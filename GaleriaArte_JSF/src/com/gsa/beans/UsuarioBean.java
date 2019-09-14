package com.gsa.beans;

import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.gsa.dao.UsuarioDAO;
import com.gsa.dao.implem.UsuarioDAOImplem;
import com.gsa.entity.Usuario;
import com.gsa.security.MD5;

@ManagedBean(name="usuarioBean")
@SessionScoped
public class UsuarioBean 
{

	@ManagedProperty("#{loginBean}")
	private LoginBean loginBean;
	
	private Usuario usuario;
	private DataModel<Usuario> listaUsuarios;
	
	
	public void limpiarUsuario()
	{
		this.usuario = new Usuario();				
	}
	
	public String prepararAgregarUsuarioAdministrador()
	{
		this.usuario = new Usuario();
		return "/administrador/NuevoUsuario.xhtml?faces-redirect=true";
	}
	
	public String registroNuevoUsuario()
	{
		UsuarioDAOImplem usuarioDao = new UsuarioDAOImplem();
		Usuario existe = usuarioDao.buscarUser(this.usuario.getUserName());
		
		if(existe == null)
		{
			String contraseña = this.generarContraseñaAleatoria();
			
			this.enviarContraseñaGmail(contraseña, this.usuario.getEmailAddress());
			
			this.usuario.setDateLastPassword( new Date() );
			this.usuario.setIntentos(0);
			this.usuario.setActive("A");
			this.usuario.setUserType("U");
			this.usuario.setPassword( MD5.getMD5( contraseña ) );
			usuarioDao.add(this.usuario);
			
			FacesContext context = FacesContext.getCurrentInstance();
		    context.getExternalContext().getFlash().setKeepMessages(true);

		    try
		    {
		    	if( !(loginBean.getUserType().equals("A") || loginBean.getUserType().equals("O")) )
		    	{
		    		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "¡Usuario Registrado!", "Tu clave ha sido enviada al correo." ));
		    		return "/index.xhtml?faces-redirect=true";
		    	}
		    }
		    catch(Exception e)
		    {
		    	context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "¡Usuario Registrado!", "Tu clave ha sido enviada al correo." ));
		    	return "/index.xhtml?faces-redirect=true";
		    }

		    context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "¡Usuario Registrado!", "La clave ha sido enviada al correo." ));
		    return "/administrador/ListaDeUsuarios.xhtml?faces-redirect=true";
		}
		
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "¡Advertencia!", "El nombre de usuario ya esta utilizado." ));
		return null;
	}

	public String prepararModificarUsuario()
	{
		this.usuario = (Usuario)( this.listaUsuarios.getRowData() );
		System.out.println("Usuario preparado: " + this.usuario.getUserName());
		return "/administrador/ActualizarUsuarios.xhtml?faces-redirect=true";
	}
	
	public String modificarUsuario()
	{
		UsuarioDAO usuarioDao = new UsuarioDAOImplem();
		
		Usuario userViejo = usuarioDao.getElemento( this.usuario.getId() ); 
		System.out.println("Usuario viejo: " + userViejo.getUserName());
		if(this.usuario.getPassword().trim() != "")
			this.usuario.setPassword( MD5.getMD5( this.usuario.getPassword() ) );
		else
			this.usuario.setPassword( userViejo.getPassword() );

		usuarioDao.update(this.usuario);		
		return "/administrador/ListaDeUsuarios.xhtml?faces-redirect=true";
	}
	
	
	public String actualizarDatosUsuario()
	{
		this.usuario.setPassword(  MD5.getMD5( this.usuario.getPassword() )  );
		UsuarioDAOImplem usuarioDao = new UsuarioDAOImplem();
		usuarioDao.update(this.usuario);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Información:", "Los datos han sido actualizados." ));
		return null;
	}
	
	public String desactivarUsuario()
	{
		Usuario usuarioActual = (Usuario)( this.listaUsuarios.getRowData() );
		UsuarioDAOImplem usuarioDao = new UsuarioDAOImplem();
		
		usuarioActual.setActive("I");
		this.enviarContraseñaGmail( " ", usuarioActual.getEmailAddress() );
		usuarioDao.update(usuarioActual);
		
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Información:", "El usuario ha sido desactivado." ));
		return null;
	}
	
	public String activarUsuario()
	{
		Usuario usuarioActual = (Usuario)( this.listaUsuarios.getRowData() );
		this.usuario = usuarioActual;
		UsuarioDAO usuarioDao = new UsuarioDAOImplem();
		
		String nuevaContraseña = this.generarContraseñaAleatoria();
		usuarioActual.setActive("A");
		usuarioActual.setIntentos(0);
		usuarioActual.setDateLastPassword( new Date() );
		usuarioActual.setPassword( MD5.getMD5( nuevaContraseña ) ); 
		
		this.enviarContraseñaGmail(nuevaContraseña, usuarioActual.getEmailAddress());
		usuarioDao.update(usuarioActual);
		
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Información:", "El usuario ha sido activado." ));
		return null;
	}
	
	public DataModel<Usuario> getAllUsuarios()
	{
		List<Usuario> listUsuarios = new UsuarioDAOImplem().getAllElementos();
		this.listaUsuarios = new ListDataModel<Usuario>(listUsuarios);
		return this.listaUsuarios;
	}

	public Usuario getUsuario() 
	{
		return usuario;
	}
	
	public int usuarioAgregar()
	{
		return ( (new UsuarioDAOImplem().getAllElementos().size()) + 1);
	}
	
	public void enviarContraseñaGmail(String pContraseña, String pEmailAddress) 
	{
		String correoGaleria = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("correoGmail");
		String clave = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("claveGmail");
		
		String asuntoCorreo = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("asuntoCorreo");
		String mensajeCorreo = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("mensajeCorreo") + pContraseña;
		
		Properties properties = System.getProperties();
	    properties.put("mail.smtp.host", "smtp.gmail.com");
	    properties.put("mail.smtp.user", correoGaleria );
	    properties.put("mail.smtp.clave", clave );   
	    properties.put("mail.smtp.auth", "true");   
	    properties.put("mail.smtp.starttls.enable", "true"); 
	    properties.put("mail.smtp.port", "587");

	    Session session = Session.getDefaultInstance(properties);
	    MimeMessage message = new MimeMessage(session);

	    try 
	    {
	        message.setFrom( new InternetAddress( String.valueOf( correoGaleria ) ) );
	        message.addRecipients(Message.RecipientType.TO, pEmailAddress);
	        message.setSubject(asuntoCorreo);
	        message.setText(mensajeCorreo);
	        Transport transport = session.getTransport("smtp");
	        transport.connect("smtp.gmail.com", correoGaleria, clave);
	        transport.sendMessage(message, message.getAllRecipients());
	        transport.close();
	    }
	    catch (MessagingException me) 
	    {
	        me.printStackTrace();
	    }
	    
	}
	
	public String generarContraseñaAleatoria()
	{
		String contraseña = "";
		char aleatorio;
		
		for (int i = 0; i < 2; i++) 
		{
			//Letra mayuscula
			aleatorio = (char)((int)((Math.random()*10)+65));
			contraseña = contraseña + aleatorio;
			
			//Letra minuscula
			aleatorio = (char)((int)((Math.random()*26)+97));
			contraseña = contraseña + aleatorio;
		}
		
		//Numero aleatorio
		aleatorio = (char)((int)((Math.random()*10)+48));
		contraseña = contraseña + aleatorio;
		
		return contraseña;
	}

	public void obtenerDatos()
	{
		String username = this.loginBean.getUserName();
		this.usuario = new UsuarioDAOImplem().buscarUser( username );
	}
	
	public String olvidoContraseña()
	{
		UsuarioDAOImplem usuarioDao = new UsuarioDAOImplem();
		Usuario existe = usuarioDao.buscarUserCorreo(this.usuario.getUserName(), this.usuario.getEmailAddress());
		
		if(existe != null)
		{
			String nuevaContraseña = this.generarContraseñaAleatoria();
			this.enviarContraseñaGmail(nuevaContraseña, existe.getEmailAddress());
			existe.setPassword( MD5.getMD5(nuevaContraseña) );
			usuarioDao.update(existe);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Información:", "Se ha enviado la nueva clave al correo." ));
			return "index.xhtml?faces-redirect=true";
		}
		
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Advertencia:", "Verifique correo y usuario." ));
		return null;
	}

	public LoginBean getLoginBean()
	{
		return loginBean;
	}

	public void setLoginBean(LoginBean loginBean)
	{
		this.loginBean = loginBean;
	}
	
	
}

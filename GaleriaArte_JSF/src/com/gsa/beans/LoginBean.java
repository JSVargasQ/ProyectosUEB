package com.gsa.beans;

import java.util.Properties;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.gsa.dao.implem.UsuarioDAOImplem;
import com.gsa.entity.Usuario;
import com.gsa.security.MD5;

@ManagedBean(name="loginBean")
@SessionScoped
public class LoginBean
{

	private static final long serialVersionUID = 1L;
	
	
	private String userName;
	private String password;
	private String userType;
	
	private Usuario datosLogueados;
	
	private boolean autenticado = false;


	public String verifica() 
	{
		UsuarioDAOImplem userDao = new UsuarioDAOImplem();
		
		Usuario existeUserName = userDao.buscarUser(userName);
		
		if( existeUserName != null )
		{
			this.password = MD5.getMD5(this.password);
			Usuario user = userDao.verificaUsuario(userName, password);
			
			if (user != null) 
			{
				if(user.getActive().equals("A"))
				{
					this.datosLogueados = user;
					this.userName = user.getUserName();
					this.userType = user.getUserType();
					this.autenticado = true;
					
					user.limpiarIntentos();
					userDao.update(user);

					return "/index.xhtml?faces-redirect=true";
				}
				else
				{
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "¡Advertencia!", "Usuario inactivo."));
					return null;
				}
			}
			else
			{
				if( !( existeUserName.getUserType().equals("O") ) )
				{
					existeUserName.intentoFallido();
					userDao.update(existeUserName);
					
					if(existeUserName.getIntentos() == 3 )
						this.enviarCorreo( existeUserName.getEmailAddress() );
				}
			}
			
		}

		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Atención", "Usuario y/o contraseña incorrecta."));
		return null;

	}
	
	public String retornarInicio()
	{
		return "/index.xhtml?faces-redirect=true";
    }
	
	public void cerrarSesion()
	{
		this.autenticado = false;
		this.userName = null;
		this.password = null;
		this.userType = null;
		this.datosLogueados = null;
	}
	
	public void enviarCorreo(String pEmailAddress) 
	{
		String correoGaleria = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("correoGmail");
		String clave = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("claveGmail");
		
		String asuntoCorreo = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("asuntoCorreo");
		String mensajeCorreo = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("mensajeCorreo");
		
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

	public boolean getAutenticado() {
		return autenticado;
	}

	public void setAutenticado(boolean autenticado) {
		this.autenticado = autenticado;
	}

	public String getUserName() {
		System.out.println("LoginBean- getUserName(): " + userName);
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public Usuario getDatosLogueados() {
		return datosLogueados;
	}

	public void setDatosLogueados(Usuario datosLogueados) {
		this.datosLogueados = datosLogueados;
	}	
	
	
}
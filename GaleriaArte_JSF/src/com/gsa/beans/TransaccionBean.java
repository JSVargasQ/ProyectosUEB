package com.gsa.beans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import com.gsa.dao.ElementoDAO;
import com.gsa.dao.implem.ProductoDAOImplem;
import com.gsa.dao.implem.TransaccionDAOImplem;
import com.gsa.entity.Transaccion;

@ManagedBean(name="transaccionBean")
@SessionScoped
public class TransaccionBean 
{

	private Transaccion transaccion;
	private DataModel<Transaccion> listaTransacciones
	;
	private int mesTarjeta;
	private int añoTarjeta;
	
	@ManagedProperty("#{auditoriaBean}")
	private AuditoriaBean auditoriaBean;
	
	@ManagedProperty("#{loginBean}")
	private LoginBean loginBean;
	
	public String prepararAgregarTransacciones()
	{
		this.transaccion = new Transaccion();
		return "Transaccion.xhtml?faces-redirect=true";
	}
	
	public String agregarTransaccion()
	{
		String idComprador = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idComprador");
		String idProducto = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idProducto");
		String valorTransaccion = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("valorTransaccion");		
		
		FacesContext context = FacesContext.getCurrentInstance();
	    context.getExternalContext().getFlash().setKeepMessages(true);
		
		int mesActual = new Date().getMonth() + 1;
		int añoActual = new Date().getYear() + 1900;

		if( this.mesTarjeta <= mesActual && añoTarjeta == añoActual )
		{
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Mes inválido", "Verifiqué el mes." ));
			return null;
		}
		
		ElementoDAO<Transaccion> transaccionDao = new TransaccionDAOImplem();
		transaccion.setActivo("A");
		transaccion.setFechaTransaccion(new Date());
		transaccion.setIdComprador( Long.parseLong( idComprador ) );
		transaccion.setIdProducto(  Long.parseLong( idProducto ) );
		transaccion.setValorTransaccion( valorTransaccion );
		
		transaccionDao.add(this.transaccion);
		auditoriaBean.agregarAuditoria();
		
		ProductoDAOImplem productoDao = new ProductoDAOImplem();
		productoDao.obraVendida( Long.parseLong( idProducto ) );
		
		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "¡Obra comprada!", "La obra ha sido comprada con exito." ));
		return "/index.xhtml?faces-redirect=true";
	}
	
	public String eliminarTransaccion()
	{
		Transaccion transaccionActual = (Transaccion)( this.listaTransacciones.getRowData() );
		ElementoDAO<Transaccion> transaccionDao = new TransaccionDAOImplem();

		System.out.println(transaccionActual.getActivo());
		if( transaccionActual.getActivo().equals("A") )
			transaccionActual.setActivo("I");
		else
			transaccionActual.setActivo("A");
		
		System.out.println(transaccionActual.getActivo());
		transaccionDao.update(transaccionActual);
		return null;
	}
	
	public DataModel<Transaccion> getAllTransacciones()
	{
		List<Transaccion> listaTransaccions = new TransaccionDAOImplem().getAllElementos();
		this.listaTransacciones = new ListDataModel<Transaccion>(listaTransaccions);
		return this.listaTransacciones;
	}
	
	public DataModel<Transaccion> getAllTransaccionesUsuario()
	{
		List<Transaccion> listaTransaccions = new TransaccionDAOImplem().getAllElementos();

		Object[] array = listaTransaccions.toArray();
		
		listaTransaccions.clear();
		
		for (int i = 0; i < array.length; i++) 
		{
			Transaccion actual = (Transaccion) array[i];
			
			if(actual.getIdComprador() == loginBean.getDatosLogueados().getId())
				listaTransaccions.add(actual);
		}
		
		this.listaTransacciones = new ListDataModel<Transaccion>(listaTransaccions);
		return this.listaTransacciones;
	}
	
	public DataModel<Transaccion> getTransaccionesMes(int pMes)
	{
		List<Transaccion> listaTransaccions = new TransaccionDAOImplem().getAllElementos();
		Object[] exposiciones = listaTransaccions.toArray();
		listaTransaccions.clear();
		
		for (int i = 0; i < exposiciones.length; i++) 
		{
			Transaccion actual = (Transaccion) exposiciones[i];
			if( actual.getFechaTransaccion().getMonth() == pMes)
				listaTransaccions.add(actual); 
		}
		
		this.listaTransacciones = new ListDataModel<Transaccion>(listaTransaccions);
		return this.listaTransacciones;
			
	}
	
	public List<Integer> darAñosTarjeta()
	{
		List<Integer> años = new ArrayList<Integer>();
		int añoActual = new Date().getYear() + 1900;
		
		años.add(añoActual);
		
		for (int i = 0; i < 14; i++)
		{
			añoActual = (añoActual + 1);
			años.add(añoActual);
		}
		
		return años;
	}

	public Transaccion getTransaccion() 
	{
		return transaccion;
	}

	public void setTransaccion(Transaccion transaccion) 
	{
		this.transaccion = transaccion;
	}

	public DataModel<Transaccion> getListaTransacciones() 
	{
		return listaTransacciones;
	}

	public void setListaTransacciones(DataModel<Transaccion> listaTransacciones) 
	{
		this.listaTransacciones = listaTransacciones;
	}

	public int getMesTarjeta() 
	{
		return mesTarjeta;
	}

	public void setMesTarjeta(int mesTarjeta) 
	{
		this.mesTarjeta = mesTarjeta;
	}

	public int getAñoTarjeta()
	{
		return añoTarjeta;
	}

	public void setAñoTarjeta(int añoTarjeta) 
	{
		this.añoTarjeta = añoTarjeta;
	}

	public AuditoriaBean getAuditoriaBean() 
	{
		return auditoriaBean;
	}

	public void setAuditoriaBean(AuditoriaBean auditoriaBean) 
	{
		this.auditoriaBean = auditoriaBean;
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

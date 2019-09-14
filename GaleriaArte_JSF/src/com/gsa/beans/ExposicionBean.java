package com.gsa.beans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import com.gsa.dao.ElementoDAO;
import com.gsa.dao.implem.ExposicionDAOImplem;
import com.gsa.dao.implem.ProductoDAOImplem;
import com.gsa.entity.Exposicion;


@ManagedBean
@SessionScoped
public class ExposicionBean 
{

	private static final long serialVersionUID = 1L;
	
	
	private Exposicion exposicion;
	private DataModel<Exposicion> listaExposiciones;
	
	
	public String prepararAgregarExposicion()
	{
		this.exposicion = new Exposicion();
		this.exposicion.setActivo("A");
		return "RegistroExposicion.xhtml?faces-redirect=true";
	}
	
	public String agregarExposicion()
	{
		ElementoDAO<Exposicion> exposicionDao = new ExposicionDAOImplem();
		this.exposicion.setIdObras(" ");
		exposicionDao.add(this.exposicion);
		return "ListaDeExposiciones.xhtml?faces-redirect=true";
	}
	
	public String prepararModificarExposicion()
	{
		this.exposicion = (Exposicion)( this.listaExposiciones.getRowData() );
		return "RegistroExposicion.xhtml?faces-redirect=true";
	}
	
	public String modificarExposicion()
	{
		ElementoDAO<Exposicion> ExposicionDao = new ExposicionDAOImplem();
		ExposicionDao.update(this.exposicion);
		return "ListaDeExposiciones.xhtml?faces-redirect=true";
	}
	
	public String eliminarExposicion() 
	{
		Exposicion exposicionActual = this.listaExposiciones.getRowData();
		ElementoDAO<Exposicion> exposicionDao = new ExposicionDAOImplem();
		
		if(exposicionActual.getActivo().equals("A"))
			exposicionActual.setActivo("I");
		else
			exposicionActual.setActivo("A");
		
		exposicionDao.update(exposicionActual);
		return null;
	}
	
	public DataModel<Exposicion> getAllExposiciones()
	{
		List<Exposicion> listaExposiciones = new ExposicionDAOImplem().getAllElementos();
		this.listaExposiciones = new ListDataModel<Exposicion>(listaExposiciones);
		return this.listaExposiciones;
	}
	
	public DataModel<Exposicion> getAllExposicionesActivas()
	{		
		List<Exposicion> listaExposiciones = new ExposicionDAOImplem().getAllElementos();
		Object[] allExposiciones = listaExposiciones.toArray();
		listaExposiciones.clear();
		
		for (int i = 0; i < allExposiciones.length; i++) 
		{
			Exposicion actual = (Exposicion)(allExposiciones[i]);
			if( actual.getActivo().equals("A"))
				listaExposiciones.add(actual);
		}
		
		this.listaExposiciones = new ListDataModel<Exposicion>(listaExposiciones);
		return this.listaExposiciones;
	}

	public Exposicion getExposicion() 
	{
		return exposicion;
	}

	public void setExposicion(Exposicion exposicion) 
	{
		this.exposicion = exposicion;
	}
	
	public String mostrarExposicion()
	{
		this.exposicion = (Exposicion)( this.listaExposiciones.getRowData() );
		return "ObraAdministrador.xhtml?faces-redirect=true";
	}
	
	public int numExpoAgregar()
	{
		return ( (new ExposicionDAOImplem().getAllElementos().size()) + 1);
	}	
	
	
	

}

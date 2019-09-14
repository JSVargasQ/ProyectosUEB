package com.gsa.beans;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import com.gsa.dao.ElementoDAO;
import com.gsa.dao.implem.AuditoriaDAOImplem;
import com.gsa.entity.Auditoria;

@ManagedBean(name="auditoriaBean")
@SessionScoped
public class AuditoriaBean 
{

	private Auditoria auditoria;
	private DataModel<Auditoria> listaAuditoria;
	
	
	public void agregarAuditoria()
	{
		System.out.println("Agregando Auditoria");
		int id = Integer.valueOf(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idUsuario"));
		String operationCrud = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("operationCrud");		
		String tableName = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("tableName");
		int idModificado = Integer.valueOf(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idModif"));
		
		ElementoDAO<Auditoria> auditoriaDao = new AuditoriaDAOImplem();
		Auditoria nueva = new Auditoria();
		nueva.setUserId(id);
		nueva.setOperationCrud(operationCrud);
		nueva.setTableName(tableName);
		nueva.setTableId(idModificado);
		nueva.setCreateDate( new Date() );
		try 
		{
			nueva.setAddressIP( String.valueOf( InetAddress.getLocalHost().getHostAddress() ) );
		}
		catch (UnknownHostException e) 
		{

		}
		auditoriaDao.add(nueva);
		System.out.println("Auditoria guardada");
	}
	
	public DataModel<Auditoria> getAllAuditorias()
	{
		List<Auditoria> listAuditoria = new AuditoriaDAOImplem().getAllElementos();
		this.listaAuditoria = new ListDataModel<Auditoria>(listAuditoria);
		return this.listaAuditoria;
	}
	
}

package com.gsa.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "exposicion")
public class Exposicion implements java.io.Serializable
{
	
	private static final long serialVersionUID = -243246535829966740L;


	private Long id;
	private String descripcion;
	private String tipoExposicion;
	private Date fechaInicial;
	private Date fechaFinal;
	private String activo;
	private String idObras;
	
	
	public Exposicion()
	{
		
	}
	
	public Exposicion(Long pId)
	{
		this.id = pId; 
	}

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	@Column(name = "descripcion", length = 200)
	public String getDescripcion() 
	{
		return descripcion;
	}

	public void setDescripcion(String descripcion)
	{
		this.descripcion = descripcion;
	}

	@Column(name = "tipoExposicion", length = 100)
	public String getTipoExposicion()
	{
		return tipoExposicion;
	}

	public void setTipoExposicion(String tipoExposicion) 
	{
		this.tipoExposicion = tipoExposicion;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fechaInicial", length = 19)
	public Date getFechaInicial() 
	{
		return fechaInicial;
	}

	public void setFechaInicial(Date fechaInicial) 
	{
		this.fechaInicial = fechaInicial;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fechaFinal", length = 19)
	public Date getFechaFinal() 
	{
		return fechaFinal;
	}

	public void setFechaFinal(Date fechaFinal) 
	{
		this.fechaFinal = fechaFinal;
	}

	@Column(name = "activo", length = 1)
	public String getActivo() 
	{
		return activo;
	}

	public void setActivo(String activo) 
	{
		this.activo = activo;
	}

	@Column(name = "idObras", length = 120)
	public String getIdObras() 
	{
		return idObras;
	}

	public void setIdObras(String idObras) 
	{
		this.idObras = idObras;
	}
	
	
	
	
}

package com.gsa.entity;

import java.util.Date;

import javax.faces.bean.SessionScoped;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "transaccion")
public class Transaccion implements java.io.Serializable
{


	private static final long serialVersionUID = 1612661203240438496L;
	
	
	private Long id;
	private Long idComprador;
	private Date fechaTransaccion;
	private Long idProducto;
	private String valorTransaccion;
	private String activo;
	private String direccionEnvio;
	
	
	public Transaccion()
	{
		
	}
	
	public Transaccion(Long pId)
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

	@Column(name = "idComprador", length = 3)
	public Long getIdComprador() 
	{
		return idComprador;
	}

	public void setIdComprador(Long idComprador) 
	{
		this.idComprador = idComprador;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fechaTransaccion", length = 19)
	public Date getFechaTransaccion() 
	{
		return fechaTransaccion;
	}

	public void setFechaTransaccion(Date fechaTransaccion)
	{
		this.fechaTransaccion = fechaTransaccion;
	}

	@Column(name = "idProducto", length = 3)
	public Long getIdProducto() 
	{
		return idProducto;
	}

	public void setIdProducto(Long idProducto) 
	{
		this.idProducto = idProducto;
	}

	@Column(name = "valorTransaccion", length = 10)
	public String getValorTransaccion() 
	{
		return valorTransaccion;
	}

	public void setValorTransaccion(String valorTransaccion) 
	{
		this.valorTransaccion = valorTransaccion;
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
	
	@Column(name = "direccionEnvio", length = 120)
	public String getDireccionEnvio() 
	{
		return direccionEnvio;
	}

	public void setDireccionEnvio(String direccionEnvio) 
	{
		this.direccionEnvio = direccionEnvio;
	}

	
	
	
}

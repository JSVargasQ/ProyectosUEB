package com.gsa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "producto")
public class Producto implements java.io.Serializable
{


	private static final long serialVersionUID = 7816236470653618230L;
	
	private Long id;
	private String nombre;
	private String descripcion;
	private String autor;
	private String rutaFoto;
	private String valorProducto;
	private String activo;
	
	public Producto()
	{
		
	}
	
	public Producto(Long pId)
	{
		this.id = pId;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false, unique = true)
	public Long getId() 
	{
		return id;
	}
	
	public void setId(Long id) 
	{
		this.id = id;
	}
	
	@Column(name = "nombre", length = 75)
	public String getNombre() 
	{
		return nombre;
	}
	
	public void setNombre(String nombre) 
	{
		this.nombre = nombre;
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
	
	@Column(name = "autor", length = 75)
	public String getAutor() 
	{
		return autor;
	}
	
	public void setAutor(String autor) 
	{
		this.autor = autor;
	}
	
	@Column(name = "rutaFoto", length = 75)
	public String getRutaFoto()
	{
		return rutaFoto;
	}
	
	public void setRutaFoto(String rutaFoto) 
	{
		this.rutaFoto = rutaFoto;
	}
	
	@Column(name = "valorProducto", length = 20)
	public String getValorProducto() 
	{
		return valorProducto;
	}
	
	public void setValorProducto(String valorProducto) 
	{
		this.valorProducto = valorProducto;
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
	
}

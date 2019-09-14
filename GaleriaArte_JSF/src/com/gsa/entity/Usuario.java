package com.gsa.entity;

import java.text.SimpleDateFormat;
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
@Table(name = "user")
public class Usuario implements java.io.Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8867032511204738572L;
	
	private Long id;
	private String userName;
	private String password;
	private String fullName;
	private String emailAddress;
	private String phoneNumber;
	private Date dateLastPassword;
	private String active; 
	private Integer intentos;
	private String userType;
	
	
	public Usuario()
	{
		
	}
	
	public Usuario(Long pId)
	{
		this.id = pId;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", unique = true, nullable = false)
	public Long getId() 
	{
		return id;
	}
	
	public void setId(Long id)
	{
		this.id = id;
	}
	
	@Column(name = "userName", length = 8)
	public String getUserName() 
	{
		return userName;
	}

	public void setUserName(String userName)
	{
		this.userName = userName;
	}
	
	@Column(name = "password", length = 32)
	public String getPassword() 
	{
		return password;
	}

	public void setPassword(String password) 
	{
		this.password = password;
	}

	@Column(name = "fullName", length = 60)
	public String getFullName() 
	{
		return fullName;
	}

	public void setFullName(String fullName) 
	{
		this.fullName = fullName;
	}

	@Column(name = "emailAddress", length = 75)
	public String getEmailAddress() 
	{
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) 
	{
		this.emailAddress = emailAddress;
	}

	@Column(name = "phoneNumber", length = 10)
	public String getPhoneNumber() 
	{
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber)
	{
		this.phoneNumber = phoneNumber;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dateLastPassword", length = 19)
	public Date getDateLastPassword() 
	{
		return dateLastPassword;
	}

	public void setDateLastPassword(Date dateLastPassword) 
	{
		this.dateLastPassword = dateLastPassword;
	}

	@Column(name = "active", length = 1)
	public String getActive()
	{
		return active;
	}

	public void setActive(String active) 
	{
		this.active = active;
	}

	@Column(name = "intentos", length = 2)
	public Integer getIntentos()
	{
		return intentos;
	}

	public void setIntentos(Integer intentos)
	{
		this.intentos = intentos;
	}

	@Column(name = "userType", length = 1)
	public String getUserType() 
	{
		return userType;
	}

	public void setUserType(String userType)
	{
		this.userType = userType;
	}
	
	public String fechaFiltrada()
	{
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
		String fechaTexto = formatter.format(this.dateLastPassword);
		return fechaTexto;
	}
	
	public void intentoFallido()
	{
		this.intentos = this.intentos + 1;
		this.verificarBloqueo();
	}
	
	private void verificarBloqueo()
	{
		if(this.intentos >= 3)
			this.active = "I";
	}
	
	public void limpiarIntentos()
	{
		this.intentos = 0;
	}
	
	
}

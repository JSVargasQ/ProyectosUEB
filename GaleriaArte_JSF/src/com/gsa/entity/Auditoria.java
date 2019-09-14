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
@Table(name = "audit")
public class Auditoria implements java.io.Serializable
{


	private static final long serialVersionUID = 5621735115915467379L;
	
	private Long id; //Id operacion
	private Integer userId; //Usuario ejecuto accion
	private String operationCrud; //Operacion realizada
	private String tableName; //Tabla modificada
	private Integer tableId; //Id modificado en la tabla
	private Date createDate; //Fecha y hora
	private String addressIP; //IP
	
	
	public Auditoria()
	{
		
	}
	
	public Auditoria(Long pId)
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

	@Column(name = "userId", nullable = false, length = 5)
	public Integer getUserId() 
	{
		return userId;
	}

	public void setUserId(Integer userId) 
	{
		this.userId = userId;
	}

	@Column(name = "operationCrud", length = 1)
	public String getOperationCrud() 
	{
		return operationCrud;
	}

	public void setOperationCrud(String operationCrud) 
	{
		this.operationCrud = operationCrud;
	}

	@Column(name = "tableName", length = 30)
	public String getTableName() 
	{
		return tableName;
	}

	public void setTableName(String tableName) 
	{
		this.tableName = tableName;
	}

	@Column(name = "tableId", length = 20)
	public Integer getTableId() 
	{
		return tableId;
	}

	public void setTableId(Integer tableId) 
	{
		this.tableId = tableId;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "createDate", length = 19)
	public Date getCreateDate() 
	{
		return createDate;
	}

	public void setCreateDate(Date createDate) 
	{
		this.createDate = createDate;
	}

	@Column(name = "addressIP", length = 15)
	public String getAddressIP() 
	{
		return addressIP;
	}

	public void setAddressIP(String addressIP) 
	{
		this.addressIP = addressIP;
	}	
	
}

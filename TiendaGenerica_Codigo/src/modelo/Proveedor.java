package modelo;

public class Proveedor extends Persona
{

	private int nit;
	private String ciudad;
	private String tipoProveedor;
	
	
	
	public Proveedor()
	{
		this.nit = -1;
		this.ciudad = "";
		this.tipoProveedor = "";
	}
	
	
	public int getNit() 
	{
		return nit;
	}

	public String getCiudad()
	{
		return ciudad;
	}
	
	public void setNit(int pNit) 
	{
		this.nit = pNit;
	}

	public void setCiudad(String pCiudad) 
	{
		this.ciudad = pCiudad;
	}


	public String getTipoProveedor() 
	{
		return tipoProveedor;
	}

	public void setTipoProveedor(String pTipoPorveedor) 
	{
		this.tipoProveedor = pTipoPorveedor;
	}
	
	
}

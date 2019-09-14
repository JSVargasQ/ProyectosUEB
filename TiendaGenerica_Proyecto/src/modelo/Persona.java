package modelo;

public abstract class Persona 
{

	private String nombre;
	private String direccion;
	private int telefono;
	
	
	
	public Persona()
	{
		this.nombre = "";
		this.direccion = "";
		this.telefono = -1;
	}



	public String getNombre() 
	{
		return nombre;
	}

	public void setNombre(String pNombre) 
	{
		this.nombre = pNombre;
	}


	public String getDireccion() 
	{
		return direccion;
	}

	public void setDireccion(String pDireccion) 
	{
		this.direccion = pDireccion;
	}

	public int getTelefono() 
	{
		return telefono;
	}

	public void setTelefono(int pTelefono) 
	{
		this.telefono = pTelefono;
	}
	
}

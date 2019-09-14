package modelo;

public class Cliente extends Persona
{

	private int cedula;
	private String genero;
	private String correoElectronico;
	
	public Cliente()
	{
		this.cedula = -1;
		this.correoElectronico = "";
		
	}

	public int getCedula() 
	{
		return cedula;
	}

	public String getCorreoElectronico()
	{
		return correoElectronico;
	}
	
	public String getGenero()
	{
		return genero;
	}
	
	public void setCedula(int pCedula) 
	{
		this.cedula = pCedula;
	}

	public void setCorreoElectronico(String pCorreoElectronico)
	{
		this.correoElectronico = pCorreoElectronico;
	}

	public void setGenero(String pGenero)
	{
		this.genero = pGenero;
	}
	
	
		
}

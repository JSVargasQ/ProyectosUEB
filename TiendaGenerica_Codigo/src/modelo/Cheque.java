package modelo;

public class Cheque 
{

	private int consecutivoCheque;
	private double valorCifra;
	private String valorMontoEscrito;
	private String nombre;
	private String nombreProveedor;
	private String nombreBanco;
	private int numeroCuenta;
	
	public Cheque()
	{
		this.consecutivoCheque = -1;
		this.valorCifra = -1.0;
		this.valorMontoEscrito = "";
		this.nombre = "";
		this.nombreProveedor = "";
		this.nombreBanco = "";
		this.numeroCuenta = -1;	
	}

	public int getConsecutivoCheque() 
	{
		return consecutivoCheque;
	}

	public void setConsecutivoCheque(int pConsecutivoCheque) 
	{
		this.consecutivoCheque = pConsecutivoCheque;
	}

	public double getValorCifra() 
	{
		return valorCifra;
	}

	public void setValorCifra(double pValorCifra)
	{
		this.valorCifra = pValorCifra;
	}

	public String getValorMontoEscrito() 
	{
		return valorMontoEscrito;
	}

	public void setValorMontoEscrito(String pValorMontoEscrito) 
	{
		this.valorMontoEscrito = pValorMontoEscrito;
	}

	public String getNombre()
	{
		return nombre;
	}

	public void setNombre(String pNombre) 
	{
		this.nombre = pNombre;
	}

	public String getNombreProveedor() 
	{
		return nombreProveedor;
	}

	public void setNombreProveedor(String pNombreProveedor) 
	{
		this.nombreProveedor = pNombreProveedor;
	}

	public String getNombreBanco()
	{
		return nombreBanco;
	}

	public void setNombreBanco(String pNombreBanco) 
	{
		this.nombreBanco = pNombreBanco;
	}

	public int getNumeroCuenta() 
	{
		return numeroCuenta;
	}

	public void setNumeroCuenta(int pNumeroCuenta) 
	{
		this.numeroCuenta = pNumeroCuenta;
	}
	
		
	
	
	
}

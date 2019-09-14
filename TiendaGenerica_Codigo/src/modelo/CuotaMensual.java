package modelo;

public class CuotaMensual 
{
	
	private int numeroCuota;
	private double saldo;
	private double cuota;
	private double interes;
	private double amortizacion;
	
	
	
	public CuotaMensual()
	{
		this.numeroCuota = 0;
		this.saldo = 0;
		this.cuota = 0;
		this.interes = 0;
		this.amortizacion = 0;
	}



	public int getNumeroCuota() 
	{
		return numeroCuota;
	}

	public void setNumeroCuota(int pNumeroCuota) 
	{
		this.numeroCuota = pNumeroCuota;
	}

	public double getSaldo() 
	{
		return saldo;
	}

	public void setSaldo(double pSaldo) 
	{
		this.saldo = pSaldo;
	}

	public double getCuota() 
	{
		return cuota;
	}

	public void setCuota(double pCuota) 
	{
		this.cuota = pCuota;
	}

	public double getInteres()
	{
		return interes;
	}

	public void setInteres(double pInteres)
	{
		this.interes = pInteres;
	}

	public double getAmortizacion()
	{
		return amortizacion;
	}

	public void setAmortizacion(double pAmortizacion) 
	{
		this.amortizacion = pAmortizacion;
	}

	
}

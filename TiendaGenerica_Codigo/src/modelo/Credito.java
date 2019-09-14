package modelo;

import java.text.DecimalFormat;

public class Credito 
{
	
	//Ingresa por parametro
	private double monto;
	private int cuotas;
	
	//Valores predeterminados y calculados
	private double interes;
	private double tasaEfectiva;
	private double valorAnualidad;
	
	private CuotaMensual[] tablaAmortizacion;	
	
	
	
	public Credito()
	{		
		this.cuotas = -1;
		this.interes = -1;
		this.monto = -1;
		this.tasaEfectiva = -1;
		this.valorAnualidad = -1;
	}
	
	
	
	private double calcularTasaEfectiva()
	{
		double tasaEfectiva = 0;
		
		double parte1 = ((double)(this.interes/100)) + 1.0 ;
		double elevado = 1.0/12.0;
		tasaEfectiva = (Math.pow(parte1, elevado)) - 1;
		
		return tasaEfectiva;
	}
	
	private double calcularValorAnualidad()
	{
		double valorAnualidad = 0;
		
		valorAnualidad = (double)(1 - Math.pow((this.tasaEfectiva + 1.0) , (-this.cuotas))) / this.tasaEfectiva;
		
		return valorAnualidad;
	}
	
	private double calcularValorCuota()
	{
		double valorCuota = 0;
		
		valorCuota = (double)this.monto/this.valorAnualidad;
		
		return valorCuota;
	}
	
	public void calcularValoresPredeterminados()
	{
		this.tasaEfectiva = calcularTasaEfectiva();
		this.valorAnualidad = calcularValorAnualidad();
	
		inicializarTabla();
	}
	
	private void inicializarTabla()
	{
		int cantCuotas = this.cuotas+1;
		tablaAmortizacion = new CuotaMensual[cantCuotas];
		
		for (int i = 0; i < cantCuotas; i++)
		{
			tablaAmortizacion[i] = new CuotaMensual();
		}
	}
		
	public void asignarValoresTabla()
	{	
		double monto = this.monto;
		double montoCuota = calcularValorCuota();
		tablaAmortizacion[0].setSaldo(monto);
		
		for (int i = 1; i < tablaAmortizacion.length; i++)
		{
			double interes = monto * this.tasaEfectiva;
			double amortizacion = montoCuota - interes;
			monto = monto - amortizacion;
			tablaAmortizacion[i].setNumeroCuota(i);
			tablaAmortizacion[i].setSaldo(monto);
			tablaAmortizacion[i].setCuota(montoCuota);
			tablaAmortizacion[i].setInteres(interes);
			tablaAmortizacion[i].setAmortizacion(amortizacion);
		}
	}

	public int getCuotas() 
	{
		return cuotas;
	}

	public double getInteres() 
	{
		return interes;
	}

	public double getMonto() 
	{
		return monto;
	}

	public double getTasaEfectiva()
	{
		return tasaEfectiva;
	}

	public double getValorAnualidad() 
	{
		return valorAnualidad;
	}

	public CuotaMensual[] getTablaAmortizacion() 
	{
		return tablaAmortizacion;
	}

	public void setCuotas(int cuotas)
	{
		this.cuotas = cuotas;
	}

	public void setInteres(double interes) 
	{
		this.interes = interes;
	}

	public void setMonto(double monto) 
	{
		this.monto = monto;
	}
	
	private String completarEspacio(int pEspacio, String pDato)
	{
		String dato = pDato;
		
		while(dato.length() < pEspacio)
		{
			dato+= " ";
		}
		
		return dato;
	}
	
	private String realizarFila(int pNumeroFila)
	{
		String fila = "";
		DecimalFormat df = new DecimalFormat("#,###,###");
		
		CuotaMensual actual = tablaAmortizacion[pNumeroFila];
		fila+= completarEspacio(10, String.valueOf(actual.getNumeroCuota()));
		fila+= completarEspacio(20, String.format(df.format(actual.getSaldo())));
		fila+= completarEspacio(15, String.format(df.format(actual.getCuota())));
		fila+= completarEspacio(15, df.format(actual.getInteres())); 
		fila+= completarEspacio(13, df.format(actual.getAmortizacion()));
		
		return fila;
	}

	private String[] getTablaDeAmortizacionCompleta()
	{
		String[] tabAmortizacion = new String[(this.cuotas+2)];
		int numeroFilaActual = 0;

		tabAmortizacion[0] = completarEspacio(10, "N Cuota") + completarEspacio(20, "Saldo") + completarEspacio(15, "Cuota") + completarEspacio(15, "Intereses") + completarEspacio(13, "Amortizacion");
		
		for (int i = 1; i < tabAmortizacion.length; i++) 
		{
			tabAmortizacion[i] = realizarFila(numeroFilaActual);
			numeroFilaActual++;
		}
				
		return tabAmortizacion;
	}
	
	public String[] calcularTablaAmortizacion(int pNumeroCuotas, double pMonto)
	{
		this.setCuotas(pNumeroCuotas);
		this.setMonto(pMonto);
		this.calcularValoresPredeterminados();
		this.asignarValoresTabla();
		
		return getTablaDeAmortizacionCompleta();
	}

	
}

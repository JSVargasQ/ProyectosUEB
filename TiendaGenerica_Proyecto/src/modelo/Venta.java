package modelo;

import java.util.ArrayList;

public class Venta 
{
	
	private ArrayList<DetalleVenta> detallesVentas;	
	private int codigoUltimaVenta;

	private Credito credito;	
	
	public Venta()
	{
		this.credito = new Credito();
		
		this.detallesVentas = new ArrayList<>();
		this.codigoUltimaVenta = -1;
	}
	
	public ArrayList<DetalleVenta> getDetallesVentas() 
	{
		return detallesVentas;
	}

	public void setDetallesVentas(ArrayList<DetalleVenta> pDetallesVentas)
	{
		this.detallesVentas = pDetallesVentas;
	}

	public int getCodigoUltimaVenta()
	{
		return codigoUltimaVenta;
	}

	public void setCodigoUltimaVenta(int pCodigoUltimaVenta) 
	{
		this.codigoUltimaVenta = pCodigoUltimaVenta;
	}

	public Credito getCredito() 
	{
		return credito;
	}

	public void setCredito(Credito pCredito) 
	{
		this.credito = pCredito;
	}

	public String[] calcularCredito(int pNumCuotas, double pMonto)
	{
		return this.credito.calcularTablaAmortizacion(pNumCuotas, pMonto);
	}
	
	
	
}

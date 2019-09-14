package modelo;

import java.util.ArrayList;

public class DetalleVenta 
{

	private int codigoDetalleVenta;
	private int cedulaClienteVenta;
	private ArrayList<Integer> codigoProducto;
	private ArrayList<Integer> cantidadProducto;
	private ArrayList<Double> valorVentaProducto;
	private double valorTotal;
	private double valorIVA;
	private double valorMasIVA;
	
	
	
	public DetalleVenta()
	{
		this.codigoDetalleVenta = -1;
		this.codigoProducto = new ArrayList<>();
		this.cantidadProducto = new ArrayList<>();
		this.valorVentaProducto = new ArrayList<>();
		this.valorTotal = -0.999;
	}

	public void calcularValorTotal()
	{
		this.valorTotal = 0;
		
		for (int i = 0; i < codigoProducto.size(); i++) 
		{
			this.valorTotal+= this.valorVentaProducto.get(i) * (double) this.cantidadProducto.get(i);
		}
	}
	
	public void calcularValoresIVA(double pIva)
	{	
		double iva = (double)(pIva / 100.0);
		this.valorIVA = this.valorTotal * iva;
		this.valorMasIVA = this.valorTotal + this.valorIVA;
	}
	
	public int getCodigoDetalleVenta() 
	{
		return codigoDetalleVenta;
	}

	public void setCodigoDetalleVenta(int pCodigoDetalleVenta) 
	{
		this.codigoDetalleVenta = pCodigoDetalleVenta;
	}

	public ArrayList<Integer> getCodigoProducto() 
	{
		return codigoProducto;
	}

	public void setCodigoProducto(ArrayList<Integer> pCodigoProducto) 
	{
		this.codigoProducto = pCodigoProducto;
	}

	public ArrayList<Integer> getCantidadProducto() 
	{
		return cantidadProducto;
	}

	public void setCantidadProducto(ArrayList<Integer> pCantidadProducto) 
	{
		this.cantidadProducto = pCantidadProducto;
	}

	public ArrayList<Double> getValorVentaProducto() 
	{
		return valorVentaProducto;
	}

	public void setValorVentaProducto(ArrayList<Double> pValorVentaProducto) 
	{
		this.valorVentaProducto = pValorVentaProducto;
	}

	public double getValorTotal() 
	{
		return valorTotal;
	}

	public void setValorTotal(double pValorTotal) 
	{
		this.valorTotal = pValorTotal;
	}

	public int getCedulaClienteVenta() 
	{
		return cedulaClienteVenta;
	}
	
	public void setCedulaClienteVenta(int pCedulaClienteVenta) 
	{
		this.cedulaClienteVenta = pCedulaClienteVenta;
	}
	
	public double getValorIVA()
	{
		return valorIVA;
	}

	public void setValorIVA(double pValorIVA) 
	{
		this.valorIVA = pValorIVA;
	}

	public double getValorMasIVA() 
	{
		return valorMasIVA;
	}

	public void setValorMasIVA(double pValorMasIVA) 
	{
		this.valorMasIVA = pValorMasIVA;
	}

	

	
	
	

}

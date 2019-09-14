package modelo;

import java.util.ArrayList;

public class DetalleCompra 
{
	
	private int codigoDetalleCompra;
	private int nitProveedorCompra;
	private ArrayList<Integer> codigoProducto;
	private ArrayList<Integer> cantidadProducto;
	private ArrayList<Double> valorCompraProducto;
	private double valorTotal;
	private double valorIVA;
	private double valorMasIVA;
	
	
	public DetalleCompra()
	{
		this.codigoDetalleCompra = -1;
		this.nitProveedorCompra = -1;
		this.codigoProducto = new ArrayList<>();
		this.cantidadProducto = new ArrayList<>();
		this.valorCompraProducto = new ArrayList<>();
		this.valorTotal = -1.0;
		this.valorIVA = -1.0;
		this.valorMasIVA = -1.0;
	}

	public void calcularValorTotal()
	{
		this.valorTotal = 0;
		
		for (int i = 0; i < codigoProducto.size(); i++) 
		{
			this.valorTotal+= this.valorCompraProducto.get(i) * (double) this.cantidadProducto.get(i);
		}
	}
	
	public void calcularValoresIVA(double pIva)
	{	
		double iva = (double)(pIva / 100.0);
		this.valorIVA = this.valorTotal * iva;
		this.valorMasIVA = this.valorTotal + this.valorIVA;
	}
	
	public int getCodigoDetalleCompra() 
	{
		return codigoDetalleCompra;
	}

	public void setCodigoDetalleCompra(int pCodigoDetalleCompra) 
	{
		this.codigoDetalleCompra = pCodigoDetalleCompra;
	}

	public int getNitProveedorCompra() 
	{
		return nitProveedorCompra;
	}

	public void setNitProveedorCompra(int nitProveedorCompra) 
	{
		this.nitProveedorCompra = nitProveedorCompra;
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

	public ArrayList<Double> getValorCompraProducto()
	{
		return valorCompraProducto;
	}

	public void setValorCompraProducto(ArrayList<Double> pValorCompraProducto)
	{
		this.valorCompraProducto = pValorCompraProducto;
	}

	public double getValorTotal() 
	{
		return valorTotal;
	}

	public double getValorIVA()
	{
		return valorIVA;
	}

	public double getValorMasIVA() 
	{
		return valorMasIVA;
	}

	
	
	
	
	

	
	
	
	
	

}

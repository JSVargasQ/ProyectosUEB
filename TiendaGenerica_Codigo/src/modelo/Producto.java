package modelo;

public class Producto 
{

	private int codigoProducto;
	private String nombreProducto;
	private int nitProveedor;
	private String tipoProducto;
	private double valorCompraProducto;
	private double valorVentaProducto;
	
	
	
	public Producto()
	{
		this.codigoProducto = -1;
		this.nombreProducto = "";
		this.nitProveedor = -1;
		this.tipoProducto = "";
		this.valorCompraProducto = -1.0;
		this.valorVentaProducto = -1.0;
	}



	public int getCodigoProducto() 
	{
		return codigoProducto;
	}

	public void setCodigoProducto(int pCodigoProducto) 
	{
		this.codigoProducto = pCodigoProducto;
	}

	public String getNombreProducto() 
	{
		return nombreProducto;
	}

	public void setNombreProducto(String pNombreProducto)
	{
		this.nombreProducto = pNombreProducto;
	}

	public int getNitProveedor() 
	{
		return nitProveedor;
	}

	public void setNitProveedor(int pNitProveedor) 
	{
		this.nitProveedor = pNitProveedor;
	}

	public double getValorCompraProducto()
	{
		return valorCompraProducto;
	}

	public void setValorCompraProducto(double pValorCompraProducto) 
	{
		this.valorCompraProducto = pValorCompraProducto;
	}

	public double getValorVentaProducto() 
	{
		return valorVentaProducto;
	}

	public void setValorVentaProducto(double pValorVentaProducto) 
	{
		this.valorVentaProducto = pValorVentaProducto;
	}

	public String getTipoProducto()
	{
		return tipoProducto;
	}

	public void setTipoProducto(String pTipoProducto) 
	{
		this.tipoProducto = pTipoProducto;
	}
	
	

		
}

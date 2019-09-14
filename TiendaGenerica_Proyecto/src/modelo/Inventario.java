package modelo;

import java.util.ArrayList;

public class Inventario 
{

	private ArrayList<Producto> productos;
	
	public Inventario()
	{
		this.productos = new ArrayList<>();
	}
	
	public Producto buscarProducto(int pCodigoProducto)
	{
		Producto buscado = null;
		
		for (int i = 0; i < productos.size(); i++) 
		{
			if(this.productos.get(i).getCodigoProducto() == pCodigoProducto)
			{
				buscado = this.productos.get(i);
			}
		}
		
		return buscado;
	}

	public ArrayList<Producto> getProductos()
	{
		return productos;
	}

	public void setProductos(ArrayList<Producto> pProductos) 
	{
		this.productos = pProductos;
	}
	
	
	
}

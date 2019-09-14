package modelo;

import java.util.ArrayList;

public class TiendaGenerica 
{

	private Configuracion configuracion;
	private Archivos archivos;
	private Inventario inventario;
	private ArrayList<Cliente> clientes;
	private ArrayList<Proveedor> proveedores;
	private Venta venta;
	private Compra compra;

	private String nombreTienda; 
	private String tipoTienda; 
	private String nombreGerente; 
	private String ciudad;
	private int nit;
	private double iva;

	
	
	public TiendaGenerica()
	{
		this.configuracion = new Configuracion();
		this.archivos = new Archivos();
		this.inventario = new Inventario();
		this.clientes = new ArrayList<>();
		this.proveedores = new ArrayList<>();
		this.venta = new Venta();
		this.compra = new Compra();
		
		this.nombreTienda = "";
		this.tipoTienda = "";
		this.nombreGerente = "";
		this.ciudad = "";
		this.nit = -1;
		this.iva = -1.0;
		
		this.cargarArchivos();
		this.configurarDatos();
	}


	public Cliente buscarCliente(int pCedula)
	{
		Cliente buscado = null;
		
		for (int i = 0; buscado == null && i < clientes.size(); i++) 
		{
			if(clientes.get(i).getCedula() == pCedula)
			{
				buscado = clientes.get(i);
			}
		}
		
		return buscado;
	}
	
	public Proveedor buscarProveedor(int pNit)
	{
		Proveedor buscado = null;
		
		for (int i = 0; buscado == null && i < proveedores.size(); i++) 
		{
			if(proveedores.get(i).getNit() == pNit)
			{
				buscado = proveedores.get(i);
			}
		}
		
		return buscado;
	}
	
	private void cargarArchivos()
	{
		String[] archivos = this.configuracion.getArchivosPersistencia();
		this.iva = Double.parseDouble(archivos[10]);
		
		this.archivos.setArchivoClientes(archivos[0]);
		this.archivos.setArchivoProveedores(archivos[1]);
		this.archivos.setArchivoProductos(archivos[2]);
		this.archivos.setArchivoVentas(archivos[3]);
		this.archivos.setArchivoCompras(archivos[4]);
		this.archivos.setRutaDetallesVentas(archivos[5]);
		this.archivos.setRutaCreditos(archivos[6]);
		this.archivos.setRutaDetalleCompras(archivos[7]);
		this.archivos.setRutaCheques(archivos[8]);
		
		this.setClientes(this.archivos.cargarClientes());
		this.setProveedores(this.archivos.cargarProveedores());
		this.inventario.setProductos(this.archivos.cargarProductos());
		this.getVenta().setDetallesVentas(this.archivos.cargarDetallesVentas(iva));
		this.getCompra().setDetallesCompras(this.archivos.cargarDetallesCompras(iva));
		this.venta.getCredito().setInteres(Double.parseDouble(archivos[9]));
		
		this.venta.setCodigoUltimaVenta( this.getVenta().getDetallesVentas().size() );
		this.compra.setCodigoUltimaCompra( this.getCompra().getDetallesCompras().size() );
	}

	public void configurarDatos()
	{
		String[] datos = this.configuracion.getDatosDefault();
		
		this.nombreTienda = datos[0];
		this.nombreGerente = datos[1];
		this.tipoTienda = datos[2];
		this.ciudad = datos[3];
		this.nit = Integer.parseInt(datos[4]);
		
	}
	
	public Configuracion getConfiguracion() 
	{
		return configuracion;
	}

	public void setConfiguracion(Configuracion pConfiguracion) 
	{
		this.configuracion = pConfiguracion;
	}

	public ArrayList<Cliente> getClientes() 
	{
		return clientes;
	}

	public void setClientes(ArrayList<Cliente> pClientes) 
	{
		this.clientes = pClientes;
	}

	public ArrayList<Proveedor> getProveedores() 
	{
		return proveedores;
	}

	public void setProveedores(ArrayList<Proveedor> pProveedores) 
	{
		this.proveedores = pProveedores;
	}

	public Venta getVenta() 
	{
		return venta;
	}

	public void setVenta(Venta pVenta) 
	{
		this.venta = pVenta;
	}

	public String getNombreTienda()
	{
		return nombreTienda;
	}

	public void setNombreTienda(String pNombreTienda) 
	{
		this.nombreTienda = pNombreTienda;
	}

	public String getTipoTienda() 
	{
		return tipoTienda;
	}

	public void setTipoTienda(String pTipoTienda)
	{
		this.tipoTienda = pTipoTienda;
	}

	public String getNombreGerente() 
	{
		return nombreGerente;
	}

	public void setNombreGerente(String pNombreGerente) 
	{
		this.nombreGerente = pNombreGerente;
	}

	public String getCiudad() 
	{
		return ciudad;
	}

	public void setCiudad(String pCiudad) 
	{
		this.ciudad = pCiudad;
	}

	public int getNit()
	{
		return nit;
	}

	public void setNit(int pNit)
	{
		this.nit = pNit;
	}

	public Archivos getArchivos() 
	{
		return archivos;
	}

	public void setArchivos(Archivos pArchivos) 
	{
		this.archivos = pArchivos;
	}
	
	public Inventario getInventario()
	{
		return inventario;
	}

	public void setInventario(Inventario pInventario) 
	{
		this.inventario = pInventario;
	}

	public Compra getCompra() 
	{
		return compra;
	}

	public double getIva()
	{
		return iva;
	}
	
	
	
	
}

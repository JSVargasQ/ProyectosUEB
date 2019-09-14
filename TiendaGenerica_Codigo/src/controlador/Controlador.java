package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import modelo.Cheque;
import modelo.Cliente;
import modelo.DetalleCompra;
import modelo.DetalleVenta;
import modelo.EnteNoExisteException;
import modelo.EnteYaExistenteException;
import modelo.Producto;
import modelo.Proveedor;
import modelo.TiendaGenerica;
import vista.PanelCrear;
import vista.VentanaPrincipal;

public class Controlador implements ActionListener
{

	
	private TiendaGenerica modelo;
	private VentanaPrincipal vista;
	
	public Controlador()
	{
		this.modelo = new TiendaGenerica();
		this.vista = new VentanaPrincipal();
		
		this.configurarBotones();
		this.guardarDatos();
				
	}
	
	public void guardarDatos()
	{
		this.modelo.getArchivos().guardarClientes(this.modelo.getClientes());
		this.modelo.getArchivos().guardarProveedores(this.modelo.getProveedores());
		this.modelo.getArchivos().guardarProductos(this.modelo.getInventario().getProductos());
	}

	
	
	public void actionPerformed(ActionEvent event) 
	{
		try
		{
			String evento = event.getActionCommand();
			
			if(evento.equals(Persistencia.AGREGAR_CLIENTE))
			{
				agregarCliente();
			}
			else if(evento.equals(Persistencia.BUSCAR_CLIENTE))
			{
				buscarCliente();
			}
			else if(evento.equals(Persistencia.ACTUALIZAR_CLIENTE))
			{
				actualizarCliente();
			}
			else if(evento.equals(Persistencia.ELIMINAR_CLIENTE))
			{
				eliminarCliente();
			}
			else if(evento.equals(Persistencia.AGREGAR_PROVEEDOR))
			{
				agregarProveedor();
			}
			else if(evento.equals(Persistencia.BUSCAR_PROVEEDOR))
			{
				buscarProveedor();
			}
			else if(evento.equals(Persistencia.ACTUALIZAR_PROVEEDOR))
			{
				actualizarProveedor();
			}
			else if(evento.equals(Persistencia.ELIMINAR_PROVEEDOR))
			{
				eliminarProveedor();
			}
			else if(evento.equals(Persistencia.AGREGAR_PRODUCTO))
			{
				agregarProducto();
			}
			else if(evento.equals(Persistencia.BUSCAR_PRODUCTO))
			{
				buscarProducto();
			}
			else if(evento.equals(Persistencia.ACTUALIZAR_PRODUCTO))
			{
				actualizarProducto();
			}
			else if(evento.equals(Persistencia.ELIMINAR_PRODUCTO))
			{
				eliminarProducto();
			}
			else if(evento.equals(Persistencia.VENTAS_BUSCAR_CLIENTE))
			{
				ventaBuscarCliente();
			}
			else if(evento.equals(Persistencia.VENTAS_BUSCAR_PRODUCTO))
			{
				ventaSeleccionarProducto();
			}
			else if(evento.equals(Persistencia.VENTAS_AGREGAR))
			{
				ventaAgregarProducto();
			}
			else if(evento.equals(Persistencia.VENTAS_TOTALIZAR))
			{
				ventaTotalizar();
			}
			else if(evento.equals(Persistencia.COMPRAS_BUSCAR_PROVEEDOR))
			{
				compraBuscarProveedor();
			}
			else if(evento.equals(Persistencia.COMPRAS_BUSCAR_PRODUCTO))
			{
				compraSeleccionarProducto();
			}
			else if(evento.equals(Persistencia.COMPRAS_AGREGAR))
			{
				compraAgregarProducto();
			}
			else if(evento.equals(Persistencia.COMPRAS_TOTALIZAR))
			{
				compraTotalizar();
			}
			else if(evento.equals(Persistencia.CONFIGURACION))
			{
				configurar();
			}
			else if(evento.equals(Persistencia.VISUALIZAR_PROPIEDADES))
			{
				mostrarPropiedaes();
			}
			else if(evento.equals(Persistencia.MODIFICAR_PROPIEDADES))
			{
				modificarPropiedades();
			}
			else if(evento.equals(Persistencia.LISTAR_CLIENTES))
			{
				listarClientes();
			}
			else if(evento.equals(Persistencia.LIMPIAR_PANEL))
			{
				limpiarPaneles();
			}
			else if(evento.equals(Persistencia.AYUDA))
			{
				this.vista.darMensajeAyuda();
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			if(e.getClass() != EnteNoExisteException.class && e.getClass() != EnteYaExistenteException.class)
			{
				this.vista.darMensajeError("Ha ocurrido un error.");
			}
			else
			{
				
				this.vista.darMensajeError(e.getMessage());
			}
		}
	}
	
	private void agregarCliente() throws EnteYaExistenteException
	{
		int cedula = Integer.parseInt(this.vista.getPanelClientes().getPanelCrear().getTxtDato2().getText());
		if(modelo.buscarCliente(cedula) == null)
		{
			PanelCrear clientesPanelCrear = this.vista.getPanelClientes().getPanelCrear();
			
			int posicionClienteNuevo = this.modelo.getClientes().size();
			this.modelo.getClientes().add(new Cliente());
			this.modelo.getClientes().get(posicionClienteNuevo).setCedula(cedula);
			this.modelo.getClientes().get(posicionClienteNuevo).setTelefono(Integer.parseInt(clientesPanelCrear.getTxtDato3().getText()));
			this.modelo.getClientes().get(posicionClienteNuevo).setNombre(clientesPanelCrear.getTxtDato1().getText());
			this.modelo.getClientes().get(posicionClienteNuevo).setCorreoElectronico(clientesPanelCrear.getTxtDato5().getText());
			this.modelo.getClientes().get(posicionClienteNuevo).setDireccion(clientesPanelCrear.getTxtDato6().getText());
		
			if(clientesPanelCrear.getRadioButton1().isSelected() == true)
			{
				this.modelo.getClientes().get(posicionClienteNuevo).setGenero(clientesPanelCrear.getRadioButton1().getText());
			}
			else if(clientesPanelCrear.getRadioButton2().isSelected() == true)
			{
				this.modelo.getClientes().get(posicionClienteNuevo).setGenero(clientesPanelCrear.getRadioButton2().getText());
			}
			else if(clientesPanelCrear.getRadioButton3().isSelected() == true)
			{
				this.modelo.getClientes().get(posicionClienteNuevo).setGenero(clientesPanelCrear.getRadioButton3().getText());
			}	
			
			this.modelo.getArchivos().guardarClientes(this.modelo.getClientes());
			
			clientesPanelCrear.getTxtDato1().setText("");
			clientesPanelCrear.getTxtDato2().setText("");
			clientesPanelCrear.getTxtDato3().setText("");
			clientesPanelCrear.getTxtDato5().setText("");			
			clientesPanelCrear.getTxtDato6().setText("");
			
		}
		else
		{
			throw new EnteYaExistenteException();
		}
	}
	
	private void agregarProveedor() throws EnteYaExistenteException
	{
		int nit = Integer.parseInt(this.vista.getPanelProveedores().getPanelCrear().getTxtDato2().getText());
		if(modelo.buscarProveedor(nit) == null)
		{
			PanelCrear proveedorPanelCrear = this.vista.getPanelProveedores().getPanelCrear();
			
			int posicionProveedorNuevo = this.modelo.getProveedores().size();
			this.modelo.getProveedores().add(new Proveedor());
			this.modelo.getProveedores().get(posicionProveedorNuevo).setNit(nit);
			this.modelo.getProveedores().get(posicionProveedorNuevo).setNombre(proveedorPanelCrear.getTxtDato1().getText());
			this.modelo.getProveedores().get(posicionProveedorNuevo).setDireccion(proveedorPanelCrear.getTxtDato5().getText());
			this.modelo.getProveedores().get(posicionProveedorNuevo).setTelefono(Integer.parseInt(proveedorPanelCrear.getTxtDato3().getText()));
			this.modelo.getProveedores().get(posicionProveedorNuevo).setCiudad(proveedorPanelCrear.getTxtDato6().getText());
			
			if(proveedorPanelCrear.getRadioButton1().isSelected() == true)
			{
				this.modelo.getProveedores().get(posicionProveedorNuevo).setTipoProveedor(proveedorPanelCrear.getRadioButton1().getText());
			}
			else if(proveedorPanelCrear.getRadioButton2().isSelected() == true)
			{
				this.modelo.getProveedores().get(posicionProveedorNuevo).setTipoProveedor(proveedorPanelCrear.getRadioButton2().getText());
			}
			else if(proveedorPanelCrear.getRadioButton3().isSelected() == true)
			{
				this.modelo.getProveedores().get(posicionProveedorNuevo).setTipoProveedor(proveedorPanelCrear.getRadioButton3().getText());
			}	
			
			this.modelo.getArchivos().guardarProveedores(this.modelo.getProveedores());		
			
			this.vista.getPanelProveedores().getPanelCrear().getTxtDato1().setText("");
			this.vista.getPanelProveedores().getPanelCrear().getTxtDato2().setText("");
			this.vista.getPanelProveedores().getPanelCrear().getTxtDato3().setText("");
			this.vista.getPanelProveedores().getPanelCrear().getTxtDato5().setText("");			
			this.vista.getPanelProveedores().getPanelCrear().getTxtDato6().setText("");
		}
		else
		{
			throw new EnteYaExistenteException();
		}
	}
	
	private void agregarProducto() throws EnteYaExistenteException
	{
		int codigoProducto = Integer.parseInt(this.vista.getPanelProductos().getPanelCrear().getTxtDato2().getText());
		if(this.modelo.getInventario().buscarProducto(codigoProducto) == null)
		{
			PanelCrear productoPanelCrear = this.vista.getPanelProductos().getPanelCrear();
			
			int posicionProductoNuevo = this.modelo.getInventario().getProductos().size();
			this.modelo.getInventario().getProductos().add(new Producto());
			this.modelo.getInventario().getProductos().get(posicionProductoNuevo).setCodigoProducto(codigoProducto);
			this.modelo.getInventario().getProductos().get(posicionProductoNuevo).setNombreProducto(productoPanelCrear.getTxtDato1().getText());
			this.modelo.getInventario().getProductos().get(posicionProductoNuevo).setNitProveedor(Integer.parseInt(productoPanelCrear.getTxtDato3().getText()));
			this.modelo.getInventario().getProductos().get(posicionProductoNuevo).setValorCompraProducto(Double.parseDouble(productoPanelCrear.getTxtDato5().getText()));
			this.modelo.getInventario().getProductos().get(posicionProductoNuevo).setValorVentaProducto(Double.parseDouble(productoPanelCrear.getTxtDato6().getText()));	
		
			if(productoPanelCrear.getRadioButton1().isSelected() == true)
			{
				this.modelo.getInventario().getProductos().get(posicionProductoNuevo).setTipoProducto(productoPanelCrear.getRadioButton1().getText());
			}
			else if(productoPanelCrear.getRadioButton2().isSelected() == true)
			{
				this.modelo.getInventario().getProductos().get(posicionProductoNuevo).setTipoProducto(productoPanelCrear.getRadioButton2().getText());
			}
			else if(productoPanelCrear.getRadioButton3().isSelected() == true)
			{
				this.modelo.getInventario().getProductos().get(posicionProductoNuevo).setTipoProducto(productoPanelCrear.getRadioButton3().getText());
			}	
			
			
			this.modelo.getArchivos().guardarProductos(this.modelo.getInventario().getProductos());
			
			this.vista.getPanelProductos().getPanelCrear().getTxtDato1().setText("");
			this.vista.getPanelProductos().getPanelCrear().getTxtDato2().setText("");
			this.vista.getPanelProductos().getPanelCrear().getTxtDato3().setText("");
			this.vista.getPanelProductos().getPanelCrear().getTxtDato5().setText("");			
			this.vista.getPanelProductos().getPanelCrear().getTxtDato6().setText("");
		}
		else
		{
			throw new EnteYaExistenteException();
		}
	}
	
	private void buscarCliente() throws EnteNoExisteException
	{
		int cedula = Integer.parseInt(this.vista.getPanelClientes().getPanelActualizar().getTxtBuscar().getText());
		
		Cliente buscado = this.modelo.buscarCliente(cedula);
		
		if(buscado != null)
		{
			this.vista.getPanelClientes().getPanelActualizar().getTxtDato1().setText(buscado.getNombre());
			this.vista.getPanelClientes().getPanelActualizar().getTxtDato2().setText(String.valueOf(buscado.getTelefono()));
			this.vista.getPanelClientes().getPanelActualizar().getTxtDato3().setText(buscado.getCorreoElectronico());
			this.vista.getPanelClientes().getPanelActualizar().getTxtDato5().setText(buscado.getDireccion());
			
			if(buscado.getGenero().equals(this.vista.getPanelClientes().getPanelActualizar().getRadioButton1().getText()))
			{
				this.vista.getPanelClientes().getPanelActualizar().getRadioButton1().setSelected(true);
			}
			else if(buscado.getGenero().equals(this.vista.getPanelClientes().getPanelActualizar().getRadioButton2().getText()))
			{
				this.vista.getPanelClientes().getPanelActualizar().getRadioButton2().setSelected(true);
			}
			else if(buscado.getGenero().equals(this.vista.getPanelClientes().getPanelActualizar().getRadioButton3().getText()))
			{
				this.vista.getPanelClientes().getPanelActualizar().getRadioButton3().setSelected(true);
			}		
			
		}
		else
		{
			throw new EnteNoExisteException();
		}
	}
	
	private void buscarProveedor() throws EnteNoExisteException
	{
		int nit = Integer.parseInt(this.vista.getPanelProveedores().getPanelActualizar().getTxtBuscar().getText());
		
		Proveedor buscado = this.modelo.buscarProveedor(nit);
		
		if(buscado != null)
		{
			this.vista.getPanelProveedores().getPanelActualizar().getTxtDato1().setText(buscado.getNombre());
			this.vista.getPanelProveedores().getPanelActualizar().getTxtDato2().setText(String.valueOf(buscado.getTelefono()));
			this.vista.getPanelProveedores().getPanelActualizar().getTxtDato3().setText(buscado.getDireccion());
			this.vista.getPanelProveedores().getPanelActualizar().getTxtDato5().setText(buscado.getCiudad());
			
			if(buscado.getTipoProveedor().equals(this.vista.getPanelProveedores().getPanelActualizar().getRadioButton1().getText()))
			{
				this.vista.getPanelProveedores().getPanelActualizar().getRadioButton1().setSelected(true);
			}
			else if(buscado.getTipoProveedor().equals(this.vista.getPanelProveedores().getPanelActualizar().getRadioButton2().getText()))
			{
				this.vista.getPanelProveedores().getPanelActualizar().getRadioButton2().setSelected(true);
			}
			else if(buscado.getTipoProveedor().equals(this.vista.getPanelProveedores().getPanelActualizar().getRadioButton3().getText()))
			{
				this.vista.getPanelProveedores().getPanelActualizar().getRadioButton3().setSelected(true);
			}		
		}
		else
		{
			throw new EnteNoExisteException();
		}
	}
	
	private void buscarProducto() throws EnteNoExisteException
	{
		int codigoProducto = Integer.parseInt(this.vista.getPanelProductos().getPanelActualizar().getTxtBuscar().getText());
		
		Producto buscado = this.modelo.getInventario().buscarProducto(codigoProducto);
		
		if(buscado != null)
		{
			this.vista.getPanelProductos().getPanelActualizar().getTxtDato1().setText(buscado.getNombreProducto());
			this.vista.getPanelProductos().getPanelActualizar().getTxtDato2().setText(String.valueOf(buscado.getNitProveedor()));
			this.vista.getPanelProductos().getPanelActualizar().getTxtDato3().setText(String.valueOf(buscado.getValorCompraProducto()));
			this.vista.getPanelProductos().getPanelActualizar().getTxtDato5().setText(String.valueOf(buscado.getValorVentaProducto()));
			
			if(buscado.getTipoProducto().equals(this.vista.getPanelProductos().getPanelActualizar().getRadioButton1().getText()))
			{
				this.vista.getPanelProductos().getPanelActualizar().getRadioButton1().setSelected(true);
			}
			else if(buscado.getTipoProducto().equals(this.vista.getPanelProductos().getPanelActualizar().getRadioButton2().getText()))
			{
				this.vista.getPanelProductos().getPanelActualizar().getRadioButton2().setSelected(true);
			}
			else if(buscado.getTipoProducto().equals(this.vista.getPanelProductos().getPanelActualizar().getRadioButton3().getText()))
			{
				this.vista.getPanelProductos().getPanelActualizar().getRadioButton3().setSelected(true);
			}		
			
			this.modelo.getArchivos().guardarProductos(this.modelo.getInventario().getProductos());
		}
		else
		{
			throw new EnteNoExisteException();
		}
	}
	
	private void actualizarCliente() throws EnteNoExisteException
	{
		int cedula = Integer.parseInt(this.vista.getPanelClientes().getPanelActualizar().getTxtBuscar().getText());
		
		Cliente buscado = this.modelo.buscarCliente(cedula);
		
		if(buscado != null)
		{
			buscado.setNombre(this.vista.getPanelClientes().getPanelActualizar().getTxtDato1().getText());
			buscado.setTelefono(Integer.parseInt(this.vista.getPanelClientes().getPanelActualizar().getTxtDato2().getText()));
			buscado.setCorreoElectronico(this.vista.getPanelClientes().getPanelActualizar().getTxtDato3().getText());
			buscado.setDireccion(this.vista.getPanelClientes().getPanelActualizar().getTxtDato5().getText());
			
			if(this.vista.getPanelClientes().getPanelActualizar().getRadioButton1().isSelected() == true)
			{
				buscado.setGenero(this.vista.getPanelClientes().getPanelActualizar().getRadioButton1().getText());
			}
			else if(this.vista.getPanelClientes().getPanelActualizar().getRadioButton2().isSelected() == true)
			{
				buscado.setGenero(this.vista.getPanelClientes().getPanelActualizar().getRadioButton2().getText());
			}
			else if(this.vista.getPanelClientes().getPanelActualizar().getRadioButton3().isSelected() == true)
			{
				buscado.setGenero(this.vista.getPanelClientes().getPanelActualizar().getRadioButton3().getText());
			}	
			
			this.modelo.getArchivos().guardarClientes(this.modelo.getClientes());
			
			this.vista.getPanelClientes().getPanelActualizar().getTxtDato1().setText("");
			this.vista.getPanelClientes().getPanelActualizar().getTxtDato2().setText("");
			this.vista.getPanelClientes().getPanelActualizar().getTxtDato3().setText("");
			this.vista.getPanelClientes().getPanelActualizar().getTxtDato5().setText("");	
		}
		else
		{
			throw new EnteNoExisteException();
		}
	}
	
	private void actualizarProveedor() throws EnteNoExisteException
	{
		int nit = Integer.parseInt(this.vista.getPanelProveedores().getPanelActualizar().getTxtBuscar().getText());
		
		Proveedor buscado = this.modelo.buscarProveedor(nit);
		
		if(buscado != null)
		{
			buscado.setNombre(this.vista.getPanelProveedores().getPanelActualizar().getTxtDato1().getText());
			buscado.setTelefono(Integer.parseInt(this.vista.getPanelProveedores().getPanelActualizar().getTxtDato2().getText()));
			buscado.setDireccion(this.vista.getPanelProveedores().getPanelActualizar().getTxtDato3().getText());
			buscado.setCiudad(this.vista.getPanelProveedores().getPanelActualizar().getTxtDato5().getText());
			
			
			if(this.vista.getPanelProveedores().getPanelActualizar().getRadioButton1().isSelected() == true)
			{
				buscado.setTipoProveedor(this.vista.getPanelProveedores().getPanelActualizar().getRadioButton1().getText());
			}
			else if(this.vista.getPanelProveedores().getPanelActualizar().getRadioButton2().isSelected() == true)
			{
				buscado.setTipoProveedor(this.vista.getPanelProveedores().getPanelActualizar().getRadioButton2().getText());
			}
			else if(this.vista.getPanelProveedores().getPanelActualizar().getRadioButton3().isSelected() == true)
			{
				buscado.setTipoProveedor(this.vista.getPanelProveedores().getPanelActualizar().getRadioButton3().getText());
			}	
			
			this.modelo.getArchivos().guardarProveedores(this.modelo.getProveedores());
			
			this.vista.getPanelProveedores().getPanelActualizar().getTxtDato1().setText("");
			this.vista.getPanelProveedores().getPanelActualizar().getTxtDato2().setText("");
			this.vista.getPanelProveedores().getPanelActualizar().getTxtDato3().setText("");
			this.vista.getPanelProveedores().getPanelActualizar().getTxtDato5().setText("");	
		}
		else
		{
			throw new EnteNoExisteException();
		}
	}
	
	private void actualizarProducto() throws EnteNoExisteException
	{
		int codigoProducto = Integer.parseInt(this.vista.getPanelProductos().getPanelActualizar().getTxtBuscar().getText());
		
		Producto buscado = this.modelo.getInventario().buscarProducto(codigoProducto);
		
		if(buscado != null)
		{
			buscado.setNombreProducto(this.vista.getPanelProductos().getPanelActualizar().getTxtDato1().getText());
			buscado.setNitProveedor(Integer.parseInt(this.vista.getPanelProductos().getPanelActualizar().getTxtDato2().getText()));
			buscado.setValorCompraProducto(Double.parseDouble(this.vista.getPanelProductos().getPanelActualizar().getTxtDato3().getText()));
			buscado.setValorVentaProducto(Double.parseDouble(this.vista.getPanelProductos().getPanelActualizar().getTxtDato5().getText()));
			
			
			if(this.vista.getPanelProductos().getPanelActualizar().getRadioButton1().isSelected() == true)
			{
				buscado.setTipoProducto(this.vista.getPanelProductos().getPanelActualizar().getRadioButton1().getText());
			}
			else if(this.vista.getPanelProductos().getPanelActualizar().getRadioButton2().isSelected() == true)
			{
				buscado.setTipoProducto(this.vista.getPanelProductos().getPanelActualizar().getRadioButton2().getText());
			}
			else if(this.vista.getPanelProductos().getPanelActualizar().getRadioButton3().isSelected() == true)
			{
				buscado.setTipoProducto(this.vista.getPanelProductos().getPanelActualizar().getRadioButton3().getText());
			}	
			
			this.modelo.getArchivos().guardarProductos(this.modelo.getInventario().getProductos());
			
			this.vista.getPanelProductos().getPanelActualizar().getTxtDato1().setText("");
			this.vista.getPanelProductos().getPanelActualizar().getTxtDato2().setText("");
			this.vista.getPanelProductos().getPanelActualizar().getTxtDato3().setText("");
			this.vista.getPanelProductos().getPanelActualizar().getTxtDato5().setText("");			
		}
		else
		{
			throw new EnteNoExisteException();
		}
	}
	
	private void eliminarCliente() throws EnteNoExisteException 
	{
		int cedula = Integer.parseInt(this.vista.ingresarDato("Ingrese la cedula del cliente que desea buscar"));
		if(this.modelo.buscarCliente(cedula) != null)
		{
			this.modelo.getClientes().remove(this.modelo.buscarCliente(cedula));
			this.modelo.getArchivos().guardarClientes(this.modelo.getClientes());
		}
		else
		{
			throw new EnteNoExisteException();
		}
	}
	
	private void eliminarProveedor() throws EnteNoExisteException
	{
		int nit = Integer.parseInt(this.vista.ingresarDato("Ingrese el Nit del proveedor que desea eliminar"));
		if(this.modelo.buscarProveedor(nit) != null)
		{
			this.modelo.getProveedores().remove(this.modelo.buscarProveedor(nit));
			this.modelo.getArchivos().guardarProveedores(this.modelo.getProveedores());
		}
		else
		{
			throw new EnteNoExisteException();
		}
	}

	private void eliminarProducto() throws EnteNoExisteException
	{
		int codigoProducto = Integer.parseInt(this.vista.ingresarDato("Ingrese el Codigo del producto que desea eliminar"));
		if(this.modelo.getInventario().buscarProducto(codigoProducto) != null)
		{
			this.modelo.getInventario().getProductos().remove(this.modelo.getInventario().buscarProducto(codigoProducto));
			this.modelo.getArchivos().guardarProductos(this.modelo.getInventario().getProductos());
		}
		else
		{
			throw new EnteNoExisteException();
		}
	}
	
	private void ventaBuscarCliente() throws EnteNoExisteException
	{		
		int cedula = Integer.parseInt(this.vista.getPanelVentas().getPanelTransacciones().getTxtBuscar1().getText());
		
		Cliente buscado = this.modelo.buscarCliente(cedula);
		
		if(buscado != null)
		{
			this.vista.getPanelVentas().getPanelTransacciones().getLabDato1().setText(buscado.getNombre());
			this.vista.getPanelVentas().getPanelTransacciones().getLabDato2().setText(String.valueOf(buscado.getCedula()));
			this.vista.getPanelVentas().getPanelTransacciones().getLabDato3().setText(String.valueOf(buscado.getTelefono()));
			this.vista.getPanelVentas().getPanelTransacciones().getLabDato4().setText(buscado.getCorreoElectronico());
			
			if(this.modelo.getVenta().getCodigoUltimaVenta() == this.modelo.getVenta().getDetallesVentas().size())
			{
				this.modelo.getVenta().getDetallesVentas().add(new DetalleVenta());
			}
			this.modelo.getVenta().getDetallesVentas().get(this.modelo.getVenta().getCodigoUltimaVenta()).setCedulaClienteVenta(cedula);
			this.modelo.getVenta().getDetallesVentas().get(this.modelo.getVenta().getCodigoUltimaVenta()).setCodigoDetalleVenta(this.modelo.getVenta().getCodigoUltimaVenta() + 1);
		}
		else
		{
			throw new EnteNoExisteException();
		}
	}
	
	private void ventaSeleccionarProducto()
	{
		int codigoProducto = Integer.parseInt(this.vista.getPanelVentas().getPanelTransacciones().getTxtBuscar2().getText());
		Producto actual = this.modelo.getInventario().buscarProducto(codigoProducto);
		boolean yaAgregado = false;
		
		for (int i = 0; i < this.modelo.getVenta().getDetallesVentas().get(this.modelo.getVenta().getCodigoUltimaVenta()).getCodigoProducto().size() && yaAgregado == false; i++) 
		{
			if(this.modelo.getVenta().getDetallesVentas().get(this.modelo.getVenta().getCodigoUltimaVenta()).getCodigoProducto().get(i) == codigoProducto)
			{
				yaAgregado = true;
			}
		}
		
		if(actual != null && yaAgregado == false)
		{
			this.modelo.getVenta().getDetallesVentas().get(this.modelo.getVenta().getCodigoUltimaVenta()).getCodigoProducto().add(codigoProducto);
			String nombreProducto = actual.getNombreProducto();
			this.modelo.getVenta().getDetallesVentas().get(this.modelo.getVenta().getCodigoUltimaVenta()).getValorVentaProducto().add(actual.getValorVentaProducto());
			
			String codProducto = String.valueOf(codigoProducto);
			String valorVentaProducto = String.valueOf(actual.getValorVentaProducto());
			
			String[] datos = {codProducto, nombreProducto, "", valorVentaProducto, ""};
			this.vista.getPanelVentas().getPanelTransacciones().agregarProductoTabla(datos);
			this.vista.getPanelVentas().getPanelTransacciones().getTxtBuscar2().setEnabled(false);
			this.vista.getPanelVentas().getPanelTransacciones().getBtnBuscar2().setEnabled(false);
			this.vista.getPanelVentas().getPanelTransacciones().getBtnAgregar().setEnabled(true);
		}
		else
		{
			this.vista.darMensajeError("-Verifique que el producto exista.\n-Verifique que no este agregado el producto a la lista.");
		}
	}
	
	private void ventaAgregarProducto()
	{
		int cantidadProducto = Integer.parseInt(this.vista.getPanelVentas().getPanelTransacciones().getTxtCantidad().getText());
		double valorTotal = -9999;
		
		boolean encontrado = false;
		for (int i = 0; i < this.modelo.getVenta().getDetallesVentas().get(this.modelo.getVenta().getCodigoUltimaVenta()).getCodigoProducto().size() && encontrado == false; i++) 
		{
			if(Integer.parseInt(this.vista.getPanelVentas().getPanelTransacciones().getTxtBuscar2().getText()) == this.modelo.getVenta().getDetallesVentas().get(this.modelo.getVenta().getCodigoUltimaVenta()).getCodigoProducto().get(i))
			{
				valorTotal = (this.modelo.getVenta().getDetallesVentas().get(this.modelo.getVenta().getCodigoUltimaVenta()).getValorVentaProducto().get(i))*(double)(cantidadProducto);
				this.modelo.getVenta().getDetallesVentas().get(this.modelo.getVenta().getCodigoUltimaVenta()).getCantidadProducto().add(cantidadProducto);
				this.vista.getPanelVentas().getPanelTransacciones().modificarFila(String.valueOf(cantidadProducto), i+1, 2);
				this.vista.getPanelVentas().getPanelTransacciones().modificarFila(String.valueOf(valorTotal), i+1, 4);		
				encontrado = true;
			}
		}
		
		this.vista.getPanelVentas().getPanelTransacciones().getTxtBuscar2().setEnabled(true);
		this.vista.getPanelVentas().getPanelTransacciones().getBtnBuscar2().setEnabled(true);
		this.vista.getPanelVentas().getPanelTransacciones().getBtnAgregar().setEnabled(false);
		this.vista.getPanelVentas().getPanelTransacciones().getTxtBuscar2().setText("");
		this.vista.getPanelVentas().getPanelTransacciones().getTxtCantidad().setText("");		
	}
	
	private void ventaTotalizar()
	{
		this.modelo.getVenta().getDetallesVentas().get(this.modelo.getVenta().getCodigoUltimaVenta()).calcularValorTotal();
		this.modelo.getVenta().getDetallesVentas().get(this.modelo.getVenta().getCodigoUltimaVenta()).calcularValoresIVA(this.modelo.getIva());
		String[] opcionesPago = {"Efectivo", "Credito"};
		int opcionPago = this.vista.escogerOpcion("El precio final es de $" + this.modelo.getVenta().getDetallesVentas().get(this.modelo.getVenta().getCodigoUltimaVenta()).getValorMasIVA() + " con IVA\n¿Como desea pagar?", opcionesPago);
		if(opcionPago == 1)
		{
			int numCuotas = Integer.parseInt(this.vista.ingresarDato("Ingrese la cantidad de cuotas"));
			double valorVenta = this.modelo.getVenta().getDetallesVentas().get(this.modelo.getVenta().getCodigoUltimaVenta()).getValorMasIVA();
		
			String[] credito = this.modelo.getVenta().calcularCredito(numCuotas, valorVenta);
			int confirmacion = this.vista.getPanelVentas().getPanelTransacciones().mostrarCredito(this.modelo.getVenta().getCredito().getTablaAmortizacion());
			
			if(confirmacion == JOptionPane.YES_OPTION)
			{
				String nombreCliente = this.vista.getPanelVentas().getPanelTransacciones().getLabDato1().getText();
				String cedulaCliente = this.vista.getPanelVentas().getPanelTransacciones().getLabDato2().getText();
				this.modelo.getArchivos().guardarCredito(nombreCliente, cedulaCliente, credito);
				
				this.modelo.getArchivos().guardarDetalleVenta(this.modelo.getVenta().getDetallesVentas().get(this.modelo.getVenta().getCodigoUltimaVenta()));
				this.modelo.getArchivos().guardarVenta(this.modelo.getVenta().getDetallesVentas().get(this.modelo.getVenta().getCodigoUltimaVenta()));
				this.modelo.getVenta().setCodigoUltimaVenta(this.modelo.getVenta().getCodigoUltimaVenta()+1);
			}
			else
			{
				ventaTotalizar();
			}
		}
		else
		{
			this.modelo.getArchivos().guardarDetalleVenta(this.modelo.getVenta().getDetallesVentas().get(this.modelo.getVenta().getCodigoUltimaVenta()));
			this.modelo.getArchivos().guardarVenta(this.modelo.getVenta().getDetallesVentas().get(this.modelo.getVenta().getCodigoUltimaVenta()));
			this.modelo.getVenta().setCodigoUltimaVenta(this.modelo.getVenta().getCodigoUltimaVenta() + 1);
		}
		
		this.vista.getPanelVentas().getPanelTransacciones().getTxtBuscar1().setText("");
		this.vista.getPanelVentas().getPanelTransacciones().getTxtBuscar2().setText("");
		this.vista.getPanelVentas().getPanelTransacciones().getTxtCantidad().setText("");
		this.vista.getPanelVentas().getPanelTransacciones().limpiarTabla();
	}
	
	private void compraBuscarProveedor() throws EnteNoExisteException
	{
		int nit = Integer.parseInt(this.vista.getPanelCompras().getPanelTransacciones().getTxtBuscar1().getText());
		
		Proveedor buscado = this.modelo.buscarProveedor(nit);
		
		if(buscado != null)
		{
			this.vista.getPanelCompras().getPanelTransacciones().getLabDato1().setText(buscado.getNombre());
			this.vista.getPanelCompras().getPanelTransacciones().getLabDato2().setText(String.valueOf(buscado.getNit()));
			this.vista.getPanelCompras().getPanelTransacciones().getLabDato3().setText(String.valueOf(buscado.getTelefono()));
			this.vista.getPanelCompras().getPanelTransacciones().getLabDato4().setText(buscado.getDireccion());
			
			
			
			if(this.modelo.getCompra().getCodigoUltimaCompra() == this.modelo.getCompra().getDetallesCompras().size())
			{
				this.modelo.getCompra().getDetallesCompras().add(new DetalleCompra());
			}
			this.modelo.getCompra().getDetallesCompras().get(this.modelo.getCompra().getCodigoUltimaCompra()).setNitProveedorCompra(nit);
			this.modelo.getCompra().getDetallesCompras().get(this.modelo.getCompra().getCodigoUltimaCompra()).setCodigoDetalleCompra(this.modelo.getCompra().getCodigoUltimaCompra() + 1);
		}
		else
		{
			throw new EnteNoExisteException();
		}
	}
		
	private void compraSeleccionarProducto()
	{
		int codigoProducto = Integer.parseInt(this.vista.getPanelCompras().getPanelTransacciones().getTxtBuscar2().getText());
		Producto actual = this.modelo.getInventario().buscarProducto(codigoProducto);
		boolean yaAgregado = false;
		
		for (int i = 0; i < this.modelo.getCompra().getDetallesCompras().get(this.modelo.getCompra().getCodigoUltimaCompra()).getCodigoProducto().size() && yaAgregado == false; i++) 
		{
			if(this.modelo.getCompra().getDetallesCompras().get(this.modelo.getCompra().getCodigoUltimaCompra()).getCodigoProducto().get(i) == codigoProducto)
			{
				yaAgregado = true;
			}
		}
		
		if(actual != null && yaAgregado == false)
		{
			this.modelo.getCompra().getDetallesCompras().get(this.modelo.getCompra().getCodigoUltimaCompra()).getCodigoProducto().add(codigoProducto);
			String nombreProducto = actual.getNombreProducto();
			this.modelo.getCompra().getDetallesCompras().get(this.modelo.getCompra().getCodigoUltimaCompra()).getValorCompraProducto().add(actual.getValorCompraProducto());
			
			String codProducto = String.valueOf(codigoProducto);
			String valorCompraProducto = String.valueOf(actual.getValorCompraProducto());
			
			String[] datos = {codProducto, nombreProducto, "", valorCompraProducto, ""};
			this.vista.getPanelCompras().getPanelTransacciones().agregarProductoTabla(datos);
			this.vista.getPanelCompras().getPanelTransacciones().getTxtBuscar2().setEnabled(false);
			this.vista.getPanelCompras().getPanelTransacciones().getBtnBuscar2().setEnabled(false);
			this.vista.getPanelCompras().getPanelTransacciones().getBtnAgregar().setEnabled(true);
		}
		else
		{
			this.vista.darMensajeError("-Verifique que el producto exista.\n-Verifique que no este agregado el producto a la lista.");
		}
	}
	
	private void compraAgregarProducto()
	{
		int cantidadProducto = Integer.parseInt(this.vista.getPanelCompras().getPanelTransacciones().getTxtCantidad().getText());
		double valorTotal = -9999;
		
		boolean encontrado = false;
		for (int i = 0; i < this.modelo.getCompra().getDetallesCompras().get(this.modelo.getCompra().getCodigoUltimaCompra()).getCodigoProducto().size() && encontrado == false; i++) 
		{
			if(Integer.parseInt(this.vista.getPanelCompras().getPanelTransacciones().getTxtBuscar2().getText()) == this.modelo.getCompra().getDetallesCompras().get(this.modelo.getCompra().getCodigoUltimaCompra()).getCodigoProducto().get(i))
			{
				valorTotal = (this.modelo.getCompra().getDetallesCompras().get(this.modelo.getCompra().getCodigoUltimaCompra()).getValorCompraProducto().get(i))*(double)(cantidadProducto);
				this.modelo.getCompra().getDetallesCompras().get(this.modelo.getCompra().getCodigoUltimaCompra()).getCantidadProducto().add(cantidadProducto);
				this.vista.getPanelCompras().getPanelTransacciones().modificarFila(String.valueOf(cantidadProducto), i+1, 2);
				this.vista.getPanelCompras().getPanelTransacciones().modificarFila(String.valueOf(valorTotal), i+1, 4);		
				encontrado = true;
			}
		}
		
		this.vista.getPanelCompras().getPanelTransacciones().getTxtBuscar2().setEnabled(true);
		this.vista.getPanelCompras().getPanelTransacciones().getBtnBuscar2().setEnabled(true);
		this.vista.getPanelCompras().getPanelTransacciones().getBtnAgregar().setEnabled(false);
		this.vista.getPanelCompras().getPanelTransacciones().getTxtBuscar2().setText("");
		this.vista.getPanelCompras().getPanelTransacciones().getTxtCantidad().setText("");	
	}

	private void compraTotalizar()
	{
		this.modelo.getCompra().getDetallesCompras().get(this.modelo.getCompra().getCodigoUltimaCompra()).calcularValorTotal();
		this.modelo.getCompra().getDetallesCompras().get(this.modelo.getCompra().getCodigoUltimaCompra()).calcularValoresIVA(this.modelo.getIva());
		
		
		int confirmar = this.vista.escogerOpcion("El precio final es de $" + this.modelo.getCompra().getDetallesCompras().get(this.modelo.getCompra().getCodigoUltimaCompra()).getValorMasIVA() + " con IVA\n¿Desea confirmar la compra?", "Compra");
		if(confirmar == JOptionPane.YES_OPTION)
		{
			Cheque chequeActual = this.modelo.getCompra().getCheque();
			
			chequeActual.setNombreBanco(this.vista.ingresarDato("¿En que banco se hara la transaccion?"));
			chequeActual.setNumeroCuenta(Integer.parseInt(this.vista.ingresarDato("Introduzca el numero de cuenta del proveedor")));
			
			chequeActual.setNombreProveedor(this.vista.getPanelCompras().getPanelTransacciones().getLabDato1().getText());
			chequeActual.setNombre(this.modelo.getNombreTienda());
			chequeActual.setConsecutivoCheque(this.modelo.getCompra().getCodigoUltimaCompra()+1);
			chequeActual.setValorCifra(this.modelo.getCompra().getDetallesCompras().get(this.modelo.getCompra().getCodigoUltimaCompra()).getValorMasIVA());
			this.modelo.getCompra().calcularMontoEscrito();
			
			this.vista.getPanelCompras().generarCheque(chequeActual);
			
			this.modelo.getArchivos().guardarDetalleCompra(this.modelo.getCompra().getDetallesCompras().get(this.modelo.getCompra().getCodigoUltimaCompra()));
			this.modelo.getArchivos().guardarCompra(this.modelo.getCompra().getDetallesCompras().get(this.modelo.getCompra().getCodigoUltimaCompra()));
			this.modelo.getCompra().setCodigoUltimaCompra(this.modelo.getCompra().getCodigoUltimaCompra() + 1);
			
		}
		
		this.vista.getPanelCompras().getPanelTransacciones().getTxtBuscar1().setText("");
		this.vista.getPanelCompras().getPanelTransacciones().getTxtBuscar2().setText("");
		this.vista.getPanelCompras().getPanelTransacciones().getTxtCantidad().setText("");
		this.vista.getPanelCompras().getPanelTransacciones().limpiarTabla();
	}
	
	private void limpiarPaneles()
	{
		this.vista.getPanelClientes().getPanelCrear().getTxtDato1().setText("");
		this.vista.getPanelClientes().getPanelCrear().getTxtDato2().setText("");
		this.vista.getPanelClientes().getPanelCrear().getTxtDato3().setText("");
		this.vista.getPanelClientes().getPanelCrear().getTxtDato5().setText("");
		this.vista.getPanelClientes().getPanelCrear().getTxtDato6().setText("");
		
		this.vista.getPanelProveedores().getPanelCrear().getTxtDato1().setText("");
		this.vista.getPanelProveedores().getPanelCrear().getTxtDato2().setText("");
		this.vista.getPanelProveedores().getPanelCrear().getTxtDato3().setText("");
		this.vista.getPanelProveedores().getPanelCrear().getTxtDato5().setText("");			
		this.vista.getPanelProveedores().getPanelCrear().getTxtDato6().setText("");
		
		this.vista.getPanelProductos().getPanelCrear().getTxtDato1().setText("");
		this.vista.getPanelProductos().getPanelCrear().getTxtDato2().setText("");
		this.vista.getPanelProductos().getPanelCrear().getTxtDato3().setText("");
		this.vista.getPanelProductos().getPanelCrear().getTxtDato5().setText("");			
		this.vista.getPanelProductos().getPanelCrear().getTxtDato6().setText("");
		
		this.vista.getPanelClientes().getPanelActualizar().getTxtBuscar().setText("");
		this.vista.getPanelClientes().getPanelActualizar().getTxtDato1().setText("");
		this.vista.getPanelClientes().getPanelActualizar().getTxtDato2().setText("");
		this.vista.getPanelClientes().getPanelActualizar().getTxtDato3().setText("");
		this.vista.getPanelClientes().getPanelActualizar().getTxtDato5().setText("");
		
		this.vista.getPanelProveedores().getPanelActualizar().getTxtBuscar().setText("");
		this.vista.getPanelProveedores().getPanelActualizar().getTxtDato1().setText("");
		this.vista.getPanelProveedores().getPanelActualizar().getTxtDato2().setText("");
		this.vista.getPanelProveedores().getPanelActualizar().getTxtDato3().setText("");
		this.vista.getPanelProveedores().getPanelActualizar().getTxtDato5().setText("");	
		
		this.vista.getPanelProductos().getPanelActualizar().getTxtBuscar().setText("");
		this.vista.getPanelProductos().getPanelActualizar().getTxtDato1().setText("");
		this.vista.getPanelProductos().getPanelActualizar().getTxtDato2().setText("");
		this.vista.getPanelProductos().getPanelActualizar().getTxtDato3().setText("");
		this.vista.getPanelProductos().getPanelActualizar().getTxtDato5().setText("");	

		this.vista.getPanelVentas().getPanelTransacciones().getTxtBuscar1().setText("");
		this.vista.getPanelVentas().getPanelTransacciones().getTxtBuscar2().setText("");
		this.vista.getPanelVentas().getPanelTransacciones().getTxtCantidad().setText("");
		this.vista.getPanelVentas().getPanelTransacciones().limpiarTabla();
		
		this.vista.getPanelCompras().getPanelTransacciones().getTxtBuscar1().setText("");
		this.vista.getPanelCompras().getPanelTransacciones().getTxtBuscar2().setText("");
		this.vista.getPanelCompras().getPanelTransacciones().getTxtCantidad().setText("");
		this.vista.getPanelCompras().getPanelTransacciones().limpiarTabla();
	}
	
	private void modificarPropiedades()
	{
		this.modelo.setNombreTienda( this.vista.ingresarDato("Ingrese nombre de la tienda") );
		this.modelo.setNombreGerente( this.vista.ingresarDato("Ingrese nombre del gerente de la tienda") );
		this.modelo.setTipoTienda(this.vista.ingresarDato("Ingrese el tipo de tienda") );
		this.modelo.setCiudad( this.vista.ingresarDato("Ingrese la ciudad donde se encuentra la tienda") );
		this.modelo.setNit(Integer.parseInt(this.vista.ingresarDato("Ingrese el NIT de la tienda") ));
		
		this.modelo.getConfiguracion().guardarDatosDefault(this.modelo);
	}
	
	private void configurar()
	{
		this.vista.getVentanConfiguraciones().setVisible(true);
	}
	
	private void listarClientes()
	{
		this.vista.getPanelConsultasYReportes().listarClientes(this.modelo.getClientes());
	}
	
	private void mostrarPropiedaes()
	{
		String nombreTienda = this.modelo.getNombreTienda();
		String nombreGerente = this.modelo.getNombreGerente();
		String tipoTienda = this.modelo.getTipoTienda();
		String ciudad = this.modelo.getCiudad();
		String nit = String.valueOf(this.modelo.getNit());
		this.vista.darMensaje(nombreTienda + "\n" + nombreGerente + "\n" + tipoTienda + "\n" + ciudad + "\n" + nit);
	}
	
	private void configurarBotones()
	{
		this.vista.getPanelClientes().getPanelCrear().getBtnAgregar().setActionCommand(Persistencia.AGREGAR_CLIENTE);
		this.vista.getPanelClientes().getPanelCrear().getBtnAgregar().addActionListener(this);
		this.vista.getPanelClientes().getPanelActualizar().getBtnBuscar().setActionCommand(Persistencia.BUSCAR_CLIENTE);
		this.vista.getPanelClientes().getPanelActualizar().getBtnBuscar().addActionListener(this);
		this.vista.getPanelClientes().getPanelActualizar().getBtnAgregar().setActionCommand(Persistencia.ACTUALIZAR_CLIENTE);
		this.vista.getPanelClientes().getPanelActualizar().getBtnAgregar().addActionListener(this);
		this.vista.getPanelClientes().getPanelInicio().getBtnBorrar().setActionCommand(Persistencia.ELIMINAR_CLIENTE);
		this.vista.getPanelClientes().getPanelInicio().getBtnBorrar().addActionListener(this);
		
		this.vista.getPanelProveedores().getPanelCrear().getBtnAgregar().setActionCommand(Persistencia.AGREGAR_PROVEEDOR);
		this.vista.getPanelProveedores().getPanelCrear().getBtnAgregar().addActionListener(this);
		this.vista.getPanelProveedores().getPanelActualizar().getBtnBuscar().setActionCommand(Persistencia.BUSCAR_PROVEEDOR);
		this.vista.getPanelProveedores().getPanelActualizar().getBtnBuscar().addActionListener(this);
		this.vista.getPanelProveedores().getPanelActualizar().getBtnAgregar().setActionCommand(Persistencia.ACTUALIZAR_PROVEEDOR);
		this.vista.getPanelProveedores().getPanelActualizar().getBtnAgregar().addActionListener(this);
		this.vista.getPanelProveedores().getPanelInicio().getBtnBorrar().setActionCommand(Persistencia.ELIMINAR_PROVEEDOR);
		this.vista.getPanelProveedores().getPanelInicio().getBtnBorrar().addActionListener(this);
		
		this.vista.getPanelProductos().getPanelCrear().getBtnAgregar().setActionCommand(Persistencia.AGREGAR_PRODUCTO);
		this.vista.getPanelProductos().getPanelCrear().getBtnAgregar().addActionListener(this);
		this.vista.getPanelProductos().getPanelActualizar().getBtnBuscar().setActionCommand(Persistencia.BUSCAR_PRODUCTO);
		this.vista.getPanelProductos().getPanelActualizar().getBtnBuscar().addActionListener(this);
		this.vista.getPanelProductos().getPanelActualizar().getBtnAgregar().setActionCommand(Persistencia.ACTUALIZAR_PRODUCTO);
		this.vista.getPanelProductos().getPanelActualizar().getBtnAgregar().addActionListener(this);
		this.vista.getPanelProductos().getPanelInicio().getBtnBorrar().setActionCommand(Persistencia.ELIMINAR_PRODUCTO);
		this.vista.getPanelProductos().getPanelInicio().getBtnBorrar().addActionListener(this);
		
		this.vista.getPanelVentas().getPanelTransacciones().getBtnBuscar1().setActionCommand(Persistencia.VENTAS_BUSCAR_CLIENTE);
		this.vista.getPanelVentas().getPanelTransacciones().getBtnBuscar1().addActionListener(this);	
		this.vista.getPanelVentas().getPanelTransacciones().getBtnBuscar2().setActionCommand(Persistencia.VENTAS_BUSCAR_PRODUCTO);
		this.vista.getPanelVentas().getPanelTransacciones().getBtnBuscar2().addActionListener(this);
		this.vista.getPanelVentas().getPanelTransacciones().getBtnAgregar().setActionCommand(Persistencia.VENTAS_AGREGAR);
		this.vista.getPanelVentas().getPanelTransacciones().getBtnAgregar().addActionListener(this);		
		this.vista.getPanelVentas().getPanelTransacciones().getBtnTotalizar().setActionCommand(Persistencia.VENTAS_TOTALIZAR);
		this.vista.getPanelVentas().getPanelTransacciones().getBtnTotalizar().addActionListener(this);
		
		this.vista.getPanelCompras().getPanelTransacciones().getBtnBuscar1().setActionCommand(Persistencia.COMPRAS_BUSCAR_PROVEEDOR);
		this.vista.getPanelCompras().getPanelTransacciones().getBtnBuscar1().addActionListener(this);	
		this.vista.getPanelCompras().getPanelTransacciones().getBtnBuscar2().setActionCommand(Persistencia.COMPRAS_BUSCAR_PRODUCTO);
		this.vista.getPanelCompras().getPanelTransacciones().getBtnBuscar2().addActionListener(this);
		this.vista.getPanelCompras().getPanelTransacciones().getBtnAgregar().setActionCommand(Persistencia.COMPRAS_AGREGAR);
		this.vista.getPanelCompras().getPanelTransacciones().getBtnAgregar().addActionListener(this);		
		this.vista.getPanelCompras().getPanelTransacciones().getBtnTotalizar().setActionCommand(Persistencia.COMPRAS_TOTALIZAR);
		this.vista.getPanelCompras().getPanelTransacciones().getBtnTotalizar().addActionListener(this);
		
		this.vista.getPanelClientes().getPanelCrear().getBtnCancelar().setActionCommand(Persistencia.LIMPIAR_PANEL);
		this.vista.getPanelClientes().getPanelCrear().getBtnCancelar().addActionListener(this);
		this.vista.getPanelClientes().getPanelActualizar().getBtnCancelar().setActionCommand(Persistencia.LIMPIAR_PANEL);
		this.vista.getPanelClientes().getPanelActualizar().getBtnCancelar().addActionListener(this);
		this.vista.getPanelProveedores().getPanelCrear().getBtnCancelar().setActionCommand(Persistencia.LIMPIAR_PANEL);
		this.vista.getPanelProveedores().getPanelCrear().getBtnCancelar().addActionListener(this);
		this.vista.getPanelProveedores().getPanelActualizar().getBtnCancelar().setActionCommand(Persistencia.LIMPIAR_PANEL);
		this.vista.getPanelProveedores().getPanelActualizar().getBtnCancelar().addActionListener(this);
		this.vista.getPanelProductos().getPanelCrear().getBtnCancelar().setActionCommand(Persistencia.LIMPIAR_PANEL);
		this.vista.getPanelProductos().getPanelCrear().getBtnCancelar().addActionListener(this);
		this.vista.getPanelProductos().getPanelActualizar().getBtnCancelar().setActionCommand(Persistencia.LIMPIAR_PANEL);
		this.vista.getPanelProductos().getPanelActualizar().getBtnCancelar().addActionListener(this);
		
		this.vista.getPanelInicio().getBtnConfigurarParametros().setActionCommand(Persistencia.CONFIGURACION);
		this.vista.getPanelInicio().getBtnConfigurarParametros().addActionListener(this);
		this.vista.getVentanConfiguraciones().getBtnVisualizarPropiedadesDeLaTienda().setActionCommand(Persistencia.VISUALIZAR_PROPIEDADES);
		this.vista.getVentanConfiguraciones().getBtnVisualizarPropiedadesDeLaTienda().addActionListener(this);
		this.vista.getVentanConfiguraciones().getBtnModificarArchivoDePropiedades().setActionCommand(Persistencia.MODIFICAR_PROPIEDADES);
		this.vista.getVentanConfiguraciones().getBtnModificarArchivoDePropiedades().addActionListener(this);
		
		this.vista.getPanelConsultasYReportes().getBtnListadoClientes().setActionCommand(Persistencia.LISTAR_CLIENTES);
		this.vista.getPanelConsultasYReportes().getBtnListadoClientes().addActionListener(this);
		
		this.vista.getPanelInicio().getBtnAyuda().setActionCommand(Persistencia.AYUDA);
		this.vista.getPanelInicio().getBtnAyuda().addActionListener(this);
		this.vista.getPanelClientes().getPanelInicio().getBtnAyuda().setActionCommand(Persistencia.AYUDA);
		this.vista.getPanelClientes().getPanelInicio().getBtnAyuda().addActionListener(this);
		this.vista.getPanelProveedores().getPanelInicio().getBtnAyuda().setActionCommand(Persistencia.AYUDA);
		this.vista.getPanelProveedores().getPanelInicio().getBtnAyuda().addActionListener(this);
		this.vista.getPanelProductos().getPanelInicio().getBtnAyuda().setActionCommand(Persistencia.AYUDA);
		this.vista.getPanelProductos().getPanelInicio().getBtnAyuda().addActionListener(this);
		
		
		
	}
	
	
}

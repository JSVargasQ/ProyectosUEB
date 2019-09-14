package vista;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;

public class VentanaPrincipal extends JFrame
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	private JTabbedPane pestañas;
	
	private PestañaInicio panelInicio;
	private PestañaClientes panelClientes;
	private PestañaProveedores panelProveedores;
	private PestañaProductos panelProductos;
	private PestañaVentas panelVentas;
	private PestañaCompras panelCompras;
	private PestañaConsultasYReportes panelConsultasYReportes;
	
	private VentanaConfiguraciones ventanConfiguraciones;
	
	
	
	public VentanaPrincipal()
	{
		
		setTitle("Tienda generica");
		setSize(700, 700);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setIconImage(new ImageIcon("Imagenes/Inicio icono.png").getImage());
		
		pestañas = new JTabbedPane();
		
		panelInicio = new PestañaInicio();
		panelClientes = new PestañaClientes();
		panelProveedores = new PestañaProveedores();
		panelProductos = new PestañaProductos();
		panelVentas = new PestañaVentas();
		panelCompras = new PestañaCompras();
		panelConsultasYReportes = new PestañaConsultasYReportes();
		
		ventanConfiguraciones = new VentanaConfiguraciones();
		
		pestañas.addTab("Inicio", panelInicio);	
		pestañas.addTab("Clientes", panelClientes);
		pestañas.addTab("Proveedores", panelProveedores);
		pestañas.addTab("Productos", panelProductos);
		pestañas.addTab("Ventas", panelVentas);
		pestañas.addTab("Compras", panelCompras);
		pestañas.addTab("Consultas y reportes", panelConsultasYReportes);
		
		getContentPane().add(pestañas);
	
		setVisible(true);
		
	}

	public void darMensaje(String pMensaje)
	{
		JOptionPane.showMessageDialog(null, pMensaje);
	}
	
	public void darMensajeError(String pMensaje)
	{
		JOptionPane.showMessageDialog(null, pMensaje, "ERROR", JOptionPane.ERROR_MESSAGE);
	}
	
	public String ingresarDato(String pMensaje)
	{
		return JOptionPane.showInputDialog(null, pMensaje);
	}
	
	public int escogerOpcion(String pMensaje, String[] pOpciones)
	{
		return JOptionPane.showOptionDialog(null, pMensaje, "Escoger Opción", JOptionPane.PLAIN_MESSAGE, JOptionPane.PLAIN_MESSAGE, null, pOpciones, pOpciones[0]);
	}
	
	public int escogerOpcion(String pMensaje, String pTitulo)
	{
		return JOptionPane.showConfirmDialog(null, pMensaje, pTitulo, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
	}
	
	public void darMensajeAyuda()
	{
		JOptionPane.showMessageDialog(null, "- Arriba encontraras las pestañas de cada área que podras manejar.\n\n- Cada pestaña cuenta con tres paneles: Inicio, Crear y Actualizar\n\n- Al final estan las pestañas de \"Ventas\", \"Compras\", allí llena los datos de\n arriba hacia abajo, izquierda - derecha ", "Ayuda", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public JTabbedPane getPestañas()
	{
		return pestañas;
	}

	public PestañaInicio getPanelInicio() 
	{
		return panelInicio;
	}

	public PestañaClientes getPanelClientes()
	{
		return panelClientes;
	}

	public PestañaProveedores getPanelProveedores()
	{
		return panelProveedores;
	}

	public PestañaProductos getPanelProductos()
	{
		return panelProductos;
	}

	public PestañaVentas getPanelVentas()
	{
		return panelVentas;
	}

	public PestañaCompras getPanelCompras() 
	{
		return panelCompras;
	}

	public PestañaConsultasYReportes getPanelConsultasYReportes() 
	{
		return panelConsultasYReportes;
	}

	public VentanaConfiguraciones getVentanConfiguraciones() 
	{
		return ventanConfiguraciones;
	}
	
	
	
	
	
	
}

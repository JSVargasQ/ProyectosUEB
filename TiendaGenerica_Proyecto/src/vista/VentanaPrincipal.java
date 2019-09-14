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
	

	private JTabbedPane pesta�as;
	
	private Pesta�aInicio panelInicio;
	private Pesta�aClientes panelClientes;
	private Pesta�aProveedores panelProveedores;
	private Pesta�aProductos panelProductos;
	private Pesta�aVentas panelVentas;
	private Pesta�aCompras panelCompras;
	private Pesta�aConsultasYReportes panelConsultasYReportes;
	
	private VentanaConfiguraciones ventanConfiguraciones;
	
	
	
	public VentanaPrincipal()
	{
		
		setTitle("Tienda generica");
		setSize(700, 700);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setIconImage(new ImageIcon("Imagenes/Inicio icono.png").getImage());
		
		pesta�as = new JTabbedPane();
		
		panelInicio = new Pesta�aInicio();
		panelClientes = new Pesta�aClientes();
		panelProveedores = new Pesta�aProveedores();
		panelProductos = new Pesta�aProductos();
		panelVentas = new Pesta�aVentas();
		panelCompras = new Pesta�aCompras();
		panelConsultasYReportes = new Pesta�aConsultasYReportes();
		
		ventanConfiguraciones = new VentanaConfiguraciones();
		
		pesta�as.addTab("Inicio", panelInicio);	
		pesta�as.addTab("Clientes", panelClientes);
		pesta�as.addTab("Proveedores", panelProveedores);
		pesta�as.addTab("Productos", panelProductos);
		pesta�as.addTab("Ventas", panelVentas);
		pesta�as.addTab("Compras", panelCompras);
		pesta�as.addTab("Consultas y reportes", panelConsultasYReportes);
		
		getContentPane().add(pesta�as);
	
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
		return JOptionPane.showOptionDialog(null, pMensaje, "Escoger Opci�n", JOptionPane.PLAIN_MESSAGE, JOptionPane.PLAIN_MESSAGE, null, pOpciones, pOpciones[0]);
	}
	
	public int escogerOpcion(String pMensaje, String pTitulo)
	{
		return JOptionPane.showConfirmDialog(null, pMensaje, pTitulo, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
	}
	
	public void darMensajeAyuda()
	{
		JOptionPane.showMessageDialog(null, "- Arriba encontraras las pesta�as de cada �rea que podras manejar.\n\n- Cada pesta�a cuenta con tres paneles: Inicio, Crear y Actualizar\n\n- Al final estan las pesta�as de \"Ventas\", \"Compras\", all� llena los datos de\n arriba hacia abajo, izquierda - derecha ", "Ayuda", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public JTabbedPane getPesta�as()
	{
		return pesta�as;
	}

	public Pesta�aInicio getPanelInicio() 
	{
		return panelInicio;
	}

	public Pesta�aClientes getPanelClientes()
	{
		return panelClientes;
	}

	public Pesta�aProveedores getPanelProveedores()
	{
		return panelProveedores;
	}

	public Pesta�aProductos getPanelProductos()
	{
		return panelProductos;
	}

	public Pesta�aVentas getPanelVentas()
	{
		return panelVentas;
	}

	public Pesta�aCompras getPanelCompras() 
	{
		return panelCompras;
	}

	public Pesta�aConsultasYReportes getPanelConsultasYReportes() 
	{
		return panelConsultasYReportes;
	}

	public VentanaConfiguraciones getVentanConfiguraciones() 
	{
		return ventanConfiguraciones;
	}
	
	
	
	
	
	
}

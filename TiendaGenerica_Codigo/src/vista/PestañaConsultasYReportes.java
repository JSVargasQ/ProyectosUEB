package vista;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SpringLayout;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import modelo.Cliente;

public class PestañaConsultasYReportes extends JPanel
{	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	private JFreeChart grafico;

	DefaultCategoryDataset datos;

	private JLabel labImagenConsultasYReportes;

	private JButton btnListadoClientes;
	private JButton btnTotalDeVentasPorCliente;
	private JButton btnDetalleVentasPorCliente;
	private JButton btnTotalDeComprasPorProveedor;
	private JButton btnDetalleDeChequesExpedidos;
	private JButton btnGenerarGrafico;

	private JLabel labListadoClientes;
	private JLabel labTotalDeVentasPorCliente;
	private JLabel labDetalleVentasPorCliente;
	private JLabel labTotalDeComprasPorProveedor;
	private JLabel labDetalleDeChequesExpedidos;
	private JLabel labGraficoVentaDeProductos;

	private JPanel panelImagen;
	private JPanel panelConsultasYReportes;
	private JPanel panelBotones;

	public PestañaConsultasYReportes()
	{

		setBorder(new TitledBorder("Consultas y reportes"));
		setLayout(new GridLayout(3,1));

		elaborarPanelImagen();
		elaborarPanelConsultasYReportes();
		elaborarPanelBotones();

		add(panelImagen);
		add(panelConsultasYReportes);
		add(panelBotones);
	}

	public void elaborarPanelImagen()
	{

		panelImagen = new JPanel();
		SpringLayout layout = new SpringLayout();
		panelImagen.setLayout(layout);

		labImagenConsultasYReportes = new JLabel();
		labImagenConsultasYReportes.setBounds(0, 0, 480, 160);
		ImageIcon imagenConsultasYReportes = new ImageIcon("Imagenes/Banner consultas y reportes.png");
		Icon iconoConsultasYReportes = new ImageIcon(imagenConsultasYReportes.getImage().getScaledInstance(labImagenConsultasYReportes.getWidth(), labImagenConsultasYReportes.getHeight(), Image.SCALE_DEFAULT));
		labImagenConsultasYReportes.setIcon(iconoConsultasYReportes);
		labImagenConsultasYReportes.setHorizontalAlignment(JLabel.CENTER);
		labImagenConsultasYReportes.setVerticalAlignment(JLabel.CENTER);

		panelImagen.add(labImagenConsultasYReportes);

		layout.putConstraint(SpringLayout.WEST, labImagenConsultasYReportes, panelImagen.getWidth(), SpringLayout.WEST, panelImagen);		
		layout.putConstraint(SpringLayout.EAST, labImagenConsultasYReportes, panelImagen.getWidth(), SpringLayout.EAST, panelImagen);
		layout.putConstraint(SpringLayout.NORTH, labImagenConsultasYReportes, 0, SpringLayout.NORTH, panelImagen);
		layout.putConstraint(SpringLayout.SOUTH, labImagenConsultasYReportes, 180, SpringLayout.NORTH, panelImagen);
	}

	public void elaborarPanelConsultasYReportes()
	{

		panelConsultasYReportes = new JPanel();
		SpringLayout layout = new SpringLayout();
		panelConsultasYReportes.setLayout(layout);

		labListadoClientes = new JLabel("Listado de clientes");
		labListadoClientes.setFont(new Font("Rockwell", Font.ROMAN_BASELINE, 20));

		labTotalDeVentasPorCliente = new JLabel("Total de ventas por cliente");
		labTotalDeVentasPorCliente.setFont(new Font("Rockwell", Font.ROMAN_BASELINE, 20));

		labDetalleVentasPorCliente = new JLabel("Detalle de venta por cliente");
		labDetalleVentasPorCliente.setFont(new Font("Rockwell", Font.ROMAN_BASELINE, 20));

		labTotalDeComprasPorProveedor = new JLabel("Total de compras por proveedor");
		labTotalDeComprasPorProveedor.setFont(new Font("Rockwell", Font.ROMAN_BASELINE, 20));

		labDetalleDeChequesExpedidos = new JLabel("Detalle de cheques expedidos");
		labDetalleDeChequesExpedidos.setFont(new Font("Rockwell", Font.ROMAN_BASELINE, 20));

		btnListadoClientes = new JButton("Generar reporte");

		btnTotalDeVentasPorCliente = new JButton("Generar reporte");

		btnDetalleVentasPorCliente = new JButton("Generar reporte");

		btnTotalDeComprasPorProveedor = new JButton("Generar reporte");

		btnDetalleDeChequesExpedidos = new JButton("Generar reporte");

		panelConsultasYReportes.add(labListadoClientes);
		panelConsultasYReportes.add(labTotalDeVentasPorCliente);
		panelConsultasYReportes.add(labDetalleVentasPorCliente);
		panelConsultasYReportes.add(labTotalDeComprasPorProveedor);
		panelConsultasYReportes.add(labDetalleDeChequesExpedidos);
		
		panelConsultasYReportes.add(btnListadoClientes);
		panelConsultasYReportes.add(btnTotalDeVentasPorCliente);
		panelConsultasYReportes.add(btnDetalleVentasPorCliente);
		panelConsultasYReportes.add(btnTotalDeComprasPorProveedor);
		panelConsultasYReportes.add(btnDetalleDeChequesExpedidos);

		layout.putConstraint(SpringLayout.WEST, labListadoClientes, 120, SpringLayout.WEST, panelConsultasYReportes);
		layout.putConstraint(SpringLayout.EAST, labListadoClientes, 30, SpringLayout.HORIZONTAL_CENTER, panelConsultasYReportes);
		layout.putConstraint(SpringLayout.NORTH, labListadoClientes, 0, SpringLayout.NORTH, panelConsultasYReportes);
		layout.putConstraint(SpringLayout.SOUTH, labListadoClientes, 30, SpringLayout.NORTH, panelConsultasYReportes);

		layout.putConstraint(SpringLayout.WEST, labTotalDeVentasPorCliente, 120, SpringLayout.WEST, panelConsultasYReportes);
		layout.putConstraint(SpringLayout.EAST, labTotalDeVentasPorCliente, 30, SpringLayout.HORIZONTAL_CENTER, panelConsultasYReportes);
		layout.putConstraint(SpringLayout.NORTH, labTotalDeVentasPorCliente, 10, SpringLayout.SOUTH, labListadoClientes);
		layout.putConstraint(SpringLayout.SOUTH, labTotalDeVentasPorCliente, 40, SpringLayout.NORTH, labTotalDeVentasPorCliente);

		layout.putConstraint(SpringLayout.WEST, labDetalleVentasPorCliente, 120, SpringLayout.WEST, panelConsultasYReportes);
		layout.putConstraint(SpringLayout.EAST, labDetalleVentasPorCliente, 30, SpringLayout.HORIZONTAL_CENTER, panelConsultasYReportes);
		layout.putConstraint(SpringLayout.NORTH, labDetalleVentasPorCliente, 10, SpringLayout.SOUTH, labTotalDeVentasPorCliente);
		layout.putConstraint(SpringLayout.SOUTH, labDetalleVentasPorCliente, 40, SpringLayout.NORTH, labDetalleVentasPorCliente);

		layout.putConstraint(SpringLayout.WEST, labTotalDeComprasPorProveedor, 120, SpringLayout.WEST, panelConsultasYReportes);
		layout.putConstraint(SpringLayout.EAST, labTotalDeComprasPorProveedor, 30, SpringLayout.HORIZONTAL_CENTER, panelConsultasYReportes);
		layout.putConstraint(SpringLayout.NORTH, labTotalDeComprasPorProveedor, 10, SpringLayout.SOUTH, labDetalleVentasPorCliente);
		layout.putConstraint(SpringLayout.SOUTH, labTotalDeComprasPorProveedor, 40, SpringLayout.NORTH, labTotalDeComprasPorProveedor);

		layout.putConstraint(SpringLayout.WEST, labDetalleDeChequesExpedidos, 120, SpringLayout.WEST, panelConsultasYReportes);
		layout.putConstraint(SpringLayout.EAST, labDetalleDeChequesExpedidos, 30, SpringLayout.HORIZONTAL_CENTER, panelConsultasYReportes);
		layout.putConstraint(SpringLayout.NORTH, labDetalleDeChequesExpedidos, 10, SpringLayout.SOUTH, labTotalDeComprasPorProveedor);
		layout.putConstraint(SpringLayout.SOUTH, labDetalleDeChequesExpedidos, 40, SpringLayout.NORTH, labDetalleDeChequesExpedidos);
		
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, btnListadoClientes, 310, SpringLayout.HORIZONTAL_CENTER, labListadoClientes);
		layout.putConstraint(SpringLayout.NORTH, btnListadoClientes, 0, SpringLayout.NORTH, panelConsultasYReportes);
		layout.putConstraint(SpringLayout.SOUTH, btnListadoClientes, 30, SpringLayout.NORTH, panelConsultasYReportes);
		
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, btnTotalDeVentasPorCliente, 310, SpringLayout.HORIZONTAL_CENTER, labListadoClientes);
		layout.putConstraint(SpringLayout.NORTH, btnTotalDeVentasPorCliente, 20, SpringLayout.SOUTH, btnListadoClientes);
		layout.putConstraint(SpringLayout.SOUTH, btnTotalDeVentasPorCliente, 50, SpringLayout.SOUTH, btnListadoClientes);
		
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, btnDetalleVentasPorCliente, 310, SpringLayout.HORIZONTAL_CENTER, labListadoClientes);
		layout.putConstraint(SpringLayout.NORTH, btnDetalleVentasPorCliente, 20, SpringLayout.SOUTH, btnTotalDeVentasPorCliente);
		layout.putConstraint(SpringLayout.SOUTH, btnDetalleVentasPorCliente, 50, SpringLayout.SOUTH, btnTotalDeVentasPorCliente);
		
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, btnTotalDeComprasPorProveedor, 310, SpringLayout.HORIZONTAL_CENTER, labListadoClientes);
		layout.putConstraint(SpringLayout.NORTH, btnTotalDeComprasPorProveedor, 20, SpringLayout.SOUTH, btnDetalleVentasPorCliente);
		layout.putConstraint(SpringLayout.SOUTH, btnTotalDeComprasPorProveedor, 50, SpringLayout.SOUTH, btnDetalleVentasPorCliente);
		
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, btnDetalleDeChequesExpedidos, 310, SpringLayout.HORIZONTAL_CENTER, labListadoClientes);
		layout.putConstraint(SpringLayout.NORTH, btnDetalleDeChequesExpedidos, 20, SpringLayout.SOUTH, btnTotalDeComprasPorProveedor);
		layout.putConstraint(SpringLayout.SOUTH, btnDetalleDeChequesExpedidos, 50, SpringLayout.SOUTH, btnTotalDeComprasPorProveedor);
	}
	
	public void elaborarPanelBotones()
	{
		
		panelBotones = new JPanel();
		SpringLayout layout = new SpringLayout();
		panelBotones.setLayout(layout);

		labGraficoVentaDeProductos = new JLabel("Generar grafico de la venta de cada producto");
		labGraficoVentaDeProductos.setFont(new Font("Rockwell", Font.ROMAN_BASELINE, 20));
		
		btnGenerarGrafico = new JButton("Generar grafico");
		
		panelBotones.add(btnGenerarGrafico);
		panelBotones.add(labGraficoVentaDeProductos);
		
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, labGraficoVentaDeProductos, 0, SpringLayout.HORIZONTAL_CENTER, panelBotones);		
		layout.putConstraint(SpringLayout.NORTH, labGraficoVentaDeProductos, 50, SpringLayout.NORTH, panelBotones);
		layout.putConstraint(SpringLayout.SOUTH, labGraficoVentaDeProductos, 90, SpringLayout.NORTH, panelBotones);
		
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, btnGenerarGrafico, 0, SpringLayout.HORIZONTAL_CENTER, panelBotones);		
		layout.putConstraint(SpringLayout.NORTH, btnGenerarGrafico, 110, SpringLayout.NORTH, panelBotones);
		layout.putConstraint(SpringLayout.SOUTH, btnGenerarGrafico, 150, SpringLayout.NORTH, panelBotones);
	}

	public void elaborarGrafico()
	{
		datos = new DefaultCategoryDataset();

		grafico = ChartFactory.createBarChart("Ventas por producto", "Productos", "Número de ventas", datos, PlotOrientation.HORIZONTAL, true, true, false);

		ChartPanel PanelGrafico = new ChartPanel(grafico);
		JFrame VentanaGrafico = new JFrame("JFreeChart");
		VentanaGrafico.getContentPane().add(PanelGrafico);
		VentanaGrafico.pack();
		VentanaGrafico.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		VentanaGrafico.setVisible(true);
	}

	public void listarClientes(ArrayList<Cliente> pClientes)
	{
		DefaultTableModel datosTablaClientes = new DefaultTableModel();
		JTable tablaClientes = new JTable(datosTablaClientes);
		datosTablaClientes.addColumn("Nombre");
		datosTablaClientes.addColumn("Cedula");
		datosTablaClientes.addColumn("Telefono");
		datosTablaClientes.addColumn("Genero");		
		datosTablaClientes.addColumn("Correo");
		datosTablaClientes.addColumn("Direccion");;
		
		for (int i = 0; i < pClientes.size(); i++) 
		{
			String[] datosFila = new String[6];			
			
			datosFila[0] = pClientes.get(i).getNombre();
			datosFila[1] = String.valueOf(pClientes.get(i).getCedula());
			datosFila[2] = String.valueOf(pClientes.get(i).getTelefono());
			datosFila[3] = pClientes.get(i).getGenero();
			datosFila[4] = pClientes.get(i).getCorreoElectronico();
			datosFila[5] = pClientes.get(i).getDireccion();
		
			datosTablaClientes.addRow(datosFila);
		}
		
		JScrollPane desplazar = new JScrollPane(tablaClientes);
		JOptionPane.showMessageDialog(null, desplazar);
	}
	
	public void totalVentasCliente()
	{
		
	}
	
	public JButton getBtnListadoClientes() {
		return btnListadoClientes;
	}

	public JButton getBtnTotalDeVentasPorCliente() {
		return btnTotalDeVentasPorCliente;
	}

	public JButton getBtnDetalleVentasPorCliente() {
		return btnDetalleVentasPorCliente;
	}

	public JButton getBtnTotalDeComprasPorProveedor() {
		return btnTotalDeComprasPorProveedor;
	}

	public JButton getBtnDetalleDeChequesExpedidos() {
		return btnDetalleDeChequesExpedidos;
	}

	public JButton getBtnGenerarGrafico() {
		return btnGenerarGrafico;
	}
	
	
}

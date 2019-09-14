package vista;

import java.awt.Font;
import java.awt.GridLayout;
import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import org.jdesktop.swingx.prompt.PromptSupport;

import modelo.CuotaMensual;

public class PanelTransacciones extends JPanel
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private JLabel labDato1;
	private JLabel labDato2;
	private JLabel labDato3;
	private JLabel labDato4;

	private JTextField txtBuscar1;
	private JTextField txtBuscar2;
	private JTextField txtCantidad;

	private JButton btnBuscar1;
	private JButton btnBuscar2;
	private JButton btnAgregar;
	private JButton btnListaElementos;
	private JButton btnTotalizar;

	private DefaultTableModel datos;
	private JTable tabla;

	private JPanel panelTransaccion;

	public PanelTransacciones(String pTxtBuscar1, String pTxtBuscar2, String pTxtCantidad)
	{

		setLayout(new GridLayout(1,1));

		elaborarPanelInformacion(pTxtBuscar1, pTxtBuscar2, pTxtCantidad);

		add(panelTransaccion);
	}

	public void elaborarPanelInformacion(String pTxtBuscar1, String pTxtBuscar2, String pTxtCantidad)
	{

		panelTransaccion = new JPanel();
		SpringLayout layout = new SpringLayout();
		panelTransaccion.setLayout(layout);

		txtBuscar1 = new JTextField();
		PromptSupport.setPrompt(pTxtBuscar1, txtBuscar1);

		btnBuscar1 = new JButton("Buscar");

		panelTransaccion.add(txtBuscar1);
		panelTransaccion.add(btnBuscar1);

		layout.putConstraint(SpringLayout.WEST, txtBuscar1, 30, SpringLayout.WEST, panelTransaccion);
		layout.putConstraint(SpringLayout.EAST, txtBuscar1, 660, SpringLayout.WEST, panelTransaccion);
		layout.putConstraint(SpringLayout.NORTH, txtBuscar1, 10, SpringLayout.NORTH, panelTransaccion);
		layout.putConstraint(SpringLayout.SOUTH, txtBuscar1, 40, SpringLayout.NORTH, panelTransaccion);

		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, btnBuscar1, 320, SpringLayout.HORIZONTAL_CENTER, panelTransaccion);
		layout.putConstraint(SpringLayout.NORTH, btnBuscar1, 10, SpringLayout.NORTH, panelTransaccion);
		layout.putConstraint(SpringLayout.SOUTH, btnBuscar1, 40, SpringLayout.NORTH, panelTransaccion);

		labDato1 = new JLabel();
		labDato1.setFont(new Font("Rockwell", Font.ROMAN_BASELINE, 20)); 
		labDato1.setHorizontalAlignment(JLabel.CENTER);

		labDato2 = new JLabel();
		labDato2.setFont(new Font("Rockwell", Font.ROMAN_BASELINE, 20));
		labDato2.setHorizontalAlignment(JLabel.CENTER);

		labDato3 = new JLabel();
		labDato3.setFont(new Font("Rockwell", Font.ROMAN_BASELINE, 20)); 
		labDato3.setHorizontalAlignment(JLabel.CENTER);

		labDato4 = new JLabel();
		labDato4.setFont(new Font("Rockwell", Font.ROMAN_BASELINE, 20)); 
		labDato4.setHorizontalAlignment(JLabel.CENTER);

		panelTransaccion.add(labDato1);
		panelTransaccion.add(labDato2);
		panelTransaccion.add(labDato3);
		panelTransaccion.add(labDato4);

		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, labDato1, 0, SpringLayout.HORIZONTAL_CENTER, panelTransaccion);
		layout.putConstraint(SpringLayout.NORTH, labDato1, 60, SpringLayout.NORTH, panelTransaccion);
		layout.putConstraint(SpringLayout.SOUTH, labDato1, 100, SpringLayout.NORTH, panelTransaccion);

		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, labDato2, -300, SpringLayout.HORIZONTAL_CENTER, panelTransaccion);
		layout.putConstraint(SpringLayout.NORTH, labDato2, 110, SpringLayout.NORTH, panelTransaccion);
		layout.putConstraint(SpringLayout.SOUTH, labDato2, 150, SpringLayout.NORTH, panelTransaccion);

		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, labDato3, 0, SpringLayout.HORIZONTAL_CENTER, panelTransaccion);
		layout.putConstraint(SpringLayout.NORTH, labDato3, 110, SpringLayout.NORTH, panelTransaccion);
		layout.putConstraint(SpringLayout.SOUTH, labDato3, 150, SpringLayout.NORTH, panelTransaccion);

		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, labDato4, 300, SpringLayout.HORIZONTAL_CENTER, panelTransaccion);
		layout.putConstraint(SpringLayout.NORTH, labDato4, 110, SpringLayout.NORTH, panelTransaccion);
		layout.putConstraint(SpringLayout.SOUTH, labDato4, 150, SpringLayout.NORTH, panelTransaccion);

		txtBuscar2 = new JTextField();
		PromptSupport.setPrompt(pTxtBuscar2, txtBuscar2);

		btnBuscar2 = new JButton("Buscar producto");

		txtCantidad = new JTextField();
		PromptSupport.setPrompt(pTxtCantidad, txtCantidad);

		btnAgregar = new JButton("Agregar");
		btnAgregar.setEnabled(false);

		btnListaElementos = new JButton("Codigo de productos");

		panelTransaccion.add(txtBuscar2);
		panelTransaccion.add(btnBuscar2);
		panelTransaccion.add(txtCantidad);
		panelTransaccion.add(btnAgregar);
		panelTransaccion.add(btnListaElementos);

		layout.putConstraint(SpringLayout.WEST, txtBuscar2, 30, SpringLayout.WEST, panelTransaccion);
		layout.putConstraint(SpringLayout.EAST, txtBuscar2, 250, SpringLayout.WEST, panelTransaccion);
		layout.putConstraint(SpringLayout.NORTH, txtBuscar2, 170, SpringLayout.NORTH, panelTransaccion);
		layout.putConstraint(SpringLayout.SOUTH, txtBuscar2, 200, SpringLayout.NORTH, panelTransaccion);

		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, btnBuscar2, -60, SpringLayout.HORIZONTAL_CENTER, panelTransaccion);
		layout.putConstraint(SpringLayout.NORTH, btnBuscar2, 170, SpringLayout.NORTH, panelTransaccion);
		layout.putConstraint(SpringLayout.SOUTH, btnBuscar2, 200, SpringLayout.NORTH, panelTransaccion);

		layout.putConstraint(SpringLayout.WEST, txtCantidad, 410, SpringLayout.WEST, panelTransaccion);
		layout.putConstraint(SpringLayout.EAST, txtCantidad, 630, SpringLayout.WEST, panelTransaccion);
		layout.putConstraint(SpringLayout.NORTH, txtCantidad, 170, SpringLayout.NORTH, panelTransaccion);
		layout.putConstraint(SpringLayout.SOUTH, txtCantidad, 200, SpringLayout.NORTH, panelTransaccion);

		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, btnAgregar, 295, SpringLayout.HORIZONTAL_CENTER, panelTransaccion);
		layout.putConstraint(SpringLayout.NORTH, btnAgregar, 170, SpringLayout.NORTH, panelTransaccion);
		layout.putConstraint(SpringLayout.SOUTH, btnAgregar, 200, SpringLayout.NORTH, panelTransaccion);

		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, btnListaElementos, 0, SpringLayout.HORIZONTAL_CENTER, panelTransaccion);
		layout.putConstraint(SpringLayout.NORTH, btnListaElementos, 220, SpringLayout.NORTH, panelTransaccion);
		layout.putConstraint(SpringLayout.SOUTH, btnListaElementos, 250, SpringLayout.NORTH, panelTransaccion);

		datos = new DefaultTableModel();
		tabla = new JTable(datos);
		tabla.setBounds(0, 0,400,600);     

		datos.addColumn (1);
		datos.addColumn (2);
		datos.addColumn (3);
		datos.addColumn (4);
		datos.addColumn (5);

		String [] nombreColumnas = {"Codigo del producto", "Nombre del producto", "Cantidad", "Valor unitario", "Valor total"};

		datos.addRow(nombreColumnas);

		DefaultTableCellRenderer centrado = new DefaultTableCellRenderer();
		centrado.setHorizontalAlignment(SwingConstants.CENTER);
		tabla.getColumnModel().getColumn(0).setCellRenderer(centrado);

		centrado.setHorizontalAlignment(SwingConstants.CENTER);
		tabla.getColumnModel().getColumn(1).setCellRenderer(centrado);

		centrado.setHorizontalAlignment(SwingConstants.CENTER);
		tabla.getColumnModel().getColumn(2).setCellRenderer(centrado);

		centrado.setHorizontalAlignment(SwingConstants.CENTER);
		tabla.getColumnModel().getColumn(3).setCellRenderer(centrado);

		centrado.setHorizontalAlignment(SwingConstants.CENTER);
		tabla.getColumnModel().getColumn(4).setCellRenderer(centrado);

		tabla.setEnabled(false);
		panelTransaccion.add(tabla);

		layout.putConstraint(SpringLayout.WEST, tabla, panelTransaccion.getWidth(), SpringLayout.WEST, panelTransaccion);
		layout.putConstraint(SpringLayout.EAST, tabla, panelTransaccion.getWidth(), SpringLayout.EAST, panelTransaccion);
		layout.putConstraint(SpringLayout.NORTH, tabla, 270, SpringLayout.NORTH, panelTransaccion);
		layout.putConstraint(SpringLayout.SOUTH, tabla, 650, SpringLayout.NORTH, panelTransaccion);

		btnTotalizar = new JButton("Finalizar transacción");

		panelTransaccion.add(btnTotalizar);
		
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, btnTotalizar, 0, SpringLayout.HORIZONTAL_CENTER, panelTransaccion);
		layout.putConstraint(SpringLayout.NORTH, btnTotalizar, 670, SpringLayout.NORTH, panelTransaccion);
		layout.putConstraint(SpringLayout.SOUTH, btnTotalizar, 700, SpringLayout.NORTH, panelTransaccion);
	
	}

	public void agregarProductoTabla(String[] datosFila)
	{	
		datos.addRow(datosFila);
	}
	
	public void eliminarFila(int pNumeroFila)
	{
		datos.removeRow(pNumeroFila);
	}
	
	public void modificarFila(String pDato, int pFila, int pColumna)
	{
		datos.setValueAt(pDato, pFila, pColumna);
	}
	
	public int mostrarCredito(CuotaMensual[] pTablaAmortizacion)
	{	
		DefaultTableModel datosTablaAmortizacion = new DefaultTableModel();
		JTable tablaAmortizacion = new JTable(datosTablaAmortizacion);
		datosTablaAmortizacion.addColumn(1);
		datosTablaAmortizacion.addColumn(2);
		datosTablaAmortizacion.addColumn(3);
		datosTablaAmortizacion.addColumn(4);		
		datosTablaAmortizacion.addColumn(5);
		
		String[] encabezadoColumnas = {"Num Cuota", "Saldo", "Cuota", "Interes", "Amortizacion"};
		datosTablaAmortizacion.addRow(encabezadoColumnas);
		
		for (int i = 0; i < pTablaAmortizacion.length; i++) 
		{
			CuotaMensual actual = pTablaAmortizacion[i];
			String[] datosFila = new String[5];			
			DecimalFormat df = new DecimalFormat("#,###,###");
			
			datosFila[0] = String.valueOf(actual.getNumeroCuota());
			datosFila[1] = String.format(df.format(actual.getSaldo()));
			datosFila[2] = String.format(df.format(actual.getCuota()));
			datosFila[3] = String.valueOf(df.format(actual.getInteres())); 
			datosFila[4] = String.valueOf(df.format(actual.getAmortizacion()));
			
			datosTablaAmortizacion.addRow(datosFila);
		}
		
		tabla.add(tablaAmortizacion);		
		tabla.setVisible(true);
		
		JScrollPane desplazar = new JScrollPane(tablaAmortizacion);
		return JOptionPane.showConfirmDialog(null, desplazar, "¿Desea confirmar su credito?", JOptionPane.YES_NO_OPTION);
		
	}
	
	public void limpiarTabla()
	{
		for(int i = 0; i < datos.getRowCount(); i++) 
		{
			this.datos.removeRow(i);
			i--;
		}
		
		String [] nombreColumnas = {"Codigo del producto", "Nombre del producto", "Cantidad", "Valor unitario", "Valor total"};
		datos.addRow(nombreColumnas);
	}
	
	public JTextField getTxtBuscar1() 
	{
		return txtBuscar1;
	}

	public JTextField getTxtBuscar2()
	{
		return txtBuscar2;
	}

	public JTextField getTxtCantidad() 
	{
		return txtCantidad;
	}

	public JButton getBtnBuscar1()
	{
		return btnBuscar1;
	}

	public JButton getBtnBuscar2()
	{
		return btnBuscar2;
	}

	public JButton getBtnAgregar() 
	{
		return btnAgregar;
	}

	public JButton getBtnListaElementos() 
	{
		return btnListaElementos;
	}

	public JButton getBtnTotalizar()
	{
		return btnTotalizar;
	}

	public JLabel getLabDato1()
	{
		return labDato1;
	}

	public JLabel getLabDato2() 
	{
		return labDato2;
	}

	public JLabel getLabDato3() 
	{
		return labDato3;
	}

	public JLabel getLabDato4() 
	{
		return labDato4;
	}

	public DefaultTableModel getDatos()
	{
		return datos;
	}

	public JTable getTabla() 
	{
		return tabla;
	}
	
	
	
	
	
}

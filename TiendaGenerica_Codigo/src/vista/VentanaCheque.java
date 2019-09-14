package vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

public class VentanaCheque extends JFrame
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private JLabel labFija1;
	private JLabel labFija2;
	private JLabel labConsecutivoCheque;
	private JLabel labFija3;
	private JLabel labValorCifra;
	private JLabel labFija4;
	private JLabel labValorMontoEscrito;
	private JLabel labFija5;
	private JLabel labNombre;
	private JLabel labFija6;
	private JLabel labNombreProveedor;
	private JLabel labNombreBanco;
	private JLabel labFija7;
	private JLabel labNumeroDeCuenta;
	private JLabel labSelloDeSeguridad;

	private JPanel panelCheque;

	public VentanaCheque()
	{

		setTitle("Cheque");
		setSize(1400, 500);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		
		setLayout(new GridLayout(1,1));		

		elaborarPanelCheque();
		
		add(panelCheque);
		
		setVisible(false);
	}

	public void elaborarPanelCheque()
	{
		
		panelCheque = new JPanel();
		panelCheque.setBackground(new Color(179, 255, 179));
		SpringLayout layout = new SpringLayout();
		panelCheque.setLayout(layout);

		labFija1 = new JLabel("Dia / Mes / Año");
		labFija1.setFont(new Font("Rockwell", Font.ROMAN_BASELINE, 25));

		Calendar calendario = new GregorianCalendar();

		String año = Integer.toString(calendario.get(Calendar.YEAR));
		String mes = Integer.toString(calendario.get(Calendar.MONTH));
		String dia = Integer.toString(calendario.get(Calendar.DAY_OF_MONTH));

		labFija2 = new JLabel();
		labFija2.setFont(new Font("Rockwell", Font.ROMAN_BASELINE, 25));
		labFija2.setText(dia + " / " + mes + " / " + año);
		
		labConsecutivoCheque = new JLabel();
		labConsecutivoCheque.setFont(new Font("Rockwell", Font.ROMAN_BASELINE, 25));
		
		labFija3 = new JLabel("Valor a pagar:");
		labFija3.setFont(new Font("Rockwell", Font.ROMAN_BASELINE, 25));
		
		labValorCifra = new JLabel();
		labValorCifra.setFont(new Font("Rockwell", Font.ROMAN_BASELINE, 25));
		
		labFija4 = new JLabel("Valor a pagar:");
		labFija4.setFont(new Font("Rockwell", Font.ROMAN_BASELINE, 25));
		
		labValorMontoEscrito = new JLabel();
		labValorMontoEscrito.setFont(new Font("Rockwell", Font.ROMAN_BASELINE, 25));
		
		labFija5 = new JLabel("Paguese a la orden de:");
		labFija5.setFont(new Font("Rockwell", Font.ROMAN_BASELINE, 25));
		
		labNombre = new JLabel();
		labNombre.setFont(new Font("Rockwell", Font.ROMAN_BASELINE, 25));
		
		labFija6 = new JLabel("Paguese a:");
		labFija6.setFont(new Font("Rockwell", Font.ROMAN_BASELINE, 25));
		
		labNombreProveedor = new JLabel();
		labNombreProveedor.setFont(new Font("Rockwell", Font.ROMAN_BASELINE, 25));
		
		labNombreBanco = new JLabel();
		labNombreBanco.setFont(new Font("Rockwell", Font.ROMAN_BASELINE, 25));
		
		labFija7 = new JLabel("Numero de cuenta:");
		labFija7.setFont(new Font("Rockwell", Font.ROMAN_BASELINE, 25));
		
		labNumeroDeCuenta = new JLabel();
		labNumeroDeCuenta.setFont(new Font("Rockwell", Font.ROMAN_BASELINE, 25));
		
		labSelloDeSeguridad = new JLabel();
		labSelloDeSeguridad.setBounds(0, 0, 60, 60);
		ImageIcon imagenSelloDeSeguridad = new ImageIcon("Imagenes/Sello de seguridad.png");
		Icon iconoSelloDeSeguridad = new ImageIcon(imagenSelloDeSeguridad.getImage().getScaledInstance(labSelloDeSeguridad.getWidth(), labSelloDeSeguridad.getHeight(), Image.SCALE_DEFAULT));
		labSelloDeSeguridad.setIcon(iconoSelloDeSeguridad);
		labSelloDeSeguridad.setHorizontalAlignment(JLabel.CENTER);
		labSelloDeSeguridad.setVerticalAlignment(JLabel.CENTER);
		
		panelCheque.add(labNombreBanco);
		panelCheque.add(labFija1);
		panelCheque.add(labFija2);
		panelCheque.add(labConsecutivoCheque);
		panelCheque.add(labFija3);
		panelCheque.add(labValorCifra);
		panelCheque.add(labFija4);
		panelCheque.add(labValorMontoEscrito);
		panelCheque.add(labFija5);
		panelCheque.add(labNombre);
		panelCheque.add(labFija6);
		panelCheque.add(labNombreProveedor);
		panelCheque.add(labFija7);	
		panelCheque.add(labNumeroDeCuenta);
		panelCheque.add(labSelloDeSeguridad);		
		
		layout.putConstraint(SpringLayout.WEST, labNombreBanco, 20, SpringLayout.WEST, panelCheque);
		layout.putConstraint(SpringLayout.EAST, labNombreBanco, 350, SpringLayout.WEST, panelCheque);
		layout.putConstraint(SpringLayout.VERTICAL_CENTER, labNombreBanco, -200, SpringLayout.VERTICAL_CENTER, panelCheque);
		
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, labFija1, 0, SpringLayout.HORIZONTAL_CENTER, panelCheque);
		layout.putConstraint(SpringLayout.VERTICAL_CENTER, labFija1, -170, SpringLayout.VERTICAL_CENTER, panelCheque);
		
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, labFija2, 0, SpringLayout.HORIZONTAL_CENTER, panelCheque);
		layout.putConstraint(SpringLayout.VERTICAL_CENTER, labFija2, -200, SpringLayout.VERTICAL_CENTER, panelCheque);
		
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, labConsecutivoCheque, 520, SpringLayout.HORIZONTAL_CENTER, panelCheque);
		layout.putConstraint(SpringLayout.VERTICAL_CENTER, labConsecutivoCheque, -200, SpringLayout.VERTICAL_CENTER, panelCheque);
		
		layout.putConstraint(SpringLayout.WEST, labFija3, 20, SpringLayout.WEST, panelCheque);
		layout.putConstraint(SpringLayout.EAST, labFija3, 200, SpringLayout.WEST, panelCheque);
		layout.putConstraint(SpringLayout.VERTICAL_CENTER, labFija3, -100, SpringLayout.VERTICAL_CENTER, panelCheque);
		
		layout.putConstraint(SpringLayout.WEST, labValorCifra, 200, SpringLayout.WEST, panelCheque);
		layout.putConstraint(SpringLayout.EAST, labValorCifra, 800, SpringLayout.WEST, panelCheque);
		layout.putConstraint(SpringLayout.VERTICAL_CENTER, labValorCifra, -100, SpringLayout.VERTICAL_CENTER, panelCheque);
		
		layout.putConstraint(SpringLayout.WEST, labFija4, 20, SpringLayout.WEST, panelCheque);
		layout.putConstraint(SpringLayout.EAST, labFija4, 200, SpringLayout.WEST, panelCheque);
		layout.putConstraint(SpringLayout.VERTICAL_CENTER, labFija4, -50, SpringLayout.VERTICAL_CENTER, panelCheque);
		
		layout.putConstraint(SpringLayout.WEST, labValorMontoEscrito, 200, SpringLayout.WEST, panelCheque);
		layout.putConstraint(SpringLayout.EAST, labValorMontoEscrito, 1400, SpringLayout.WEST, panelCheque);
		layout.putConstraint(SpringLayout.VERTICAL_CENTER, labValorMontoEscrito, -50, SpringLayout.VERTICAL_CENTER, panelCheque);
		
		layout.putConstraint(SpringLayout.WEST, labFija5, 20, SpringLayout.WEST, panelCheque);
		layout.putConstraint(SpringLayout.EAST, labFija5, 300, SpringLayout.WEST, panelCheque);
		layout.putConstraint(SpringLayout.VERTICAL_CENTER, labFija5, 0, SpringLayout.VERTICAL_CENTER, panelCheque);
		
		layout.putConstraint(SpringLayout.WEST, labNombre, 300, SpringLayout.WEST, panelCheque);
		layout.putConstraint(SpringLayout.EAST, labNombre, 1000, SpringLayout.WEST, panelCheque);
		layout.putConstraint(SpringLayout.VERTICAL_CENTER, labNombre, 0, SpringLayout.VERTICAL_CENTER, panelCheque);
		
		layout.putConstraint(SpringLayout.WEST, labFija6, 20, SpringLayout.WEST, panelCheque);
		layout.putConstraint(SpringLayout.EAST, labFija6, 160, SpringLayout.WEST, panelCheque);
		layout.putConstraint(SpringLayout.VERTICAL_CENTER, labFija6, 50, SpringLayout.VERTICAL_CENTER, panelCheque);
		
		layout.putConstraint(SpringLayout.WEST, labNombreProveedor, 160, SpringLayout.WEST, panelCheque);
		layout.putConstraint(SpringLayout.EAST, labNombreProveedor, 1000, SpringLayout.WEST, panelCheque);
		layout.putConstraint(SpringLayout.VERTICAL_CENTER, labNombreProveedor, 50, SpringLayout.VERTICAL_CENTER, panelCheque);

		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, labFija7, -110, SpringLayout.HORIZONTAL_CENTER, panelCheque);
		layout.putConstraint(SpringLayout.VERTICAL_CENTER, labFija7, 140, SpringLayout.VERTICAL_CENTER, panelCheque);
		
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, labNumeroDeCuenta, 110, SpringLayout.HORIZONTAL_CENTER, panelCheque);
		layout.putConstraint(SpringLayout.VERTICAL_CENTER, labNumeroDeCuenta, 140, SpringLayout.VERTICAL_CENTER, panelCheque);
		
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, labSelloDeSeguridad, 600, SpringLayout.HORIZONTAL_CENTER, panelCheque);
		layout.putConstraint(SpringLayout.VERTICAL_CENTER, labSelloDeSeguridad, 160, SpringLayout.VERTICAL_CENTER, panelCheque);
	}

	public JLabel getLabConsecutivoCheque() 
	{
		return labConsecutivoCheque;
	}

	public JLabel getLabValorCifra() 
	{
		return labValorCifra;
	}

	public JLabel getLabValorMontoEscrito()
	{
		return labValorMontoEscrito;
	}

	public JLabel getLabNombre()
	{
		return labNombre;
	}

	public JLabel getLabNombreProveedor() 
	{
		return labNombreProveedor;
	}

	public JLabel getLabNombreBanco() 
	{
		return labNombreBanco;
	}

	public JLabel getLabNumeroDeCuenta() 
	{
		return labNumeroDeCuenta;
	}

	
}

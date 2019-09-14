package vista;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.border.TitledBorder;

public class PanelCrear extends JPanel
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	private JLabel labImagenCrear;

	private JLabel labDato1;
	private JLabel labDato2;
	private JLabel labDato3;
	private JLabel labDato4;
	private JLabel labDato5;
	private JLabel labDato6;

	private JTextField txtDato1;	
	private JTextField txtDato2;
	private JTextField txtDato3;
	private JTextField txtDato5;
	private JTextField txtDato6;

	private ButtonGroup grupo;

	private JRadioButton radioButton1;
	private JRadioButton radioButton2;
	private JRadioButton radioButton3;

	private JButton btnAgregar;
	private JButton btnCancelar;

	private JPanel panelImagen;
	private JPanel panelFormulario;
	private JPanel panelBotones;

	public PanelCrear()
	{

		setBorder(new TitledBorder("Crear"));
		setLayout(new GridLayout(3,1));

		elaborarPanelImagen();
		elaborarPanelFormulario();
		elaborarPanelBotones();

		add(panelImagen);
		add(panelFormulario);
		add(panelBotones);
	}

	public void elaborarPanelImagen()
	{

		panelImagen = new JPanel();
		SpringLayout layout = new SpringLayout();
		panelImagen.setLayout(layout);

		labImagenCrear = new JLabel();
		labImagenCrear.setBounds(0, 0, 480, 160);
		ImageIcon imagenCrear = new ImageIcon("Imagenes/Banner crear.png");
		Icon iconoCrear = new ImageIcon(imagenCrear.getImage().getScaledInstance(labImagenCrear.getWidth(), labImagenCrear.getHeight(), Image.SCALE_DEFAULT));
		labImagenCrear.setIcon(iconoCrear);
		labImagenCrear.setHorizontalAlignment(JLabel.CENTER);
		labImagenCrear.setVerticalAlignment(JLabel.CENTER);

		panelImagen.add(labImagenCrear);

		layout.putConstraint(SpringLayout.WEST, labImagenCrear, panelImagen.getWidth(), SpringLayout.WEST, panelImagen);		
		layout.putConstraint(SpringLayout.EAST, labImagenCrear, panelImagen.getWidth(), SpringLayout.EAST, panelImagen);
		layout.putConstraint(SpringLayout.NORTH, labImagenCrear, 0, SpringLayout.NORTH, panelImagen);
		layout.putConstraint(SpringLayout.SOUTH, labImagenCrear, 180, SpringLayout.NORTH, panelImagen);
	}

	public void elaborarPanelFormulario()
	{

		panelFormulario = new JPanel();
		SpringLayout layout = new SpringLayout();
		panelFormulario.setLayout(layout);

		labDato1 = new JLabel();
		labDato1.setFont(new Font("Rockwell", Font.ROMAN_BASELINE, 20));
		txtDato1 = new JTextField();

		labDato2 = new JLabel();
		labDato2.setFont(new Font("Rockwell", Font.ROMAN_BASELINE, 20));
		txtDato2 = new JTextField();

		labDato3 = new JLabel();
		labDato3.setFont(new Font("Rockwell", Font.ROMAN_BASELINE, 20));
		txtDato3 = new JTextField();

		labDato4 = new JLabel();
		labDato4.setFont(new Font("Rockwell", Font.ROMAN_BASELINE, 20));
		
		grupo = new ButtonGroup();
		
		radioButton1 = new JRadioButton();
		
		radioButton2 = new JRadioButton();
		
		radioButton3 = new JRadioButton();
		
		grupo.add(radioButton1);
		grupo.add(radioButton2);
		grupo.add(radioButton3);

		labDato5 = new JLabel();
		labDato5.setFont(new Font("Rockwell", Font.ROMAN_BASELINE, 20));
		txtDato5 = new JTextField();

		labDato6 = new JLabel();
		labDato6.setFont(new Font("Rockwell", Font.ROMAN_BASELINE, 20)); 
		txtDato6 = new JTextField();

		panelFormulario.add(labDato1);
		panelFormulario.add(labDato2);
		panelFormulario.add(labDato3);
		panelFormulario.add(labDato4);
		panelFormulario.add(labDato5);
		panelFormulario.add(labDato6);

		layout.putConstraint(SpringLayout.WEST, labDato1, 15, SpringLayout.WEST, panelFormulario);
		layout.putConstraint(SpringLayout.EAST, labDato1, 0, SpringLayout.HORIZONTAL_CENTER, panelFormulario);
		layout.putConstraint(SpringLayout.NORTH, labDato1, 0, SpringLayout.NORTH, panelFormulario);
		layout.putConstraint(SpringLayout.SOUTH, labDato1, 20, SpringLayout.NORTH, panelFormulario);

		layout.putConstraint(SpringLayout.WEST, labDato2, 15, SpringLayout.WEST, panelFormulario);
		layout.putConstraint(SpringLayout.EAST, labDato2, 0, SpringLayout.HORIZONTAL_CENTER, panelFormulario);
		layout.putConstraint(SpringLayout.NORTH, labDato2, 20, SpringLayout.SOUTH, labDato1);
		layout.putConstraint(SpringLayout.SOUTH, labDato2, 20, SpringLayout.NORTH, labDato2);

		layout.putConstraint(SpringLayout.WEST, labDato3, 15, SpringLayout.WEST, panelFormulario);
		layout.putConstraint(SpringLayout.EAST, labDato3, 0, SpringLayout.HORIZONTAL_CENTER, panelFormulario);
		layout.putConstraint(SpringLayout.NORTH, labDato3, 20, SpringLayout.SOUTH, labDato2);
		layout.putConstraint(SpringLayout.SOUTH, labDato3, 20, SpringLayout.NORTH, labDato3);

		layout.putConstraint(SpringLayout.WEST, labDato4, 15, SpringLayout.WEST, panelFormulario);
		layout.putConstraint(SpringLayout.EAST, labDato4, 0, SpringLayout.HORIZONTAL_CENTER, panelFormulario);
		layout.putConstraint(SpringLayout.NORTH, labDato4, 20, SpringLayout.SOUTH, labDato3);
		layout.putConstraint(SpringLayout.SOUTH, labDato4, 20, SpringLayout.NORTH, labDato4);

		layout.putConstraint(SpringLayout.WEST, labDato5, 15, SpringLayout.WEST, panelFormulario);
		layout.putConstraint(SpringLayout.EAST, labDato5, 0, SpringLayout.HORIZONTAL_CENTER, panelFormulario);
		layout.putConstraint(SpringLayout.NORTH, labDato5, 20, SpringLayout.SOUTH, labDato4);
		layout.putConstraint(SpringLayout.SOUTH, labDato5, 20, SpringLayout.NORTH, labDato5);

		layout.putConstraint(SpringLayout.WEST, labDato6, 15, SpringLayout.WEST, panelFormulario);
		layout.putConstraint(SpringLayout.EAST, labDato6, 0, SpringLayout.HORIZONTAL_CENTER, panelFormulario);
		layout.putConstraint(SpringLayout.NORTH, labDato6, 20, SpringLayout.SOUTH, labDato5);
		layout.putConstraint(SpringLayout.SOUTH, labDato6, 20, SpringLayout.NORTH, labDato6);

		panelFormulario.add(txtDato1);
		panelFormulario.add(txtDato2);
		panelFormulario.add(txtDato3);
		panelFormulario.add(radioButton1);
		panelFormulario.add(radioButton2);
		panelFormulario.add(radioButton3);
		panelFormulario.add(txtDato5);
		panelFormulario.add(txtDato6);

		layout.putConstraint(SpringLayout.WEST, txtDato1, 0, SpringLayout.EAST, labDato1);
		layout.putConstraint(SpringLayout.EAST, txtDato1, 320, SpringLayout.EAST, labDato1);
		layout.putConstraint(SpringLayout.NORTH, txtDato1, 0, SpringLayout.NORTH, panelFormulario);
		layout.putConstraint(SpringLayout.SOUTH, txtDato1, 20, SpringLayout.NORTH, panelFormulario);

		layout.putConstraint(SpringLayout.WEST, txtDato2, 0, SpringLayout.EAST, labDato2);
		layout.putConstraint(SpringLayout.EAST, txtDato2, 320, SpringLayout.EAST, labDato2);
		layout.putConstraint(SpringLayout.NORTH, txtDato2, 20, SpringLayout.SOUTH, txtDato1);
		layout.putConstraint(SpringLayout.SOUTH, txtDato2, 20, SpringLayout.NORTH, txtDato2);

		layout.putConstraint(SpringLayout.WEST, txtDato3, 0, SpringLayout.EAST, labDato3);
		layout.putConstraint(SpringLayout.EAST, txtDato3, 320, SpringLayout.EAST, labDato3);
		layout.putConstraint(SpringLayout.NORTH, txtDato3, 20, SpringLayout.SOUTH, txtDato2);
		layout.putConstraint(SpringLayout.SOUTH, txtDato3, 20, SpringLayout.NORTH, txtDato3);

		layout.putConstraint(SpringLayout.WEST, txtDato3, 0, SpringLayout.EAST, labDato3);
		layout.putConstraint(SpringLayout.EAST, txtDato3, 320, SpringLayout.EAST, labDato3);
		layout.putConstraint(SpringLayout.NORTH, txtDato3, 20, SpringLayout.SOUTH, txtDato2);
		layout.putConstraint(SpringLayout.SOUTH, txtDato3, 20, SpringLayout.NORTH, txtDato3);

		layout.putConstraint(SpringLayout.WEST, radioButton1, 40, SpringLayout.EAST, labDato3);
		layout.putConstraint(SpringLayout.EAST, radioButton1, 120, SpringLayout.EAST, labDato3);
		layout.putConstraint(SpringLayout.NORTH, radioButton1, 20, SpringLayout.SOUTH, txtDato3);
		layout.putConstraint(SpringLayout.SOUTH, radioButton1, 20, SpringLayout.NORTH, radioButton1);

		layout.putConstraint(SpringLayout.WEST, radioButton2, 10, SpringLayout.EAST, radioButton1);
		layout.putConstraint(SpringLayout.EAST, radioButton2, 100, SpringLayout.EAST, radioButton1);
		layout.putConstraint(SpringLayout.NORTH, radioButton2, 20, SpringLayout.SOUTH, txtDato3);
		layout.putConstraint(SpringLayout.SOUTH, radioButton2, 20, SpringLayout.NORTH, radioButton2);

		layout.putConstraint(SpringLayout.WEST, radioButton3, 10, SpringLayout.EAST, radioButton2);
		layout.putConstraint(SpringLayout.EAST, radioButton3, 100, SpringLayout.EAST, radioButton2);
		layout.putConstraint(SpringLayout.NORTH, radioButton3, 20, SpringLayout.SOUTH, txtDato3);
		layout.putConstraint(SpringLayout.SOUTH, radioButton3, 20, SpringLayout.NORTH, radioButton3);

		layout.putConstraint(SpringLayout.WEST, txtDato5, 0, SpringLayout.EAST, labDato5);
		layout.putConstraint(SpringLayout.EAST, txtDato5, 320, SpringLayout.EAST, labDato5);
		layout.putConstraint(SpringLayout.NORTH, txtDato5, 60, SpringLayout.SOUTH, txtDato3);
		layout.putConstraint(SpringLayout.SOUTH, txtDato5, 20, SpringLayout.NORTH, txtDato5);

		layout.putConstraint(SpringLayout.WEST, txtDato6, 0, SpringLayout.EAST, labDato6);
		layout.putConstraint(SpringLayout.EAST, txtDato6, 320, SpringLayout.EAST, labDato6);
		layout.putConstraint(SpringLayout.NORTH, txtDato6, 20, SpringLayout.SOUTH, txtDato5);
		layout.putConstraint(SpringLayout.SOUTH, txtDato6, 20, SpringLayout.NORTH, txtDato6);
	}

	public void elaborarPanelBotones()
	{

		panelBotones = new JPanel();
		SpringLayout layout = new SpringLayout();
		panelBotones.setLayout(layout);

		btnAgregar = new JButton("Agregar");

		btnCancelar = new JButton("Cancelar");

		panelBotones.add(btnAgregar);
		panelBotones.add(btnCancelar);

		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, btnAgregar, -50, SpringLayout.HORIZONTAL_CENTER, panelBotones);
		layout.putConstraint(SpringLayout.NORTH, btnAgregar, 90, SpringLayout.NORTH, panelBotones);
		layout.putConstraint(SpringLayout.SOUTH, btnAgregar, 130, SpringLayout.NORTH, panelBotones);

		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, btnCancelar, 50, SpringLayout.HORIZONTAL_CENTER, panelBotones);
		layout.putConstraint(SpringLayout.NORTH, btnCancelar, 90, SpringLayout.NORTH, panelBotones);
		layout.putConstraint(SpringLayout.SOUTH, btnCancelar, 130, SpringLayout.NORTH, panelBotones);
	}

	public JLabel getLabDato1() {
		return labDato1;
	}

	public JLabel getLabDato2() {
		return labDato2;
	}

	public JLabel getLabDato3() {
		return labDato3;
	}

	public JLabel getLabDato4() {
		return labDato4;
	}

	public JLabel getLabDato5() {
		return labDato5;
	}

	public JLabel getLabDato6() {
		return labDato6;
	}
	
	public JTextField getTxtDato1() {
		return txtDato1;
	}


	public JTextField getTxtDato2() {
		return txtDato2;
	}

	public JTextField getTxtDato3() {
		return txtDato3;
	}

	public JTextField getTxtDato5() {
		return txtDato5;
	}

	public JTextField getTxtDato6() {
		return txtDato6;
	}

	public JRadioButton getFemenino() {
		return radioButton1;
	}

	public JRadioButton getMasculino() {
		return radioButton2;
	}

	public JRadioButton getOtro() {
		return radioButton3;
	}

	public JButton getBtnAgregar() {
		return btnAgregar;
	}

	public JButton getBtnCancelar() {
		return btnCancelar;
	}

	public JRadioButton getRadioButton1() 
	{	
		return radioButton1;
	}

	public JRadioButton getRadioButton2()
	{	
		return radioButton2;
	}

	public JRadioButton getRadioButton3() 
	{	
		return radioButton3;
	}

	public JPanel getPanelFormulario()
	{
		return panelFormulario;
	}

	public JPanel getPanelBotones() 
	{
		return panelBotones;
	}
	
	

}

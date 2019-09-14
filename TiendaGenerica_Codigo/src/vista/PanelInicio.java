package vista;

import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.border.TitledBorder;

import vista.PanelFechaYHora;

public class PanelInicio extends JPanel
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	private JLabel labImagenInicio;

	private JButton btnAyuda;
	private JButton btnLeer;
	private JButton btnBorrar;

	private PanelFechaYHora panelFechaYHora;

	private JPanel panelImagen;
	private JPanel panelGeneralidades;
	private JPanel panelBotones;

	public PanelInicio(String pRutaImagen)
	{

		setBorder(new TitledBorder("Inicio"));
		setLayout(new GridLayout(3,1));

		elaborarPanelImagen(pRutaImagen);
		elaborarPanelGeneralidades();
		elaborarPanelBotones();

		add(panelImagen);
		add(panelGeneralidades);
		add(panelBotones);
	}

	public void elaborarPanelImagen(String pRutaImagen)
	{

		panelImagen = new JPanel();
		SpringLayout layout = new SpringLayout();
		panelImagen.setLayout(layout);

		labImagenInicio = new JLabel();
		labImagenInicio.setBounds(0, 0, 480, 160);
		ImageIcon imagenInicio = new ImageIcon(pRutaImagen);
		Icon iconoInicio = new ImageIcon(imagenInicio.getImage().getScaledInstance(labImagenInicio.getWidth(), labImagenInicio.getHeight(), Image.SCALE_DEFAULT));
		labImagenInicio.setIcon(iconoInicio);
		labImagenInicio.setHorizontalAlignment(JLabel.CENTER);
		labImagenInicio.setVerticalAlignment(JLabel.CENTER);

		panelImagen.add(labImagenInicio);

		layout.putConstraint(SpringLayout.WEST, labImagenInicio, panelImagen.getWidth(), SpringLayout.WEST, panelImagen);		
		layout.putConstraint(SpringLayout.EAST, labImagenInicio, panelImagen.getWidth(), SpringLayout.EAST, panelImagen);
		layout.putConstraint(SpringLayout.NORTH, labImagenInicio, 0, SpringLayout.NORTH, panelImagen);
		layout.putConstraint(SpringLayout.SOUTH, labImagenInicio, 180, SpringLayout.NORTH, panelImagen);
	}

	public void elaborarPanelGeneralidades()
	{

		panelGeneralidades = new JPanel();
		panelGeneralidades.setLayout(new GridLayout(1,1));

		panelFechaYHora = new PanelFechaYHora();

		panelGeneralidades.add(panelFechaYHora);
	}

	public void elaborarPanelBotones()
	{

		panelBotones = new JPanel();
		SpringLayout layout = new SpringLayout();
		panelBotones.setLayout(layout);

		btnAyuda = new JButton("Ayuda");
		
		btnLeer = new JButton("Leer archivo");
		
		btnBorrar = new JButton("Borrar");

		panelBotones.add(btnAyuda);
		panelBotones.add(btnLeer);
		panelBotones.add(btnBorrar);		

		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, btnAyuda, -100, SpringLayout.HORIZONTAL_CENTER, panelBotones);		
		layout.putConstraint(SpringLayout.NORTH, btnAyuda, 70, SpringLayout.NORTH, panelBotones);
		layout.putConstraint(SpringLayout.SOUTH, btnAyuda, 110, SpringLayout.NORTH, panelBotones);
		
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, btnLeer, 0, SpringLayout.HORIZONTAL_CENTER, panelBotones);		
		layout.putConstraint(SpringLayout.NORTH, btnLeer, 70, SpringLayout.NORTH, panelBotones);
		layout.putConstraint(SpringLayout.SOUTH, btnLeer, 110, SpringLayout.NORTH, panelBotones);
		
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, btnBorrar, 100, SpringLayout.HORIZONTAL_CENTER, panelBotones);		
		layout.putConstraint(SpringLayout.NORTH, btnBorrar, 70, SpringLayout.NORTH, panelBotones);
		layout.putConstraint(SpringLayout.SOUTH, btnBorrar, 110, SpringLayout.NORTH, panelBotones);
	}

	public JButton getBtnAyuda() 
	{
		return btnAyuda;
	}

	public JButton getBtnLeer() 
	{
		return btnLeer;
	}

	public JButton getBtnBorrar() 
	{
		return btnBorrar;
	}
	
	
	
}

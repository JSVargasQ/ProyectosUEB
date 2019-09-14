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

public class PestañaInicio extends JPanel
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	private JLabel labImagenInicio;
	
	private JButton btnAyuda;
	private JButton btnConfigurarParametros;
	
	private PanelFechaYHora panelFechaYHora;

	private JPanel panelImagen;
	private JPanel panelGeneralidades;
	private JPanel panelBotones;
	
	public PestañaInicio()
	{
		
		setBorder(new TitledBorder("Inicio"));
		setLayout(new GridLayout(3,1));

		elaborarPanelImagen();

		elaborarPanelImagen();
		elaborarPanelGeneralidades();
		elaborarPanelBotones();

		add(panelImagen);
		add(panelGeneralidades);
		add(panelBotones);
	}
	
	public void elaborarPanelImagen()
	{

		panelImagen = new JPanel();
		SpringLayout layout = new SpringLayout();
		panelImagen.setLayout(layout);

		labImagenInicio = new JLabel();
		labImagenInicio.setBounds(0, 0, 480, 160);
		ImageIcon imagenInicio = new ImageIcon("Imagenes/Banner inicio.png");
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
		panelGeneralidades.setLayout(new GridLayout(1,2));

		panelFechaYHora = new PanelFechaYHora();

		panelGeneralidades.add(panelFechaYHora);
	}

	
	public void elaborarPanelBotones()
	{

		panelBotones = new JPanel();
		SpringLayout layout = new SpringLayout();
		panelBotones.setLayout(layout);

		btnConfigurarParametros = new JButton();
		ImageIcon iconoConfiguraciones = new ImageIcon("Imagenes/Configuraciones icono.png");
		btnConfigurarParametros.setIcon(iconoConfiguraciones);
		btnConfigurarParametros.setSize(60, 60);
		
		btnAyuda = new JButton("Ayuda general");

		panelBotones.add(btnConfigurarParametros);
		panelBotones.add(btnAyuda);	
		
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, btnConfigurarParametros, 0, SpringLayout.HORIZONTAL_CENTER, panelBotones);	
		layout.putConstraint(SpringLayout.VERTICAL_CENTER, btnConfigurarParametros, -30, SpringLayout.VERTICAL_CENTER, panelBotones);	

		
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, btnAyuda, 0, SpringLayout.HORIZONTAL_CENTER, panelBotones);	
		layout.putConstraint(SpringLayout.VERTICAL_CENTER, btnAyuda, 40, SpringLayout.VERTICAL_CENTER, panelBotones);	

	}

	public JButton getBtnAyuda()
	{
		return btnAyuda;
	}

	public JButton getBtnConfigurarParametros() 
	{
		return btnConfigurarParametros;
	}
	
	
	
}

package vista;

import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

public class VentanaConfiguraciones extends JFrame
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	private JLabel labImagenConfiguraciones;
	private JLabel labInfo;
	
	private JButton btnVisualizarPropiedadesDeLaTienda;
	private JButton btnModificarArchivoDePropiedades;
	
	public VentanaConfiguraciones()
	{
		
		setTitle("Configuraciones");
		setIconImage(new ImageIcon("Imagenes/Configuraciones.png").getImage());
		setSize(400, 400);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		
		JPanel panelConfiguraciones = new JPanel();
		
		SpringLayout layout = new SpringLayout();
		panelConfiguraciones.setLayout(layout);
		
		labImagenConfiguraciones = new JLabel();
		labImagenConfiguraciones.setBounds(0, 0, 60, 60);
		ImageIcon imagenConfiguraciones = new ImageIcon("Imagenes/Configuraciones.png");
		Icon iconoConfiguraciones = new ImageIcon(imagenConfiguraciones.getImage().getScaledInstance(labImagenConfiguraciones.getWidth(), labImagenConfiguraciones.getHeight(), Image.SCALE_DEFAULT));
		labImagenConfiguraciones.setIcon(iconoConfiguraciones);
		labImagenConfiguraciones.setHorizontalAlignment(JLabel.CENTER);
		labImagenConfiguraciones.setVerticalAlignment(JLabel.CENTER);
	
		labInfo = new JLabel("Propiedaes");
		btnVisualizarPropiedadesDeLaTienda = new JButton("Visualizar propiedades del sistema");
		btnModificarArchivoDePropiedades = new JButton("Modificar propiedades del sistema");
		
		panelConfiguraciones.add(labImagenConfiguraciones);
		panelConfiguraciones.add(labInfo);
		panelConfiguraciones.add(btnVisualizarPropiedadesDeLaTienda);
		panelConfiguraciones.add(btnModificarArchivoDePropiedades);
		
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, labImagenConfiguraciones, 0, SpringLayout.HORIZONTAL_CENTER, panelConfiguraciones);	
		layout.putConstraint(SpringLayout.VERTICAL_CENTER, labImagenConfiguraciones, -100, SpringLayout.VERTICAL_CENTER, panelConfiguraciones);
		
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, labInfo, 0, SpringLayout.HORIZONTAL_CENTER, panelConfiguraciones);	
		layout.putConstraint(SpringLayout.VERTICAL_CENTER, labInfo, -10, SpringLayout.VERTICAL_CENTER, panelConfiguraciones);	
		
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, btnVisualizarPropiedadesDeLaTienda, 0, SpringLayout.HORIZONTAL_CENTER, panelConfiguraciones);	
		layout.putConstraint(SpringLayout.VERTICAL_CENTER, btnVisualizarPropiedadesDeLaTienda, 40, SpringLayout.VERTICAL_CENTER, panelConfiguraciones);	
		
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, btnModificarArchivoDePropiedades, 0, SpringLayout.HORIZONTAL_CENTER, panelConfiguraciones);	
		layout.putConstraint(SpringLayout.VERTICAL_CENTER, btnModificarArchivoDePropiedades, 90, SpringLayout.VERTICAL_CENTER, panelConfiguraciones);	
		
		getContentPane().add(panelConfiguraciones);
	}

	public JLabel getlabInfo() {
		return labInfo;
	}

	public JButton getBtnVisualizarPropiedadesDeLaTienda() {
		return btnVisualizarPropiedadesDeLaTienda;
	}

	public JButton getBtnModificarArchivoDePropiedades() {
		return btnModificarArchivoDePropiedades;
	}
}

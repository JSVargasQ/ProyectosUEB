package vista;

import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.TitledBorder;

public class PestañaProveedores extends JPanel

{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	private JTabbedPane pestañas;

	private PanelInicio panelInicio;
	private PanelCrear panelCrear;
	private PanelActualizar panelActualizar;
	
	public PestañaProveedores()
	{
		
		setBorder(new TitledBorder("Proveedores"));
		setLayout(new GridLayout(1,1));
		
		pestañas = new JTabbedPane();

		panelCrear = new PanelCrear();
		panelCrear.getLabDato1().setText("Nombre del proveedor");
		panelCrear.getLabDato2().setText("NIT del proveedor");
		panelCrear.getLabDato3().setText("Teléfono del proveedor");
		panelCrear.getLabDato4().setText("Tipo de proveedor");
		panelCrear.getRadioButton1().setText("Clase A");
		panelCrear.getRadioButton2().setText("Clase B");
		panelCrear.getRadioButton3().setText("Clase C");
		panelCrear.getLabDato5().setText("Dirección física");
		panelCrear.getLabDato6().setText("Ciudad de establecimiento");
		
		panelInicio = new PanelInicio("Imagenes/Banner proveedores.png");
		
		panelActualizar = new PanelActualizar("Ingrese el NIT del proveedor cuyos datos desea actualizar");
		panelActualizar.getLabDato1().setText("Nombre del proveedor");
		panelActualizar.getLabDato2().setText("Teléfono del proveedor");
		panelActualizar.getLabDato4().setText("Tipo de proveedor");
		panelActualizar.getLabDato3().setText("Dirección física");
		panelActualizar.getRadioButton1().setText("Clase A");
		panelActualizar.getRadioButton2().setText("Clase B");
		panelActualizar.getRadioButton3().setText("Clase C");
		panelActualizar.getLabDato5().setText("Ciudad de establecimiento");
		
		pestañas.addTab("Inicio", panelInicio);
		ImageIcon imagenInicio = new ImageIcon("Imagenes/Inicio icono.png");
		Icon iconoInicio = new ImageIcon(imagenInicio.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
		pestañas.setIconAt(0, iconoInicio);
		
		pestañas.addTab("Crear", panelCrear);
		ImageIcon imagenCrear = new ImageIcon("Imagenes/Crear icono.png");
		Icon iconoCrear = new ImageIcon(imagenCrear.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
		pestañas.setIconAt(1, iconoCrear);
		
		pestañas.addTab("Actualizar", panelActualizar);
		ImageIcon imagenActualizar = new ImageIcon("Imagenes/Actualizar icono.png");
		Icon iconoActualizar = new ImageIcon(imagenActualizar.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
		pestañas.setIconAt(2, iconoActualizar);
		
		add(pestañas);
		
		pestañas.setTabPlacement(JTabbedPane.LEFT);
	}

	public PanelInicio getPanelInicio() 
	{
		return panelInicio;
	}

	public PanelCrear getPanelCrear() 
	{
		return panelCrear;
	}

	public PanelActualizar getPanelActualizar() 
	{
		return panelActualizar;
	}
	
	
}

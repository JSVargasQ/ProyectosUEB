package vista;

import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.TitledBorder;

public class Pesta�aProductos extends JPanel
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	private JTabbedPane pesta�as;

	private PanelInicio panelInicio;
	private PanelCrear panelCrear;
	private PanelActualizar panelActualizar;
	
	public Pesta�aProductos()
	{
		
		setBorder(new TitledBorder("Productos"));
		setLayout(new GridLayout(1,1));
		
		pesta�as = new JTabbedPane();

		panelCrear = new PanelCrear();
		panelCrear.getLabDato1().setText("Nombre del producto");
		panelCrear.getLabDato2().setText("Codigo del producto");
		panelCrear.getLabDato3().setText("NIT del proveedor");
		panelCrear.getLabDato4().setText("Tipo de producto");
		panelCrear.getRadioButton1().setText("Clase A");
		panelCrear.getRadioButton2().setText("Clase B");
		panelCrear.getRadioButton3().setText("Clase C");
		panelCrear.getLabDato5().setText("Precio de compra");
		panelCrear.getLabDato6().setText("Precio de venta");
		
		panelInicio = new PanelInicio("Imagenes/Banner productos.png");
		
		panelActualizar = new PanelActualizar("Ingrese el codigo del producto cuyos datos desea actualizar");
		panelActualizar.getLabDato1().setText("Nombre del producto");
		panelActualizar.getLabDato2().setText("NIT del proveedor");
		panelActualizar.getLabDato3().setText("Precio de compra");
		panelActualizar.getLabDato4().setText("Tipo de producto");
		panelActualizar.getRadioButton1().setText("Clase A");
		panelActualizar.getRadioButton2().setText("Clase B");
		panelActualizar.getRadioButton3().setText("Clase C");
		panelActualizar.getLabDato5().setText("Precio de venta");
		
		pesta�as.addTab("Inicio", panelInicio);
		ImageIcon imagenInicio = new ImageIcon("Imagenes/Inicio icono.png");
		Icon iconoInicio = new ImageIcon(imagenInicio.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
		pesta�as.setIconAt(0, iconoInicio);
		
		pesta�as.addTab("Crear", panelCrear);
		ImageIcon imagenCrear = new ImageIcon("Imagenes/Crear icono.png");
		Icon iconoCrear = new ImageIcon(imagenCrear.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
		pesta�as.setIconAt(1, iconoCrear);
		
		pesta�as.addTab("Actualizar", panelActualizar);
		ImageIcon imagenActualizar = new ImageIcon("Imagenes/Actualizar icono.png");
		Icon iconoActualizar = new ImageIcon(imagenActualizar.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
		pesta�as.setIconAt(2, iconoActualizar);
		
		add(pesta�as);
		
		pesta�as.setTabPlacement(JTabbedPane.LEFT);
	}

	public JTabbedPane getPesta�as() 
	{
		return pesta�as;
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

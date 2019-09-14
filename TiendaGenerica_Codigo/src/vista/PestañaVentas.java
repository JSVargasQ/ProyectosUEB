package vista;

import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class Pesta�aVentas extends JPanel
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private PanelTransacciones panelTransacciones;
	
	public Pesta�aVentas()
	{
		
		setBorder(new TitledBorder("Ventas"));
		setLayout(new GridLayout(1,1));
		
		panelTransacciones = new PanelTransacciones("Ingresa la identificaci�n del cliente que va a realizar la compra", "Ingrese el codigo del producto a vender", "Ingrese la cantidad a vender");
		
		add(panelTransacciones);
	}

	public PanelTransacciones getPanelTransacciones() 
	{
		return panelTransacciones;
	}
	
}

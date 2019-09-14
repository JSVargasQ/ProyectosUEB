package vista;

import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import modelo.Cheque;

public class PestañaCompras extends JPanel
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private PanelTransacciones panelTransacciones;

	public PestañaCompras()
	{

		setBorder(new TitledBorder("Compras"));
		setLayout(new GridLayout(1,1));

		panelTransacciones = new PanelTransacciones("Ingresa la identificación del proveedor al cual se le va a realizar la compra", "Ingrese el codigo del producto a comprar", "Ingrese la cantidad a comprar");

		add(panelTransacciones);
	}

	public PanelTransacciones getPanelTransacciones()
	{
		return panelTransacciones;
	}
	
	public void generarCheque(Cheque pCheque)
	{
		VentanaCheque ventanaCheque = new VentanaCheque();
		ventanaCheque.setVisible(true);
		ventanaCheque.getLabConsecutivoCheque().setText(String.valueOf(pCheque.getConsecutivoCheque()));
		ventanaCheque.getLabNombre().setText(pCheque.getNombre());
		ventanaCheque.getLabNombreBanco().setText(pCheque.getNombreBanco());
		ventanaCheque.getLabNombreProveedor().setText(pCheque.getNombreProveedor());
		ventanaCheque.getLabNumeroDeCuenta().setText(String.valueOf(pCheque.getNumeroCuenta()));
		ventanaCheque.getLabValorCifra().setText(String.valueOf(pCheque.getValorCifra()));
		ventanaCheque.getLabValorMontoEscrito().setText(pCheque.getValorMontoEscrito());
	}
	
	
}

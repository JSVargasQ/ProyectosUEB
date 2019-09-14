package vista;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import controlador.Controlador;

public class PanelOperaciones extends JPanel
{

	// -----------------------------------------------------------------
	// Atributos
	// -----------------------------------------------------------------
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private JButton btnNuevaPartida;
	private JButton btnGuardarPartida;
	private JButton btnCargarPartida;
	private JButton btnCambiarNombres;
	
	
	// -----------------------------------------------------------------
	// Constructor
	// -----------------------------------------------------------------
	
	/**
	 * Crea el panel con todas las operaciones.
	 * @param pVentanaPrincipal Ventana principal. pVentanaPrincipal != null.
	 */
	public PanelOperaciones(Controlador pControlador)
		{			
			btnNuevaPartida = new JButton(Ventana.NUEVA_PARTIDA);
			btnGuardarPartida = new JButton(Ventana.GUARDAR_PARTIDA);
			btnCargarPartida = new JButton(Ventana.CARGAR_PARTIDA);
			btnCambiarNombres = new JButton(Ventana.CAMBIAR_NOMBRES);
			
			btnNuevaPartida.setActionCommand(Ventana.NUEVA_PARTIDA);
			btnGuardarPartida.setActionCommand(Ventana.GUARDAR_PARTIDA);
			btnCargarPartida.setActionCommand(Ventana.CARGAR_PARTIDA);
			btnCambiarNombres.setActionCommand(Ventana.CAMBIAR_NOMBRES);
			
			btnNuevaPartida.addActionListener(pControlador);
			btnGuardarPartida.addActionListener(pControlador);
			btnCargarPartida.addActionListener(pControlador);
			btnCambiarNombres.addActionListener(pControlador);
			
			setBorder(new TitledBorder("Operaciones"));
			setLayout(new GridLayout(4, 1));
			
			add(btnNuevaPartida);
			add(btnGuardarPartida);
			add(btnCargarPartida);
			add(btnCambiarNombres);
			
		}
	
}
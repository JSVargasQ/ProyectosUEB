package vista;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class PanelPartida extends JPanel
{

	
	// -----------------------------------------------------------------
	// Atributos
	// -----------------------------------------------------------------

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private JLabel lbTurno;
	private JLabel lbTxtTurno;
	
	private JLabel lbJugador1;
	private JLabel lbTxtJugador1;
	
	private JLabel lbJugador2;
	private JLabel lbTxtJugador2;
	
	
	// -----------------------------------------------------------------
	// Constructor
	// -----------------------------------------------------------------
	
	/**
	 * Se crea el panel partida.
	 * @param pVentanaPrincipal Ventana principal. pVentanaPrincipal != null.
	 */
	public PanelPartida()
		{
			lbTurno = new JLabel("Turno: ");
			lbTxtTurno = new JLabel("Jugador 1");
			
			lbJugador1 = new JLabel("Jugador 1: ");
			lbTxtJugador1 = new JLabel("0");
			
			lbJugador2 = new JLabel("Jugador 2: ");
			lbTxtJugador2 = new JLabel("0");
			
			setBorder(new TitledBorder("Partida"));
			
			setLayout(new GridLayout(3, 2));
			
			add(lbTurno);
			add(lbTxtTurno);
			
			add(lbJugador1);
			add(lbTxtJugador1);
			
			add(lbJugador2);
			add(lbTxtJugador2);
			
		}
	
	// ----------------------------------------------------------------- 
	// Metodos
	// -----------------------------------------------------------------
	
	/**
	 * Se actualiza en el panel los nombres de los jugadores.
	 * @param pNombreJugador1 Nombre del jugador1.
	 * @param pNombreJugador2 Nombre del jugador2.
	 */
	public void cambiarNombreJugadores(String pNombreJugador1, String pNombreJugador2)
		{
			lbJugador1.setText(pNombreJugador1);
			lbJugador2.setText(pNombreJugador2);
		}
	
	/**
	 * Actualiza en el panel el numero de movimientos de cada jugador.
	 * @param pMovJugador1 Numero de movimientos del jugador1.
	 * @param pMovJugador2 Numero de movimientos del jugador2.
	 */
	public void actualizarMovimientos(int pMovJugador1, int pMovJugador2)
		{
			lbTxtJugador1.setText(String.valueOf(pMovJugador1));
			lbTxtJugador2.setText(String.valueOf(pMovJugador2));
		}
	/**
	 * Actualiza el nombre del jugador en el turno actual.
	 * @param pTurno Nombre del jugador. 
	 */
	public void actualizarTurno(String pTurno)
		{
			lbTxtTurno.setText(pTurno);
		}
	
}

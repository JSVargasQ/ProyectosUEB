package vista;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import controlador.Controlador;
import modelo.Casilla;

public class Ventana extends JFrame
{
	// -----------------------------------------------------------------
	// Constantes
	// -----------------------------------------------------------------


	public static final String NUEVA_PARTIDA = "Nueva Partida";
	public static final String GUARDAR_PARTIDA = "Guardar Partida";
	public static final String CARGAR_PARTIDA = "Cargar Partida";
	public static final String CAMBIAR_NOMBRES = "Cambiar Nombres";
	
	// -----------------------------------------------------------------
	// Asociaciones
	// -----------------------------------------------------------------
	
	private PanelTablero panelTablero;
	private PanelPartida panelPartida;
	private PanelOperaciones panelOperaciones;

	// -----------------------------------------------------------------
	// Atributos
	// -----------------------------------------------------------------
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private JPanel panelEast;
	private JLabel pictureTriqui;
	
	// -----------------------------------------------------------------
	// Constructor
	// -----------------------------------------------------------------
	
	/**
	 * Crea la ventana principal.
	 * @param pControlador Controlador. pControlador != null.
	 */
	public Ventana(Controlador pControlador)
		{
			panelTablero = new PanelTablero(pControlador);
			panelEast = new JPanel();
			pictureTriqui = new JLabel();
			panelPartida = new PanelPartida();
			panelOperaciones = new PanelOperaciones(pControlador);
			
			ImageIcon picture = new ImageIcon("./pictures/triqui.jpg");
			pictureTriqui.setIcon(picture);
			
			panelEast.setLayout(new GridLayout(3, 1));
			panelEast.add(pictureTriqui);
			panelEast.add(panelPartida);
			panelEast.add(panelOperaciones);
			
			setTitle("Proyecto Final: El Triqui");
			setSize(800, 600);
			setResizable(false);
			setDefaultCloseOperation(HIDE_ON_CLOSE);
			setLayout(new BorderLayout());
			
			add(panelTablero, BorderLayout.CENTER);
			add(panelEast, BorderLayout.EAST);
						
			setVisible(true);
		
		}
	
	// -----------------------------------------------------------------
	// Metodos
	// -----------------------------------------------------------------
	
	public void actualizarPanelTablero(Casilla[][] pTablero)
		{
			panelTablero.atualizarPanel(pTablero);
		}
	
	public void actualizarPanelPartida(int pMovJugador1, int pMovJugador2)
		{
			panelPartida.actualizarMovimientos(pMovJugador1, pMovJugador2);
		}
	
	/**
	 * Da el mensaje de que alguien gano.
	 * Lanza una ventana avisando que hay un ganador y desactiva el tablero.
	 */
	public void hayGanador()
		{
			JOptionPane.showMessageDialog(this, "¡ Tenemos un ganador !");
			panelTablero.desactivarBotones();
		}
	
	/**
	 * Tablero completado.
	 * Lanza una ventana avisando que no hay ganador y desactiva el tablero.
	 */
	public void tableroLleno()
		{
			JOptionPane.showMessageDialog(this, "¡ No hay ningún ganador !");
			panelTablero.desactivarBotones();
		}
	
	public void actualizarTurno(String pTurno)
		{
			panelPartida.actualizarTurno(pTurno);
		}
	
	public void actualizarNombres(String pNombreJugador1, String pNombreJugador2)
		{
			panelPartida.cambiarNombreJugadores(pNombreJugador1, pNombreJugador2);
		}
	
	public void activarTablero()
		{
			panelTablero.activarBotones();
		}
	
	public void darMensajeError(String pMensaje)
		{
			JOptionPane.showMessageDialog(this, pMensaje, "ERROR", JOptionPane.ERROR_MESSAGE, null);
		}

	public PanelTablero getPanelTablero() 
	{
		return panelTablero;
	}

	public PanelPartida getPanelPartida() 
	{
		return panelPartida;
	}

	public PanelOperaciones getPanelOperaciones() 
	{
		return panelOperaciones;
	}

	public JPanel getPanelEast()
	{
		return panelEast;
	}

	public JLabel getPictureTriqui()
	{
		return pictureTriqui;
	}
	
	

}

package vista;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import controlador.Controlador;
import modelo.Casilla;
import modelo.Triqui;

public class PanelTablero extends JPanel
{	
	// -----------------------------------------------------------------
	// Atributos
	// -----------------------------------------------------------------
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	/**
	 * Arreglo bidimensional de botones que representa el tablero.
	 */
	private JButton[][] matrizBotones;
	
	
	
	
	// -----------------------------------------------------------------
	// Constructor
	// -----------------------------------------------------------------
	
	/**
	 * Crea el panel que representa el tablero.
	 * @param pVentanaPrincipal Ventana principal. pVentanaPrincipal != null.
	 */
	public PanelTablero(Controlador pControlador)
		{
			matrizBotones = new JButton[Triqui.FILAS][Triqui.COLUMNAS];
			
			setLayout(new GridLayout(Triqui.FILAS, Triqui.COLUMNAS));
			inicializarBotones(pControlador);
			cargarBotones();			
		}
	
	
	// -----------------------------------------------------------------
	// Metodos
	// -----------------------------------------------------------------
	
	/**
	 * Actualiza tablero.
	 * Actualiza el color de cada boton segun el jugador.
	 * @param pMatriz Matriz representante del tablero. pMatriz != null.
	 */
	public void atualizarPanel(Casilla[][] pMatriz)
		{
			for (int a = 0; a < Triqui.FILAS; a++)
				{
					for (int b = 0; b < Triqui.COLUMNAS; b++)
						{
							Casilla actual = pMatriz[a][b];
							
							if(actual.darTipo() == Casilla.VACIA)
								{
									matrizBotones[a][b].setBackground(Color.WHITE);
								}
							else if(actual.darTipo() == Casilla.JUGADOR_1)
								{
									matrizBotones[a][b].setBackground(Color.RED);
								}
							else
								{
									matrizBotones[a][b].setBackground(Color.BLACK);
								}
							
						}
				}
		}
	
	/**
	 * Inicializa los botones del panel.
	 * Inicializa los botones que representan el tablero.
	 */
	public void inicializarBotones(Controlador pControlador)
		{
			for (int a = 0; a < Triqui.FILAS; a++)
				{
					for (int b = 0; b < Triqui.COLUMNAS; b++)
						{
							matrizBotones[a][b] = new JButton("");
							matrizBotones[a][b].setActionCommand(a + "," + b);
							matrizBotones[a][b].addActionListener(pControlador);
						}
				}
		}
	
	/**
	 * Agrega los botones al panel.
	 * Agrega uno a uno los botones del panel en su correspondiente posición.
	 */
	public void cargarBotones()
		{
			for (int a = 0; a < Triqui.FILAS; a++)
			{
				for (int b = 0; b < Triqui.COLUMNAS; b++)
					{
						add(matrizBotones[a][b]);
					}
			}
		}
	
	/**
	 * Activa los botones del tablero.
	 * Permite interactuar ccon los botones del tablero.
	 */
	public void activarBotones()
		{
			for (int a = 0; a < Triqui.FILAS; a++)
			{
				for (int b = 0; b < Triqui.COLUMNAS; b++)
					{
						matrizBotones[a][b].setEnabled(true);
					}
			}
		}
	
	/**
	 * Desactiva los botones del tablero.
	 * No permite interactuar con los botones del tablero.
	 */
	public void desactivarBotones()
		{
			for (int a = 0; a < Triqui.FILAS; a++)
			{
				for (int b = 0; b < Triqui.COLUMNAS; b++)
					{
						matrizBotones[a][b].setEnabled(false);
					}
			}
		}
	
}

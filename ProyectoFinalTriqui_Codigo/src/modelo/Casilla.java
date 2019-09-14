package modelo;

public class Casilla 
{
	//-----------------------------------------------------------------
	//Constantes - Estados posibles para la casilla
	//-----------------------------------------------------------------
	
	public static final int VACIA = 0;
	public static final int JUGADOR_1 = 1;
	public static final int JUGADOR_2 = 2;
	
	//-----------------------------------------------------------------
	//Atributos
	//-----------------------------------------------------------------
	
	/**
	 * Estado de la casilla
	 */
	private int tipo;
	
	
	//-----------------------------------------------------------------
	//Constructor
	//-----------------------------------------------------------------

	/**
	 * Crea una casilla
	 * <b>post: </b> Se creó una casilla de tipo "VACIA"
	 */
	public Casilla()
		{
			tipo = VACIA;
		}
	
	//-----------------------------------------------------------------
	// Métodos
	//-----------------------------------------------------------------
	
	public int darTipo()
		{
			return tipo;
		}
	
	/**
	 * Cambia el tipo de la casilla.<br>
	 * @param pTipo Tipo al que se cambiara la casilla. pTipo >= 0 && pTipo <= 2.
	 */
	public void cambiarTipo(int pTipo)
		{
			tipo = pTipo;
		}
}

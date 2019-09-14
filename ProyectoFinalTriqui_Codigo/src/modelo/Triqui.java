package modelo;

public class Triqui 
{
	//-----------------------------------------------------------------
	// Constantes -Numero filas y Numero columnas
	//-----------------------------------------------------------------
	public static final int FILAS = 5;
	public static final int COLUMNAS = 5;
	
	//-----------------------------------------------------------------
	// Asociaciónes
	//-----------------------------------------------------------------
	
	/**
	 * Casillas que en conjunto seran el tablero del Triqui
	 */
	private Casilla[][] tablero;
	
	private boolean turno;
	
	private String nombreJugador1;
	private String nombreJugador2;
	
	/**
	 * Cantidad de movimiento del jugador1
	 */
	private int movJugador1;
	
	/**
	 * Cantidad de movimientos del jugador2
	 */
	private int movJugador2;
	
	
	//-----------------------------------------------------------------
	// Constructor
	//-----------------------------------------------------------------
	
	/**
	 * Crea el triqui. <br>
	 * <br>post: </b> Se crea el triqui con el turno en false, los movimientos de cada jugador en 0 y dando nombres por defecto a los jugadores.<br>
	 * Se inicializa el tablero. <br>
	 */
	public Triqui()
		{
			tablero = new Casilla[FILAS][COLUMNAS];
			
			turno = false; 
			
			movJugador1 = 0;
			movJugador2 = 0;
			
			nombreJugador1 = "Jugador 1";
			nombreJugador2 = "Jugador 2";
			
			inicializarTablero();	
		}
	
	public void inicializarTablero()
		{
			for (int a = 0; a < FILAS; a++)
				{
					for (int b = 0; b < COLUMNAS; b++)
						{
							tablero[a][b] = new Casilla();
						}
				}
		}
	
	/**
	 * Retorna un arreglo bidimensional con todas las casillas del Triqui.<br>
	 * @return Arreglo 2d llamado "tablero" con todas las casillas.
	 */
	public Casilla[][] darTablero()
		{
			return tablero;
		}
	
	/**
	 * Retorna el estado booleano del turno.
	 * @return turno. False si el turno es del jugador1 y True si el turno es del jugador2
	 */
	public boolean darTurno()
		{
			return turno;
		}
	
	public String darNombreJugador1()
		{
			return nombreJugador1;
		}
	
	
	public String darNombreJugador2()
		{
			return nombreJugador2;
		}
	
	public int darMovimientosJugador1()
		{
			return movJugador1;
		}
	
	public int darMovimientosJugador2()
		{
			return movJugador2;
		}
	
	public void cambiarTurno(boolean pTurno)
		{
			turno = pTurno;
		}
	
	public void cambiarNombreJugador1(String pNombreJugador1)
		{
			nombreJugador1 = pNombreJugador1;
		}
	
	public void cambiarNombreJugador2(String pNombreJugador2)
		{
			nombreJugador2 = pNombreJugador2;
		}
	
	public void cambiarMovimientosJugador1(int pNumMovimientos)
		{
			movJugador1 = pNumMovimientos;
		}
	
	public void cambiarMovimientosJugador2(int pNumMovimientos)
		{
			movJugador2 = pNumMovimientos;
		}
	
	/**
	 * Retorna el nombre el jugador que tiene el actual turno.<br>
	 * @return nombreJugador1 si el turno == false
	 * @return nombreJugador2 Si el turno == true
	 */
	public String darNombreJugadorTurnoActual()
		{
			String actual = "";
			
			if(turno == false)
				{
					actual = nombreJugador1;
				}
			
			else
				{
					actual = nombreJugador2;
				}
			
			return actual;
		}
	
	/**
	 * Actualiza la casilla.<br>
	 * Si la casilla es de tipo VACIA se actualizara segun el valor del turno actual.<br>
	 * @param pX Numero de la fila donde se ubica la casilla
	 * @param pY Numero de la columna donde se ubica la casilla
	 * @return True si la casilla fue actualizada, False en caso contrario.
	 * @throws Exception Dispara excepción si la casilla es diferente al tipo VACIA
	 */
	public boolean actualizarCasilla(int pX, int pY) throws Exception
		{
			boolean actualizada = false;
			
			Casilla actual = tablero[pX][pY];
			
			if(actual.darTipo() == Casilla.VACIA)
				{
					if(turno == false) 
						{
							actual.cambiarTipo(Casilla.JUGADOR_1);
							movJugador1++;
							turno = true;
						}
					else 
						{
							actual.cambiarTipo(Casilla.JUGADOR_2);
							movJugador2++;
							turno = false;
						}
					
					actualizada = true;
				}
			else
				{
					if(turno == false)
						{
							if(actual.darTipo() == Casilla.JUGADOR_1)
								{
									throw new Exception("Ya ocupaste esta casilla");
								}
							else
								{
									throw new Exception("Tu contricante ya ocupó esta casilla");
								}
						}
					else
						{
							if(actual.darTipo() == Casilla.JUGADOR_2)
								{
									throw new Exception("Ya ocupaste esta casilla");
								}
							else
								{
									throw new Exception("Tu contricante ya ocupó esta casilla");
								}
						}
				
				}
			
			return actualizada;
		}
	
	public void cambiarEstadoCasilla(int pFila, int pColumna, int pTipo)
		{
			tablero[pFila][pColumna].cambiarTipo(pTipo);
		}
	
	/**
	 * Verifica si hay un ganador.<br>
	 * Verifica si hay un numero de celdas de la misma cantidad en linea recta con el mismo jugador. (La cantidad de celdas es igual al de las filas o columnas)<br>
	 * @return True si hay un ganador, False si no lo hay
	 */
	public boolean verificarPartida()
		{
			boolean partidaGanada = false;
			
			if(verificarEsquinas(Casilla.JUGADOR_1) || verificarFilas(Casilla.JUGADOR_1) || verificarColumnas(Casilla.JUGADOR_1))
				{
					partidaGanada = true;
					turno= !turno;
				}
			else if(verificarEsquinas(Casilla.JUGADOR_2) || verificarFilas(Casilla.JUGADOR_2) || verificarColumnas(Casilla.JUGADOR_2))
				{
					partidaGanada = true;
					turno= !turno;
				}
			
			return partidaGanada;
		}
	
	public boolean verificarTableroLleno()
		{
			boolean tableroLleno = false;
			int contador = 0;
			
			for (int a = 0; a < FILAS; a++)
				{
					for (int b = 0; b < COLUMNAS; b++) 
						{
							Casilla actual = tablero[a][b];
							
							if(actual.darTipo() != Casilla.VACIA)
								{
									contador++;
								}
						}
				}
			
			if(contador == (FILAS * COLUMNAS))
				{
					tableroLleno = true;
				}
			
			return tableroLleno;
		}
	
	public void reiniciarPartida()
		{
			turno = false;
			movJugador1 = 0;
			movJugador2 = 0;
		
			for (int a = 0; a < tablero.length; a++)
				{
					for (int b = 0; b < tablero.length; b++)
						{
							tablero[a][b].cambiarTipo(Casilla.VACIA);
						}
				}
		}
	/**
	 * Verifica las fiagonales.<br>
	 * Verifica las dos diagonales.<br> 
	 * @param pJugador Jugador con el cual verificaremos si ha ocupado las casillas.
	 * @return True si pJugador ha ocupado las casillas de una de las dos diagonales, False del caso contrario.
	 */
	public boolean verificarEsquinas(int pJugador)
		{
			boolean ganada = false;
			int contador = 0;
			
			for (int a = 0, b = 0; a < FILAS; a++, b++) 
				{
					Casilla actual = tablero[a][b];
					
					if(actual.darTipo() == pJugador)
						{
							contador++;
						}
				}
			
			if(contador == COLUMNAS)
				{
					ganada = true;
				}
			else
				{
					contador = 0;
					for (int a = 0, b = FILAS - 1; a < FILAS && ganada == false; a++, b--) 
						{
							Casilla actual = tablero[a][b];
							
							if(actual.darTipo() == pJugador)
								{
									contador++;
								}
						}
					
					if(contador == COLUMNAS)
						{
							ganada = true;
						}
				}
			
			return ganada;
		}
	
	/**
	 * Verifica las filas.<br>
	 * Verifica si las celdas de forma horizontal estan llenas por pJugador.<br>
	 * @return True si pJugador ha ocupado una de las 5 filas, False de caso contrario.
	 */
	public boolean verificarFilas(int pJugador)
		{
			boolean ganada = false;
			
			for (int a = 0; a < FILAS && ganada == false; a++)
				{
					int contador = 0;
				
					for (int b = 0; b < COLUMNAS; b++)
						{
							Casilla actual = tablero[a][b];
							
							if(actual.darTipo() == pJugador)
								{
									contador++;
								}
						}
					
					if(contador == FILAS)
						{
							ganada = true;
						}
				}
			
			return ganada;
		}
	/**
	 * Verifica las columnas.<br>
	 * Verifica si las celdas de forma vertical estan llenas por pJugador.<br>
	 * @return True si pJugador ha ocupado una de las 5 columnas, False de caso contrario.
	 */
	public boolean verificarColumnas(int pJugador)
		{
			boolean ganada = false;
			
			for (int a = 0; a < FILAS && ganada == false; a++)
				{
					int contador = 0;
					
					for (int b = 0; b < COLUMNAS; b++)
						{
							Casilla actual = tablero[b][a];
							
							if(actual.darTipo() == pJugador)
								{
									contador++;
								}
						}
					
					if(contador == FILAS)
						{
							ganada = true;
						}
				}
			
			return ganada;
		}

}

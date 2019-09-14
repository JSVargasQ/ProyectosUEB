package persistencia;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JFileChooser;

import modelo.Casilla;
import modelo.Triqui;

public class AdministradorIO 
{

	// --------------------------------------------------
	// Asociaciones
	// --------------------------------------------------
	
	private Triqui modelo;
	
	// --------------------------------------------------
	// Constructor
	// --------------------------------------------------
	public AdministradorIO(Triqui pTriqui)
		{
			modelo = pTriqui;
		}
	
	// --------------------------------------------------
	// Metodos
	// --------------------------------------------------
	/**
	 * Guarda la partida.
	 * Guarda en un archivo .properties el estado de la partida actual por medio de llaves.
	 * @param pNombrePartida Nombre con el que se guardara la partida. pNombrePartida != null.
	 * @throws IOException Lanza excepcion si no se pudo guardar la partida.
	 */
	public void guardarPartida(String pNombrePartida) throws IOException
		{
		
			File archivo = new File("./data/ " + pNombrePartida + ".properties");
			FileWriter fileWriter = new FileWriter(archivo);
			PrintWriter printWriter = new PrintWriter(fileWriter);
			
			boolean turno = modelo.darTurno();
			String nombreJugador1 = modelo.darNombreJugador1();
			int movimientosJugador1 = modelo.darMovimientosJugador1();
			String nombreJugador2 = modelo.darNombreJugador2();
			int movimientosJugador2 = modelo.darMovimientosJugador2();
			
			Casilla[][] tablero = modelo.darTablero();
			
			printWriter.println("turno =" + turno);
			printWriter.println("nombreJugador1 =" + nombreJugador1);
			printWriter.println("movimientoJugador1 =" + movimientosJugador1);
			printWriter.println("nombreJugador2 =" + nombreJugador2);
			printWriter.println("movimientoJugador2 =" + movimientosJugador2);
			
			for (int a = 0; a < tablero.length; a++) 
				{
					for (int b = 0; b < tablero.length; b++)
						{
							Casilla actual = tablero[a][b];
							int tipo = actual.darTipo();
							
							printWriter.println("casilla" + a + "," + b + " =" + tipo);
						}
				}
			
			printWriter.close();
			
		}
	
	/**
	 * Carga la partida.
	 * Carga un archivo .properties, el cual es escogido por el usuario.
	 * @throws IOException Lanza error si no se ha podido cargar todos los datos.
	 */
	public void cargarPartida() throws IOException
		{
			File archivo = null;
			JFileChooser fileChooser = new JFileChooser( "./data" );
			fileChooser.setDialogTitle("Escoge la paritda");
			int archivoEscogido = fileChooser.showOpenDialog(fileChooser);
			
			if(archivoEscogido == JFileChooser.APPROVE_OPTION)
				{
					archivo = fileChooser.getSelectedFile();
					
					FileReader fileReader = new FileReader(archivo);
					BufferedReader buffer = new BufferedReader(fileReader);
					
					String linea = buffer.readLine();
					String[] txtTurno = linea.split("=");
					boolean turno = Boolean.parseBoolean(txtTurno[1]);
					
					linea = buffer.readLine();
					String[] txtNombreJugador1 = linea.split("=");
					String nombreJugador1 = txtNombreJugador1[1];
					
					linea = buffer.readLine();
					String[] txtMovimientosJugador1 = linea.split("=");
					int movimientosJugador1 = Integer.parseInt(txtMovimientosJugador1[1]);
					
					linea = buffer.readLine();
					String[] txtNombreJugador2 = linea.split("=");
					String nombreJugador2 = txtNombreJugador2[1];
					
					linea = buffer.readLine();
					String[] txtMovimientosJugador2 = linea.split("=");
					int movimientosJugador2 = Integer.parseInt(txtMovimientosJugador2[1]);
					
					modelo.cambiarTurno(turno);
					modelo.cambiarNombreJugador1(nombreJugador1);
					modelo.cambiarMovimientosJugador1(movimientosJugador1);
					modelo.cambiarNombreJugador2(nombreJugador2);
					modelo.cambiarMovimientosJugador2(movimientosJugador2);
					
					for (int a = 0; a < Triqui.FILAS; a++) 
						{
							for (int b = 0; b < Triqui.COLUMNAS; b++) 
								{
									linea = buffer.readLine();
									String[] txtLlave = linea.split("=");
									int estado = Integer.parseInt(txtLlave[1]);
									
									modelo.cambiarEstadoCasilla(a, b, estado);
								}
						}
					
					fileReader.close();
					buffer.close();
					
				}
		}
}

package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JOptionPane;

import modelo.Casilla;
import modelo.Triqui;
import persistencia.AdministradorIO;
import vista.Ventana;

public class Controlador implements ActionListener
{

	// --------------------------------------------------
	// Asociaciones
	// --------------------------------------------------
	
	private Triqui modelo;
	private Ventana vista;
	private AdministradorIO persistencia;
	
	
	// --------------------------------------------------
	// Constructor
	// --------------------------------------------------
	public Controlador()
		{
			modelo = new Triqui();
			vista = new Ventana(this);
			persistencia = new AdministradorIO(modelo);
			Casilla[][] tablero = modelo.darTablero();
			vista.actualizarPanelTablero(tablero);
			
		}
	
	// --------------------------------------------------
	// Metodos
	// --------------------------------------------------
	
	public void actualizarCasillas(int fila, int columna)
		{
		try
			{
				modelo.actualizarCasilla(fila, columna);
				Casilla[][] tablero = modelo.darTablero();
				vista.actualizarPanelTablero(tablero);
				
				boolean verificacionGanador = modelo.verificarPartida();
				boolean tableroLleno = modelo.verificarTableroLleno();
				
				int pMovJugador1 = modelo.darMovimientosJugador1();
				int pMovJugador2 = modelo.darMovimientosJugador2();
				
				vista.actualizarPanelPartida(pMovJugador1, pMovJugador2);
				actualizarTurno();
				
				if(verificacionGanador == true)
						vista.hayGanador();
				
				else if(tableroLleno == true)
						vista.tableroLleno();
			}
		catch(Exception e)
			{ 
				JOptionPane.showMessageDialog(vista, e.getMessage());
			}
		}
	
	public void reiniciar()
		{
			modelo.reiniciarPartida();
			
			Casilla[][] tableroModelo = modelo.darTablero(); 
			vista.actualizarPanelTablero(tableroModelo);
			
			int pMovJugador1 = modelo.darMovimientosJugador1();
			int pMovJugador2 = modelo.darMovimientosJugador2();
			
			vista.actualizarPanelPartida(pMovJugador1, pMovJugador2);
			actualizarTurno();
		}
	
	public void actualizarTurno()
		{
			String pTurno = modelo.darNombreJugadorTurnoActual();
		
			vista.actualizarTurno(pTurno);
		}
	
	public void cambiarNombre(String pNombreJugador1, String pNombreJugador2)
		{
			modelo.cambiarNombreJugador1(pNombreJugador1);
			modelo.cambiarNombreJugador2(pNombreJugador2);
		}
	
	public void guardarPartida(String pNombrePartida)
		{
			try 
				{
					persistencia.guardarPartida(pNombrePartida);
					
				}
			catch (IOException e) 
				{
					vista.darMensajeError("No se ha podido guardar la partida");
				}
		}
	
	public void cargarPartida()
		{
			try
				{
					persistencia.cargarPartida();
					
					Casilla[][] tablero = modelo.darTablero();
					vista.actualizarPanelTablero(tablero);
					
					String nombreJugador1 = modelo.darNombreJugador1();
					String nombreJugador2 = modelo.darNombreJugador2();
					int pMovJugador1 = modelo.darMovimientosJugador1();
					int pMovJugador2 = modelo.darMovimientosJugador2();
					
					vista.actualizarNombres(nombreJugador1, nombreJugador2);
					vista.actualizarPanelPartida(pMovJugador1, pMovJugador2);
					actualizarTurno();
					
					boolean verificacionGanador = modelo.verificarPartida();
					boolean tableroLleno = modelo.verificarTableroLleno();
					
					if(verificacionGanador == true)
							vista.hayGanador();
					
					else if(tableroLleno == true)
							vista.tableroLleno();
					
					else
							vista.activarTablero();
					
				}
			catch(Exception e)
				{
					vista.darMensajeError("No se ha podido cargar la partida");
				}
		}
	
	@Override
	public void actionPerformed(ActionEvent evento) 
		{
			String comando = evento.getActionCommand();
			
			if(comando.equals(Ventana.NUEVA_PARTIDA))
				{
					this.reiniciar();
					this.vista.getPanelTablero().activarBotones();
				}
			else if(comando.equals(Ventana.CAMBIAR_NOMBRES))
				{
					String nombreJugador1 = JOptionPane.showInputDialog("Ingrese el nombre del primer jugador");
					String nombreJugador2 = JOptionPane.showInputDialog("Ingrese el nombre del segundo jugador");
					
					vista.actualizarNombres(nombreJugador1, nombreJugador2);
					this.cambiarNombre(nombreJugador1, nombreJugador2);
					this.actualizarTurno();
				}
			else if(comando.equals(Ventana.GUARDAR_PARTIDA))
				{
					String nombrePartida = JOptionPane.showInputDialog(this, "Ingrese el nombre de la partida");
					if(nombrePartida != null)
						{
							this.guardarPartida(nombrePartida);
						}
				}
			else if(comando.equals(Ventana.CARGAR_PARTIDA))
				{
					this.cargarPartida();	
				}
			else
				{
					String[] posiciones = comando.split(",");
					int fila = Integer.parseInt( posiciones[0] );
					int columna = Integer.parseInt( posiciones[1] );
					this.actualizarCasillas(fila, columna);
					this.actualizarTurno();
				}
		}
}

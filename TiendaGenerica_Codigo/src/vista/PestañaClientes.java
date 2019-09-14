package vista;

import java.awt.GridLayout;
import java.awt.Image;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import modelo.Cliente;
import modelo.CuotaMensual;

public class Pesta�aClientes extends JPanel
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	private JTabbedPane pesta�as;

	private PanelInicio panelInicio;
	private PanelCrear panelCrear;
	private PanelActualizar panelActualizar;

	public Pesta�aClientes()
	{

		setBorder(new TitledBorder("Clientes"));
		setLayout(new GridLayout(1,1));
		
		pesta�as = new JTabbedPane();

		panelCrear = new PanelCrear();
		panelCrear.getLabDato1().setText("Nombre del cliente");
		panelCrear.getLabDato2().setText("C�dula del cliente");
		panelCrear.getLabDato3().setText("Tel�fono del cliente");
		panelCrear.getLabDato4().setText("G�nero del cliente");
		panelCrear.getRadioButton1().setText("Femenino");
		panelCrear.getRadioButton2().setText("Masculino");
		panelCrear.getRadioButton3().setText("Otro");
		panelCrear.getLabDato5().setText("Correo electronico");
		panelCrear.getLabDato6().setText("Direcci�n de residencia");
		
		panelInicio = new PanelInicio("Imagenes/Banner clientes.png");
		
		panelActualizar = new PanelActualizar("Ingrese la cedula del cliente cuyos datos desea actualizar");
		panelActualizar.getLabDato1().setText("Nombre del cliente");
		panelActualizar.getLabDato2().setText("Tel�fono del cliente");
		panelActualizar.getLabDato3().setText("Correo electronico");
		panelActualizar.getLabDato4().setText("G�nero del cliente");
		panelActualizar.getRadioButton1().setText("Femenino");
		panelActualizar.getRadioButton2().setText("Masculino");
		panelActualizar.getRadioButton3().setText("Otro");
		panelActualizar.getLabDato5().setText("Direcci�n de residencia");
		
		pesta�as.addTab("Inicio", panelInicio);
		ImageIcon imagenInicio = new ImageIcon("Imagenes/Inicio icono.png");
		Icon iconoInicio = new ImageIcon(imagenInicio.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
		pesta�as.setIconAt(0, iconoInicio);
		
		pesta�as.addTab("Crear", panelCrear);
		ImageIcon imagenCrear = new ImageIcon("Imagenes/Crear icono.png");
		Icon iconoCrear = new ImageIcon(imagenCrear.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
		pesta�as.setIconAt(1, iconoCrear);
		
		pesta�as.addTab("Actualizar", panelActualizar);
		ImageIcon imagenActualizar = new ImageIcon("Imagenes/Actualizar icono.png");
		Icon iconoActualizar = new ImageIcon(imagenActualizar.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
		pesta�as.setIconAt(2, iconoActualizar);
		
		add(pesta�as);
		
		pesta�as.setTabPlacement(JTabbedPane.LEFT);
	}
	
	public PanelInicio getPanelInicio()
	{
		return panelInicio;
	}

	public PanelCrear getPanelCrear()
	{
		return panelCrear;
	}

	public PanelActualizar getPanelActualizar() {
		
		return panelActualizar;
	}
	
	
}
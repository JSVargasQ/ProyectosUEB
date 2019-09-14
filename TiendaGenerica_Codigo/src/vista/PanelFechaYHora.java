package vista;

import java.awt.Font;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

import com.toedter.calendar.JCalendar;

public class PanelFechaYHora extends JPanel implements Runnable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private String hora;
	private String minutos;
	private String segundos;
	private String IndicadorAmPm;
	
	private String año;
	private String mes;
	private String dia;
	
	private JLabel labFecha;
	private JLabel labHora;
	
	private Calendar calendario;   
	
	private Date fechaYHoraActual;
	
	private Thread hilo;

	public PanelFechaYHora()
	{

		SpringLayout layout = new SpringLayout();
		setLayout(layout);
		
		labHora = new JLabel();
		labHora.setFont(new Font("Rockwell", Font.ROMAN_BASELINE, 25));
		labHora.setHorizontalAlignment(JLabel.CENTER);
		
		labFecha = new JLabel();
		labFecha.setFont(new Font("Rockwell", Font.ROMAN_BASELINE, 25));
		labFecha.setHorizontalAlignment(JLabel.CENTER);
		
		hilo = new Thread(this);
		hilo.start();

		calcularFecha();
		
		JCalendar calendar = new JCalendar();
		 
		add(calendar);
		add(labFecha);
		add(labHora);
		
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, calendar, -140, SpringLayout.HORIZONTAL_CENTER, this);
		layout.putConstraint(SpringLayout.VERTICAL_CENTER, calendar, 0, SpringLayout.VERTICAL_CENTER, this);
		
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, labFecha, 90, SpringLayout.HORIZONTAL_CENTER, this);
		layout.putConstraint(SpringLayout.VERTICAL_CENTER, labFecha, -50, SpringLayout.VERTICAL_CENTER, this);
		
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, labHora, 90, SpringLayout.HORIZONTAL_CENTER, this);
		layout.putConstraint(SpringLayout.VERTICAL_CENTER, labHora, 0, SpringLayout.VERTICAL_CENTER, this);
	}
	
	public void calcularFecha()
	{
		
		calendario = new GregorianCalendar();
		
		año = Integer.toString(calendario.get(Calendar.YEAR));
		mes = Integer.toString(calendario.get(Calendar.MONTH));
		dia = Integer.toString(calendario.get(Calendar.DAY_OF_MONTH));
		
		labFecha.setText(dia + " / " + mes + " / " + año);
	}

	public void calcularHora() 
	{        
		
		calendario = new GregorianCalendar();
		
		fechaYHoraActual = new Date();
		
		calendario.setTime(fechaYHoraActual);
		
		IndicadorAmPm = calendario.get(Calendar.AM_PM) == Calendar.AM ? "AM" : "PM";

		if(IndicadorAmPm.equals("PM"))
		{
			
			int horaDelDia = calendario.get(Calendar.HOUR_OF_DAY) - 12;
			
			hora = horaDelDia > 9 ? "" + horaDelDia : "0" + horaDelDia;
		}
		else
		{
			hora = calendario.get(Calendar.HOUR_OF_DAY) > 9 ? "" + calendario.get(Calendar.HOUR_OF_DAY) : "0" + calendario.get(Calendar.HOUR_OF_DAY);            
		}
		
		minutos = calendario.get(Calendar.MINUTE) > 9 ? "" + calendario.get(Calendar.MINUTE) : "0" + calendario.get(Calendar.MINUTE);
		segundos = calendario.get(Calendar.SECOND) > 9 ? "" + calendario.get(Calendar.SECOND) : "0" + calendario.get(Calendar.SECOND); 
	}

	public void run() 
	{

		Thread hiloActual = Thread.currentThread();
		
		while(hiloActual == hilo) 
		{   
			
			calcularHora();
			
			labHora.setText(hora + " : " + minutos + " : " + segundos + " " + IndicadorAmPm);
			try 
			{
				
				Thread.sleep(1000);
			} 
			catch(InterruptedException e)
			{
				
			}
		}
	}
}

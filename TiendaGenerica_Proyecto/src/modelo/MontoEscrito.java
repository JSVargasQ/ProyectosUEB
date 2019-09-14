package modelo;

public class MontoEscrito 
{

	private PersistenciaMontoEscrito persistencia;

	private String numeroIngresado;
	private String numeroConvertido;

	public MontoEscrito()
	{
		persistencia = new PersistenciaMontoEscrito();
	}
	
	public void convertir()
	{
		
		if(numeroIngresado.length() == 1)
		{
			this.unDigito();
		}
		if(numeroIngresado.length() == 2)
		{
			this.dosDigitos();
		}
		if(numeroIngresado.length() == 3)
		{
			this.tresDigitos();
		}
		if(numeroIngresado.length() == 4)
		{
			this.cuatroDigitos();
		}
		if(numeroIngresado.length() == 5)
		{
			this.cincoDigitos();
		}
		if(numeroIngresado.length() == 6)
		{
			this.seisDigitos();
		}
		if(numeroIngresado.length() == 7)
		{
			this.sieteDigitos();
		}
		if(numeroIngresado.length() == 8)
		{
			this.ochoDigitos();
		}
		if(numeroIngresado.length() == 9)
		{
			this.nueveDigitos();
		}
	}

	public void unDigito()
	{

		for(int i = 0; i < persistencia.unidadesNumero.length; i++)
		{
			if(numeroIngresado.equals(persistencia.unidadesNumero[i]))
			{
				numeroConvertido = persistencia.unidadesLetra[i];
			}
		}
	}

	public void dosDigitos()
	{

		String numeroTotal = null;

		String unidad = Character.toString(numeroIngresado.charAt(1));

		String decena = Character.toString(numeroIngresado.charAt(0));

		for(int i = 0; i < persistencia.decenasNumero.length; i++)
		{

			if(decena.equals(persistencia.decenasNumero[i]))
			{
				numeroTotal = persistencia.decenasLetra[i];
			}
		}		

		for(int i = 0; i < persistencia.unidadesNumero.length; i++)
		{
			if(unidad.equals(persistencia.unidadesNumero[i]) && decena != "2")
			{
				numeroTotal = numeroTotal + " y " + persistencia.unidadesLetra[i].toLowerCase();
			}
			if(unidad.equals(persistencia.unidadesNumero[i]) && decena.equals("2"))
			{
				numeroTotal = numeroTotal + persistencia.unidadesLetra[i].toLowerCase();
			}
		}

		numeroConvertido = numeroTotal;
	}

	public void tresDigitos()
	{

		String numeroTotal = null;

		String unidad = Character.toString(numeroIngresado.charAt(2));

		String decena = Character.toString(numeroIngresado.charAt(1));

		String centena = Character.toString(numeroIngresado.charAt(0));

		for(int i = 0; i < persistencia.centenasNumero.length; i++)
		{

			if(centena.equals(persistencia.centenasNumero[i]))
			{
				numeroTotal = persistencia.centenasLetra[i]; 
			}
		}

		for(int i = 0; i < persistencia.decenasNumero.length; i++)
		{

			if(decena.equals(persistencia.decenasNumero[i]))
			{
				numeroTotal = numeroTotal + " " + persistencia.decenasLetra[i].toLowerCase();
			}
		}		

		for(int i = 0; i < persistencia.unidadesNumero.length; i++)
		{

			if(unidad.equals(persistencia.unidadesNumero[i]) && decena != "2")
			{
				numeroTotal = numeroTotal + " y " + persistencia.unidadesLetra[i].toLowerCase();
			}
			if(unidad.equals(persistencia.unidadesNumero[i]) && decena.equals("2"))
			{
				numeroTotal = numeroTotal + persistencia.unidadesLetra[i].toLowerCase();
			}
		}

		numeroConvertido = numeroTotal;
	}

	public void cuatroDigitos()
	{

		String numeroTotal = null;	

		String unidad = Character.toString(numeroIngresado.charAt(3));

		String decena = Character.toString(numeroIngresado.charAt(2));

		String centena = Character.toString(numeroIngresado.charAt(1));

		String unidadesDeMil = Character.toString(numeroIngresado.charAt(0));

		for(int i = 0; i < persistencia.unidadesMilNumero.length; i++)
		{

			if(unidadesDeMil.equals("1"))
			{
				numeroTotal = "Mil";
			}
			if(unidadesDeMil.equals(persistencia.unidadesMilNumero[i]))
			{
				numeroTotal = persistencia.unidadesMilLetra[i] + " mil"; 
			}
		}

		for(int i = 0; i < persistencia.centenasNumero.length; i++)
		{

			if(centena.equals(persistencia.centenasNumero[i]))
			{
				numeroTotal = numeroTotal + " " + persistencia.centenasLetra[i].toLowerCase(); 
			}
		}

		for(int i = 0; i < persistencia.decenasNumero.length; i++)
		{

			if(decena.equals(persistencia.decenasNumero[i]))
			{
				numeroTotal = numeroTotal + " " + persistencia.decenasLetra[i].toLowerCase();
			}
		}		

		for(int i = 0; i < persistencia.unidadesNumero.length; i++)
		{

			if(unidad.equals(persistencia.unidadesNumero[i]) && decena != "2")
			{
				numeroTotal = numeroTotal + " y " + persistencia.unidadesLetra[i].toLowerCase();
			}
			if(unidad.equals(persistencia.unidadesNumero[i]) && decena.equals("2"))
			{
				numeroTotal = numeroTotal + persistencia.unidadesLetra[i].toLowerCase();
			}
		}

		numeroConvertido = numeroTotal;
	}

	public void cincoDigitos()
	{

		String numeroTotal = null;	

		String unidad = Character.toString(numeroIngresado.charAt(4));

		String decena = Character.toString(numeroIngresado.charAt(3));

		String centena = Character.toString(numeroIngresado.charAt(2));

		String unidadesDeMil = Character.toString(numeroIngresado.charAt(1));

		String decenasDeMil = Character.toString(numeroIngresado.charAt(0));

		for(int i = 0; i < persistencia.decenasNumero.length; i++)
		{

			if(decenasDeMil.equals(persistencia.decenasNumero[i]))
			{
				numeroTotal = persistencia.decenasLetra[i]; 
			}
		}

		for(int i = 0; i < persistencia.unidadesMilNumero.length; i++)
		{

			if(unidadesDeMil.equals("1"))
			{
				numeroTotal = "Mil";
			}
			if(unidadesDeMil.equals(persistencia.unidadesMilNumero[i]))
			{
				numeroTotal = numeroTotal + " y " + persistencia.unidadesMilLetra[i].toLowerCase() + " mil"; 
			}
		}

		for(int i = 0; i < persistencia.centenasNumero.length; i++)
		{

			if(centena.equals(persistencia.centenasNumero[i]))
			{
				numeroTotal = numeroTotal + " " + persistencia.centenasLetra[i].toLowerCase(); 
			}
		}

		for(int i = 0; i < persistencia.decenasNumero.length; i++)
		{

			if(decena.equals(persistencia.decenasNumero[i]))
			{
				numeroTotal = numeroTotal + " " + persistencia.decenasLetra[i].toLowerCase();
			}
		}		

		for(int i = 0; i < persistencia.unidadesNumero.length; i++)
		{

			if(unidad.equals(persistencia.unidadesNumero[i]) && decena != "2")
			{
				numeroTotal = numeroTotal + " y " + persistencia.unidadesLetra[i].toLowerCase();
			}
			if(unidad.equals(persistencia.unidadesNumero[i]) && decena.equals("2"))
			{
				numeroTotal = numeroTotal + persistencia.unidadesLetra[i].toLowerCase();
			}
		}

		numeroConvertido = numeroTotal;
	}

	public void seisDigitos()
	{

		String numeroTotal = null;	

		String unidad = Character.toString(numeroIngresado.charAt(5));

		String decena = Character.toString(numeroIngresado.charAt(4));

		String centena = Character.toString(numeroIngresado.charAt(3));

		String unidadesDeMil = Character.toString(numeroIngresado.charAt(2));

		String decenasDeMil = Character.toString(numeroIngresado.charAt(1));

		String centenasDeMil = Character.toString(numeroIngresado.charAt(0));

		for(int i = 0; i < persistencia.decenasNumero.length; i++)
		{

			if(centenasDeMil.equals(persistencia.centenasNumero[i]))
			{
				numeroTotal = persistencia.centenasLetra[i]; 
			}
		}

		for(int i = 0; i < persistencia.decenasNumero.length; i++)
		{

			if(decenasDeMil.equals(persistencia.decenasNumero[i]))
			{
				numeroTotal = numeroTotal + " " + persistencia.decenasLetra[i].toLowerCase(); 
			}
		}

		for(int i = 0; i < persistencia.unidadesMilNumero.length; i++)
		{

			if(unidadesDeMil.equals("1"))
			{
				numeroTotal = "Mil";
			}
			if(unidadesDeMil.equals(persistencia.unidadesMilNumero[i]))
			{
				numeroTotal = numeroTotal + " y " + persistencia.unidadesMilLetra[i].toLowerCase() + " mil"; 
			}
		}

		for(int i = 0; i < persistencia.centenasNumero.length; i++)
		{

			if(centena.equals(persistencia.centenasNumero[i]))
			{
				numeroTotal = numeroTotal + " " + persistencia.centenasLetra[i].toLowerCase(); 
			}
		}

		for(int i = 0; i < persistencia.decenasNumero.length; i++)
		{

			if(decena.equals(persistencia.decenasNumero[i]))
			{
				numeroTotal = numeroTotal + " " + persistencia.decenasLetra[i].toLowerCase();
			}
		}		

		for(int i = 0; i < persistencia.unidadesNumero.length; i++)
		{

			if(unidad.equals(persistencia.unidadesNumero[i]) && decena != "2")
			{
				numeroTotal = numeroTotal + " y " + persistencia.unidadesLetra[i].toLowerCase();
			}
			if(unidad.equals(persistencia.unidadesNumero[i]) && decena.equals("2"))
			{
				numeroTotal = numeroTotal + persistencia.unidadesLetra[i].toLowerCase();
			}
		}

		numeroConvertido = numeroTotal;
	}

	public void sieteDigitos()
	{

		String numeroTotal = null;	

		String unidad = Character.toString(numeroIngresado.charAt(6));

		String decena = Character.toString(numeroIngresado.charAt(5));

		String centena = Character.toString(numeroIngresado.charAt(4));

		String unidadesDeMil = Character.toString(numeroIngresado.charAt(3));

		String decenasDeMil = Character.toString(numeroIngresado.charAt(2));

		String centenasDeMil = Character.toString(numeroIngresado.charAt(1));

		String unidadesDeMillon = Character.toString(numeroIngresado.charAt(0));

		for(int i = 0; i < persistencia.unidadesMilNumero.length; i++)
		{

			if(unidadesDeMillon.equals("1"))
			{
				numeroTotal = "Un millon";
			}
			if(unidadesDeMillon.equals(persistencia.unidadesMilNumero[i]))
			{
				numeroTotal = persistencia.unidadesMilLetra[i] + " millones"; 
			}
		}

		for(int i = 0; i < persistencia.decenasNumero.length; i++)
		{

			if(centenasDeMil.equals(persistencia.centenasNumero[i]))
			{
				numeroTotal = numeroTotal + " " + persistencia.centenasLetra[i].toLowerCase(); 
			}
		}

		for(int i = 0; i < persistencia.decenasNumero.length; i++)
		{

			if(decenasDeMil.equals(persistencia.decenasNumero[i]))
			{
				numeroTotal = numeroTotal + " " + persistencia.decenasLetra[i].toLowerCase(); 
			}
		}

		for(int i = 0; i < persistencia.unidadesMilNumero.length; i++)
		{

			if(unidadesDeMil.equals("1"))
			{
				numeroTotal = "Mil";
			}
			if(unidadesDeMil.equals(persistencia.unidadesMilNumero[i]))
			{
				numeroTotal = numeroTotal + " y " + persistencia.unidadesMilLetra[i].toLowerCase() + " mil"; 
			}
		}

		for(int i = 0; i < persistencia.centenasNumero.length; i++)
		{

			if(centena.equals(persistencia.centenasNumero[i]))
			{
				numeroTotal = numeroTotal + " " + persistencia.centenasLetra[i].toLowerCase(); 
			}
		}

		for(int i = 0; i < persistencia.decenasNumero.length; i++)
		{

			if(decena.equals(persistencia.decenasNumero[i]))
			{
				numeroTotal = numeroTotal + " " + persistencia.decenasLetra[i].toLowerCase();
			}
		}		

		for(int i = 0; i < persistencia.unidadesNumero.length; i++)
		{

			if(unidad.equals(persistencia.unidadesNumero[i]) && decena != "2")
			{
				numeroTotal = numeroTotal + " y " + persistencia.unidadesLetra[i].toLowerCase();
			}
			if(unidad.equals(persistencia.unidadesNumero[i]) && decena.equals("2"))
			{
				numeroTotal = numeroTotal + persistencia.unidadesLetra[i].toLowerCase();
			}
		}

		numeroConvertido = numeroTotal;
	}

	public void ochoDigitos()
	{

		String numeroTotal = null;	

		String unidad = Character.toString(numeroIngresado.charAt(7));

		String decena = Character.toString(numeroIngresado.charAt(6));

		String centena = Character.toString(numeroIngresado.charAt(5));

		String unidadesDeMil = Character.toString(numeroIngresado.charAt(4));

		String decenasDeMil = Character.toString(numeroIngresado.charAt(3));

		String centenasDeMil = Character.toString(numeroIngresado.charAt(2));

		String unidadesDeMillon = Character.toString(numeroIngresado.charAt(1));

		String decenasDeMillon = Character.toString(numeroIngresado.charAt(0));
		
		String decenasDeMillonConjunto = Character.toString(numeroIngresado.charAt(0)) + Character.toString(numeroIngresado.charAt(1));

		if(decenasDeMillon.equals("1"));
		{
			for(int i = 0; i < persistencia.especialesNumero.length; i++)
			{
				if(decenasDeMillonConjunto.equals(persistencia.especialesNumero[i]))
				{
					numeroTotal = persistencia.especialesLetra[i] + " millones";
				}
			}
		}	
		if(decenasDeMillon.equals("1") == false)
		{
				
			for(int i = 0; i < persistencia.decenasMillonNumero.length; i++)
			{

				if(decenasDeMillon.equals(persistencia.decenasMillonNumero[i]))
				{
					numeroTotal = persistencia.decenasMillonLetra[i]; 
				}
			}
			for(int i = 0; i < persistencia.unidadesMilNumero.length; i++)
			{

				if(unidadesDeMillon.equals(persistencia.unidadesMilNumero[i]))
				{
					numeroTotal = numeroTotal + " y " + persistencia.unidadesMilLetra[i].toLowerCase() + " millones"; 
				}
			}
		}
		

		for(int i = 0; i < persistencia.centenasNumero.length; i++)
		{

			if(centenasDeMil.equals(persistencia.centenasNumero[i]))
			{
				numeroTotal = numeroTotal + " " + persistencia.centenasLetra[i].toLowerCase(); 
			}
		}

		for(int i = 0; i < persistencia.decenasNumero.length; i++)
		{

			if(decenasDeMil.equals(persistencia.decenasNumero[i]))
			{
				numeroTotal = numeroTotal + " " + persistencia.decenasLetra[i].toLowerCase(); 
			}
		}

		for(int i = 0; i < persistencia.unidadesMilNumero.length; i++)
		{

			if(unidadesDeMil.equals("1"))
			{
				numeroTotal = "Mil";
			}
			if(unidadesDeMil.equals(persistencia.unidadesMilNumero[i]))
			{
				numeroTotal = numeroTotal + " y " + persistencia.unidadesMilLetra[i].toLowerCase() + " mil"; 
			}
		}

		for(int i = 0; i < persistencia.centenasNumero.length; i++)
		{

			if(centena.equals(persistencia.centenasNumero[i]))
			{
				numeroTotal = numeroTotal + " " + persistencia.centenasLetra[i].toLowerCase(); 
			}
		}

		for(int i = 0; i < persistencia.decenasNumero.length; i++)
		{

			if(decena.equals(persistencia.decenasNumero[i]))
			{
				numeroTotal = numeroTotal + " " + persistencia.decenasLetra[i].toLowerCase();
			}
		}		

		for(int i = 0; i < persistencia.unidadesNumero.length; i++)
		{

			if(unidad.equals(persistencia.unidadesNumero[i]) && decena != "2")
			{
				numeroTotal = numeroTotal + " y " + persistencia.unidadesLetra[i].toLowerCase();
			}
			if(unidad.equals(persistencia.unidadesNumero[i]) && decena.equals("2"))
			{
				numeroTotal = numeroTotal + persistencia.unidadesLetra[i].toLowerCase();
			}
		}

		numeroConvertido = numeroTotal;
	}
	
	public void nueveDigitos()
	{
		
		String numeroTotal = null;	

		String unidad = Character.toString(numeroIngresado.charAt(8));

		String decena = Character.toString(numeroIngresado.charAt(7));

		String centena = Character.toString(numeroIngresado.charAt(6));

		String unidadesDeMil = Character.toString(numeroIngresado.charAt(5));

		String decenasDeMil = Character.toString(numeroIngresado.charAt(4));

		String centenasDeMil = Character.toString(numeroIngresado.charAt(3));

		String unidadesDeMillon = Character.toString(numeroIngresado.charAt(2));

		String decenasDeMillon = Character.toString(numeroIngresado.charAt(1));
		
		String decenasDeMillonConjunto = Character.toString(numeroIngresado.charAt(1)) + Character.toString(numeroIngresado.charAt(2));
		
		String centenasDeMillon = Character.toString(numeroIngresado.charAt(0));
		
		for(int i = 0; i < persistencia.centenasNumero.length; i++)
		{
			if(centenasDeMillon.equals(persistencia.centenasNumero[i]))
			{
				numeroTotal = persistencia.centenasLetra[i];
			}
		}

		if(decenasDeMillon.equals("1"));
		{
			for(int i = 0; i < persistencia.especialesNumero.length; i++)
			{
				if(decenasDeMillonConjunto.equals(persistencia.especialesNumero[i]))
				{
					numeroTotal = numeroTotal + " " + persistencia.especialesLetra[i].toLowerCase() + " millones";
				}
			}
		}	
		if(decenasDeMillon.equals("1") == false)
		{
				
			for(int i = 0; i < persistencia.decenasMillonNumero.length; i++)
			{

				if(decenasDeMillon.equals(persistencia.decenasMillonNumero[i]))
				{
					numeroTotal = numeroTotal + " " + persistencia.decenasMillonLetra[i].toLowerCase(); 
				}
			}
			for(int i = 0; i < persistencia.unidadesMilNumero.length; i++)
			{

				if(unidadesDeMillon.equals(persistencia.unidadesMilNumero[i]))
				{
					numeroTotal = numeroTotal + " y " + persistencia.unidadesMilLetra[i].toLowerCase() + " millones"; 
				}
			}
		}
		

		for(int i = 0; i < persistencia.centenasNumero.length; i++)
		{

			if(centenasDeMil.equals(persistencia.centenasNumero[i]))
			{
				numeroTotal = numeroTotal + " " + persistencia.centenasLetra[i].toLowerCase(); 
			}
		}

		for(int i = 0; i < persistencia.decenasNumero.length; i++)
		{

			if(decenasDeMil.equals(persistencia.decenasNumero[i]))
			{
				numeroTotal = numeroTotal + " " + persistencia.decenasLetra[i].toLowerCase(); 
			}
		}

		for(int i = 0; i < persistencia.unidadesMilNumero.length; i++)
		{

			if(unidadesDeMil.equals("1"))
			{
				numeroTotal = "Mil";
			}
			if(unidadesDeMil.equals(persistencia.unidadesMilNumero[i]))
			{
				numeroTotal = numeroTotal + " y " + persistencia.unidadesMilLetra[i].toLowerCase() + " mil"; 
			}
		}

		for(int i = 0; i < persistencia.centenasNumero.length; i++)
		{

			if(centena.equals(persistencia.centenasNumero[i]))
			{
				numeroTotal = numeroTotal + " " + persistencia.centenasLetra[i].toLowerCase(); 
			}
		}

		for(int i = 0; i < persistencia.decenasNumero.length; i++)
		{

			if(decena.equals(persistencia.decenasNumero[i]))
			{
				numeroTotal = numeroTotal + " " + persistencia.decenasLetra[i].toLowerCase();
			}
		}		

		for(int i = 0; i < persistencia.unidadesNumero.length; i++)
		{

			if(unidad.equals(persistencia.unidadesNumero[i]) && decena != "2")
			{
				numeroTotal = numeroTotal + " y " + persistencia.unidadesLetra[i].toLowerCase();
			}
			if(unidad.equals(persistencia.unidadesNumero[i]) && decena.equals("2"))
			{
				numeroTotal = numeroTotal + persistencia.unidadesLetra[i].toLowerCase();
			}
		}

		numeroConvertido = numeroTotal;

	}

	public void cambiarNumeroIngresado(String pNumeroIngresado)
	{

		numeroIngresado = pNumeroIngresado;
	}

	public String darNumeroConvertido()
	{

		return numeroConvertido + " euros";
	}

}

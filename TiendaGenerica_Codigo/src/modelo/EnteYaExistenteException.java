package modelo;

public class EnteYaExistenteException extends Exception
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EnteYaExistenteException()
	{
		super("El dato de identificacion ya esta registrado.");		
	}
}

package modelo;

public class EnteNoExisteException extends Exception
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EnteNoExisteException()
	{
		super("No se encuentra información relacionada con los datos ingresados.");
	}
}

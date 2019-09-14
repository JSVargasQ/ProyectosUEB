package modelo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

public class Configuracion 
{
	
	private String archivoConfigProp;
	private File archivoParametrizacion;
	private File archivoPropiedades;
	private Properties propiedades;
	
	
	public Configuracion()
	{
		this.archivoConfigProp = "./data/configuracion.properties";		
		this.archivoPropiedades = new File(archivoConfigProp);
		this.archivoParametrizacion = new File("./data/default.properties");
		this.propiedades = new Properties();			
	}
	
	public String[] getArchivosPersistencia()
	{
		String[] archivos = new String[11];
		
		try
		{
			this.propiedades.load(new FileInputStream(archivoPropiedades));
			
			archivos[0] = propiedades.getProperty("archivoClientes");
			archivos[1] = propiedades.getProperty("archivoProveedores");
			archivos[2] = propiedades.getProperty("archivoProductos");
			archivos[3] = propiedades.getProperty("archivoVentas");
			archivos[4] = propiedades.getProperty("archivoCompras");
			archivos[5] = propiedades.getProperty("rutaDetallesVentas");
			archivos[6] = propiedades.getProperty("rutaCreditos");
			archivos[7] = propiedades.getProperty("rutaDetalleCompras");
			archivos[8] = propiedades.getProperty("rutaCheques");
			archivos[9] = propiedades.getProperty("tasaInteres");
			archivos[10] = propiedades.getProperty("iva");
		}
		catch (Exception e)
		{
			
		}
		
		return archivos;
	}

	public String[] getDatosDefault()
	{
		String[] datosDefault  = new String[5];
		
		try
		{
			this.propiedades = new Properties();
			this.propiedades.load(new FileInputStream(archivoParametrizacion));
			
			datosDefault[0] = propiedades.getProperty("nombreTienda");
			datosDefault[1] = propiedades.getProperty("nombreGerente");
			datosDefault[2] = propiedades.getProperty("tipoTienda");
			datosDefault[3] = propiedades.getProperty("ciudad");
			datosDefault[4] = propiedades.getProperty("nit");
		}
		catch (Exception e)
		{
			
		}
		
		return datosDefault;
	}
	
	public void guardarDatosDefault(TiendaGenerica pModelo)
	{
		try
		{
			FileOutputStream out = new FileOutputStream(archivoParametrizacion);
			propiedades = new Properties();
			propiedades.setProperty("nombreTienda", pModelo.getNombreTienda());
			propiedades.setProperty("nombreGerente", pModelo.getNombreGerente());
			propiedades.setProperty("tipoTienda", pModelo.getTipoTienda());
			propiedades.setProperty("ciudad", pModelo.getCiudad());
			propiedades.setProperty("nit", String.valueOf(pModelo.getNit()));
			
			propiedades.store(out, "Default");
			
			out.close();
		}
		catch (Exception e)
		{
			
		}
	}
	
}

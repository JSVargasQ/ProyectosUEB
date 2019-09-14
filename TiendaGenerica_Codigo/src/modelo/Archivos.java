package modelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Archivos 
{

	private File file;
	private FileWriter fileWriter;
	private FileReader fileReader;
	private PrintWriter printWriter;
	private BufferedReader bufferedReader;
	
	private String archivoClientes;
	private String archivoProveedores;
	private String archivoProductos;
	private String archivoVentas;
	private String archivoCompras;
	private String rutaDetallesVentas;	
	private String rutaCreditos;
	private String rutaDetallesCompras;
	private String rutaCheques;
	
	private int ultimaVentaRegistrada;
	private int ultimoChequeRegistrado;
	
	
	public Archivos()
	{
		this.archivoClientes = "";
		this.archivoProveedores = "";
		this.archivoProductos = "";
		this.archivoVentas = "";
		this.archivoCompras = "";
		this.rutaDetallesVentas = "";
		this.rutaCreditos = "";
		this.rutaDetallesCompras = "";
		this.rutaCheques = "";
		
		this.ultimaVentaRegistrada = -1;
		this.ultimoChequeRegistrado = -1;
	}
	
	public File getFile() 
	{
		return file;
	}
	
	public void setFile(File pFile) 
	{
		this.file = pFile;
	}
	
	public FileWriter getFileWriter() 
	{
		return fileWriter;
	}
	
	public void setFileWriter(FileWriter pFileWriter)
	{
		this.fileWriter = pFileWriter;
	}
	
	public FileReader getFileReader() 
	{
		return fileReader;
	}
	
	public void setFileReader(FileReader pFileReader)
	{
		this.fileReader = pFileReader;
	}
	
	public PrintWriter getPrintWriter() 
	{
		return printWriter;
	}
	
	public void setPrintWriter(PrintWriter pPrintWriter) 
	{
		this.printWriter = pPrintWriter;
	}
	
	public BufferedReader getBufferedReader()
	{
		return bufferedReader;
	}
	
	public void setBufferedReader(BufferedReader pBufferedReader) 
	{
		this.bufferedReader = pBufferedReader;
	}
		
	public String getArchivoClientes() 
	{
		return archivoClientes;
	}
	
	public void setArchivoClientes(String pArchivoClientes)
	{
		this.archivoClientes = pArchivoClientes;
	}
	
	public String getArchivoProveedores() 
	{
		return archivoProveedores;
	}
	
	public void setArchivoProveedores(String pArchivoProveedores)
	{
		this.archivoProveedores = pArchivoProveedores;
	}
	
	public String getArchivoProductos()
	{
		return archivoProductos;
	}
	
	public void setArchivoProductos(String pArchivoProductos)
	{
		this.archivoProductos = pArchivoProductos;
	}
		
	public String getArchivoVentas() 
	{
		return archivoVentas;
	}

	public void setArchivoVentas(String pArchivoVentas) 
	{
		this.archivoVentas = pArchivoVentas;
	}

	public String getRutaDetallesVentas()
	{
		return rutaDetallesVentas;
	}

	public void setRutaDetallesVentas(String pRutaDetallesVentas)
	{
		this.rutaDetallesVentas = pRutaDetallesVentas;
	}

	public int getUltimaVentaRegistrada() 
	{
		return ultimaVentaRegistrada;
	}

	public void setUltimaVentaRegistrada(int pUltimaVentaRegistrada) 
	{
		this.ultimaVentaRegistrada = pUltimaVentaRegistrada;
	}
	
	public String getRutaCreditos() 
	{
		return rutaCreditos;
	}

	public void setRutaCreditos(String pRutaCreditos) 
	{
		this.rutaCreditos = pRutaCreditos;
	}

	public String getArchivoCompras() 
	{
		return archivoCompras;
	}

	public void setArchivoCompras(String pArchivoCompras) 
	{
		this.archivoCompras = pArchivoCompras;
	}

	public String getRutaDetalleCompras() 
	{
		return rutaDetallesCompras;
	}

	public void setRutaDetalleCompras(String pRutaDetalleCompras) 
	{
		this.rutaDetallesCompras = pRutaDetalleCompras;
	}

	public String getRutaCheques() 
	{
		return rutaCheques;
	}

	public void setRutaCheques(String pRutaCheques) 
	{
		this.rutaCheques = pRutaCheques;
	}

	public int getUltimoChequeRegistrado() 
	{
		return ultimoChequeRegistrado;
	}

	public void setUltimoChequeRegistrado(int pUltimoChequeRegistrado) 
	{
		this.ultimoChequeRegistrado = pUltimoChequeRegistrado;
	}

	public void guardarClientes(ArrayList<Cliente> pClientes)
	{
		try
		{
			this.file = new File(archivoClientes);
			this.file.createNewFile();
			this.fileWriter = new FileWriter(this.file, false);
			this.printWriter = new PrintWriter(this.fileWriter);
			
			for (int i = 0; i < pClientes.size(); i++) 
			{
				Cliente actual = pClientes.get(i);
				
				this.printWriter.print(actual.getCedula() + ";");
				this.printWriter.print(actual.getNombre() + ";");
				this.printWriter.print(actual.getGenero() + ";");
				this.printWriter.print(actual.getTelefono() + ";");
				this.printWriter.print(actual.getCorreoElectronico() + ";");
				this.printWriter.print(actual.getDireccion());
				this.printWriter.println("");
			}
			
			this.fileWriter.close();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public void guardarProveedores(ArrayList<Proveedor> pProveedores)
	{
		try
		{
			this.file = new File(archivoProveedores);
			this.file.createNewFile();
			this.fileWriter = new FileWriter(this.file);
			this.printWriter = new PrintWriter(this.fileWriter);
			
			for (int i = 0; i < pProveedores.size(); i++) 
			{
				Proveedor actual = pProveedores.get(i);
				
				this.printWriter.print(actual.getNit() + ";");
				this.printWriter.print(actual.getNombre() + ";");
				this.printWriter.print(actual.getTipoProveedor() + ";");
				this.printWriter.print(actual.getTelefono() + ";");
				this.printWriter.print(actual.getCiudad() + ";");
				this.printWriter.println(actual.getDireccion());
			}
			
			this.fileWriter.close();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void guardarProductos(ArrayList<Producto> pProductos)
	{
		try
		{
			this.file = new File(archivoProductos);
			this.file.createNewFile();
			this.fileWriter = new FileWriter(this.file);
			this.printWriter = new PrintWriter(this.fileWriter);
			
			for (int i = 0; i < pProductos.size(); i++) 
			{
				Producto actual = pProductos.get(i);
				
				this.printWriter.print(actual.getCodigoProducto() + ";");
				this.printWriter.print(actual.getNombreProducto() + ";");
				this.printWriter.print(actual.getValorVentaProducto() + ";");
				this.printWriter.print(actual.getValorCompraProducto() + ";");
				this.printWriter.print(actual.getNitProveedor() + ";");
				this.printWriter.println(actual.getTipoProducto());
			}
			
			this.fileWriter.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public ArrayList<Cliente> cargarClientes()
	{
		ArrayList<Cliente> clientesCargados = new ArrayList<>();
		
		try
		{	
			this.file = new File(archivoClientes);

			if(this.file.exists() == true)
			{
				this.fileReader = new FileReader(this.file);
				this.bufferedReader = new BufferedReader(this.fileReader);
				String linea = this.bufferedReader.readLine();

				while(linea != null)
				{
					String[] lineaDatos = linea.split(";");

					Cliente nuevo = new Cliente();
					nuevo.setCedula(Integer.parseInt(lineaDatos[0]));
					nuevo.setNombre(lineaDatos[1]);
					nuevo.setGenero(lineaDatos[2]);
					nuevo.setTelefono(Integer.parseInt(lineaDatos[3]));
					nuevo.setCorreoElectronico(lineaDatos[4]);
					nuevo.setDireccion(lineaDatos[5]);

					clientesCargados.add(nuevo);

					linea = this.bufferedReader.readLine();
				}
				
				this.fileReader.close();
			}
			else
			{
				this.file.createNewFile();
			}

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return clientesCargados;
	}
	
	public ArrayList<Proveedor> cargarProveedores()
	{
		ArrayList<Proveedor> proovedoresCargados = new ArrayList<>();
		
		try
		{	
			this.file = new File(archivoProveedores);
			
			if(this.file.exists() == true)
			{
				this.fileReader = new FileReader(this.file);
				this.bufferedReader = new BufferedReader(this.fileReader);
				String linea = this.bufferedReader.readLine();
				
				while(linea != null)
				{
					String[] lineaDatos = linea.split(";");
						
					Proveedor nuevo = new Proveedor();
					nuevo.setNit(Integer.parseInt(lineaDatos[0]));
					nuevo.setNombre(lineaDatos[1]);
					nuevo.setTipoProveedor(lineaDatos[2]);
					nuevo.setTelefono(Integer.parseInt(lineaDatos[3]));
					nuevo.setCiudad(lineaDatos[4]);
					nuevo.setDireccion(lineaDatos[5]);
					
					proovedoresCargados.add(nuevo);
					
					linea = this.bufferedReader.readLine();
				}
				
				this.fileReader.close();
			}
			else
			{
				this.file.createNewFile();
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return proovedoresCargados;
	}
	
	public ArrayList<Producto> cargarProductos()
	{
		ArrayList<Producto> productosCargados = new ArrayList<>();
		
		try
		{	
			this.file = new File(archivoProductos);
			
			if(this.file.exists() == true)
			{
				this.fileReader = new FileReader(this.file);
				this.bufferedReader = new BufferedReader(this.fileReader);
				String linea = this.bufferedReader.readLine();
				
				while(linea != null)
				{
					String[] lineaDatos = linea.split(";");
						
					Producto nuevo = new Producto();
					nuevo.setCodigoProducto(Integer.parseInt(lineaDatos[0]));
					nuevo.setNombreProducto(lineaDatos[1]);
					nuevo.setValorVentaProducto(Double.parseDouble(lineaDatos[2]));
					nuevo.setValorCompraProducto(Double.parseDouble(lineaDatos[3]));
					nuevo.setNitProveedor(Integer.parseInt(lineaDatos[4]));
					nuevo.setTipoProducto(lineaDatos[5]);
					
					productosCargados.add(nuevo);
					
					linea = this.bufferedReader.readLine();
				}
				this.fileReader.close();
			}
			else
			{
				this.file.createNewFile();
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return productosCargados;
	}
	
	public void guardarVenta(DetalleVenta pDetalleVenta)
	{
		try
		{
			this.file = new File(archivoVentas);
			
			if(this.file.exists() == false)
			{
				this.file.createNewFile();				
			}
			
			this.fileWriter = new FileWriter(this.file, true);
			this.printWriter = new PrintWriter(this.fileWriter);

			printWriter.print(pDetalleVenta.getCodigoDetalleVenta() + ";");
			printWriter.print(pDetalleVenta.getCedulaClienteVenta() + ";");
			printWriter.print(pDetalleVenta.getValorTotal() + ";");
			printWriter.print(pDetalleVenta.getValorIVA() + ";");
			printWriter.println(pDetalleVenta.getValorMasIVA());

			this.fileWriter.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void guardarDetalleVenta(DetalleVenta pDetalleVenta)
	{
		try
		{
			this.file = new File(rutaDetallesVentas + pDetalleVenta.getCodigoDetalleVenta() + ".txt");
			this.file.createNewFile();
			this.fileWriter = new FileWriter(this.file);
			this.printWriter = new PrintWriter(this.fileWriter);
			
			for (int i = 0; i < pDetalleVenta.getCodigoProducto().size(); i++) 
			{
				printWriter.print(pDetalleVenta.getCodigoProducto().get(i) + ";");
				printWriter.print(pDetalleVenta.getCantidadProducto().get(i) + ";");
				printWriter.print(pDetalleVenta.getValorVentaProducto().get(i) + ";");
				printWriter.println(  (pDetalleVenta.getValorVentaProducto().get(i) * (double)pDetalleVenta.getCantidadProducto().get(i) )  );				
			}
			
			this.ultimaVentaRegistrada = pDetalleVenta.getCodigoDetalleVenta();
			this.fileWriter.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public ArrayList<DetalleVenta> cargarDetallesVentas(double pIva)
	{
		ArrayList<DetalleVenta> datosDetalleVenta = new ArrayList<>();

		try
		{
			int i = 1;
			this.file = new File(rutaDetallesVentas + i + ".txt");
			if(this.file.exists() == true)
			{
				while(this.file.exists() == true)
				{
					this.fileReader = new FileReader(this.file);
					this.bufferedReader = new BufferedReader(this.fileReader);
					
					DetalleVenta nuevo = new DetalleVenta();
					nuevo.setCodigoDetalleVenta(i);

					String linea = this.bufferedReader.readLine();

					while(linea != null) 
					{
						String[] lineaDatos = linea.split(";");

						nuevo.getCodigoProducto().add(Integer.parseInt(lineaDatos[0]));
						nuevo.getCantidadProducto().add(Integer.parseInt(lineaDatos[1]));
						nuevo.getValorVentaProducto().add(Double.parseDouble(lineaDatos[2]));

						linea = this.bufferedReader.readLine();
					}

					File fileArchivoVentas = new File(archivoVentas);
					FileReader fileReaderArchivoVentas = new FileReader(fileArchivoVentas);
					BufferedReader fileBufferReader = new BufferedReader(fileReaderArchivoVentas);

					boolean cedulaCambiada = false;

					while(cedulaCambiada == false)
					{
						String dataFileVentas = fileBufferReader.readLine();
						String[] datosFileVentas = dataFileVentas.split(";");

						if(Integer.parseInt(datosFileVentas[0]) == i)
						{
							nuevo.setCedulaClienteVenta(Integer.parseInt(datosFileVentas[1]));
							cedulaCambiada = true;
							fileReaderArchivoVentas.close();
						}
					}

					nuevo.calcularValorTotal();
					nuevo.calcularValoresIVA(pIva);
					
					datosDetalleVenta.add(nuevo);

					this.fileReader.close();

					i++;
					this.file = new File(rutaDetallesVentas + i + ".txt");
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return datosDetalleVenta;
	}
	
	public void guardarCredito(String pNombreCliente, String pCedulaCliente, String[] pCredito)
	{
		try
		{
			this.file = new File(rutaCreditos + pCedulaCliente + ".txt");
			this.fileWriter = new FileWriter(this.file);
			this.printWriter = new PrintWriter(this.fileWriter);
			
			printWriter.println(pNombreCliente);
			printWriter.println(pCedulaCliente);
			
			for (int i = 0; i < pCredito.length; i++) 
			{
				printWriter.println(pCredito[i]);
			}
			
			this.fileWriter.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void guardarCompra(DetalleCompra pDetalleCompra)
	{
		try
		{
			this.file = new File(archivoCompras);
			
			if(this.file.exists() == false)
			{
				this.file.createNewFile();				
			}
			
			this.fileWriter = new FileWriter(this.file, true);
			this.printWriter = new PrintWriter(this.fileWriter);

			printWriter.print(pDetalleCompra.getCodigoDetalleCompra() + ";");
			printWriter.print(pDetalleCompra.getNitProveedorCompra() + ";");
			printWriter.print(pDetalleCompra.getValorTotal() + ";");
			printWriter.print(pDetalleCompra.getValorIVA() + ";");
			printWriter.println(pDetalleCompra.getValorMasIVA());

			this.fileWriter.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void guardarDetalleCompra(DetalleCompra pDetalleCompra)
	{
		try
		{
			this.file = new File(rutaDetallesCompras + pDetalleCompra.getCodigoDetalleCompra() + ".txt");
			this.file.createNewFile();
			this.fileWriter = new FileWriter(this.file);
			this.printWriter = new PrintWriter(this.fileWriter);
			
			for (int i = 0; i < pDetalleCompra.getCodigoProducto().size(); i++) 
			{
				printWriter.print(pDetalleCompra.getCodigoProducto().get(i) + ";");
				printWriter.print(pDetalleCompra.getCantidadProducto().get(i) + ";");
				printWriter.print(pDetalleCompra.getValorCompraProducto().get(i) + ";");
				printWriter.println(  (pDetalleCompra.getValorCompraProducto().get(i) * (double)pDetalleCompra.getCantidadProducto().get(i) )  );				
			}
			
			this.ultimaVentaRegistrada = pDetalleCompra.getCodigoDetalleCompra();
			this.fileWriter.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public ArrayList<DetalleCompra> cargarDetallesCompras(double pIva)
	{
		ArrayList<DetalleCompra> datosDetalleCompra = new ArrayList<>();

		try
		{
			int i = 1;
			this.file = new File(rutaDetallesCompras + i + ".txt");
			if(this.file.exists() == true)
			{
				while(this.file.exists() == true)
				{
					this.fileReader = new FileReader(this.file);
					this.bufferedReader = new BufferedReader(this.fileReader);
					
					DetalleCompra nuevo = new DetalleCompra();
					nuevo.setCodigoDetalleCompra(i);

					String linea = this.bufferedReader.readLine();

					while(linea != null) 
					{
						String[] lineaDatos = linea.split(";");

						nuevo.getCodigoProducto().add(Integer.parseInt(lineaDatos[0]));
						nuevo.getCantidadProducto().add(Integer.parseInt(lineaDatos[1]));
						nuevo.getValorCompraProducto().add(Double.parseDouble(lineaDatos[2]));

						linea = this.bufferedReader.readLine();
					}

					File fileArchivoCompras = new File(archivoCompras);
					FileReader fileReaderArchivoCompras = new FileReader(fileArchivoCompras);
					BufferedReader fileBufferReader = new BufferedReader(fileReaderArchivoCompras);

					boolean nitCambiado = false;

					while(nitCambiado == false)
					{
						String dataFileCompras = fileBufferReader.readLine();
						String[] datosFileCompras = dataFileCompras.split(";");

						if(Integer.parseInt(datosFileCompras[0]) == i)
						{
							nuevo.setNitProveedorCompra(Integer.parseInt(datosFileCompras[1]));
							nitCambiado = true;
							fileReaderArchivoCompras.close();
						}
					}

					nuevo.calcularValorTotal();
					nuevo.calcularValoresIVA(pIva);
					
					datosDetalleCompra.add(nuevo);

					this.fileReader.close();

					i++;
					this.file = new File(rutaDetallesVentas + i + ".txt");
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return datosDetalleCompra;
	}
	
	public void guardarCheque(Cheque pCheque)
	{
		try
		{
			this.file = new File(rutaCheques + pCheque.getConsecutivoCheque() + ".txt");
			this.fileWriter = new FileWriter(this.file);
			this.printWriter = new PrintWriter(this.fileWriter);
			
			printWriter.println(pCheque.getConsecutivoCheque());
			printWriter.println(pCheque.getNombre());
			printWriter.println(pCheque.getNombreBanco());
			printWriter.println(pCheque.getNombreProveedor());
			printWriter.println(pCheque.getNombreProveedor());
			printWriter.println(pCheque.getNumeroCuenta());
			printWriter.println(pCheque.getValorCifra());
			printWriter.println(pCheque.getValorMontoEscrito());
			
			this.fileWriter.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
	
}

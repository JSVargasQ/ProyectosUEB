package com.gsa.beans;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

import com.gsa.dao.ElementoDAO;
import com.gsa.dao.implem.ProductoDAOImplem;
import com.gsa.entity.Producto;


@ManagedBean
@SessionScoped
public class ProductoBean
{

	private static final long serialVersionUID = 1L;
	
	
	private Producto producto;
	private DataModel<Producto> listaProductos;
	
	private Producto[] productosMostrar;
	
	private UploadedFile file;
	
	
	public String prepararAgregarProducto()
	{
		this.producto = new Producto();
		return "RegistroObras.xhtml?faces-redirect=true";
	}
	
	public String agregarProducto()
	{
		this.upload();
		ElementoDAO<Producto> ProductoDao = new ProductoDAOImplem();
		this.producto.setActivo("A");
		this.producto.setRutaFoto( this.file.getFileName() );
		ProductoDao.add(this.producto);
		return "ListaDeObras.xhtml?faces-redirect=true";
	}
		
	public String mostrarProducto()
	{
		this.producto = (Producto)( this.listaProductos.getRowData() );
		return "/obras/Obra.xhtml?faces-redirect=true";
	}
	
	public String mostrarProducto(int i)
	{
		this.producto = this.productosMostrar[i];
		return "./obras/Obra.xhtml?faces-redirect=true";
	}
	
	public String prepararModificarProducto()
	{
		this.producto = (Producto)( this.listaProductos.getRowData() );
		return "RegistroObras.xhtml?faces-redirect=true";
	}
	
	public String modificarProducto()
	{
		ElementoDAO<Producto> productoDao = new ProductoDAOImplem();
		productoDao.update(this.producto);
		return "ListaDeObras.xhtml?faces-redirect=true";
	}
	
	public String eliminarProducto()
	{
		Producto productoActual = (Producto)( this.listaProductos.getRowData() );
		ElementoDAO<Producto> productoDao = new ProductoDAOImplem();
		if( productoActual.getActivo().equals("A") )
			productoActual.setActivo("I");
		else
			productoActual.setActivo("A");

		productoDao.update(productoActual);
		return null;
	}
	
	public DataModel<Producto> getAllProductos()
	{
		List<Producto> listaProductos = new ProductoDAOImplem().getAllElementos();
		this.listaProductos = new ListDataModel<Producto>(listaProductos);
		return this.listaProductos;
	}

	public Producto getProducto() 
	{
		return producto;
	}

	public void setProducto(Producto producto)
	{
		this.producto = producto;
	}
	
	public void obtenerObras()
	{
		List<Producto> obras = new ProductoDAOImplem().getAllElementos();

		Object[] allObras = obras.toArray();

		if(allObras.length != 0)
		{
			this.productosMostrar = new Producto[5];
			int obrasAgregadas = 0;

			while(obrasAgregadas < 5)
			{
				int idObra = (int)(Math.random()*allObras.length);
				Producto actual = (Producto) (allObras[idObra]);
				if(actual.getActivo().equals("A"))
				{
					this.productosMostrar[obrasAgregadas] = actual;
					obrasAgregadas++;
				}
			}
		}
	}

	public Producto[] getProductosMostrar() 
	{
		return productosMostrar;
	}

	public void setProductosMostrar(Producto[] productosMostrar)
	{
		this.productosMostrar = productosMostrar;
	}

	public boolean existenObras()
	{
		List<Producto> listaProductos = new ProductoDAOImplem().getAllElementos();
		return (listaProductos.size() != 0);
	}
	
	public int numObraAgregar()
	{
		return ( (new ProductoDAOImplem().getAllElementos().size()) + 1);
	}	
	
	public boolean existeObra()
	{
		ProductoDAOImplem productoDao = new ProductoDAOImplem();
		System.out.println("Id: " + this.producto.getId());
		Producto existe = productoDao.getElemento(this.producto.getId());
		System.out.println("Existe obra: " + existe);
		
		if(existe != null)
			return true;
		return false;
	}
	 	
	
	
	 
    public UploadedFile getFile() {
        return file;
    }
 
    public void setFile(UploadedFile file) {
        this.file = file;
    }
     
    public void upload()
    {
        if(file != null)
        {
            FacesMessage message = new FacesMessage("Succesful", file.getFileName() + " is uploaded.");
            FacesContext.getCurrentInstance().addMessage(null, message);
            
            
            try
            {
            	OutputStream out = new FileOutputStream(new File("/resources" + file.getFileName()));
            	int read = 0;
            	byte[] bytes = new byte[1024];
            	
            	InputStream in = file.getInputstream();
            	while ((read = in.read(bytes)) != -1)
            	{
					out.write(bytes, 0, read);
				}
            	
            	
            }
            catch(Exception e)
            {
            
            }
        }

    }
     
    public void handleFileUpload(FileUploadEvent event)
    {
    	this.file = event.getFile();
        FacesMessage msg = new FacesMessage("Succesful", event.getFile().getFileName() + " is uploaded.");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    
    
	 	 

}

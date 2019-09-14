package modelo;

import java.util.ArrayList;

public class Compra 
{

	private Cheque cheque;
	private ArrayList<DetalleCompra> detallesCompras;
	private int codigoUltimaCompra;
	
	private MontoEscrito montoEscrito;
	
	public Compra()
	{
		this.cheque = new Cheque();
		this.montoEscrito = new MontoEscrito();
		this.detallesCompras = new ArrayList<>();
		this.codigoUltimaCompra = -1;
	}
	
	public void calcularMontoEscrito()
	{
		this.montoEscrito.cambiarNumeroIngresado(String.valueOf(this.cheque.getValorCifra()));
		this.montoEscrito.convertir();
		this.cheque.setValorMontoEscrito( this.montoEscrito.darNumeroConvertido() );
	}

	public Cheque getCheque() 
	{
		return cheque;
	}

	public MontoEscrito getMontoEscrito()
	{
		return montoEscrito;
	}
	
	public ArrayList<DetalleCompra> getDetallesCompras() 
	{
		return detallesCompras;
	}

	public void setCheque(Cheque pCheque)
{
		this.cheque = pCheque;
	}

	public void setDetallesCompras(ArrayList<DetalleCompra> pDetallesCompras) 
	{
		this.detallesCompras = pDetallesCompras;
	}

	public int getCodigoUltimaCompra()
	{
		return codigoUltimaCompra;
	}

	public void setCodigoUltimaCompra(int pCodigoUltimaCompra)
	{
		this.codigoUltimaCompra = pCodigoUltimaCompra;
	}
	
	
}

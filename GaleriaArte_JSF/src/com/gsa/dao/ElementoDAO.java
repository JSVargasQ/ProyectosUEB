package com.gsa.dao;

import java.util.List;

public interface ElementoDAO<E>
{

	public void add(E pElemento);

	public E getElemento(long pId);

	public List<E> getAllElementos();

	public void remove(E pElemento);

	public void update(E pElemento);
	
}

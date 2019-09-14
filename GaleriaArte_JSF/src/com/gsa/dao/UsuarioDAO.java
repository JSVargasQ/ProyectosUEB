package com.gsa.dao;

import java.util.List;

import com.gsa.entity.Usuario;

public interface UsuarioDAO 
{

	public void add(Usuario pUsuario);

	public Usuario getElemento(long pId);
	
	public Usuario verificaUsuario(String pUserName, String pPassword);

	public List<Usuario> getAllElementos();

	public void remove(Usuario pUsuario);

	public void update(Usuario pUsuario);
	
	
}

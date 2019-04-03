package controllers;
import javax.faces.bean.ManagedBean;

import dao.UsuarioDao;
import models.UsuarioBean;

@ManagedBean
public class Controlador {

	private UsuarioBean usuario;

	public Controlador() {
		usuario = new UsuarioBean();
	}
	
	
	public UsuarioBean getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioBean usuario) {
		this.usuario = usuario;
	}

	
	public String autenticarUsuario() {
		UsuarioDao usuarioDao = new UsuarioDao();
		return usuarioDao.autenticarUsuario(usuario);
	}
	
	public String cadastrarUsuario() {
		UsuarioDao usuarioDao = new UsuarioDao();
		return usuarioDao.cadastrarUsuario(usuario);
	}
	
	
}

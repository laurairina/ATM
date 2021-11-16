package es.springboot.atm.dao;

import es.springboot.atm.model.Usuario;

public interface UsuarioDao{
	public Usuario getForUser (Usuario jsonLogin);
	public void fillData();
	public Usuario getDispenseMoney(Usuario jsonLogin);
}

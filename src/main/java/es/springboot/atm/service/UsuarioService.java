package es.springboot.atm.service;

import es.springboot.atm.model.Usuario;

public interface UsuarioService {

	public Usuario authentication(Usuario jsonLogin);
	public Usuario  userDispense(Usuario jsonLogin); 
	public void fillData();
}

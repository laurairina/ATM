package es.springboot.atm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;

import es.springboot.atm.dao.UsuarioDao;
import es.springboot.atm.model.Usuario;

@Service 
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired 
	private UsuarioDao usuarioDao; 
	
	@Override
	public Usuario authentication(Usuario jsonLogin) {
	   Usuario u = usuarioDao.getForUser(jsonLogin); //este metodo esta primero en la interfaz
		
		if (u == null)  
			return null;
		else
			return u;
	}

	@Override
	public Usuario userDispense(Usuario jsonLogin) {
	    Usuario u= usuarioDao.getDispenseMoney(jsonLogin);
		
		return u;
	}

	@Override
	public void fillData() {
		usuarioDao.fillData();
		
	}

}

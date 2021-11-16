package es.springboot.atm.testFactory;

import es.springboot.atm.model.Usuario;

public class TestFactory {

	public static Usuario firstAccount() {
		Usuario u= new Usuario();
		u.setPin("1234");
		u.setUser("123456789");
		u.setOverdraft(200);
		return u;
	}

}

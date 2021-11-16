package es.springboot.atm.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import es.springboot.atm.model.Money;
import es.springboot.atm.model.Usuario;
import lombok.Data;

@Component 
public class UsuarioDaoImpl implements UsuarioDao {
	
	private List<Usuario> userData= new ArrayList<>() ;
	
	@Override
	public Usuario getForUser(Usuario jsonLogin) {
		Usuario userFind= null;
	    int i=0;
	    boolean find=false;
	    while(i<userData.size() && find!=true ){
	    	Usuario u=userData.get(i);
	    	if(u.getUser().equals(jsonLogin.getUser())){
	    		userFind=u;
	    		find=true;
	    	}
	    	i++;
	    }
	
		return userFind;
	}

	@Override
	public void fillData() {
	   Money money= new Money(10,10,10,9);
	   Usuario usuarioFirst= new Usuario("123456789","1234",money);
	   userData.add(usuarioFirst);
	   
	    money= new Money(10,21,21,20);
	  usuarioFirst= new Usuario("987654321","4321",money);
	  userData.add(usuarioFirst);
		
	}
	
	@Override
	public Usuario getDispenseMoney(Usuario jsonLogin) {
		Usuario u= getForUser(jsonLogin);
		Usuario user=new Usuario();
		user.setOverdraft(jsonLogin.getOverdraft());
		user.setPin(u.getPin());
		user.setUser(u.getUser());
		
		if(jsonLogin.getOverdraft()< u.getMoney().getAmounts()) {
			   
				Money m= new Money(u.getMoney().getMoney5(),u.getMoney().getMoney10(), u.getMoney().getMoney20(),u.getMoney().getMoney50()); //user.getMoney();	
				
				user.setMoney(m.newTotalmoney(jsonLogin.getOverdraft()));
				
				int minus=u.getMoney().getMoney5()-user.getMoney().getMoney5();
				String money5=(minus==0)?"":minus+" of €5 "; 
				
				minus=u.getMoney().getMoney10()-user.getMoney().getMoney10();
				String money10=(minus==0)?"":minus+" of €10, "; 
				
				minus=u.getMoney().getMoney20()-user.getMoney().getMoney20();
				String money20=(minus==0)?"":minus+" of €20, ";
				
				minus=u.getMoney().getMoney50()-user.getMoney().getMoney50();
				String money50=(minus==0)?"":minus+" of €50, "; 
				
				String bills= money50.concat(money20+ money10+ money5);
				user.setMessage("Successful operation. Details of the notes that would be dispensed :"+bills);
		}
		else {
			user=u;		
			user.setMessage("Cannot dispense more funds than customer have access ");
		}
		

		return user; 
	}

}

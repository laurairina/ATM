package es.springboot.atm.controller;



import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import es.springboot.atm.model.Usuario;
import es.springboot.atm.service.UsuarioService;
import es.springboot.atm.util.Urls;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class RetrieveUserController {
	  private final Logger logger = LoggerFactory.getLogger(RetrieveUserController.class);
		@Autowired 
		private UsuarioService usuarioService;
		
	/**
	 * first mapping login
	 * @param jsonLogin
	 * @return
	 */
	@PostMapping(Urls.URL_LOGIN)
	public ResponseEntity<String> loginUser(@RequestBody Usuario jsonLogin){
		String message="";
		Usuario u = null;
		ResponseEntity<String> result;
		try {
			usuarioService.fillData();
			u = usuarioService.authentication(jsonLogin);
			if(u!=null) {
				if(u.getPin().equals(jsonLogin.getPin())){
					message= "User Exists with account number:  "+jsonLogin.getUser();	
					result=new ResponseEntity<>(message, HttpStatus.OK);
				}
				else {
					message= "User Exists with account number and Pin Incorrect:  "+jsonLogin.getUser();	
					result= new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
				}
			
			}
			else {
				message= "Not User Exists with account number :  "+jsonLogin.getUser();	
				result= new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
			}
			
		
		} catch (Exception e) {
			message="Error sending a message in login";
		  logger.error(message);
			return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
		}
		
		
		return result;
	}
	
	
	/**
	 * first mapping login and after this mapping
	 * @param jsonLogin
	 * @return
	 */
	@PostMapping(Urls.URL_DISPENSE_MONEY_URL)
	public ResponseEntity<Usuario> dispenseMonenyUrl(@RequestBody Usuario jsonLogin){
		Usuario u = null;
		String message="";
		
		ResponseEntity<Usuario> result= new ResponseEntity<>(new Usuario(), HttpStatus.BAD_REQUEST);
		
		try {
		    
		    u= usuarioService.userDispense(jsonLogin);
		    if(u.getMessage().contains("Successful")) {
		    	result= new ResponseEntity<>(u, HttpStatus.OK);
		    }
		    else {
				result= new ResponseEntity<>(u, HttpStatus.NOT_ACCEPTABLE);
		    }
	
		} catch (Exception e) {
			message="Error sending a message in dispense";
			  logger.error(message);
				return result;
		}
		
		
		
		return result;
	}
	
}

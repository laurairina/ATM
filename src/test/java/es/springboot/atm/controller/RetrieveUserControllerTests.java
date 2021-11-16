package es.springboot.atm.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import es.springboot.atm.model.Usuario;
import es.springboot.atm.service.UsuarioService;
import es.springboot.atm.testFactory.TestFactory;

@RunWith(SpringRunner.class)
@ExtendWith(MockitoExtension.class)
public class RetrieveUserControllerTests {
	
	@InjectMocks
	private RetrieveUserController retrieveUserController;
	
	@Mock
	private UsuarioService usuarioService;
	
	@Before
	public void setUp() throws Exception{
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void urlLoginNotFound() {
		Usuario jsonLogin= TestFactory.firstAccount();
		
		ResponseEntity<String> result= retrieveUserController.loginUser(jsonLogin);
		String message= "Not User Exists with account number :  "+jsonLogin.getUser();	
		assertEquals(new ResponseEntity<>(message, HttpStatus.NOT_FOUND), result);
	}

}

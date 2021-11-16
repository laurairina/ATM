package es.springboot.atm.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Usuario{



	private  String user;
     private  String pin;
	 private  Money money;
	 private int overdraft;
	 private String message;
	

	public Usuario(){
		
	}

	public Usuario(String user, String pin, Money money) {

		this.user = user;
		this.pin = pin;
		this.money = money;
		
	}
	public void setUser(String user) {
		this.user = user;
	}
	public void setPin(String pin) {
		this.pin = pin;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getUser() {
		return user;
	}
	public void setMoney(Money money) {
		this.money = money;
	}
	public String getPin() {
		return pin;
	}
	public Money getMoney() {
		return money;
	}
	public int getOverdraft() {
		return overdraft;
	}
	public void setOverdraft(int overdraft) {
		this.overdraft = overdraft;
	}

}

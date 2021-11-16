package es.springboot.atm.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Money{

	private int money5;
	private int money10;
	private int money20;
	private int money50;
	private int amounts;
	
	public Money(int money5, int money10, int money20, int money50) {
	
		this.money5 = money5;
		this.money10 = money10;
		this.money20 = money20;
		this.money50 = money50;
	    this.amounts=getAmounts(money5, money10, money20, money50);
	}
	
	public void setAmounts(int amounts) {
		this.amounts = amounts;
	}

	public int getAmounts(int money5, int money10, int money20, int money50) {
		this.amounts= money5*5+ money10*10+ money20*20 + money50*50;
		
		return this.amounts;
	}
	
	public int getAmounts() {
		return amounts;
	}
	public int getMoney5() {
		return money5;
	}
	public void setMoney5(int money5) {
		this.money5 = money5;
	}
	public int getMoney10() {
		return money10;
	}
	public void setMoney10(int money10) {
		this.money10 = money10;
	}
	public int getMoney20() {
		return money20;
	}
	public void setMoney20(int money20) {
		this.money20 = money20;
	}
	public int getMoney50() {
		return money50;
	}
	public void setMoney50(int money50) {
		this.money50 = money50;
	}

	public Money newTotalmoney(int overdraft) {
		Money m=null;
	
		//string c= (valor==null)?"null":x; 
			
		
		if(overdraft>=85 && this.money50>0 && this.money20>0 && this.money10>0 && this.money5>0) {
			    int mult= overdraft/85;
			    overdraft= totalAmount(overdraft,85);
				
				
				this.money5 = this.money5 - mult;
				this.money10 = this.money10 - mult;
				this.money20 = this.money20 - mult;
				this.money50 = this.money50 - mult;
		}
		
	       if(overdraft>=70  && this.money50>0 && this.money20>0) {
	        	int mult= overdraft/70;
	        	overdraft= totalAmount(overdraft,70);				
				
				this.money50 = this.money50 - mult;
				this.money20 = this.money20 - mult;
				
		    }
		
	       if(overdraft>=60  && this.money50>0 && this.money10>0) {
	        	int mult= overdraft/60;
	        	overdraft= totalAmount(overdraft,60);				
				
				this.money50 = this.money50 - mult;
				this.money10 = this.money10 - mult;
				
		    }
	       
	       if(overdraft>=50  && this.money50>0) {
	        	int mult= overdraft/50;
	        	overdraft= totalAmount(overdraft,50);				
				
				this.money50 = this.money50 - mult;
			
				
		   }
	       
          if(overdraft>=35  && this.money20>0 && this.money10>0 && this.money5>0) {
        	  int mult= overdraft/35;
        	 overdraft= totalAmount(overdraft,35);
			
			
			this.money5 = this.money5 - mult;
			this.money10 = this.money10 - mult;
			this.money20 = this.money20 - mult;
	    }
		
		if(overdraft>=30  && this.money20>0 && this.money10>0) {
			int mult= overdraft/30;
			overdraft= totalAmount(overdraft,30);
			

			this.money10 = this.money10 - mult;
			this.money20 = this.money20 - mult;
	    }
		
	    if(overdraft>=20  && this.money20>0 ) {
	    	int mult= overdraft/20;
	    	overdraft= totalAmount(overdraft,20);
			
			this.money20 = this.money20 - mult;
	    }
	
	    if(overdraft>=10  && this.money10>0 ) {
	    	int mult= overdraft/10;
	    	overdraft= totalAmount(overdraft,10);
			
			this.money10 = this.money10 - mult;
	    }
	   

	    if(overdraft>=5 && this.money5>0 ) {
	    	int mult= overdraft/5;
	    	overdraft= totalAmount(overdraft,5);
			
			this.money5 = this.money5 - mult;
	    }
	   
	     m=new Money(this.money5, this.money10, this.money20, this.money50);
		
		return m;
		
	}
	
	public int totalAmount(int amount, int valor) {
		
		int result=0;
		int mult= amount/valor;
		result =  amount - (valor*mult);  	

		return result;
	}
	
	
}

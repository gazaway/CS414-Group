package model;

public class PizzaException extends Exception {

	private static final long serialVersionUID = 1L;
	private String errorMessage;
	
	public PizzaException(String error){
		this.errorMessage = error;
	}
	
	public PizzaException(){
		this.errorMessage = "";
	}

	public PizzaException(Throwable cause){
		super(cause);
	}
	
	public PizzaException(String error, Throwable cause){
		super(error, cause);
		this.errorMessage = error;
	}
	
	public PizzaException(String error, Throwable cause, boolean enableSuppression, boolean writableStackTrace){
		super(error, cause, enableSuppression, writableStackTrace);
		this.errorMessage = error;
	}
	
	public String getErrorMessage(){
		return this.errorMessage;
	}
}

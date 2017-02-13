package com.sviatlana.shapeCalculation.exception;

public class CustomException  extends Exception{

	private static final long serialVersionUID = 1L;

	public CustomException() {}  
	
	public CustomException(String er) { 
		super(er); 
	}  
	
	public CustomException (Throwable er) {
        super (er);
    }

    public CustomException (String er, Throwable cause) {
        super (er, cause);
    }

}

package dominio;

public class CosteValidationException extends Exception {
	  public CosteValidationException() { super(); }
	  public CosteValidationException(String message) { super(message); }
	  public CosteValidationException(String message, Throwable cause) { super(message, cause); }
	  public CosteValidationException(Throwable cause) { super(cause); }
	}

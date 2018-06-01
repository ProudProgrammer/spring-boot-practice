package hu.gaborbalazs.practice.springboot.exception;

public class ExceptionResponse {

	private String message;

	public ExceptionResponse() {
	}

	public ExceptionResponse(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}

package hu.gaborbalazs.practice.springboot.handler;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import hu.gaborbalazs.practice.springboot.exception.ExceptionResponse;
import hu.gaborbalazs.practice.springboot.exception.TestException;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	@Autowired
	private Logger logger;

	@ExceptionHandler(IllegalStateException.class)
	public ResponseEntity<Object> handleIllegalStateException(RuntimeException ex, WebRequest request) {
		logger.debug(">> handleIllegalStateException()");
		return handleExceptionInternal(ex, "There was an Illegal State Exception", new HttpHeaders(),
				HttpStatus.BAD_REQUEST, request);
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	@ExceptionHandler(TestException.class)
	public ExceptionResponse handleTestException(RuntimeException ex, WebRequest request) {
		logger.debug(">> handleTestException()");
		return new ExceptionResponse("There was a Test Exception");
	}
}

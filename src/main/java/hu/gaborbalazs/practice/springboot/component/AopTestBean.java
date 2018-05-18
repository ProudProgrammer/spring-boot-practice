package hu.gaborbalazs.practice.springboot.component;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AopTestBean {

	@Autowired
	private Logger logger;

	private static final String MESSAGE = "AOP testMethod";

	public String aopTestMethod() {
		logger.debug(MESSAGE);
		return MESSAGE;
	}
}

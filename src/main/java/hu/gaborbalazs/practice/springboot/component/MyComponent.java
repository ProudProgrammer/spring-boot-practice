package hu.gaborbalazs.practice.springboot.component;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import hu.gaborbalazs.practice.springboot.annotation.MyAnnotation;

@Component
public class MyComponent {

	@Autowired
	private Logger logger;

	@MyAnnotation
	public void nothing() {
		logger.debug("Nothing");
	}
}

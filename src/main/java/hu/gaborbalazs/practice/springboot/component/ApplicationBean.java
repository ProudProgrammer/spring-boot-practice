package hu.gaborbalazs.practice.springboot.component;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.ApplicationScope;

import hu.gaborbalazs.practice.springboot.SampleController;

@ApplicationScope
@Component
public class ApplicationBean {

	private final Logger LOGGER = LoggerFactory.getLogger(ApplicationBean.class);
	
	private int num;
	
	@PostConstruct
	public void init() {
		LOGGER.trace(">> init()");
	}

	public int getNum() {
		return num;
	}

	public void increaseNum() {
		num++;
	}
}

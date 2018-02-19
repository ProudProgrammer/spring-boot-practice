package hu.gaborbalazs.practice.springboot.component;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class DefaultBean {
	
	private final Logger LOGGER = LoggerFactory.getLogger(DefaultBean.class);
	
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

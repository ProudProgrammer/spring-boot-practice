package hu.gaborbalazs.practice.springboot.component;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DefaultBean {

	@Autowired
	private Logger logger;

	private int num;

	@PostConstruct
	public void init() {
		logger.trace(">> init()");
	}

	public int getNum() {
		return num;
	}

	public void increaseNum() {
		num++;
	}
}

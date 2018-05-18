package hu.gaborbalazs.practice.springboot.component;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Component
public class PrototypeBean {

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

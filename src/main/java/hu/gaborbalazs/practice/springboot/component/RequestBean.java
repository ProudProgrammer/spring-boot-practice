package hu.gaborbalazs.practice.springboot.component;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.annotation.RequestScope;

// @RequestScope - ez proxy-t használ
@Scope(WebApplicationContext.SCOPE_REQUEST)
@Component
public class RequestBean {

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

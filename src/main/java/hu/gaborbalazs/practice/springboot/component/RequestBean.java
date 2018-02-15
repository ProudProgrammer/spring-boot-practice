package hu.gaborbalazs.practice.springboot.component;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@RequestScope
@Component
public class RequestBean {

	private int num;
	
	public int getNum() {
		return num;
	}
	
	public void increaseNum() {
		num++;
	}
}

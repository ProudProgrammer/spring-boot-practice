package hu.gaborbalazs.practice.springboot.component;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.ApplicationScope;

@ApplicationScope
@Component
public class ApplicationBean {

	private int num;

	public int getNum() {
		return num;
	}

	public void increaseNum() {
		num++;
	}
}

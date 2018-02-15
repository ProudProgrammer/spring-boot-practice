package hu.gaborbalazs.practice.springboot.component;

import org.springframework.stereotype.Component;

@Component
public class DefaultBean {
	
	private int num;

	public int getNum() {
		return num;
	}

	public void increaseNum() {
		num++;
	}
}

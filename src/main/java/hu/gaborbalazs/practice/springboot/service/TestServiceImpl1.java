package hu.gaborbalazs.practice.springboot.service;

import org.springframework.stereotype.Service;

@Service("impl1")
public class TestServiceImpl1 implements TestService {

	@Override
	public int add(int a, int b) {
		return a + b;
	}

}

package hu.gaborbalazs.practice.springboot.service;

import org.springframework.stereotype.Service;

@Service("impl2")
public class TestServiceImpl2 implements TestService {

	@Override
	public int add(int a, int b) {
		return 2 * (a + b);
	}

}

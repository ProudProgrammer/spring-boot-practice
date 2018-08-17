package hu.gaborbalazs.practice.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class SampleController {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(SampleController.class, args);
	}
}

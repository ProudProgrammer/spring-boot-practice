package hu.gaborbalazs.practice.springboot.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfigurations {

	@Bean
	public String welcome() {
		return "Hello World";
	}
}

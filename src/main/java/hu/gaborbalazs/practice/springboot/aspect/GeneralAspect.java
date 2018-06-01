package hu.gaborbalazs.practice.springboot.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class GeneralAspect {

	@Autowired
	private Logger logger;

	@Pointcut("execution(* *.aopTestMethod(..))")
	private void allAopTestMethod() {
	}

	@Pointcut("@annotation(hu.gaborbalazs.practice.springboot.annotation.MyAnnotation)")
	private void allMyAnnotationMethod() {
	}

	@Before("allAopTestMethod()")
	public void before() {
		logger.debug("AOP method executed");
	}

	@Before("allMyAnnotationMethod()")
	public void beforeService() {
		logger.debug("MyAnnotation method executed");
	}
}

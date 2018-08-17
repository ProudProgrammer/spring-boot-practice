package hu.gaborbalazs.practice.springboot.web;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.WebApplicationContext;

import hu.gaborbalazs.practice.springboot.component.AopTestBean;
import hu.gaborbalazs.practice.springboot.component.ApplicationBean;
import hu.gaborbalazs.practice.springboot.component.DefaultBean;
import hu.gaborbalazs.practice.springboot.component.MyComponent;
import hu.gaborbalazs.practice.springboot.component.RequestBean;
import hu.gaborbalazs.practice.springboot.component.SessionBean;
import hu.gaborbalazs.practice.springboot.domain.TestDto;
import hu.gaborbalazs.practice.springboot.entity.Car;
import hu.gaborbalazs.practice.springboot.exception.TestException;
import hu.gaborbalazs.practice.springboot.repository.CarRepository;
import hu.gaborbalazs.practice.springboot.service.TestService;

@Scope(WebApplicationContext.SCOPE_REQUEST)
@RestController
public class MyController {

	@Autowired
	private Logger logger;

	@Autowired
	private ApplicationContext applicationContext;

	@Autowired
	@Qualifier("impl1")
	private TestService service1;

	@Autowired
	@Qualifier("impl2")
	private TestService service2;

	@Autowired
	private CarRepository carRepository;

	@Autowired
	private DefaultBean defaultBean;

	@Autowired
	private RequestBean requestBean;

	@Autowired
	private SessionBean sessionBean;

	@Autowired
	private ApplicationBean applicationBean;

	@Autowired
	private String message;

	@Value("${welcome}")
	private String welcome;

	@Autowired
	private AopTestBean aopTestBean;

	@Autowired
	private MyComponent myComponent;

	@RequestMapping("/")
	public String home() {
		logger.debug(">> home()");
		return message + " and " + welcome;
	}

	@RequestMapping("/aop")
	public String aopTest() {
		aopTestBean.aopTestMethod();
		myComponent.nothing();
		return "aop";
	}

	@RequestMapping("/exception")
	public String exceptionTest() {
		logger.debug(">> exceptionTest()");
		throw new IllegalStateException();
	}

	@RequestMapping("/testException")
	public String exceptionTest2() {
		logger.debug(">> exceptionTest2()");
		throw new TestException();
	}

	@RequestMapping(value = "/scopeTest", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
	public List<String> scopeTest() {
		defaultBean.increaseNum();
		requestBean.increaseNum();
		sessionBean.increaseNum();
		applicationBean.increaseNum();
		List<String> result = new ArrayList<>();
		RequestBean bean = new RequestBean();
		result.add("A New Request Scoped Bean with new operator, num: " + bean.getNum() + ", hashCode: "
				+ bean.hashCode());
		result.add("Default Scoped Bean, num: " + defaultBean.getNum() + ", hashCode: " + defaultBean.hashCode());
		result.add("Request Scoped Bean, num: " + requestBean.getNum() + ", hashCode: " + requestBean.hashCode());
		result.add("Session Scoped Bean, num: " + applicationContext.getBean(SessionBean.class).getNum()
				+ ", hashCode: " + applicationContext.getBean(SessionBean.class).hashCode());
		result.add("Application Scoped Bean, num: " + applicationBean.getNum() + ", hashCode: "
				+ applicationBean.hashCode());
		result.add(
				"Request Scoped Bean in an Application Scoped Bean, num: " + applicationBean.getRequestBean().getNum()
						+ ", hashCode: " + applicationBean.getRequestBean().hashCode());
		return result;
	}

	@RequestMapping(value = "/cars", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
	public List<Car> cars() {
		return carRepository.findAll();
	}

	@RequestMapping(value = "/testJson", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
	public TestDto testJson() {
		logger.debug("testJson() called");
		return new TestDto("Hello String", 10);
	}

	@RequestMapping(value = "/testAnotherJson", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
	public TestDto testAnotherJson() {
		logger.debug("testAnotherJson() called");
		return new TestDto("Hello String", 10);
	}

	@RequestMapping(value = "/testXml", method = RequestMethod.GET, produces = "application/xml; charset=UTF-8")
	public TestDto testXml() {
		logger.debug("testXml() called");
		return new TestDto("Hello String", 10);
	}

	@RequestMapping(value = "/testAnotherXml", method = RequestMethod.GET, produces = "application/xml; charset=UTF-8")
	public TestDto testAnotherXml() {
		logger.debug("testAnotherXml() called");
		return new TestDto("Hello String", 10);
	}

	@RequestMapping("/add")
	public int add() {
		logger.debug("add() called");
		return service1.add(10, 20);
	}

	@RequestMapping("/add2")
	public int add2() {
		logger.debug("add2() called");
		return service2.add(10, 20);
	}

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String hello(@RequestParam Long id, @RequestHeader String text) {
		String myheader = "header";
		return "Hello param: " + id + ", Hello header: " + text + ", Hello " + myheader;
	}

	@RequestMapping(value = "/mapping", method = RequestMethod.POST)
	public String mapping(@RequestBody TestDto dto) {
		return "StringField: " + dto.getStringField();
	}
}

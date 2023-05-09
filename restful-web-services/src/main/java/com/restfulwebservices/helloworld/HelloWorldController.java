package com.restfulwebservices.helloworld;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

	private MessageSource messageSource;
	
	
	
	public HelloWorldController(MessageSource messageSource) {
		this.messageSource = messageSource;
	}

	@GetMapping(path = "hello-world")
	public String helloWorld() {
		return "Hello World";
	}

	@GetMapping(path = "hello-world-bean")
	public HelloWorldBean helloWorldbean() {
		return new HelloWorldBean("Hello World");
	}

	@GetMapping(path = "hello-world/path-variable/{name}")
	public HelloWorldBean helloWorldPathVariable(@PathVariable String name) {
		return new HelloWorldBean(String.format("Hello Wolrd, %s", name));
	}

	@GetMapping(path = "hello-world-internationalized")
	public String helloWorldInternationazied() {
		
		Locale locale=LocaleContextHolder.getLocale();
		return messageSource.getMessage("good.morning.message", null, "Default Message", locale);
		//return " Hello World V2";
	}

}

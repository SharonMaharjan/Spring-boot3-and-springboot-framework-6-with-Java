package com.in28minutes.learnspringframework;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


record Person (String name, int age, Address address) {};
record Address (String firstLine, String city) {};
@Configuration
public class HelloWorldConfiguration {
	@Bean
	public String name() {
		return "Sharon";
	}
	
	@Bean
	public int age() {
		return 6;
	}

	@Bean
	public Person person() {
		//var person = new Person("Lara",20);
		return new Person("Lara",20,new Address("Kathmandu","Nepal"));
	}
	
	
	@Bean
	public Person person2MethodCall() {
		//var person = new Person("Lara",20);
		return new Person(name(),age(),address());
	}
	
	
	@Bean
	public Person person3Parameters(String name,int age, Address address3) {
		//name,age,address2
		//var person = new Person("Lara",20);
		return new Person(name,age,address);
	}
	
	@Bean(name = "address2")
	public Address address() {
		//var person = new Person("Lara",20);
		return new Address("Kathmandu","Nepal");
	}
	
	@Bean(name = "address3")
	public Address address3() {
		//var person = new Person("Lara",20);
		return new Address("Pokhara","Nepal");
	}
}

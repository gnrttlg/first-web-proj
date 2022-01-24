package com.tc.web01.controller.entity;

import java.util.Objects;

public class Greeting {
	String greeting;

	public Greeting(String greeting) {
		this.greeting = greeting;
	}

	public String greetUserByType(boolean isNewUser) {
		if(isNewUser) {
			return "Welcome ";
		}
		return "Hello again";
	}
	
	public String getGreeting() {
		return greeting;
	}

	public void setGreeting(String greeting) {
		this.greeting = greeting;
	}

	@Override
	public int hashCode() {
		return Objects.hash(greeting);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Greeting other = (Greeting) obj;
		return Objects.equals(greeting, other.greeting);
	}
	

}

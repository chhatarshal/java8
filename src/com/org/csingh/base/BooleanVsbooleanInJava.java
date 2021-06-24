package com.org.csingh.base;

import org.junit.jupiter.api.Test;

class BooleanVsbooleanInJava {

	@Test
	public void test_bool() {
		System.out.println("Here in this example we will see how we can get some unexpected problem with Boolean in java");
		Student student = new Student();
		if (student.getPassedExam()) {
			System.out.println("Student is good");
		}
		System.out.println("Here we will get null pointer exception at run time because value of Bool in java is null and it try to make"
				+ "convert Boolean object to boolean using autoboxing but not can not converted to false and it gives null pointer exception"
				+ "so we need to case full while using Boolean as properties of object");
	}
	
}

class Student {
	
	private Boolean passedExam;

	public Boolean getPassedExam() {
		return passedExam;
	}

	public void setPassedExam(Boolean passedExam) {
		this.passedExam = passedExam;
	}
	
	
}

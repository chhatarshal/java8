package com.org.csingh.base;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.Test;
///  https://www.baeldung.com/java-optional

class _java8 {

	@Test
	void createEmptyOptinal() {
		Optional<String> empty = Optional.empty();
		assertFalse(empty.isPresent());
	}
	
	@Test
	void createEmptyOptinal2() {
		String name = "java";
		Optional<String> opt = Optional.of(name);
		assertTrue(opt.isPresent());
	}
	
	@Test
	void createEmptyOptinal3() {
		String name = "java";
		Optional<String> opt = Optional.ofNullable(name);
		assertTrue(opt.isPresent());
		
		name = null;
		opt = Optional.ofNullable(name);
		assertFalse(opt.isPresent());
	}
	
	@Test
	void testOrElse() {
		String name = null;
		String nameAgain = Optional.ofNullable(name).orElse("Rana");
		assertEquals("Rana", nameAgain);
	}
	
	@Test
	void testOrElseGet() {
		 String nullName = null;
	    String name = Optional.ofNullable(nullName).orElseGet(() -> "hello");
	    assertEquals("hello", name);
	}
	
	public String getDeaultValue() {
		return "THis is default value";
	}
	
	@Test
	void testOrElseGet2() {
		 String nullName = null;
	    String name = Optional.ofNullable(nullName).orElseGet(() -> getDeaultValue());
	    assertEquals("THis is default value", name);
	}
	
	@Test
	void testOrElseThrows() {
		String nullName = null;
	    String name = Optional.ofNullable(nullName).orElseThrow(
	      IllegalArgumentException::new);
	}
	
	

}

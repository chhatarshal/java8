package com.org.csingh.base;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
	
	/*
	 * @Test void testOrElseThrows() { String nullName = null; String name =
	 * Optional.ofNullable(nullName).orElseThrow( IllegalArgumentException::new); }
	 */
	
	@Test
	void testFilters() {
		Integer year = 2021;		
		boolean present2021 = Optional.of(year).filter(y -> year == 2021).isPresent();
		assertEquals(true, present2021);
	}
	
	@Test
	void testFilters2() {
		Integer year = 2021;
		List<Integer> years = new ArrayList<>();
		years.add(year);
		years.add(2020);
		boolean present2021 = Optional.of(year).filter(y -> year == 2021).isPresent();
		assertEquals(true, present2021);
		boolean present2000 = Optional.of(year).filter(y -> year == 2000).isPresent();
		assertEquals(false, present2000);
	}
	
	@Test
	void maptest() {
		 List<String> companyNames = Arrays.asList(
			      "paypal", "oracle", "", "microsoft", "", "apple");
		 
		 Optional<List<String>> listOptional = Optional.of(companyNames);
		 
		 int size = listOptional.map(List::size).orElse(0);
		 assertEquals(6, size);
		 
		 Optional<List<String>> listOptional2 = Optional.of(new ArrayList());
		 
		 int size2 = listOptional2.map(List::size).orElse(0);
		 assertEquals(0, size2);
	}
	
	@Test
	void maptest2() {
		 String name = "baeldung";
		 Optional<String> nameOptional = Optional.of(name);
		 int len = nameOptional.map(String::length).orElse(0);		
		 assertEquals(8, len);
	}
	
	@Test
	void testmapwithfilter() {
		String password = " password ";
		Optional<String> passOpt = Optional.of(password);
		
		boolean pass2 = passOpt.filter(pass -> pass.equals("password")).isPresent();
		assertFalse(pass2);
		
		// lets trim password with map
		
		boolean pass3 = passOpt.map(String::trim).filter(pass -> pass.equals("password")).isPresent();
		
		assertTrue(pass3);
		
	}
	
	
	
	//  Testing flatmap and comparing it to map
	
	public class Person {
	    private String name;
	    private int age;
	    private String password;
	    
	    Person () {
	    	
	    }
	    
	    Person (String name, int age) {
	    	this.name = name;
	    	this.age = age;
	    }

	    public Optional<String> getName() {
	        return Optional.ofNullable(name);
	    }

	    public Optional<Integer> getAge() {
	        return Optional.ofNullable(age);
	    }

	    public Optional<String> getPassword() {
	        return Optional.ofNullable(password);
	    }
	}
	
	@Test
	public void testAndCompareFlatMap() {
		// Flat map do same thing in 1 step what map do in two step
	    Person person = new Person("john", 26);
	    Optional<Person> personOptional = Optional.of(person);

	    Optional<Optional<String>> nameOptionalWrapper = personOptional.map(Person::getName);
	    Optional<String> nameOptional = nameOptionalWrapper.orElseThrow(IllegalArgumentException::new);
	    
	    String name1 = nameOptional.orElse("");
	    
	    assertEquals("john", name1);

	    String name = personOptional.flatMap(Person::getName).orElse("");
	    assertEquals("john", name);
	}
	
	
	

}

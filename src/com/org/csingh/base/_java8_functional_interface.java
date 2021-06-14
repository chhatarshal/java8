package com.org.csingh.base;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class _java8_functional_interface {
	
	@FunctionalInterface
	public interface Foo {
	    String method(String string);
	}
	
	@FunctionalInterface
	public interface Doubler {
	    Integer method(Integer value);
	}
	
	class UseFoo {
		public String add(String string, Foo foo) {
		    return foo.method(string);
		}
		
		public Integer doubleValues(Doubler dbl, Integer value) {
		    return dbl.method(value);
		}
	}

	@Test
	void functionInterface1() {
		Foo foo = parameter -> parameter + " from lambda";
		UseFoo useFoo = new UseFoo();
		String result = useFoo.add("Message ", foo);
		assertEquals("Message  from lambda", result);
	}
	
	@Test
	void functionInterfaceDoubler() {
		System.out.println("Look at me:: ");
		Doubler dbl = parameter ->  parameter * 2;
		UseFoo useFoo = new UseFoo();
		Integer result = useFoo.doubleValues(dbl, 10);
		assertEquals(new Integer(20), result);
	}
	
	// Instantiate Functional Interfaces With Lambda Expressionss
	
	//
	
	@Test
	void lambdawith_functionInterface() {
		Foo foo = parameter -> parameter + " from Foo";
	}
	
	@Test
	void cant_access_non_final_variable_inside_lambda() {
		int x = 10;
		x = 90;
		System.out.println("Uncommenting below line will give compile time error because of line where we are re-assigning x value 90");
	//	Foo foo = parameter -> parameter + x;
	}
	
	
	// Protect Object Variables From Mutation
	@Test
	void Protect_Object_Variables_From_Mutation() {
		int[] total = new int[1];
		total[0] = 1;
		total[0] = 2;
		Runnable r = () -> total[0]++;
		r.run();
		assertEquals(3, total[0]);
		System.out.println("This code is legal, as total variable remains “effectively final,” but will the object it references have the same state after execution of the lambda? No!");
	//	Foo foo = parameter -> parameter + x;
	}
	
	//Use Method References
	@Test
	void Use_Method_References() {
		String name = "abcd";
		 
	}
	
	//Keep Lambda Expressions Short and Self-explanatory
	
	private String buildString(String parameter) {
	    String result = "Something " + parameter;
	    //many lines of code
	    return result;
	}
	
	
	@Test
	void example_of_using_lambda() {
		Foo foo = parameter -> buildString(parameter); 
		//assertEquals("Something ", foo);
	}
	
	public interface MyComparator {

	    public int compare(int a1, int a2);

	}
	
	@Test
	void example_of_using_lambda_example2() {
		MyComparator myComparator = (a1, a2) -> a1 > a2 ? a1 : a2;
		assertEquals(21, myComparator.compare(10, 21));
	}
	
}

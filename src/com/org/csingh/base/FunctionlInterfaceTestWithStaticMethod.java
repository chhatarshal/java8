package com.org.csingh.base;

public class FunctionlInterfaceTestWithStaticMethod {	
	
	public static void main(String[] args) {
		System.out.println("Here in this exmaple I created a functional interface with static method. Created a class which has a method which takes interface as argument");
		
		FunctionInterfaceWithStaticMethod tes = () -> {
			System.out.println("Running..");
		};
		
		TestFunctionalInterface t2 = new TestFunctionalInterface();
		t2.dowork(tes);
	}
}

class TestFunctionalInterface {
	
	public void dowork(FunctionInterfaceWithStaticMethod t) {
		t.test();
		FunctionInterfaceWithStaticMethod.im_static();
	}
}

@FunctionalInterface
interface FunctionInterfaceWithStaticMethod {
	
	static void im_static() {
		System.out.println("Hey I am static");
	}
	
	default void def_method() {
		System.out.println("Hay I am default");
	}
	public void test();
}

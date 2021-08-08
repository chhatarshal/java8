package com.org.csingh.base;

import org.junit.jupiter.api.Test;
 

 
class java_8_switch_statement {
	
	@Test
	void simple_switch() {
		System.out.println("Older swith example 1");
		int x = 100;		
		switch (x) {
			case 100:
				System.out.println("Value is 100");
				break;
			default:
				System.out.println("Final output");
		}				
	}
	
	@Test
	void simple_switch_2() {
		System.out.println("Older swith example 2");
		int x = 90;		
		switch (x) {
			case 10:
				System.out.println("Value is 10");
				break;
			case 100:
				System.out.println("Value is 100");
				break;
			case 90:
				System.out.println("Value is 90");
				break;
			case 70:
				System.out.println("Value is 70");
				break;
			default:
				System.out.println("Default");
		}				
	}
	
	@Test
	void simple_switch_3() {
		System.out.println("Older swith example 3");
		int x = 90;		
		switch (x) {
		case 10:
			System.out.println("Value is 10");
		}		
	}
	
	@Test
	void simple_switch_4() {
		System.out.println("Older swith example 4");
		String day = "Sunday";		
		switch (day) {
			case "Sunday":
				System.out.println("Value is 10");
		}		
	}

}

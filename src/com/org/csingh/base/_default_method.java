package com.org.csingh.base;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class _default_method {
	
	interface product {
		
		public void checkMe();
		public void countme();
		default void print_product() {
			System.out.println("hay product manufacturer .. ");
		}
	}

	@Test
	void test() {
		fail("Not yet implemented");
	}

}

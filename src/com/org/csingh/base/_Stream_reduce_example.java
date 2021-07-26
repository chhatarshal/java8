package com.org.csingh.base;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

class _Stream_reduce_example {

	@Test
	void test() {

		  int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		  int sum = 0;
		  for (int i : numbers) {
		      sum += i;
		  }

		  System.out.println("sum : " + sum); // 55
		  
		  System.out.println("Same think we can do with java 8.");
		  
		  int[] numbers_java8 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

		  // 1st argument, init value = 0
		  int sum_java8 = Arrays.stream(numbers_java8).reduce(0, (a, b) -> a + b);

		  System.out.println("sum java 8 : " + sum_java8); // 55
		  
		  assertEquals(55, sum_java8);
		  
		  assertEquals(56, Arrays.stream(numbers_java8).reduce(1, (a, b) -> a + b));
	}

}

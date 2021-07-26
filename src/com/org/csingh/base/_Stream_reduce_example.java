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
		  
		  int sum1 = Arrays.stream(numbers).reduce(0, (a, b) -> a + b);    // 55
		  int sum2 = Arrays.stream(numbers).reduce(0, Integer::sum);      // 55

		  int sum3 = Arrays.stream(numbers).reduce(0, (a, b) -> a - b);   // -55
		  int sum4 = Arrays.stream(numbers).reduce(0, (a, b) -> a * b);   // 0, initial is 0, 0 * whatever = 0
		  int sum5 = Arrays.stream(numbers).reduce(0, (a, b) -> a / b);  
		  assertEquals(55, sum1);
		  assertEquals(55, sum2);
		  
		  assertEquals(-55, sum3);
		  assertEquals(0, sum4);
		  assertEquals(0, sum5);
		  System.out.println(sum5);
	}

}

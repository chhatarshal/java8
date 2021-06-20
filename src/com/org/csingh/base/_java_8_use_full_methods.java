package com.org.csingh.base;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Random;

import org.junit.jupiter.api.Test;

class _java_8_use_full_methods {

	@Test
	void  highest_number_that_exists_on_a_list() {
		List<Integer> numbers = Arrays.asList(3, 1, 2, 3, 4, 5, 3, 2, 8);
		IntSummaryStatistics stats = numbers.stream().mapToInt((x) -> x).summaryStatistics();
		System.out.println(stats.getMin());
		assertEquals(1, stats.getMin());
	}
	
	@Test
	void print_10_random_numbers_using_foreach() {
		Random random = new Random();
		random.ints().limit(10).forEach(System.out::println);
	}

}

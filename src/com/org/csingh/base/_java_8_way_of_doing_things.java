package com.org.csingh.base;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

class _java_8_way_of_doing_things {

	@Test
	void Convert_arrays_to_stream() {
		System.out.println("Convert arrays to stream");
		String[] testarray = {"Hello", "Hey", "learners"};
		Stream<String> numbers = Stream.of(testarray);
		numbers.forEach(System.out::println);
	}
	
	@Test
	void sum_of_all() {
		List<Integer> numbers = Arrays.asList(5, 4, 10, 12);
		IntSummaryStatistics summary = numbers.stream().mapToInt( val -> val).summaryStatistics();
		assertEquals(31, summary.getSum());
	}

}

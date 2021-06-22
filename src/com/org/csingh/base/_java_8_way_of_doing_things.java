package com.org.csingh.base;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
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
	
	//collectors in Java 8
	@Test
	void collectors_in_Java_8() {
		System.out.println("Collectors used to combine result of all operations");
		List<String>strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
		List<String> filtered = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());
		System.out.println("Filtered List: " + filtered);
		String mergedString = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.joining(", "));
		System.out.println("Merged String: " + mergedString);
	}
	
	@Test
	void generate_20_random_numbers_java_8() {
		System.out.println("Printing 20 random numbers");
		Random random = new Random();
		random.ints().limit(20).forEach(System.out::println);
	}

}

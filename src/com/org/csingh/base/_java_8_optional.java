package com.org.csingh.base;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;

class _java_8_optional {
	
	@Test
	public void optional_test1() {
		String name = null;
		String val = Optional.ofNullable(name).orElse("Dummy");
		assertEquals("Dummy", val);
	}
	
	@Test
	public void optional_test2() {
		List<String> names = Arrays.asList("a", null);
		System.out.println("Question: What is benifit of using Option.of in java 8");
		System.out.println("Answer: Using Option.of you will get Optional<T> object which you can further check if it is empty or value is there");
		List<String> names2 = Optional.of(names).orElse(new ArrayList<String>());
		assertEquals(2, names2.size());
	}
	
	@Test
	public void null_check_with_optional_best_example() {
		System.out.println("Here is best example of null check in java 8 style");
		System.out.println("Original source is : https://www.geeksforgeeks.org/java-8-optional-class/");
		System.out.println("Here we are checking if 5th element in string array is null or not");
		String[] words = new String[10];
		Optional<String> checkNull = Optional.ofNullable(words[5]);
		if (checkNull.isPresent()) {
			String word = words[5].toLowerCase();
			System.out.print(word);
		} else {
			System.out.println("word is null");
		}
	}

}

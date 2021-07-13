package com.org.csingh.base;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

class _FibSeriesJava8 {

	
	
	@Test
	void stream_iterate() {
		 Stream.iterate(0, b -> b + 1).limit(10).forEach(System.out::println);	       	
	}
	
	@Test
	void fibSeries() {
		 Stream.iterate(new int[]{0, 1}, t -> new int[]{t[1], t[0] + t[1]})
	        .limit(10)
	        .forEach(x -> System.out.println("{" + x[0] + "," + x[1] + "}"));		
	}
	
	@Test
	void fibSeries_2() {
		 Stream.iterate(new int[]{0, 1}, t -> new int[]{t[1], t[0] + t[1]})
	        .limit(10).map(t -> t[0])
	        .forEach(x -> System.out.println("{" + x + "}"));		
	}
	
	@Test
	void sum_of_all_fib() {
		int sum = Stream.iterate(new int[]{0, 1}, t -> new int[]{t[1], t[0] + t[1]})
	        .limit(10).map(t -> t[0])
	        .mapToInt(Integer::intValue).sum();	
		System.out.println(sum);
	}
	
	@Test
	void full_feb_series() {	 
		
		String collect = Stream.iterate(new int[]{0, 1}, t -> new int[]{t[1], t[0] + t[1]})
                .limit(10)
                .map(t -> t[0])
                .map(String::valueOf) // convert to string
                .collect(Collectors.joining(", "));

        System.out.println("Result : " + collect);
	}	 

}

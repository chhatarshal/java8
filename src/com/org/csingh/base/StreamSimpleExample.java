package com.org.csingh.base;

import java.util.Arrays;

public class StreamSimpleExample {
	
	public static int getSum() {
		int sum = Arrays.stream(new int[]{1, 2, 3}).sum();
		return sum;
	}
	
	public static int getMultipliedSum() {
		int sum = Arrays.stream(new int[]{1, 2, 3})
				.filter(i -> i >= 2)
				  .map(i -> i * 3).sum();
		return sum;
	}
	
	 
	
	public static void main(String[] args) {
		System.out.println(getSum());
		System.out.println(getMultipliedSum());
	}

}

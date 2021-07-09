package com.org.csingh.base;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

class Stream_Use_Cases {
	

	@Test
	void How_to_convert_a_primitive_Array_to_List() {
		System.out.println("Java 7");
		int[] number = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

	    List<Integer> list = new ArrayList<>();
	    for (int i : number) {
	    	list.add(i);
	    }
	    System.out.println(list);
	    System.out.println("Java 8");
	    List<Integer> list_java_8 = Arrays.stream(number).boxed().collect(Collectors.toList());
	    System.out.println(list_java_8);
	}
	

}

package com.org.csingh.base;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

class Lambda_Expressions_Method_References {

	@Test
	void old_style_vs_lamda() {
		List<String> list = Arrays.asList("node", "java", "python", "ruby");
		list.forEach(new Consumer<String>() {       // anonymous class
		    @Override
		    public void accept(String str) {
		        System.out.println(str);
		    }
		});
		
		
		list.forEach(str -> System.out.println(str)); // lambda expressions
	}
	
	@Test
	void How_to_sort_a_Map_java_8() {
		//Steps to sort a Map in Java 8.

		// 1.Convert a Map into a Stream
		// 2. Sort it
		// 3. Collect and return a new LinkedHashMap (keep the order)
		
		 Map<String, Integer> unsortMap = new HashMap<>();
	        unsortMap.put("z", 10);
	        unsortMap.put("b", 5);
	        unsortMap.put("a", 6);
	        unsortMap.put("c", 20);
	        unsortMap.put("d", 1);
	        unsortMap.put("e", 7);
	        unsortMap.put("y", 8);
	        unsortMap.put("n", 99);
	        unsortMap.put("g", 50);
	        unsortMap.put("m", 2);
	        unsortMap.put("f", 9);

	        System.out.println("Original...");
	        System.out.println(unsortMap);
	        
	        
		Map<String, Integer> result = unsortMap.entrySet().stream().sorted(Map.Entry.comparingByKey()) 			
			    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
			    (oldValue, newValue) -> oldValue, LinkedHashMap::new));
		
		 System.out.println("sorted...");
	        System.out.println(result);
	}
	
	
	@Test
	void java_8_sort_map_by_values() {
		 Map<String, Integer> unsortMap = new HashMap<>();
	        unsortMap.put("z", 10);
	        unsortMap.put("b", 5);
	        unsortMap.put("a", 6);
	        unsortMap.put("c", 20);
	        unsortMap.put("d", 1);
	        unsortMap.put("e", 7);
	        unsortMap.put("y", 8);
	        unsortMap.put("n", 99);
	        unsortMap.put("g", 50);
	        unsortMap.put("m", 2);
	        unsortMap.put("f", 9);

	        System.out.println("Original...");
	        System.out.println(unsortMap);

	        //sort by values, and reserve it, 10,9,8,7,6...
	        Map<String, Integer> result = unsortMap.entrySet().stream()
	                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
	                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
	                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));

	                        
	        //Alternative way
	        Map<String, Integer> result2 = new LinkedHashMap<>();
	        unsortMap.entrySet().stream()
	                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
	                .forEachOrdered(x -> result2.put(x.getKey(), x.getValue()));

	        System.out.println("Sorted...");
	        System.out.println(result);
	        System.out.println(result2);
	}

}

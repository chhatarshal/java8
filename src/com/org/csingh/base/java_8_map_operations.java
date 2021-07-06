package com.org.csingh.base;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

class java_8_map_operations {

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
			    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> oldValue, LinkedHashMap::new));
		
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
	
	@Test
	void java_8_sort_object_map() {
		Properties properties = System.getProperties();
        // not easy to sort this
        Set<Map.Entry<Object, Object>> entries = properties.entrySet();

        LinkedHashMap<String, String> collect = entries.stream()
                //Map<String, String>
                .collect(Collectors.toMap(k -> (String) k.getKey(), e -> (String) e.getValue()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));

        collect.forEach((k, v) -> System.out.println(k + ":" + v));
	}

}

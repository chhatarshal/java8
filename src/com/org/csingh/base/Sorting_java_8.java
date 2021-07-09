package com.org.csingh.base;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

class Sorting_java_8 {

	@Test
	void simple_natural_sorting() {
		System.out.println("Simple sorting");
		 List<String> list = Arrays.asList("9", "A", "Z", "1", "B", "Y", "4", "a", "c");
		 List<String> sortedList = list.stream().sorted().collect(Collectors.toList());	        
	        sortedList.forEach(System.out::println);
	}
	
	@Test
	void simple_reverse_sorting() {
		System.out.println("reverse sorting");
		 List<String> list = Arrays.asList("9", "A", "Z", "1", "B", "Y", "4", "a", "c");
		 List<String> sortedList = list.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());	        
	        sortedList.forEach(System.out::println);
	}
	
	@Test
	void object_sorting() {
		System.out.println("object sorting");
		List<User> users = Arrays.asList(
	            new User("C", 30),
	            new User("D", 40),
	            new User("A", 10),
	            new User("B", 20),
	            new User("E", 50));
		
		List<User> sortedList = users.stream()
	            .sorted(Comparator.comparingInt(User::getAge))
	            .collect(Collectors.toList());
	 
	        sortedList.forEach(System.out::println);
	}
	
	@Test
	void object_sorting_revese() {
		System.out.println("object sorting");
		List<User> users = Arrays.asList(
	            new User("C", 30),
	            new User("D", 40),
	            new User("A", 10),
	            new User("B", 20),
	            new User("E", 50));
		
		List<User> sortedList = users.stream()
	            .sorted(Comparator.comparingInt(User::getAge).reversed())
	            .collect(Collectors.toList());
	 
	        sortedList.forEach(System.out::println);
	}
	
	@Test
	void object_sorting_byname() {
		System.out.println("object sorting");
		List<User> users = Arrays.asList(
	            new User("C", 30),
	            new User("D", 40),
	            new User("A", 10),
	            new User("B", 20),
	            new User("E", 50));
		
		List<User> sortedList = users.stream()
	            .sorted(Comparator.comparing(User::getName))
	            .collect(Collectors.toList());
	 
	        sortedList.forEach(System.out::println);
	}
	
	

}


class User {

    private String name;
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

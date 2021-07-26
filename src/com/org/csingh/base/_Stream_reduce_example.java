package com.org.csingh.base;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

class _Stream_reduce_example {

	@Test
	void reduce_example() {

		  int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		  int sum = 0;
		  for (int i : numbers) {
		      sum += i;
		  }

		  System.out.println("sum : " + sum); // 55
		  
		  System.out.println("Same think we can do with java 8.");
		  
		  int[] numbers_java8 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

		  // 1st argument, init value = 0
		  int sum_java8 = Arrays.stream(numbers_java8).reduce(0, (a, b) -> a + b);

		  System.out.println("sum java 8 : " + sum_java8); // 55
		  
		  assertEquals(55, sum_java8);
		  
		  assertEquals(56, Arrays.stream(numbers_java8).reduce(1, (a, b) -> a + b));
		  
		  int sum1 = Arrays.stream(numbers).reduce(0, (a, b) -> a + b);    // 55
		  int sum2 = Arrays.stream(numbers).reduce(0, Integer::sum);      // 55

		  int sum3 = Arrays.stream(numbers).reduce(0, (a, b) -> a - b);   // -55
		  int sum4 = Arrays.stream(numbers).reduce(0, (a, b) -> a * b);   // 0, initial is 0, 0 * whatever = 0
		  int sum5 = Arrays.stream(numbers).reduce(0, (a, b) -> a / b);  
		  assertEquals(55, sum1);
		  assertEquals(55, sum2);
		  
		  assertEquals(-55, sum3);
		  assertEquals(0, sum4);
		  assertEquals(0, sum5);
		  System.out.println(sum5);
	}
	
	@Test
	void map_and_reduce() {
		List<Invoice> invoices = Arrays.asList(
                new Invoice("A01", BigDecimal.valueOf(9.99), BigDecimal.valueOf(1)),
                new Invoice("A02", BigDecimal.valueOf(19.99), BigDecimal.valueOf(1.5)),
                new Invoice("A03", BigDecimal.valueOf(4.99), BigDecimal.valueOf(2))
        );

        BigDecimal sum = invoices.stream()
                .map(x -> x.getQty().multiply(x.getPrice()))    // map
                .reduce(BigDecimal.ZERO, BigDecimal::add);      // reduce
System.out.println("test case 2...   " + sum);
        System.out.println(sum);    // 49.955
      //  assertEquals(49.955, sum);
        System.out.println(sum.setScale(2, RoundingMode.HALF_UP));  // 49.96
       

    }
	
	class Invoice {

	    String invoiceNo;
	    BigDecimal price;
	    BigDecimal qty;
	    
	    public Invoice(String invoiceNo, BigDecimal price, BigDecimal qty) {
	    	this.invoiceNo = invoiceNo;
	    	this.price = price;
	    	this.qty= qty;
	    }

		public BigDecimal getQty() {
			return this.qty;
		}

		public BigDecimal getPrice() {
			return this.price;
		}

	    // getters, stters n constructor
	}

	

}

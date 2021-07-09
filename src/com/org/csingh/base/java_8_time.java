package com.org.csingh.base;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.ZonedDateTime;
import java.util.Date;

import org.junit.jupiter.api.Test;

class java_8_time {
	
 

	@Test
	void test() {

		Timestamp timestamp = new Timestamp(System.currentTimeMillis());

		Date date = new Date();
		Timestamp timestamp2 = new Timestamp(date.getTime());
		// convert Instant to Timestamp
		Timestamp ts = Timestamp.from(Instant.now());
		// convert ZonedDateTime to Instant to Timestamp
		Timestamp ts2 = Timestamp.from(ZonedDateTime.now().toInstant());
		// convert Timestamp to Instant
		Instant instant = ts2.toInstant();
		System.out.println(instant);
	}

	@Test
	void test2() {
		// 2021.03.24.16.34.26
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");

		// 2021-03-24T16:44:39.083+08:00
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");

		// 2021-03-24 16:48:05
		SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		// method 1
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		System.out.println(timestamp); // 2021-03-24 16:34:26.666

		// method 2 - via Date
		Date date = new Date();
		System.out.println(new Timestamp(date.getTime())); // 2021-03-24 16:34:26.666
															// number of milliseconds since January 1, 1970, 00:00:00
															// GMT
		System.out.println(timestamp.getTime()); // 1616574866666

		System.out.println(sdf1.format(timestamp)); // 2021.03.24.16.34.26

		System.out.println(sdf2.format(timestamp)); // 2021-03-24T16:48:05.591+08:00

		System.out.println(sdf3.format(timestamp)); // 2021-03-24 16:48:05

	}
	
	@Test
	void test3() {
		System.out.println("Java 8 instant example");
		 Timestamp timestamp = new Timestamp(System.currentTimeMillis());
	      System.out.println(timestamp);                  // 2021-03-24 17:12:03.311
	      System.out.println(timestamp.getTime());        // 1616577123311

	      // Convert Timestamp to Instant
	      Instant instant = timestamp.toInstant();
	      System.out.println(instant);                    // 2021-03-24T09:12:03.311Z
	      System.out.println(instant.toEpochMilli());     // 1616577123311

	      // Convert Instant to Timestamp
	      Timestamp tsFromInstant = Timestamp.from(instant);
	      System.out.println(tsFromInstant.getTime());   
	
	}

}

package com.org.csingh.base;

import java.util.Date;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.ZonedDateTime;

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

}

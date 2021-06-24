package com.org.csingh.base;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

class _StringReplaceAll_Issue {

	@Test
	void main() {
		System.out.println("String replace all can lead to some defect if not properly used. Here is example below");
		assertEquals("Hello How are you?", testReplaceAll("Hi How are you?", "Hi", "Hello"));
		System.out.println("What if you pass null instead of Hi in above method call");
		assertEquals("Hello How are you?", testReplaceAll("Hi How are you?", null, "Hello"));
	}

	private String testReplaceAll(String text, String oldChar, String newChar) {
		text = text.replaceAll(oldChar, newChar);
		return text;
	}
}

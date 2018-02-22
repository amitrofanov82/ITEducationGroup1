package ua.step.homework.test;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ua.step.homework.Task04;

public class TaskTest04 {
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

	@Before
	public void setUpStreams() {
		System.setOut(new PrintStream(outContent));
	}

	@After
	public void cleanUpStreams() {
		System.setOut(null);
	}

	@Test
	public void test() {
		String inputData = "ab baa aba abc";
		System.setIn(new java.io.ByteArrayInputStream(inputData.getBytes()));
		Task04.main(null);
		String errorMessage = "Wrong result";
		int index = outContent.toString().indexOf("ab");
		String test = outContent.toString().substring(index).trim();
		assertEquals(errorMessage, test, "ab abc");
	}
	
	@Test
	public void test2() {
		String inputData = "idi if oko egh upl";
		System.setIn(new java.io.ByteArrayInputStream(inputData.getBytes()));
		Task04.main(null);
		String errorMessage = "Wrong result";
		int index = outContent.toString().indexOf("if");
		String test = outContent.toString().substring(index).trim();
		assertEquals(errorMessage, test, "if egh upl");
	}
	
	@Test
	public void test3() {
		String inputData = "yes no noupe yep yea";
		System.setIn(new java.io.ByteArrayInputStream(inputData.getBytes()));
		Task04.main(null);
		String errorMessage = "Wrong result";
		int index = outContent.toString().indexOf("yes");
		String test = outContent.toString().substring(index).trim();
		assertEquals(errorMessage, test, "yes yep");
	}
}

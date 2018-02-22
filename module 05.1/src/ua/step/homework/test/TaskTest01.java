package ua.step.homework.test;

import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ua.step.homework.Task01;

public class TaskTest01 {
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
	public void test1() {
		String inputData = "обороноспособность\nо";
		System.setIn(new java.io.ByteArrayInputStream(inputData.getBytes()));
		Task01.main(null);
		String errorMessage = "Wrong result";
		int index = outContent.toString().indexOf('о');
		String test = outContent.toString().substring(index);
		assertTrue(errorMessage, test.trim().contains("0 2 4 6 9 11 14"));
	}
	
	@Test
	public void test2() {
		String inputData = "aaa aa";
		System.setIn(new java.io.ByteArrayInputStream(inputData.getBytes()));
		Task01.main(null);
		String errorMessage = "Wrong result";
		int index = outContent.toString().indexOf('о');
		String test = outContent.toString().substring(index);
		assertTrue(errorMessage, test.trim().contains("0 1 2 4 5"));
	}
}

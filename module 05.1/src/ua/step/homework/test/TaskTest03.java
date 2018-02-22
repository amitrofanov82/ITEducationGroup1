package ua.step.homework.test;

import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ua.step.homework.Task03;

public class TaskTest03 {
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
		String inputData = "aa aaaa aaaaaa";
		System.setIn(new java.io.ByteArrayInputStream(inputData.getBytes()));
		Task03.main(null);
		String errorMessage = "Wrong result";
		assertTrue(errorMessage, outContent.toString().indexOf("4")!=-1);
	}
	
	@Test
	public void test2() {
		String inputData = "a a   a";
		System.setIn(new java.io.ByteArrayInputStream(inputData.getBytes()));
		Task03.main(null);
		String errorMessage = "Wrong result";
		assertTrue(errorMessage, outContent.toString().indexOf("1")!=-1);
	}
}

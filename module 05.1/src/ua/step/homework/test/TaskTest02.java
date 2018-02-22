package ua.step.homework.test;

import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ua.step.homework.Task02;

public class TaskTest02 {
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
		final int position = 12;
		String inputData = String.valueOf(position);
		System.setIn(new java.io.ByteArrayInputStream(inputData.getBytes()));
		Task02.main(null);
		String errorMessage = "Wrong result";
		String testString = "0123456789101112131415161718192021";
		boolean test = outContent.toString().trim().contains(String.valueOf(testString.charAt(position-1)));
		assertTrue(errorMessage, test);
	}
}

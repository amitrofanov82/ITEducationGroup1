package ua.step.homework.test;

import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ua.step.homework.Task07;

public class TaskTest07 {
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
		String inputData = "Mama mIA";
		System.setIn(new java.io.ByteArrayInputStream(inputData.getBytes()));
		Task07.main(null);
		String errorMessage = "Wrong result";
		assertTrue(errorMessage, outContent.toString().contains("mAMA Mia"));
	}

	@Test
	public void test2() {
		String inputData = "aBaB CddCddC";
		System.setIn(new java.io.ByteArrayInputStream(inputData.getBytes()));
		Task07.main(null);
		String errorMessage = "Wrong result";
		assertTrue(errorMessage, outContent.toString().contains("AbAb cDDcDDc"));
	}
}

package ua.step.homework.test;

import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ua.step.homework.Task05;

public class TaskTest05 {
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
		String inputData = "ab:baa aba:abcd:fgfwdf rr";
		System.setIn(new java.io.ByteArrayInputStream(inputData.getBytes()));
		Task05.main(null);
		String errorMessage = "Wrong result";
		assertTrue(errorMessage, outContent.toString().indexOf("4")!=-1);
	}
	
	@Test
	public void test2() {
		String inputData = "aa:bbbb:cccccc:dddddddd";
		System.setIn(new java.io.ByteArrayInputStream(inputData.getBytes()));
		Task05.main(null);
		String errorMessage = "Wrong result";
		assertTrue(errorMessage, outContent.toString().indexOf("4")!=-1);
	}
	
	@Test
	public void test3() {
		String inputData = "z xx yyy;bbb:cc:d";
		System.setIn(new java.io.ByteArrayInputStream(inputData.getBytes()));
		Task05.main(null);
		String errorMessage = "Wrong result";
		assertTrue(errorMessage, outContent.toString().indexOf("2")!=-1);
	}
}

package ua.step.homework.test;

import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ua.step.homework.Task08;
import ua.step.homework.Task09;

public class TaskTest09 {
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
		String inputData = "«Аз есмь строка, живу я, мерой остр.»\n«За семь морей ростка я вижу рост!»";
		System.setIn(new java.io.ByteArrayInputStream(inputData.getBytes()));
		Task09.main(null);
		String errorMessage = "Wrong result";
		assertTrue(errorMessage, outContent.toString().contains("Yes"));
	}

	public void test2() {
		String inputData = "Мама мыла раму\nРыло надо мыть с мылом!";
		System.setIn(new java.io.ByteArrayInputStream(inputData.getBytes()));
		Task08.main(null);
		String errorMessage = "Wrong result";
		assertTrue(errorMessage, outContent.toString().contains("No"));
	}
}

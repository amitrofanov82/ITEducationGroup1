package ua.step.homework.test;

import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ua.step.homework.Task08;

public class TaskTest08 {
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
		String inputData = "java_home";
		System.setIn(new java.io.ByteArrayInputStream(inputData.getBytes()));
		Task08.main(null);
		String errorMessage = "Wrong result";
		assertTrue(errorMessage, outContent.toString().contains("javaHome"));
	}

	public void test2() {
		String inputData = "javaHome";
		System.setIn(new java.io.ByteArrayInputStream(inputData.getBytes()));
		Task08.main(null);
		String errorMessage = "Wrong result";
		assertTrue(errorMessage, outContent.toString().contains("java_home"));
	}

	public void test3() {
		String inputData = "j_a_v_a_h_o_m_e";
		System.setIn(new java.io.ByteArrayInputStream(inputData.getBytes()));
		Task08.main(null);
		String errorMessage = "Wrong result";
		assertTrue(errorMessage, outContent.toString().contains("jAVAHOME"));
	}

	public void test4() {
		String inputData = "mainJavaHome";
		System.setIn(new java.io.ByteArrayInputStream(inputData.getBytes()));
		Task08.main(null);
		String errorMessage = "Wrong result";
		assertTrue(errorMessage, outContent.toString().contains("main_java_home"));
	}
	
	public void test5() {
		String inputData = "MainJavaHome";
		System.setIn(new java.io.ByteArrayInputStream(inputData.getBytes()));
		Task08.main(null);
		String errorMessage = "Wrong result";
		assertTrue(errorMessage, outContent.toString().contains("main_java_home"));
	}
	
	public void test6() {
		String inputData = "_java_home";
		System.setIn(new java.io.ByteArrayInputStream(inputData.getBytes()));
		Task08.main(null);
		String errorMessage = "Wrong result";
		assertTrue(errorMessage, outContent.toString().contains("javaHome"));
	}
}

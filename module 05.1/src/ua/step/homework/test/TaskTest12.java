package ua.step.homework.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashSet;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ua.step.homework.Task12;

public class TaskTest12 {

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
		Task12.main(null);
		String result = outContent.toString();
		String[] strings = result.split("\r\n");
		assertSame("Examples should be 15 pieces", strings.length, 15);
	}

	@Test
	public void test2() {
		Task12.main(null);
		String result = outContent.toString();
		String[] strings = result.split("\r\n");
		for (String string : strings) {
			String[] parts = string.split("\\s+");
			assertSame("Example should be 5 parts", parts.length, 5);
			assertEquals("Part 1 should be *", parts[1], "*");
			assertEquals("Part 1 should be *", parts[3], "=");
			int r = Integer.valueOf(parts[0]) * Integer.valueOf(parts[2]);
			assertSame("The result of the multiplication to be " + r, r, Integer.valueOf(parts[4]));
		}
	}

	@Test
	public void test3() {
		Task12.main(null);
		String result = outContent.toString();
		String[] strings = result.split("\r\n");
		Set<String> unic = new HashSet<String>();
		for (String string : strings) {
			String[] parts = string.split("=");
			String prim = parts[0].trim();
			StringBuilder sb = new StringBuilder(prim);
			sb.reverse();
			assertTrue("Not unique result", unic.add(prim));
			if (prim.equals(sb.toString())) {
				assertTrue("Not unique result", unic.add(prim));
			}
		}
	}
}

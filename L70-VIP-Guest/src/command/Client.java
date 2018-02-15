package command;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils.Collections;

public class Client {

	public static void main(String[] args) {
		List<String> strings = new ArrayList<>();
		strings.add("ab");
		strings.add("cd");
		new AddHelloButton(strings).click();
		System.out.println(strings);
	}
}

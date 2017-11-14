package artifact47;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

public class MainExample {
	
	public static void main(String[] args) throws IOException {
		//File f = new File("./pom.xml");
		//List<String> lines = FileUtils.readLines(f, "UTF-8");
		InputStream resource = MainExample.class.getClassLoader()
			.getResourceAsStream("artifact47/testToRead.xml");
		List<String> lines = IOUtils.readLines(resource, "UTF-8");
		System.out.println(lines.get(5));
	}
}
























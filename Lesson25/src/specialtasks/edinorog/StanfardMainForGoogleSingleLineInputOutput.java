package specialtasks.edinorog;

import util.FileUtils;

public class StanfardMainForGoogleSingleLineInputOutput {
	//public final static String INPUT_FILE = "resources/edinorog/sample.in";
	public final static String INPUT_FILE = "resources/edinorog/B-large-practice.in";
	public final static String OUTPUT_FILE = "resources/edinorog/sample-large.out";

	public static void main(String[] args) throws Exception {
		String[] input = FileUtils.readFileAsStringArray(INPUT_FILE);
		String[] output = new String[input.length-1];
		for (int i =1; i< input.length; i++) {
			String oneTaskResult = TaskResolverZhigimont.resolveOneCase(input[i]);
			output[i-1] = "Case #" + i + ": " + oneTaskResult;
		}
		FileUtils.writeStringArrayToFile(output, OUTPUT_FILE);
		
		
	}
	
}

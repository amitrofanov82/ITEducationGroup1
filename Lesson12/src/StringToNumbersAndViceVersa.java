
public class StringToNumbersAndViceVersa {
	
	public static void main(String[] args) {
		String asInt = "12";
		String asBool = "true";
		int i = Integer.parseInt(asInt);
		long longVar = Long.parseLong(asInt);
		double d = Double.parseDouble(asInt);
		float f = Float.parseFloat(asInt);
		boolean b = Boolean.parseBoolean(asBool);
		//char c = Character.figVam!!
		char[] cMass = asInt.toCharArray();
 		byte byteVar = Byte.parseByte(asInt);
 		
 		System.out.println(b);
 		
 		//Обратное преобразование:
 		Integer.toString(i);
 		Byte.toString(byteVar);
 		Long.toString(longVar);
 		Boolean.toString(b);
 		Double.toString(d);
 		Float.toString(f);
 		System.out.println(Character.toString('A'));
 		cMass.toString();
	}

}






















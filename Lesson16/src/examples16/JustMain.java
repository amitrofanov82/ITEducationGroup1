package examples16;

public class JustMain {

	public static void main(String[] args) {
		Auto veryPowerfulAuto, veryWeakAuto;
		System.out.println(Auto.classDescritpion);
		
		//создание объекта:
		veryPowerfulAuto = new Auto();
		veryWeakAuto = new Auto();
		
		System.out.println("veryPowerfulAuto power =" 
							+ veryPowerfulAuto.HorsePower);
		System.out.println("veryPowerfulAuto color =" 
				+ veryPowerfulAuto.color);
		System.out.println(veryPowerfulAuto == veryWeakAuto);
		//задание значений в объекте:
		veryPowerfulAuto.HorsePower = 1200;
		veryWeakAuto.HorsePower = 35;
		
		System.out.println(veryPowerfulAuto == veryWeakAuto);
		
		Auto oneMoreAuto;
		oneMoreAuto = veryPowerfulAuto;
		oneMoreAuto.HorsePower = 1250;
		System.out.println("veryPowerfulAuto power =" 
				+ veryPowerfulAuto.HorsePower);
		
		veryPowerfulAuto.color = "black";
		
	}

}

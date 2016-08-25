package iie;

import java.util.AbstractMap;
import java.util.HashMap;

public class publicstaticvoidmain {
	
	public static void main(String[] args){
		System.out.println("Hello World!");
		
		int test = 1234;
		String testString = Integer.toString(test);
		int test2 = Integer.parseInt(testString);
		System.out.println(test2);
		
		if (test == 1234){
			test = 12345;
		}
		
		System.out.println(test);
		
		
		long currentTime = System.currentTimeMillis();
		int currentTimeInt = (int) (currentTime/1000);

		System.out.println(currentTime);
		System.out.println(currentTimeInt);


		System.out.println(Long.parseLong("1472003809703"));
		
		AbstractMap<String,String> deathMap = new HashMap<String,String>();
		deathMap.put("test", "1472003809703");
		long deathTime = Long.parseLong(deathMap.get("test"));
		System.out.println(deathMap.get("test"));
		System.out.println(deathTime + " is a number");		
		
		System.out.println(deathMap.get("other"));
		System.out.println("you are dead for the next " + ((86400000 - (currentTime - deathTime))/3600000) + " hours");
		

		
	
	}
}

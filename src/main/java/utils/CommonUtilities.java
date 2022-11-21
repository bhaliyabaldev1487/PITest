package utils;

import java.util.HashMap;
import java.util.Map;

public class CommonUtilities {
	
	public static void displayTitleAndCount(HashMap<String, Integer> map) {
		for(Map.Entry<String,Integer> mapElement : map.entrySet()) {
			String key = mapElement.getKey();
			Integer value = mapElement.getValue();
			System.out.println("Title: \t"+ key+" \tValue: \t"+ value);
		}
	}
}

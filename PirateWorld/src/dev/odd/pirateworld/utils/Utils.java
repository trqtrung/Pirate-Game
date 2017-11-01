package dev.odd.pirateworld.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.attribute.AclEntry.Builder;

public class Utils {
	
	public static String loadFileAsString(String path) {
		StringBuilder sb = new StringBuilder();
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(path));
			String line;
			while((line = br.readLine()) != null)
				sb.append(line + "\n");
			br.close();
		}catch(IOException e) {
			e.printStackTrace();		
		}
		
		return sb.toString();
	}
	
	public static int parseInt(String number) {
		try {
			return Integer.parseInt(number);
		}catch(NumberFormatException e) {
			e.printStackTrace();
			return 0;
		}
	}
	
}

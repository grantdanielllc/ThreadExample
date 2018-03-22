package com.aca;

import java.io.IOException;
import java.io.InputStream;

public class BreakPassword extends Thread {

	private static String[] chars = new String[] {"a","b","n","z"};
	
	private String firstChar;
	
	public BreakPassword(String firstChar) {
		this.firstChar = firstChar;
	}
	
	@Override
	public void run() {
		
		System.out.println("start thread for first char: " + this.firstChar);
		
			for (String pos2 : chars) {				
				for (String pos3 : chars) {					
					for (String pos4 : chars) {						
						for (String pos5 : chars) {							
							for (String pos6 : chars) {
								
								String password = firstChar + pos2 + pos3 + pos4 + pos5 + pos6;
																
								try {
									Process proc = Runtime.getRuntime().exec("java -jar c:\\metovachallenge.jar " + password );
									// Then retreive the process output
								    InputStream in = proc.getInputStream();							   
								    
								    byte b[]=new byte[in.read()];
								    in.read(b,0,b.length);
								    String answer = new String(b);
								   // System.out.println(answer);

								    if (answer.contains("@")) {
								    	System.out.println("password: " + password);
								    	System.out.println("winner winner chicken dinner!");
								    	System.exit(0);
								    	
								    }							    
								  
									
								} catch (IOException e) {									
									e.printStackTrace();
								}
								
							}
						}
					}
				}				
			}	
			
			System.out.println("end thread for first char: " + this.firstChar);
		
	}
	
	
}

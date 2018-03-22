package com.aca;

import java.util.ArrayList;
import java.util.List;

public class PrintNumbersTest {

	public static void main(String[] args) {
	
		System.out.println("start thread name: " + Thread.currentThread().getName() );
		
		PrintNumbers printNumbers = new PrintNumbers("P1");	
		System.out.println("returned for calling PrintNumbers() ");
		
		printNumbers.start();
		System.out.println("returned for calling printNumbers.start() ");
		
		
		PrintNumbersTest printNumbersTest = new PrintNumbersTest();			
		printNumbersTest.start();
		
		System.out.println("returned for calling printNumbersTest.start()");
		
		
		System.out.println("end of main method");
	}

	private void start() {
		
		List<String> names = new ArrayList<String>();
		names.add("dan");
		names.add("sam");
		names.add("pete");
		
		for (String name : names) {
			System.out.println("name: " + name);
			
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {				
				e.printStackTrace();
			}
		}
		
	}

}

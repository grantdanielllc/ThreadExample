package com.aca;

public class PrintNumbers extends Thread {

	private String key;

	public PrintNumbers(String key) {
		this.key = key;
	}
	
	@Override
	public void run() {
		
		System.out.println("start key: " + key + ", thread Name: " + Thread.currentThread().getName());		
		
		for (int i = 0; i < 20; i++) {
			System.out.println("i: " + i);
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {				
				e.printStackTrace();
			}
		}
		
		System.out.println("end key: " + key + ", thread Name: " + Thread.currentThread().getName());
	}
	
	
}

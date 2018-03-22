package com.aca;

public class BreakPasswordTest {

	public static void main(String[] args) {
		
		String[] chars = new String[] {"a","b","n","z"};
		
		for (String firstChar : chars) {
			BreakPassword breakPassword = new BreakPassword(firstChar);
			breakPassword.start();
		}

	}

}

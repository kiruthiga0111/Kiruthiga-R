package com.hexa.arrays;

public class Factorial {
	public static void main(String[] args) {
		int value=5;
		int fact=1;
		while(value>=1) {
			fact*=value;
			value--;
			
		}
		System.out.println(fact);
	}

}

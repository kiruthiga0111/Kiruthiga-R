package com.hexa.arrays;

public class Amstrong {
	public static void main(String[] args) {
		int num=153;
		int copy=num;
		int value=0;
		while(num!=0) {
			int rem=num%10;
			value+=rem*rem*rem;
			num/=10;
		}
		
		if(value==copy) {
			System.out.println(value+ " is a amstrong number");
		}
		else {
			System.out.println(value+ " is a amstrong not a number");
		}
	}
}

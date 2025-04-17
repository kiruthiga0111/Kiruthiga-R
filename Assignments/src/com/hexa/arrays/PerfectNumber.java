package com.hexa.arrays;

public class PerfectNumber {
	public static void main(String[] args) {
		int num=6;
		int copy=num;
		int sum=0;
		for(int i=1;i<=num/2;i++) {
			if(num%i==0) {
				sum+=i;
			}
		}
		if(sum==copy) {
			System.out.println("it is a perfect num");
		}else {
			System.out.println("it is not a perfect num");
		}
			
	}}

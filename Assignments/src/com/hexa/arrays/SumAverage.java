package com.hexa.arrays;

public class SumAverage {
	public static void main(String[] args) {
		int[] nums= {10,20,30,40,50,60,70};
		int sum=0;
		
		for(int i=0;i<nums.length;i++) {
			sum+=nums[i];
		}
		System.out.println("sum= "+sum);
		int avg=sum/(nums.length);
		System.out.println("average= "+avg);
	}
}

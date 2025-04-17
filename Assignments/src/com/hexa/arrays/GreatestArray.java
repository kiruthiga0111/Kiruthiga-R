package com.hexa.arrays;

public class GreatestArray {
	public static void main(String[] args) {
		int[] nums= {10,40,60,50,80,45,90};
		int max=nums[1];
		for(int i=0;i<7;i++) {
			if(nums[i]>=max) {
				max=nums[i];
				
			}
		}System.out.println("greatest num= "+ max);
	}

}

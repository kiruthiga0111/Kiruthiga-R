package com.hexa.arrays;

public class SmallestArray {
	public static void main(String[] args) {
		int[] nums= {70,40,60,50,20,45,90};
		int min=nums[1];
		for(int i=0;i<7;i++) {
			if(nums[i]<=min) {
				min=nums[i];
				
			}
		}System.out.println("smallest num= "+ min);
	}

}

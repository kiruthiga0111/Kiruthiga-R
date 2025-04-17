package com.hexa.arrays;

public class ArraysExample {
	public static void main(String[] args) {
		int[] even= {2,4,6,8,10,12};
		int[] odd=new int[] {1,3,5,7,9,11};
		int[] nums=new int[4];
		System.out.println("LENGTH "+ nums.length);
		
		nums[0]=20;
		nums[1]=30;
		nums[2]=40;
		nums[3]=50;
		
		System.out.println(nums[2]);
		
		for(int i=0;i<4;i++) {
			System.out.println(nums[i]);
			
		}
	}

}

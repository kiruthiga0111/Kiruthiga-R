package com.hexa.arrays;

public class OddArray {
	public static void main(String[] args) {
		int[] nums = { 11, 40, 69, 50, 87, 45, 90 };
		System.out.println("odd nums are: ");
		for (int i = 0; i < 7; i++) {
			if (nums[i] % 2 != 0) {
				System.out.println(nums[i]);

			}
		}
	}

}

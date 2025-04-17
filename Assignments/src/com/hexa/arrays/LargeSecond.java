package com.hexa.arrays;

import java.util.Arrays;

public class LargeSecond {

		public static void main(String[] args) {
			int[] nums = { 50, 40, 10, 71, 87, 45, 90 };
			
			Arrays.sort(nums);
			
			System.out.println(nums[nums.length-2]);

	       
	        }
	}


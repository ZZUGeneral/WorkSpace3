package com.zzu.leetcode.second;

public class Thirty_Five {
	public static void main(String[] args) {
		int[] num = { 1, 3, 5, 6 };
		int tem_target = 5;
		int i = searchInsert(num, tem_target);
		System.out.println("This is " + i);
	}

	public static int searchInsert(int[] nums, int target) {
		int i = 0, j = nums.length;
		if (nums[0] >= target)
			return 0;
		if (nums[j - 1] < target)
			return j;
		for (i = 1; i < j; i++) {
			if (nums[i] == target)
				return i;
			else {
				if (nums[i] > target)
					return i;
			}
		}
		return i;
	}
}

package com.zzu.leetcode.first;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Twenty_Seven {
	public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
          return new int[0];
        }
    
        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for(int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }
    
    public static String integerArrayToString(int[] nums, int length) {
        if (length == 0) {
            return "[]";
        }
    
        String result = "";
        for(int index = 0; index < length; index++) {
            int number = nums[index];
            result += Integer.toString(number) + ", ";
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }
    
    public static String integerArrayToString(int[] nums) {
        return integerArrayToString(nums, nums.length);
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[] nums = stringToIntegerArray(line);
            line = in.readLine();
            int val = Integer.parseInt(line);
            
            int ret = new Twenty_Seven().removeElement(nums, val);
            String out = integerArrayToString(nums, ret);
            
            System.out.print(out);
        }
    }
    public int removeElement(int[] nums, int val) {
        int i,j;
		int len = nums.length;  //  保存长度
		for ( i = 0; i < len; i++) {
			//  删除重复的元素
			if (nums[i] == val) {
				for ( j = i; j < len-1; j++) {
					nums[j] = nums[j + 1];
				}
				len --;
				if(i==len) return len;
				else i--;
			}
		}
		return len;
    }
}
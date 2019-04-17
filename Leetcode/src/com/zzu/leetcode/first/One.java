package com.zzu.leetcode.first;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class One {
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
            int target = Integer.parseInt(line);
            
            int[] ret = new One().twoSum(nums, target);
            
            String out = integerArrayToString(ret);
            
            System.out.print(out);
        }
    }
    public int[] twoSum(int[] nums, int target) {
        int x=0,y=0;    // 璁剧疆涓や釜鍙傛暟鏉ヨ〃绀鸿繍绠楁椂鐨勪袱涓姞鏁扮殑涓嬫爣
        int[] result = new int[2];  // 杩斿洖鏁版嵁鍊�
        for(x = 0; x < nums.length;x++){
             int temp = target - nums[x];   // 鑾峰彇闇�瑕佹壘鍒扮殑鏁�
            for(y =0; y< nums.length;y++){
                if((nums[y]==temp)&&(y!=x)){
                    result[0] = x;
                    result[1] = y;
                    return result;
                }
            }
        }
        return null;
        
    }
}
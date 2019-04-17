package com.zzu.leetcode.first;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Nine{
	public static String booleanToString(boolean input) {
        return input ? "True" : "False";
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int x = Integer.parseInt(line);
            
            boolean ret = new Nine().isPalindrome(x);
            
            String out = booleanToString(ret);
            
            System.out.print(out);
        }
    }
    public boolean isPalindrome(int x) {
        if(x<0) return false;   //   负数返回False
        String  s = Integer.toString(x);   // 将测试数转换为字符串
	    	int l = s.length();
	        for ( int i =0; i < l/2;i++){
	            if(s.charAt(i)!=s.charAt(l-i-1)) return false;   //遍历字符串，有一对对应位置的字符不同就返回False
	        }
        return true;
    }
}
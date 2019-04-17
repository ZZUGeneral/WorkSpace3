package com.zzu.leetcode.first;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Nine_Second {
	public static String booleanToString(boolean input) {
        return input ? "True" : "False";
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int x = Integer.parseInt(line);
            
            boolean ret = new Nine_Second().isPalindrome(x);
            
            String out = booleanToString(ret);
            
            System.out.print(out);
        }
    }
    public boolean isPalindrome(int x) {
        if(x<0) return false;   //   负数返回False
        //  temp 暂时保存x result表示 x 逆序的结果， last 是temp的最后一个数字
        int temp = x,result = 0,last = 0;
        while(temp>0){
            last = temp % 10;
            result = result *10 + last;
            temp = (temp - last)/10;
        }
        
        if(x==result)   return true;
        else return false;
    }
}
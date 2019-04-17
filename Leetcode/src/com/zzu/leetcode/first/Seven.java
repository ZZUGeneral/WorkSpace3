package com.zzu.leetcode.first;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Seven {
	public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int x = Integer.parseInt(line);
            
            int ret = new Seven().reverse(x);
            
            String out = String.valueOf(ret);
            
            System.out.print(out);
        }
    }
    public int reverse(int x) {
        //  result表示 x 逆序的结果， last 是temp的最后一个数字
        long result = 0;
		 int last = 0;
	        while(x!=0){
	            last = x % 10;
	            result = result *10 + last;
	            x = (x - last)/10;
	        }
	        if((result>Math.pow(2,31)-1)||(result < Math.pow(-2,31))) result = 0;
	        return (int)result;
    }
}
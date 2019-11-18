package com.zzu.leetcode.first;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Thirteen {
	public static String stringToString(String input) {
        if (input == null) {
            return "null";
        }
        return String.valueOf(input).toString();
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            String s = stringToString(line);
            
            int ret = new Thirteen().romanToInt(s);
            
            String out = String.valueOf(ret);
            
            System.out.print(out);
        }
    }
    public int romanToInt(String s) {
        String str = "IVXLCDM";
		int[] arr = new int[20];
		int result = 0, flag = 0, i = 0;
		int[] num = { 1, 5, 10, 50, 100, 500, 1000 };
		int len = s.length() - 1;
	    arr[0] = str.indexOf(s.charAt(0));
		arr[i+1] = -1;
		s = s + 'I';
		for (i = 0; i <= len ; i++) {
			flag = arr[i];
            arr[i+1] = str.indexOf(s.charAt(i+1));
			if(flag<arr[i+1]){
				result = result - num[flag];
			}else{
				result = result + num[flag];
			}
		}
		return result;
    }
}
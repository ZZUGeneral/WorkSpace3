package com.zzu.leetcode.first;

public class Twelve {
    public String intToRoman(int num) {
        String temp = "",result = "";
		String[] str = {"I","V","X","L","C","D","M"}; 
		int last = 0, order = 0;
        while(num!=0){
        	order ++;
        	temp = "";
        	last = num % 10;
        	if(last == 9) {
        		temp = str[order*2-2] + str[order*2] + temp;
        		num = (num - last) / 10;
            	result = temp + result;
        		continue;
        	}
        	if(last == 4){
        		temp = str[order*2-2] + str[order*2-1] + temp;
        		num = (num - last) / 10;
            	result = temp + result;
        		continue;
        	}
        	if(last >= 5) {
        		temp = str[order*2-1] + temp;
        		last = last - 5;
        	}
        	for(;last>0;last--) temp = temp + str[order*2-2];
        	num = (num - last) / 10;
        	result = temp + result;
        }
        return result;
    }
}
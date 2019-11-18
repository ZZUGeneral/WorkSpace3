package com.zzu.leetcode.first;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Seventeen {
	public static String stringToString(String input) {
        if (input == null) {
            return "null";
        }
        return String.valueOf(input).toString();
    }
    
    public static String stringListToString(List<String> stringList) {
        StringBuilder sb = new StringBuilder("[");
        for (String item : stringList) {
            sb.append(item);
            sb.append(",");
        }
    
        sb.setCharAt(sb.length() - 1, ']');
        return sb.toString();
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            String digits = stringToString(line);
            
            List<String> ret = new Seventeen().letterCombinations(digits);
            
            String out = stringListToString(ret);
            
            System.out.print(out);
        }
    }
    public List<String> letterCombinations(String digits) {
       // 返回值
		List<String> result = new ArrayList<String>();
		String[][] num = {{}, {}, { "a", "b", "c" }, { "d", "e", "f" }, { "g", "h", "i" }, { "j", "k", "l" },
				{ "m", "n", "o" }, { "p", "q", "r", "s" }, { "t", "u", "v" }, { "w", "x", "y", "z" } };
		String s;  //  拼接的字符串
		int i, j; // 循环下标
		// 保存指定位置的数字及对应位置字符的下标的数组
		int[][] digit = new int[10][2];
		// 分解字符串
		for (i = 0;i < digits.length() ; i++) {
			digit[i][0] = digits.charAt(i) - '0';
			digit[i][1] = 0;
		}
		int x = digit[0][0];
		int len = num[x].length;
		int flag = 0;
		while (digit[0][1] < len) {
			while (digit[flag][1] <= (num[x].length - 1) && flag < i) {
				flag++;
				x = digit[flag][0];
			}
			if (flag == i) {
				flag--;
			}
			x = digit[flag][0];
			while (digit[flag][1] == num[x].length && flag > 0) {
				digit[flag][1] = 0;
				flag--;
				x = digit[flag][0];
				digit[flag][1] = digit[flag][1] + 1;
			}
			if (digit[0][1] >= len) {
				break;
			}

			s = "";

			for (j = 0; j < i; j++) {
				int z = digit[j][0];
				int y = digit[j][1];
				s = s + num[z][y];
			}
			result.add(s);
			if (flag != (i - 1))	flag = 1;
			digit[i - 1][1] = digit[i - 1][1] + 1;
		}
        return result;
    }
}
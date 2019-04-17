package com.zzu.leetcode.first;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ten {
	public static String stringToString(String input) {
		if (input == null) {
			return "null";
		}
		return String.valueOf(input).toString();
	}

	public static String booleanToString(boolean input) {
		return input ? "True" : "False";
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String line;
		while ((line = in.readLine()) != null) {
			String s = stringToString(line);
			line = in.readLine();
			String p = stringToString(line);

			boolean ret = new Ten().isMatch(s, p);

			String out = booleanToString(ret);

			System.out.print(out);
		}
	}

	public boolean isMatch(String s, String p) {
		/*
		 * '.' 匹配任意单个字符。 '*' 匹配零个或多个前面的元素。
		 */

		int i, j, temp = 0;
		if (s.equals(p) || p.equals(".*"))
			return true;

		if (s.equals("") && !p.equals(""))
			s="0";
		if (p.equals("") && !s.equals(""))
			return false;
		int sl = s.length(), pl = p.length();

		for (i = 0, j = 0; j < pl; i++) {
			if (i == sl && i > 0) {
				i--;
				if (j + 1 < pl && p.charAt(j + 1) == '*') {
					j = j + 2;
					continue;
				}
				if (p.charAt(j) == s.charAt(i) || p.charAt(j) == '.') {
					temp = j;
					if (i - 1 >= 0 && s.charAt(i) == s.charAt(i - 1)) {
						while (temp - 2 >= 0 && p.charAt(temp - 1) == '*' && p.charAt(temp - 2) != s.charAt(i))
							temp = temp - 2;
						if (temp - 2 >= 0 && (p.charAt(temp - 2) == s.charAt(i)||p.charAt(temp-2)=='.') && p.charAt(temp - 1) == '*') {
							j++;
						} else
							return false;
					} else {
						if (i - 1 < 0)
							return false;
						j++;
					}

				} else if(p.charAt(j)=='*') {j++;i--;}
				else return false;
			} else if (s.charAt(i) == p.charAt(j)) {
				j++;
			} else if (p.charAt(j) == '.') {
				if(s.charAt(i)!='0') j++;
				else return false;
			} else if (p.charAt(j) == '*') {
				while (i < sl && (s.charAt(i) == p.charAt(j - 1) || p.charAt(j - 1) == '.'))
					i++;
				if(i==0&&s.charAt(i)=='0') i++;
				j++;
				i--;
			} else if (j + 1 < pl && p.charAt(j + 1) == '*') {
				j++;
				i--;
			} else
				return false;
		}
		if (i < sl)
			return false;
		return true;
		/*
		 * aaa aaaa falseaaa ab*a*c*a Trueaa a Falseaa a* Trueab .* Trueaab
		 * c*a*b Truemississippi mis*is*p*. Falsea aa True ab .*c false a ab*a
		 * false mississippi mis*is*ip*. true a ab* true aaa a*a trueaaa ab*ac*a
		 * falseaasdfasdfasdfasdfas aasdf.*asdf.*asdf.*asdf.*s true
		 */
	}
}

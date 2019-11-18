package com.zzu.leetcode.second;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Seventy_Three {
	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String line;
		while ((line = in.readLine()) != null) {
			int num = Integer.parseInt(line);

			new Seventy_Three();
			String ret = Seventy_Three.numberToWords(num);

			String out = (ret);

			System.out.print(out);
		}

	}

	public static String numberToWords(int num) {
		String[] second = { " ", " Thousand", " Million", " Billion" };
		String result = "";
		int temp = 0, count = 0;
		if (num == 0)
			return "Zero";
		while (num > 0) {
			temp = num % 1000;
			if(temp == 0){
				num = (num - temp) / 1000;
				count++;
				continue;
			}
			if (count == 0)
				result = ToWords(temp);
			else if (result.equals(""))
				result = ToWords(temp) + second[count];
			else
				result = ToWords(temp) + second[count] + " " + result;
			if (result.equals(second[count]))
				result = "";
			num = (num - temp) / 1000;
			count++;
		}
		return result;
	}

	public static String ToWords(int num) {
		String result = "";
		String[] first = { "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine" };
		String[] second = { "", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety" };
		String[] third = { "", "One Hundred", "Two Hundred", "Three Hundred", "Four Hundred", "Five Hundred",
				"Six Hundred", "Seven Hundred", "Eight Hundred", "Nine Hundred" };
		String[] ten = { "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen",
				"Nineteen" };
		int Ge = 0, Shi = 0, Bai = 0;
		Ge = num % 10;
		num = (num - Ge) / 10;
		Shi = num % 10;
		num = (num - Shi) / 10;
		Bai = num % 10;
		if (Bai != 0 && (Shi != 0 || Ge != 0))
			result = result + third[Bai] + " ";
		else
			result = result + third[Bai];
		if (Shi == 1 && Ge != 0){
			result = result + ten[Ge-1];
			return result;
			}
		else if (Shi >= 1 && Ge != 0)
			result = result + second[Shi] + " ";
		else
			result = result + second[Shi];
		result = result + first[Ge];

		return result;
	}

	public String numberToWords1(int num) {
		String[][] first = { { "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine" },
				{ "", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety" },
				{ "", "One Hundred", "Two Hundred", "Three Hundred", "Four Hundred", "Five Hundred", "Six Hundred",
						"Seven Hundred", "Eight Hundred", "Nine Hundred" } };
		String[] second = { "", "Thousand", "Million", "Billion" };
		String result = "";
		int temp = 0, count = 0, next = 0;
		if (num == 0)
			return "Zero";
		while (num > 0) {
			if (num == 11 && next == 0)
				return "Eleven " + result;
			if (num == 12 && next == 0)
				return "Twelve " + result;
			temp = num % 10;
			if (count == 0 || result == "")
				result = first[next][temp];
			else if (temp == 0)
				result = first[next][temp] + result;
			else
				result = first[next][temp] + " " + result;
			next++;
			if (next % 3 == 0 && num >= 10) {
				if (result.equalsIgnoreCase(second[count / 3]))
					result = second[count / 3 + 1];
				else
					result = second[count / 3 + 1] + " " + result;
				next = 0;
			}
			count++;
			num = (num - temp) / 10;
		}
		return result;

	}
}

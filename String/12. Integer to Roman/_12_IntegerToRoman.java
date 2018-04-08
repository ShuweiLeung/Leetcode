/*
Given an integer, convert it to a roman numeral.

Input is guaranteed to be within the range from 1 to 3999.
 */

package string.medium;

public class _12_IntegerToRoman {
	public static void main(String[] args) {
		_12_IntegerToRoman test = new _12_IntegerToRoman();
		System.out.print(test.intToRoman(45));
	}
	
	/**
	 * 罗马数字的基本型为：I=1，V=5，X=10，L=50，C=100，D=500，M=1000，相同的罗马数字最多不能超过三个。所以对于4只能表示为5-1即IV，
	 * 左减右加，即4=IV。同理，9=IX，40=XL，90=XC，400=CD，900=CM。
	 * @param num
	 * @return String
	 */
	public String intToRoman(int num) {
		StringBuilder result = new StringBuilder();
		while(num != 0) {
			if(num / 1000 > 0) {
				for(int i = 0; i < num / 1000; i++) {
					result.append("M");
				}
				num -= (num / 1000) * 1000;
			}
			else if(num / 900 > 0) {
				for(int i = 0; i < num / 900; i++) {
					result.append("CM");
				}
				num -= (num / 900) * 900;
			}
			else if(num / 500 > 0) {
				for(int i = 0; i < num / 500; i++) {
					result.append("D");
				}
				num -= (num / 500) * 500;
			}
			else if(num / 400 > 0) {
				for(int i = 0; i < num / 400; i++) {
					result.append("CD");
				}
				num -= (num / 400) * 400;
			}
			else if(num / 100 > 0) {
				for(int i = 0; i < num / 100; i++) {
					result.append("C");
				}
				num -= (num / 100) * 100;
			}
			else if(num / 90 > 0) {
				for(int i = 0; i < num / 90; i++) {
					result.append("XC");
				}
				num -= (num / 90) * 90;
			}
			else if(num / 50 > 0) {
				for(int i = 0; i < num / 50; i++) {
					result.append("L");
				}
				num -= (num / 50) * 50;
			}
			else if(num / 40 > 0) {
				for(int i = 0; i < num / 40; i++) {
					result.append("XL");
				}
				num -= (num / 40) * 40;
			}
			else if(num / 10 > 0) {
				for(int i = 0; i < num / 10; i++) {
					result.append("X");
				}
				num -= (num / 10) * 10;
			}
			else if(num / 9 > 0) {
				for(int i = 0; i < num / 9; i++) {
					result.append("IX");
				}
				num -= (num / 9) * 9;
			}
			else if(num / 5 > 0) {
				for(int i = 0; i < num / 5; i++) {
					result.append("V");
				}
				num -= (num / 5) * 5;
			}
			else if(num / 4 > 0) {
				for(int i = 0; i < num / 4; i++) {
					result.append("IV");
				}
				num -= (num / 4) * 4;
			}
			else if(num / 1 > 0) {
				for(int i = 0; i < num / 1; i++) {
					result.append("I");
				}
				num -= (num / 1) * 1;
			}
		}
		return result.toString();
	}
}

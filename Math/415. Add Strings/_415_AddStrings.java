/*
Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and num2.

Note:

    1. The length of both num1 and num2 is < 5100.
    2. Both num1 and num2 contains only digits 0-9.
    3. Both num1 and num2 does not contain any leading zero.
    4. You must not use any built-in BigInteger library or convert the inputs to integer directly.

 */

package math.easy;

public class _415_AddStrings {
	public static void main(String[] args) {
		_415_AddStrings test = new _415_AddStrings();
		System.out.println(test.addStrings("584", "18"));
	}
	
	public String addStrings(String num1, String num2) {
		if(num1.length() < num2.length()) {		//保证num1的长度大于等于num2的长度
	    		String temp = num1;
	    		num1 = num2;
	    		num2 = temp;
	    }
		
		int carryBit = 0;
		StringBuilder sb = new StringBuilder();
		for(int i = num2.length() - 1, j = num1.length() - 1; i >= 0; i--, j--) {
			int sum = num1.charAt(j) - '0' + num2.charAt(i) - '0' + carryBit;
			sb.insert(0, sum % 10);
			carryBit = sum / 10;
		}
		for(int j = num1.length() - num2.length() - 1; j >= 0; j--) {
			int sum = num1.charAt(j) - '0' + carryBit;
			sb.insert(0, sum % 10);
			carryBit = sum / 10;
		}
		if(carryBit != 0)
			sb.insert(0, carryBit);
		return sb.toString();
	}
}

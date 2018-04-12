/*
Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2.

Note:

    1.The length of both num1 and num2 is < 110.
    2.Both num1 and num2 contains only digits 0-9.
    3.Both num1 and num2 does not contain any leading zero.
    4.You must not use any built-in BigInteger library or convert the inputs to integer directly.

 */

public class _43_MultiplyStrings {
	public String multiply(String num1, String num2) {
        if(num1.length() < num2.length()) {		//保证num1的长度大于等于num2的长度
        		String temp = num1;
        		num1 = num2;
        		num2 = temp;
        }
        
        int len1 = num1.length(), len2 = num2.length();
        char[] result = new char[len1+len2+1];		//两数相乘最大len1+len2+1位，也可能是len1+len2位
        for(int i = 0; i < result.length; i++)
        		result[i] = '0';
        
        for(int i = num2.length() - 1; i >= 0; i--) {
            StringBuilder multiply = new StringBuilder();
        		int multiplyCarryBit = 0; 		//进位
        		for(int j = num1.length() - 1; j >= 0; j--) {
        			int multiplyResult = (num1.charAt(j) - '0') * (num2.charAt(i) - '0') + multiplyCarryBit;
        			multiplyCarryBit = multiplyResult / 10;
        			multiply.insert(0, multiplyResult%10);
        		}
        		if(multiplyCarryBit > 0)
            		multiply.insert(0, multiplyCarryBit);
        		int p1 = result.length - 1 - (num2.length() - 1 - i), p2 = multiply.length() - 1;
        		int addCarryBit = 0;
        		while(p1 >= 0 && p2 >= 0) {
        			int addResult = result[p1] - '0' + multiply.charAt(p2) - '0' + addCarryBit;
        			addCarryBit = addResult / 10;
        			result[p1] = (char)(addResult % 10 + (int)'0');
        			p1--;
        			p2--;
        		}
        		if(addCarryBit > 0)
        			result[p1] = (char)(addCarryBit + (int)'0');		//处理结果相加时的最高位进位
        }
        
        int q = 0;
        while(q < result.length) {
        		if(result[q] == '0')
        			q++;
        		else
        			break;
        }
        if(q == result.length)	//说明有一个因子是0
        		return "0";
        else
        		return String.valueOf(result).substring(q);
    }
}

/*
Implement atoi to convert a string to an integer.

Hint: Carefully consider all possible input cases. If you want a challenge, please do not see below and ask 
yourself what are the possible input cases.

Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). You are responsible to
 gather all the input requirements up front.


Requirements for atoi:

The function first discards as many whitespace characters as necessary until the first non-whitespace character is 
found. Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical 
digits as possible, and interprets them as a numerical value.

The string can contain additional characters after those that form the integral number, which are ignored and have
 no effect on the behavior of this function.

If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence 
exists because either str is empty or it contains only whitespace characters, no conversion is performed.

If no valid conversion could be performed, a zero value is returned. If the correct value is out of the range of 
representable values, INT_MAX (2147483647) or INT_MIN (-2147483648) is returned.

 */

package string.medium;

public class _8_StringToInteger_atoi {
	public static void main(String[] args) {
		_8_StringToInteger_atoi test = new _8_StringToInteger_atoi();
		System.out.println(test.myAtoi("-1"));
	}
	
	/*
	 * beat 26%，按照“Requirements for atoi”进行实现即可
	 */
	public int myAtoi(String str) {
		str = str.trim();
		if(str.length() == 0)
			return 0;
		
		char sign;
		int i = 0;
		if(str.charAt(0) == '-') {
			sign = '-';
			i++;
		}
		else if(str.charAt(0) == '+') {
			sign = '+';
			i++;
		}
		else if(str.charAt(0) >= 48 && str.charAt(0) <= 57) {
			sign = '+';
		}
		else
			return 0;
		
		StringBuilder sb = new StringBuilder();
		while(i < str.length()) {
			if(str.charAt(i) >= '0' && str.charAt(i) <= '9') {
				sb.append(str.charAt(i));
				i++;
			}
			else
				break;
		}
		
		try {
			if(sb.length() == 0)
				return 0;
			else	{
				if(sign == '+')
					return Integer.valueOf(sb.toString());
				else
					return Integer.valueOf(sb.toString())*(-1);
			}
		}
		catch(NumberFormatException e) {
			if(sign == '+')
				return Integer.MAX_VALUE;
			else
				return Integer.MIN_VALUE;
		}
	}
}

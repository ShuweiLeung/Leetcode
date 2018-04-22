/*
A self-dividing number is a number that is divisible by every digit it contains.

For example, 128 is a self-dividing number because 128 % 1 == 0, 128 % 2 == 0, and 128 % 8 == 0.

Also, a self-dividing number is not allowed to contain the digit zero.

Given a lower and upper number bound, output a list of every possible self dividing number, including the bounds if possible.

Example 1:

Input: 
left = 1, right = 22
Output: [1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22]

Note:
The boundaries of each input argument are 1 <= left <= right <= 10000.
 */

import java.util.ArrayList;
import java.util.List;

public class _728_SelfDividingNumbers {
	public List<Integer> selfDividingNumbers(int left, int right) {
		List<Integer> list = new ArrayList<>();
		for(int i = left; i <= right; i++) {
			char[] digits = String.valueOf(i).toCharArray();
			int divided = -1; 		//标记当前的数字是否能被每一个digit除尽,0为不能，1为能
			for(int j = 0; j < digits.length; j++) {
				if(digits[j] == '0') {
					divided = 0;
					break;
				}
				if(i % (digits[j] - '0') != 0) {
					divided = 0;
					break;
				}
				else
					divided = 1;
			}
			if(divided == 1)
				list.add(i);
		}
		return list;
	}
}

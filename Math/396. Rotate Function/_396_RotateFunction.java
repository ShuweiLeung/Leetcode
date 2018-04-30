/*
 Given an array of integers A and let n to be its length.

Assume Bk to be an array obtained by rotating the array A k positions clock-wise, we define a "rotation function"
 F on A as follow:

F(k) = 0 * Bk[0] + 1 * Bk[1] + ... + (n-1) * Bk[n-1].

Calculate the maximum value of F(0), F(1), ..., F(n-1).

Note:
n is guaranteed to be less than 105.

Example:

A = [4, 3, 2, 6]

F(0) = (0 * 4) + (1 * 3) + (2 * 2) + (3 * 6) = 0 + 3 + 4 + 18 = 25
F(1) = (0 * 6) + (1 * 4) + (2 * 3) + (3 * 2) = 0 + 4 + 6 + 6 = 16
F(2) = (0 * 2) + (1 * 6) + (2 * 4) + (3 * 3) = 0 + 6 + 8 + 9 = 23
F(3) = (0 * 3) + (1 * 2) + (2 * 6) + (3 * 4) = 0 + 2 + 12 + 12 = 26

So the maximum value of F(0), F(1), F(2), F(3) is F(3) = 26.

 */

package math.medium;

import java.util.ArrayList;

public class _396_RotateFunction {
	public static void main(String[] args) {
		_396_RotateFunction test = new _396_RotateFunction();
		int[] A = {4, 3, 2, 6};
		System.out.println(test.maxRotateFunction(A));
	}
	
	/**
	 * 根据规律计算F(i)值，具体推导见笔记，beat 99%
	 * @param A
	 * @return
	 */
	public int maxRotateFunction(int[] A) {
		int allSum = 0;		//a[0]..A[n-1]的元素和，即Bk[0] + ... + Bk[n-1]
		int len = A.length;
		int F = 0;
		for (int i = 0; i < len; i++) {
		    F += i * A[i];			//该循环计算的是F(0)的值
		    allSum += A[i];	
		}
		int max = F;
		for (int i = len - 1; i >= 1; i--) {
		    F = F + allSum - len * A[i];		//该循环在已知F(i)的情况下计算F(i+1)的值
		    max = Math.max(F, max);			//取F(0)..F(n-1)中的最大值
		}
		return max;  
	}
	
	/**
	 * 按照题目，每次顺时针移动一个元素并计算最新的F值
	 * 效率很低，只beat 4%
	 * @param A
	 * @return
	
	public int maxRotateFunction(int[] A) {
		if(A == null || A.length == 0)
			return 0;
		
		ArrayList<Integer> list = new ArrayList<>();
		for(int a:A)
			list.add(a);
		
		int maxValue = Integer.MIN_VALUE;
		for(int count = 0; count < A.length; count++) {
			int value = F(list);
			if(value > maxValue)
				maxValue = value;
			int lastNum = list.remove(list.size() - 1);
			list.add(0, lastNum);
		}
		return maxValue;
	}
	
	public int F(ArrayList<Integer> list) {
		int result = 0;
		for(int i = 0; i < list.size(); i++) {
			result += i * list.get(i);
		}
		return result;
	}
	*/
}

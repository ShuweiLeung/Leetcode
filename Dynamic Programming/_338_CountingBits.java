/*
Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num calculate the number of 1's 
in their binary representation and return them as an array.

Example:
For num = 5 you should return [0,1,1,2,1,2].

Follow up:

    It is very easy to come up with a solution with run time O(n*sizeof(integer)). But can you do it in linear time
     O(n) /possibly in a single pass?
    Space complexity should be O(n).
    Can you do it like a boss? Do it without using any builtin function like __builtin_popcount in c++ or in any 
    other language.

 */

package dynamicprogramming.medium;

public class _338_CountingBits {
	public static void main(String[] args) {
		_338_CountingBits test = new _338_CountingBits();
		System.out.print(test.countBits(2));
	}
	
	/**
	 * 省去了Math函数的使用，但思路相同
	 * @param num
	 * @return
	 */
	public int[] countBits(int num) {
		int[] res = new int[num+1];
		
		res[0] = 0;
		if(num == 0)
			return res;
		res[1] = 1;
		if(num == 1)
			return res;
		
		int last2pow = 2;
		for(int i = 2; i < res.length; i++) {
			if(last2pow * 2 <= i)
				last2pow *= 2;
			if(last2pow == i)
				res[i] = 1;
			else {
				int t = i - last2pow;
				res[i] = res[t] + 1;
			}
		}
		
		return res;
	}
	
	/*
	 * 利用Math.pow公式作幂次运算，因为用到Math函数，所以效率较低
	public int[] countBits(int num) {
		int[] res = new int[num+1];
		
		res[0] = 0;
		if(num == 0)
			return res;
		res[1] = 1;
		if(num == 1)
			return res;
		
		int power = 1;	//幂次
		for(int i = 2; i < res.length; i++) {
			if(Math.pow(2, power) <= i && Math.pow(2, power+1) <= i)
				power++;
			if(Math.pow(2, power) == i)
				res[i] = 1;
			else {
				int t = i - (int)Math.pow(2, power);
				res[i] = res[t] + 1;
			}
		}
		
		return res;
	}
	*/
}

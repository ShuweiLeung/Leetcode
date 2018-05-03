/*
You have n super washing machines on a line. Initially, each washing machine has some dresses or is empty.

For each move, you could choose any m (1 ≤ m ≤ n) washing machines, and pass one dress of each washing machine to 
one of its adjacent washing machines at the same time .

Given an integer array representing the number of dresses in each washing machine from left to right on the line,
 you should find the minimum number of moves to make all the washing machines have the same number of dresses. If
  it is not possible to do it, return -1.

Example1

Input: [1,0,5]

Output: 3

Explanation: 
1st move:    1     0 <-- 5    =>    1     1     4
2nd move:    1 <-- 1 <-- 4    =>    2     1     3    
3rd move:    2     1 <-- 3    =>    2     2     2   

Example2

Input: [0,3,0]

Output: 2

Explanation: 
1st move:    0 <-- 3     0    =>    1     2     0    
2nd move:    1     2 --> 0    =>    1     1     1     

Example3

Input: [0,2,0]

Output: -1

Explanation: 
It's impossible to make all the three washing machines have the same number of dresses. 

Note:

    The range of n is [1, 10000].
    The range of dresses number in a super washing machine is [0, 1e5].

 */

package math.hard;

public class _517_SuperWashingMachines {
	public static void main(String[] args) {
		
	}
	
	/**
	 * 个人认为该题并不能算作一个DP问题，因为更新dp[i]时，并没有与dp[0...i-1]建立联系，而是和avgNum一个固定数值进行比较，因为它并没有一个子结构
	 * 我们可以把该问题看作一个管道，管道大小为1，衣服的移动相当于水流的流动，返回值就是最大的水位差
	 * @param machines
	 * @return
	 */
	public int findMinMoves(int[] machines) {
		int sum = 0, n = machines.length;
		for(int e:machines)
			sum += e;
		if(sum % n != 0)		//衣服总数不能被洗衣机的个数整除
			return -1;
		
		int avgNum = sum / n;
		int[] move = new int[n];			//为了使machines[i]达到平均数量，需要移动多少步
		int result = 0;
		
		for(int i = 0; i < n - 1; i++) {		//我们只考虑第i个洗衣机和第i+1个洗衣机的关系
			if(machines[i] > avgNum) {
				move[i] += machines[i] - avgNum;		//注意是+=，而不是=，因为machines[i]之前可能已经遍历到（见下面else语句）
				machines[i+1] += machines[i]-avgNum;		//对于i位置多余的衣服，machines[i]的衣服移向machines[i+1]
				machines[i] = avgNum;
				result = Math.max(result, move[i]);
			}
			else {	
				move[i+1] = avgNum - machines[i];	//注意是=，而不是+=，因为machines[i+1]一定没有访问过
				machines[i+1] -= avgNum - machines[i];	//对于i位置缺少的衣服，machines[i+1]的衣服移向machines[i]
				machines[i] = avgNum;
				result = Math.max(result, move[i+1]);
			}
		}
		return result;
	}
}

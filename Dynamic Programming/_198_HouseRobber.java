/*
You are a professional robber planning to rob houses along a street. Each house has a certain amount of money 
stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system 
connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount
 of money you can rob tonight without alerting the police.

Example 1:

Input: [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
             Total amount you can rob = 1 + 3 = 4.

Example 2:

Input: [2,7,9,3,1]
Output: 12
Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
             Total amount you can rob = 2 + 9 + 1 = 12.
 */

package dynamicprogramming.easy;

public class _198_HouseRobber {
	/**
	 * 简化空间复杂度
	 * @param num
	 * @return
	 */
	public int rob(int[] num) {
	    int prevNo = 0;
	    int prevYes = 0;
	    for (int n : num) {
	        int temp = prevNo;
	        prevNo = Math.max(prevNo, prevYes);
	        prevYes = n + temp;
	    }
	    return Math.max(prevNo, prevYes);
	}
	
	/*
	 * 详细设计思路
	public int rob(int[] nums) {
		if(nums.length == 0 || nums == null)
			return 0;
		
		if(nums.length == 1)
			return nums[0];
		
		int n = nums.length;
		int[] yes = new int[n];	//代表抢第i个房子的最大价值
		int[] no = new int[n];	//代表不抢第i个房子的最大价值
		
		//初始化变量
		yes[0] = nums[0];
		yes[1] = nums[1];
		no[1] = yes[0];
		
		for(int i = 2; i < nums.length; i++) {
			yes[i] = Math.max(yes[i-2] + nums[i], no[i-2] + nums[i]);	//如果第i个房子要抢，那么第i-1个房子一定不能抢，所以获得的总价值应该是"i-2个房子抢或不抢的最大值+i个房子的价值"
			no[i] = Math.max(yes[i-1], no[i-1]);	//如果第i个房子不抢，那么第i个房子的最大价值应该是i-1个房子抢或不抢的最大值
		}
		
		return Math.max(yes[n-1], no[n-1]);
	}
	*/
}

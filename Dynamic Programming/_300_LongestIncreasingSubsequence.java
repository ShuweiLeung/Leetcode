/*
Given an unsorted array of integers, find the length of longest increasing subsequence.

Example:

Input: [10,9,2,5,3,7,101,18]
Output: 4 
Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4. 

Note:

    There may be more than one LIS combination, it is only necessary for you to return the length.
    Your algorithm should run in O(n2) complexity.

Follow up: Could you improve it to O(n log n) time complexity?
 */

package dynamicprogramming.medium;

import java.util.Arrays;

public class _300_LongestIncreasingSubsequence {
	public int lengthOfLIS(int[] nums) {
		if(nums == null || nums.length == 0)
			return 0;
		if(nums.length == 1)
			return 1;
		
		int maxLen = 0;
		int[] dp = new int[nums.length];	//dp[i]代表前0至i个元素中最长序列长度
		Arrays.fill(dp, 1);		//每个元素自身能构成一个长度为1的序列
		
		for(int i = 1; i < nums.length; i++) {
			for(int j = 0; j < i; j++) {
				if(nums[j] < nums[i])
					dp[i] = Math.max(dp[i], dp[j]+1);
			}
			maxLen = Math.max(maxLen, dp[i]);
		}
		
		return maxLen;
	}
}

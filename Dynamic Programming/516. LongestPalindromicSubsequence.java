/*
 Given a string s, find the longest palindromic subsequence's length in s. You may assume that the maximum length 
 of s is 1000.

Example 1:
Input:

"bbbab"

Output:

4

One possible longest palindromic subsequence is "bbbb".

Example 2:
Input:

"cbbd"

Output:

2

One possible longest palindromic subsequence is "bb". 
 */

public class _516_LongestPalindromicSubsequence {
	/**
	 * 该题与Leetcode String类第647题思路类似
	 * @param s
	 * @return
	 */
	public int longestPalindromeSubseq(String s) {
        int[][] dp = new int[s.length()][s.length()];
        
      //i从s.length()-1开始从后往前遍历，是因为在下面的for循环里面要用到i+1，所以bottom-up要用到之前的信息而不是未知的信息，
      //因此从后往前遍历
        for (int i = s.length() - 1; i >= 0; i--) {	
            dp[i][i] = 1;
            for (int j = i+1; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i+1][j-1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
                }
            }
        }
        return dp[0][s.length()-1];
    }
}

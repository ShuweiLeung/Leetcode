/*
Given a string S and a string T, count the number of distinct subsequences of S which equals T.

A subsequence of a string is a new string which is formed from the original string by deleting some (can be none)
 of the characters without disturbing the relative positions of the remaining characters. (ie, "ACE" is a subsequence
  of "ABCDE" while "AEC" is not).

Here is an example:
S = "rabbbit", T = "rabbit"

Return 3.

 */

public class _115_DistinctSubsequences {
	public int numDistinct(String S, String T) {
		int n = S.length();
	    int m = T.length();
	    
	    int[][] dp = new int[n+1][m+1];
	    
	    for (int i = 0; i < n+1; i++) {
	        dp[i][0] = 1;
	    }
	    
	    for (int j = 1; j < m+1; j++) {
	        dp[0][j] = 0;
	    }
	    
	    for (int j = 1; j < m+1; j++) {
	        for (int i = 1; i < n+1; i++) {
	            dp[i][j] = dp[i-1][j];
	            if (S.charAt(i-1) == T.charAt(j-1)) {
	                dp[i][j] += dp[i-1][j-1];
	            }
	        }
	    }
	    
	    return dp[n][m];
	}
}

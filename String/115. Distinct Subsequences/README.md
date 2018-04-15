[Hard]Distinct Subsequences
===

## Description
Given a string **S** and a string **T**, count the number of distinct subsequences of **S** which equals **T**.

A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, `"ACE"` is a subsequence of `"ABCDE"` while `"AEC"` is not).

Here is an example:
**S** = `"rabbbit"`, **T** = `"rabbit"`

Return `3`.


## Idea
Explanation to the state transition function

dp[i][j] = dp[i-1][j] when s[i-1] != t[j-1] or dp[i][j] = dp[i-1][j] + dp[i-1][j-1] when s[i-1] == t[j-1],
dp[i][j] represents the number of distinct subsequences for s[0, i-1] and t[0, t-1];

We first keep in mind that **s is the longer string [0, i-1], t is the shorter substring [0, j-1]. We can assume t is fixed, and s is increasing in character one by one (this is the key point)**.

For example:
t : ab–> ab --> ab --> ab
s: a --> ac --> acb --> acbb

The first case is easy to catch. When the new character in s, s[i-1], is not equal with the head char in t, t[j-1], we can no longer increment the number of distinct subsequences, it is the same as the situation before incrementing the s, so dp[i][j] = dp[i-1][j].

However, when the new incrementing character in s, s[i-1] is equal with t[j-1], which contains two case:

1. We don’t match those two characters, which means that it still has original number of distinct subsequences, so dp[i][j] = dp[i-1][j].
2. We match those two characters, in this way. dp[i][j] = dp[i-1][j-1];

Thus, including both two case, dp[i][j] = dp[i-1][j] + dp[i-1][j-1]

[Hard]Palindrome Pairs
===

## Description
Given a list of **unique** words, find all pairs of **distinct** indices `(i, j)` in the given list, so that the concatenation of the two words, i.e. `words[i] + words[j]` is a palindrome.

**Example 1:**

Given `words` = `["bat", "tab", "cat"]`

Return `[[0, 1], [1, 0]]`

The palindromes are `["battab", "tabbat"]`

**Example 2:**

Given `words` = `["abcd", "dcba", "lls", "s", "sssll"]`

Return `[[0, 1], [1, 0], [3, 2], [2, 4]]`

The palindromes are `["dcbaabcd", "abcddcba", "slls", "llssssll"]`

## Idea
There are 4 cases to be considered that isPalindrome(s1 + s2):

Case1: If s1 is a blank string, then for any string that is palindrome s2, s1+s2 and s2+s1 are palindrome.

Case 2: If s2 is the reversing string of s1, then s1+s2 and s2+s1 are palindrome.

Case 3: If s1[0:cut] is palindrome and there exists s2 is the reversing string of s1[cut+1:] , then s2+s1 is palindrome.

Case 4: Similiar to case3. If s1[cut+1: ] is palindrome and there exists s2 is the reversing string of s1[0:cut] , then s1+s2 is palindrome.

To make the search faster, build a HashMap to store the String-idx pairs.

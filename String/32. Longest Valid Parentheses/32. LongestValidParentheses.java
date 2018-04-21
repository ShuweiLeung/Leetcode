/*
Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) 
parentheses substring.

Example 1:

Input: "(()"
Output: 2
Explanation: The longest valid parentheses substring is "()"

Example 2:

Input: ")()())"
Output: 4
Explanation: The longest valid parentheses substring is "()()"

 */

import java.util.Stack;

public class _32_LongestValidParentheses {
	/**
	 * The workflow of the solution is as below.

	    1. Scan the string from beginning to end.
	    2. If current character is ‘(’,
		    push its index to the stack. If current character is ‘)’ and the
		    character at the index of the top of stack is ‘(’, we just find a
		    matching pair so pop from the stack. Otherwise, we push the index of
		    ’)’ to the stack.
	    3. After the scan is done, the stack will only
		    contain the indices of characters which cannot be matched. Then
		    let’s use the opposite side - substring between adjacent indices
		    should be valid parentheses.
	    4. If the stack is empty, the whole input
		    string is valid. Otherwise, we can scan the stack to get longest
		    valid substring as described in step 3.

	 * @param s
	 * @return
	 */
	public int longestValidParentheses(String s) {
		int n = s.length(), longest = 0;
		Stack<Integer> st = new Stack<>();
		for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') 
            		st.push(i);
            else {
                if (!st.empty()) {
                    if (s.charAt(st.lastElement()) == '(') 
                    	st.pop();
                    else 
                    	st.push(i);
                }
                else 
                    st.push(i);
            }
        }
		
		if (st.empty()) 
			longest = n;
		else {
            		int a = n, b = 0;
            		while (!st.empty()) {
                		b = st.pop();
                		longest = Math.max(longest, a-b-1);
                		a = b;
            		}
            		longest = Math.max(longest, a);
        	}
        	return longest;
	}
}

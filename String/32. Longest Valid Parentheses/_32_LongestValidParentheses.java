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

package string.hard;

import java.util.Stack;

public class _32_LongestValidParentheses {
	public static void main(String[] args) {
		_32_LongestValidParentheses test = new _32_LongestValidParentheses();
		System.out.println(test.longestValidParentheses("()(())(()"));
	}
	
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
	
	/*
	 * 下面是自己的思路，不能通过所有的test case，有漏洞
	public int longestValidParentheses(String s) {
		Stack<Integer> stack = new Stack<>();
		int maxLen = 0, curLen = 0;
		char[] chars = s.toCharArray();
		for(int i = 0; i < chars.length; i++) {
			if(chars[i] == '(')
				stack.push(i);
			else if(chars[i] == ')') {
				if(stack.size() == 0) {		//多余的右括号直接略过
					continue;
				}
				else {	//匹配成功
					stack.pop();
				}
			}
		}
		
		//找出未匹配的左括号，如"()(()"的最大有效长度时2不是4
		if(stack.size() > 0) {
			while(stack.size() != 0) {			//将未匹配的左括号作标记，在统计最大长度时遇到这些位置的左括号应将curLen重置
				int index = stack.pop();
				chars[index] = '0';
			}
		}
		
		for(int i = 0; i < chars.length; i++) {
		    if(chars[i] == '0') {
			    	if(curLen > maxLen) {
					maxLen = curLen;
					curLen = 0;
				}
		    }
		    else if(chars[i] == '(')
				stack.push(i);
			else if(chars[i] == ')') {
				if(stack.size() == 0) {		//多余的右括号直接略过
					if(curLen > maxLen) {
						maxLen = curLen;
						curLen = 0;
					}
				}
				else {	//匹配成功
					stack.pop();
					curLen += 2;		//一对左右括号的长度为2
				}
			}
		}
		
		if(curLen > maxLen)		//特殊处理最后一个字符
			maxLen = curLen;
		
		return maxLen;
	}
	*/
}

/*
Given an input string (s) and a pattern (p), implement regular expression matching with support for '.' and '*'.

'.' Matches any single character.
'*' Matches zero or more of the preceding element.

The matching should cover the entire input string (not partial).

Note:

    s could be empty and contains only lowercase letters a-z.
    p could be empty and contains only lowercase letters a-z, and characters like . or *.

Example 1:

Input:
s = "aa"
p = "a"
Output: false
Explanation: "a" does not match the entire string "aa".

Example 2:

Input:
s = "aa"
p = "a*"
Output: true
Explanation: '*' means zero or more of the precedeng element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".

Example 3:

Input:
s = "ab"
p = ".*"
Output: true
Explanation: ".*" means "zero or more (*) of any character (.)".

Example 4:

Input:
s = "aab"
p = "c*a*b"
Output: true
Explanation: c can be repeated 0 times, a can be repeated 1 time. Therefore it matches "aab".

Example 5:

Input:
s = "mississippi"
p = "mis*is*p*."
Output: false

 */


public class _10_RegularExpressionMatching {
	/**
	 * 递归调用的思路，字符串和正则表达式均是从后往前进行读取和解析
	 * @param s
	 * @param p
	 * @return
	 */
	public boolean isMatch(String s, String p) {
		return myMatch(s,s.length()-1,p,p.length()-1);
	}
	
	/**
	 * 
	 * @param s:字符串s
	 * @param i:指向字符串s的指针
	 * @param p:正则表达式
	 * @param j:指向正则表达式的指针
	 * @return 当前i字符与j字符能否正确匹配
	 */
	boolean myMatch(String s, int i, String p, int j) {
		if(j == -1)
            if(i == -1)    
            		return true;
            else 
            		return false;
		
		//字符串已扫描完毕，但正则表达式没有全部解析完成，不能直接返回false，需要进一步判断
		if(p.charAt(j) == '*')
        {
            if(i > -1 && (p.charAt(j - 1) == '.' || p.charAt(j - 1) == s.charAt(i)))
                if(myMatch(s,i-1,p,j))		//对于“X*”，尝试匹配一个或多个X
                    return true;
            return myMatch(s,i,p,j-2);	//“X*”匹配失败，选择略过"X*"的配对
        }
		if(i > -1 && j > -1) {
	        if(p.charAt(j) == '.' || p.charAt(j) == s.charAt(i))
	            return myMatch(s,i-1,p,j-1);
		}
        return false;
	}
	
	/*
	 * 下面的思路是从左往右读取字符，先读取正则表达式，然后再解析字符串
	 * 虽然能解决大部分正常的解析式，但对如s="aaa" p="ab*a*c*a"的测试例无法通过，如果仍按照该思路，只能利用“递归调用”来解决
	public boolean isMatch(String s, String p) {
		int i = 0, j = 0; 		//分别指向s、p串的指针
		while(i < s.length() && j < p.length()) {
			//先解析正则表达式
			char curP = p.charAt(j);
			char specialChar = '#';		//’#‘表示无特殊字符，每次循环都会初始化
			if(j + 1 < p.length()) {
				if(p.charAt(j + 1) == '*') {
					specialChar = '*';
					j += 2;
				}
				else
					j++;
			}
			else			//表示已读完正则表达式
				j++;
			
			//再根据正则表达式解析字符串
			
			if(specialChar == '#') {
				if(curP == '.')		//注意，curP也可能等于'.'
					i++;
				else if(s.charAt(i) == curP)
					i++;
				else
					return false;
			}
			else if(specialChar == '*') {
				//因为’*‘可以匹配0个或多个curP，所以即使curP与当前i指针的字符不等，也符合条件。
				//此外，还需注意，curP也可能等于'.'
				if(curP == '.') {		//直接就能匹配所有s中的字符
					i = s.length();
					break;
				}
				else if(curP != '.') {
					if(s.charAt(i) == curP) {
						while(i < s.length()) {
							if(s.charAt(i) == curP)
								i++;
							else
								break;
						}
					}
					else if(s.charAt(i) != curP)		//'*'允许不匹配，因为此时的charP可以出现零次
						continue;
				}
			}
		}
		
		if(i == s.length() && j == p.length())
			return true;
		else if(i != s.length() && j == p.length())
			return false;
		
		// i == s.length() && j != p.length()	即字符串已匹配完，但正则表达式还没有解析完
		while(j < p.length()) {
			char curP = p.charAt(j);
			char specialChar = '#';		//’#‘表示无特殊字符，每次循环都会初始化
			char prePreChar = '#';
			char preChar = '#';
			
			if(j - 2 >= 0) {	
				prePreChar = p.charAt(j - 2);
				preChar = p.charAt(j - 1);
			}
			
			if(j + 1 < p.length()) {
				if(p.charAt(j + 1) == '*') {
					specialChar = '*';
					j += 2;
				}
				else
					j++;
			}
			else			//curP就是最后一个字符
				j++;

			if(specialChar != '*'){
				if(s.length() != 0) {
					if((prePreChar == curP || prePreChar == '.') && preChar == '*' && s.charAt(s.length() - 1) == curP)	//如s="aaa"，p="a*a"
						continue;
				}
			
				return false;
			}
		}
		return true;
	}
	*/
}

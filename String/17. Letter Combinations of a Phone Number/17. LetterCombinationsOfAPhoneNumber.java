/*
Given a digit string, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below.

Input:Digit string "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].

Note:
Although the above answer is in lexicographical order, your answer could be in any order you want. 
 */

import java.util.List;
import java.util.ArrayList;

public class _17_LetterCombinationsOfAPhoneNumber {
	String[][] map = {{}, {}, {"a","b","c"}, {"d","e","f"}, {"g","h","i"}, {"j","k","l"}, {"m","n","o"}, {"p","q","r","s"}, {"t","u","v"}, {"w","x","y","z"}};
	
	public List<String> letterCombinations(String digits) {
		List<String> res = (List<String>)new ArrayList<String>();		//结果集
		if(digits.length() == 0)
			return res;
		dfs(res, digits, 0, "");			//递归调用
		return res;
	}
	
	public void dfs(List<String> res, String digits, int depth, String path) {
		if(depth == digits.length()) {
			res.add(path);
			return;
		}
		if(digits.charAt(depth) == '0' || digits.charAt(depth) == '1')	//digit为0或1时，没有代表的字母，故跳过
			dfs(res, digits, depth+1, path);
		else {
			int digit = Integer.valueOf(String.valueOf(digits.charAt(depth)));	//当前扫描到的digit
			for(int i = 0; i < map[digit].length; i++) {
				dfs(res, digits, depth+1, path+map[digit][i]);
			}
		}
	}
}

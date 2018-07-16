/*
Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be 
segmented into a space-separated sequence of one or more dictionary words.

Note:

    The same word in the dictionary may be reused multiple times in the segmentation.
    You may assume the dictionary does not contain duplicate words.

Example 1:

Input: s = "leetcode", wordDict = ["leet", "code"]
Output: true
Explanation: Return true because "leetcode" can be segmented as "leet code".

Example 2:

Input: s = "applepenapple", wordDict = ["apple", "pen"]
Output: true
Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
             Note that you are allowed to reuse a dictionary word.

Example 3:

Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
Output: false
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class _139_WordBreak {
	public static void main(String[] args) {
		_139_WordBreak test = new _139_WordBreak();
		String s = "leetcode";
		List<String> wordDict = new ArrayList<>();
		wordDict.add("leet");
		wordDict.add("code");
		System.out.println(test.wordBreak(s, wordDict));
	}
	
	public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<String>(wordDict);	//将wordDict转化为set，利于一次存取即可得到结果
        Map<String, Boolean> mem = new HashMap<String, Boolean>();//存储该字符串是否能被成功分割
        return wordBreak(s, mem, dict);
    }
 
    private boolean wordBreak(String s, Map<String, Boolean> mem, Set<String> dict) {
        if (mem.containsKey(s)) return mem.get(s);
        if (dict.contains(s)) {
            mem.put(s, true);
            return true;
        }
        
        for (int i = 1; i < s.length(); ++i) {
            if (wordBreak(s.substring(0, i), mem, dict) && dict.contains(s.substring(i))) {//将dict的判断和递归函数交换一下顺序可以减少递归深度，提高效率。即换成dict.contains(s.substring(i)) && wordBreak(s.substring(0, i), mem, dict)
                mem.put(s, true);
                return true;
            }
        }
        
        mem.put(s, false);
        return false;
    }
}

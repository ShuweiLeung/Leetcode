/*
Given an array of strings, group anagrams together.

For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"],
Return:

[
  ["ate", "eat","tea"],
  ["nat","tan"],
  ["bat"]
]

Note: All inputs will be in lower-case.
 
 */

package string.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;
import java.util.Map.Entry;

public class _49_GroupAnagrams {
	public static void main(String[] args) {
		_49_GroupAnagrams test = new _49_GroupAnagrams();
		String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
		test.groupAnagrams(strs);
	}
	
	public List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> result = new ArrayList<List<String>> ();
		Hashtable<String, List<String>> table = new Hashtable<String, List<String>>();	//key是字母，value是anagram字符串
		for(String str:strs) {
			char[] arr = str.toCharArray();
			Arrays.sort(arr);
			String originalWord = String.valueOf(arr);
			if(!table.containsKey(originalWord)) {		//Hashtable中不含该key
				ArrayList<String> list = new ArrayList<String>();
				list.add(str);
				table.put(originalWord, list);
			}
			else {				//Hashtable中含有该key，则添加一个新字符串到该value中
				ArrayList<String> list = (ArrayList<String>)table.get(originalWord);
				list.add(str);
				table.put(originalWord, list);
			}
		}
		for(Entry<String, List<String>> entry: table.entrySet()) {
			result.add(entry.getValue());
		}
		return result;
	}
}

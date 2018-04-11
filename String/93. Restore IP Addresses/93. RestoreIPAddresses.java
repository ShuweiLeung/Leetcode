/*
Given a string containing only digits, restore it by returning all possible valid IP address combinations.

For example:
Given "25525511135",

return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)

 */


import java.util.ArrayList;
import java.util.List;

public class _93_RestoreIPAddresses {
	public List<String> restoreIpAddresses(String s) {
		List<String> res = new ArrayList<>();
		dfs(s, res, 0, "", 0);
		return res;
	}
	
	public void dfs(String s, List<String> res, int index, String path,int depth) {
		if(index >= s.length())
			return;
		
		if(depth == 3) {
			String lastSegment = s.substring(index);
			if(lastSegment.length() > 3)		//网段的数字最长只能是3位数255
				return;
			if(lastSegment.length() > 1 && lastSegment.charAt(0) == '0')	//当某一网段的首数字是0时，该网段只能为0
				return;
			if(Integer.valueOf(lastSegment) >= 0 && Integer.valueOf(lastSegment) <= 255)	//网段数字大小在0-255之间
				res.add(path+"."+lastSegment);												
			else
				return;
		}
		
		for(int i = 1; i <= 3; i++) {
			if(index + i <= s.length()) {
				String segment = s.substring(index, index + i);
				if(segment.length() > 1 && segment.charAt(0) == '0')	//当某一网段的首数字是0时，该网段只能为0
					return;
				if(Integer.valueOf(segment) >= 0 && Integer.valueOf(segment) <= 255) {	//网段数字大小在0-255之间
					if(depth == 0)
						dfs(s, res, index+i, path+segment, depth+1);
					else
						dfs(s, res, index+i, path+"."+segment, depth+1);
				}
			}
		}
	}
}

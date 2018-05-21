/*
You're given strings J representing the types of stones that are jewels, and S representing the stones you have.
  Each character in S is a type of stone you have.  You want to know how many of the stones you have are also jewels.

The letters in J are guaranteed distinct, and all characters in J and S are letters. Letters are case sensitive, 
so "a" is considered a different type of stone from "A".

Example 1:

Input: J = "aA", S = "aAAbbbb"
Output: 3

Example 2:

Input: J = "z", S = "ZZ"
Output: 0

Note:

    S and J will consist of letters and have length at most 50.
    The characters in J are distinct.

 */

package hashtable.easy;

import java.util.HashMap;
import java.util.Map.Entry;

public class _771_JewelsAndStones {
	public static void main(String[] args) {
		
	}
	
	/*
	 * 下面根据字符串的indexOf来查找S中的字符是否存在于J中，更加高效
	 */
	public int numJewelsInStones(String J, String S) {
		int count = 0;
	    for(int i = 0; i < S.length(); i++) {
	        if(J.indexOf(S.charAt(i)) >= 0) {
	            count++;
	        }
	    }
	    return count;
	}
	
	/*下面使用了HashMap和Entry的数据结构，所以效率较低，只beat 24%
	public int numJewelsInStones(String J, String S) {
		HashMap<Character, Integer> map = new HashMap<>();	//key是宝石，value是该宝石的数量
		for(int i = 0; i < J.length(); i++) {
			map.put(J.charAt(i), 0);
		}
		
		for(int i = 0; i < S.length(); i++) {
			if(map.containsKey(S.charAt(i))) 
				map.put(S.charAt(i), map.getOrDefault(S.charAt(i), 0) + 1);
		}
		
		int sum = 0;
		for(Entry<Character, Integer> entry:map.entrySet()) {
			sum += entry.getValue();
		}
		return sum;
	}
	*/
}

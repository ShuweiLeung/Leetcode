/*
 Given two arrays, write a function to compute their intersection.

Example:
Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].

Note:

    Each element in the result must be unique.
    The result can be in any order.

 */

package hashtable.easy;

import java.util.ArrayList;
import java.util.HashMap;

public class _349_IntersectionOfTwoArrays {
	public int[] intersection(int[] nums1, int[] nums2) {
		HashMap<Integer, Integer> map = new HashMap<>();		//key是nums1中数字，value是其频率
		for(int i = 0; i< nums1.length; i++)
			map.put(nums1[i], map.getOrDefault(nums1[i], 0)+1);
		
		ArrayList<Integer> list = new ArrayList<>();
		for(int i = 0; i < nums2.length; i++) {
			if(map.containsKey(nums2[i])) {
				if(!list.contains(nums2[i]))
					list.add(nums2[i]);
			}
		}
		
		int[] res = new int[list.size()];
		for(int i = 0; i < res.length; i++) {
			res[i] = list.get(i);
		}
		
		return res;
	}
}

/*
You need to find the largest value in each row of a binary tree.

Example:

Input: 

          1
         / \
        3   2
       / \   \  
      5   3   9 

Output: [1, 3, 9]

 */

package tree.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _515_FindLargestValueInEachTreeRow {
	public List<Integer> largestValues(TreeNode root) {
		List<Integer> res = new ArrayList<Integer>();
		Queue<TreeNode> q = new LinkedList<>();
		if(root == null)
			return res;
		q.add(root);
		
		while(!q.isEmpty()) {
			int max = Integer.MIN_VALUE;		//该层最大值
			int n = q.size();	//n是某一层的结点总个数
			for(int i = 0; i < n; i++) {
				TreeNode node = q.poll();
				if(node.val >= max)
					max = node.val;
				if(node.left != null) q.offer(node.left);
	            if(node.right != null) q.offer(node.right);
			}
			res.add(max);
		}
		return res;
	}
}

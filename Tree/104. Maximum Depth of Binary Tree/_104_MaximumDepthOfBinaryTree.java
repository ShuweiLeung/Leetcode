/*
Given a binary tree, find its maximum depth.

The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

Note: A leaf is a node with no children.

Example:

Given binary tree [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7

return its depth = 3.
 */

package tree.easy;

import java.util.LinkedList;
import java.util.Queue;

public class _104_MaximumDepthOfBinaryTree {
	public static void main(String[] args) {
		
	}
	
	/**
	 * 使用DFS，效率会更高，beat 100%
	 * @param root
	 * @return
	 */
	public int maxDepth(TreeNode root) {
        if (root == null) return 0;
       return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
	
	/**
	 * 使用BFS，效率相对较低，beat 7%
	 * @param root
	 * @return
	
	public int maxDepth(TreeNode root) {
		if(root == null)
			return 0;
		
		int maxDepth = 0;
		Queue<TreeNode> q = new LinkedList<>();
		
		q.add(root);
	    while(!q.isEmpty()) {
	    		maxDepth++;
	        int n = q.size();		//n是某一层的结点总个数
	        for(int i = 0; i < n; i++) {		//注意这里i<n，所以刚好控制读取的只有当前层的结点，而没有当前层的子结点
	            TreeNode node = q.poll();
	            if(node.left != null) q.offer(node.left);
	            if(node.right != null) q.offer(node.right);
	        }
	    }
	    
	    return maxDepth;
	}
	*/
}

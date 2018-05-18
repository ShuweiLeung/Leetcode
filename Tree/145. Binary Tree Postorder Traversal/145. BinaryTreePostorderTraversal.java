/*
Given a binary tree, return the postorder traversal of its nodes' values.

Example:

Input: [1,null,2,3]
   1
    \
     2
    /
   3

Output: [3,2,1]

Follow up: Recursive solution is trivial, could you do it iteratively?

 */

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Definition for a binary tree node.
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class _145_BinaryTreePostorderTraversal {
	public List<Integer> postorderTraversal(TreeNode root) {
		LinkedList<Integer> result = new LinkedList<>();
	    Deque<TreeNode> stack = new ArrayDeque<>();		//双端队列
	    TreeNode p = root;
	    while(!stack.isEmpty() || p != null) {
	        if(p != null) {
	            stack.push(p);
	            result.addFirst(p.val);  // Reverse the process of preorder	//因为每次都插入队头，所以根节点->右子树、根节点->左子树、右子树、根节点
	            p = p.right;             // Reverse the process of preorder
	        } else {
	            TreeNode node = stack.pop();
	            p = node.left;           // Reverse the process of preorder
	        }
	    }
	    return result;
	}
	
	/*
	 * dfs递归搜索 beat 98%
	List<Integer> res = new ArrayList<>();
	public List<Integer> postorderTraversal(TreeNode root) {
		if(root == null)
			return res;
		
		dfs(root);
		
		return res;
	}
	
	public void dfs(TreeNode root) {
		if(root == null)
			return;
		
		dfs(root.left);
		dfs(root.right);
		res.add(root.val);
	}
	*/
}

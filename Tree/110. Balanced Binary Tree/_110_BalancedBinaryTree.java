/*
Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as:

    a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

Example 1:

Given the following tree [3,9,20,null,null,15,7]:

    3
   / \
  9  20
    /  \
   15   7

Return true.

Example 2:

Given the following tree [1,2,2,3,3,null,null,4,4]:

       1
      / \
     2   2
    / \
   3   3
  / \
 4   4

Return false.
 */

package tree.easy;

public class _110_BalancedBinaryTree {
	boolean balanced = true;
	public boolean isBalanced(TreeNode root) {
		if(root == null)
			return true;
		
		int leftDepth = cmpDepth(root.left);
		int rightDepth = cmpDepth(root.right);
		if(Math.abs(leftDepth - rightDepth) <= 1) {
			if(balanced == false)
				return false;
			else
				return true;
		}
		else
			return false;
	}
	
	public int cmpDepth(TreeNode root) {
		if(root == null)
			return 0;
		
		int leftDepth = cmpDepth(root.left);
		int rightDepth = cmpDepth(root.right);
		if(Math.abs(leftDepth - rightDepth) > 1)
			balanced = false;
		
		return Math.max(leftDepth, rightDepth) + 1;
	}
}

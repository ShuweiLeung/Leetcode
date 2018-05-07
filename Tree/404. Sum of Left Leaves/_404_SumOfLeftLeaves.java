/*
Find the sum of all left leaves in a given binary tree.

Example:

    3
   / \
  9  20
    /  \
   15   7

There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.

 */

package tree.easy;

public class _404_SumOfLeftLeaves {
	public static void main(String[] args) {
		
	}
	
	public int sumOfLeftLeaves(TreeNode root) {
		if(root == null)
			return 0;
		
		return leftSum(root.left, 0) + leftSum(root.right, 1);
	}
	
	public int leftSum(TreeNode node, int dir) {		//dir = 0左子树，dir=1右子树
		if(node == null)
			return 0;
		
		int sum = 0;
		if(dir == 0 && node.left == null && node.right == null)		//必须是叶子节点
			sum += node.val;
		
		return sum + leftSum(node.left, 0) + leftSum(node.right, 1);
		
	}
}

/*
Given a binary tree

struct TreeLinkNode {
  TreeLinkNode *left;
  TreeLinkNode *right;
  TreeLinkNode *next;
}

Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should
 be set to NULL.

Initially, all next pointers are set to NULL.

Note:

    You may only use constant extra space.
    Recursive approach is fine, implicit stack space does not count as extra space for this problem.
    You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two
     children).

Example:

Given the following perfect binary tree,

     1
   /  \
  2    3
 / \  / \
4  5  6  7

After calling your function, the tree should look like:

     1 -> NULL
   /  \
  2 -> 3 -> NULL
 / \  / \
4->5->6->7 -> NULL


 */

package tree.medium;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Definition for binary tree with next pointer.
 */
class TreeLinkNode {
    int val;
    TreeLinkNode left, right, next;
    TreeLinkNode(int x) { val = x; }
}

public class _116_PopulatingNextRightPointersInEachNode {
	public void connect(TreeLinkNode root) {
		if(root == null)
			return;
		
		Queue<TreeLinkNode> q = new LinkedList<>();
		
		q.add(root);
	    while(!q.isEmpty()) {
	    		int n = q.size();		//n是某一层的结点总个数
	    		TreeLinkNode pre = null;
	        for(int i = 0; i < n; i++) {		//注意这里i<n，所以刚好控制读取的只有当前层的结点，而没有当前层的子结点
	        		TreeLinkNode node = q.poll();
	        		if(i > 0)
	        			pre.next = node;
	        		
	        		pre = node;
	            if(node.left != null) q.offer(node.left);
	            if(node.right != null) q.offer(node.right);
	        }
	    }
	}
}

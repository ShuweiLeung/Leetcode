/*
Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the 
nodes of the first two lists.

Example:

Input: 1->2->4, 1->3->4
Output: 1->1->2->3->4->4

 */

package linkedlist.easy;

public class _21_MergeTwoSortedLists {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if(l1 == null)
			return l2;
		else if(l2 == null)
			return l1;
		
		ListNode cur1 = l1, cur2 = l2;
		ListNode pre = null;
		ListNode head = l1.val < l2.val ? l1 : l2;
		while(cur1 != null && cur2 != null) {
			if(cur1.val < cur2.val) {
				if(pre == null)
					pre = cur1;
				else {
					pre.next = cur1;
					pre = pre.next;
				}
				
				cur1 = cur1.next;
			}
			else {
				if(pre == null)
					pre = cur2;
				else {
					pre.next = cur2;
					pre = pre.next;
				}
				
				cur2 = cur2.next;
			}
		}
		
		if(cur1 == null)
			pre.next = cur2;
		else
			pre.next = cur1;
		
		return head;
	}
}

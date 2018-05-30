/*
Given a linked list, determine if it has a cycle in it.

Follow up:
Can you solve it without using extra space? 
 */

package linkedlist.easy;

public class _141_LinkedListCycle {
	public boolean hasCycle(ListNode head) {
	   if(head==null) return false;
       ListNode walker = head;
       ListNode runner = head;
       while(runner.next!=null && runner.next.next!=null) {
           walker = walker.next;
           runner = runner.next.next;
           if(walker==runner) return true;
       }
       return false;
   }
}

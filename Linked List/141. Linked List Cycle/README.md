[Easy]Linked List Cycle
===

## Description
 Given a linked list, determine if it has a cycle in it.

Follow up:
Can you solve it without using extra space? 

## Idea
At first, we should highlight that the cycle mentioned here is possible the one made of one middle node and the last tail node. Thus, set two pointers - fast and slow. The speed of the fast pointer is twice as the slow one. In this case, if there is a cycle in the given list, the fast pointer will catch up the slow one at some time.

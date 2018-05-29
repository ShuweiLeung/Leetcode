[Easy]Delete Node in a Linked List
===

## Description
Write a function to delete a node (except the tail) in a singly linked list, given only access to that node.

Supposed the linked list is `1 -> 2 -> 3 -> 4` and you are given the third node with value `3`, the linked list should become `1 -> 2 -> 4` after calling your function. 

## Idea
This problem is great. The given node is needed to delete. But, we don't know its previous node so that we cannot operate the node's next pointer to resolve this problem.

One great solution is to set the value of this deleted node equal to its next node, i.e., the value of node A is equal to the value of its next node B. And then, the problem is converted to delete node B instead of node A. At the same time, the previous node is obtained by us.

[Medium]Find Largest Value in Each Tree Row
===

## Description
You need to find the largest value in each row of a binary tree.

**Example:**

```
Input: 

          1
         / \
        3   2
       / \   \  
      5   3   9 

Output: [1, 3, 9]
```

## Idea
BFS is a great method to solve this problem. Besides, we should update an variable `maxVal` in every while loop and add this maxVal into the result list in the end of the loop.

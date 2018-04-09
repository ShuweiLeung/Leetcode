[Medium]Letter Combinations of a Phone Number
===

## Description
Given a digit string, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below.

![alt text](https://upload.wikimedia.org/wikipedia/commons/thumb/7/73/Telephone-keypad2.svg/200px-Telephone-keypad2.svg.png "dial")

    Input:Digit string "23"
    Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
    
**Note:**

Although the above answer is in lexicographical order, your answer could be in any order you want. 
## Idea
It is apparent that the length of `digits` is variable so that `Backtracking` is a good way to produce variable-length sequence . Here, the depth of recursive call is equal to the length of `digits`.

Before calling the function recursively, we should set a 2-D array which stores the letters represented by each digital button, like `String[][] map = {{}, {}, {"a","b","c"}, {"d","e","f"}, {"g","h","i"}, {"j","k","l"}, {"m","n","o"}, {"p","q","r","s"}, {"t","u","v"}, {"w","x","y","z"}}`.

## Attention
Digital buttons **7** and **9** both represent 4 distinct letters while **0** and **1** have no links with any letter.

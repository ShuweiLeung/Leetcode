[Medium]Basic Calculator II
===

## Description
Implement a basic calculator to evaluate a simple expression string.

The expression string contains only **non-negative** integers, `+`, `-`, `*`, `/` operators and empty spaces` `. The integer division should truncate toward zero.

You may assume that the given expression is always valid.

Some examples:

    "3+2*2" = 7
    " 3/2 " = 1
    " 3+5 / 2 " = 5

**Note**: **Do not** use the `eval` built-in library function. 

## Idea
This is a very **classical** problem in String tag. As before, `stack` is a great choice to realize the required function. We can set two variables, `num` and `sign` which represent the int value of the current digit string and its front operator respectively. During the first traverse of the input string `s`, multiplication and division should be computed directly and subtraction should be transformed to the opposite number of the subtractor so that all of the numbers in `stack` should be added, i.e. there are only additive operation need to do after traversing the input string.

## Attention
1.`Character.isDigit(c)` can used to check if character 'c' represent a digit.

2.`c-'0'` can derive the real int value of digit character 'c' directly.

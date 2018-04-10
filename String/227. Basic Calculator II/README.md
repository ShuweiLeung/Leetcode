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
Standard Roman numeral notations are `I=1，V=5，X=10，L=50，C=100，D=500，M=1000`. Since no more than three same roman numerals can appear continuously, for int number 4, it can only be expressed by "5-1" (i.e. `IV=4`). Similarly, `IX=9，XL=40，XC=90，CD=400，CM=900`. In order to follow the rule that no more than three same roman numerals can be put continuously, we, at first, use the largest roman numeral to express the input number and update its value (like 3800-3*1000=800). When the updated value is bigger than the largest roman numeral, the second largest numeral can be tried until the updated final value is equal to 0.

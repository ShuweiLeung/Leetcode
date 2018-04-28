[Easy]Ugly Number
===

## Description
Write a program to check whether a given number is an ugly number.

Ugly numbers are positive numbers whose prime factors only include `2, 3, 5`. For example, `6, 8` are ugly while `14` is not ugly since it includes another prime factor `7`.

**Note:**

1. `1` is typically treated as an ugly number.
2. Input is within the 32-bit signed integer range.

## Idea
We can recursively divide the given number by 2,3,5. If the final result is equal to 1, the program returns true.

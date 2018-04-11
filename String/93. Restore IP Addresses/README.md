[Medium]Restore IP Addresses
===

## Description
Given a string containing only digits, restore it by returning all possible valid IP address combinations.

For example:
Given `"25525511135"`,

return `["255.255.11.135", "255.255.111.35"]`. (Order does not matter)

## Idea
Before writing this program, we should understand several points about IP address. **Firstly**, the number in each group is between `0` and `255`. In other words, these numbers have 3 digits at most, which means 4-digit or numbers with more digits are not eligible. **Secondly**, if the first character of a string is `'0'`, the number of this ip group can only be `0`.

Based on above two things, DFS with depth of 4 can solve this problem.

## Attention
Exception mechanism is very time-consuming.

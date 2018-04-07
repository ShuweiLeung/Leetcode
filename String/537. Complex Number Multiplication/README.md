Complex Number Multiplication
===

## Description
 Given two strings representing two complex numbers.

You need to return a string representing their multiplication. Note i2 = -1 according to the definition.

Example 1:

     Input: "1+1i", "1+1i"
     Output: "0+2i"
     Explanation: (1 + i) * (1 + i) = 1 + i2 + 2 * i = 2i, and you need convert it to the form of 0+2i.

Example 2:

     Input: "1+-1i", "1+-1i"
     Output: "0+-2i"
     Explanation: (1 - i) * (1 - i) = 1 + i2 - 2 * i = -2i, and you need convert it to the form of 0+-2i.

Note:

    The input strings will not have extra blank.
    The input strings will be given in the form of a+bi, where the integer a and b will both belong to the range of [-100, 100]. And the output should be also in this form.

## Idea
According to the question, the program should perform simulation of mutiplication of two complex numbers.

As is known, `(m + ni) * (p + qi) = m * p - n * q + (m * q + n * p)i`. Besides, input strings and output strings are all in the form of `a + bi`. Thus, using `split()` function in String class is a natural intuition to obtain `real number field` and `complex number field` respectively.

After that, we can compute multiplication in terms of the above equation and store the result in a StringBuilder container.

## Attention
The parameter of split() is a `regular expression`. Here, I want to use "+" as a separator, but "+" has some special and specific meaning in regular expressions. Therefore, please replace `"+"` with `"\\+"` (adding escape character) here.

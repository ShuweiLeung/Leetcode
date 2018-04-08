/*
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
 */

package string.medium;

public class _537_ComplexNumberMultiplication {
    public String complexNumberMultiply(String a, String b) {
        StringBuilder result = new StringBuilder();
        String[] aArr = a.split("\\+"), bArr = b.split("\\+");
        //(m+ni)*(p+qi) = mp-nq+(mq+np)i
        int m = Integer.valueOf(aArr[0]);
        int n = Integer.valueOf(aArr[1].substring(0, aArr[1].length()-1));
        int p = Integer.valueOf(bArr[0]);
        int q = Integer.valueOf(bArr[1].substring(0, bArr[1].length()-1));
        result.append(m*p-n*q);
        result.append("+");
        result.append(m*q+n*p);
        result.append("i");
        return result.toString();
    }
}

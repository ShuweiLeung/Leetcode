/*
Implement a basic calculator to evaluate a simple expression string.

The expression string contains only non-negative integers, +, -, *, / operators and empty spaces . The integer division should truncate toward zero.

You may assume that the given expression is always valid.

Some examples:

"3+2*2" = 7
" 3/2 " = 1
" 3+5 / 2 " = 5

Note: Do not use the eval built-in library function.

Credits:
Special thanks to @ts for adding this problem and creating all test cases.
 */

import java.util.Arrays;
import java.util.Stack;

public class _227_BasicCalculatorII {
	/*
	 * 下面的思路只需要一次遍历s就可完成大部分的计算任务，将减法运算转化为减数的相反数，从而转化为加法
	 */
	public int calculate(String s) {
	    int len;
	    if(s==null || (len = s.length())==0) return 0;
	    Stack<Integer> stack = new Stack<Integer>();	//存储只需要进行加法的数
	    int num = 0;
	    char sign = '+';		//一开始初始化为'+'号，默认运算公式中第一个数字是正数，当然若第一个数字是负数也不影响，因为我们第一个压入栈的数是0
	    						//相当于这个sign正好是num=0的符号
	    for(int i=0;i<len;i++){
	        if(Character.isDigit(s.charAt(i))){
	            num = num*10+s.charAt(i)-'0';		//这里乘10是因为"56"对于字符串56，第一个扫描到的字符是5，那么当扫描到'6'时，5一定要乘10，当一个数字串扫描结束后，该变量会清零
	        }
	        if((!Character.isDigit(s.charAt(i)) &&' '!=s.charAt(i)) || i==len-1){		//扫描到的是运算符
	            if(sign=='-'){			//注意，sign永远存储的是”已扫描“数字串前的运算符号，而不是下一个扫描的数字串前的运算符
	                stack.push(-num);
	            }
	            if(sign=='+'){
	                stack.push(num);
	            }
	            if(sign=='*'){
	                stack.push(stack.pop()*num);
	            }
	            if(sign=='/'){
	                stack.push(stack.pop()/num);
	            }
	            sign = s.charAt(i);		//更新sign为即将扫描的数字串前的符号
	            num = 0;					//将存储数字串的变量清零，因为马上要扫描新的数字串
	        }
	    }

	    int re = 0;
	    for(int i:stack){			//栈中的数字只需要进行加法运算即可，因为乘除运算在之前遍历时已经完成计算，减法已将减数改为其相反数
	        re += i;
	    }
	    return re;
	}
}

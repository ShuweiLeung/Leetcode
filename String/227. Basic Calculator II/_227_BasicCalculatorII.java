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

package string.medium;

import java.util.Arrays;
import java.util.Stack;

public class _227_BasicCalculatorII {
	public static void main(String[] args) {
		_227_BasicCalculatorII test = new _227_BasicCalculatorII();
		int diff = '8'-'0';
		System.out.println(diff);
		System.out.println(test.calculate(" 3+7 8/ 2 "));
	}
	/*
	 * 下面的思路只需要一次遍历s就可完成大部分的计算任务，将减法运算转化为减数的相反数，从而转化为加法
	 */
	public int calculate(String s) {
	    int len;
	    if(s==null || (len = s.length())==0) return 0;
	    Stack<Integer> stack = new Stack<Integer>();	//存储只需要进行加法的数
	    int num = 0;
	    char sign = '+';		//一开始初始化为'+'号，默认运算公式中第一个数字是正数，当然若第一个数字是负数也不影响，因为我们第一个压入栈的数是0
	    						//相当于这个正好是num=0的符号
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
	
	/*
	 * 下面的思路正确，但超时，还是思路没有整理清楚，想法过于臃肿
	 * 下面的思路是，先将乘除运算在第一次遍历字符串s的时候运算完毕，那么堆栈中只需要进行加减运算，如“3+4*5-7”，先计算4*5=20
	 * 此时数字栈中存储的数字时[3,20,7],操作符栈中存储的是[+,-]，然后每次取数字栈的前两个元素进行计算
	public int calculate(String s) {
        Stack<Integer> numbers = new Stack<>();
        Stack<String> operators = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
        		if(s.charAt(i) == ' ') 
        			continue;
        		else if(s.charAt(i) >= 48 && s.charAt(i) <= 57) {
        			StringBuilder temp = new StringBuilder();
        			temp.append(String.valueOf(s.charAt(i)));
        			while(i + 1 < s.length())
        			{
        				if(s.charAt(i + 1) == ' ') {
        					i++;
        					continue;
        				}
        				else if((int)s.charAt(i+1) >= 48 && (int)s.charAt(i+1) <= 57) 
            				temp.append(String.valueOf(s.charAt(++i)));
        				else
        					break;
        			}
        			numbers.push(Integer.valueOf(temp.toString()));
        			continue;
        		}
        		else if(s.charAt(i) == '+' || s.charAt(i) == '-') {		//i指向的是‘+’或‘-’
        			operators.push(String.valueOf(s.charAt(i)));
        		}
        		else {		//i指向的是‘*’或‘/’
        			char operator = s.charAt(i);
        			i++;
        			while(s.charAt(i) == ' ')
        				i++;
        			StringBuilder temp = new StringBuilder();		//求'*'或'/'后的下一个数字
        			temp.append(String.valueOf(s.charAt(i)));
        			while(i + 1 < s.length())
        			{
        				if(s.charAt(i + 1) == ' ') {
        					i++;
        					continue;
        				}
        				else if((int)s.charAt(i+1) >= 48 && (int)s.charAt(i+1) <= 57) 
            				temp.append(String.valueOf(s.charAt(++i)));
        				else
        					break;
        			}
        			int num2 = Integer.valueOf(temp.toString());
        			int num1 = numbers.pop();
        			if(operator == '*') {
        				numbers.push(num1 * num2);
        			}
        			else {
        				numbers.push(num1 / num2);
        			}
        			continue;
        		}	
        }
        
        //上面只计算乘法除法，现在Operators堆中只剩下加减法
        int sizeOfNums = numbers.size();
        int res = numbers.remove(0);
        for(int i = 1; i < sizeOfNums; i++) {
        		int num2 = numbers.remove(0);
        		String operator = operators.remove(0);
        		if(operator.compareTo("+") == 0) {
    				res += num2;
    			}
    			else {
    				res -= num2;
    			}
        }
        return res;
    }
	*/
}

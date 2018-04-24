/*
Given a positive integer, return its corresponding column title as appear in an Excel sheet.

For example:

    1 -> A
    2 -> B
    3 -> C
    ...
    26 -> Z
    27 -> AA
    28 -> AB 
 */

package math.easy;

public class _168_ExcelSheetColumnTitle {
	public static void main(String[] args) {
		_168_ExcelSheetColumnTitle test = new _168_ExcelSheetColumnTitle();
		System.out.print(test.convertToTitle(703));
	}
	
	/**
	 * 该题类似于10进制数转化为26进制数
	 * @param n
	 * @return
	 */
	public String convertToTitle(int n) {
		String ret = "";
        while(n>0)
        {
            ret = (char)((n-1)%26+'A') + ret;
            n = (n-1)/26;
        }
        return ret;
	}
}

/*
Find the total area covered by two rectilinear rectangles in a 2D plane.

Each rectangle is defined by its bottom left corner and top right corner as shown in the figure.

Assume that the total area is never beyond the maximum possible value of int.
 */

public class _223_RectangleArea {
	/**
	 * 该方法是之前暴力解法的简化，可以更快速的判断是否重叠并找到重叠矩形
	 * @param A
	 * @param B
	 * @param C
	 * @param D
	 * @param E
	 * @param F
	 * @param G
	 * @param H
	 * @return
	 */
	public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
		int areaA = (A-C) * (B-D);
		int areaB = (E-G) * (F-H);
		
		//我们从test case的图片示例中可以发现，重叠部分的矩形四条边的位置可以由如下方法确定
		int left = Math.max(A, E);
		int right = Math.min(C, G);
		int top = Math.min(D, H);
		int bottom = Math.max(B, F);
		
		int overlap = 0;
		if(right > left && top > bottom)		//四条边可以包围形成重叠矩形
			overlap = (right - left) * (top - bottom);
		
		return areaA + areaB - overlap;
	}
	
	/**
	 * 下面是非常粗暴的，根据ABCD矩形和EFGH矩形的相对位置进行分类讨论得出的一种解法，简单来说就是将两矩形面积求和后减去公共区域的面积
	 * @param A
	 * @param B
	 * @param C
	 * @param D
	 * @param E
	 * @param F
	 * @param G
	 * @param H
	 * @return
	 
	public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
		//保证ABCD矩形在EFGH矩形的左侧
		if(A >= E) {
			int[] temp = {A,B,C,D};
			A = E; B = F; C = G; D = H;
			E = temp[0]; F = temp[1]; G = temp[2]; H = temp[3];
		}
		
		//先不考虑两个矩形是否有重叠，先计算两个大矩形的面积
		int area1 = calArea(A,B,C,D);
		int area2 = calArea(E,F,G,H);
		
		//考虑不重叠的情况
		if(C <= E || D <= F || H <= B)	//ABCD在EFGH的左侧，ABCD在EFGH的正下方，ABCD在EFGH的正上方
			return area1+area2;
		
		//考虑面积重叠的情况
		//1. ABCD矩形包含EFGH矩形
		if(A<=E && B<=F && G<=C && H<=D)
			return area1;
		//2. 部分面积相交,根据两矩形y轴相对位置分类（注意ABCD矩形永远在EFGH矩形的左侧）
		if(B <= F) {	//ABCD矩形在下
			if(G < C){	//按判断条件画图即得该情况位置关系
				if(D >= H)
					return area1+area2-calArea(E,F,C,H);
				else
					return area1+area2-calArea(E,F,G,D);
			}
			else {
				if(D >= H)
					return area1+area2-calArea(E,F,C,H);
				else
					return area1+area2-calArea(E,F,C,D);
			}
		}
		else	{		//EFGH矩形在下
			if(G < C) {	//按判断条件画图即得该情况位置关系
				if(H >= D)
					return area1+area2-calArea(E,B,G,D);
				else
					return area1+area2-calArea(E,B,G,H);
			}
			else {
				if(H >= D)
					return area1+area2-calArea(E,B,C,D);
				else
					return area1+area2-calArea(C,B,E,H);
			}
		}
	}
	*/
	/**
	 * 由对角的顶点(x1,y1)、(x2,y2)组成的矩形面积
	 * @param x1
	 * @param y1
	 * @param x2
	 * @param y2
	 * @return
	
	public int calArea(int x1, int y1, int x2, int y2) {
		int a = Math.abs(x1 - x2);
		int b = Math.abs(y1 - y2);
		return a*b;
	}
	*/
}

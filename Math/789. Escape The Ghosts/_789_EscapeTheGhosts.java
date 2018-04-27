/*
You are playing a simplified Pacman game. You start at the point (0, 0), and your destination is (target[0], target[1]).
 There are several ghosts on the map, the i-th ghost starts at (ghosts[i][0], ghosts[i][1]).

Each turn, you and all ghosts simultaneously *may* move in one of 4 cardinal directions: north, east, west, or south,
 going from the previous point to a new point 1 unit of distance away.

You escape if and only if you can reach the target before any ghost reaches you (for any given moves the ghosts may
 take.)  If you reach any square (including the target) at the same time as a ghost, it doesn't count as an escape.

Return True if and only if it is possible to escape.

Example 1:
Input: 
ghosts = [[1, 0], [0, 3]]
target = [0, 1]
Output: true
Explanation: 
You can directly reach the destination (0, 1) at time 1, while the ghosts located at (1, 0) or (0, 3) have no way
 to catch up with you.

Example 2:
Input: 
ghosts = [[1, 0]]
target = [2, 0]
Output: false
Explanation: 
You need to reach the destination (2, 0), but the ghost at (1, 0) lies between you and the destination.

Example 3:
Input: 
ghosts = [[2, 0]]
target = [1, 0]
Output: false
Explanation: 
The ghost can reach the target at the same time as you.

Note:

    All points have coordinates with absolute value <= 10000.
    The number of ghosts will not exceed 100.


 */

package math.medium;

public class _789_EscapeTheGhosts {
	public static void main(String[] args) {
		int[][] ghosts = {{1,8},{-9,0},{-7,-6},{4,3},{1,3}};
		int[] target = {6,-9};
		_789_EscapeTheGhosts test = new _789_EscapeTheGhosts();
		System.out.println(test.escapeGhosts(ghosts, target));
	}
	
    public boolean escapeGhosts(int[][] ghosts, int[] target) {  
        int myDistance=Math.abs(target[0])+Math.abs(target[1]);  
        for(int i=0;i<ghosts.length;i++){  
            int ghostDistance=Math.abs(target[0]-ghosts[i][0])+Math.abs(target[1]-ghosts[i][1]);  //曼哈顿距离
            if(ghostDistance<=myDistance){  
                return false;  
            }  
        }  
            return true;  
    }  
	
	/*
	 * ghost和我们的行走路线并不是直线距离，而是曼哈顿距离（两个点在标准坐标系上的绝对轴距总和）
	public boolean escapeGhosts(int[][] ghosts, int[] target) {
		double minGhostDistance = Double.MAX_VALUE;		//ghosts和target的直线最短距离
		for(int[] ghost:ghosts) {
			//直线距离
			double ghostDistance = Math.sqrt((ghost[0] - target[0])*(ghost[0] - target[0])+(ghost[1] - target[1])*(ghost[1] - target[1]));
			if(ghostDistance < minGhostDistance)
				minGhostDistance = ghostDistance;
		}
		double ODistance = Math.sqrt(target[0]*target[0]+target[1]*target[1]);
		
		return ODistance < minGhostDistance;
	}
	*/
}

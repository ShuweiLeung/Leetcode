/*
There are a total of n courses you have to take, labeled from 0 to n-1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is 
expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

Example 1:

Input: 2, [[1,0]] 
Output: true
Explanation: There are a total of 2 courses to take. 
             To take course 1 you should have finished course 0. So it is possible.

Example 2:

Input: 2, [[1,0],[0,1]]
Output: false
Explanation: There are a total of 2 courses to take. 
             To take course 1 you should have finished course 0, and to take course 0 you should
             also have finished course 1. So it is impossible.

Note:

    The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how
     a graph is represented.
    You may assume that there are no duplicate edges in the input prerequisites.
 */

package depthFirstSearch.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class _207_CourseSchedule {
	/*
	 * 正确的思路是使用"拓扑排序topological sort"，拓扑排序可以解决有向图中编号的顺序问题
	 */
	public boolean canFinish(int numCourses, int[][] prerequisites) {        
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>(); //索引是高级课程，对应的value arraylist是先修课程
        
        for (int i = 0; i < numCourses; ++i)
            graph.add(new ArrayList<Integer>());
        
        for (int i = 0; i < prerequisites.length; ++i) {
            int course = prerequisites[i][0];
            int prerequisite = prerequisites[i][1];            
            graph.get(course).add(prerequisite);
        }
        
        int[] visited = new int[numCourses]; 	//states: 0 = unkonwn, 1 == visiting(表示正在处理), 2 = visited(表示肯定可以修读的课程)
        for (int i = 0; i < numCourses; ++i)
            if (dfs(i, graph, visited)) return false; //dfs函数返回true代表有环，false代表无环
        
        return true;
    }
    
    private boolean dfs(int curr, ArrayList<ArrayList<Integer>> graph, int[] visited) {
        if (visited[curr] == 1) return true;  //visited数组的1状态表示当前有向图中的高级课程，他们需要将低级课程全部修完才能修
        if (visited[curr] == 2) return false; //肯定能修的课程
        
        visited[curr] = 1;  //将当前课程标记为visiting
                
        for (int next : graph.get(curr)) //如果有先修课程，则继续深度搜索其先修课程
            if (dfs(next, graph, visited)) return true;
        
        visited[curr] = 2;  //如果当前课程的所有先修课程都已经修完了，则将当前课程标记为visited
        return false;
    }
	
	
	/*
	 * 超时
	   本意是想使用BFS，将该树上的所有结点都遍历后，若没有环则说明所有课程都可以上，
	   但不能判断[(0,1),(0,2),(1,2)]的情况，否则若用map集合来记录某个课程的搜索路径来判断是否有环，思路很复杂且超时
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		if(prerequisites == null || prerequisites.length == 0)
			return true;
		
		int[][] preCourses = new int[numCourses][numCourses];
		for(int[] prerequisite : prerequisites)
			preCourses[prerequisite[0]][prerequisite[1]] = 1;
		
		Set<Integer> finishedCourses = new HashSet<>(); //可以上完的课程
		
		for(int i = 0; i < numCourses; i++) {
			if(finishedCourses.contains(i))
				continue;
			
			Queue<Integer> queue = new LinkedList<>();
			Set<Integer> dealingCourses = new HashSet<>(); 
			
			queue.add(i); 	//用于BFS搜索
			dealingCourses.add(i);  //当前已经处理过的课程编号（该课程树上有先修课关系的所有课程）
			Map<Integer, ArrayList<Integer>> parents = new HashMap<>();  //key=i时，对应的value代表上完第i门课才可以上的其他高级课程
			while(!queue.isEmpty()) {
				int cur = queue.poll();
				for(int j = 0; j < numCourses; j++) {
					if(preCourses[cur][j] == 1) {
						if(parents.containsKey(cur) && parents.get(cur).contains(j)) 	//证明有环
							return false;
						if(finishedCourses.contains(j))
							continue;
						
						ArrayList<Integer> list = parents.getOrDefault(j, new ArrayList<Integer>());
						list.add(cur);
						parents.put(j, list);
						queue.add(j);
						dealingCourses.add(j);
					}
				}
			}
			
			//说明上面的树无环
			finishedCourses.addAll(dealingCourses);
		}
		
		return finishedCourses.size() == numCourses;
	}
	 */
}

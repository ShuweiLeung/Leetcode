/*
Given a list of directory info including directory path, and all the files with contents in this directory, you need 
to find out all the groups of duplicate files in the file system in terms of their paths.

A group of duplicate files consists of at least two files that have exactly the same content.

A single directory info string in the input list has the following format:

"root/d1/d2/.../dm f1.txt(f1_content) f2.txt(f2_content) ... fn.txt(fn_content)"

It means there are n files (f1.txt, f2.txt ... fn.txt with content f1_content, f2_content ... fn_content, respectively) 
in directory root/d1/d2/.../dm. Note that n >= 1 and m >= 0. If m = 0, it means the directory is just the root directory.

The output is a list of group of duplicate file paths. For each group, it contains all the file paths of the files 
that have the same content. A file path is a string that has the following format:

"directory_path/file_name.txt"

Example 1:

Input:
["root/a 1.txt(abcd) 2.txt(efgh)", "root/c 3.txt(abcd)", "root/c/d 4.txt(efgh)", "root 4.txt(efgh)"]
Output:  
[["root/a/2.txt","root/c/d/4.txt","root/4.txt"],["root/a/1.txt","root/c/3.txt"]]

Note:

    1.No order is required for the final output.
    2.You may assume the directory name, file name and file content only has letters and digits, and the length of 
      file content is in the range of [1,50].
    3.The number of files given is in the range of [1,20000].
    4.You may assume no files or directories share the same name in the same directory.
    5.You may assume each given directory info represents a unique directory. Directory path and file info are 
      separated by a single blank space.

Follow-up beyond contest:

    1.Imagine you are given a real file system, how will you search files? DFS or BFS?
    2.If the file content is very large (GB level), how will you modify your solution?
    3.If you can only read the file by 1kb each time, how will you modify your solution?
    4.What is the time complexity of your modified solution? What is the most time-consuming part and memory consuming 
      part of it? How to optimize?
    5.How to make sure the duplicated files you find are not false positive?

 */

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map.Entry;

public class _609_FindDuplicateFileInSystem {
	public List<List<String>> findDuplicate(String[] paths) {
		Hashtable<String, List<String>> table = new Hashtable<String, List<String>>();
		for(int i = 0; i < paths.length; i++) {
			String[] infos = paths[i].split(" ");	//将 路径 和 路径目录中所含文件 分开
			for(int j = 1; j < infos.length; j++) {	//j=0存储的是当前目录的路径
				int contentp1 = infos[j].indexOf('(') + 1;	//当前文件内容的起始下标
				int contentp2 = infos[j].length() - 1;		//右括号')'位置，即当前文件内容的结束下标+1
				if(table.containsKey(infos[j].substring(contentp1, contentp2))) { //之前已经有相同内容的文件，则把该文件路径添加到之前的列表里即可
					List<String> list = (List<String>) table.get((String)infos[j].substring(contentp1, contentp2));
					list.add(infos[0]+"/"+infos[j].substring(0, contentp1-1));
					table.put(infos[j].substring(contentp1, contentp2), list);
				}
				else {	//说明之前没有相同内容的文件
					List<String> list = new ArrayList<String>();
					list.add(infos[0]+"/"+infos[j].substring(0, contentp1-1));
					table.put(infos[j].substring(contentp1, contentp2), list);
				}	
			}
		}
		//遍历Hashtable，并将相同内容的文件路径存入结果集中
		List<List<String>> res = new ArrayList<List<String>>();	//result set结果集
		for(Entry<String, List<String>> entry:table.entrySet()) {
			if(entry.getValue().size() > 1)					//只返回duplicate files with same content
				res.add((List<String>)entry.getValue());
		}
		return res;
	}
}

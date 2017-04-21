package tools;

import java.io.File;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class RefactorReadme {

	private final static String readme;
	private static int count;
	private static int lines;
	static {
		readme = System.getProperty("user.dir") + "\\README.md";
	}

	public static void main(String[] args) {
		// 获取当前工程路径
		String root = System.getProperty("user.dir") + "\\";
		String file = "src";
		countFiles(root, file);
		FileOperation.resetTxtFile(readme);
		FileOperation.writeTxtFile("# DailyCode", readme);
		FileOperation.writeTxtFile("", readme);
		FileOperation.writeTxtFile("### 该项目保存平时随手写下的代码以及一些想法", readme);
		FileOperation.writeTxtFile("### 主要包含：常用经典算法的实现、LeetCode题解、LintCode题解、Java设计模式", readme);
		FileOperation.writeTxtFile("### 项目开始积累代码的时间：2017年4月", readme);
		FileOperation.writeTxtFile("", readme);
		FileOperation.writeTxtFile("### 文件数:" + count + "　　　　" + "代码行数:" + lines, readme);
		FileOperation.writeTxtFile("### 代码目录结构:", readme);
		FileOperation.writeTxtFile("", readme);
		printFiles("    ", root, file);

	}

	public static void countFiles(String pre, String filesName) {
		File files = new File(pre + filesName);
		if (!files.isDirectory()) {
			count++;
			ArrayList<String> list = FileOperation.readTxtFile(pre + filesName, null);
			for (String s : list) {
				// 用StringTokenizer处理连续空格或者Tab键
				StringTokenizer st = new StringTokenizer(s);
				if (st.hasMoreTokens()) {
					lines++;
				}
			}
		} else {
			File file[] = files.listFiles();
			for (File f : file) {
				countFiles(pre + filesName + "\\", f.getName());
			}
		}
	}

	public static void printFiles(String tab, String pre, String filesName) {
		File files = new File(pre + filesName);
		if (files.isDirectory()) {
			File file[] = files.listFiles();
			for (File f : file) {
				System.out.println(tab + f.getName());
				FileOperation.writeTxtFile(tab + f.getName(), readme);
				printFiles(tab + "    ", pre + filesName + "\\", f.getName());
			}
		}
	}

}

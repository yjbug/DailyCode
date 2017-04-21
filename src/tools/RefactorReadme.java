package tools;

import java.io.File;
import java.util.ArrayList;

public class RefactorReadme {

	private static String readme = "/E:/YJGit/LintCode/README.md";
	private static int count;
	private static int lines;

	public static void main(String[] args) {

		String root = "E:\\YJGit\\LintCode\\";
		String start = "src";
		countFiles(root, start);
		System.out.println(readme);
		String tmp = readme;
		FileOperation.resetTxtFile(tmp);
		FileOperation.writeTxtFile("# DailyCode", tmp);
		FileOperation.writeTxtFile("", tmp);
		FileOperation.writeTxtFile("### 该项目保存平时随手写下的代码以及一些想法", tmp);
		FileOperation.writeTxtFile("### 主要包含：常用经典算法的实现、LeetCode题解、LintCode题解、Java设计模式", tmp);
		FileOperation.writeTxtFile("### 项目开始积累代码的时间：2017年4月", tmp);
		FileOperation.writeTxtFile("", tmp);
		FileOperation.writeTxtFile("### 文件数:" + count + "　　　　" + "代码行数:" + lines, tmp);
		FileOperation.writeTxtFile("### 代码目录结构:", tmp);
		FileOperation.writeTxtFile("", tmp);

		printFiles("    ", root, start);

	}

	public static void countFiles(String pre, String filesName) {
		File files = new File(pre + filesName);
		if (!files.isDirectory()) {
			count++;
			ArrayList<String> list = FileOperation.readTxtFile(pre + filesName, null);
			for (String s : list) {
				if (!s.equals("")) {
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

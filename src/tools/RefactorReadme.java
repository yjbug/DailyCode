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
		FileOperation.writeTxtFile("### ����Ŀ����ƽʱ����д�µĴ����Լ�һЩ�뷨", tmp);
		FileOperation.writeTxtFile("### ��Ҫ���������þ����㷨��ʵ�֡�LeetCode��⡢LintCode��⡢Java���ģʽ", tmp);
		FileOperation.writeTxtFile("### ��Ŀ��ʼ���۴����ʱ�䣺2017��4��", tmp);
		FileOperation.writeTxtFile("", tmp);
		FileOperation.writeTxtFile("### �ļ���:" + count + "��������" + "��������:" + lines, tmp);
		FileOperation.writeTxtFile("### ����Ŀ¼�ṹ:", tmp);
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

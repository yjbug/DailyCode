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
		// ��ȡ��ǰ����·��
		String root = System.getProperty("user.dir") + "\\";
		String file = "src";
		countFiles(root, file);
		FileOperation.resetTxtFile(readme);
		FileOperation.writeTxtFile("# DailyCode", readme);
		FileOperation.writeTxtFile("", readme);
		FileOperation.writeTxtFile("### ����Ŀ����ƽʱ����д�µĴ����Լ�һЩ�뷨", readme);
		FileOperation.writeTxtFile("### ��Ҫ���������þ����㷨��ʵ�֡�LeetCode��⡢LintCode��⡢Java���ģʽ", readme);
		FileOperation.writeTxtFile("### ��Ŀ��ʼ���۴����ʱ�䣺2017��4��", readme);
		FileOperation.writeTxtFile("", readme);
		FileOperation.writeTxtFile("### �ļ���:" + count + "��������" + "��������:" + lines, readme);
		FileOperation.writeTxtFile("### ����Ŀ¼�ṹ:", readme);
		FileOperation.writeTxtFile("", readme);
		printFiles("    ", root, file);

	}

	public static void countFiles(String pre, String filesName) {
		File files = new File(pre + filesName);
		if (!files.isDirectory()) {
			count++;
			ArrayList<String> list = FileOperation.readTxtFile(pre + filesName, null);
			for (String s : list) {
				// ��StringTokenizer���������ո����Tab��
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

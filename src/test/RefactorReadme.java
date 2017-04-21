package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.print.attribute.standard.PrinterMessageFromOperator;
import javax.tools.FileObject;

import com.sun.org.apache.bcel.internal.generic.FNEG;

import tools.FileOperation;

public class RefactorReadme {
	
	private static String readme="/E:/YJGit/LintCode/README.md";

	public static void main(String[] args) {

		String fileName = RefactorReadme.class.getResource("/").getFile();
		fileName = fileName.substring(0, fileName.length() - 4);
		System.out.println(readme);
		String tmp = readme;
		FileOperation.resetTxtFile(tmp);
		FileOperation.writeTxtFile("# DailyCode", tmp);
		FileOperation.writeTxtFile("", tmp);
		FileOperation.writeTxtFile("### ����Ŀ����ƽʱ����д�µĴ����Լ�һЩ�뷨", tmp);
		FileOperation.writeTxtFile("### ��Ҫ���������þ����㷨��ʵ�֡�LeetCode��⡢LintCode��⡢Java���ģʽ", tmp);
		FileOperation.writeTxtFile("### ��Ŀ��ʼ���۴����ʱ�䣺2017��4��", tmp);
		FileOperation.writeTxtFile("", tmp);
		FileOperation.writeTxtFile("����Ŀ¼�ṹ:", tmp);
		FileOperation.writeTxtFile("", tmp);

		String filesName = "E:\\YJGit\\LintCode\\src";
		printFiles("    ", "E:\\YJGit\\LintCode\\", "src");

	}

	public static void printFiles(String tab, String pre, String filesName) {
		File files = new File(pre + filesName);
		ArrayList<String> filelist = new ArrayList<String>();
		if (files.isDirectory()) {
			File file[] = files.listFiles();
			for (File f : file) {
				filelist.add(f.getName());
				System.out.println(tab + f.getName());
				FileOperation.writeTxtFile(tab + f.getName(), readme);
				printFiles(tab + "    ", pre + filesName + "\\", f.getName());
			}
		}
	}

}

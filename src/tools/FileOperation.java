package tools;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.util.ArrayList;

public class FileOperation {
	public static String ENCODING;
	static {
		ENCODING = "GBK";
		changeEncoding();
	}

	// -----------�����ļ�----------
	public static boolean createFile(String file_Name) {
		File fileName = new File(file_Name);
		try {
			if (!fileName.exists()) {
				fileName.createNewFile();
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	// -----------��ȡ�ļ�----------
	// file_Name: absolute path , FileName can be null
	public static ArrayList<String> readTxtFile(String file_Name, String FileName) {
		File fileName = new File(file_Name);
		ArrayList<String> strArray = new ArrayList<String>();
		FileReader fileReader = null;
		BufferedReader bufferedReader = null;
		InputStreamReader reader = null;
		try {
			reader = new InputStreamReader(new FileInputStream(fileName), ENCODING);
			bufferedReader = new BufferedReader(reader);
			String read = null;
			while ((read = bufferedReader.readLine()) != null) {
				strArray.add(read); // collect all lines to strArray
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (bufferedReader != null) {
					bufferedReader.close();
				}
				if (fileReader != null) {
					fileReader.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return strArray;
	}

	// -----------��ȡ�ļ���,�����ļ����б�----------
	public static ArrayList<String> readFiles(String filesName) {
		File files = new File(filesName);
		ArrayList<String> filelist = new ArrayList<String>();
		File file[] = files.listFiles();
		for (File f : file) {
			filelist.add(f.getName());
		}
		return filelist;
	}

	// -----------�ַ���д��TXT----------
	public static boolean writeTxtFileAfter(String content, String fileName) {
		createFile(fileName);
		RandomAccessFile mm = null;
		boolean flag = false;
		FileOutputStream o = null;
		try {
			o = new FileOutputStream(new File(fileName), true);
			o.write(content.getBytes(ENCODING));
			o.close();
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (mm != null)
					mm.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return flag;
	}

	public static boolean writeTxtFile(String content, String fileName) {
		createFile(fileName);
		content += "\n";
		RandomAccessFile mm = null;
		boolean flag = false;
		FileOutputStream o = null;
		try {
			o = new FileOutputStream(new File(fileName), true);
			o.write(content.getBytes(ENCODING));
			o.close();
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (mm != null)
					mm.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return flag;
	}

	public static boolean resetTxtFile(String fileName) {
		createFile(fileName);
		RandomAccessFile mm = null;
		boolean flag = false;
		FileOutputStream o = null;
		try {
			o = new FileOutputStream(new File(fileName), false);
			String content = "";
			o.write(content.getBytes(ENCODING));
			o.close();
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (mm != null)
					mm.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return flag;
	}

	// -----------�ļ�������----------
	public static void renameFile(String path, String oldname, String newname) {
		if (!oldname.equals(newname)) {// �µ��ļ�������ǰ�ļ�����ͬʱ,���б�Ҫ����������
			File oldfile = new File(path + "/" + oldname);
			File newfile = new File(path + "/" + newname);
			if (!oldfile.exists()) {
				return;// �������ļ�������
			}
			if (newfile.exists())// ���ڸ�Ŀ¼���Ѿ���һ���ļ������ļ�����ͬ��������������
				System.out.println(newname + "�Ѿ����ڣ�");
			else {
				oldfile.renameTo(newfile);
			}
		} else {
			System.out.println("���ļ����;��ļ�����ͬ");
		}
	}

	// ----------�л������ʽ----------
	public static void changeEncoding() {
		if (ENCODING == "GBK") {
			System.out.println("Encoding is UTF-8");
			ENCODING = "UTF-8";
		} else {
			System.out.println("Encoding is GBK");
			ENCODING = "GBK";
		}
	}
}
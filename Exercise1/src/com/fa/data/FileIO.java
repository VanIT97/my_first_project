package com.fa.data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @author du du
 * class provide many functions to read and write a object from file
 */
public class FileIO {
	public static final String FILE_COMPUTER = "C:\\computer.txt";
	public static final String FILE_MANAGER = "C:\\manager.txt";
	
	/**
	 * @param fileName: name directory of file
	 * @return true if file existed and have data else return false
	 */
	public static boolean checkData(String fileName) {
		File file = new File(fileName);
		return file.length() > 0 && file.exists() ? true : false;
	}

	/**
	 * @param fileName
	 * @return object which read from file
	 */
	public static Object readFile(String fileName) {
		Object object = null;
		FileInputStream fin = null;
		ObjectInputStream ois = null;
		try {
			fin = new FileInputStream(fileName);
			ois = new ObjectInputStream(fin);
			object = ois.readObject();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (fin != null) {
				try {
					fin.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (ois != null) {
				try {
					ois.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}

		return object;
	}

	/**
	 * @param object:
	 * save a object into file
	 */
	public static void saveFile(Object object,String fileName) {
		FileOutputStream fout = null;
		ObjectOutputStream oos = null;
		try {
			fout = new FileOutputStream(fileName);
			oos = new ObjectOutputStream(fout);
			oos.writeObject(object);
			System.out.println("Done");
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (fout != null) {
				try {
					fout.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (oos != null) {
				try {
					oos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
}

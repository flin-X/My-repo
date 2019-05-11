package com.xwm.demo;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileTest {
	public static void main(String[] args) throws IOException {
		FileManager fm1 = new FileManager("./src/main/resources/a.txt", new char[] { ' ' });
		FileManager fm2 = new FileManager("./src/main/resources/b.txt", new char[] { '\n', ' ' });
		FileWriter fw = new FileWriter("./src/main/resources/c.txt", false);
		String aWord = null;
		String bWord = null;
		while ((aWord = fm1.nextWord()) != null) {
			fw.write(aWord + "\n");
			if ((bWord = fm2.nextWord()) != null) {
				fw.write(bWord + '\n');
			}
		}
		while ((bWord = fm2.nextWord()) != null) {
			fw.write(bWord + ' ');
		}
		fw.close();
	}
}

class FileManager {
	String[] words = null;
	int pos = 0;

	public FileManager(String str, char[] arr) {
		File f = new File(str);
		try {
			FileReader fr = new FileReader(f);
			char[] buf = new char[3];
			String result = "";
			for (int len = 0; (len = fr.read(buf)) != -1;) {
				String temp = new String(buf, 0, len);
				result += temp;
				System.out.print(temp);
			}
//			char[] buf = new char[(int) f.length()];
//			int len = fr.read(buf);
//			String result = new String(buf, 0, len);
			String regex = null;
			if (arr.length > 1) {
				regex = arr[0] + "|" + arr[1];
			} else
				regex = arr[0] + "";
			words = result.split(regex);
			fr.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String nextWord() {
		if (pos == words.length) {
			return null;
		} else {
			return words[pos++];
		}
	}
}
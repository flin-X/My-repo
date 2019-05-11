package com.xwm.demo1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestObject {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		testWrite();
		testRead();
	}

	public static void testWrite() throws IOException {
		OutputStream out = new FileOutputStream("./src/main/resources/a.txt", true);
		ObjectOutputStream oout = new ObjectOutputStream(out);
		Map<String, String> map = new HashMap<>();
		map.put("3", "r");
		map.put("4", "t");
		oout.writeObject(map);
		List<String> list = new ArrayList<>();
		list.add("q");
		list.add("w");
		oout.writeObject(list);
		oout.close();
		out.close();
	}

	public static void testRead() throws ClassNotFoundException {
		try {
			InputStream in = new FileInputStream(new File("./src/main/resources/a.txt"));
			ObjectInputStream oin = new ObjectInputStream(in);
			Object readObject = oin.readObject();
			@SuppressWarnings("unchecked")
			Map<String, String> map = (HashMap<String, String>) readObject;
			System.out.println(map.size());
			System.out.println(map.get("1"));
			@SuppressWarnings("unchecked")
			Map<String, String> map1 = (HashMap<String, String>) readObject;
			System.out.println(map1.size());
			System.out.println(map1.get("1"));

			@SuppressWarnings("unchecked")
			List<String> list = (List<String>) oin.readObject();
			for (String string : list) {
				System.out.println(string);
			}
			oin.close();
			in.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}

package com.xwm.demo;

import java.io.File;

public class FileWay {
	public static void main(String[] args) {
		File directory = new File("");// 设定为当前文件夹
		try {
			System.out.println(directory.getCanonicalPath());// 获取标准的路径
			System.out.println(directory.getAbsolutePath());// 获取绝对路径
		} catch (Exception e) {
		}
		System.out.println("\\/\\\\\\\\\\");
	}
}

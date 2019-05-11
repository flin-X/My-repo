package com.xwm.demo;

public class StringTest {
	public static void main(String[] args) {
		String str = "a|bcacewa|ceabdeadeadgeag";
		String[] split = str.split("a\\|c");
		for (String string : split) {
			System.out.println(string);
		}
	}
}

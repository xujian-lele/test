package com.anphenix.smartnurse.chat;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class test {
	public static String questionPath = "./knowledge-base/ql.lst";
	String questionPath = getClass().getResource("/").toString();
	public static void loadQuestion(Map<Integer, ArrayList<String>> qid_Qlis)
			throws IOException {
		String inputPath = questionPath;
		File file = new File(inputPath);
		if (!file.exists())
			file.createNewFile();
		FileInputStream fis = new FileInputStream(file);
		BufferedReader bf = new BufferedReader(new InputStreamReader(fis));
		String data;
		data = bf.readLine();
		String[] st;
		ArrayList<String> alist = new ArrayList<String>();

		while (data != null) {
			// System.out.println(data);
			// 1 糖尿病|6 糖尿病有几种类型？ 糖尿病|几种
			st = data.split("	");
			String s = st[1];
			String[] ss = s.split("\\|");
			for (int i = 0; i < ss.length; i++) {
				alist.add(ss[i]);
			}
			if (alist.size() >= 1) {
				qid_Qlis.put(Integer.valueOf(st[0]), new ArrayList<String>(
						alist));
				alist.clear();
			}
			data = bf.readLine();
		}
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		HashMap<Integer, ArrayList<String>> qid_Qlis = new HashMap<Integer, ArrayList<String>>();
		loadQuestion(qid_Qlis);
		System.out.println(qid_Qlis.toString());
	}

}

package aa;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class preprocess {
	public static String inputpath = "./src/aa/萌问题1.txt";
	public static void loadfile(Map<Integer,ArrayList<String>> qid_Qlis) throws Exception
	{
		String inputPath = inputpath;
		File file = new File(inputPath);
		if(!file.exists())
			file.createNewFile();
		FileInputStream fis = new FileInputStream(file);
		BufferedReader bf = new BufferedReader(new InputStreamReader(fis,"utf-8"));
		String data;
		data=bf.readLine();
		String[] st;
		ArrayList<String> alist = new ArrayList<String>();

		while(data != null)
		{
			System.out.println(data);
//			1	糖尿病|6	糖尿病有几种类型？	糖尿病|几种
			st=data.split("#");
			String s = st[0];
			ChineseTokenizer.getInstance().tokenizeAndLowerCase(st[0], alist);
			System.out.println(alist.toString());
			alist.clear();
			data=bf.readLine();
		}		
	}
	
	public static void main(String[] args) throws Exception
	{
		Map<Integer, ArrayList<String>> a= new HashMap<Integer, ArrayList<String>>();
		loadfile(a);
	}
}

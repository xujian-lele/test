package aa;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Map;

public class filerewrite {

	public static String input="./src/aa/同义词1.txt"; 
	public static String output="./src/aa/同义词2.txt"; 

	public static void loadQuestion(Map<Integer,ArrayList<String>> qid_Qlis) throws IOException
	{
		String inputPath = input;
		File file = new File(inputPath);
		if(!file.exists())
			file.createNewFile();
		FileInputStream fis = new FileInputStream(file);
		BufferedReader bf = new BufferedReader(new InputStreamReader(fis,"utf-8"));
		
		String outputPath=output;
		File file1=new File(outputPath);
		if(!file.exists())
			file.createNewFile();
		FileOutputStream fot = new FileOutputStream(file1);
		BufferedWriter bfw=new BufferedWriter(new OutputStreamWriter(fot,"utf-8"));
		
		String data;
		data=bf.readLine();
		String[] st;
		ArrayList<String> alist = new ArrayList<String>();
		int length=1;
		while(data != null)
		{
			System.out.println(data);
//			1	糖尿病|6	糖尿病有几种类型？	糖尿病|几种
			st=data.split("=");
//			String s = st[1];
//			String[] ss=s.split("\\|");
//			for(int i=0;i<ss.length;i++)
//			{
// 				alist.add(ss[i]);
//			}
//			if(alist.size()>=1){
//				System.out.println(st[0].length());
//				String sm = new String();
//
//				for(int ii=1;ii<st[0].length();ii++)
//				{
//					sm=sm+st[0].charAt(ii);
//				}
//				int mm = Integer.valueOf(sm); 
//				System.out.println(mm);
				
// 				qid_Qlis.put(Integer.valueOf(st[0]),new ArrayList<String>(alist));
			bfw.write(String.valueOf(length)+"|"+st[1]+"\n");
			bfw.flush();
// 				alist.clear();
			length++;
			data=bf.readLine();
		}		
	}
	public static void main(String[] args) throws IOException {
		Map<Integer, ArrayList<String>> qid_Qlis = null;
		// TODO Auto-generated method stub
		loadQuestion(qid_Qlis);
	}

}

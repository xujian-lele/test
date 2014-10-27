package aa;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Loader {
	/**
	 * 从文件中加载Question
	 */
	public String questionPath = "./src/aa/ql.lst";
	public String answerPath = "./src/aa/an.lst";
	public String synonymousWordsPath = "./src/aa/synonymousWords.lst";



	
	public String getQuestionPath() {
		return questionPath;
	}

	public void setQuestionPath(String questionPath) {
		this.questionPath = questionPath;
	}

	public void loadQuestion(Map<Integer,ArrayList<String>> qid_Qlis) throws IOException
	{
		String inputPath = questionPath;
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
//			System.out.println(data);
//			1	糖尿病|6	糖尿病有几种类型？	糖尿病|几种
			st=data.split("	");
			String s = st[1];
			String[] ss=s.split("\\|");
			for(int i=0;i<ss.length;i++)
			{
 				alist.add(ss[i]);
			}
			if(alist.size()>=1){
//				System.out.println(st[0].length());
//				String sm = new String();
//
//				for(int ii=1;ii<st[0].length();ii++)
//				{
//					sm=sm+st[0].charAt(ii);
//				}
//				int mm = Integer.valueOf(sm); 
//				System.out.println(mm);
				
 				qid_Qlis.put(Integer.valueOf(st[0]),new ArrayList<String>(alist));
 				alist.clear();
			}
			data=bf.readLine();
		}		
	}
	public void loadAnswerSet(Map<Integer,String> answer) throws IOException
	{
		String inputPath = answerPath;
		File file = new File(inputPath);
		if(!file.exists())
			file.createNewFile();
		FileInputStream fis = new FileInputStream(file);
		BufferedReader bf = new BufferedReader(new InputStreamReader(fis));
		String data;
		data=bf.readLine();
		String[] st;
		while(data != null)
		{
//			System.out.println(data);
//			1	糖尿病|6	糖尿病有几种类型？	糖尿病|几种
			st=data.split("\\|");
			String s = st[1];
			answer.put(Integer.valueOf(st[0]), st[1]);
			data=bf.readLine();
		}		
	}
	public void loadSynonymousWords(Map<Integer,ArrayList<String>> sw) throws IOException
	{
		String inputPath = synonymousWordsPath;
		File file = new File(inputPath);
		if(!file.exists())
			file.createNewFile();
		FileInputStream fis = new FileInputStream(file);
		BufferedReader bf = new BufferedReader(new InputStreamReader(fis));
		String data;
		data=bf.readLine();
		String[] st;
		ArrayList<String> alist = new ArrayList<String>();
		while(data != null)
		{
//			System.out.println(data);
//			7|几片/几颗/几粒
			st=data.split("\\|");
			String s = st[1];
			String[] ss=s.split("\\/");
			for(int i=0;i<ss.length;i++)
			{
 				alist.add(ss[i]);
			}
			if(alist.size()>=1){
 				sw.put(Integer.valueOf(st[0]),new ArrayList<String>(alist));
 				alist.clear();
			}
			data=bf.readLine();
		}	
	}
}

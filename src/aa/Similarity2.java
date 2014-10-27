package aa;

import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;
public class Similarity2 {
	public static double getSimilarity(String str1,String str2){
		double result = 0;
		int same=0;
		int length=0;
		if(str1==null||str2==null||str1.length()<=0||str2.length()<=0)
		length=str1.length()>str2.length()?str1.length():str2.length();
		System.out.println("length is:"+length);
		for(int i=0;i<str1.length();i++)
		{
			for(int j=0;j<str2.length();j++)
			{
				if(str1.charAt(i)==str2.charAt(j))
				{
					same++;
					break;
				}
			}
		}
		result = (double)same/(double)length;
		System.out.print(result);
		return result;
		}
	public static String readLine(){
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		String s = null;
		try {
			s = br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return s;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str="糖尿病患者应该怎么运动";
		while(true){
			String s=readLine();
			double similarity = getSimilarity(str,s);
		}

	}

}

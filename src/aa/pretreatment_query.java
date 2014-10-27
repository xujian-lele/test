package aa;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/**
 * 同义词库
 * @author xujian
 *
1|什么/啥
2|怎么/如何/咋
3|为什么/为何/为啥
4|哪儿/哪里
5|谁
6|几种/几类
7|几片/几颗/几粒
8|几点/几时
9|几次
 */

public class pretreatment_query {

	public static void synonymousWords_Init()
	{
	}
	
	public static ArrayList<String> queryPretreatment_ReplaceSynonymousWords(Map<Integer,ArrayList<String>>synonymousWords,ArrayList<String> query)
	{
		String s=null;
		int sign=0;
		ArrayList<String> sa=new ArrayList<String>();
		for(int i=0;i<query.size();i++)
		{
			s=null;
			s=query.get(i);
			sign=0;
			for(int j=1;j<=synonymousWords.size()&&sign==0;j++)
			{
				sa=null;
				sa=synonymousWords.get(j);
				sa.size();
				for(int k=0;k<sa.size();k++)
				{
					if(sa.get(k).equals(s))
					{
						query.set(i, String.valueOf(j));
						sign=1;
						break;
					}
				}
			}
		}
		System.out.println("Replaceed Query is:"+query.toString());
		return query;
	}

}

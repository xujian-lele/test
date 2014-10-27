package aa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


import aa.pretreatment_query;
import aa.QuestionSet;
import aa.AnswerSet;
import aa.Loader;
public class timerTest {

	/**
	 * 糖尿病知识库:问题ID-问题
	 * 
	 * @author xujian 
	 * 1|糖尿病有几种类型？ （糖尿病|6） 2|什么是1型糖尿病？ （1型糖尿病|1） 3|什么是2型糖尿病？
	 *         （2型糖尿病|1） 4|饮食的注意事项？ （饮食，注意事项）
	 *
	 */
/**
 * 糖尿病知识库：问题ID-问题答案
 * @author xujian
 *
 */
	public  static Map<Integer,String> answerset = new HashMap<Integer,String>();
	public static Map<Integer,ArrayList<String>> Qid_Qlist = new HashMap<Integer,ArrayList<String>>();
	public static Map<Integer,ArrayList<String>> synonymousWords =  new HashMap<Integer,ArrayList<String>>();



	public int matchQuestion(ArrayList<String>query)
	{
		
		return 0 ;
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		//Timer t =  new Timer();
		//t.schedule(new task(), 0, 1000);
//		System.out.println(Long.parseLong("123".toString()));
//		ArrayList<String> list = new ArrayList<String>();
//		String s=null;
//		list.remove(0);
//		for(int i=0;i<10;i++)
//		{
//			s= String.valueOf(1);
//			list.add(s);
//		}
//		System.out.println(list.size());	
//		list.remove(0);
//		System.out.println(list.size());
//		System.out.println(list.get(0));	
		ArrayList <String> test = new ArrayList <String>();
		ArrayList <String> test1 = new ArrayList <String>();
		/**
		 * 量：几种，几片，几颗，几粒，几点，几次
		 * 问：什么（啥what）怎么（咋How），在哪儿（where），谁（who），为什么（why）
		 */

//		String s ="A怎么吃？什么咋时候几点吃，糖尿病理糖尿病有";
//		String s1 ="糖尿病包含几种类型？";
//		try {
//			ChineseTokenizer.getInstance().tokenizeAndLowerCase(s1, test1);
//			ChineseTokenizer.getInstance().tokenizeAndLowerCase(s, test);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		System.out.println(test.toString());
//		System.out.println(test1.toString());
		
		Loader ld = new Loader();
		ld.loadQuestion(Qid_Qlist);
		ld.loadAnswerSet(answerset);
		ld.loadSynonymousWords(synonymousWords);
		System.out.println(synonymousWords.toString());
		
		int tag=10;
		byte[] t=null;
		String str = null;
		pretreatment_query pq = new pretreatment_query();
		SearchAnswer sa=new SearchAnswer();
//		pq.synonymousWords_Init();
		QuestionSet qs = new QuestionSet();
//		qs.Qid_Qlist_init();
		ArrayList<String> query =new ArrayList<String>();
		int qid = -1;
		
		while(tag==10)
		{
			qid=-1;
			System.out.println("请输入你的问题:");
			query.clear();
			str = null;
			BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
			str  = bf.readLine();			
			System.out.println(str.length());
			ChineseTokenizer.getInstance().tokenizeAndLowerCase(str, query);
			System.out.println(query.toString());
			query=pq.queryPretreatment_ReplaceSynonymousWords(synonymousWords,query);
			qid=sa.getMatchedQuestionID(Qid_Qlist, query);
			if(qid>=1)
				{
				System.out.println("answer is:");
				System.out.println(answerset.get(qid));
				}
			else{
				System.out.println("知识库中没有这个文件");
			}
		}
	}
}

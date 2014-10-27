package aa;
import java.util.ArrayList;
import java.util.Map;

import aa.QuestionSet;

public class SearchAnswer {
	
	/**
	 *从问题库中搜索出与用户请求最近接的问题，并将问题ID返回。
	 *-1:表示没有找到
	 */
	public int getMatchedQuestionID(Map<Integer, ArrayList<String>> Qid_Qlist,
			ArrayList<String> query) {
		ArrayList<String> sl = new ArrayList<String>();
		int ml=0;
		int result = -1;
		System.out.println(Qid_Qlist.toString());
		for (int i = 0; i < Qid_Qlist.size(); i++) {
//			sl.clear();
			ml=0;
			sl=new ArrayList<String>(Qid_Qlist.get(i+1));
//			System.out.println(sl.toString());
			// 通过对query做排序预处理，可以降低算法时间复杂度，以后可以改进
			for (int j = 0; j < sl.size(); j++) {
				for (int k = 0; k < query.size(); k++) {
					if (sl.get(j).equalsIgnoreCase(query.get(k))) {
						ml++;
						break;
					}
				}
			}
			if(ml>0&&ml==sl.size())
			{
				result =i+1;
				System.out.println("Matched Question ID:"+result);
				return result;
			}
		}
		System.out.println("Matched Question ID:"+result);
		return result;
	}
} 

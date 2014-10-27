package aa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class QuestionSet {
	/**
	 * 1|糖尿病有几种类型？（糖尿病，几种）（糖尿病|6） 2|什么是1型糖尿病？（什么，1型糖尿病） （1型糖尿病|1）
	 * 3|什么是2型糖尿病？（什么，2型糖尿病）（2型糖尿病|1） 4|饮食的注意事项？（饮食，注意事项）
	 */
	public static Map<Integer,ArrayList<String>> Qid_Qlist = new HashMap<Integer,ArrayList<String>>();

	public Map<Integer, ArrayList<String>> getQid_Qlist() {
		return Qid_Qlist;
	}

	public void setQid_Qlist(Map<Integer, ArrayList<String>> qid_Qlist) {
		Qid_Qlist = qid_Qlist;
	}
	
	public void Qid_Qlist_init()
	{
		
		ArrayList<String>list1=new ArrayList<String>();

		list1.add("糖尿病");
		list1.add("6");
		Qid_Qlist.put(1, list1);
		
		
		ArrayList<String>list2=new ArrayList<String>();

		list2.add("1型糖尿病");
		list2.add("1");
		Qid_Qlist.put(2, list2);
		System.out.println(Qid_Qlist.toString());
	}
	

}

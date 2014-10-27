package aa;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class QuestionTypeIdentity {
	public static QuestionTypeIdentity INSTANCE = new QuestionTypeIdentity();
	static Set<String> whatset;
	static Set<String> whenset;
	static Set<String> whoset;
	static Set<String> whereset;
	static Set<String> whyset;
	Set<String> a;

	private QuestionTypeIdentity() {
		whatset = new HashSet<String>();
		whenset = new HashSet<String>();
		whoset = new HashSet<String>();
		whereset = new HashSet<String>();
		whyset = new HashSet<String>();
		init();
	}
	 private void print(){
		 System.out.println(a.toString());
	 }
	 public void init()
	 {
		 whatsetinit();
		 whensetinit();
		 whosetinit();
		 wheresetinit();
		 whysetinit();
	 }
	public void whatsetinit()
	{
		whatset.add("什么");
		whatset.add("哪些");
		whatset.add("何");
		whatset.add("啥");
//		System.out.println(whatset.toString());
	}
	public void whensetinit()
	{
		whenset.add("什么时候");
		whenset.add("啥时候");
//		System.out.println(whenset.toString());
	}
	public void whosetinit()
	{
		whoset.add("谁");
		whoset.add("哪个");
		whoset.add("哪位");
		whoset.add("哪一个");
		whoset.add("哪一位");
		whoset.add("哪一名");
//		System.out.println(whenset.toString());
	}
//	哪儿，哪里，哪个地方，哪个位置，什么地方，什么位置，啥地方，啥位置，何方
	public void wheresetinit()
	{
		whereset.add("哪儿");
		whereset.add("哪里");
		whereset.add("哪个地方");
		whereset.add("哪个位置");
		whereset.add("什么地方");
		whereset.add("什么位置");
		whereset.add("啥地方");
		whereset.add("啥位置");
		whereset.add("何方");
	}
	public void whysetinit()
	{
		whyset.add("为什么");
		whyset.add("为啥");
		whyset.add("为嘛");
		whyset.add("啥原因");
		whyset.add("什么原因");
		whyset.add("原因是什么");
		whyset.add("原因是啥");
		whyset.add("原因是什么");
		whyset.add("原因有哪些");
//		System.out.println(whatset.toString());
	}
	
	/**
	 * 
	 * @param str
	 * @return instruction as follows
	 * what	return 1
	 * when	return 2
	 * who	return 3
	 * where return 4
	 * 
	 */
	public int QuestionIndentify(String str) 
	{
		int result = 0;
		if(isWhat(str)){
			result=1;
//			return result;
		}
		if(isWhen(str)){
			result=2;
			return result;
		}
		if(isWho(str)){
			result=3;
			return result;
		}
		if(isWhere(str)){
			result=4;
			return result;
		}
		if(isWhy(str)){
			result=5;
			return result;
		}
		return result;
	}
	/**
	 * 
	 * @param str
	 * @return
	 * 什么、啥、何、哪些
	 */
	public boolean isWhat(String str)
	{
		Iterator<String> ite = whatset.iterator();
		
		for(String s=ite.next();ite.hasNext();s=ite.next())
		{
			if(str.contains(s)==true)
			{
				return true;
			}
		}
		return false;
	}
	/**
	 * 
	 * @param str
	 * @return 
	 * 什么时候，啥时候
	 */
	public boolean isWhen(String str)
	{
		Iterator<String> ite = whenset.iterator();
		
		for(String s=ite.next();ite.hasNext();s=ite.next())
		{
			if(str.contains(s)==true)
			{
				return true;
			}
		}
		return false;
	}
	/**
	 * 
	 * @param str
	 * @return 
	 * 谁，哪个，哪位，哪一个，哪一位，哪一名
	 */
	public boolean isWho(String str)
	{
		Iterator<String> ite = whoset.iterator();
		
		for(String s=ite.next();ite.hasNext();s=ite.next())
		{
			if(str.contains(s)==true)
			{
				return true;
			}
		}
		return false;
	}
	/**
	 * 
	 * @param str
	 * @return 
	 * 哪儿，哪里，哪个地方，哪个位置，什么地方，什么位置，啥地方，啥位置，何方
	 */
	public boolean isWhere(String str)
	{
		Iterator<String> ite = whereset.iterator();
		
		for(String s=ite.next();ite.hasNext();s=ite.next())
		{
			if(str.contains(s)==true)
			{
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 
	 * @param str
	 * @return 
	 * 哪儿，哪里，哪个地方，哪个位置，什么地方，什么位置，啥地方，啥位置，何方
	 */
	public boolean isWhy(String str)
	{
		Iterator<String> ite = whyset.iterator();
		
		for(String s=ite.next();ite.hasNext();s=ite.next())
		{
			if(str.contains(s)==true)
			{
				return true;
			}
		}
		return false;
	}
	
public static void main(String[] args)
{
	System.out.println(QuestionTypeIdentity.INSTANCE.isWhen("糖尿病是什么"));
	System.out.println(QuestionTypeIdentity.INSTANCE.isWhat("谁是什么"));
	System.out.println(QuestionTypeIdentity.INSTANCE.isWhere("你来自哪里"));
	System.out.println(QuestionTypeIdentity.INSTANCE.isWhy("你是谁呀"));
}
}

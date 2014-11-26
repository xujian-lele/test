import SortCommon.SortUtil;

/**
 * 实现KMP算法来实现字符串匹配的工作
 * @author xujian
 *
 */
public class KMP {
	/**
	 * 在text中查找pattern是否存在.
	 * @param text	主字符串
	 * @param pattern	匹配字符串
	 * @param next	next数组
	 * @return	存在:ture		不存在:false
	 */
	public static boolean KMP(String text, String pattern, int[] next){
		if(text == null || text.length() < pattern.length())return false;
		if(pattern == null) return true;
		for(int i=0,j=0; i<text.length();){
			if(j == -1 || text.charAt(i) == pattern.charAt(j)){
				i++;
				j++;
				if(j == pattern.length()){
					return true;
				}
			}else{
				j = next[j];
			}
		}
		return false;
	}
	
	/**
	 * 产生next数组
	 * @param pattern	匹配字符串
	 * @param next	next数组
	 */
	public static void getNext(String pattern, int[] next){
		if(pattern == null || pattern.length() == 0)return ;
		//前面两个元素-1,0
		for(int i=0;i<next.length && i<2;i++){
			next[i] = i-1;
		}
		
		for(int i=0,j=-1;i<pattern.length();){
			if(j == -1 || pattern.charAt(j) == pattern.charAt(i)){
				i++;
				j++;
				if(i < pattern.length())next[i] = j;
			}else{
				j = next[j];
			}
		}
		
	}
	
	public static void main(String[] args){
		int size = 8;
		String pattern = "abaabcac";
		int[] next = new int[size];
		getNext(pattern, next);
		SortUtil.INSTANCE.printArray(next, size);
		String text = "abaabdabaabca";
		System.out.println(KMP(text, pattern, next));
	}
}

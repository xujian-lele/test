package Generic;

public class ArrayAlg {

	public static ArrayAlg instance = new  ArrayAlg();
	public <T extends Comparable<T>> Pair<T> minmax(T[] s){
		if(s==null || s.length==0) return null;
		T min;
		T max;
		min = s[0];
		max= s[0];
		
		for(int i=0;i<s.length;i++){
			if(min.compareTo(s[i])>0) {
				min = s[i];
			}
			
			if(max.compareTo(s[i])<0){
				max = s[i];
			}
		}
		return new Pair<T>(min,max);
		
	}

}

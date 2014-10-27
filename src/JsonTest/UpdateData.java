package JsonTest;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UpdateData {
	public  static void main(String[] args){
		Set<String> s = new HashSet<String>();
		Set<String> s1 = new HashSet<String>();

		List<String> l = new ArrayList<String>();
		
		for(int i=0;i<10;i++){
			s.add(String.valueOf(i));
			s1.add(String.valueOf(5*i));

			l.add(String.valueOf(10*i));
		}
		
//		s.addAll(s1);
		s.addAll(l);
		System.out.println(s);
	}

}

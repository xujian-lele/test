package Sum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

/**
 * 有序数组1到n,将所有的数分成两个集合，使得两个集合的和相等，输出所有的这种情况。
 * @author xujian
 *
 */
public class Pick {
	public static HashSet<HashSet<Integer>> result = new HashSet<HashSet<Integer>>();
	public static void process(int n, int sum1, int sum2, int[] array1, int[] array2, int index1, int index2){
		if(n == 0 ){
			if(sum1 == sum2){
				StringBuffer sb = new StringBuffer();
				HashSet<Integer> s1 = new HashSet<Integer>();
				
				for(int i=0;i<index1;i++){
					s1.add(array1[i]);
					sb.append(array1[i]);
					sb.append(" ");
				}
				sb.append("	");
				HashSet<Integer> s2 = new HashSet<Integer>();
				for(int i=0;i<index2;i++){
					s2.add(array2[i]);
					sb.append(array2[i]);
					sb.append(" ");
				}
				if(result.size()==0 || (!result.contains(s1) && !result.contains(s2))){
					result.add(s1);
					result.add(s2);
					System.out.println(sb.toString());
				}
			}
			return;
		}
		//放1中
		if(n > 0){
			sum1 = sum1 + n;
			array1[index1++] = n;
			process(n-1, sum1, sum2, array1, array2, index1, index2);
		}
		//放2中
		if(n > 0 && index1 >=0){
			sum1 -= array1[--index1];

			sum2 += n;
			array2[index2++] = n;
			process(n-1, sum1, sum2, array1, array2, index1, index2);
		}
	}

	public static int add(int x, int y){
		return (x+y);
	}
	
	public static void main(String[] args) {
		System.out.println("请输入一个大于0的整数： ");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = null;
		try {
			input = br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int n = Integer.parseInt(input);
		int[] array1 = new int[n];
		int[] array2 = new int[n];
		process(n, 0, 0, array1, array2, 0, 0);
	}

}

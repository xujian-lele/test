

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * 
 * @author xujian
 *	function: 输入两个整数n,m，写一个函数，找到所有1.2.3...n中所有和为m组合
 *	解法：将该问题类比成一个背包问题，1到n为体积，背包的体积为m，求所有正好装满背包的组合
 */

public class Sort_Test {
	/**
	 * @param n 未处理的个数
	 * @param m 当前背包剩余容量
	 * @param array 背包中的东西
	 */
	public static void process(int n, int m, int[] array, int index){
		if(m == 0){
			StringBuffer sb = new StringBuffer();
			for(int i=0 ; i<index ;i++){
				sb.append(array[i]);
				sb.append(" ");
			}
			System.out.println(sb.toString());
			return;
			}
		
		//不放
		if(n >= 1){
			process(n-1, m, array, index);
		}
		//放
		if(n >=1 && m >= n){
			array[index++] = n;
			process(n-1, m-n, array, index);
		}

		
	}
	public static void main(String[] args){
		System.out.println("请输入两个数字,以空格隔开");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = null;
		try {
			str = br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String[] words = str.split(" ");
		int n = Integer.parseInt(words[0]);
		int m = Integer.parseInt(words[1]);
		
		int[] array = new int[5];
		process(n, m, array, 0);
	}

}

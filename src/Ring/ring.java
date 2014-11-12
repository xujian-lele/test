/**
 * 
 */
package Ring;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author xujian
 * 约瑟夫环问题
 *	输入：两个整数n和m
 *	输出：最后剩下的那个人的编号
 */
public class ring {
	public static void main(String[] args){
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = null;
		System.out.println("约瑟夫环问题，请输入两个整数，以空格隔开。");
		try {
			input = br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int n = Integer.valueOf(input.split(" ")[0]);
		int m = Integer.valueOf(input.split(" ")[1]);
		int result = findLast2(n, m);
		if(result!=-1)System.out.println("最后剩下的那个人的编号是："+result);
		else{
			System.out.println("没找到答案!");
		}
	}

	private static int findLast(int n, int m) {
		//递推解法
		if(m <=0 || n <= 0) return -1;
		if(n == 1) return 0;
		int result = (findLast(n-1, m)+ m%n + 1)% n;
		return result;
	}
	
	public static int findLast2(int n, int m){
		//非递归的方法
		if(n <=0 || m<=0) return -1;
		if( n==1 ) return 0;
		int result = 0;
		for(int i=2;i<=n;i++){
			result = (result + m%n +1) % i;
		}
		return result;
		
	}

}

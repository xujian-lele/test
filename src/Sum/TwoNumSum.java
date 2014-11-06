package Sum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TwoNumSum {
	/**
	 * 输入：
	 * m:数组长度；
	 * n：和
	 * 要求：找出所有两个数的和为n的组合
	 */
	
	/*
	 * 1 2 3 4 5 6 7 8
	 */
	public static void process(int arrayLength, int sum){
		if(arrayLength == 0) return ;
		if(sum < 0 || sum > arrayLength*(arrayLength-1)/2){
			return ;
		}
		int[] array = new int[arrayLength];
		for(int i=0;i<arrayLength;i++){
			array[i] = i + 1;
		}
		
		int j = 0;
		int k = arrayLength -1;
		for(;j<k;){
			if((array[j] + array[k]) == sum){
				System.out.println(array[j]+"     "+array[k]);
				j++;
				k--;
			}
			if((array[j] + array[k]) > sum){
				k--;
			}
			if((array[j] + array[k]) < sum){
				j++;
			}
		}
	}
	
	public static void main(String[] args){
		System.out.println("请输入两个数字，中间以空格隔开。");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = null;
		try {
			input = br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int m = Integer.parseInt(input.split(" ")[0]);
		int n = Integer.parseInt(input.split(" ")[1]);
		
		process(m, n);
		System.out.println();
	}

}

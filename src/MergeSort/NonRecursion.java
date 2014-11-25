package MergeSort;

import SortCommon.SortUtil;

/**
 * 归并排序的非递归实方法
 * 思路：以长度为2^n（n=0,1,2,3...）对数组进行（int）log2（length） + 1趟归并排序
 */
public class NonRecursion {
	public static void oneMergePass(int[] array, int wide){
		if(array.length <= 1) return;
		for(int i=0; i+wide < array.length; i = i + wide * 2){
			int low = i;
			int high = i + 2*wide -1;
			if(high >= array.length) {
				high = array.length-1;
			}
			int mid = i + wide -1;
			array = MergeSortUtil.INSTANCE.merge(array, low, mid, high);
		}
	}
	
	public static void mergeSortNonRecursion(int[] array){
		if(array.length <= 0) return;
		int wide = 1;
		int turnTimes = (int) (Math.log10(array.length)/Math.log10(2) + 1);
		while(wide <= Math.pow(2, turnTimes)){
			oneMergePass(array, wide);
			wide = wide * 2;
		}
	}
	
	public static void main(String[] args){
		int size = 5;
		int[] array = SortUtil.INSTANCE.arrayBuilder(size);
		SortUtil.INSTANCE.printArray(array, size);
		mergeSortNonRecursion(array);
		SortUtil.INSTANCE.printArray(array, size);

	}
}

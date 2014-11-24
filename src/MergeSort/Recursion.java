package MergeSort;

import SortCommon.SortUtil;

/**
 * 归并排序的递归实现
 */
public class Recursion {
	/**
	 * 将array拆解成2个部分。
	 * @param array
	 * @param low
	 * @param high
	 */
	public static void splitTo2(int[] array, int low, int high){
		if(low < -1 || high < -1 || low >= high) return;
		int mid = (low + high)/2;
		splitTo2(array, low, mid);
		splitTo2(array, mid+1, high);
		array = MergeSortUtil.INSTANCE.merge(array, low, mid, high);
		SortUtil.INSTANCE.printArray(array, array.length);

	}
	
	public static void main(String[] args){
		int size = 5;
		int[] array = SortUtil.INSTANCE.arrayBuilder(size);
		SortUtil.INSTANCE.printArray(array, size);
		splitTo2(array, 0, size-1);
	}
}

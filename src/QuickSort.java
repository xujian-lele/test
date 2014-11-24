import SortCommon.SortUtil;


public class QuickSort {
	/**
	 * 递归形式的快速排序(从大到小)
	 */
	
	public static void quickSort(int[] array, int low, int high){
		//TODO:结束条件。
		if(low == high) return;
		int mid = getMiddle(array, low, high);
		quickSort(array, low, mid);
		if(mid+1 < array.length)
		quickSort(array, mid+1, high);
	}
	
	private static int getMiddle(int[] array, int low, int high) {
		int tag = array[low];
		while(low < high){
			while(array[high] <= tag && low < high){
				high--;
			}
			array[low] = array[high];
			array[high] = tag;
			while(array[low] >= tag && low < high){
				low++;
			}
			array[high] = array[low];
			array[low] = tag;
		}
		return low;
	}
	
	public static void main(String[] args){
		int size = 5;
		int[] array = SortUtil.INSTANCE.arrayBuilder(size);
		SortUtil.INSTANCE.printArray(array, size);
		quickSort(array, 0, array.length-1);
		SortUtil.INSTANCE.printArray(array, size);
	}
}

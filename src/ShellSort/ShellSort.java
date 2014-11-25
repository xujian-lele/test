package ShellSort;

import SortCommon.SortUtil;

public class ShellSort {

	/**
	 * shell 排序（从大到小）
	 */
	public static void shellSort(int[] array){

		if(array.length <= 1) return;
		for(int stepLength = 3; stepLength>=1; stepLength--){
			for(int i=0; i<stepLength; i++){
				straightInsert(array, i, array.length, stepLength);
			}
		}
	}

	/**
	 * 数组array中，以i开始间隔为stepLength的各个数组成一个数组，对该数据进行直接插入排序
	 * @param array	被排序的数组
	 * @param start	插入排序的起始位置
	 * @param length	数组长度
	 * @param stepLength	步长
	 */
	private static void straightInsert(int[] array, int start, int length, int stepLength) {
		for(int i = start + stepLength; i < length; i += stepLength){
			insertItem(array, i, stepLength);
		}
	}

	/**
	 * 将下标为itemPlace的元素，插入到array中间隔为stepLength的各元素组成的数组的有序区。
	 * @param array	被操作的数组
	 * @param itemPlace	插入元素的下标	
	 * @param stepLength	步长
	 */
	private static void insertItem(int[] array, int itemPlace, int stepLength) {
		int item = array[itemPlace];
		int newPlace = itemPlace - stepLength;
		while(newPlace >= 0 && array[newPlace] < item){
			array[newPlace + stepLength] = array[newPlace];
			newPlace -= stepLength;
		}
		
		if(newPlace != itemPlace - stepLength){
			array[newPlace + stepLength] = item;
			SortUtil.INSTANCE.printArray(array, array.length);
		}
	}
	
	public static void main(String[] args){
		int size = 5;
		int[] array = SortUtil.INSTANCE.arrayBuilder(size);
		SortUtil.INSTANCE.printArray(array, size);
		shellSort(array);
		SortUtil.INSTANCE.printArray(array, size);

	}
	
}

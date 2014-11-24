package MergeSort;

public class MergeSortUtil {
	public static MergeSortUtil INSTANCE = new MergeSortUtil();
	
	/**
	 * low到mid  mid到high量个数组归并到一起(从大到小)。
	 * @param array
	 * @param low
	 * @param mid
	 * @param high
	 */
	public int[] merge(int[] array, int low, int mid, int high){
		int[] sorted = array.clone();
		int lowTag = low;
		int highTag = mid+1;
		int sortedLength = low;
		for(;sortedLength <= high && lowTag <= mid && highTag <= high;sortedLength++){
			if(array[lowTag] > array[highTag]){
				sorted[sortedLength] = array[lowTag];
				lowTag ++;
			}else{
				sorted[sortedLength] = array[highTag];
				highTag ++;
			}
		}
		
		//
		if(lowTag != mid+1){
			for(int k=lowTag; k < mid+1; k++){
				sorted[sortedLength++] = array[k];
			}
		}else{
			for(int k=highTag; k < high+1; k++){
				sorted[sortedLength++] = array[k];
			}
		}
		
        for(int m = low; m<=high ; m++){//将辅助数组中的排序好的元素复制回原数组  
            array[m] = sorted[m];  
        }  
		return array;
	}

}

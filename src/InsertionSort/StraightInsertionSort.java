package InsertionSort;
/**
 * 运用直接排序的方法进行排序
 * @author xujian
 *
 */
import SortCommon.SortUtil;
public class StraightInsertionSort {
	/**
	 * 直接插入排序(从大到小)
	 * @param array
	 */
	public static void Sort(int[] array){
		if(array.length <= 1) return;
		for(int i=1; i<array.length; i++){
			insert(array, i);
		}
	}

	/**
	 * 找到array[itemPlace]的插入位置,并执行插入操作
	 * @param array
	 * @param itemPlace
	 * @return
	 */
	private static void insert(int[] array, int itemPlace) {
		int sortItem = array[itemPlace];
		for(int i=itemPlace-1 ; i>=-1; i--){
			if(i == -1 || sortItem <= array[i]){
				array[i+1] = sortItem;
				break;
			}else{
				array[i+1] = array[i];
			}
		}
	}
	

	public static void main(String[] args){
		int size = 5;
		int[] array = SortUtil.INSTANCE.arrayBuilder(size);
		SortUtil.INSTANCE.printArray(array, size);
		Sort(array);
		SortUtil.INSTANCE.printArray(array, size);
	}
}

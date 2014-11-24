package InsertionSort;
/**
 * 运用直接排序的方法进行排序
 * @author xujian
 *
 */
public class StraightInsertionSort {
	/**
	 * 直接插入排序(从大到小)
	 * @param array
	 */
	public static void Sort(int[] array){
		if(array.length <= 1) return;
		for(int i=1; i<array.length; i++){
			int newplace = findReplace(array,i);
			insertItem(array,i,newplace);
		}
	}

	/**
	 * 将array[itemPlace]插入到array[newplace]
	 * @param array
	 * @param itemPlace
	 * @param newplace
	 */
	private static void insertItem(int[] array, int itemPlace, int newplace) {
		if(newplace == -1) return ;
		int item = array[itemPlace];
		for(int i=itemPlace;i>=newplace+1;i--){
			array[i] = array[i-1];
		}
		
		array[newplace] = item;
	}

	/**
	 * 找到array[itemPlace]的插入位置
	 * @param array
	 * @param itemPlace
	 * @return
	 */
	private static int findReplace(int[] array, int itemPlace) {
		int newplace = -1;
		if(array[itemPlace] >= array[0]) return 0;
		if(itemPlace <= 0) return newplace;//不进行移动
		for(int i=itemPlace-1 ; i>=0; i--){
			if(array[itemPlace] <= array[i]){
				newplace = i+1;
				break;
			}
		}
		return newplace;
	}
	
	/**
	 * 创建一个size大小的数组（从小到大）
	 * @param size
	 * @return
	 */
	public static int[] arrayBuilder(int size){
		int[] array = new int[size];
		for(int i=0;i<size;i++){
//			array[i] = (int) (Math.random()*100 + 1);
			array[i] = i + 1 ;
		}
		return array;
	}
	
	/**
	 * 打印一个大小为size的数组的内容
	 * @param array
	 * @param size
	 */
	public static void printArray(int[] array, int size){
		StringBuffer sb = new StringBuffer();
		for(int i=0;i<size;i++){
			sb.append(array[i]);
			sb.append("    ");
		}
		System.out.println(sb.toString().trim());
	}
	
	public static void main(String[] args){
		int size = 5;
		int[] array = arrayBuilder(size);
		printArray(array, size);
		Sort(array);
		printArray(array, size);
		
	}
}

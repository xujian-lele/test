package SelectionSort;

/**
 * 实现选择排序
 * @author xujian
 *
 */
public class SelectionSort {
	public static int[] arrayBuilder(int num){
		int[] array = new int[num];
		for(int i=0;i<num;i++){
//			array[i] = (int) (Math.random()*100 + 1);
			array[i] = i + 1 ;
		}
		return array;
	}
	
	public static void printArray(int[] array, int size){
		StringBuffer sb = new StringBuffer();
		for(int i=0;i<size;i++){
			sb.append(array[i]);
			sb.append("    ");
		}
		System.out.println(sb.toString().trim());
	}
	
	/**
	 * 运用选择排序的思想进行排序（从大到小）
	 * @param array
	 */
	public static void Sort(int[] array){
		if(array.length <= 1) return ;
		int bigest;
		for(int i=0;i<array.length-1;i++){
			bigest = i;
			for(int j=i+1;j<array.length;j++){
				if(array[j] > array[bigest]){
					bigest = j;
				}
			}
			if(bigest != i){
				int t = array[bigest];
				array[bigest] = array[i];
				array[i] = t;
			}
		}
	}
	public static void main(String[] args){
		int size = 5;
		int[] array = arrayBuilder(size);
		printArray(array, size);
		Sort(array);
		printArray(array, size);

		
	}
}

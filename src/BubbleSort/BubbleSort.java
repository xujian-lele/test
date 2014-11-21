package BubbleSort;
/**
 * 冒泡排序
 * @author xujian
 *
 */
public class BubbleSort {
	int[] array;

	public BubbleSort(int[] array) {
		super();
		this.array = array;
	}

	public void swap(int a, int b){
		int t = this.array[a];
		this.array[a] = this.array[b];
		this.array[b] = t;
	}
	
	/**
	 * 运用冒泡排序的思想实现从大到小的排序
	 * @param array
	 */
	public void b2SSort(int[] array){
		for(int i=array.length-1;i>=0;i--){
			for(int j=0; j<i; j++){
				if(array[j] < array[j+1]){
					swap(j, j+1);
				}
			}
		}
	}
	
	/**
	 * 运用冒泡排序的思想实现从小到大的排序
	 * @param array
	 */
	public void s2BSort(int[] array){
		for(int i=array.length-1;i>=0;i--){
			for(int j=0; j<i; j++){
				if(array[j] > array[j+1]){
					swap(j, j+1);
				}
			}
		}
	}
	
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
	
	public static void main(String[] args){
		int size = 5;
		int[] array = arrayBuilder(size);
		printArray(array, size);
		BubbleSort bs = new BubbleSort(array);
		bs.s2BSort(array);
		printArray(array, size);
		
		bs.b2SSort(array);
		printArray(array, size);
	}
}

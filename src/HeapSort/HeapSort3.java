package HeapSort;


/**
 * 实现对排序
 * @author xujian
 *
 */
public class HeapSort3 {
	public static int size = 100;
	public int[] array = new int[size];
	
	public static int getSize() {
		return size;
	}

	public static void setSize(int size) {
		HeapSort3.size = size;
	}

	public int[] getArray() {
		return array;
	}

	public void setArray(int[] array) {
		this.array = array;
	}

	public HeapSort3(int[] array) {
		super();
		this.array = array;
	}
	
	public static int[] arrayBuilder(int num){
		int[] array = new int[num];
		for(int i=0;i<num;i++){
//			array[i] = (int) (Math.random()*100 + 1);
			array[i] = i + 1 ;
		}
		return array;
	}
	
	public static void buildBigTopHeap(int[] array, int size){
		for(int i=array.length/2; i>=0; i--){
			adjustBigTopHeap(array, i, array.length);
		}
	}
	
	public static void Sort(int[] array, int size){
		for(int i = size-1; i>=0; i--){
			int t = array[0];
			array[0] = array[i];
			array[i] = t;
			adjustBigTopHeap(array, 0, i);
		}
	}
	
	/**
	 * m+1 ... length 满足堆条件，之后m不满足。
	 * 功能：将m也调整为满足堆条件
	 * @param array
	 * @param m
	 * @param length
	 */
	public static void adjustBigTopHeap(int[] array ,int m, int length){
		int k = m;
		for(int i=(1+k)*2-1; i<length; ){
			if(array[i]>array[k] || ((i+1) < length && array[i+1] > array[k])){
				if((i+1) >= length || array[i] > array[i+1]){
					int t = array[i];
					array[i] = array[k];
					array[k] = t;
					k = i;
					i = (i+1)*2 -1;
				}else if(array[i] <= array[i+1]){
					int t = array[i+1];
					array[i+1] = array[k];
					array[k] = t;
					k = i+1;
					i = (i+1+1)*2-1;
				}
			}else{
				break;
			}
		}
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
		
		HeapSort3.buildBigTopHeap(array ,size);
		printArray(array, size);
		HeapSort3.Sort(array, size);
		printArray(array, size);

	}
	
	
}

/**
 * 
 */
package Sort;


/**
 * @author xujian
 * 实现堆排序
 */
public class HeapSort2 {
	public static boolean buildSmallTopHeap(int[] array){
		for(int i=0; i<array.length; i++){
//			AdjustSmallTopHeap(array, i);
			AdjustSmallTopHeap2(array, i);
		}
		return true;
	}
	
	public static boolean buildBigTopHeap(int[] array){
		for(int i=0; i<array.length; i++){
			AdjustBigTopHeap(array, i);
		}
		return true;
	}
	
	public static boolean AdjustSmallTopHeap2(int[] array, int m){
		if(m == 0) return true;
		//将m和0处的数据对调位置
		int t = array[m];
		array[m] = array[0];
		array[0] = t;
		
		for(int i=0; i<=m-1;){
			int left = -1;
			int right = -1;
			if(m-1 >= (i+1)*2){
				right = (i+1)*2;
			}
			if(m-1 >= (i+1)*2 - 1){
				left = (i+1)*2 - 1;
			}
			
			if((left!=-1 && array[left] < array[i]) || (right!=-1 && array[right] < array[i])){
				if(array[left] < array[right]){
					int k = array[left];
					array[left] = array[i];
					array[i] = k;
					i = left;
					continue;
				}
				
				else if(array[left] > array[right]){
					int k = array[right];
					array[right] = array[i];
					array[i] = k;
					i = right;
					continue;
				}
				
			}
			break;
		}
		return true;
	}
	
	/**
	 * 调整小顶堆，
	 * 调整方向：从非叶子节点向跟节点调整，不将最后一个元素跟第一个元素对调。
	 * @param array
	 * @param m
	 * @return
	 */
	public static boolean AdjustSmallTopHeap(int[] array, int m){
		if(m==0) return true;
		for(int i=m; i>0;){
			int parent;
			if(i%2 == 0){
				parent = i/2 - 1;
			}
			else parent = i/2;
			if(array[parent] > array[i]){
				int k = array[parent];
				array[parent] = array[i];
				array[i] = k;
				i = parent;
				continue;
			}else{
				break;
			}
		}
		return true;
	}
	
	public static boolean AdjustBigTopHeap(int[] array, int m){
		if(m==0) return true;
		for(int i=m; i>0; i=m/2){
			int parent;
			if(i%2 == 0){
				parent = i/2 - 1;
			}
			else parent = i/2;
			if(array[parent] < array[i]){
				int k = array[parent];
				array[parent] = array[i];
				array[i] = k;
				i = parent;
				continue;
			}else{
				break;
			}
		}
		return true;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {	
		int length = 5;
		int[] array = new int[length];
		for(int i=0; i<length; i++){
			array[i] = length - i;
		}
		
		for(int i=0; i<length; i++){
			System.out.print(array[i]+ "    ");
		}
		
		System.out.println("\n");

		buildSmallTopHeap(array);
//		buildBigTopHeap(array);
		
		for(int i=0; i<length; i++){
			System.out.print(array[i]+"    ");
		}
		
	}

}

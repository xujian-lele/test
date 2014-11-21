/**
 * 
 */
package HeapSort;

import java.util.LinkedList;
import java.util.List;

/**
 * @author xujian
 *
 */
public class HeapSort {

	/**
	 * @param args
	 * 功能：利用堆排序原理，将一个数组从小到大进行排序
	 * 
	 */
	
	/*
	 * 给定一个数据，建立一个小顶堆
	 */
	public static void adjustHeap(List<Integer> array){
		for(int k=0; k<array.size()/2; k++){
			for(int i=0; i<array.size(); i++){
				int root = array.get(i);
				int left = -1;
				int right = -1;
				//get left
				if(2*(i+1)-1 < array.size()){
					left = array.get(2*(i+1)-1);
				}
				//get right
				if(2*(i+1) < array.size()){
					right = array.get(2*(i+1));
				}
				
				if(root > left || root > right){
					//left和right都存在，left最小，将left和root进行交换
					if((left < right && left != -1) || (right == -1 && left != -1 )){
						int temp = root;
						array.set(i, left);
						array.set(2*(i+1)-1, temp);
					}
					//left和right都存在，right最小，将right和root进行交换
					if((left > right && right != -1) || (right != -1 && left == -1 )){
						int temp = root;
						array.set(i, right);
						array.set(2*(i+1), temp);
					}
				}
			}
		}
	}
	
	/**
	 * 调整堆
	 */
	public static void main(String[] args) {
		List<Integer> array = new LinkedList<Integer>();
		int length = 5;
		for(int i=0; i<length; i++){
			array.add(length-i);
		}
		adjustHeap(array);
		System.out.println(array);
		
		while(array.size()>=1){
			System.out.println(array.get(0));
			array.set(0, array.get(array.size()-1));
			array.remove(array.size()-1);
			adjustHeap(array);
		}
	}
}

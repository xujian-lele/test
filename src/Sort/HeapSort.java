/**
 * 
 */
package Sort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author xujian
 * 	function : 给定一个数组建立一个棵二叉树
 *
 */
public class HeapSort {

	/**
	 * @param args
	 */
	

	public static HeapSortNode buildHeap(List<Integer> array){
		if(array == null || array.size() == 0)return null;
		HeapSortNode root = new HeapSortNode(array.get(0));
		Queue<HeapSortNode> queue = new LinkedList<HeapSortNode>();
		queue.add(root);
		for(int i=1; i<array.size(); i++){
			if(i%2!=0){
				HeapSortNode node = new HeapSortNode(array.get(i));
				queue.peek().setLeft(node);
				queue.offer(node);
			}else if(i%2==0){
				HeapSortNode node = new HeapSortNode(array.get(i));
				queue.poll().setRight(node);
				queue.offer(node);
			}
		}
		return root;
	}
	
	public static void main(String[] args){
		List<Integer> array = new ArrayList<Integer>();
		for(int i=0;i<10;i++){
			array.add(i);
		}
		
		HeapSortNode root = buildHeap(array);
		System.out.println(array);
	}
	
	
}

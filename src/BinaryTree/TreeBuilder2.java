/**
 * 
 */
package BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author xujian
 * 	function : 给定一个数组建立一个棵二叉树
 *
 */
public class TreeBuilder2 {

	/**
	 * @param args
	 */
	

	public static TreeBuilder2Node buildHeap(List<Integer> array){
		if(array == null || array.size() == 0)return null;
		TreeBuilder2Node root = new TreeBuilder2Node(array.get(0));
		Queue<TreeBuilder2Node> queue = new LinkedList<TreeBuilder2Node>();
		queue.add(root);
		for(int i=1; i<array.size(); i++){
			if(i%2!=0){
				TreeBuilder2Node node = new TreeBuilder2Node(array.get(i));
				queue.peek().setLeft(node);
				queue.offer(node);
			}else if(i%2==0){
				TreeBuilder2Node node = new TreeBuilder2Node(array.get(i));
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
		
		TreeBuilder2Node root = buildHeap(array);
		System.out.println(array);
	}
	
	
}

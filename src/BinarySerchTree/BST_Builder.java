/**
 * 
 */
package BinarySerchTree;

import BinaryTree.Node;
import BinaryTree.TreeBuilder;

/**
 * @author xujian
 *	创建一个二叉排序树
 *	问题1：二叉排序树的节点是否允许相同。
 */
public class BST_Builder implements TreeBuilder{

	public Node buildTree(int[] array) {
		Node root = new Node(array[0]);
		for(int i=1; i<array.length; i++){
			insertNode(root, array[i]);
		}
		return root;
	}

	private boolean insertNode(Node root, int key) {
		if(root == null){
			root = new Node(key);
			return true;
		}
		if(key < root.value){
			if(root.getRightChild() == null){
				Node node = new Node(key);
				root.setLeftChild(node);
				return true;
			}else{
				insertNode(root.getLeftChild(), key);
			}
		}else if(root.value < key){
			if(root.getRightChild() == null){
				Node node = new Node(key);
				root.setRightChild(node);;
				return true;
			}else{
				insertNode(root.getRightChild(), key);
			}
		}
		return true;
	}

}
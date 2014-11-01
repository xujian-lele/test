package BinarySerchTree;

import BinaryTree.Node;

public class LDR_BST {
	public static LDR_BST INSTANCE = new LDR_BST();
	Node root;
	public boolean LDR(Node root){
		if(root == null) return false;
		if(root.getLeftChild() != null){
			LDR(root.getLeftChild());
		}
		
		System.out.println(root.getValue() + " ");
		
		if(root.getRightChild() != null){
			LDR(root.getRightChild());
		}
		return true;
	}

}

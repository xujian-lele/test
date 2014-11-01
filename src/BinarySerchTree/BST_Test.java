package BinarySerchTree;

import BinaryTree.Node;

public class BST_Test {
	public static void LDR_Test(){
		int[] array={19,12,3,22,6,7,21,11,43}; 
		BST_Builder treeBuilder = new BST_Builder();
		Node root = treeBuilder.buildTree(array);
		LDR_BST.INSTANCE.LDR(root);
	}
	
	public static void main(String[] args){
		LDR_Test();
	}

}

/**
 * 
 */
package BinaryTree;

/**
 * @author xujian
 *	描述一个节点
 */
public class Node {

	//value
	public int value;
	//leftchild
	public Node leftChild;
	//right
	public Node rightChild;
	
	
	public Node(int value) {
		super();
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public Node getLeftChild() {
		return leftChild;
	}
	public void setLeftChild(Node leftChild) {
		this.leftChild = leftChild;
	}
	public Node getRightChild() {
		return rightChild;
	}
	public void setRightChild(Node rightChild) {
		this.rightChild = rightChild;
	}
}

package BinaryTree;

public class TreeBuilder2Node {
		int value;
		TreeBuilder2Node left;
		TreeBuilder2Node right;
		public int getValue() {
			return value;
		}
		public void setValue(int value) {
			this.value = value;
		}
		public TreeBuilder2Node getLeft() {
			return left;
		}
		public void setLeft(TreeBuilder2Node left) {
			this.left = left;
		}
		public TreeBuilder2Node getRight() {
			return right;
		}
		public void setRight(TreeBuilder2Node right) {
			this.right = right;
		}
		public TreeBuilder2Node(int value) {
			this.value = value;
		}			
		
}

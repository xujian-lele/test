package Sort;

public class HeapSortNode {
		int value;
		HeapSortNode left;
		HeapSortNode right;
		public int getValue() {
			return value;
		}
		public void setValue(int value) {
			this.value = value;
		}
		public HeapSortNode getLeft() {
			return left;
		}
		public void setLeft(HeapSortNode left) {
			this.left = left;
		}
		public HeapSortNode getRight() {
			return right;
		}
		public void setRight(HeapSortNode right) {
			this.right = right;
		}
		public HeapSortNode(int value) {
			this.value = value;
		}			
		
}

public class TNode {
	private char key;
	private TNode left;
	private TNode right;
	
	public TNode(char k, TNode l, TNode r) {
		key = k;
		left = l;
		right = r;
		
	}
	
	public void setLeft(TNode l) {
		left = l; 
	}
	
	public void setRight(TNode r) {
		right = r; 
	}
	
	public void setKey (char k) {
		key = k;
	}

	public char getKey() {
		return key;
	}
	
	public TNode getLeft() {
		return left;
	}
	
	public TNode getRight() {
		return right;
	}
	
}
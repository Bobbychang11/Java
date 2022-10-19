public class TNode {
	private char key;
	private TNode left;
	private TNode right;
	
	public TNode(char c, TNode u, TNode v) {
		key = c;
		left = u;
		right = v;
		
	}
	
	public void setLeft(TNode u) {
		left = u; 
	}
	
	public void setRight(TNode u) {
		right = u; 
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
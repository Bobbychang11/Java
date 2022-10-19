/**
 * COM212 Data Structures
 *
 * Shorter version of binary tree to perform the given task
 *
 */

public class BSTNode {

	private String key;
	private String element;
	private BSTNode parent,left,right;

	public BSTNode(String k, String e, BSTNode p, BSTNode l, BSTNode r) {
		key = k;
		element = e;
		parent = p;
		left = l;
		right = r;
	} 

	public boolean isExternal() {
		return (left==null && right==null);
	}
	
	public boolean isInternal() {
		return !isExternal();
	}
	
	public BSTNode parent() { return parent; }
	
	public BSTNode left() { return left; }
	
	public BSTNode right() { return right; }
	
	public boolean hasLeft() {
		return (left!=null);
	}
	
	public boolean hasRight() {
		return (right!=null);
	}
	
	public void setParent(BSTNode v) {
		parent = v;
	}
	
	public void setLeft(BSTNode v) {
		left = v;
		if (v!=null)
			v.setParent(this);
	}
	
	public void setRight(BSTNode v) {
		right = v;
		if (v!=null)
			v.setParent(this);
	}
	
	public String element() { return element; }
	
	public void setElement(String e) { element = e; }
	
	public String key() { return key; }
	
	public void setKey(String k) { key = k; }
	
		
}
public class BST {

	private int size;
	private BSTNode root;
	
	
	public BST() {
		size = 0;
		root = null;
	}
	
	public int size() { return size; }
	
	public boolean isEmpty() {
		return (size==0);
	}
	
	public BSTNode root() { return root; }
	
	public void setRoot(BSTNode v) {
		if (size==0)
			size++;
			
		root = v;
	}
	
	
	
	public void insert(BSTNode v, String k, String e) {
		// where to insert?
		int comp = k.compareTo(v.key());
		
		// left
		if (comp < 0) {
			if (v.hasLeft())
				insert(v.left(), k, e);
			else {
				BSTNode newnode = new BSTNode(k, e, null, null, null);
				v.setLeft(newnode);
				size++;
			}
		}
		else if (comp > 0) {	// right
			if (v.hasRight())
				insert(v.right(), k, e);
			else {
				BSTNode newnode = new BSTNode(k, e, null, null, null);
				v.setRight(newnode);
				size++;
			}
		
		} else {	// self
			v.setElement(e);
		}		
	
	}
	
	public BSTNode search(BSTNode v, String k) {
	
		// compare key value
		int comp = k.compareTo(v.key());
		if (comp == 0)	// hit
			return v;
		else if (comp < 0) {	// left
			if (v.hasLeft())
				return search(v.left(), k);
			else
				return null;
		}
		else {
			if (v.hasRight())
				return search(v.right(), k);
			else
				return null;
		}
	
	}
	
	

	
	public void remove(BSTNode v) {
	
		// check error just in case
		if (v == null) {
			return;
		}
	
		// parent of v and see if v is left child or right child
		BSTNode vParent = v.parent();
		boolean isLeftChild = false;
		if (v != root)
			if (vParent.left() == v)
				isLeftChild = true;
		
		// internal node with both children
		if (v.hasLeft() && v.hasRight() ) {

			// have both children
			// find left most external of from right subtree of v
			BSTNode y = v.right();
			while (y.hasLeft() )
				y = y.left();
		
			// y has no left child
			// so it take v position & reconnect right child to candidate right
			BSTNode yParent = y.parent();
			if (v == root) {
				root = y;
				root.setLeft(v.left());
			}
			else {
				if (isLeftChild)
					vParent.setLeft(y);
				else
					vParent.setRight(y);
			}

			y.setLeft(v.left());

			if (yParent != v) {
				yParent.setLeft(y.right());
				y.setRight(v.right());
			
			}
		}
		// internal node with left child
		else if (v.hasLeft()) {
			if (v == root) {
				root = v.left();
				root.setParent(null);
			}
			else {
				if (isLeftChild)
					vParent.setLeft(v.left());
				else
					vParent.setRight(v.left());
			}
		}
		// internal node with right child
		else if (v.hasRight()) {
			if (v == root) {
				root = v.right();
				root.setParent(null);
			}
			else {
				if (isLeftChild)
					vParent.setLeft(v.right());
				else
					vParent.setRight(v.right());
			}
		}
		// external node
		else {
			if (v == root)
				root = null;
			else {
				if (isLeftChild)
					vParent.setLeft(null);
				else
					vParent.setRight(null);
			}
		}
		
		// unlink
		v.setParent(null);
		v.setLeft(null);
		v.setRight(null);
		
		size--;
	}
	
}







/*
import java.util.*;

public class BST<E>{
	
	private int size;
	private BSTNode<E> root;

	private String element;
	private String key;
	private BSTNode<E> right;
	private BSTNode<E> left;
	private BSTNode<E> parent;
	private String definition; 



	public BST(){
		size = 0;
		root = null;

	}
	


	public BSTNode<E> root(){ ///BSTNode
	
		return root;
	}

	private void Insert(String k, BSTNode<E> v, String def){

		if (v == null){
			v.setLeft(null);
			v.setRight(null); 
			v.setKey(key);
			v.setElement(definition); 
		}
		if (key.compareTo(v.getKey()) == -1){
			Insert(k, v.getLeft(), def);
		}

		if (key.compareTo(v.getKey()) == -1){
			Insert(k, v.getRight(), def);
		}
	
	}

	public BSTNode<E> search(BSTNode<E> v, String key){
		if(v == null){
			return null;
		}
		else if((key.compareTo(v.getKey()) == 0)){
			System.out.println(v.getElement());
			return v;
		}
		else if((key.compareTo(v.getKey()) == -1)){
			return search(v.getLeft(), key);
		}
		else if((key.compareTo(v.getKey()) == 1)){
			return search(v.getRight(), key);
		}
		else{
			return null;
		}
		}

	public Boolean isEmpty(){
		return (root == null);
	}

		
	}

*/


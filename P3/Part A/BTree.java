import java.util.*;
import java.io.*;

public class BTree {
    private TNode root;
	private int size;
	public String postfixExp;   
       //  needs a string to store the postfix (unlike in part B)

    public BTree() {
        root = null;
		size = 0;
		postfixExp = "";
    }

    public TNode getRoot() {
        return root;
    }

    public void setRoot(TNode r) {
        root = r;
        size++;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int s) {
        size = s;
    }

    public void addRight(TNode r, TNode v) {
        r.setRight(v);
        size++;
    }

    public void addLeft(TNode r, TNode l) {
        r.setLeft(l);
        size++;
    }

    public char set(TNode p, char e) {
        char old = p.getKey();
        p.setKey(e);
        return old;
    }

    public boolean isEmpty() {
        return root == null;
    }

    
    public void reset() {
        root = null;
    }

	public String postOrderTrav(TNode k) {
		if(k.getLeft() != null) {
			postOrderTrav(k.getLeft());
		}
		if(k.getRight() != null) {
			postOrderTrav(k.getRight());
		}
		postfixExp += k.getKey();   //  creates a string in postfix order
		return postfixExp;   //  returns postfix as string
	}

	public String getPostfix() {
		return postfixExp;
	}
}
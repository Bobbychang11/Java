import java.util.*;
import java.io.*;

public class BTree {
    private TNode root;
	private int size;
	public String postfixExp;   //  needs a string to store the postfix (unlike in part B)

    public BTree() {
        root = null;
		size = 0;
		postfixExp = "";
    }

    public TNode getRoot() {
        return root;
    }

    public void setRoot(TNode u) {
        root = u;
        size++;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int s) {
        size = s;
    }

    public void addLeft(TNode u, TNode v) {
        u.setLeft(v);
        size++;
    }

    public void addRight(TNode u, TNode v) {
        u.setRight(v);
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

	public String postOrderTrav(TNode v) {
		if(v.getLeft() != null) {
			postOrderTrav(v.getLeft());
		}
		if(v.getRight() != null) {
			postOrderTrav(v.getRight());
		}
		postfixExp += v.getKey();   //  creates a string in postfix order
		return postfixExp;   //  returns postfix as string
	}

	public String getPostfix() {
		return postfixExp;
	}
}
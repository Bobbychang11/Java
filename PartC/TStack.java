public class TStack {

    private PNode head;
    private int size;

    public TStack() {
        head = null;
        size = 0;
    }

    public PNode getHead() {
        return head;
    }

    public int getSize() {
        return size;
    }

    public void push(BTree t) {
        PNode u = new PNode(t, null);
		u.setNext(head);
		head = u;
		size++;
    }

    public BTree pop() {
		BTree item = head.getTree();
		head = head.getNext();
		size--;
		return item;
    }
    
    public BTree peek() {
		return head.getTree();
    }
    
    public boolean isEmpty() {
		return size == 0;
    }
}
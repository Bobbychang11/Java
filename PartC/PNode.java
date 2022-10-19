public class PNode {
    
    private BTree tree;
    private PNode next;

    public PNode(BTree t, PNode n) {
        tree = t;
        next = n;
    }

    public BTree getTree() {
        return tree;
    }

    public PNode getNext() {
        return next;
    }

    public void setTree(BTree t) {
        tree = t;
    }

    public void setNext(PNode n) {
        next = n;
    }
}
/** 
 * Class definition for a Node of a singly linked list of Game Entries. 
 */
public class Node {

	/* Note: these fields are public so that they can be directly accessed
	 * from outside this class.  For example, if v is a Node object, 
	 * then v.entry and v.next can be used to access these fields. */
	 
	private String edit;	//the high score entry 
	private Node next;		//refers to the next node in the list
	
	/** 
	 * Constructor: creates a node with the given entry and next Node. 
	 */
	public Node(String s, Node n) {
		edit = s;
		next = n;
	}


	public String getString(){
		return edit;
	}
	public Node getNext(){
		return next;
	}
	public void setNext(Node n){
		next = n;
	}
}
	



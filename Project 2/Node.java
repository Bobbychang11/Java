
public class Node {
	 
	private String edit;
    //creating a variable for string entered by user	
	private Node next;
	//refers to the next node in the list
    //These variables are only visible to the Node class
	 
	
	public Node(String p, Node m) {
    //Creating a method for Nodes
		edit = p;
		next = m;
    //Creates Node with element p and Next(node)M
	}


	public String getString(){
		return edit;
	}
	public Node getNext(){
		return next;
	}
	public void setNext(Node m){
		next = m;
	}
}
	



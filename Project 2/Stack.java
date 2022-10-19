public class Stack{


	private Node head;
	private int size;
    //Creating variables that can be used throughout the Stack class

	public Stack(){
		head = null;
		size = 0;
        //Creating an empty stack

	}

	public Node getHead(){
		return head;
	}

    public String pop(){
        //Creating a method for pop function
		String element = head.getString();
		head = head.getNext();
		size--;
		return element;
	}
	public boolean isEmpty(){
		return size == 0;
	}
	public int size(){
		return size;
    //Method will pop or take element off of stack 
	}
    public String peek(){
		return head.getString();
	}

	public void push(String change){
        //Creating a method for push function
		Node n = new Node(change, null);
		if(size == 10){
			Node current = head;
			for(int i=0;i<9;i++){
				current = current.getNext();
			}
			current.setNext(null);
		}
		n.setNext(head);
		head = n;
		size++;
    //Method will push or put on what the user inputs from the scanner
	}
	

}



public class Stack{


	private Node head;
	private int size;

	public Stack(){
		head = null;
		size = 0;

	}

	public Node getHead(){
		return head;
	}


	public void push(String edit){
		Node u = new Node(edit, null);
		if(size == 10){
			Node cur = head;
			for(int i=0;i<9;i++){
				cur = cur.getNext();
			}
			cur.setNext(null);
		}
		u.setNext(head);
		head = u;
		size++;
	}
	public String pop(){
		String item = head.getString();
		head = head.getNext();
		size--;
		return item;
	}
	public String peek(){
		return head.getString();
	}
	public boolean isEmpty(){
		return size == 0;
	}
	public int size(){
		return size;
	}

}



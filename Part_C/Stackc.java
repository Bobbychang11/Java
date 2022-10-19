public class Stackc{


	private Node head;
	private int size;

	public Stack(){
		head = null;
		size = 0;

	}

	public Node getHead(){
		return head;
	}


	public void push(int x){
		// if(isEmpty()){
		// 	Node v = new Node(c, null)
		// 	head = 
		// }
		Node u = new Node(x, null);
		u.setNext(head);
		head = u;
		size++;
	}
	public int pop(){
		int item = head.getValue();
		head = head.getNext();
		size--;
		return item;
	}
	public int peek(){
		return head.getValue();
	}
	public boolean isEmpty(){
		return size == 0;
	}
	public int size(){
		return size;
	}

}

class StackTest{
	public static void main(String[] args){
		Stackc c = new Stack();
		System.out.println(c.isEmpty());
		c.push('[');
		System.out.println(c.peek());
		c.push('(');
		System.out.println(c.peek());
		System.out.println(c.pop());
		System.out.println(c.peek());
	}
}



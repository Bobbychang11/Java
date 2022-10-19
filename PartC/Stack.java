/*
class BracketTest {
	public static void main(String[] args) {
		Stack cstack = new Stack(100);
		
		cstack.push('a');
		cstack.push('b');
		System.out.println(cstack.peek()+"");
		cstack.pop();
		System.out.println(cstack.peek()+"");
		cstack.isEmpty();
		cstack.size();
		System.out.println(cstack.peek()+"");
	}
}
*/

public class Stack {
	private int intStack[];
	private int top;
	
	public Stack(int size) {
		intStack = new int[size];
		top = -1;
	}
	
	public void push (int num) {
		top++;
		intStack[top] = num;
	}
	
	public int pop() {
		int popNum = intStack[top];
		top -= 1;
		return popNum;
	}
	
	public int peek() {
		return intStack[top];
	}
	
	public boolean isEmpty() {
		if (top == -1) {
			return true;
		}
		else
			return false;
	}
	
	public int size() {
		return top +1;
	}
}
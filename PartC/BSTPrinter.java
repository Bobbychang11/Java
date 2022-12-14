/**
 * COM212 Data Structures Project3.B utility class
 *
 * Print contents (key value) of Binary Search Tree
 *
 * Assume. BSTree class with BSTNode. BSTNode must have methods left(), right(), 
 *         key() defined
 *
 */


public class BSTPrinter {

	private static class BSTStack {
	
		private BSTNode [] nodes;
		private int size;
		
		public BSTStack() {
			size = 0;
			nodes = new BSTNode[128];
		}
	
		public void push(BSTNode v) {
			nodes[size++]=v;
		}
		public BSTNode pop() {
			if (size==0)
				return null;
			BSTNode n = nodes[size-1];
			size--;
			nodes[size]=null;
			return n;
		}
		public BSTNode top() {
			if (size==0)
				return null;
			return nodes[size-1];
		}
		public boolean isEmpty() {
			return (size==0);
		}
	
	}

	public static void printBST(BSTNode root) {
	
		BSTStack globalStack = new BSTStack();
		globalStack.push(root);
		int nBlanks = 32;
		boolean isRowEmpty = false;
		System.out.println(
		"......................................................");
		while(isRowEmpty==false)
		{
			BSTStack localStack = new BSTStack();
			isRowEmpty = true;

			for(int j=0; j<nBlanks; j++)
			System.out.print(' ');

			while(globalStack.isEmpty()==false)
			{
				BSTNode temp = (BSTNode)globalStack.pop();
				if(temp != null)
				{
					System.out.print(temp.key());
					localStack.push(temp.left());
					localStack.push(temp.right());

					if(temp.left() != null ||
							temp.right() != null)
					isRowEmpty = false;
				}
				else
				{
					System.out.print("--");
					localStack.push(null);
					localStack.push(null);
				}
				for(int j=0; j<nBlanks*2-2; j++)
				System.out.print(' ');
			}  // end while globalStack not empty
			System.out.println();
			nBlanks /= 2;
			while(localStack.isEmpty()==false)
			globalStack.push( localStack.pop() );
		}  // end while isRowEmpty is false
		System.out.println(
		"......................................................");
		
	
	}



}
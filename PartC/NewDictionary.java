import java.util.*;
import java.io.*;
import java.util.Random;
import java.util.*;

public class NewDictionary{

static private String key;
static BST tree = new BST();
private String value;

	public NewDictionary(){
	
	}

	public void command(String cmd){ // takes command string,tokenize,
// // and call corresponding method
// // (insert or search or printDic)
		Scanner s = new Scanner(System.in);
		System.out.println("Commands: insert (insert word definition), search (word), print");	System.out.println("Please enter a command:");
		String input = s.nextLine();
	}


	public void search(String k){ 
// 	// given word key found, then print its definition (element value)
 		String key = k;
 		search(k); 
	}
	public void insert(String k, BSTNode v, String def){
 		insert(k, v, def);
 	}




// // insert or search node in BST, you need to compare key value to determine where
// // to insert a new node or find key value
 

	public static void main(String[] args) {
		BST tree = new BST();
		boolean quit = false;
		while(quit == false){
			String [] r;
			Scanner i = new Scanner(System.in);
			//Using Scanner to take in input    
			System.out.print("Enter command: "); 
			//Print statement to prompt user to type edit command
			String commands = i.nextLine();      
			//Stores command in next Node; Starts at head
			r = commands.split(" ");
			String command = r[0];
			String word;
			String definition;


			if(command.equals("search")){
				word = r[1];
				definition = " ";
				if(tree.size() == 0){
					System.out.print("The tree is empty."+"\n"); 
					System.out.print(" ");
				}
				else {
					Object val = tree.search(tree.root(), word);
					if (val == null){
						System.out.print("no definition for, "+word+", found"+"\n");
					}
					else {
						val = tree.search(tree.root(), word).element();
						System.out.print("result>" +val+"\n");
					}
					//if (tree.search(tree.root(), word) = true) {
					//	System.out.print(definition);
					//}
					//else {
					//	System.out.print("not found");
					//}
				}
			}
			else if(command.equals("insert")){

  				word = r[1];
  				definition = " ";

  				for (int j=2; j <r.length; j++) {
 					definition = definition + " " + r[j];
 				}
		 		if(tree.size() == 0){
					BSTNode temp = new BSTNode(word, definition, null, null, null);
			 		tree.setRoot(temp);
				}
		 		else{
					tree.insert(tree.root(), word, definition);
				}
				System.out.print("result> word, "+word+", was inserted"+"\n");

 			}
			else if(command.equals("quit")){
				quit = true;
			}
			else if(command.equals("print")){
				System.out.println("result> current contents of dictionary:");
				tree.printInorder(tree.root()); 
			}
			else{
				System.out.println("That was not a usable command, try again."+"\n");
			}
		}
		System.out.println("Good-bye!");
     }
}

	 

 
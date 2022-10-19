import java.io.*;
import java.util.Scanner;
public class PhotoshopEditInterface{
	public static void main(String[] args){
		PhotoshopEdit e = new PhotoshopEdit();
        boolean quit = false;

        while(quit == false) {   
        // while loop that takes one of the input commands at a time
            Scanner i = new Scanner(System.in);
        //Using Scanner to take in input    
            System.out.print("Type edit command> "); 
        //Print statement to prompt user to type edit command
            String command = i.next();          
        //Stores command in next Node; Starts at head

            if(command.equals("quit")) {  
                quit = true; 
            //When quit command is entered program is closed
            }
            else if(command.equals("undo")) {   
            //Using command undo to activate if statement
                if(e.history.size() == 0) {  
                    System.out.println("Edit history is empty, undo unavailable");
                //if stack is empty the undo command has nothing to undo
                }
                else {
                    //r = 1
                    System.out.println("result:"+ e.history.pop() + " command" + " undone"); 
            //Does the undo command which just pops off head of stack
                }
            }

            // else if(command.equals("redo")){  
//     if( r == 1){
//         e.history.push(saver);
//         r = 0;
//         System.out.println("result:" + saver + " command" + " added back");
    
//     }
//     else{
//         System.out.println("result: There is no command to add back");
//     }
// }
            else {  
                e.history.push(command);
            //adds user input command to stack
            }
        }
	}

}
// else if(command.equals("redo")){  
//     if( r == 1){
//         e.history.push(saver);
//         r = 0;
//         System.out.println("result:" + saver + " command" + " added back");
    
//     }
//     else{
//         System.out.println("result: There is no command to add back");
//     }
// }
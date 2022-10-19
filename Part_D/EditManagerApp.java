import java.io.*;
import java.util.Scanner;
public class EditManagerApp{
	public static void main(String[] args){
		EditManager e = new EditManager();
        boolean quit = false;
        while(quit == false) {   //  loop that takes one command each iteration
            Scanner s = new Scanner(System.in);        //  takes command from user
            System.out.print("Type edit command> ");   //  and stores it to
            String command = s.next();                 //  the variable command

            if(command.equals("quit")) {   //  quits program when command is quit
                quit = true;   
            }
            else if(command.equals("undo")) {   //  handles 'undo' command
                if(e.history.size() == 0) {   //  if stack is empty, undo cannot be performed
                    System.out.println("Sorry! Edit history is empty.");
                }
                else {
                    System.out.println("result > undone " + e.history.pop() + " command");   //  performs undo
                }
            }
            else {   //  adds command to history Stack
                e.history.push(command);
            }
        }
	}

}
import java.io.*;
import java.util.Scanner;

//This class maintains input histories
public class PostFix {
    //private instance variables
    private int[] operator = {'+', '-', '*', '/'};

    //check if the item is a arithemetic operator
    public boolean isOperator(int o)  {
        for (int i=0; i<operator.length; i++) {
            if (o == operator[i]) {
                return true;
            }
        }
        return false;
    }

    //a method that convert char to int
    public int intAt(char c, int index)
    {
        //convert char to string
        String str = Character.toString(c);
        //convert string to int
        int value = Integer.parseInt(str);
        return value;
    }

    //the calculator for the post fix notation
    public int calculate(String s){
        //initialize a new stack that stores the input
        Stack input = new Stack(100);
        //loop through the input post fix notation
        for (int i = 0; i < s.length(); i++) {
            //if s[i] is a number, push it into the stack
            if (!isOperator(s.charAt(i))) {
                input.push(intAt(s.charAt(i),i));
                //System.out.println(input.peek());
            }
            //if s[i] is a arithmetic operator
            else if (isOperator(s.charAt(i))) {
                //pop 2 numbers from the stack
                int pop1 = input.pop();
                int pop2 = input.pop();
                //perform the arithmetic calculation
                if(s.charAt(i)=='+'){
                    int result = pop1+pop2;
                    //and then push the result back into stack
                    input.push(result);
                }
                else if(s.charAt(i)=='-'){
                    int result = pop1-pop2;
                    input.push(result);
                }
                else if(s.charAt(i)=='*'){
                    int result = pop1*pop2;
                    input.push(result);
                }
                else if(s.charAt(i)=='/'){
                    int result = pop1/pop2;
                    input.push(result);
                }
            }
        }
        //return the value left on top of the stack
        //after the whole post fic notation is looped through
        return input.peek();
    }
}
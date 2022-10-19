import java.io.*;
import java.util.Scanner;
import java.util.*; //for enhanced postfix calculator
public class PemdasStacker{
	private Node head;
	private int size;
	public char[] mathSigns = {'+','*','-','/'};
	public Stack y;
	

	/* 
	 * Constructor 
	 */
	public PemdasStacker(){
		head = null;
		size = 0;
		y = new Stack();
	}

	public boolean isMath(char c){
		for(int i = 0; i < mathSigns.length; i++){
			if(c == mathSigns[i])
				return true;
		}
		return false;
	}

	public int[] getNumbers(){
		int two = y.pop();
		int one = y.pop();
		if(two >= 10){ //if it's greater than 10, it has to be an ASCII value so I need to convert back to normal 
			two = Character.getNumericValue(two);
		}
		if(one >= 10){
			one = Character.getNumericValue(one);
		}
		// System.out.println(one+" "+two);
		int[] numbers = {one, two};
		return numbers;

	}

	public int performOperation(int firstNum, char symbol, int secondNum){
		System.out.println(symbol);
		int output = 0;
		
		if(symbol == mathSigns[0]){
			output = (firstNum+secondNum);
			// System.out.println("hi");
		}
		else if(symbol == mathSigns[1]){
			output = (firstNum*secondNum);
		}
		else if(symbol == mathSigns[2]){
			output = (firstNum-secondNum);
		}
		else if(symbol == mathSigns[3]){
			output = (firstNum/secondNum);
		}
		
		
		return output;
	}


	


	public int enhancedMath(String s){
		for(int i = 0; (i < s.length()); i++){
			String concatenate = "";
			if(!(Character.isSpaceChar(s.charAt(i))) && !isMath(s.charAt(i))){
				concatenate.concat(Character.toString(s.charAt(i)));

				
				// y.push(s.charAt(i));
			}
			else{
				if(!concatenate.equals("")){
				System.out.println("this is"+" "+concatenate);
					int newInt = Integer.parseInt(concatenate);
					y.push(newInt);
				}
				concatenate = "";
				if(isMath(s.charAt(i))){
					int numbers[] = getNumbers();
					int first = numbers[0];
					int second = numbers[1];
					int complete = performOperation(first, s.charAt(i), second);
					y.push(complete);
					System.out.println(y.peek());
				}
			}

		}
		return y.peek();
			
	}


	public int addMath(String s){
		for(int i = 0; (i < s.length()); i++){
			if(!isMath(s.charAt(i))){
				
				y.push(s.charAt(i));

				
			}
			else if(isMath(s.charAt(i))){
				int numbers[] = getNumbers();
				int first = numbers[0];
				int second = numbers[1];
				int complete = performOperation(first, s.charAt(i), second);
				y.push(complete);
				System.out.println(y.peek());
			}

		}
		return y.peek();
			
	}



}










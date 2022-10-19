import java.util.Scanner;

public class MyArray {
    //Creating class MyArray
    private int[] numArray;
    private int max;
    private int c = 0;
    //Making instance variables to use through out code
    //Creating array;max size for array;counter variable

    public MyArray(int max) {
        numArray = new int[max];
        this.max = max;
        //Creating the array size;making numArray size of given value;
        //Making max used in this method = given Array size
    }

    public int findMax(){
        //Function to find largest value in Array
        if(c == 0){
            return-1;
            //-1 will return if array is empty to show Array is empty
            }
            else{
                //if the array isnt empty 
                int  largest = numArray[0];
                for(int i=1; i <  c; i++){
                    //give variable an element position to begi c;
                    //searchs through the entire array
                    if(numArray[i] >  largest)
                     largest = numArray[i];
                    //if a new largest is found it is assigned  largest
                }
                return  largest;
                //final largest returned 



     }
    }

    public int findMin(){
        if(c == 0){
            return -1;
        }
        //if the array is empty -1 will return 
        else {
            //if array has elements else runs
            int smallest = numArray[0];
            for(int i = 1; i <  c; i++){
                if(numArray[i] < smallest)
                smallest = numArray[i];
                //creates a starting point for variable;searches through array
                //if new lowest element if found it is set equal to smallest
            }
            return smallest;
            //returns lowest element
        }

    }


     public boolean findVal(int value){
        //function created to search array for given value
         if(c == 0)
             return false;
             //if the array is empty then value cant be there, false will return
         else
         //if array has elements function will search through array
         {
             for(int i = 0; i < c; i++){
                 if(numArray[i] == value){
                     return true;
                     //searches through array; if value is found true is returned
                 }
             }
             return false;
             //if value is not found false returns
         }
     }




     public int total(int sum) {
         //function created to find total value of array
         //sum is created to hold integer
         sum = 0;
         for (int counter = 0; counter < numArray.length; counter++) {
             sum += numArray[counter];
             //searches the array;collects each elements data and adds it together

         }
         return sum;
         //returns the total value of the array
     }

      public double average(){
        //Creating a function to average the elements of the array
          double tot = 0;
          for(int i = 0; i < c; i++) {
              tot = tot + numArray[i];
        //creating a double variable to see the decimal point of average;
        //searches array and adds all elements together
          }
          double average = tot/c;
          return average;
        //takes total value of array and devides it by the number of elements in the array
        //returns the average of the arrayjava
      }


           public int add(int given){
        //function to insert given value
        if(c ==0){
            numArray[c] = given;
            c = c+1;
        //if the array empty element position c gets assigned given value
    }
    else if (c < max){
        numArray[c] = given;
        c = c+1;
        //postition c of array gets assigned the given value
    }
    return c;
    //returns variable to show max array size
}


         public boolean remove(int removeVal){
        //creating function that removes given value
        for(int i = 0; i < c; i++){
            if (numArray[i] == removeVal){
                //searches through the array and if value is found if statement runs
                numArray[i] = numArray[c-1];
                c = c-1;
                //sets element found to end of array and removes it
                return true;
                //if found and removed return true
            }
        }
        return false;
        //if not found return false
    }
    

     public int removeMax(){
         //Creating function to remove max integer
         if(c == 0){
             return -1;
             //if there are no elements in the Array return -1 to show array is empty
         }
         else{
             //if the array contains elements else runs
             int removeCMax = numArray[0];
             for(int i = 1; i < c;){
                 //creates a starting element so the for loop can search through the array
                 if(numArray[i] > removeCMax){
                     removeCMax = numArray[i];
                     //if a new element is larger than previous removeCmax it replaces old element
                     numArray[i] = numArray[c-1];
                     c = c-1;
                     //putting largest element at the end of the array;
                     //removing that element from array

                 }
             }
             return removeCMax;
             //the largest element is removed and returned
         }
     }


     public int removeMin(){
         //creating function to remove smallest element
         if(c == 0){
             return -1;
             //if the array is empty return -1 to show array is empty
         }
         else{
             //if array has elements run else
             int removeCMin = numArray[0];
             for(int i = 1; i < c; i++){
                 //gives variavle a starting element
                 //searches through array to find smallest element
                 if(numArray[i] < removeCMin){
                     removeCMin = numArray[c-1];
                     //if a new smallest element is found given position numArray[i]
                     //sets smallest element to end of array
                     c = c-1;
                     //removes last value of the array(smallest)
                     
                 }
             }
             return removeCMin;
         }
     }


     public void reverse(){
         //function that reverses the array
         int[] numArray1 = new int[c];
         int length = c;
         //creats new array same length as old one
         for(int i = 0; i < c; i++){
             //searches through the array
             numArray1[length-1] = numArray[i];
             length = length - 1;
             //elements from the begining of the array are swaped with those at the end of the array
             //variable is updated
         }
     }



     public boolean allDistinct(){
         //Creating a function that searches array for repeating values
         for(int i = 0; i < c; i++){
             for(int j = i + 1; j < c; j++){
                 //Two for loops one to track c variable other to track j
                 if(numArray[i] == numArray[j]){
                     return false;
                    //if a repeating element is found false is returned
                 }
             }
         }
         return true;
         //if no repeating elements true is returned
     }


  public void display(){
        for(int i = 0; i < c; i++){
            System.out.println(numArray[i]);
        }
    }




 public static void main(String[] args){
     //MyArray test

         Scanner myObj = new Scanner(System.in);
         System.out.println("Enter the Array max size ");

         int max = myObj.nextInt();
         //collets given array size and applys it to array


         MyArray array = new MyArray(10);
         array.add(5);
     array.add(5);
     array.add(5);
     array.add(5);
     array.add(5); 
     array.add(10);
     array.add(5);
     array.add(5);
     array.add(5);
     array.add(5);

     int m = array.findMax();
     System.out.println("The largest element in the array is:" + m);
     //Print statement for Max

     int s = array.findMin();
     System.out.println("The smallest elemnent in the array is:" + s);
     //Print statement for Min


         Scanner myObj2 = new Scanner(System.in);
         System.out.println("Enter integer you would like to search array for");

         int search = myObj2.nextInt();

         boolean b = array.findVal(search);

         System.out.println(b);
         //Print statement to find value given

         double a = array.average();
         System.out.println("The average of the array is:" + a);
         //Print statement to show the average of the array


         Scanner myObj3 = new Scanner(System.in);
         System.out.println("Enter integer you would like to add to the array");

         int add = myObj3.nextInt();
         //Adds given integer to the array

        Scanner myObj4 = new Scanner(System.in);
         System.out.println("Enter integer you would like to remove from the array");

         int del = myObj4.nextInt();

         boolean d = array.remove(del);
         System.out.println(d);
         //Print statement to remove given value


        //  System.out.println(removeMax);
        //  //*Statement to remove Max

    
        //  System.out.println(removeMin);
        //  //*Statement to remove Min

        //  //reverse order the array
         

         
        //  System.out.println(allDistinct);
         
         //print array from 0-last
        //  for (int c = 0; c < array.length; c++) {  
        //     System.out.print(array[c] + " ");  

        //Commented a few out so the code wouldnt get caught was unable to figure out why. 






 }
}


      
     
     


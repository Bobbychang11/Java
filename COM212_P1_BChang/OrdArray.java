import java.util.Scanner;

public class OrdArray{
    private int c; 
    private int max; 
    private int[] ordArray; 
//Creating variables that can be used throughout code
    public OrdArray(int size){ //constructor which creates size of array
        c = 0;
        max = size;
        ordArray = new int[size];
        //setting the variable to 0; collects the given max size
        //Creats an empty array size given
    }


    public int add(int given){
        //function to insert given value
        if(c ==0){
            ordArray[c] = given;
            c = c+1;
        //if the array empty element position c gets assigned given value
    }
    else if (c < max){
        ordArray[c] = given;
        c = c+1;
        //postition c of array gets assigned the given value
    }
    return c;
    //returns variable to show max array size
}



    public void sort(){
        //function created to sort the array
        for(int i = 0; i < c; i++){
            //for loop to keep track of variable c
            for(int j = i +1; j < c;j++){
                //for loop to keep track of variable j
                if (ordArray[i] > ordArray[j]){
                    int tempLargest = ordArray[i];
                    ordArray[i] = ordArray[j];
                    ordArray[j] = tempLargest;
                    //if element i is larger than element j, i will become tempLargest
                }
            }
        }
    }



    public boolean find(int binary) {
        //function to search sorted array
        int left = 0;
        int middle;
        int right = c - 1;
        //left is equal to smallest element;Rigt is the largest value
        //Middle is point to start binary search
        while(left <= right) {
            middle = (left + right) / 2;
            //making sure array is sorted and finding middle point
            if(ordArray[middle] == binary) {
                return true;
                //if value find in list return true
            } else if(ordArray[middle] < binary) {
                left = middle + 1;
                //element left of middle is larger then middle sets new largest
            } else if(ordArray[middle] > binary) {
                right = middle - 1;
                //element right of arrau is smaller new smallest point will be set

            }
            // System.out.println(left);
            // System.out.println(right + "\n");
            //Code getting stuck tried to use printstatments to figure out where
        }
        return false;
        //if given value non existant return false
    }




    public boolean remove(int removeVal){
        //creating function that removes given value
        for(int i = 0; i < c; i++){
            if (ordArray[i] == removeVal){
                //searches through the array and if value is found if statement runs
                ordArray[i] = ordArray[c-1];
                c = c-1;
                //sets element found to end of array and removes it
                return true;
                //if found and removed return true
            }
        }
        return false;
        //if not found return false
    }





    public void display(){
        //created to display the array
        for(int i = 0; i < c; i++){
            System.out.println(ordArray[i]);
            //searches through array and prints elements sorted
        }
    }



 

      public static void main(String[] args){
          //OrdArray test

                   Scanner myObj = new Scanner(System.in);
         System.out.println("Enter the Array max size ");

         int max = myObj.nextInt();
         //collets given array size and applys it to array

         OrdArray ordA = new OrdArray(max);
         ordA.add(10);
         ordA.add(3);
         ordA.add(5);
         ordA.add(2);
         ordA.add(9);
         ordA.add(3);
         ordA.add(8);
         ordA.add(10);
         ordA.add(6);
         ordA.add(4);
         ordA.add(1);


         Scanner myObj1 = new Scanner(System.in);
         System.out.println("Enter integer you would like to add to the array");

         int add = myObj1.nextInt();
         //Adds integer to the array


         Scanner myObj2 = new Scanner(System.in);
         System.out.println("Enter integer you would like to search array for");

         int search = myObj2.nextInt();

         boolean b = ordA.find(search);

         System.out.println(b);
         //searches array for given value


        



         Scanner myObj3 = new Scanner(System.in);
         System.out.println("Enter integer you would like to remove from the array");

         int del = myObj3.nextInt();

         boolean d = ordA.remove(del);
         System.out.println(d);
         //removes given integer


        //  System.out.println(Arrays.toString(OrdArray));
        //  //prints array 
        //Comented out so code and compress wasnt able to get to work
         














      }
}
    
        //Insert given value
        //Do binary search to find given value
        //Remove given value; return true; if value not present return false
        // print elements 0-last





    



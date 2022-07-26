import java.util.Arrays;
import java.util.Scanner;
import java.time.*;

/**
*@param ArrayFile is an object of the class ArrayFile that holds the 5000+ element array to search through

*@param a[] is the array that ArrayFile injects the elements of the array into

*@param scn is a scanner used to scan user input for the search number 

*@param x is the variable that holds user input value 

*@param arrLength is the variable that holds the length of the array 

*@param tBin is the varaible that holds the time (in nanoseconds) of the binarySearch execution 

*@param bSearch holds the value returned by the binarySearch method

*@param tLin is the varaible that holds the time (in nanoseconds) of the linearSearch execution 

*@param lSearch holds the value returned by the linearSearch method
*/

class Main {
  public static void main(String[] args) 
  {
    //Initial array with all the numbers stored to sort through 
    ArrayFile t = new ArrayFile();
    int a[] = t.arrayMethod();
    Scanner scn = new Scanner(System.in);
    System.out.print("Choose a number you would like to search: ");
    int x = scn.nextInt();
    int arrLength = a.length;

    //Code for binary search starts
    long tBin = System.nanoTime();
    int bsearch = binarySearch(a, 0, arrLength, x, tBin, 0);
    System.out.println("Binary Search Element: " + bsearch);
    //code for binary search ends

    //code for linear search starts
    long tLin = System.nanoTime();
    int lsearch = linearSearch(a, x, 0, tLin, 0);
    System.out.println("Linear Search Element: "+ lsearch);
    //code for linear search ends

    
  }

/**

*This method uses the binary search algorithm to search through an array of x   
  length. It splits the array in half each time dependiong on wether the value   
  is smaller or larger than the current index. 
  
  *@param arr[] is an array with all the numbers to search through 
  *@param s is the int that keeps track of which side of the array we transverse 
   through
  *@param arrayLength is the int that holds the length of the array
  *@param x is the number the user is searching for 
  *@param startTime keeps track of the start time of the method execution
  *@param stopTime is when the method stops execution and returns the value or -1
  *@param elapsedTime is the difference between stop and start times of the search
*/

public static int binarySearch(int arr[], int s, int arrayLength, int x, long startTime, int comparisons)
  {
    if (arrayLength >= s) {
      //keeps track the initial, left or right middle
      int mid = s + (arrayLength - s) / 2;
      // if element is equal, it is present in the middle
      if (arr[mid] == x){
        comparisons++;
        long stopTime = System.nanoTime();
        long elapsedTime = stopTime - startTime;
        System.out.println("\n\nBinary Time: " + elapsedTime + " ns --  " + ((float)elapsedTime / 1000000) + " ms");
        System.out.println("Comparisons: " + comparisons);
        return mid;
        }
        // if element is smaller, it is present on the left side
        if (arr[mid] > x)
          return binarySearch(arr, s, mid - 1 , x, startTime, comparisons + 1);
        // Else move to the right to check for the element
        return binarySearch(arr, mid + 1, arrayLength, x, startTime, comparisons + 1);
        }
 
    // when here, the element is not present in the array
    long stopTime = System.nanoTime();
    long elapsedTime = stopTime - startTime;
    System.out.println("\n\nBinary Time: " + elapsedTime + " ns --  " + ((float)elapsedTime / 1000000) + " ms");
    System.out.println("Comparisons: " + comparisons);
    return -1;
    }
/**
* This method searches through the array linearly. 

  *@param arr[] is an array with all the numbers to search through 
  *@param x is the value the user is looking for
  *@param n is the position of the current element the method is looking at
  *@param startTime keeps track of the start time of the method execution
  *@param stopTime is when the method stops execution and returns the value or -1
  *@param elapsedTime is the difference between stop and start times of the searchs

*/
  public static int linearSearch(int arr[], int x, int n, long startTime, int comparisons)
  {
    //if value doesnt exist in the array, returns -1
     if (n > arr.length - 1)
    {
          comparisons++;
          long stopTime = System.nanoTime();
          long elapsedTime = stopTime - startTime;
          System.out.println("\n\nLinear Time: " + elapsedTime + " ns --  " + ((float)elapsedTime / 1000000) + " ms");
          System.out.println("Comparisons: " + comparisons);
          return -1;
    }

       //if value does, checks each element to compare
    else 
    {
      //if found return n 
    if (arr[n] == x)
    {
      comparisons++;
      long stopTime = System.nanoTime();
      long elapsedTime = stopTime - startTime;
      System.out.println("\n\nLinear Time: " + elapsedTime + " ns --  " + ((float)elapsedTime / 1000000) + " ms");
      System.out.println("Comparisons: " + comparisons);
      return n;
    }
      //if not found move to the next index (n + 1)
    else
    {
    return linearSearch(arr, x, n + 1, startTime, comparisons + 1);
    }
    }
  }
}

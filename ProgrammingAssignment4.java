/* Description: This program reads input from user to set the size of two arrays and reads input for the elements of each array. The program then sorts in ascending
 * 				order the elements of each array. The program then merges the elements of each array into one array using logic where the smaller of the two elements
 * 				is added to the new array. The program then displays 
 * Author: Jeremy Reinert
 * Date: 11/26/2018
 * Version: 1.0
 * 
 * STEP 1: Prompt user to enter the size of each array and read inputs for each element of each array
 * STEP 2: Sort in ascending order the elements of each array
 * STEP 3: Merge the elements of each array into one new array
 * STEP 4: Display the new merged array to the console
 */

// Import Java scanner library
import java.util.Scanner;
public class ProgrammingAssignment4 {
	
	//Declare/initialize global scanner variable to read input throughout all methods in program
	public static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {
		// Declare variables and arrays
		int n;
		int a[];
		int b[];
		int c[];
		
		// STEP 1: Prompt and read user input
		// Prompt user to enter the size of the first array
		System.out.println("Please enter an integer for the size of the first array");
		n = input.nextInt();
		
		// Call readArray method to create new array of size n, store n integers in it, and store it in array a
		a = readArray(n);
		
		// Prompt user to enter the size of the second array
		System.out.println("Please enter an integer for the size of the second array");
		n = input.nextInt();
		
		// Call readArray method to create new array of size n, store n integers in it, and store it in array b
		b = readArray(n);
		
		// STEP 2: Sort arrays
		// Call arraySort method to sort arrays a and b using selected sort algorithm
		arraySort(a);
		arraySort(b);
		
		// Display the arrays entered by the user
		System.out.println("The elements of the first array are: ");
		for(int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		
		System.out.println();
		System.out.println("The elements of the second array are: ");
		for(int i = 0; i < b.length; i++) {
			System.out.print(b[i] + " ");
		}
		
		System.out.println();
		
		// STEP 3: Merge arrays into one new array
		// Call merge method to sort array a and array b and store in sorted values in c
		c = merge(a, b);
		
		// STEP 4: Display merged array
		// Call displayArray method to display the values in the merged array c to the console
		displayArray(c);
	}
	
	// Method to read n integers, store integers in an array of n size, and return the array to the main method
	public static int[] readArray(int n) {
		// Declare new array with size n
		int[] numberArray = new int[n];
		
		// Prompt user to enter n integers to be stored in the array
		System.out.println("Please enter " + n + " integers");
		
		// Store integers into the array
		for(int i = 0; i < numberArray.length; i++) {
			numberArray[i] = input.nextInt();
		}
		
		// Return the array to the main method
		return numberArray;
	}
	

	// Method to sort each array in ascending order using selected sort algorithm
	public static void arraySort(int[] array) {
		// Declare variables
		int currentMin, currentMinIndex;
		
		// 
		for(int i = 0; i < array.length - 1; i++) {
			currentMin = array[i];
			currentMinIndex = i;
			
			// Check if currentMin above is greater than value at array[j] and if so, set currentMin to array[j] and currentMinIndex to j
			for(int j = i + 1; j < array.length; j++) {
				if(currentMin > array[j]) {
					currentMin = array[j];
					currentMinIndex = j;
				}
			}
			
			// Check if currentMinIndex does not equal i and if so, set value of array[currentMinIndex] to array[i] and array[i] to currentMin value
			if(currentMinIndex != i) {
				array[currentMinIndex] = array[i];
				array[i] = currentMin;
			}
		}
	}
	
	// Method to merge arrays and return a new array with the elements of the merged arrays to the main method
	public static int[] merge(int[] a, int[] b) {
		// Declare new array c to the size of the length of a + the length of b
		int[] c = new int[a.length + b.length];
		
		// Declare and initialize variables
		int i, j, k;
		i = 0;
		j = 0;
		k = 0;
		
		// Check if a[i] or b[j] is smaller while both i is less than the size of array a and j is less than the size of array b
		while(i < a.length && j < b.length) {
			// Check if a[i]] is less than or equal to b[j] and if so, set c[z] to a[i] and increment i and k
			if(a[i] <= b[j]) {
				c[k] = a[i];
				i++;
				k++;
			}
			
			// Check if b[j] is less than a[i] and if so, set c[z] to b[j] and increment j and k
			else if(b[j] < a[i]) {
				c[k] = b[j];
				j++;
				k++;
			}
		}
		
		// Check if a[i] or b[j] is smaller while i is less than the size of array a or j is less than the size of array b
		while(i < a.length || j < b.length) {
			// Check if a[i]] is less than or equal to b[j] and if so, set c[z] to a[i] and increment i and k
			if(i < a.length) {
				c[k] = a[i];
				i++;
				k++;
			}
			// Check if b[j] is less than a[i] and if so, set c[z] to b[j] and increment j and k
			else if(j < b.length) {
				c[k] = b[j];
				j++;
				k++;
			}
		}
		
		// Return the array to the main method
		return c;
		}

	// Method to display the merged array to the console
	public static void displayArray(int[] input) {
		
		// Display elements of array input to the console
		System.out.println("The elements of the merged array are: ");
		for(int i = 0; i < input.length; i++) {
			System.out.print(input[i] + " ");
		}	
	}
}



import java.util.*;

public class Lab9 {
	public static int swapCount = 0;
    /**
     * Helper method for printing out arrays.
     * @param int[] arr Array of integers to print
     */
    public static void printArray(int[] arr) {
		System.out.print("[ ");
		for (int j=0; j < (arr.length - 1); j++) {
		    System.out.print(arr[j] + ", ");
		}
		if (arr.length > 0) {
		    System.out.print(arr[arr.length - 1]);
		}
		System.out.println(" ]");
		    
    }

    /**
     * Swap two elements in an array
     * @param int[] arr - the array
     * @param int index1 - the index of first element to swap
     * @param int index2 - the index of the second element to swap
     */

    public static void swap(int[] arr, int index1, int index2) {
		if (index1 == index2) {
		    // Do nothing!
		} else {
		    int tmp = arr[index1];
		    arr[index1] = arr[index2];
		    arr[index2] = tmp;
		    swapCount ++;
		}
    }

    /**
     * Sort an array in ascending order using the Selection Sort algorithm
     * @param int[] arr - the array
     */
    
    public static void selectionSort(int[] arr) {
		swapCount = 0;
		if (arr.length < 2) {
		    return;
		}
		
		int minIndex = 0;
		int minVal = 0;
	
		for (int j = 0; j < (arr.length-1); j++) {
	
		    minIndex = j;
		    minVal = arr[j];
		    for(int k = j + 1; k < arr.length; k++) {
	
				if (arr[k] < minVal) {
		
				    minVal = arr[k];
				    minIndex = k;
				}
		    }
		    swap(arr, j, minIndex);
		    printArray(arr);
		}
		System.out.print("Selection sort: ");
		printArray(arr);
		System.out.println("Swaps = " + swapCount);
    }
    
    /**
     * Sort an array in ascending order using the Bubble Sort algorithm
     * @param arr - array
     */
    public static void bubbleSort(int[] arr) {
    	swapCount = 0;
		if (arr.length < 2) {
		    return;
		}
		
		int index = 0;
		for (int i = 0; i < arr.length; i ++) {
			System.out.printf("\nInteration %d:\n",i);
			for (int j = 0; j < (arr.length-1); j++) {
				// Swap values if next value in array is less than current value
			    if (arr[j+1] < arr[j]){
			    	index = j+1;
			    	printArray(arr);
			    	swap(arr, j, index);
			    	
			    }
			        
			}
		}
		printArray(arr);
		System.out.print("Bubble sort: ");
		printArray(arr);
		System.out.println("Swaps = " + swapCount);
    }
    
    /**
     * Creates deep copy of a1 array
     * @param arr - original array
     * @return - new array
     */
	public static int[][] deepCopy(int[][] arr) {
    	int[][] newArr = new int[arr.length][];
    	for (int i = 0; i < newArr.length; i++)
    	     newArr[i] = Arrays.copyOf(arr[i], arr[i].length);
    	return newArr;
    }

    public static void main(String[] args) {
		int[][] a1 = { {8, 9, 5, 6, 4, 3},
			       {9, 0, 14, 13, 10, 8, 2, 1, 17, 18, 19, 201, 220, 235, 2},
			       {100, 200, 300, 400, 500, 600, 700, 800, 900, 1000, 1100, 1200 },
			       {22, 24, 26, 28, 30, 32, 34, 36, 38, 40, 1},
			       {20, 18, 13, 12, 11, 9, 6, 5, 4, 3, 2, 1, -87, -900, -9, -909, -911, -80, -44, -32, -1000} };
		
		
		
		int[][] a2 = deepCopy(a1);
	
		/*System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		for (int i = 0; i < a1.length; i++){
			selectionSort(a1[i]);
		}*/
		selectionSort(a1[0]);
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		bubbleSort(a2[0]);
		
		/*System.out.println("A1: ");
		for (int i = 0; i < a1.length; i ++) {
			printArray(a1[i]);
		}
		
		System.out.println("A2: ");
		for (int i = 0; i < a2.length; i ++) {
			printArray(a2[i]);
		}*/
    }

    
}
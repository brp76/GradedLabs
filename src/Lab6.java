import java.util.*;
import java.io.*;
public class Lab6 {
	public static char[] generateUniverse(int size) { // Generate array for universe
		char [] A = new char[size];
		for (int i = 0; i < size; i++)
			A[i]='.';
		// Initialize Carrots
		for (int j = 5; j < size; j += 5)
			A[j]='^';
		// Initialize Numericons (If overlap, overwrite carrots)
		for (int k = 0; k < size; k += 7)
			A[k]='0';
		return A;
	}

	public static void advanceUniverse(char [] u) { // Advance universe by growing and shifting Numericons
		for (int i = u.length-1; i >= 0; i--){ // Iterate through array backwards to avoid unnecessary changes
			char value = u[i];
			switch (value){
			case '0':  // Baby to child
				u[i] = '1';
				break;
			case '1':  // Child to adult
				u[i] = '2';
				break;
			case '2':  // Shift/rejuvenate adults
				if (i+1 < u.length){
					if (u[i+1] == '.' && u[i] == '2') { // Shift
						u[i] = '.';
						u[i+1] = '2';
					} else if (u[i+1] == '^' && u[i] == '2') { // Eat carrot				
						u[i] = '.';
						u[i+1] = '0';
					}
				}			
				break;
			default:
				break;
			}	
		}
	}
	
	public static void saveUniverse(char [] u) throws IOException { // Create and write universe to file
		PrintWriter out = new PrintWriter("universe");
		int countBaby = 0, countChild = 0, countAdult = 0;
		
		for (char a : u)
			// Print array to file
			out.print(a);
		
		// Count Numericons
		for (int i = u.length-1; i >= 0; i--){ // Iterate through array backwards
			char value = u[i];
			switch (value){
			case '0':  // Baby
				countBaby ++;
				break;
			case '1':  // Child
				countChild ++;
				break;
			case '2':  // Adult
				countAdult ++;		
				break;	
			default:
				break;
			}	
		}
		
		// Print count to file
		out.println();
		out.println("Babies: " + countBaby);
		out.println("Children: " + countChild);
		out.println("Adults: " + countAdult);
		out.close();
	}
	
	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(System.in);
		char [] universe;
		char choice = 'Q';
		
		// Ask user for size of universe
		System.out.print("What size universe would you like to create? > ");
		int size = sc.nextInt();
		
		// Generate universe
		universe = generateUniverse(size);
		
		do {
			switch (choice) { // Executes user's choic
			case 'A':
				advanceUniverse(universe);
				break;
			case 'S':
				saveUniverse(universe);
				break;
			default:
				break;
			}	
			
			// Print array
			for (char a : universe)
				System.out.print(a);
			
			// Give user choice of what to do with simulation
			System.out.print("\n(Q)uit / (A)dvance / (S)ave > ");
			choice = sc.next().charAt(0);
		} while (choice == 'A' || choice == 'S'); // Only loop while user picks Advance or Save
	}
}

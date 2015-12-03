import java.util.Scanner;

public class Lab13 {
	public static void main(String[] args) {
		// CoogieException
		try {
			throw (new CoogieException());
		} catch (CoogieException ex) {
			System.out.println(ex.toString());
		}
		
		// Try to access array with illegal index
		try {
			int[] a = new int[5];
			a[6] = 0;
		} catch (ArrayIndexOutOfBoundsException ex) {
			System.out.println(ex.toString());
		}

		// Try to access a null object
		try {
			Integer b = null;
			b.getClass();
		} catch (NullPointerException ex) {
			System.out.println(ex.toString());
		}
		
		// Try to cast an object to a subclass of which it is not an instance
		try {
			Object c = new Integer(5);
			System.out.println((String)c);
		} catch (ClassCastException ex) {
			System.out.println(ex.toString());
		}
		
		// Try illegal arithmetic operation
		try {
			int d = 5;
			d = 5/0;
		} catch (ArithmeticException ex) {
			System.out.println(ex.toString());
		}
		
		// Try making array with negative size
		try {
			int[] e = new int[-5];
		} catch (NegativeArraySizeException ex) {
			System.out.println(ex.toString());
		}
		
		// Try to access string out of index
		try {
			String f = "This string is too short";
			System.out.println(f.charAt(100));
		} catch (StringIndexOutOfBoundsException ex) {
			System.out.println(ex.toString());
		}
		
		// Try to convert non-number string to Integer
		try {
			String g = "not a number";
			Integer h = Integer.parseInt(g);
		} catch (NumberFormatException ex) {
			System.out.println(ex.toString());
		}
		
		// Try to store wrong type of object in an array of objects
		try {
			Object[] i = new String[5];
			i[0] = new Integer(5);
		} catch (ArrayStoreException ex) {
			System.out.println(ex.toString());
		}
		
		// NoogieException
		try {
			throw (new NoogieException());
		} catch (NoogieException ex) {
			System.out.println(ex.toString());
		}
	}
}

class NoogieException extends Exception {
	public NoogieException() {
		// Do nothing
	}
}

class CoogieException extends Exception {
	private int numCats = 0;
	public CoogieException() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter numCats > ");
		numCats = sc.nextInt();
		sc.close();
	}
	
	public String toString() {
		String s = numCats + " is too many cats!";
		return s;
	}
}
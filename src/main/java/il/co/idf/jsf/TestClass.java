package il.co.idf.jsf;

public class TestClass {

	public static int SIZE = 10;

	public static void main(String[] args) {
		printX();
		printTop();
		printBot();
		printLeft();
		printRight();
	}

	public static void printX() {
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				if (i == 0 || j == 0 || i == SIZE - 1 || j == SIZE - 1 || i == j || i + j == SIZE - 1 || (i < 6 && i < j && i+j < 10)) {
					System.out.print("x");
				} else {
					System.out.print(" ");
				}
			}
			System.out.print("\n");
		}
	}

	public static void printTop() {
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				if (i == 0 || j == 0 || i == SIZE - 1 || j == SIZE - 1 || i == j || i + j == SIZE - 1 || (i < j && i < 5 && i + j < SIZE - 1)) {
					System.out.print("x");
				} else {
					System.out.print(" ");
				}
			}
			System.out.print("\n");
		}
	}

	public static void printLeft() {
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				if (i == 0 || j == 0 || i == SIZE - 1 || j == SIZE - 1 || i == j || i + j == SIZE - 1) {
					System.out.print("x");
				} else if(i > j && j < 5 && i + j < SIZE - 1){
					System.out.print("x");
				} else {
					System.out.print(" ");
				}
			}
			System.out.print("\n");
		}
	}

	public static void printRight() {
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				if (i == 0 || j == 0 || i == SIZE - 1 || j == SIZE - 1 || i == j || i + j == SIZE - 1 || (i < j && j > 5 && i + j > SIZE - 1)) {
					System.out.print("x");
				} else {
					System.out.print(" ");
				}
			}
			System.out.print("\n");
		}
	}

	public static void printBot() {
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				if (i == 0 || j == 0 || i == SIZE - 1 || j == SIZE - 1 || i == j || i + j == SIZE - 1 || (i > j && i > 5 && i + j > SIZE - 1)) {
					System.out.print("x");
				} else {
					System.out.print(" ");
				}
			}
			System.out.print("\n");
		}
	}


}

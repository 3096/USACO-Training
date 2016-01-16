
/*
ID: yao.dai1
LANG: JAVA
TASK: transform
*/
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class transform {
	static int n;

	public static void main(String[] args) throws IOException {
		// Initialize I/O and some variables
		Scanner sc = new Scanner(new FileReader("transform.in"));
		n = sc.nextInt();
		boolean[][] original = patterner(sc), target = patterner(sc);
		sc.close();
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("transform.out")));

		// Start comparing with rotate and verticFlip methods.
		if (Arrays.deepEquals(target, rotate(original, 1))) {
			out.println(1);
		} else if (Arrays.deepEquals(target, rotate(original, 2))) {
			out.println(2);
		} else if (Arrays.deepEquals(target, rotate(original, 3))) {
			out.println(3);
		} else if (Arrays.deepEquals(target, verticFlip(original))) {
			out.println(4);
		} else if (Arrays.deepEquals(target, rotate(verticFlip(original), 1))
				|| Arrays.deepEquals(target, rotate(verticFlip(original), 2))
				|| Arrays.deepEquals(target, rotate(verticFlip(original), 3))) {
			out.println(5);
		} else if (Arrays.deepEquals(target, original)) {
			out.println(6);
		} else {
			out.println(7);
		}
		out.close();
	}
	
	// A method for converting input text into boolean[][]
	static boolean[][] patterner(Scanner sc) {
		boolean[][] var = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			String s = sc.next();
			for (int j = 0; j < n; j++) {
				char ch = s.charAt(j);
				if (ch == '@')
					var[i][j] = true;
				else
					var[i][j] = false;

			}
		}
		return var;
	}

	// Returns clockwise rotated boolean[][] by times of rotation.
	static boolean[][] rotate(boolean[][] var, int times) {
		boolean[][] result = new boolean[var.length][var[0].length];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				result[i][j] = var[n - 1 - j][i];
			}
		}
		if (times > 1) {
			return (rotate(result, times - 1));
		} else {
			return result;
		}
	}

	// Returns vertically flipped boolean[][].
	static boolean[][] verticFlip(boolean[][] var) {
		boolean[][] result = new boolean[var.length][var[0].length];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				result[i][j] = var[i][n - 1 - j];
			}
		}
		return result;
	}
}


/*
ID: yao.dai1
LANG: JAVA
TASK: beads
*/
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class beads {
	public static void main(String[] args) throws IOException {
		// Initialize I/O and some variables
		Scanner sc = new Scanner(new FileReader("beads.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("beads.out")));
		int n = sc.nextInt(); // Beads number
		String neck = sc.next();
		sc.close();
		int max = 2, end = n * 2;
		// Use the middle part with both sides attached extras to simulate a
		// closed circle.
		char[] lace = (neck + neck + neck).toCharArray();

		// Loop through every split possible.
		for (int i = n; i < end; i++) {
			int left = 1, right = 1; // Possible take for each side
			int cbi = 1; // Current target bead position
			char current; // Current target color

			// Loop for left side.

			// Find target color by skipping white.
			while (i - cbi > -1 && lace[i - cbi] == 'w') {
				cbi++;
			}
			if (i - cbi < 0) // Special case, all white.
				current = 'w';
			else
				current = lace[i - cbi];
			// Loop to find most possible take.
			while (i - 1 - left > -1 && (lace[i - 1 - left] == current || lace[i - 1 - left] == 'w')) {
				left += 1;
			}

			// Same loop for right side.
			cbi = 0;
			while (i + cbi < lace.length && lace[i + cbi] == 'w') {
				cbi++;
			}
			if (i + cbi >= lace.length)
				current = 'w';
			else
				current = lace[i + cbi];
			while (i + right < lace.length && (lace[i + right] == current || lace[i + right] == 'w')) {
				right += 1;
			}

			if (max < left + right)
				max = left + right;
		}
		// When the whole necklace is taken.
		if (max > n) {
			max = n;
		}

		// Output result and close writer
		out.print(max + "\n");
		out.close();
	}
}

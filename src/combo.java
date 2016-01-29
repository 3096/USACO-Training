
/*
ID: yao.dai1
LANG: JAVA
TASK: combo
*/
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

// This solution is less preferred because the algorithm, even though
// it runs at O(1), but the idea was kinda hard to implement.
public class combo {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new FileReader("combo.in"));
		int n = sc.nextInt();
		// 6 variables to hold both combinations.
		int s1 = sc.nextInt(), s2 = sc.nextInt(), s3 = sc.nextInt();
		int m1 = sc.nextInt(), m2 = sc.nextInt(), m3 = sc.nextInt();
		sc.close();
		int c = 250; // Max possible combinations without overlay.
		// This is the worst part, using three different ways to find overlaid
		// combinations and subtract the most.
		int d1 = overlay(s1, m1, n), d2 = overlay(s2, m2, n), d3 = overlay(s3, m3, n);
		int do1 = overlay(m1, s1, n), do2 = overlay(m2, s2, n), do3 = overlay(m3, s3, n);
		int di1 = intOverlay(s1, m1, n), di2 = intOverlay(s2, m2, n), di3 = intOverlay(s3, m3, n);
		c -= Math.max(di1 * di2 * di3, Math.max(d1 * d2 * d3, do1 * do2 * do3));

		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("combo.out")));
		// Check for special cases when n is small.
		if (c > n * n * n) {
			out.println(n * n * n);
		} else {
			out.println(c);
		}
		out.close();
	}

	// In order, find if the difference between single digit from both combinations is smaller than 5.
	static int overlay(int s, int m, int n) {
		int d;
		if ((d = s - m) < 0) {
			d += n;
		}
		if ((d = 5 - d) < 0) {
			d = 0;
		}
		return d;
	}
	
	// Same calculation as above but discard the order of two numbers.
	static int intOverlay(int s, int m, int n) {
		return overlay(Math.max(s, m), Math.min(s, m), n);
	}
}

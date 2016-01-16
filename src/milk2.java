
/*
ID: yao.dai1
LANG: JAVA
TASK: milk2
*/
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class milk2 {
	public static void main(String[] args) throws IOException {
		// Initialize I/O and some variables
		Scanner sc = new Scanner(new FileReader("milk2.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milk2.out")));
		int n = sc.nextInt();
		int[][] time = new int[n][2];
		int startTime = 2147483647, endTime = 0;
		for (int i = 0; i < n; i++) {
			time[i][0] = sc.nextInt();
			if (time[i][0] < startTime)
				startTime = time[i][0];
			time[i][1] = sc.nextInt();
			if (time[i][1] > endTime)
				endTime = time[i][1];
		}
		sc.close();
		// Variables keeping record.
		int max0 = 0, min1 = 0, current = 0;
		// Variables keeping milking state of the second and the interval.
		boolean milkNow = false, milking = false;

		// Iterating through every second
		for (int i = startTime; i < endTime; i++) {
			// Check if current second is milking
			milkNow = false;
			for (int[] t : time) {
				if (i >= t[0] && i < t[1]) {
					milkNow = true;
					break;
				}
			}
			// Check if state of milking changed
			if (milkNow == milking)
				current++;
			else {
				// If a interval finished, compare if it's a new record.
				if (milking) {
					if (current > min1)
						min1 = current;
				} else {
					if (current > max0)
						max0 = current;
				}
				current = 1;
				milking = milkNow;
			}
		}
		// Last check
		if (milking) {
			if (current > min1)
				min1 += current;
		} else {
			if (current > max0)
				max0 += current;
		}

		// Output
		out.println(min1 + " " + max0);
		out.close();
	}
}

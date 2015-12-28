
/*
ID: yao.dai1
LANG: JAVA
TASK: friday
*/
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class friday {

	public static void main(String[] args) throws IOException {

		// Initialize i/o
		Scanner sc = new Scanner(new FileReader("friday.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("friday.out")));

		// Some variables initialization
		int years = sc.nextInt();
		int[] thirteenth = new int[7]; // the array that counts each day
		int[] days = { 31, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		int today = 4; // last day of the thirteenth
		int y = 1900; // current year

		// Loop through each year
		for (int i = 0; i < years; i++) {
			// Determine the days of February
			if (leap(y))
				days[2] = 29;
			else
				days[2] = 28;
			// Loop through each month
			for (int m = 1; m <= 12; m++) {
				today = (today + (days[m - 1] % 7)) % 7; // Determine the day of
															// this month's 13th
				thirteenth[today]++; // Count day in the array
			}
			y++; // Increase current year
		}

		String output = ""; // String holder for output result
		for (int n : thirteenth)
			output += n + " ";
		out.println(output.trim()); // Come on USACO, I didn't have to do this
									// last time!
		sc.close();
		out.close();
	}

	// method for leap year
	static boolean leap(int year) {
		if (year % 4 == 0)
			if (year % 100 == 0)
				if (year % 400 == 0)
					return true;
				else
					return false;
			else
				return true;

		return false;
	}
}

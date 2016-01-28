
/*
ID: yao.dai1
LANG: JAVA
TASK: crypt1
*/
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class crypt1 {
	static List<Integer> nums;

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new FileReader("crypt1.in"));
		int n = sc.nextInt();
		nums = new ArrayList<Integer>();
		for (int i = 0; i < n; i++) {
			nums.add(sc.nextInt());
		}
		sc.close();
		// All digits being in order can reduce run time by skipping
		// combinations when the product has too many digits. Assume in test
		// cases, they are not presented in order.
		Collections.sort(nums);

		// Form all possible combinations with the provided set and check each
		// one.
		int count = 0;
		for (int a : nums) {
			for (int b : nums) {
				for (int c : nums) {
					int m1 = a * 100 + b * 10 + c;
					for (int d : nums) {
						int p2; // partial product 2
						// If partial product exceeds three digits, move on to
						// next one.
						if ((p2 = m1 * d) / 1000 > 0) {
							break;
						}
						for (int e : nums) {
							int p1; // partial product 1
							if ((p1 = m1 * e) / 1000 > 0) {
								break;
							}
							if (inNums(p1 = m1 * d) && inNums(p2 = m1 * e) && inNums(p1 + p2 * 10)) {
								count++;
							}
						}
					}
				}
			}
		}

		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("crypt1.out")));
		out.println(count);
		out.close();
	}

	// Method for checking if all digits of a number are in provided set.
	static boolean inNums(int n) {
		if (nums.contains(n % 10)) {
			if (n / 10 <= 0) {
				return true;
			} else {
				return inNums(n / 10);
			}
		} else {
			return false;
		}
	}
}

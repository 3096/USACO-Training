
/*
ID: yao.dai1
LANG: JAVA
TASK: barn1
*/
import java.io.*;
import java.util.*;

public class barn1 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new FileReader("barn1.in"));
		int m = sc.nextInt();
		sc.next(); // S in the input data is completely unnecessary, skip it.
		int c = sc.nextInt();
		// "stalls" to sort stall positions, "gaps" to store found gaps.
		List<Integer> stalls = new ArrayList<Integer>(), gaps = new ArrayList<Integer>();
		for (int i = 0; i < c; i++) {
			stalls.add(sc.nextInt());
		}
		sc.close();
		Collections.sort(stalls);
		// Find all gaps, store in "gaps", then sort.
		for (int i = 1; i < c; i++) {
			int gap;
			if ((gap = stalls.get(i) - stalls.get(i - 1)) > 1) {
				gaps.add(gap - 1);
			}
		}
		Collections.sort(gaps);
		// Add all smaller gaps to cover, leave out as many large ones as
		// possible using the amount of boards.
		for (int i = 0; i < gaps.size() - m + 1; i++) {
			c += gaps.get(i);
		}

		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("barn1.out")));
		out.println(c);
		out.close();
	}

}

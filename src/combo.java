
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
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class combo {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new FileReader("combo.in"));
		final int N = sc.nextInt();
		// Instantiate two Digits for target combo, s for FJ's set, m for master
		Digits s = new Digits(sc.nextInt(), sc.nextInt(), sc.nextInt());
		Digits m = new Digits(sc.nextInt(), sc.nextInt(), sc.nextInt());
		sc.close();

		// An anonymous class enhanced on ArrayList to store all valid combos
		// from provided target combo without repeating
		List<Digits> dl = new ArrayList<Digits>() {
			private static final long serialVersionUID = 1L;

			@Override
			public boolean add(Digits d) {
				// Three loops for three digits with +-2 tolerance
				for (int i = -2; i <= 2; i++) {
					for (int j = -2; j <= 2; j++) {
						for (int k = -2; k <= 2; k++) {
							// Current combo attempt
							Digits current = new Digits(d.m1 + i, d.m2 + j, d.m3 + k, N);
							if (!this.contains(current)) {
								super.add(current);
							}
						}
					}
				}
				return true;
			}
		};

		// Store all combos with two provided target combo
		dl.add(s);
		dl.add(m);

		// Output total number of stored combos
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("combo.out")));
		out.println(dl.size());
		out.close();
	}

	// A class designed to represent a combination
	static class Digits {
		// Three digits
		int m1, m2, m3;

		Digits(int d1, int d2, int d3) {
			m1 = d1;
			m2 = d2;
			m3 = d3;
		}

		// Constructor with range checking
		Digits(int d1, int d2, int d3, int n) {
			this(check(d1, n), check(d2, n), check(d3, n));
		}

		// Make the the digit is in range.
		static int check(int i, int n) {
			while (i < 1) {
				i += n;
			}
			while (i > n) {
				i -= n;
			}
			return i;
		}

		// For comparing if a combo is repeated
		@Override
		public boolean equals(Object d) {
			return m1 == ((Digits) d).m1 && m2 == ((Digits) d).m2 && m3 == ((Digits) d).m3;
		}
	}
}

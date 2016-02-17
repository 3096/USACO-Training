
/*
ID: yao.dai1
LANG: JAVA
TASK: wormhole
*/
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

public class wormhole {
	// hl is a list of all the Holes, c counts result, mapping keeps the
	// position of Holes
	static List<Hole> hl = new ArrayList<Hole>();
	static int c;
	static HashMap<Integer, List<Hole>> mapping = new HashMap<Integer, List<Hole>>();

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new FileReader("wormhole.in"));
		int n = sc.nextInt();
		// nums is the set of index of Holes in hl, helps creating every pair
		SortedSet<Integer> nums = new TreeSet<Integer>();

		for (int i = 0; i < n; i++) {
			Hole newHole = new Hole(sc.nextInt(), sc.nextInt(), i);
			hl.add(newHole);
			if (!mapping.containsKey(newHole.y)) {
				mapping.put(newHole.y, new ArrayList<Hole>());
			}
			mapping.get(newHole.y).add(newHole);
			// Make sure Holes are in position of x direction
			Collections.sort(mapping.get(newHole.y));
			nums.add(i);
		}
		sc.close();

		// Create pairs and test if trapped, count cases in c
		map(nums);

		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("wormhole.out")));
		out.println(c);
		out.close();
	}

	// Recursively create all pairing options and test them
	static void map(SortedSet<Integer> nums) {
		int pair1;
		nums.remove(pair1 = nums.first());
		for (int pair2 : nums) {
			hl.get(pair1).setPair(pair2);
			// Continue pairing the rest or test if trapped once all are paired
			if (nums.size() > 1) {
				SortedSet<Integer> nextNums = new TreeSet<Integer>(nums);
				nextNums.remove(pair2);
				map(nextNums);
			} else {
				// Start with every Hole to check if trapped
				loose: for (Hole start : hl) {
					int y = start.y;
					List<Hole> cRow = mapping.get(y);
					int yd = cRow.indexOf(start);
					boolean revisit = false;
					while (true) {
						// End test case if returns to starting Hole
						if (start.equals(cRow.get(yd)) && revisit == true) {
							c++;
							break loose;
						}
						// Jump to paired Hole
						Hole target = hl.get(cRow.get(yd).pi);
						y = target.y;
						cRow = mapping.get(y);
						yd = cRow.indexOf(target);
						revisit = true;
						// Go to the next Hole in positive x direction, if any
						if (yd + 1 >= cRow.size()) {
							break;
						} else {
							yd++;
						}
					}
				}
				return;
			}
		}
	}

	// Class Hole represents a wormhole
	static class Hole implements Comparable<Hole> {
		// Coordinates
		int x, y;
		// Index in hl and paired Hole's index
		int i, pi;

		Hole(int x, int y, int i) {
			this.x = x;
			this.y = y;
			this.i = i;
		}

		// link two Holes together as pair
		void setPair(int i) {
			pi = i;
			hl.get(i).pi = this.i;

		}

		// For sorting in x direction
		@Override
		public int compareTo(Hole h) {
			if (x < h.x) {
				return -1;
			} else if (x > h.x) {
				return 1;
			} else {
				return 0;
			}
		}

		// For finding a Hole in hl
		@Override
		public boolean equals(Object h) {
			return ((Hole) h).x == x && ((Hole) h).y == y;
		}
	}
}

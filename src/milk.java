
/*
ID: yao.dai1
LANG: JAVA
TASK: milk
*/
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class milk {
	public static void main(String[] args) throws IOException {
		// Get input from data
		Scanner sc = new Scanner(new FileReader("milk.in"));
		int unitLeft = sc.nextInt();
		int n = sc.nextInt();
		// Use tree map, entries always automatically sorted by key, which is price.
		TreeMap<Integer, Integer> farmers = new TreeMap<Integer, Integer>();
		for (int i = 0; i < n; i++) {
			int price;
			// When farmers offer the same price, merge into existing entry.
			if (farmers.containsKey(price = sc.nextInt())) {
				// farmers.replace(price, farmers.get(price)+sc.nextInt());
				// USACO uses JDK1.7 or lower in Jan, 2016 the heck?
				farmers.put(price, farmers.get(price) + sc.nextInt());
			} else
				farmers.put(price, sc.nextInt());
		}
		sc.close();
		
		// Start with lowest price.
		int cost = 0;
		for (Map.Entry<Integer, Integer> f : farmers.entrySet()) {
			int u; // Units available for current price.
			// Determine if enough units bought.
			if ((u = f.getValue()) < unitLeft) {
				cost += u * f.getKey();
				unitLeft -= u;
			} else {
				cost += unitLeft * f.getKey();
				break;
			}
		}
		
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milk.out")));
		out.println(cost);
		out.close();
	}
}
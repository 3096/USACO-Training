
/*
ID: yao.dai1
LANG: JAVA
TASK: palsquare
*/
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

// This program takes advantage of methods of java's Integer and StringBuilder class, which makes it extremely easy.
public class palsquare {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new FileReader("palsquare.in"));
		int base = sc.nextInt();
		sc.close();
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("palsquare.out")));
		String s;
		for (int i = 1; i < 301; i++) {
			s = Integer.toString((int) Math.pow(i, 2), base);
			if (s.substring(0, s.length() / 2)
					.equals((new StringBuilder(s.substring(s.length() - s.length() / 2)).reverse().toString()))) {
				out.println(Integer.toString(i, base).toUpperCase() + " " + s.toUpperCase());
			}
		}
		out.close();
	}
}

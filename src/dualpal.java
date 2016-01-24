
/*
ID: yao.dai1
LANG: JAVA
TASK: dualpal
*/
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

// The difficult part of this program is similar to "palsquare", so kinda doesn't sense.
public class dualpal {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new FileReader("dualpal.in"));
		int n = sc.nextInt();
		int num = sc.nextInt() + 1;
		sc.close();
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("dualpal.out")));
		int count = 0;
		while (count < n) {
			boolean second = false;
			for (int base = 2; base <= 10; base++) {
				String s = Integer.toString(num, base);
				if (s.substring(0, s.length() / 2)
						.equals((new StringBuilder(s.substring(s.length() - s.length() / 2)).reverse().toString()))) {
					if (second == true) {
						out.println(num);
						count++;
						break;
					} else {
						second = true;
					}
				}
			}
			num++;
		}
		out.close();
	}
}


/*
ID: yao.dai1
LANG: JAVA
TASK: namenum
*/
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;

public class namenum {
	static char[] letters = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'R', 'S',
			'T', 'U', 'V', 'W', 'X', 'Y' };
	static HashSet<String> dict = new HashSet<String>();
	static String output = "";

	public static void main(String[] args) throws IOException {
		// Initialize dict and read the number
		BufferedReader rd = new BufferedReader(new FileReader("dict.txt"));
		for (int i = 0; i < 4617; i++) {
			dict.add(rd.readLine());
		}
		rd.close();
		rd = new BufferedReader(new FileReader("namenum.in"));
		String code = rd.readLine();
		rd.close();

		check(code, "");

		// Finish off by checking if any name found
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("namenum.out")));
		if (output.length() != 0) {
			out.print(output);
		} else {
			out.println("NONE");
		}
		out.close();
	}

	// Recursively check all combinations
	static void check(String code, String name) throws IOException {
		for (int i = 0; i < 3; i++) {
			char c = letters[(code.charAt(0) - 50) * 3 + i];
			if (code.length() <= 1) {
				if (dict.contains(name + c)) {
					output += name + c + "\n";
				}
			} else {
				check(code.substring(1), (name + c));
			}
		}
	}
}

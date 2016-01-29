
/*
ID: yao.dai1
LANG: JAVA
TASK: test
*/
import java.io.*;
import java.util.*;

public class combo {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new FileReader("dualpal.in"));
		int n = sc.nextInt();
		List<Digits> dl = new ArrayList<Digits>();
		Digits s = new Digits(sc.nextInt(), sc.nextInt(), sc.nextInt());
		Digits m = new Digits(sc.nextInt(), sc.nextInt(), sc.nextInt());
		
		List<Digits> d = new ArrayList<Digits>(){
			public boolean add(Digits d){
				for(int i = -2; i<=2; i++){
					for(int j = -2; j<=2; j++){
						for(int k = -2; k<=2; k++){
							Digits current;
							//if(this.contains(current = new Digits(d1,d2,d3))){
								
							}
						}
					}
				}
				return true;
			}
		};
		
	}

	static class Digits {
		int m1, m2, m3;

		Digits(int d1, int d2, int d3) {
			m1 = d1;
			m2 = d2;
			m3 = d3;
		}

		public boolean equals(Digits d) {
			return m1 == d.m1 && m2 == d.m2 && m3 == d.m3;
		}
	}
}

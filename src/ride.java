/*
ID: yao.dai1
LANG: JAVA
TASK: ride
*/
import java.io.*;

class ride {
  public static void main (String [] args) throws IOException {
    // Use BufferedReader rather than RandomAccessFile; it's much faster
    BufferedReader f = new BufferedReader(new FileReader("ride.in"));
                                                  // input file name goes above
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("ride.out")));
    // Use StringTokenizer vs. readLine/split -- lots faster
    
    //Compare 
    if (modValue(f.readLine()) == modValue(f.readLine())){
    	out.println("GO");
    } else{
    	out.println("STAY");
    }

    out.close();                                  // close the output file
    f.close();									  // close the BufferedReader
  }
  
  //Calculates the modulus of all letters' value in a line
  static private int modValue(String line){
	  int result = 1;
	  
	  for(int i = 0; i < line.length(); i++){
		  result *= (int)line.charAt(i)-64;
	  }
	  return result % 47;
  }
}
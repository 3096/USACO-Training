/*
ID: yao.dai1
LANG: JAVA
TASK: gift1
*/
import java.io.*;
import java.util.*;

class gift1 {

  public static void main (String [] args) throws IOException {
    Scanner s = new Scanner(new FileReader("gift1.in"));	// input file to Scanner
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("gift1.out")));	//output file
    // Get the String of the whole file from Scanner, break into tokens
    StringTokenizer st = new StringTokenizer(s.useDelimiter("\\Z").next());
    
    int np = Integer.parseInt(st.nextToken());    // NP Count
    
    //Initialize Givers ArrayList
    HashMap<String, Giver> npg = new HashMap<String, Giver>();
    for(int i = 0; i < np; i++){
    	String name = st.nextToken();
    	npg.put( name, new Giver(name) );
    }
    
    //Loops through the whole money giving
    for(int i = 0; i < np; i++){
    	Giver cGiver = npg.get(st.nextToken());		//Current giver
    	int cMoney = Integer.parseInt(st.nextToken()),		//Current giver's money
    		cRecipient = Integer.parseInt(st.nextToken());	//Current recipient count
    	int cGiving = 0;
    	if(cRecipient != 0)
    		cGiving = cMoney/cRecipient;					//Money giving to each recipient
    	cGiver.setInitMoney(cMoney);						//Set initial money for comparison.
    	cGiver.setMoney(0 - cGiving*cRecipient);			//Give away money.
    	for(int j = 0; j < cRecipient; j++){
    		npg.get(st.nextToken()).setMoney(cGiving);	//Each recipient receive money
    	}	
    }
    
    for(Giver g : npg.values())
    	out.println(g.name +" "+ (g.money-g.iMoney));  // output result
    out.close();                                  // close the output file
    s.close();									  // close the BufferedReader
  }
  
    static class Giver{
		String name; //The person's name
		int money;   //The person's money
		int iMoney;	 //The person's initial money
		
		//Constructor
		Giver(String name){
			this.name = name;
			money = 0; 
			iMoney = 0;
		}

		//Money modifier
		void setMoney(int money){
			this.money += money;
		}
		
		void setInitMoney(int money){
			iMoney = money;
			setMoney(money);
		}
	}
}
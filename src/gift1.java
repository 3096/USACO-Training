/*
ID: yao.dai1
LANG: JAVA
TASK: gift1
*/
import java.io.*;
import java.util.*;

class gift1 extends ArrayList<gift1.Giver> {
  /**
	 * Not sure what this serial thing is... Eclipse told me to add it.
	 */
	private static final long serialVersionUID = 1L;

public static void main (String [] args) throws IOException {
    // Use BufferedReader rather than RandomAccessFile; it's much faster
    Scanner s = new Scanner(new FileReader("gift1.in"));
                                                  // input file name goes above
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("gift1.out")));
    // Use StringTokenizer vs. readLine/split -- lots faster
    StringTokenizer st = new StringTokenizer(s.useDelimiter("\\Z").next());
						  // Get line, break into tokens
    
    int np = Integer.parseInt(st.nextToken());    // NP Count
    
    //Initialize Givers ArrayList
    gift1 npg = new gift1();
    for(int i = 0; i < np; i++){
    	npg.add( new Giver(st.nextToken()) );
    }
    
    //Loops through the whole money giving
    for(int i = 0; i < np; i++){
    	Giver cGiver = npg.getGiver(st.nextToken());		//Current giver
    	int cMoney = Integer.parseInt(st.nextToken()),		//Current giver's money
    		cRecipient = Integer.parseInt(st.nextToken());	//Current recipient count
    	int cGiving = 0;
    	if(cRecipient != 0)
    		cGiving = cMoney/cRecipient;					//Money giving to each recipient
    	cGiver.setInitMoney(cMoney);						//Set initial money for comparison.
    	cGiver.setMoney(0 - cGiving*cRecipient);			//Give away money.
    	for(int j = 0; j < cRecipient; j++){
    		npg.getGiver(st.nextToken()).setMoney(cGiving);	//Each recipient receive money
    	}	
    }
    
    for(Giver g : npg)
    	out.println(g +" "+ (g.money-g.iMoney));  // output result
    out.close();                                  // close the output file
    s.close();									  // close the BufferedReader
  }
  
  //Look for the Giver in this ArrayList
  Giver getGiver(String name){
	  for(Giver g : this){
		  if(g.equals(name)){
			  return g;
		  }
	  }
	  return null;
  }
  
  static class Giver{
		String name; //The person's name
		int ni;		 //The person's index
		int money;   //The person's money
		int iMoney;	 //The person's initial money
		
		//Constructor
		Giver(String name){
			this.name = name;
			money = 0; 
			iMoney = 0;
		}
		
		//Return true if name check passes
		@Override
		public boolean equals(Object o){
			return this.name.equals(o.toString());
		}
		
		//Return name for toString()
		@Override
		public String toString(){
			return name;
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
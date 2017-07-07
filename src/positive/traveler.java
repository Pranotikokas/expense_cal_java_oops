package positive;

public class traveler {
	
	private String name;
    private String reason;	
    private int amountPaid;
   
    
    int paid;//how much a traveler paid
    int payable =0;// how much he has to pay
    int total = 0;//final settlement amount gets/ give
    //------------------------------------------------------------
    
    // get Name of the Traveler
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    //------------------------------------------------------------
    
    // get Reason of travel
    public String getReason() {return reason;}
    public void setReason() {this.reason = reason;}
    //------------------------------------------------------------
    // get amountPaid of travel
    public int getAmountPaid() {return amountPaid;}
    public void setAmountPaid() {this.amountPaid = amountPaid;}
    
    	//------------------------------------------------------------
    traveler(String myArray, int amt){
    		this.name = myArray;
    		//this.reason =myArray2;
    		paid = this.amountPaid= amt;
    }
    
    
    traveler(String myArray){
		this.name = myArray;
		paid =this.amountPaid=0;	
		
    }
 
    // get the number of contributers for each  expense and calculate each share
    void calculateSettlement(traveler...travelers){
    			
    			for (traveler t :travelers ) {
    				t.payable = t.payable + (this.paid/travelers.length);
    				t.total =  t.paid - t.payable ;
    				//System.out.println(t.name + "  " + t.total);
    				//System.out.println("-------------------------------");
    			}
    			
    			
    }
    
    
    //final output display
    void display() {
    	if(total <0)
			System.out.println(this.name + " has to give " + -total);
		else
			System.out.println(this.name + " gets " + total);
		
    }
    
    
}



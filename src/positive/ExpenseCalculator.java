
/*Expected output
 A has to give 75 
 B gets 325
 C has to give 275 
 D gets 25*/


package positive;

import java.util.*;
import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;



public class ExpenseCalculator {
		static String xStrPath;
		static String[][] myArray;
		int l1,l2,l3=0;
		
		//main 
	    public static void main(String []args) throws IOException{
	    	
	    		try {
					replaceTextFile("read_equal.txt",",","","read.txt");
				} 
	    		catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    		
	    		setUpMyArray();
	    		//printMyArray();	
	    		int noOfLines = calculateNoOfLines();
	    		String travlerList[] = new String[7*noOfLines];
	    		
	    		int i = 0;
	    		for(int Rowc = 0; Rowc < noOfLines; Rowc++) {
	    			for(int Colc = 3; Colc < 8; Colc++) {
	    				travlerList[i] = myArray[Rowc][Colc];
	    				i++;
	    			}
	    			
	    		}
	    		
	    		int counter = 0;
	    		for (int b = 0; b < travlerList.length; b ++)
	    		    if (travlerList[b] != null)
	    		        counter ++;
	    		
	    		for(int Rowc = 0; Rowc < noOfLines; Rowc++) {
	    			travlerList[counter] = myArray[Rowc][0]; 
	    			counter++;
	    		}
	    		
	    		HashSet<String> uniques = new HashSet<>(Arrays.asList(travlerList));
	    		boolean isremoved = uniques.remove(null);
	    		//System.out.println(isremoved);
	    		int count =0;
	    		for(String element: uniques) {
	    	    			count++;
	    	    			//System.out.println(element);
	    	    			
	    	    }
	    		
	    		
	    		//System.out.println(count);
	    		
	    		
	    		int Amt1 = Integer.parseInt(myArray[0][1]);
	    		int Amt2 = Integer.parseInt(myArray[1][1]);
	    		int Amt3 = Integer.parseInt(myArray[2][1]);
	    		
	    		 traveler travelers[]=new traveler[count];
	    	
	    		 for(int Rowc = 0; Rowc < noOfLines; Rowc++) {
			    				int Amt = Integer.parseInt(myArray[Rowc][1]);
			    				travelers[Rowc]=new traveler(myArray[Rowc][0],Amt);
			  			
			  }
	    		 
	    		 HashSet<String> present = new HashSet<String>();
	    		 for(int m=0;m<noOfLines;m++) {
	    			 present.add(travelers[m].getName());
	    		 }
	    		 
	    		
	    		 uniques.removeAll(present);
	    		 int add=0;
	    		 for(String element: uniques) {
 	    			//System.out.println(element);
 	    			travelers[noOfLines+add]=new traveler(element);
 	    			add++;
 	    			
	    		 }
 
	    		 for(int l=0;l<count;l++) {
	    			 System.out.println("Traveler " + l + ": "+	 travelers[l].getName()); 
	    			
	    		 }
	    		 
	    		 ArrayList<String> ar = new ArrayList<String>();
	    		 
	    		 List<traveler> contriList = new ArrayList<traveler>();
	    		
	    		 for(int Rowc = 0; Rowc < noOfLines; Rowc++) {
		    			/*for(int Colc = 3; Colc < count; Colc++) {
		    				 contriList.addAll((myArray[Rowc][Colc]));
		    			}	*/
		    			
		    		}
	    		 
	    		 //this needs to be automated
	    		 travelers[0].calculateSettlement(travelers[7],travelers[1],travelers[3],travelers[4],travelers[5]);
	    		 travelers[1].calculateSettlement(travelers[3],travelers[6]);
	    		 travelers[2].calculateSettlement(travelers[0],travelers[1]);
	    		 
	    		 travelers[0].display();
	    		 travelers[1].display();
	    		 travelers[2].display();
	    		 travelers[3].display();
	    		 travelers[4].display();
	    		 travelers[5].display();
	    		 travelers[6].display();
	    		 travelers[7].display();
	    		 
	    		 
	    		 
	    		 
	    		 
	    		 
}	    		 	    		 
	    	 
	    
	    static int calculateNoOfLines() throws FileNotFoundException {
				    	try{
			
				    		File file =new File("read_equal.txt");
			
				    		if(file.exists()){
			
				    		    FileReader fr = new FileReader(file);
				    		    LineNumberReader lnr = new LineNumberReader(fr);
			
				    		    int linenumber = 0;
			
				    	            while (lnr.readLine() != null){
				    	            	linenumber++;
				    	            }
			
				    	            //System.out.println("Total number of lines : " + linenumber);
				    	            
				    	            lnr.close();
				    	            return linenumber;
					    		}else{
					    			 System.out.println("File does not exists!");
					    		}

					    	}catch(IOException e){
					    		e.printStackTrace();
					    	}
						return 0;
				    	
						

	    		}
		
		static void  replaceTextFile(String filename, String target, String replacement, String toFilename) throws IOException 
		{
            		Path path = Paths.get(filename);
            		Path topath = Paths.get(toFilename);
            		Charset charset = Charset.forName("UTF-8");
                BufferedWriter writer = Files.newBufferedWriter(topath, charset);
                Scanner scanner = new Scanner(path, charset.name());
                String line;
                while (scanner.hasNextLine()) {
                		line = scanner.nextLine();
                		line = line.replaceAll(target, replacement);
                		line = line.replaceAll("and ", "");
                		line = line.replaceAll("spent ", "");
                		line = line.replaceAll("for ", "");
                		writer.write(line);
                		
                		if(scanner.hasNextLine())
                			writer.newLine();
               
                }
                //writer.write("\b");
                scanner.close();
                writer.close(); 
        }

		//setUpMyArray
		static void setUpMyArray() throws IOException {
			int lines = calculateNoOfLines();
    			//System.out.println("No of lines in the text file is " + lines);
			myArray = new String[lines][10];
			
			Scanner scanIn = null;
			int Rowc = 0;
			int Row = 0;
			int Colc = 0;
			int Col = 0;
			String InputLine = "";
			int wordcount=0;
			double xnum = 0;
			
			
			//System.out.println("******Setup Array******");
			
			try {
				
				scanIn = new Scanner(new BufferedReader(new FileReader(("read.txt"))));
				
				
				while(scanIn.hasNextLine())
				{
					InputLine = scanIn.nextLine();
					
					
					String[] InArray = InputLine.split(" ");
					wordcount = wordcount + InArray.length;
					//System.out.println(wordcount-3);
					for(int x=0; x<InArray.length; x++)
					{
							myArray[Rowc][x]=InArray[x];
					}
					Rowc++;
					wordcount = 0;
				}	
				
			}catch(Exception e){
				System.out.println(e);
			}
			
			return;
			
		}
	    
	    
	    //printMyArray Method
	    static void printMyArray() throws FileNotFoundException {
	    		int noOfLines = calculateNoOfLines();
	    		for(int Rowc = 0; Rowc < noOfLines; Rowc++) {
	    			for(int Colc = 0; Colc < 10; Colc++) {
	    				System.out.print(myArray[Rowc][Colc] + " ");
	    			}
	    			System.out.println();
	    		}
	    		System.out.println("************************");
	    		return;
	    }    
	    
	    public int countAndPrintLineWord(String fileName) {
	    	 
	        // local variables
	        BufferedReader bufferedReader = null;
	        String line = "";
	        int lineCount = 0;
	        int wordCount = 0 ;
	       
	 
	        // Step 1: Read file from local drive location
	        try {
	            bufferedReader = new BufferedReader(new FileReader(fileName));
	            int j=0;
	      
	            // Step 2: Read line from file
	            while ((line = bufferedReader.readLine()) != null) {
	 
	                // increase line count by 1
	                lineCount++;
	 
	                // Step 3: split line using space as delimiter
	                String[] words = line.split(" ");
	 
	                // Step 4 & 5: add word count length
	                wordCount = wordCount + words.length;
	                //System.out.println(wordCount);
	                
	                if(j==0) {
	                		l1 = wordCount;
	                		System.out.println(l1);
	                }
	                else if(j == 1) {
	                			l2 = wordCount;
	                			System.out.println(l2);
	                }
	                else if(j==2) {
	                				l3 = wordCount;
	                				System.out.println(l3);
	                }
	                j++;
	                
	                wordCount = 0;
	                
	            }
	            return wordCount;
	 
	            // Step 6: print the count value of line & word
	            //System.out.println("Number of lines is : " + lineCount);
	            //System.out.println("Number of words is : " + wordCount);
	        } 
	        catch (FileNotFoundException fnfex) {
	            fnfex.printStackTrace();
	        }
	        catch (IOException ioex) {
	            ioex.printStackTrace();
	        }
	        finally {
	 
	            // close resources, if any
	            try {
	                if(null != bufferedReader) {
	                    bufferedReader.close();
	                }
	            } 
	            catch (IOException ioex) {
	                ioex.printStackTrace();
	            }
	        }
			return wordCount;
	    }
	    
}

/*for(int Rowc = 0; Rowc < noOfLines; Rowc++) {

System.out.println(t);
traveler "t" + (Rowc + 1); = new traveler(myArray[Rowc][0], Amt1,myArray[Rowc][2]);
 for(int row = 3; row < noOfLines ; row++) {
			    	    	travlerList[i] = myArray[row][0];
		    	    		if(uniques.contains(myArray[row][0])) {
		    	    			int Amt = Integer.parseInt(myArray[0][1]);
		    	    			traveler t = new traveler(myArray[row][0],Amt ,myArray[row][2]);  	   
		    	    		}
		    	    		else
		    	    		{
		    	    			traveler t = new traveler(myArray[row][5]);
		    	    		}
	    	        views.add(new traveler(this.t));
	    	    }

	    	    for(int row = 3; row < noOfLines ; row++) {
	    	    		travlerList[i] = myArray[row][0];
	    	    		if(uniques.contains(myArray[row][0])) {
	    	    			int Amt = Integer.parseInt(myArray[0][1]);
	    	    			traveler t = new traveler(myArray[row][0],Amt ,myArray[row][2]);  	   
	    	    		}
	    	    		else
	    	    		{
	    	    			traveler t = new traveler(myArray[row][5]);
	    	    		}
	    	    			


String[] names = {myArray[0][0],myArray[1][0],myArray[2][0]};
	    		int[] amount = {Amt1,Amt2,Amt3};
	    		String[] c1 = {myArray[0][3],myArray[1][0],myArray[2][0]};
	    		String[] c2 = {myArray[0][4],myArray[1][0],myArray[2][0]};
	    		String[] c3 = {myArray[0][5],myArray[1][0],myArray[2][0]};
	    		String[] c4 = {myArray[0][6],myArray[1][0],myArray[2][0]};
	
	    	    List<traveler> travelers = new ArrayList<traveler>();
	    	    int j=0;
	    	    while(j< names.length) {
	    	    		travelers.add(new traveler(names[j],amount[j]));
	    	    }
	    	    
	    	    
	    	    
	    	    

}*/
/*

A 100 Snacks  A B C D
traveler t1 = new traveler(myArray[0][0], Amt1,myArray[0][2]);
traveler t2 = new traveler(myArray[1][0], Amt2,myArray[1][2]);  
traveler t3 = new traveler(myArray[2][0], Amt3,myArray[2][2]);

traveler t4 = new traveler(myArray[0][5]);
System.out.println("\n\n\n Final Output");

*/


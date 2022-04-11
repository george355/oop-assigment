package assigment;

import javax.swing.JTextArea;
/*
 This class will be used for finding the searched term enter by the user 
 */
public class finder extends file_selector{
	
	String wordc;
	int count=0;
	public finder(String file,String search, JTextArea area1) {

		area1.append("\n\nMatches found");
	    String[] sp = file.split(" +"); // Dividing the file by finding spaces between the words
	    String[] search2 = search.split(" +"); // Finding if there is one or multiple words entered in the search menu
	    
		    for (int i = 0; i < sp.length; i++) {
		        int j = 0;
		        while (j < search2.length && i+j < sp.length && sp[i+j].equals(search2[j])) 
		        {j++;}           
		        if (j == search2.length) { // found matching words
		        	
		        //Loop to print the words around the searched word.
		        	StringBuilder word = new StringBuilder();
		            if (i-2 > 0){ word.append(sp[i-2]); word.append(" "); }
		            if (i-1 > 0){ word.append(sp[i-1]); word.append(" "); }
		            for (int k = 0; k < search2.length; k++) {
		                if (k > 0){ word.append(" "); }
	                		word.append(sp[i+k]);
			            }
			            if (i+search2.length < sp.length) {
			                word.append(" ");
			                word.append(sp[i+search2.length]);
			            }
			            if (i+search2.length+1 < sp.length) {
			                word.append(" ");
			                word.append(sp[i+search2.length+1]);		                
			            }
			            count=count +1;//calculating the total amount of finds.
			            area1.append("\n"+word.toString());//printing the rezults on the GUI screen
			        }
			    }
	}
	//Getting the total count amount
	public int getCount() {
	    	return count;
	
}
}

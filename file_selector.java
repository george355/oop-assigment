/*This is a program for Searching words or phrases between two files.
The program includes a GUI for the selection of the file and for inputing the searched term.
The program will take those files, read them line by line and convert them into a string.
After which the user will input the search term which will then be placed into a string and the the string will scan thought against the selected files.
Additional Features:
Showing the words around the searched term.
Author: George Ciobanu (C20363281)
 */
package assigment;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class file_selector extends JFrame implements ActionListener{
	int response1;
	int response2;
	String str;
	String file1;
	String file2;
	Scanner sc = null;
	String one;
	String two;
	String search;
		
	JPanel panel;
	JFrame GUI;
	JButton button1;
	JButton button2;
	JTextField textfield1;
	JButton button3;
	//GUI for the user interface
	public void file_selector1(){
		GUI=new JFrame("My Search Engine");
		panel = new JPanel(null);
		panel.setLayout( new FlowLayout());
		panel.setBackground(Color.CYAN);
		GUI.add(panel);
		
		button1= new JButton("select first file");
		button2= new JButton("select second file");
		button3= new JButton("Search");
		textfield1 = new JTextField();

		button1.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);
		textfield1.setText("Please enter you word");
		
		panel.add(button1);
		panel.add(button2);
		panel.add(textfield1);
		panel.add(button3);

		GUI.setVisible(true);
		GUI.setSize(400,300);
		GUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GUI.setLocationRelativeTo(null);
	}	
public void actionPerformed(ActionEvent e) {
	//Selecting the first file.
	if(e.getSource()==button1) 
{		
		//GUI menu
		one=null;
		JFileChooser fileChooser = new JFileChooser();
		response1 = fileChooser.showOpenDialog(null);
			
		if(response1 == JFileChooser.APPROVE_OPTION) {
			File file1 =new File(fileChooser.getSelectedFile().getAbsolutePath());
			// arraylist to store strings
		    List<String> listOfStrings = new ArrayList<String>();
		       
		    // load content of file based on specific delimiter
			try {
				sc = new Scanner(new FileReader(file1)).useDelimiter(",\\s*");
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		    // checking end of file
		    while (sc.hasNext()) {
		        str = sc.next();
		        // adding each string to arraylist
		        listOfStrings.add(str);}
		       
		    // convert the arraylist to string
		    one= listOfStrings.toString();
		    
		    //Checking to see if the file selected is empty.
	        if (one!=null)
	        	System.out.println("A file which is not empty has been selected");
	        else
	        	System.out.println("An empty file has been selected");}
}	
		
	if(e.getSource()==button2) {
		//GUI menu
		two=null;
		JFileChooser fileChooser = new JFileChooser();
		response2 = fileChooser.showOpenDialog(null);
			
			if(response2 == JFileChooser.APPROVE_OPTION) {
				File file2 =new File(fileChooser.getSelectedFile().getAbsolutePath());
				
		        // arraylist to store strings
		        List<String> listOfStrings= new ArrayList<String>();
		       
		        // load content of file based on specific delimiter
				try {
					sc = new Scanner(new FileReader(file2)).useDelimiter(",\\s*");
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();}

		        // checking end of file
		        while (sc.hasNext()) {
		            str = sc.next();
		            // adding each string to arraylist
		            listOfStrings.add(str);}
		       
		        // convert the arraylist to a string
		        two= listOfStrings.toString();
		        
		        //Checking to see if the file selected is empty.
		        if (two!=null)
		        	System.out.println("A file which is not empty has been selected");
		        else
		        	System.out.println("An empty file has been selected");
		        }
}
	
if(e.getSource()==button3) {
	int count1=0;
	int count2=0;
	search=textfield1.getText();
	
	//checking if the inputer term is in the file
	try {
		//Checking for the first file
		if (one.contains(search)) {
			System.out.println("\n\nMatches from the first file");
			String[] sp = one.split(" +"); // Dividing the file by finding spaces between the words
		    String[] search2 = search.split(" +"); // Finding if there is one or multiple words entered in the search menu
		    
			    for (int i = 0; i < sp.length; i++) {
			    	int j = 0;
			        while (j < search2.length && i+j < sp.length && sp[i+j].equals(search2[j])) 
			        {j++;}           
			        if (j == search2.length) {  // found matching words
			        	
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
				            System.out.println(word.toString());
				            count1=count1 +1;//calculating the total amount of finds.
				        }
				    }
			}
			else 
				System.out.println("\nThe word you have enter is not found in the first file");
		}
		catch (Exception f2) {
			System.out.println("First file not selected");
		}
	try {
		if (two.contains(search)) {
			System.out.println("\n\nMatches from the second file");
		    String[] sp = two.split(" +"); // Dividing the file by finding spaces between the words
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
				            System.out.println(word.toString());
				            count2=count2 +1;//calculating the total amount of finds.
				        }
				    }
			}
			else 
				System.out.println("\nThe word you have enter is not found in the second file");
}
catch (Exception f2) {
	System.out.println("Second file not selected");
}
	//Checking if any matches have been found
	if ( textfield1.getText().isBlank() || textfield1.getText().equals("Please enter you word")) {
		System.out.println("You havent enter a search word");}

	else
		if(count1==0 && count2==0) {
			System.out.println("\nThe word which you have enter doesnt have any matches");
		}
		else if (count1>count2 && count1!=count2) {
			System.out.println("\nFirst file has more matches than the second one");
		}
		else if (count2>count1 && count2!=count1) {
			System.out.println("\nSecond file has more matches than the first one");
		}		
		else 
		System.out.println("\nBoth files have the same amount of matches");
}
}}			
/*This is a program for Searching words or phrases between two files.
The program includes a GUI for the selection of the file and for inputing the searched term.
The program will take those files, read them line by line and convert them into a string.
After which the user will input the search term which will then be placed into a string and the the string will scan thought against the selected files.
Additional Features:
Showing the words around the searched term.
Author: George Ciobanu (C20363281)
 */
package assigment;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
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
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class file_selector extends JFrame implements ActionListener{
	String str;
	Scanner sc = null;
	String one = null;
	String two;
	String search;
		
	JPanel panel;
	JFrame GUI;
	JButton button1;
	JButton button2;
	public JTextField textfield1;
	JButton button3;
	JTextArea area1;
	JTextArea area2;

	//GUI for the user interface
	public void file_selector1(){

		GUI=new JFrame("My Search Engine");
		panel = new JPanel(null);
		panel.setLayout( new BorderLayout());
		panel.setBackground(Color.CYAN);
		GUI.add(panel);
		
		button1= new JButton("select first file");
		button2= new JButton("select second file");
		button3= new JButton("Search");
		textfield1 = new JTextField();
		area1 = new JTextArea();
		area2 = new JTextArea();

		button1.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);
		textfield1.setText("Please enter you word");
		area1.setText("MATCHES FOUND");
		area1.setEditable(false);

		button1.setPreferredSize(new Dimension(150, 40));
		button2.setPreferredSize(new Dimension(150, 40));
		area1.setPreferredSize(new Dimension(80, 40));

		
		panel.add(area1,BorderLayout.CENTER);
		panel.add(button1, BorderLayout.WEST);
		panel.add(button2, BorderLayout.EAST);
		panel.add(textfield1, BorderLayout.PAGE_START);
		panel.add(button3, BorderLayout.SOUTH);

		GUI.setVisible(true);
		GUI.setSize(800,700);
		GUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GUI.setLocationRelativeTo(null);


	}	
public void actionPerformed(ActionEvent e) {
	//Selecting the first file.
	if(e.getSource()==button1) 
{		
		//GUI choosing file
		chooser chose=new chooser();
		one= chose.chooser();
		return;
}
	if(e.getSource()==button2) {
		//GUI menu
		chooser chose1=new chooser();
		two= chose1.chooser();
		
		return;
}
	
if(e.getSource()==button3) {
	int count1=0;
	int count2=0;
	search=textfield1.getText();
	area1.setText("");
	
	//checking if the inputer term is in the file
	try {
		//Checking for the first file
		if (one.contains(search)) {
			area1.append("\n\nMatches from first file");
			String[] sp = one.split(" +"); // Dividing the file by finding spaces between the words
		    String[] search2 = search.split(" +"); // Finding if there is one or multiple words entered in the search menu
		    
			    for (int i = 0; i < sp.length; i++) {
			    	int j = 0;

			        while (j < search2.length && i+j < sp.length && sp[i+j].equals(search2[j])) 
			        {j++;
			        }           
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
				            count1=count1 +1;//calculating the total amount of finds.
				            area1.append("\n"+word.toString());
				        }
				    }
			}
			else 
				area1.append("\nThe word you have enter is not found in the first file");
		}
		catch (Exception f2) {
			area1.append("\nFirst file not selected");
		}
	try {
		if (two.contains(search)) {
			area1.append("\n\nMatches from second file");
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
				            count2=count2 +1;//calculating the total amount of finds.
				            area1.append("\n"+word.toString());
				        }
				    }
			}
			else 
				area1.append("\nThe word you have enter is not found in the second file");
}
catch (Exception f2) {
	area1.append("\nSecond file not selected");
}
	//Checking if any matches have been found
	if ( textfield1.getText().isBlank() || textfield1.getText().equals("Please enter you word")) {
		area1.append("\nYou havent enter a search word");}

	else
		if(count1==0 && count2==0) {
			area1.append("\n\nThe word which you have enter doesnt have any matches");
		}
		else if (count1>count2 && count1!=count2) {
			area1.append("\n\nFirst file has more matches than the second one");
		}
		else if (count2>count1 && count2!=count1) {
			area1.append("\n\nSecond file has more matches than the first one");
		}		
		else 
		area1.append("\n\nBoth files have the same amount of matches");
}

}
	
	
	
}			
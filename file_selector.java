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

	public void file_selector1(){
		GUI=new JFrame("My Search Engine");
		panel = new JPanel(null);
		panel.setLayout( new FlowLayout());
		panel.setBackground(Color.CYAN);
		GUI.add(panel);
		
		button1= new JButton("select first file");
		button1.addActionListener(this);
		button2= new JButton("select second file");
		button2.addActionListener(this);
		textfield1 = new JTextField();
		textfield1.setText("Please enter you word");
		button3= new JButton("Search");
		button3.addActionListener(this);

		panel.add(button1);
		panel.add(button2);
		panel.add(textfield1);
		panel.add(button3);


		GUI.setVisible(true);
		GUI.setSize(400,400);
		GUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GUI.setLocationRelativeTo(null);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==button1) {
			JFileChooser fileChooser = new JFileChooser();
			response1 = fileChooser.showOpenDialog(null);
			
			if(response1 == JFileChooser.APPROVE_OPTION) {
				File file1 =new File(fileChooser.getSelectedFile().getAbsolutePath());
				// arraylist to store strings
		        List<String> listOfStrings = new ArrayList<String>();
		       
		        // load content of file based on specific delimiter
					try {
						sc = new Scanner(new FileReader(file1))
						                 .useDelimiter(",\\s*");
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();}

		        // checking end of file
		        while (sc.hasNext()) {
		            str = sc.next();
		            // adding each string to arraylist
		            listOfStrings.add(str);}
		       
		        // convert any arraylist to array
		        String[] array= listOfStrings.toArray(new String[0]);
		        
		       
		        // print each string in array
		        for (String eachString : array) {
		           one=one+eachString;
		        }
		        if (one!=null)
		        	System.out.println("A file which is not empty has been selected");
		        else
		        	System.out.println("An empty file has been selected");}
			}
		
		
		
	if(e.getSource()==button2) {
			two=null;
			JFileChooser fileChooser = new JFileChooser();
			response2 = fileChooser.showOpenDialog(null);
			
			if(response2 == JFileChooser.APPROVE_OPTION) {
				File file2 =new File(fileChooser.getSelectedFile().getAbsolutePath());
				
		        // arraylist to store strings
		        List<String> listOfStrings= new ArrayList<String>();
		       
		        // load content of file based on specific delimiter
					try {
						sc = new Scanner(new FileReader(file2))
						                 .useDelimiter(",\\s*");
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();}

		        // checking end of file
		        while (sc.hasNext()) {
		            str = sc.next();
		            // adding each string to arraylist
		            listOfStrings.add(str);}
		       
		        // convert any arraylist to array
		        String[] array= listOfStrings.toArray(new String[0]);
		       
		        // print each string in array
		        for (String eachString : array) {
		            two=two+eachString;
		        }
		        if (two!=null)
		        	System.out.println("A file which is not empty has been selected");
		        else
		        	System.out.println("An empty file has been selected");
		        
		        }}
try {
		if(e.getSource()==button3) {
			int count1=0;
			int count2=0;
			search=textfield1.getText();
			
			try {
			if (one.contains(search)) {
				System.out.println("\n\nMatches from the first file");
				
				 String[] sp = one.split(" +"); // "+" for multiple spaces

				    String[] spMulti = search.split(" +"); // "+" for multiple spaces
				    for (int i = 0; i < sp.length; i++) {
				        int j = 0;
				        while (j < spMulti.length && i+j < sp.length && sp[i+j].equals(spMulti[j])) {
				            j++;
				        }           
				        if (j == spMulti.length) { // found spMulti entirely
				            StringBuilder surr = new StringBuilder();
				            if (i-2 > 0){ surr.append(sp[i-2]); surr.append(" "); }
				            if (i-1 > 0){ surr.append(sp[i-1]); surr.append(" "); }
				            for (int k = 0; k < spMulti.length; k++) {
				                if (k > 0){ surr.append(" "); }
				                surr.append(sp[i+k]);
				            }
				            if (i+spMulti.length < sp.length) {
				                surr.append(" ");
				                surr.append(sp[i+spMulti.length]);
				            }
				            if (i+spMulti.length+1 < sp.length) {
				                surr.append(" ");
				                surr.append(sp[i+spMulti.length+1]);
				            }
				            System.out.println(surr.toString());
				            count1=count1 +1;
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

				    String[] sp = two.split(" +"); // "+" for multiple spaces

				    String[] spMulti = search.split(" +"); // "+" for multiple spaces
				    for (int i = 0; i < sp.length; i++) {
				        int j = 0;
				        while (j < spMulti.length && i+j < sp.length && sp[i+j].equals(spMulti[j])) {
				            j++;
				        }           
				        if (j == spMulti.length) { // found spMulti entirely
				            StringBuilder surr = new StringBuilder();
				            if (i-2 > 0){ surr.append(sp[i-2]); surr.append(" "); }
				            if (i-1 > 0){ surr.append(sp[i-1]); surr.append(" "); }
				            for (int k = 0; k < spMulti.length; k++) {
				                if (k > 0){ surr.append(" "); }
				                surr.append(sp[i+k]);
				            }
				            if (i+spMulti.length < sp.length) {
				                surr.append(" ");
				                surr.append(sp[i+spMulti.length]);
				            }
				            if (i+spMulti.length+1 < sp.length) {
				                surr.append(" ");
				                surr.append(sp[i+spMulti.length+1]);		                
				            }
				            System.out.println(surr.toString());
				            count2=count2 +1;
				        }
				    }
				}
			else 
				System.out.println("\nThe word you have enter is not found in the second file");
			}
			catch (Exception f2) {
				System.out.println("Second file not selected");
			}
			
			if ( textfield1.getText().isBlank() || textfield1.getText().equals("Please enter you word")) {
				System.out.println("You havent enter a search word");}
			
			else	
				if (count1>count2 && count1!=count2) {
					System.out.println("\nFirst file has more matches than the second one");
				}
				else if (count2>count1 && count2!=count1) {
					System.out.println("\nSecond file has more matches than the first one");
				}
				
				else 
					System.out.println("\nBoth files have the same amount of matches");
			
			
		}
}
	
	catch (Exception f) {
		System.out.println("Files not selected");}

}}			
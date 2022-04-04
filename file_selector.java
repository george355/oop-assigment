package assigment;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.module.ModuleDescriptor.Exports;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
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
	
	public String search;
	
		JButton button1;
		JButton button2;
		JTextField textfield1;
		JButton button3;

	file_selector (){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout( new FlowLayout());
		
		button1= new JButton("select first file");
		button1.addActionListener(this);
		
		button2= new JButton("select second file");
		button2.addActionListener(this);
		
		textfield1 = new JTextField();
		textfield1.setText("Please enter you word");
		
		button3= new JButton("Search");
		button3.addActionListener(this);
		
		this.add(button1);
		this.add(button2);
		this.add(textfield1);
		this.add(button3);
		this.pack();
		this.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==button1) {
			JFileChooser fileChooser = new JFileChooser();
			response1 = fileChooser.showOpenDialog(null);
			
			if(response1 == JFileChooser.APPROVE_OPTION) {
				File file1 =new File(fileChooser.getSelectedFile().getAbsolutePath());
				System.out.println(file1);
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
		           System.out.println(eachString);
		           one=eachString;
		        }}}
		
		
	if(e.getSource()==button2) {
			JFileChooser fileChooser = new JFileChooser();
			response2 = fileChooser.showOpenDialog(null);
			
			if(response2 == JFileChooser.APPROVE_OPTION) {
				File file2 =new File(fileChooser.getSelectedFile().getAbsolutePath());
				System.out.println(file2);
				
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
		            System.out.println(eachString);
		            two=two+eachString;
		        }
		        System.out.println(two);
		        }}
	
		if(e.getSource()==button3) {
			//System.out.println(one);
			//System.out.println(two);
			
			search=textfield1.getText();
			System.out.println(search);

			if (one.contains(search)) {
				 String[] sp = one.split(" +"); // "+" for multiple spaces

				    String[] spMulti = search.split(" +"); // "+" for multiple spaces
				    for (int i = 0; i < sp.length; i++) {
				        int j = 0;
				        while (j < spMulti.length && i+j < sp.length 
				                                  && sp[i+j].equals(spMulti[j])) {
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
				        }
				    }
			}
			
			if (two.contains(search)) {
				 System.out.println("fuck this");

				    String[] sp = two.split(" +"); // "+" for multiple spaces

				    String[] spMulti = search.split(" +"); // "+" for multiple spaces
				    for (int i = 0; i < sp.length; i++) {
				        int j = 0;
				        while (j < spMulti.length && i+j < sp.length 
				                                  && sp[i+j].equals(spMulti[j])) {
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
				        }
				    }
				}
		}}}
				


		

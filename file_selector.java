package assigment;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.lang.module.ModuleDescriptor.Exports;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class file_selector extends JFrame implements ActionListener{
	
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
			
			
			int response1 = fileChooser.showOpenDialog(null);
			
			if(response1 == JFileChooser.APPROVE_OPTION) {
				File file =new File(fileChooser.getSelectedFile().getAbsolutePath());
				System.out.print(file);
			}
			
		}
		if(e.getSource()==button2) {
			JFileChooser fileChooser = new JFileChooser();
			
			
			int response2 = fileChooser.showOpenDialog(null);
			
			if(response2 == JFileChooser.APPROVE_OPTION) {
				File file =new File(fileChooser.getSelectedFile().getAbsolutePath());
				System.out.print(file);
			}
			
		}
		
	}

}

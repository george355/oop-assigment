package assigment;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JFileChooser;

public class chooser {

	public String chooser()
		{
			String file = null;
			JFileChooser fileChooser = new JFileChooser();
			int response1 = fileChooser.showOpenDialog(null);
				
			if(response1 == JFileChooser.APPROVE_OPTION) {
				File file1 =new File(fileChooser.getSelectedFile().getAbsolutePath());
				// arraylist to store strings
			    List<String> listOfStrings = new ArrayList<String>();
			       
			    Scanner sc = null;
				// load content of file based on specific delimiter
					try {
						sc = new Scanner(new FileReader(file1)).useDelimiter(",\\s*");
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

			    // checking end of file
			    while (sc.hasNext()) {
			        String str = sc.next();
			        // adding each string to arraylist
			        listOfStrings.add(str);}
			       
			    // convert the arraylist to string
			    file= listOfStrings.toString();

			//return file;
		}
			return file;
	}
}

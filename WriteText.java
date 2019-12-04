package dec4;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class WriteText {

	public static void main(String[] args)throws Throwable {
	File f=new File("D://Selenium.txt");
	f.createNewFile();
	FileWriter fw=new FileWriter(f);
	BufferedWriter bw=new BufferedWriter(fw);
	bw.write("iam so lazy");
	bw.newLine();
	bw.write("i will never practise");
	bw.newLine();
	bw.write("but i want job in top mnc");
	bw.flush();
	bw.close();
	
			
			

	}

}

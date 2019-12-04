package dec4;

import java.io.BufferedReader;
import java.io.FileReader;

public class Readdatafromfile {
	public static void main(String[] args) throws Throwable{
		FileReader fr=new FileReader("D://Selenium.txt");
		BufferedReader br=new BufferedReader(fr);
	String str=br.readLine();
	/*while((str=br.readLine())!=null)
	{
	System.out.println(str);	
	}*/
	for(int i=0;i<str.length();i++)
	{
		System.out.println(str.charAt(i));
	}
	}
}

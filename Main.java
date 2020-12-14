import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import java.io.*;  

public class Main {

    public static void getHTTPResponseStatusCode(String websiteUrl) throws IOException {
	URL url = new URL(websiteUrl);
        HttpURLConnection http = (HttpURLConnection)url.openConnection();
	if(http.getResponseCode()<400) 	
	{
	System.out.print(" "+http.getResponseCode());
	}
    }
    public static void main(String [] as) throws IOException
    {	
	Scanner obj=new Scanner(System.in);
	System.out.println("Please enter the website url");
	String websiteUrl=obj.next();
	obj.close();
	try  
	{  
	FileInputStream fis=new FileInputStream("wordlist.txt");       
	Scanner sc=new Scanner(fis);	
	System.out.print("Successful code are:[");     
	while(sc.hasNextLine())  
	{ 
	getHTTPResponseStatusCode(websiteUrl+"/"+sc.nextLine());      
	}  
	sc.close();       
	}  
	catch(Exception e)  
	{  
	e.printStackTrace();  
	}  
	System.out.print(" ]");
        
    }
}
import java.io.*;
import java.net.*;

public class Main {

	public Socket client = null;
	public DataOutputStream os = null;
    public DataInputStream is = null;
	
	public static void main(String[] args) {
		
		
		try {
			Socket client = new Socket("10.5.38.127", 5000);
			System.out.println("Connection is " + client.isConnected());
			
			PrintWriter out = new PrintWriter(client.getOutputStream(), true);
			BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
			BufferedReader stdln = new BufferedReader(new InputStreamReader(System.in));
			
			String userInput;
			while ((userInput = stdln.readLine()) != null) {
			    out.println(userInput);
			    
			    System.out.println("echo: " + in.readLine());
			}
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			System.out.println("unkown host");
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("ioexception");
			e.printStackTrace();
		}
		
		
	}

}

import java.io.*;
import java.net.*;
import java.lang.Thread;

public class Main {

	public Socket client = null;
	public DataOutputStream os = null;
    public DataInputStream is = null;
	
	public static void main(String[] args) {
		try {
			String userInput;
			BufferedReader stdln = new BufferedReader(new InputStreamReader(System.in));
			//userInput = stdln.readLine();
			Socket client = new Socket("10.5.37.154", 5000);
			System.out.println("Connection is " + client.isConnected());
			
			SendMessages send = new SendMessages(client);
			ReceiveMessages receive = new ReceiveMessages(client);
			
			Thread t1 = new Thread(send);
			Thread t2 = new Thread(receive);
			t1.start();
			t2.start();
			
//			PrintWriter out = new PrintWriter(client.getOutputStream(), true);
//			BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
//			
//			while ((userInput = stdln.readLine()) != null) {
//			    out.println(userInput);
//			    
//			    System.out.println("echo: " + in.readLine());
//			}
			
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

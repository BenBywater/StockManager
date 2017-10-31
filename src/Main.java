import java.io.*;
import java.net.*;
import java.lang.Thread;

public class Main {

	public Socket client = null;
	public static String ipAddress = "10.80.211.211";
	
	public static void main(String[] args) {
		try {
			System.out.println("Do you want to use the static IP Address? Y/N");
			BufferedReader stdln = new BufferedReader(new InputStreamReader(System.in));
			String userInput = stdln.readLine();
			if(userInput.equals("N") || userInput.equals("n"))
			{
				System.out.println("Enter IP Address");
				userInput = stdln.readLine();
				ipAddress = userInput;
			}
			Socket client = new Socket(ipAddress, 5000);
			System.out.println("Connection is " + client.isConnected());
			
			SendMessages send = new SendMessages(client);
			ReceiveMessages receive = new ReceiveMessages(client);
			
			Thread t1 = new Thread(send);
			Thread t2 = new Thread(receive);
			t1.start();
			t2.start();
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
			}
	}
		
}

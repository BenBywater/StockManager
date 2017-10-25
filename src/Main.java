import java.io.*;
import java.net.*;
import java.lang.Thread;

public class Main {

	public Socket client = null;
	public DataOutputStream os = null;
    public DataInputStream is = null;
	
	public static void main(String[] args) {
		try {
			Socket client = new Socket("10.5.37.154", 5000);
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

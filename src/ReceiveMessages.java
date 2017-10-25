import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.*;

public class ReceiveMessages implements Runnable {
	public Socket clientSocket = null; 
	public BufferedReader in = null;
	
	public ReceiveMessages(Socket client) throws IOException
	{
		clientSocket = client;
		in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
	}
	
	public void PrintMessage() throws IOException
	{
		System.out.println("Server: " + in.readLine());
	}

	@Override
	public void run() {
		while(true)
		{
			try {
				PrintMessage();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}	
	}
}

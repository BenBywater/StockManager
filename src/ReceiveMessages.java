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
	
	public void PrintMessage(String userInput) throws IOException
	{
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true)
		{
			try {
					System.out.println("echo: " + in.readLine());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		

}

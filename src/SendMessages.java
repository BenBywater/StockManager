import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.*;

public class SendMessages implements Runnable {
	public Socket clientSocket = null;
	public PrintWriter out = null;
	public String userInput = null;
	public BufferedReader stdln = null;
	
	public SendMessages(Socket client) throws IOException
	{
		clientSocket = client;
		out = new PrintWriter(clientSocket.getOutputStream(), true);
		stdln = new BufferedReader(new InputStreamReader(System.in));
	}
	
	public void SendCommand(String command)
	{
		out.println(command);
	}

	@Override
	public void run() {
		try {
			while ((userInput = stdln.readLine()) != null) {
			    SendCommand(userInput);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
}

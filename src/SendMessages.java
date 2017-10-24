import java.io.IOException;
import java.io.PrintWriter;
import java.net.*;

public class SendMessages implements Runnable {
	public Socket clientSocket = null;
	public PrintWriter out = null;
	
	public SendMessages(Socket client) throws IOException
	{
		clientSocket = client;
		out = new PrintWriter(clientSocket.getOutputStream(), true);
	}
	
	public void SendCommand(String command)
	{
		out.println(command);
	}

	@Override
	public void run() {
		while(true)
		{
			out.println("HELO");
		}
		
	}
}

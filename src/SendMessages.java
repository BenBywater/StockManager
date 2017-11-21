import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.*;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class SendMessages implements Runnable {
	public Socket clientSocket = null;
	public PrintWriter out = null;
	public String userInput = null;
	public BufferedReader in = null;
	public boolean running = true;
	public ReceiveMessages rmGlobal = null;
	
	public SendMessages(Socket client, ReceiveMessages rm) throws IOException
	{
		rmGlobal = rm;
		clientSocket = client;
		out = new PrintWriter(clientSocket.getOutputStream(), true);
		in = new BufferedReader(new InputStreamReader(System.in));
	}
	
	
	
	public void SendCommand(String command)
	{
		out.println(command);
	}

	public void StopRunning()
	{
		running = false;
	}
	
	@Override
	public void run() {
		while(running)
		{
			try {
				while ((userInput = in.readLine()) != null) {
					Map<String, String> boughtShares = rmGlobal.getBoughtShares();
					
					if (userInput.equals("LIST SHARES"))
					{	
						if (!boughtShares.isEmpty())
						{
							for (Map.Entry<String, String> entry : boughtShares.entrySet()) {
							String key = entry.getKey();
							String value = entry.getValue();
							System.out.println(key + " " + value);
							}
						}
							else 
							{
								System.out.println("NO BOUGHT SHARES");
							}
						
					} 
					else {
						SendCommand(userInput);
					}
				    
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.*;
import java.util.HashMap;
import java.util.Map;

public class ReceiveMessages implements Runnable {
	public Socket clientSocket = null; 
	public BufferedReader in = null;
	public static Map<String, String> boughtShares = new HashMap<String, String>();
	
	public ReceiveMessages(Socket client) throws IOException
	{
		clientSocket = client;
		in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
	}
	
	public Map<String, String> getBoughtShares()
	{
		return boughtShares;
	}
	
	public void PrintMessage() throws IOException
	{
		
		String str1 = in.readLine();
		
		System.out.println("Server: " + str1);
		
		if(str1.contains("BOUGHT"))
			checkForBoughtShares(str1);
	}

	@Override
	public void run() 
	{
		while(true)
		{
			try {				
				PrintMessage();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}	
	}
	
	public void checkForBoughtShares(String result) throws IOException
	{
		
		String[] tokens = result.split(":"); 
		String stockName = tokens[3].split(" ")[1];
		String stockAmount = tokens[2].split(" ")[0];
		boughtShares.put(stockName.concat(tokens[4]), stockAmount);		
		System.out.println(stockAmount + " shares in " + stockName.concat(tokens[4]));

	}
}

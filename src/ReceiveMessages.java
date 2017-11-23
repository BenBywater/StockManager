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
		
		String serverOut = in.readLine();
		
		System.out.println("Server: " + serverOut);
		
		if(serverOut.contains("BUY"))
		{
			checkForBoughtShares(serverOut);
		}
		else if(serverOut.contains("SELL"))
		{
			RemoveStock(serverOut);
		}
			
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
		String stockName = tokens[3];
		String stockAmount = tokens[2];
		boughtShares.put(stockName, stockAmount);		
		System.out.println(stockAmount + " shares in " + stockName.concat(tokens[4]));

	}
	
	public void RemoveStock(String serverOut)
	{
		String[] tokens = serverOut.split(":");
		String stock = boughtShares.get(tokens[3]);
		int stockstock = Integer.parseInt(stock);
		int tokensStock = Integer.parseInt(tokens[2]);
		
		int stockAmount = stockstock - tokensStock;
		
		String finalStock = Integer.toString(stockAmount);
		
		boughtShares.put(tokens[3], finalStock);
		
	}
}

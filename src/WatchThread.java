import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.*;
import java.util.HashMap;
import java.util.Map;

public class WatchThread implements Runnable {
	public Socket clientSocket = null; 
	public BufferedReader in = null;
	public static Map<String, String> Shares = new HashMap<String, String>();
	String stockName = null;
	String stockPrice = null;
	boolean sellOrBuy = false;
	
	public WatchThread(Socket client, String sName, String sPrice, boolean buy) throws IOException
	{
		clientSocket = client;
		in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		stockName = sName;
		stockPrice = sPrice;
		buy = sellOrBuy;
	}

	public boolean MonitorBuy()
	{
		boolean isReady = false;
		
		while(isReady == false)
		{
			
		}
		
		return isReady;
	}
	
	public boolean MonitorSell()
	{
		boolean isReady = false;
		
		return isReady;
	}
	
	@Override
	public void run() {
		//buy sotck
		if(sellOrBuy == true)
		{
			if(MonitorBuy())
			{
				System.out.println("Stock " + stockName + " has been sold for "+ stockPrice + " or lower.");
			}
		}
		//sell stock
		else
		{
			if(MonitorSell())
			{
				System.out.println("Stock " + stockName + " has been sold for " + stockPrice + " or lower.");
			}
		}
		
		
	}

}

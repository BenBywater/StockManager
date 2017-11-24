import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Facade {
	public Socket clientSocket = null;
	public PrintWriter out = null;
	public String userInput = null;
	public BufferedReader in = null;
	String ID = "";
	
	public Facade(Socket client) throws IOException
	{
		clientSocket = client;
		out = new PrintWriter(clientSocket.getOutputStream(), true);
		in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		
		SendCommand();
	}
	
	
	public void SendCommand() throws IOException
	{
		out.println("REGI");
		
		String serverOut = in.readLine();
		
		System.out.println("Server: " + serverOut);
		
		if(serverOut.contains("REGI"))
		{
			ID = CheckforID(serverOut);
		}
	}
	
	public String CheckforID(String serverOut)
	{
		String[] tokens = serverOut.split(":"); 
	
		return tokens[2];
	}
	
	public String GetID()
	{	
		return ID;
	}
	
	

}

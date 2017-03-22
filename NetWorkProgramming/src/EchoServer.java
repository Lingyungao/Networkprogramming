import java.net.Socket;
import java.net.ServerSocket;
import java.io.*;

public class EchoServer {

	
	
    public static void main(String[] args) throws Exception {
    	int portNumber;
        String x;
        portNumber = 4444;
        //set port as 4444
        

    	try {
    		ServerSocket serverSocket = new ServerSocket(portNumber);
            System.out.println("Started server on port " + portNumber);
            //it will try call to start a connection
            
            Socket clientSocket = serverSocket.accept();
            System.out.println("Accepted connection from client");
            //check if port is accepted
            
    	    PrintWriter out =
    	        new PrintWriter(clientSocket.getOutputStream(), true);
    	    BufferedReader in = new BufferedReader(
    	        new InputStreamReader(clientSocket.getInputStream()));
    	    
    	    x= in.readLine();
    	    System.out.printf("%s\n", x);
    	    
    	    
    	    
            System.err.println("Closing connection with client");
            out.close();
            in.close();
            clientSocket.close();
    	}
    	catch (Exception error) {
    	    System.err.println("Caught Exception: " + error.getMessage());
    	    throw error;
    	}
        }
    }


import java.net.ServerSocket;
import java.net.Socket;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
* EchoServer is a simple server that listens on a port for incoming
* connections, accepts them, and writes all incoming data back out to
* the socket.<BR>
*
* To run both the EchoServer and the EchoClient on the same machine, you
* need to pick a port (any unclaimed port such as 2707 will do), and you
* will use 127.0.0.1 as the hostname that the client connects to. <BR>
*
* Usage: <BR>
* {@code t1$ java EchoServer 2707}<BR>
* {@code t2$ java EchoClient 127.0.0.1 2707}<BR>
*
* Once both the server and client are running, then you can enter
* messages into the client and see them received and echoed by the
* server.
*/
public class EchoServer {
  public static void main(String[] args) {
    if(args.length != 1) {
      System.err.println("Usage: java EchoServer <port number>");
      System.exit(1);
    }

    int portNumber = Integer.parseInt(args[0]);

    try ( ServerSocket serverSocket = new ServerSocket(portNumber);
          //wait for and accept a client request
          Socket clientSocket = serverSocket.accept();
          // create a writer that will autoflush to write back to the
          // client
          PrintWriter out = 
              new PrintWriter(clientSocket.getOutputStream(), true);
          // get the Reader to read in from the client
          BufferedReader in = new BufferedReader(
              new InputStreamReader(clientSocket.getInputStream()));
    ) {
      String line;
      while((line = in.readLine()) != null) {
        System.out.printf("Received input: %s\n", line);
        System.out.println("Sending it back");
        out.println(line);
      }
    } catch (IOException e) {
      System.err.println("IOException: Listening to port " + portNumber);
      System.err.println(e.getMessage());
    }
  }
}

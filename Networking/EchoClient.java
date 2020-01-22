import java.net.Socket;
import java.net.UnknownHostException;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.Scanner;

/**
* EchoClient is a simple client that connects to a server, write user
* input out to it, and reads and prints the server's responses. <BR>
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
public class EchoClient {
  public static void main(String[] args) { 
    if (args.length != 2) {
      System.err.println("Usage: java EchoClient <host name> <port number>");
      System.exit(1);
    }

    String hostName = args[0];
    int portNumber = Integer.parseInt(args[1]);

    try (
      // open a socket to write to a host at the given port number
      Socket echoSocket = new Socket(hostName, portNumber);
      // Create a writer that will autoflush content to the socket
      PrintWriter socketOut = 
    new PrintWriter(echoSocket.getOutputStream(), true);
      BufferedReader socketInput = new BufferedReader(
          new InputStreamReader(echoSocket.getInputStream()));
      Scanner stdIn = new Scanner(System.in);
    ) {
      String userMessage;
      do {
        System.out.printf("Enter message to server (q to quit): ");
        userMessage = stdIn.nextLine().trim();
        if(userMessage.equals("q")) {
          break;
        }
        // write message to the socket
        socketOut.println(userMessage);
        // read back message from server and print it out.
        System.out.println("echo: " + socketInput.readLine());
      } while (true);
    } catch (UnknownHostException e) {
      System.err.println("Don't know about host " + hostName);
      System.err.println(e.getMessage());
      System.exit(1);
    } catch (IOException e) {
      System.err.println("Failure establishing connection to " + hostName);
      System.err.println(e.getMessage());
      System.exit(1);
    }
  }
}

import java.net.URL;
import java.net.MalformedURLException;

import java.io.IOException;

import java.util.Scanner;

/**
* URLReader connects to a URL, retrieved its contents and prints them to
* the screen. <BR>
*
* Usage:<BR>
* {@code $ java URLReader http://checkip.dyndns.com}
*/
public class URLReader {
  public static void main(String[] args) {
    if(args.length != 1) {
      System.err.println("Usage: java URLReader <url>");
      System.exit(1);
    }
    String urlStr = args[0];

    try {
      URL url = new URL(urlStr);
      Scanner in = new Scanner(url.openStream());
      while(in.hasNext()) {
        System.out.println(in.nextLine());
      }
    } catch (MalformedURLException e) {
      System.err.println("Invalid URL, check url format");
      System.err.println(e.getMessage());
    } catch (IOException e) {
      System.err.println("Failed to open stream to URL");
      System.err.println(e.getMessage());
    }
  }
}

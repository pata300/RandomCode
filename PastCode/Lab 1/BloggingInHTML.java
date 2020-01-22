/*
	
	Patrick Griffin
	Problem 2: Blogging in HTML

*/

import java.util.Scanner;

public class BloggingInHTML{

	public static void main(String[] args){

		//make variables for the tags to print
		String tagHTML = "<html>";
		String endTagHTML = "</html>";
		String tagBody = "<body>";
		String endTagBody = "</body>";
		String tagHeader = "<h1>";
		String endTagHeader = "</h1>";
		String tagImage = "<img src='";
		String endTagImage = "'/>";
		String tagParagraph = "<p>";
		String endTagParagraph = "</p>";
		String tagSmall = "<small>";
		String endTagSmall = "</small>";

		//variables for user input strings
		String header;
		String imagePNG;
		String description;
		String author;
		String date;

		//construct a scanner
		Scanner input = new Scanner(System.in);

		//ask user for header
		// System.out.print("What is your header? ");
		header = input.nextLine();

		// System.out.print("Where is your .PNG file located? ");
		imagePNG = input.nextLine();

		// System.out.print("What is your description? ");
		description = input.nextLine();

		// System.out.print("What the author's name? ");
		author = input.nextLine();

		// System.out.print("What is the date?(##/##/####) ");
		date = input.nextLine();

		//print out HTML code to user
		System.out.println(tagHTML + tagBody + tagHeader + header + endTagHeader + tagImage + imagePNG + endTagImage + tagParagraph + description + endTagParagraph + tagSmall + "By " + author + ", " + date + endTagSmall + endTagBody + endTagHTML + "\n");


	}
}
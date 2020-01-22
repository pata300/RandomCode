/*
	
	Patrick Griffin
	Problem 5: Student Grader

*/

import java.util.Scanner;

public class StudentGrader {

	public static void main(String[] args) {

		double testGrade;
		double testAvg;
		double labGrade;
		double labAvg;
		double homeworkGrade;
		double homeworkAvg;

		double finalAvg;

		Scanner input = new Scanner(System.in);

		testGrade = input.nextDouble();
		homeworkGrade = input.nextDouble();
		labGrade = input.nextDouble();

		testAvg = testGrade * 0.4;
		labAvg = labGrade * 0.1;
		homeworkAvg = homeworkGrade * 0.5;

		finalAvg = testAvg + labAvg + homeworkAvg;

		System.out.printf("%.1f%n", finalAvg);

	}
}
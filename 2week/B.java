package twoweek;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		int numStudent = getNumberKeyboard("학생 수 : ");
		int[] scores = getScoresLine(numStudent);
		printSumAverage(scores);
	}
	
	static int getNumberKeyboard(String message) {
		Scanner sc = new Scanner(System.in);
		System.out.print(message);
		int a = sc.nextInt();
		return a;
	}
	
	static int[] getScoresLine(int numStudent) {
		Scanner sc = new Scanner(System.in);
		int[]scores = new int[numStudent];
		System.out.print(numStudent + "명의 성적 : ");
		for( int i = 0; i < scores.length; i++ ) {
			scores[i] = sc.nextInt();
		}
		return scores;
	}
	
	public static void printSumAverage(int[] scores) {
		int Sum = 0;
		for (int score : scores) {
			Sum += score;
		}
		int Average = Sum/scores.length;
		
		System.out.println(">> 합계 : " + Sum);
		System.out.println(">> 평균 : " + Average);
		}

}

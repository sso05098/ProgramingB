package oneweek;

import java.util.Scanner;

public class Chapter2_9 {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	System.out.print("전공 이수 학점 : ");
	int a = sc.nextInt();
	System.out.print("교양 이수 학점 : ");
	int b = sc.nextInt();
	System.out.print("일반 이수 학점 : ");
	int c = sc.nextInt();
	boolean q = a + b + c >= 140 && a >= 70 && ((b >= 30 && c >= 30) || (b+c >= 80));
	if ( q == true ) {
		System.out.println("졸업 가능");
	}else {		
		System.out.println("졸업 불가능");
	}
	}
}

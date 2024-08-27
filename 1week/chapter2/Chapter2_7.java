package oneweek;

import java.util.Scanner;

public class Chapter2_7 {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	System.out.print("정수를 입력해라 ");
	int a = sc.nextInt();
	
	boolean q = (a%4==0 && a%5==0);
	boolean w = (a%4==0 || a%5==0);
	boolean e = (a%4==0 ^ a%5==0);
	
	System.out.println("1 : " + q);
	System.out.println("2 : " + w);
	System.out.println("3 : " + e);
}
}

package twoweek;

import java.util.Scanner;

public class A {
	public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int b = 1;
	while(b==1) {
	System.out.print("숫자를 입력하세요 : ");
	int a = sc.nextInt();
	if( a%2==0 ) {
		System.out.println(">> 짝수입니다.");
	}else {
		System.out.println(">> 홀수입니다.");
	}
	System.out.print("계속 하시겠습니까? (0-멈춤/1-계속) : ");
	b = sc.nextInt();
	
}
}
}

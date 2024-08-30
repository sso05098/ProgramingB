package twoweek;

import java.util.Scanner;

public class Star06 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("숫자를 입력하세요 : ");
		int num = sc.nextInt();
		
		for(int i = 1; i <= num; i++) {
			for(int j=1; j < i; j++) {
				System.out.print(" ");
			}
			for(int k=1; k <= (2*num)-(2*i-1); k++) {
				System.out.print("*");
			}
			System.out.println();
		}
}
}

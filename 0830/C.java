package twoweek;

import java.util.Scanner;

public class C {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("배열의 크기를 입력해 : ");
		int a = sc.nextInt();
		int[] number = new int[a];
		System.out.print("정수를 입력해 : ");
		for (int i = 0; i < number.length; i++) {
			number[i] = sc.nextInt();
		}

		int Sum = getSum(number);

		System.out.println("합계 : " + Sum);

	}

	static int getSum(int[] array) {
		int Sum = 0;
		for (int num : array) {
			Sum += num;
		}
		return Sum;
	}

}

package twoweek;

import java.util.Scanner;

public class D {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("배열의 크기 : ");
		int a = sc.nextInt();
		int[] number = new int[a];

		System.out.print("정수를 입력 : ");
		for (int i = 0; i < number.length; i++) {
			number[i] = sc.nextInt();
		}

		int result = getMax(number);
		System.out.println("가장 큰 숫자는 : " + result);

	}

	static int getMax(int[] array) {
		int Max = array[0];
		for (int num : array) {
			if (num > Max) {
				Max = num;
			}
		}
		return Max;
	}

}

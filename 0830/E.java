package twoweek;

import java.util.Scanner;

public class E {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] number = { 1, 3, 10, 20, 40, 20, 10, 2 };
		System.out.print("숫자를 입력하세요 : ");
		int input = sc.nextInt();
		int result = getcount(number, input);

		System.out.println("입력한 수보다 큰 수의 개수는 " + result + "개 입니다.");
	}

	static int getcount(int[] array, int a) {
		int count = 0;
		for (int num : array) {
			if (num > a)
				count++;
		}
		return count;
	}

}

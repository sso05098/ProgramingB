package firstweek;

import java.util.Scanner;

public class Problem1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("직사각형의 가로 길이 : ");
		double a = sc.nextDouble();
		System.out.print("직사각형의 세로 길이 : ");
		double b = sc.nextDouble();
		System.out.println("직사각형의 넓이는 " + a * b + "cm입니다.");

	}

}

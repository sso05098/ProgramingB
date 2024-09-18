package practice;

import java.util.Scanner;

public class Circle {
	final double PI = 3.14;

	double r;

	public Circle(double r) {
		this.r = r;
	}

	public double circleArea() {
		return PI * r * r;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("원의 반지름 : ");
		double a = sc.nextDouble();
		Circle circle = new Circle(a);

		double Area = circle.circleArea();

		System.out.printf("반지름이 %.1f인 원의 넓이는 %.2f입니다.", a, Area);

	}

}

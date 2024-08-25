package firstweek;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Promblem3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double PI = 3.14;
		System.out.print("원의 반지름을 입력하세요(cm): ");
		double a = sc.nextDouble();

		double area = a * a * PI;

		DecimalFormat df = new DecimalFormat("#.00");
		System.out.println("원의 넓이는 " + df.format(area) + "cm입니다.");

	}
}

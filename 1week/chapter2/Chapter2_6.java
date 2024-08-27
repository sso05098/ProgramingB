package oneweek;

import java.util.Scanner;

public class Chapter2_6 {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	System.out.print("화씨온도를 입력해 ");
	int F = sc.nextInt();
	int C = (5*(F-32))/9;
	System.out.print("섭씨온도는 " + C);
}
}

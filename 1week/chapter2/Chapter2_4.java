package oneweek;

import java.util.Scanner;

public class Chapter2_4 {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	System.out.print("초 단위 정수를 입력하세요 : ");
	int sec = sc.nextInt();
	
	int h = sec/3600;
	int m = (sec % 3600)/60;
	int s = (sec % 60);
	
	System.out.println(h + "시간" + m + "분" + s +"초");
}
}

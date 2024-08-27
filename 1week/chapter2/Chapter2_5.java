package oneweek;

import java.util.Scanner;

public class Chapter2_5 {
public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("소문자를 입력하세요 : ");
        char a = sc.next().charAt(0);

        char A = (char) (a - ('a' - 'A'));

        // 결과 출력
        System.out.println("소문자: " + a);
        System.out.println("대문자: " + A);
    }
}


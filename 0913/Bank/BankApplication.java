package practice3;

import java.util.Scanner;


public class BankApplication {
	public static void main(String[] args) {
		Account[] list = new Account[100];
		int seq = 0;
		
		while(true) {
		System.out.println("-------------------------------------------");
		System.out.println("1.계좌생성 | 2.계좌목록 | 3.예금 | 4.출금 | 5.종료");
		System.out.println("-------------------------------------------");
		System.out.print("선택>");
		Scanner sc = new Scanner(System.in);
		int menuNum = sc.nextInt();
		sc.nextLine();
		
		if( menuNum == 1 ) {
			System.out.println("------");
			System.out.println("계좌생성");
			System.out.println("------");
			System.out.print("계좌번호:");
			String number = sc.nextLine();
			System.out.print("계좌주:");
			String name = sc.nextLine();
			System.out.print("초기입금액:");
			int money = sc.nextInt();
			System.out.println("결과 : 계좌가 생성되었습니다.");
			list[seq++] = new Account(name, number, money); 
		}
		
		else if( menuNum == 2 ) {
			System.out.println("------");
			System.out.println("계좌목록");
			System.out.println("------");
			for( int i = 0; i < seq; i++ ) {
				Account ac = list[i];
				

				String name = ac.getName();
				String number = ac.getNumber();
				int money = ac.getMoney();
				
				System.out.printf("계좌번호:%s \t 계좌주:%s \t 금액:%d \n",number,name,money);
				}
		}
		
		else if( menuNum == 3 ) {
			System.out.println("------");
			System.out.println("예금");
			System.out.println("------");
			System.out.print("계좌번호:");
			String number = sc.nextLine();
			boolean found = false;
			for( int i = 0; i < seq; i++ ) {
			Account ac = list[i];
			
			if ( ac.getNumber().equals (number) ) {
				System.out.print("예금액:");
				int money2 = sc.nextInt();
				ac.addMoney(money2);
				found = true;
				}
			}
			if(!found) {
				System.out.println("존재하지 않는 계좌번호입니다.");
			}
		}
		
		else if( menuNum == 4 ) {
			System.out.println("------");
			System.out.println("출금");
			System.out.println("------");
			System.out.print("계좌번호:");
			String number = sc.nextLine();
			for( int i = 0; i < seq; i++ ) {
				Account ac = list[i];
				if ( ac.getNumber().equals (number)) {
					System.out.print("출금액:");
					int money3 = sc.nextInt();
					ac.minusMoney(money3);
				}else {
					System.out.println("존재하지 않는 계좌번호입니다.");
				}
			}
		}
		
		else if( menuNum == 5 ) {
			System.out.println("프로그램 종료");
			break;
		}
		
		else {
			System.out.println("잘못된 선택입니다.다시 선택해주세요.");
		}
	}
	}
}

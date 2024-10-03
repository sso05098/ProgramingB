package practice5;

import java.util.Scanner;
import java.util.Stack;

public class BOJ9012 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		
		for( int i = 0; i < a; i++ ) {
			System.out.println(good(sc.next()));
		}
	}
		public static String good(String n) {
			Stack<Character> stack = new Stack<>();
			
			for( int i = 0; i < n.length(); i++ ) {
				char c = n.charAt(i);
				
				if( c == '(') {
					stack.push(c);
				}else if ( stack.empty()) {
					return "NO";
				}else {
					stack.pop();
				}
			}
		
		if(stack.empty()) {
			return "yes";
		}else {
			return "NO";
		}
}
}
package twoweek;

import java.util.Arrays;

public class F {

	public static void main(String[] args) {
		int[] k = { 1, 3, 5, 6, 8, 9 };
		System.out.println("지정된 배열은" + Arrays.toString(k)); // 그냥 k를쓰면 주소값이 나옴 Arrays.toString(k)); 를 써야 내용이 나옴
		int[] result = getSum(k);
		System.out.println("역순은 : " + Arrays.toString(result)); // 위와 같음

	}

	static int[] getSum(int[] array) {
		int[] a = new int[array.length];
		for (int i = 0; i < array.length; i++) {
			a[i] = array[array.length - 1 - i]; // array.length - 1 - i을 사용하여 배열 첫번째는 0부터 시작하므로 길이와 1번째 나오는 숫자가 같아야하므로 -1을 해줘야함
		}
		return a;
	}

}

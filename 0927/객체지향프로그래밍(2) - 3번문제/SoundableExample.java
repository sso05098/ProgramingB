package practice1;

public class SoundableExample {
	public static void printSound(Soundable s) {
		System.out.println(s.sound());
	}
	public static void main(String[] args) {
		printSound(new Cat());
		printSound(new Dog());
	}
}

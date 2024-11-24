package proactice01;

public class Worker01 {
	
	public static void main(String[] args)  {
		int alphabet = 'a';
		Thread t = new Worker();
		t.start();
		
		for(int i = 0; i < 5; i++) {
			System.out.println("메인 스레드 : " + (char)alphabet );
			alphabet++;
			try {
				Thread.sleep(500);
			} catch(InterruptedException e) {
				
			}
		}
	}

	static class Worker extends Thread {
		public void run() {
			for(int i = 0; i < 5; i++) {
				System.out.println("작업 스레드 : " + i);
				try {
					Thread.sleep(1000);
				} catch(InterruptedException e) {
					
				}
			}
		}
	}
}


package proactice01;

import proactice01.Worker01.Worker;

public class WorkerRamda {

	public static void main(String[] args) {
		new Thread( () -> {
			for(int i = 0; i < 5; i++) {
				System.out.println("작업 스레드 : " + i);
				try {
					Thread.sleep(1000);
				} catch(InterruptedException e) {
					
				}
			} 
		});
		Worker worker = new Worker();
		worker.start();
	
	int alphabet = 'a';
	for(int i = 0; i < 5; i++) {
		System.out.println("메인 스레드 : " + (char)alphabet);
		alphabet++;
		try {
			Thread.sleep(500);
		} catch(InterruptedException e) {
			
		}
	}
}
}
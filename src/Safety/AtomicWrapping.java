package Safety;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicWrapping {

	public static void main(String[] args) throws InterruptedException {
		
		Thread thread = new Thread(new Changing());
		thread.start();
		
		
		Thread thread2 = new Thread(new Changing());
		thread2.start();
		
		
		thread.join();
		thread2.join();
		//System.out.println(Thread.currentThread() + "Counting: "+ thread.counting );
	}
	
	
	

}

class Changing implements Runnable{
	
	AtomicInteger counting = new AtomicInteger();

	@Override
	public void run() {
		
	try {
		for(int i= 0; i<5; i++) {
		System.out.println(Thread.currentThread() + "Counting: "+ counting );
		incrementing();
		}
		
	} catch (Exception e) {
		
		e.printStackTrace();
	}
		
	}
	
	public void incrementing() {
		counting.incrementAndGet();
	}
	
	


}
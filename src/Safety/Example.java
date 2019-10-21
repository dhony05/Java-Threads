package Safety;

import java.util.concurrent.atomic.AtomicInteger;

public class Example {

	public static void main(String[] args) throws Exception {
		
		Counter newCounter = new Counter();
		
		Thread t1 = new Thread(new Runnable()
				{
			public void run() {
				
				for (int i = 1; i <= 200; i++) {
					newCounter.increment();
				}
				
			}
				});
		
		Thread t2 = new Thread(new Runnable()
		{
	    public void run() {
		
		for (int i = 1; i <= 200; i++) {
			newCounter.increment();
		}
		
	}
		});
			
		
		t1.start(); 
		t2.start();
		
		t1.join();
		t2.join();
		
		System.out.println(newCounter.count);

	}
	
	
	

}


 class Counter
{
	AtomicInteger count = new AtomicInteger();
	
	public void increment() {
		count.incrementAndGet();
	}
}

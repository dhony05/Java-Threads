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
					//System.out.println(newCounter.count);
				}
				
			}
				});
		
		Thread t2 = new Thread(new Runnable()
		{
	    public void run() {
		
		for (int i = 1; i <= 200; i++) {
			newCounter.increment();
			System.out.println(newCounter.count);
		}
		
	}
		});
			
		
		t1.start();
		t2.start();
		
		
		t1.join();
		t2.join();
		
		System.out.println(t1.currentThread());
		System.out.println(t2.currentThread());

	}
	
	
	

}


 class Counter  
{
	AtomicInteger count = new AtomicInteger();
	
	public void increment() {
		count.incrementAndGet();
	}

	
}

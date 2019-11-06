package Safety;

public class WaitAndNotify {

	public static void main(String[] args) {
		
		ThreadB b = new ThreadB();
	
		b. start();
		
		
		synchronized (b) {
		
		try {
			System.out.println("Waiting for second thread to complete...");
			b.wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Total is: "+ b.total);
		
		
		}
		
		
		

	}

}


class ThreadB extends Thread{
	
	int total;
	
	@Override
	public void run() {
		synchronized (this) {
			
			for (int i = 0; i < 10; i++) {
				
				total += i;
				System.out.println(" --- "+ total);
			}
			notify();
		}
	}
	
}

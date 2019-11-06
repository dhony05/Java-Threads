package Safety;

public class CountDownMain {

	public static void main(String[] args) {
		
		
		CountDown cd  = new CountDown();
		Runnable r = () -> {
			
			synchronized (cd) {
				cd.printCount();
			}
			
		};
		
		
		Thread one = new Thread(r, "one");
		Thread two = new Thread(r, "two");
		
		
		one.start();
		two.start();
		
		
		
	}

}

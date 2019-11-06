package Safety;

public class CountDown {

	
	public void printCount() {
		
			try {
				for (int i = 10; i >0; i--) {
					System.out.println("  ---  " + i);
				}
				
				System.out.println("BlastOff!");
			} catch (Exception e) {
				
				e.printStackTrace();
				
				System.out.println("Thread interrupted.");
			}
			
			
			
			
	}
}


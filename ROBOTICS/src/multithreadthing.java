
public class multithreadthing extends Thread { //implements Runnable
	
	private int threadnumber;
	public multithreadthing (int threadnumber) {
		this.threadnumber = threadnumber;
	}
	
	@Override
	public void run() {
		for (int i=1; i<=5; i++) {
			System.out.println(i + " from thread number "+threadnumber);
			
			if(threadnumber == 3) {
				throw new RuntimeException();
			}
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
		}
	}
}
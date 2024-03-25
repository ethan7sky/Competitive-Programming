
public class multithreading {
	
	public static void main(String[] args) {
		
		multithreadthing thread1 = new multithreadthing(1);
		//if it implements Runnable
		//Thread mythread = new Thread(thread1);
		//mythread.start();
		
		thread1.start();
		multithreadthing thread2 = new multithreadthing(2);
		thread2.start();
		
		for(int i=0; i<5; i++) {
			System.out.println("HI");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
		}
		
		System.out.println("THAT IS SO COOL");
		
		for(int i=1; i<=3; i++) {
			multithreadthing thing = new multithreadthing(i);
			thing.start();
		}
		
		//important functions
		//mythread.join(); wait for this thread to finish executing
		//mythread.isalive(); returns boolean if thread is executing
		
		
	}
}

package mesthread;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main2 {
	
	static int i = 1;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		ScheduledExecutorService ex = Executors.newScheduledThreadPool(1);
//		Runnable r = ()->{
//			System.out.println("Hello class !");
//		};
//		ex.schedule(r, 5, TimeUnit.SECONDS);
//		ex.shutdown();
		
		//---------------------------------------------------------------
		
		
//		ScheduledExecutorService ex2 = Executors.newScheduledThreadPool(1);
//		Runnable r1 = ()->{
//			try {
//				TimeUnit.SECONDS.sleep(5);
//				System.out.println("Mamadou Lo COLY !");
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		};
//		ex2.scheduleAtFixedRate(r1, 5, 2, TimeUnit.SECONDS);
		
		ScheduledExecutorService ex3 = Executors.newScheduledThreadPool(1);
		
		Runnable r2 = ()->{
			
			try {
				TimeUnit.SECONDS.sleep(5);
				System.out.println("Mamadou Lo COLY !");
				System.out.println("Tour "+i);
				i++;
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		};
		ex3.scheduleWithFixedDelay(r2, 0, 2, TimeUnit.SECONDS);
	}

}

package mesthread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

public class ConcurentThread {
	
	int compteur = 0;
	ReentrantLock lock = new ReentrantLock();
	
	void demarrer() {
		ExecutorService ex = Executors.newFixedThreadPool(10);
		IntStream.range(0, 10).forEach(i->{
			ex.submit(this::increment);
		});
		ex.shutdown();
		try {
			ex.awaitTermination(60, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(!ex.isTerminated()) {
				System.out.println("Arret d une tache non encore terminée");
			}
		}
		System.out.println("Compteur egale : "+compteur);
	}
	
	
	void increment() {
		System.out.println("Je suis le thread "+Thread.currentThread().getName()+" en attente, compteur egale "+compteur);
		lock.lock();
		System.out.println("Je suis le thread "+Thread.currentThread().getName()+" je suis dedans");
		try {
			TimeUnit.SECONDS.sleep(5);
			compteur++;
			System.out.println("Compteur egale : "+compteur);
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			System.out.println("Je suis le thread "+Thread.currentThread().getName()+" j'ai terminé");
			lock.unlock();
			System.out.println("Je suis le thread "+Thread.currentThread().getName()+" je suis out");
		}
	}
	
	
}

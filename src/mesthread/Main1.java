package mesthread;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class Main1 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ExecutorService ex = Executors.newSingleThreadExecutor();
		ex.submit(()->{
			String nom = Thread.currentThread().getName();
			System.out.println("Thread name : "+nom);
		});
		try {
			ex.shutdown();
			ex.awaitTermination(5, TimeUnit.SECONDS);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		//------------------------------------------------------
		
		ExecutorService ex2 = Executors.newSingleThreadExecutor();
		Callable<Integer> task = ()->{
			try {
				TimeUnit.SECONDS.sleep(5);
				return 1000;
			} catch (Exception e) {
				// TODO: handle exception
				throw e;
			}
		};
		
		Future<Integer> f = ex2.submit(task);
		System.out.println("Valeur obtenue ? "+f.isDone());
		try {
			Integer v = f.get();
			System.out.println("Valeur obtenue ? "+f.isDone());
			System.out.println("Valeur récupérée égale : "+v);
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//------------------------------------------------------
		
		ExecutorService ex3 = Executors.newWorkStealingPool();
		List<Callable<String>> callables = Arrays.asList(
				()->{
					return "premier retour";
				},
				()->{
					return "deuxieme retour";
				},
				()->{
					return "troisieme retour";
				},
				()->{
					return "quatrieme retour";
				}
		);
		ex3.invokeAll(callables).stream().map(f2->{
			try {
				return f2.get();
			} catch (Exception e) {
				throw new IllegalStateException();
			}
			
		}).forEach(System.out::println);;
		
	}

}

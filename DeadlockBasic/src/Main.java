
public class Main {
	
	public static Object lock1 = new Object();
	public static Object lock2 = new Object();

	
	public static void main(String[] args) {
		
		
		new Thread1().start();
		new Thread2().start();
		
	}
	public static class Thread1 extends Thread{
		
		public void run() {
			synchronized (lock1) {
			
				System.out.println("Thread1 has lock1");
				try {
					Thread.sleep(100);
				}catch (InterruptedException e) {
					
				}
				System.out.println("Thread1 waiting for lock2");
				synchronized (lock2) {
				
					System.out.println("Lock1 has lock1 and lock2");
				}
				System.out.println("Lock1 released lock2");
			}
			System.out.println("lock1 released lock1");
		}
	}
	
public static class Thread2 extends Thread{
		
		public void run() {
			synchronized (lock1) {
			
				System.out.println("Thread2 has lock1");
				try {
					Thread.sleep(100);
				}catch (InterruptedException e) {
					
				}
				System.out.println("Thread2 waiting for lock2");
				synchronized (lock2) {
				
					System.out.println("Lock2 has lock1 and lock2");
				}
				System.out.println("Lock2 released lock2");
			}
			System.out.println("lock2 released lock1");
		}
	}
}

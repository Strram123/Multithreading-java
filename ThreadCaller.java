package multitheradingDemo;

 class ThreadDemo extends Thread{
	
	public void run() {
		
	System.out.println("Am ThreadDemo Class Thread...");
		
	}
}

 class ChildThread implements Runnable{

		@Override
		public void run() {
			
			System.out.println("Am ChildClass Thread..");
		}
	}
 
 
public  class ThreadCaller {
	
	static volatile int count;
	 
	 static void method1() {
		 count++;
		
	}
	
	 

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ThreadDemo thread1=new ThreadDemo();
		thread1.start();
		System.out.println("Default ThreadDemo Class Name :"+thread1.getName());
		
		thread1.setPriority(10);
		thread1.setName("Samsung");
		
		System.out.println("ThreadDEmo Priority is :"+thread1.getPriority());
		System.out.println("ThreadDemo Name is:"+thread1.getName());
		
		ChildThread childthread=new ChildThread();
		Thread thread2=new Thread(childthread);
		thread2.start();
		System.out.println("Default ChildThread Class Name :"+thread2.getName());
		thread2.setPriority(1);
		thread2.setName("vivo");
		
		System.out.println("Chilthread Name is :"+thread2.getName());
		System.out.println("ChildThread Priority is :"+thread2.getPriority());
		
		
		
		Thread thread3=new Thread(){
			public void run() {
				for(int i=0;i<1000;i++)
				method1();
			}
		};
		
		Thread thread4=new Thread() {
			public void run() {
				for(int i=0;i<1000;i++)
				method1();
			}
		};
		thread3.start();
		
		thread4.start();
		
		

		thread1.join();
		thread2.join();
		thread3.join();
		thread4.join();
		
		
		Thread.currentThread().sleep(2000);
		for(int i=0;i<5;i++) {
			System.out.println("Mainthread");
		}
		System.out.println("Default main Thread Name :"+Thread.currentThread().getName());
		Thread.currentThread().setName("mobiles World");
		System.out.println("After Changed main Thread Name :"+Thread.currentThread().getName());
	}



}

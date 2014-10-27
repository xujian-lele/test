package threadCreate;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CreateThread2 extends Thread{
	public Lock lock = new ReentrantLock();
	@Override
	public void run(){
		System.out.println("this is a thread test");
	}
	
	
	public static void main(String[] args){
		CreateThread2 test = new CreateThread2();
		test.start();
	}
}

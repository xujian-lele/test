package MultiThread3;

import MultiThread2.Storage;

public class Test {
	public static void test(){
		Storage storage = new Storage();
		Producer p1 = new Producer(storage);
		p1.setNum(10);
		Thread t1 = new Thread(p1);
		
		Consumer c1 = new Consumer(storage);
		c1.setNum(1);
		Thread t2 = new Thread(c1);

		Consumer c2 = new Consumer(storage);
		c2.setNum(2);
		Thread t3 = new Thread(c2);

		Consumer c3 = new Consumer(storage);
		c3.setNum(3);
		Thread t4 = new Thread(c3);

		
//		p1.start();;
//		c1.start();c2.start();c3.start();
		t1.start();
		t2.start();t3.start();t4.start();
	}
	
	public static void main(String[] args){
		test();
	}

}

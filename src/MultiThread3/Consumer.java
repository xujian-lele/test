package MultiThread3;

import MultiThread2.Storage;

public class Consumer implements Runnable{
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public Storage getStorage() {
		return storage;
	}
	public void setStorage(Storage storage) {
		this.storage = storage;
	}
	public int num;
	Storage storage = new Storage();
	public void run() {
		for(int i=0;i<10;i++){
			storage.consume(num);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	public Consumer(Storage storage) {
		super();
		this.storage = storage;
	}
	
}

package MultiThread3;

import MultiThread2.Storage;

public class Producer implements Runnable{
	public Storage getStorage() {
		return storage;
	}

	public void setStorage(Storage storage) {
		this.storage = storage;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public Producer(Storage storage) {
		super();
		this.storage = storage;
	}

	Storage storage = new Storage();
	public int num;

	public void run() {
		for(int i=0;i<10;i++){
			storage.produce(num);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

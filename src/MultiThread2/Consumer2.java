package MultiThread2;

public class Consumer2 extends Thread{
	//每次消费的数量
	public int num;
	public Storage2 storage = new Storage2();
	
	public void run(){
		while(true){
			storage.consume(num);		
		}
	}

	public Consumer2(Storage2 storage) {
		super();
		this.storage = storage;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public Storage2 getStorage() {
		return storage;
	}

	public void setStorage(Storage2 storage) {
		this.storage = storage;
	}
	
}

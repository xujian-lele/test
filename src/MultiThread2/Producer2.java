package MultiThread2;

public class Producer2 extends Thread{
	//每次生产的数量
	public int num;
	//仓库
	Storage2 storage = new Storage2();
	
	public Producer2(Storage2 storage){
		this.storage = storage;
	}
	
	public void run(){
		while(true){
			storage.Producer(num);
		}
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

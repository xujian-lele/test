package thread;

public class CreateThread2 extends Thread{
	@Override
	public void run(){
		System.out.println("this is a thread test");
	}
	
	
	public static void main(String[] args){
		CreateThread2 test = new CreateThread2();
		test.start();
	}
}

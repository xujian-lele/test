
public class ThreadTest implements Runnable{

	public void run() {
		// TODO Auto-generated method stub
		System.out.println("this is a test thread!");
	}
	public static void main(String[] args){
		ThreadTest test = new ThreadTest();
		while(true){
			for(int i=0; i<=1000 ;i++){
				
			}
			test.run();
		}
	}

}

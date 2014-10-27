package MultiThread;

public class tickets implements Runnable{
	private static int ticket_num = 10;

	public void run() {
		// TODO Auto-generated method stubti
		
		for(int i=0;i<10;i++){
			synchronized (this){
			if(ticket_num>0){
				try{
					Thread.sleep(1000);
				}catch(Exception  e){
					
				}
				System.out.print(Thread.currentThread().getName()+"正在买票"+ ticket_num-- +"\n");
//				ticket_num++;
			}
		}
		}
	}
	
	public static void main(String[] args){
		tickets myBuy = new tickets();
		Thread t1 = new Thread(myBuy, "窗口1");
		Thread t2 = new Thread(myBuy,"窗口2");
		Thread t3 = new Thread(myBuy,"窗口3");
		t1.setPriority(8);
		t2.setPriority(2);
		t3.setPriority(6);
		t1.start();
		t2.start();
		t3.start();		
	}

}

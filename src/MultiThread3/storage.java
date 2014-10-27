package MultiThread3;

import java.util.LinkedList;

public class storage {
	//容量
	int SIZE_NUM = 100;
	//
	public LinkedList<Object> list = new LinkedList<Object>();
	//
	public void produce(int num){
		synchronized(list){
			if(list.size()+num>SIZE_NUM){
				System.out.println("仓满");
				try {
					list.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			//阻塞失效之后，执行操作
			for(int i=0;i<num;i++){
				list.add(new Object());
			}
			System.out.println("生产："+num+";库存"+list.size());
			list.notify();
		}
	}
	
	
	public void consume(int num){
		synchronized(list){
			if(list.size()< num){
				System.out.println("仓储不足");
				try {
					list.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
			for(int i=0;i<num;i++){
				list.remove();
			}
			System.out.println("消费："+num+";库存为"+list.size());
			list.notify();
		}
	}
}

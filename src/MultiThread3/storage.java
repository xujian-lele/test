package MultiThread3;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class storage {
	//容量
	int SIZE_NUM = 100;
	//
	public LinkedList<Object> list = new LinkedList<Object>();
	//
	public Lock lock = new ReentrantLock();
	//
	public Condition full = lock.newCondition();
	//
	public Condition empty = lock.newCondition();
	
	public void produce(int num){
		lock.lock();
		while(list.size()+num>SIZE_NUM){
			System.out.println("仓满");
			try {
				full.await();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		//当不阻塞的时候继续执行
		for(int i=0;i<num;i++){
			list.add(new Object());
		}
		System.out.println("生产："+num+";库存："+list.size());
		
		full.signal();
		lock.unlock();
	}
	
	
	public void consume(int num){

		lock.lock();
		while(list.size()<num){
			System.out.println("仓不够");
			try {
				empty.await();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		//当不阻塞的时候继续执行
		for(int i=0;i<num;i++){
			list.remove();
		}
		System.out.println("消费："+num+";库存："+list.size());
		
		empty.signal();
		lock.unlock();
	}
}

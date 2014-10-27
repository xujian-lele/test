package MultiThread2;

import java.util.concurrent.LinkedBlockingQueue;

public class Storage2 {
	
	private LinkedBlockingQueue<Object> list = new LinkedBlockingQueue<Object>(100);
	//仓库容量
	private int SIZE_NUM = 100;
	//produce
	public void Producer(int num){
		if(list.size() + num > SIZE_NUM)
		{
            System.out.println("【要生产的产品数量】:" + num + "/t【库存量】:" + list.size()  
                    + "/t暂时不能执行生产任务!"); 
            }else{
            	for(int i=1;i<=num;i++){
            		try {
						list.put(new Object());
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
            	}
                System.out.println("【已经生产产品数】:" + num + "/t【现仓储量为】:" + list.size());  
            }
	}
	
	//consume
	public void Consumer(int num){
		if(list.size()<num){
            System.out.println("【要消费的产品数量】:" + num + "/t【库存量】:" + list.size()  
                    + "/t暂时不能执行消费任务!");  
		}else{
			try {
				for(int i=1;i<=num;i++)
				list.take();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            System.out.println("【已经消费产品数】:" + num + "/t【现仓储量为】:" + list.size());  
		}
	}
	
	public LinkedBlockingQueue<Object> getList() {
		return list;
	}
	public void setList(LinkedBlockingQueue<Object> list) {
		this.list = list;
	}

}

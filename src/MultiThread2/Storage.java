package MultiThread2;

import java.util.concurrent.LinkedBlockingQueue;

public class Storage {    // 仓库最大存储量  
    private final int MAX_SIZE = 100;  
  
    // 仓库存储的载体  
    private LinkedBlockingQueue<Object> list = new LinkedBlockingQueue<Object>();  
  
    public void produce(int num)  
    {  
        if (list.size() + num > MAX_SIZE)  
        {  
            System.out.println("【要生产的产品数量】:" + num + "/t【库存量】:" + list.size()  
                    + "/t暂时不能执行生产任务!");  
        }  
  
        // 生产条件满足情况下，生产num个产品  
        for (int i = 1; i <= num; ++i)  
        {  
            try {
				list.put(new Object());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}  
        }  
  
        System.out.println("【已经生产产品数】:" + num + "/t【现仓储量为】:" + list.size());  
    }  
  
    // 消费num个产品  
    public void consume(int num)  
    {  
        // 如果仓库存储量不足  
        if (list.size() < num)  
        {  
            System.out.println("【要消费的产品数量】:" + num + "/t【库存量】:" + list.size()  
                    + "/t暂时不能执行消费任务!");  
        }  
  
        // 消费条件满足情况下，消费num个产品  
        for (int i = 1; i <= num; ++i)  
        {  
            try {
				list.take();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}  
        }  
  
        System.out.println("【已经消费产品数】:" + num + "/t【现仓储量为】:" + list.size());  
    }  
  
    // set/get方法  
    public int getMAX_SIZE()  
    {  
        return MAX_SIZE;  
    }  
  
    public LinkedBlockingQueue<Object> getList()  
    {  
        return list;  
    }  
  
    public void setList(LinkedBlockingQueue<Object> list)  
    {  
        this.list = list;  
    }  }

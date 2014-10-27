package MultiThread2;

public class Test  
{  
    public static void test1()  
    {  
        // 仓库对象  
        Storage storage = new Storage();  
  
        // 生产者对象  
        Producer p1 = new Producer(storage);  
        Producer p2 = new Producer(storage);  
        Producer p3 = new Producer(storage);  
        Producer p4 = new Producer(storage);  
        Producer p5 = new Producer(storage);  
        Producer p6 = new Producer(storage);  
        Producer p7 = new Producer(storage);  
  
        // 消费者对象  
        Consumer c1 = new Consumer(storage);  
        Consumer c2 = new Consumer(storage);  
        Consumer c3 = new Consumer(storage);  
  
        // 设置生产者产品生产数量  
        p1.setNum(10);  
        p2.setNum(10);  
        p3.setNum(10);  
        p4.setNum(10);  
        p5.setNum(10);  
        p6.setNum(10);  
        p7.setNum(80);  
  
        // 设置消费者产品消费数量  
        c1.setNum(50);  
        c2.setNum(20);  
        c3.setNum(30);  
  
        // 线程开始执行  
        c1.start();  
        c2.start();  
        c3.start();  
        p1.start();  
        p2.start();  
        p3.start();  
        p4.start();  
        p5.start();  
        p6.start();  
        p7.start();  
    }  
    
    public static void test2(){
    	Storage2 storage = new Storage2();
    	
    	Producer2 p1 = new Producer2(storage);
    	p1.setNum(20);

    	
    	Consumer2 c1 = new Consumer2(storage);
    	Consumer2 c2 = new Consumer2(storage);

    	c1.setNum(5);
    	c2.setNum(5);
    	p1.start();

    	c1.start();
    	c2.start();

    }
    public static void main(String[] args){
    	test1();
    }
}  
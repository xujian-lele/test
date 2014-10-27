package MultiThread;


public class Consumer implements Runnable{

    private MultiThread.Info info=null;
    public Consumer(MultiThread.Info info2){
        this.info=info2;
    }
     
    public void run(){
        for(int i=0;i<25;++i){
            try{
                Thread.sleep(100);
            }catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(this.info.getName()+"<---->"+this.info.getAge());
        }
    }

}

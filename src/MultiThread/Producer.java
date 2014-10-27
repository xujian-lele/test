package MultiThread;

public class Producer implements Runnable{

    private Info info=null;
    Producer(Info info){
        this.info=info;
    }
     
    public void run(){
        boolean flag=false;
        for(int i=0;i<25;++i){
            if(flag){
                this.info.setName("Rollen");
                try{
                    Thread.sleep(100);
                }catch (Exception e) {
                    e.printStackTrace();
                }
                this.info.setAge(20);
                flag=false;
            }else{
                this.info.setName("chunGe");
                try{
                    Thread.sleep(100);
                }catch (Exception e) {
                    e.printStackTrace();
                }
                this.info.setAge(100);
                flag=true;
            }
        }
    }

}

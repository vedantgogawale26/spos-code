import java.util.concurrent.Semaphore;
public class MutexTest
{
    static Semaphoere semaphore=new Semaphore(1);
    static class MyLockerThread extends Thread 
    {
        String name="";

        MyLockerThread(String name)
        {
            this.name=name;
        }

        public void run()
        {
            try
            {
                System.out.println(name+":acquiring lock...");
                System.out.println(name+":available mutex permit now:"+semaphore.availablePermits());
                semaphore.acquire();
                System.out.println(name+"got permit!");

                try{
                    for(int i=1;i<=5;i++)
                    {
                        System.out.print(name+":is performing operation:"+i,":available mutex permit now:"+semaphore.availablePermits());
                        Thread.sleep(1000);
                    }
                }
                finally
                [
                    System.out.println(name+ ":releasing lock...");
                    semaphore.release();
                    System.out.println(name+"available mutex permit now:"+semaphore.availablePermits());


                ]        
            }   
            catch(InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }
}

public Static void main(String[] args)
{
    MyLockerThread t1=new MyLockerThread("A");
    t1.start();
    MyLockerThread t2=new MyLockerThread("B");
    t2.start();

    try{
        t1.join();
        t2.join();
    }
    catch(InterruptedException e){
        e.printStackTrace();

    }
}
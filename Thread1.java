//different cases

class MyThread implements Runnable{
    public void run()
    {
        for(int i=1;i<=5;i++)
        {
            System.out.println("child class method : "+i);
        }
    }
}

class Test
{
    public static void main(String[] args) {
        
        MyThread t=new MyThread();
        Thread t1=new Thread();
        Thread t2=new Thread(t);

        //t.start();      error
        t.run();
        t1.start();
        t1.run();
        t2.start();
        t2.run();

        for(int i=1;i<=5;i++)
        {
            System.out.println("parent class method : "+i);
        }

    }
}

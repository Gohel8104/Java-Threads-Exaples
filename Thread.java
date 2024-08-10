//multiple thread by thread class and Runnable interface

class Dhoni implements Runnable
{
     public void run() 
    {
            try
            {
            for(int i=0;i<5;i++)
            {
                System.out.println("Dhoni : "+i);
                Thread.sleep(2000);
            }
            }
             catch(InterruptedException e)
            {
                System.out.println(e);
            }
    }
}
   
    


class Virat extends Thread 
{
    public void run()
    {
        try
        {
            for(int i=0;i<5;i++)
            {
                System.out.println("Virat : "+i);
                Thread.sleep(2000);
            }
        }   
        catch(InterruptedException e)
        {
            System.out.println(e);
        }
    }
}

class Main
    {
        public static void main(String[] args) {
            
            Dhoni d=new Dhoni();
            Thread t=new Thread(d);
            t.start();   //thread by runnable interface

            Virat v=new Virat();
            v.start();
        }
    }

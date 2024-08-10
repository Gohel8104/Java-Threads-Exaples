class BankAccount 
{
    double balance;

    synchronized void deposit(double amount) 
    {
        balance += amount;
        System.out.println("Deposit: " + amount + ", New balance: " + balance);
        notify();
    }

    synchronized void withdraw(double amount) throws InterruptedException 
    {
        if (balance < amount) 
        {
                System.out.println("Insufficient balance. Waiting for deposit...");
				wait();
        }
        else
        {
            balance -= amount;
        System.out.println("Withdrawal: " + amount + ", New balance: " + balance);
        }
        
    }
}

class DepositThread extends Thread 
{
    BankAccount account;
    double amount;

    DepositThread(BankAccount account, double amount) 
    {
        this.account = account;
        this.amount = amount;
    }

    public void run() 
    {
        account.deposit(amount);
    }
}
class WithdrawThread extends Thread 
{
    BankAccount account;
    double amount;

    WithdrawThread(BankAccount account, double amount) 
    {
        this.account = account;
        this.amount = amount;
    }

    public void run() 
    {
        try {
            account.withdraw(amount);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}

class Main09 
{
    public static void main(String[] args) 
    {
        BankAccount account = new BankAccount();

        DepositThread thread1 = new DepositThread(account , 500);
        WithdrawThread thread2 = new WithdrawThread(account , 70);
        DepositThread thread3 = new DepositThread(account , 80);
        WithdrawThread thread4 = new WithdrawThread(account , 5000);

        thread2.start();
        thread1.start();
        thread3.start();
        thread4.start();

    }
}
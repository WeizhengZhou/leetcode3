package MultiThread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Condition;

public class BankTransfer {
	public static void main(String[] args){
		int NAccount = 2;
		Bank bank = new Bank(NAccount,1000);
		for(int i=0;i<NAccount;i++){
			BankRunnable r = new BankRunnable(bank,i,100);
			Thread t = new Thread(r);
			t.start();
		}
	}
}
class Bank{
	private int NAccounts = 10;
	private int initAmount = 1000;
	private double[] account;
	

	public Bank(int NAccount, int initAmout){
		this.NAccounts = NAccount;
		this.initAmount = initAmout;
		this.account = new double[NAccounts];
		for(int i=0;i<NAccount;i++){
			account[i] = initAmout;
		}
	}
	public void transfer(int from, int to, int money) throws InterruptedException{
		synchronized (this){
			while(account[from] < money){
				System.out.println(Thread.currentThread() + " says: I am waiting. From = " 
						+ from +  ", to = " + to +  "amount[from] = " + account[from] + ", money = " + money);
				wait();
			}
			account[from] -= money;
			account[to] += money;	
			System.out.println(Thread.currentThread() + ", Total amount = " + this.getTotalAmount());
			notifyAll();
		}
	}
	public int getTotalAmount(){
		int total = 0;
		for(int i=0;i<account.length;i++){
			total += account[i];
		}
		return total;
	}
	public int size(){
		return this.NAccounts;
	}
}
class BankRunnable implements Runnable{
	private Bank bank = null;
	private int maxAmount = 0;
	private int from = 0;
	public BankRunnable(Bank b, int from, int maxAmount){
		this.bank = b;
		this.from = from;
		this.maxAmount = maxAmount;
	}
	
	public void run(){
		try{
			while(true){
				int to = (int) (bank.size() * Math.random());
				int amount = (int) (maxAmount * Math.random());
				bank.transfer(to, from, amount);
				Thread.sleep( (int) (10*Math.random()));				
			}
		}
		catch(InterruptedException e){	
		}		
	}
}

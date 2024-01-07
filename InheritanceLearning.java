package objectorientedprogramming;

//Write a Java program to create a class known as "BankAccount" with methods called deposit() and withdraw(). Create a subclass called SavingsAccount that overrides the withdraw() method to prevent withdrawals if the account balance falls below one hundred.



class BankAccount
{
	private int money = 100;
	public void deposit(int moneyAddOn)
	{
		if(moneyAddOn > 0)
		{
			this.money = this.money  + moneyAddOn;
		}
	}
	public String withDraw(int amountToWithDraw)
	{
		 String message;
		if(money >= amountToWithDraw)
		{
			this.money = this.money - amountToWithDraw;
			message =  "You have with drawn ₹" + amountToWithDraw + " from your account";
		}
		else
		{
			message = "Your balance is ₹"+ getMoney() + " But you are withdrawing ₹"+ amountToWithDraw ;
		}
		return message;
		
	}
	
	public String balanceCheck()
	{
		
		return "You have ₹"+getMoney() + " in your account";
	}
	
	
	public int getMoney()
	{
		return this.money;
	}
	
	public void setMoney(int moneyToSet)
	{
		this.money = moneyToSet;
	}
}

class SavingsAccount extends BankAccount
{
	
	SavingsAccount(BankAccount sbi)
	{
		super.setMoney(sbi.getMoney());
	}
	@Override
	public String withDraw(int amountToWithDraw)
	{
//		prevent withdrawals if the account balance falls below one hundred.
		
		String message;
		if(super.getMoney() >= 100 && (amountToWithDraw  + 100) <= super.getMoney())
		{
			super.setMoney(super.getMoney() - amountToWithDraw);
			message = "Succesfully withdrawn ₹" + amountToWithDraw + " from your BankAccount";
		}
		else
		{
			message = "Insufficient Balance or Minimum Balance limit reached";
		}
		return message;
		
	}
}


public class InheritanceLearning {

	public static void main(String[] args) {

		BankAccount sbi = new BankAccount();
		
		System.out.println(sbi.balanceCheck());
		
		sbi.deposit(1000);
		
		System.out.println(sbi.balanceCheck());
		
		
		System.out.println(sbi.withDraw(500));
		System.out.println(sbi.balanceCheck());
		
		
		SavingsAccount sbiSavings = new SavingsAccount(sbi);
		System.out.println(sbiSavings.balanceCheck());
		
		System.out.println(sbiSavings.withDraw(500));
		
		System.out.println(sbiSavings.balanceCheck());

	}

}

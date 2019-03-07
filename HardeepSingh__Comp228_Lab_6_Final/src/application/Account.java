package application; // package

public class Account {
	int _balance = 0; // balance in account

	// construct a Account and give balance as input
	public Account(int balance) {
		this._balance = balance;
	} // end constructor

	// synchronized function as to deposit amount in account
	public synchronized void deposit(int depositedAmount) {

		try {
			// put thread to sleep for 1 second

			Thread.sleep(1000);
			_balance += depositedAmount; // add balance after waking form sleep
		} // end try
		catch (InterruptedException ex) {
			ex.printStackTrace();
		} // end catch

		// print details of transaction
		System.out.printf("%s deposited %d in %s.\n", Thread.currentThread().getName(), depositedAmount,
				this.getClass().getName().toString());
		// print account summary
		System.out.println(this.toString() + "\n");
		// increment index of element to be written next
		// System.out.printf("Next write index: %d\n", writeIndex);
	} // end method add

	// synchronized function as to withdraw amount from account
	public synchronized void withdraw(int withdrawnAmount) {

		try {

			Thread.sleep(1000);// sleep for 1 second
			_balance -= withdrawnAmount; // withdraw amount from account
		} // end try
		catch (InterruptedException ex) {
			ex.printStackTrace();
		} // end catch

		// print details of transaction
		System.out.printf("%s withdrew %d from %s.\n", Thread.currentThread().getName(), withdrawnAmount,
				this.getClass().getName().toString());
		// print account summary
		System.out.println(this.toString() + "\n");
		// increment index of element to be written next
		// System.out.printf("Next write index: %d\n", writeIndex);
	} // end method add

	@Override
	public String toString() { // function to print account summary
		return "Account [_balance=" + _balance + "]";
	}

}
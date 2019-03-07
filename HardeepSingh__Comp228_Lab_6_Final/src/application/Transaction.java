package application;

// transaction class
public class Transaction implements Runnable {
	// attributes of transaction
	private final Account _account;
	private final int _amount;
	private boolean _deposit = true; // false means withdraw
	// Transaction constructor

	public Transaction(Account account, int amount, boolean deposit) {
		this._account = account;
		this._amount = amount;
		this._deposit = deposit;
		;
	} // end constructor
		// run method of runnable interface

	public void run() {
		if (this._deposit) {
			this._account.deposit(this._amount);
		} else {
			this._account.withdraw(this._amount);
		}
	} // end method run
} // end class ArrayWriter
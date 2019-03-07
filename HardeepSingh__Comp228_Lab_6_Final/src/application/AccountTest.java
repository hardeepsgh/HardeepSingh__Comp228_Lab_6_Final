package application;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class AccountTest {

	public static void main(String[] arg) {
		// create array for transactions
		ArrayList<Transaction> list = new ArrayList<Transaction>();
		// initial amount in account while opening account
		int initailBalanceInAccout = 1000;
		// create new account
		Account account = new Account(initailBalanceInAccout);
		// create 3 transactions
		Transaction transaction1 = new Transaction(account, 200, true);
		Transaction transaction2 = new Transaction(account, 50, false);
		Transaction transaction3 = new Transaction(account, 25, false);

		// execute the tasks with an ExecutorService
		ExecutorService executor = Executors.newCachedThreadPool();
		// add transactions to list
		list.add(transaction1);
		list.add(transaction2);
		list.add(transaction3);
		// show initial balance
		System.out.println("inital balance in account is: " + initailBalanceInAccout + "\n");
		// perform transactions
		for (int index = 0; index < 3; index++) {
			executor.execute(list.get(index));
		}
		// shutdown executor
		executor.shutdown();
		try {
			// wait 1 minute for both writers to finish executing
			boolean tasksEnded = executor.awaitTermination(1, TimeUnit.MINUTES);
			if (tasksEnded)
				System.out.println("Final balance in account after all transactions is :" + account.toString()); // print
																													// contents
			else
				System.out.println("Timed out while waiting for tasks to finish.");
		} // end try
		catch (InterruptedException ex) {
			System.out.println("Interrupted while wait for tasks to finish.");
		} // end catch

	}

}

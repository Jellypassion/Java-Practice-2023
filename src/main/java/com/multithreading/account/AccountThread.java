package com.multithreading.account;

public class AccountThread extends Thread {

    private final Account accountFrom;
    private final Account accountTo;

    public AccountThread(Account accountFrom, Account accountTo) {
        this.accountFrom = accountFrom;
        this.accountTo = accountTo;
    }

    /*
     * if the number of iterations is 2000+ the app fails to execute
     * this is called Deadlock
     *
     * 1 ------- account1 -> account2
     * 2 ------- account2 -> account1
     * both threads are waiting until the monitor of account1 and account2 will be free to capture, but it never happens
     *
     * This is the biggest problem in multithreading, and it should be avoided (package java.util.concurrent helps to solve it)
     * */
//    @Override
//    public void run() {
//        for (int i = 0; i < 2000; i++) {
//            synchronized (accountFrom) {
//                synchronized (accountTo) {
//                    if (accountFrom.takeOff(10)) {
//                        accountTo.add(10);
//                    }
//                }
//            }
//        }
//    }

    // re-writing the method using Locks
    @Override
    public void run() {
        for (int i = 0; i < 2000; i++) {
            lockAccounts();
            // adding try-finally block because in real-world examples such operations can throw exceptions (e.g. problems with DB connection)
            try {
                if (accountFrom.takeOff(10)) {
                    accountTo.add(10);
                }
            }
            // And also we need to unlock accounts for further operations. It can be done inside finally
            finally {
                accountFrom.getLock().unlock();
                accountTo.getLock().unlock();
            }
        }
    }

    //Adding the method which will lock accounts
    private void lockAccounts() {
        while (true) {
//            accountFrom.getLock().lock(); //Acquires the lock. If the lock is not available, it waits until it's possible to catch the monitor on the object
            boolean fromLockResult = accountFrom.getLock().tryLock(); // Acquires the lock if it is available and returns immediately with the value true, otherwise returns false
            boolean toLockResult = accountTo.getLock().tryLock();
            // return from the cycle when both accounts are locked
            if (fromLockResult && toLockResult)
                break;
            // If the monitor was captured (lock applied) only on one of two accounts, we need to unlock it
            if (fromLockResult)
                accountFrom.getLock().unlock();
            if (toLockResult)
                accountTo.getLock().unlock();
        }
    }

}

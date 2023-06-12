package com.multithreading.account;

public class AccountThread extends Thread {

    private final Account accountFrom;
    private final Account accountTo;

    public AccountThread(Account accountFrom, Account accountTo) {
        this.accountFrom = accountFrom;
        this.accountTo = accountTo;
    }

    /*@Override
    public void run() {
        synchronized (accountFrom) {
            synchronized (accountTo) {
                for (int i = 0; i < 2000; i++) {
                    if (accountFrom.takeOff(10)) {
                        accountTo.add(10);
                    }
                }
            }
        }
    }*/

    /*
    * if the number of iterations is 2000+ the app fails to execute
    * this is called Deadlock
    *
    * 1 ------- account1 -> account2
    * 2 ------- account2 -> account1
    * both threads are waiting until the monitor of account1 and account2 will be free to capture, but it never happens
    *
    * This is the biggest problem in multithreading and it should be avoided
    * */
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            synchronized (accountFrom) {
                synchronized (accountTo) {
                    if (accountFrom.takeOff(10)) {
                        accountTo.add(10);
                    }
                }
            }
        }
    }

}

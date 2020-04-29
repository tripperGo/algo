package com.mright.thread.chapter03;

/**
 * @author: mright
 * @date: Created in 2020/4/28 10:19 PM
 * @desc:
 */
public class ThreadLocalDemo {

    public static void main(String[] args) {
        Bank bank = new Bank();
        Transfer transfer = new Transfer(bank);
        new Thread(transfer, "用户2").start();
        new Thread(transfer, "用户1").start();
    }

}

class Bank {
    private ThreadLocal<Integer> amount = ThreadLocal.withInitial(() -> 0);

    public Integer get() {
        return amount.get();
    }

    public void set(Integer money) {
        amount.set(amount.get() + money);
    }
}

class Transfer implements Runnable {
    private Bank bank;

    public Transfer(Bank bank) {
        this.bank = bank;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            bank.set(10);
            System.out.println(Thread.currentThread().getName() + "账户余额：" + bank.get());
        }
    }
}
package java3rd.ch13;

public class ThreadEx22 {
    public static void main(String[] args) {
        Runnable r = new RunnableEx22();

        new Thread(r).start();      // ThreadGruop에 의해 참조되므로 gc대상이 아니다.
        new Thread(r).start();      // ThreadGruop에 의해 참조되므로 gc대상이 아니다.
    }
}

class Account2 {
    private int balance = 1000;

    public int getBalance() {
        return balance;
    }

    public synchronized void withdraw(int money) {  // synchronized로 메서드를 동기화
        if(balance >= money) {
            try { Thread.sleep(1000);} catch (InterruptedException e) {}
            balance -= money;
        }
    } // withdraw
}

class RunnableEx22 implements Runnable {
    Account2 acc = new Account2();

    @Override
    public void run() {
        while(acc.getBalance() > 0) {
            // 100 , 200, 300 중의 한 값을 임의로 선택해서 출금(withdraw)
            int money = (int) (Math.random() * 3 + 1) * 100;
            acc.withdraw(money);
            System.out.println("balance : " + acc.getBalance());
        }
    } // run()
}

package java3rd.ch13;

public class Exercise13_5 {
    static boolean stopped = false;

    public static void main(String[] args) {
        Thread5 th1 = new Thread5();
        th1.start();

        try {
            Thread.sleep(6 * 1000);
        } catch (Exception e) {}

        stopped = true;     // 쓰레드를 정지시킨다.
        th1.interrupt();
        System.out.println("stopped");
    }
}

class Thread5 extends Thread {

    @Override
    public void run() {
        // Exercise13_5.stopped의 값이 false인 동안 반복
        for (int i=0; !Exercise13_5.stopped; i++) {
            System.out.println(i);

            try {
                Thread.sleep(3 * 1000);
            } catch (Exception e) {}
        }
    }
}

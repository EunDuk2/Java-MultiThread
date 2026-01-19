package thread.start.test;

import java.util.Objects;

import static util.MyLogger.log;

public class StartTest4Main {
    public static void main(String[] args) {
        Thread AThread = new Thread(new PrintWork("A", 1000), "A-Thread");
        Thread BThread = new Thread(new PrintWork("B", 500), "B-Thread");
        AThread.start();
        BThread.start();
    }

    static class PrintWork implements Runnable {

        private String content;
        private int sleepMs;

        public PrintWork(String content, int sleepMs) {
            this.content = content;
            this.sleepMs = sleepMs;
        }

        @Override
        public void run() {

            while (true) {
                log(content);
                try {
                    Thread.sleep(sleepMs);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}

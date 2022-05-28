package lenTest;

public class lt010_Runnable_Thread {

    static class ChildRunnable implements Runnable{
        private int cnt = 0;
        @Override
        public void run() {
            while (cnt<3){
                System.out.println(cnt);
                cnt++;
            }
        }
    }

    static class ChildThread extends Thread{
        private int cnt = 0;
        @Override
        public void run() {
            while (cnt<3){
                System.out.println(cnt);
                cnt++;
            }
        }
    }

    public static void main(String[] args) {
        ChildRunnable childRunnable = new ChildRunnable();
        new Thread(childRunnable).start();
        new Thread(childRunnable).start();
    }
}

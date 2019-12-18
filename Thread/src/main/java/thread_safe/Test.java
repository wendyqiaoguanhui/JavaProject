package thread_safe;

/**
 * @author QiaoGuanHui
 * @date 2019/12/16-18:07
 */
public class Test {
    public static void main(String[] args) {
        //测试线程安全
      /*  ReenLock ticket  = new ReenLock();
        Thread thread1 = new Thread(ticket,"窗口1");
        Thread thread2 = new Thread(ticket,"窗口2");
        Thread thread3 = new Thread(ticket,"窗口3");
        thread1.start();
        thread2.start();
        thread3.start();*/

      //测试线程死锁
        TreadDead runnable1 = new TreadDead(1);
        TreadDead runnable2 = new TreadDead(0);

        Thread thread1 = new Thread(runnable1,"obj1");
        Thread thread2 = new Thread(runnable2,"obj2");
        thread1.start();
        thread2.start();
    }
}

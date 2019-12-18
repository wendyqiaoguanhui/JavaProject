package thread_safe;

/**
 * 偶数线程
 * @author QiaoGuanHui
 * @date 2019/12/18-9:33
 */
public class EvenThread implements Runnable {
    public ThreadUtil t;
    public EvenThread(ThreadUtil t){
        this.t = t;
    }
    public void run() {
        t.even();
            //调用偶数

        }
    }

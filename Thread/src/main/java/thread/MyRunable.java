package thread;

import java.util.Date;

/**
 * @author QiaoGuanHui
 * @date 2019/12/13-16:49
 */
public class MyRunable implements Runnable {
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName()+"执行时间是："+ new Date());
        }
    }
}

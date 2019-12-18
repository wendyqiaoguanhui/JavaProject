package thread;

import java.util.Date;
import java.util.concurrent.Callable;

/**
 * @author QiaoGuanHui
 * @date 2019/12/13-16:24
 */
public class MyCallable implements Callable<String> {
    public String call() throws Exception {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName()+"执行时间是："+ new Date());
        }
        return "callable 接口执行完成";
    }
}
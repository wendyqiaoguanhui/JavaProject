package thread_safe;

/**
 * 奇数线程
 * @author QiaoGuanHui
 * @date 2019/12/18-9:33
 */
public class ObbThread implements Runnable{
    public ThreadUtil t;
    public ObbThread(ThreadUtil t){
        this.t = t;
    }
    public void run() {
            t.obb();
            //调用奇数

    }
}

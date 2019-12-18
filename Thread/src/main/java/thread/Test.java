package thread;

import java.util.concurrent.*;

/**
 * @author QiaoGuanHui
 * @date 2019/12/13-16:27
 */
public class Test {
    public static void main(String[] args) {
        //callable 方式执行线程
       /* FutureTask<String> task = new FutureTask<String>(new MyCallable());
        Thread thread = new Thread(task);
        thread.start();
        boolean flag = task.isDone();
        System.out.println("线程是否执行完成："+flag);
        try {
            String s = task.get();
            System.out.println("线程执行结果为："+s);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }*/

        //通过线程池执行,Executors 线程工具类
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        executorService.execute(new MyRunable());
        Object t;


    }
}

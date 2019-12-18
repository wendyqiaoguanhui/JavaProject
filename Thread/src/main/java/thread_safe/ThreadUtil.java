package thread_safe;

/**
 * @author QiaoGuanHui
 * @date 2019/12/18-13:24
 */
public class ThreadUtil {
    public static int i =0;
    public static Object obj = new Object();
    /**
     * 打印奇数
     */
    public void obb(){
        //打印奇数
        while (i<10){
            System.out.println("进入奇数线程打印");
            synchronized (obj){

                if(i%2==1){
                    System.out.println("奇数线程打印了:"+i);
                    i++;
                    try {
                        obj.notify();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }else {
                    try {
                        obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        }

    }
    /**
     * 打印偶数
     */
    public void even(){
        //打印偶数
        while (i < 10) {
            synchronized (obj) {
                if (i % 2 == 0) {
                    System.out.println("偶数线程打印了:" + i);
                    i++;
                    try {
                        obj.notify();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    try {
                        obj.wait();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

            }
        }
    }

}

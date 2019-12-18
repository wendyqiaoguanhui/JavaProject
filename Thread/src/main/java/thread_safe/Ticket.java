package thread_safe;

/**
 * @author QiaoGuanHui
 * @date 2019/12/16-18:02
 */
public class Ticket implements Runnable {
    private int ticketNum = 100;//电影票的数量
    //使用同步锁。可以创建任意对象作为锁
    Object obj = new Object();

    public void run() {

            try {
                while(true) {//如有票，则售卖
                    //加同步代码块锁
                    synchronized (obj){

                        if(ticketNum>0){

                            Thread.sleep(1000);
                            System.out.println("当前"+Thread.currentThread().getName()+"窗口，售卖了："+ticketNum--);
                        }
                    }
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

    }
}

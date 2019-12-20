package thread_safe;

/**
 * ThreadLocal 为线程创建自己副本变量，让线程间操作的共有变量时，自己保持自己的变量不变
 * 例如银行，可以存钱，也可以取钱，多个用户存款、取款。调用的都是同一个方法，这就造成多线程访问一个方法；
 *      但是各个账户间的存款又互不影响，各不相同；这就可以使用ThreadLoal类型来声明存钱的变量；为每一个线程的这个
 *      变量声明一个副本
 * @author QiaoGuanHui
 * @date 2019/12/20-12:37
 */
public class ThreadLocalDemo {

    //创建一个银行类，模仿存钱和取钱
    static class Bank{
      private  ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>(){
                //实现一个方法,设置每个账户初始值为0
            protected Integer initialValue(){
                return 0;
            }
        };
      //取钱方法，注意取钱的钱从ThreadLocal中获取
        public Integer get(){
            return threadLocal.get();
        }
        //设置存钱的方法
        public void set(Integer money){
            threadLocal.set(threadLocal.get()+money);
        }

    }
    //创建转账类线程
    static class Transfer implements Runnable {
        private Bank bank;

        public Transfer(Bank bank){
            this.bank = bank;
        }
        public void run() {
            //循环调用存钱方法
            for (int i = 0;i<10;i++){
                bank.set(10);
                System.out.println(Thread.currentThread().getName()+"银行增加存款："+bank.get());
            }

        }
    }
    public static void main(String[] args) {
        Bank bank = new Bank();
        //创建线程，调用银行的转账方法，实现存钱
        Thread thread1 = new Thread(new Transfer(bank));//传入同一个bank表示同一家银行
        Thread thread2 = new Thread(new Transfer(bank));

        thread1.start();
        thread2.start();

    }
}

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;

//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = MySpringBootApplication.class)
public class TestRabbitmq {

    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public static void main1(String[] args) {
        new ThreadPoolExecutor(5,10,60, TimeUnit.SECONDS,new LinkedBlockingQueue<Runnable>());
        System.out.println("*************");
        //ThreadPoolExecutor a = new ThreadPoolExecutor();
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName()+ "执行了。。。。");
                }
            });
        }
        executorService.shutdown();
    }


    public static void main2(String[] args) {
        ConcurrentHashMap map = new ConcurrentHashMap();
        //Student.findAll
        List<String> str = Arrays.asList("hello","World");
        List<String[]> res = str.stream().map(e -> e.split("")).distinct().collect(Collectors.toList());
        System.out.println(res.size());
    }

    public static void main3(String[] args) {
        Lock lock = new ReentrantLock();
        //lambda写法
        new Thread(() -> runMethod(lock), "thread1").start();
        new Thread(() -> runMethod(lock), "thread2").start(); //常规写法
        new Thread(new Runnable() {
            @Override
            public void run() {
                runMethod(lock);
            }
        }, "thread3").start();
    }

    private static void runMethod(Lock lock) {
        lock.lock();
        for (int i = 1; i <= 3; i++) {
            System.out.println("ThreadName:" + Thread.currentThread().getName()
                    + (" i=" + i));
        }
        System.out.println();
        lock.unlock();
    }


    public static void main(String[] args) throws Exception{
        //Jedis redis = new Jedis();

        final String abs = new String("abs");

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("********");
            }
        });
        thread.start();

        TestRabbitmq demo = new TestRabbitmq();
        new Thread( () -> demo.await(), "thread1" ).start(); Thread.sleep( 3000 );
        new Thread( () -> demo.signal(), "thread2" ).start();

        Lock lock = new ReentrantLock();
        new Thread(() -> runMethod(lock, 0), "thread1").start();
        new Thread(() -> runMethod(lock, 5000), "thread2").start();
        new Thread(() -> runMethod(lock, 1000), "thread3").start();
        new Thread(() -> runMethod(lock, 5000), "thread4").start();
        new Thread(() -> runMethod(lock, 1000), "thread5").start();
    }

    private void await()
    {
        try {
            lock.lock();
            System.out.println( "开始等待await! ThreadName:" + Thread.currentThread().getName() );
            condition.await();
            System.out.println( "等待await结束! ThreadName:" + Thread.currentThread().getName() );
        } catch ( InterruptedException e ) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    private void signal()
    {
        lock.lock();
        System.out.println( "发送通知signal! ThreadName:" + Thread.currentThread().getName() );
        condition.signal();
        lock.unlock();
    }

    private static void runMethod(Lock lock, long sleepTime) {
        lock.lock();
        try {
            Thread.sleep(sleepTime);
            System.out.println("ThreadName:" +
                    Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}

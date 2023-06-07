package com.multithreading.counter;

/*3. В методе main создать 4 потока типа CounterThread,
передав один и тот же объект Counter и запустить их, дождаться выполнения
и вывести на консоль в текущее значение нашего счетчика:
counter.getCount()*/
public class CounterRunner {
    public static void main(String[] args) {
         var counter = new Counter();
         var thread1 = new Thread(new CounterThread(counter));
         var thread2 = new Thread(new CounterThread(counter));
         var thread3 = new Thread(new CounterThread(counter));
         var thread4 = new Thread(new CounterThread(counter));
         var thread5 = new Thread(new CounterThread(counter));
         var thread6 = new Thread(new CounterThread(counter));
         var thread7 = new Thread(new CounterThread(counter));
         var thread8 = new Thread(new CounterThread(counter));
         var thread9 = new Thread(new CounterThread(counter));

         thread1.start();
         thread2.start();
         thread3.start();
         thread4.start();
         thread5.start();
         thread6.start();
         thread7.start();
         thread8.start();
         thread9.start();
        try {
            thread1.join();
            thread2.join();
            thread3.join();
            thread4.join();
            thread5.join();
            thread6.join();
            thread7.join();
            thread8.join();
            thread9.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(counter.getCount());
    }
}

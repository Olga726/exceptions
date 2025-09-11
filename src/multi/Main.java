package multi;

public class Main {
    private static volatile boolean stop;
    public static void main(String[] args) {

        //Напишите программу, в которой создается отдельный поток, выводящий сообщение "Привет из потока!"
        // 5 раз с паузой в 1 секунду между сообщениями.

        Runnable task1 = new Runnable() {
            @Override
            public void run() {
                for (int i=0; i<5; i++){
                    System.out.println("Привет из потока!");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }

            }
        };
        Thread thr1Task1 = new Thread(task1);
        thr1Task1.start();

        //Создайте два потока. Один поток должен печатать "A", второй — "B", каждый по 5 раз с небольшой задержкой.
        Thread thr1Task2 = new Thread(() -> {
            for(int i=0; i<5; i++){
                System.out.println("A");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        Thread thr2Task2 = new Thread(() -> {
            for(int i=0; i<5; i++){
                System.out.println("B");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        thr1Task2.start();
        thr2Task2.start();

        //Создайте поток, который бесконечно увеличивает счетчик.
        // В основном потоке через 2 секунды установите флаг stop = true, чтобы остановить поток.

        Thread task3 = new Thread(() ->{
            int counter1 = 0;
            while (!stop){
                counter1++;
            }
            System.out.println("counter1: " + counter1);
        });

        task3.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        stop=true;
        System.out.println("установлен stop=true");
        try {
            task3.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("состояние потока: " + task3.getState());

        // Напишите класс Counter с методом increment, увеличивающим значение счётчика. Создайте два потока,
        // каждый из которых вызывает increment() 1000 раз. Обеспечьте правильную работу с помощью synchronized.
        Counter counterTask4 = new Counter();
        Thread thr1Task4 = new Thread(() ->{
            for (int i=0; i<1000; i++){
                counterTask4.increment();
            }
        });
        Thread thr2Task4 = new Thread(() ->{
            for (int i=0; i<1000; i++){
                counterTask4.increment();
            }
        });

        thr1Task4.start();
        thr2Task4.start();

        try {
            thr1Task4.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        try {
            thr2Task4.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(counterTask4.getCounter4());


    }
}

package by.shipalex.day12;


public class MyThread extends Thread {
    public MyThread(String name) {
        super();
        setName(name);
    }

    public void run() {
        for (int i = 0; i < 71; i++) {
            System.out.println(getName() + " " + i);
            try {
                sleep(1); //попробовать sleep(0) и yield();
            } catch (InterruptedException e) {
                System.err.print("Error" + e);
            }
        }
    }

    public static void main(String[] args) {
        MyThread min = new MyThread("Min"); //1
        MyThread max = new MyThread("Max"); //10
        MyThread norm = new MyThread("Norm"); //5
        min.setPriority(Thread.MIN_PRIORITY);
        max.setPriority(Thread.MAX_PRIORITY);
        norm.setPriority(Thread.NORM_PRIORITY);
        min.start();
        norm.start();
        max.start();
    }

    public void run2() {
        String nameT = getName();
        System.out.println("Старт потока " + nameT);
        if ("First".equals(nameT)) {
            try {
                sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("завершение потока " + nameT);
        } else if ("Second".equals(nameT)) {
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("завершение потока " + nameT);
        }
    }

    public static void main2(String[] args) {
        MyThread tr1 = new MyThread("First");
        MyThread tr2 = new MyThread("Second");
        tr1.start();
        tr2.start();
        try {
            tr1.join();
            System.out.println("завершение main");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        /* join() не дает работать потоку  main до окончания выполнения
    потока tr1 */
    }

    public static void main3(String[] args) {
        new Thread() {
            public void run() {
                System.out.println("старт потока 1");
                Thread.yield();
                System.out.println("завершение 1");
            }
        }.start();
        new Thread() {
            public void run() {
                System.out.println("старт потока 2");
                System.out.println("завершение 2");
            }
        }.start(); // неизестно успеет ли начаться второй поток в тот квант времени, на который остановится первый.
        
        //как альтернатива - интерфейс Runnable передается в базовый Thread:
        (new Thread(new Runnable(){
                public void run() {
                    System.out.println("Поток стартовавший с помощью интерфеса");
                }
            })).start();
    }
}


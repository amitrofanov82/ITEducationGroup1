package deadlock;

public class DeadlockTest {
	
    public static void main(String[] args){
        ThreadSafeInteger a1 = new ThreadSafeInteger();
        ThreadSafeInteger a2 = new ThreadSafeInteger();
        Thread t1 = new Thread(new Tester(a1,a2));
        Thread t2 = new Thread(new Tester(a2,a1));
        t1.start();
        t2.start();
    }

    public static class Tester implements Runnable{

        static int nextId = 1;

        private ThreadSafeInteger obj1;
        private ThreadSafeInteger obj2;
        private int id = 0;

        public Tester(ThreadSafeInteger obj1, ThreadSafeInteger obj2){
            this.obj1 = obj1;
            this.obj2 = obj2;
            id = nextId++;
        }

        public void run(){
            print("Setting value to obj1... ");
            obj1.setValue(id);
            print("done.");
            print("Comparing objects... ");
            print("Done. Result: "+((obj1.equals(obj2)) ? "equal" : "not equal"));
        }

        private void print(String msg){
            System.out.println("Thread #"+id+": "+msg);
        }
    }

    public static class ThreadSafeInteger{

        private int value = 0;

        synchronized void setValue(int value){
            this.value = value;
        }

        synchronized int getValue(){
            return value;
        }

        public synchronized boolean equals(Object o){
            ThreadSafeInteger a = (ThreadSafeInteger) o;
            try{
                Thread.sleep(1000);
            }catch(InterruptedException ex){
                System.err.println("Interrupted!");
            }
            return value == a.getValue();
        }
    }
	
}

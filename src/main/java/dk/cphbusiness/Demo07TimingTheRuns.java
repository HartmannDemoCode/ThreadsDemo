package dk.cphbusiness;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Demo07TimingTheRuns {

    public static void main( String[] args ) {
        System.out.println( "Starting main thread" );
        long startTime = System.currentTimeMillis();
        runningTasksConcurrently();
        long endTime = System.currentTimeMillis();
        System.out.println( String.format("Execution time for concurrent run was: %s milli seconds",endTime-startTime) );
        startTime = System.currentTimeMillis();
        runningTasksSequentially();
        endTime = System.currentTimeMillis();
        System.out.println( String.format("Execution time for sequential run was: %s milli seconds",endTime-startTime) );
        System.out.println( "Main thread is done" );
    }

    private static void runningTasksConcurrently() {
        // Using a cached thread pool, we dont have to worry about the number of threads, because it will create new threads as needed
        ExecutorService workingJack = Executors.newCachedThreadPool();
        for ( int count = 0; count < 200; count++ ) {
            Runnable task = new MyTask( count );
            workingJack.submit( task );
        }
        workingJack.shutdown();
    }
    private static void runningTasksSequentially() {
        // This method is faster, because we don't have the overhead of creating threads
        for ( int count = 0; count < 200; count++ ) {
            Runnable task = new MyTask( count );
            task.run();
        }
    }

}

class MyTask implements Runnable {

    private int count = 0;

    MyTask( int cnt ) {
        count = cnt;
    }

    @Override
    public void run() {
        System.out.println( "Task: " + count );
    }
}

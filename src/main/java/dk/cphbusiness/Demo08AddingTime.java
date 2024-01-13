package dk.cphbusiness;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Demo08AddingTime {
    public static void main( String[] args ) {
        //ExecutorService workingJack = Executors.newSingleThreadExecutor();
        ExecutorService workingJack = Executors.newFixedThreadPool( 3);
        System.out.println( "Main starts" );
        for ( int count = 0; count < 25; count++ ) {
            Runnable task = new TaskWithSleep( count );
            workingJack.submit( task );
        }
        workingJack.shutdown();
//        try {
//            workingJack.awaitTermination( 10, java.util.concurrent.TimeUnit.SECONDS);
//        } catch (InterruptedException e) { System.out.println( "We got interrupted"); }
        System.out.println( "Main is done" );
    }

}

class TaskWithSleep implements Runnable {

    private int count = 0;
    private int sleepTime = 0;

    TaskWithSleep(int cnt ) {
        sleepTime = (int)(Math.random()*800+200); // At least 200 ms, up to one sec
        count = cnt;
    }

    @Override
    public void run() {
        try {
            Thread.sleep( sleepTime ); // simulate some external job taking time
            System.out.println( "Task: " + count );
        } catch ( InterruptedException ex ) {
            System.out.println( "Thread was interrupted" );
        }
    }
}
package dk.cphbusiness;

/**
 The purpose of Threads02 is to...

 @author kasper
 */
public class Demo03Lambda {

    public static void main( String[] args ) throws Exception {
        /*
        New thread by making a runnable (red level)
        The level red is because it uses lambda expressions
         */
        Thread t = new Thread( () -> {
            String[] strings = { "String 01", "String 02", "String 03", "String 04", "String 05" };
            for ( String str : strings ) {
                System.out.println( str );
                try {
                    Thread.sleep( 1000 );
                } catch ( InterruptedException ex ) {
                    System.out.println( "I was interopted" );
                }
            }
        } );
        System.out.println( "Starting new thread" );
        t.start();
//        t.join();
        Thread.sleep( 3000 );
        t.interrupt();
        System.out.println( "Main thread is done" );
    }
}

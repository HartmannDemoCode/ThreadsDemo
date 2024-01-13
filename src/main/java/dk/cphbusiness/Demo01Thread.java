package dk.cphbusiness;

public class Demo01Thread {

    public static void main( String[] args ) throws Exception{
//        New thread by making an anonymous subclass of Thread
        Thread t = new Thread() {
            @Override
            public void run() {
                String[] strings = { "String 01", "String 02", "String 03", "String 04", "String 05" };
                for ( String str : strings ) {
                    System.out.println( str );
                    try {
                        Thread.sleep( 1000 );
                    } catch ( InterruptedException ex ) {
                        System.out.println( "I was interopted" );
                    }
                }
            }
        };
        System.out.println( "Thread is being started" );
        t.start();
//        t.join();
//        t.interrupt();
        System.out.println( "Main thread is done" );
    }

}

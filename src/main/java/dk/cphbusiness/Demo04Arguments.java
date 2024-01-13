package dk.cphbusiness;

public class Demo04Arguments {
    // Show how we can send arguments to a thread

    public static void main( String[] args ) throws Exception {

        String[] stringArray01 = { "String 01", "String 02", "String 03", "String 04", "String 05" };
        String[] stringArray02 = { "String A", "String B", "String C", "String D", "String E" };
        String[] stringArray03 = { "First", "Second", "Third", "Fourth", "Fifth" };
        Thread t1 = new Thread( new TaskWithConstructor(stringArray01) );
        Thread t2 = new Thread( new TaskWithConstructor(stringArray02) );
        Thread t3 = new Thread( new TaskWithConstructor(stringArray03) );
        System.out.println( "Starting 3 threads" );
        t1.start(); t2.start(); t3.start();
        System.out.println( "Main thread is done" );
    }
}

class TaskWithConstructor implements Runnable {

    private String[] strings = null;

    public TaskWithConstructor(String... strings) {
        this.strings = strings;
    }
    
        
    @Override
    public void run() {
        for ( String msg : strings) {
            System.out.println( msg );
            try {
                Thread.sleep( 1000 );
            } catch ( InterruptedException ex ) {
                System.out.println( "I was interopted" );
            }
        }
    }

}

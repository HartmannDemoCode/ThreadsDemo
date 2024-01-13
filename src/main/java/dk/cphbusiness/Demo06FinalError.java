package dk.cphbusiness;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Demo06FinalError {

    public static void main( String[] args ) {
        ExecutorService workingJack = Executors.newSingleThreadExecutor();
        for ( int count = 0; count < 25; count++ ) {
            workingJack.submit( () -> {
                // Opgave: forklar hvad denne fejl skyldes
                // Fjern udkommenteringen i næste linje
//                System.out.println( "Hello "+ count + " to us" );
            } );
        }
        workingJack.shutdown();
    }
}

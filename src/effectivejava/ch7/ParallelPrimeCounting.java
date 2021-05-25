package effectivejava.ch7;

import java.math.BigInteger;
import java.util.stream.LongStream;

//effective sample for use parallel
public class ParallelPrimeCounting {

    static long pi(long n){
        return LongStream.rangeClosed(2, n)
                .parallel()
                .mapToObj(BigInteger::valueOf)
                .filter(bigInteger -> bigInteger.isProbablePrime(50))
                .count();
    }

    public static void main(String[] args) {

        System.out.println(pi(10_000_000));
    }

}

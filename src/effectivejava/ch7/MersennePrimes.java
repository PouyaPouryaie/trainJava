package effectivejava.ch7;

import java.math.BigInteger;
import java.util.stream.Stream;

import static java.math.BigInteger.*;

//in this code if you use parallel your code is failure lifecycle so do not use parallel when is not good
public class MersennePrimes {

    static Stream<BigInteger> primes() {
        return Stream.iterate(TWO, BigInteger::nextProbablePrime);
    }

    public static void main(String[] args) {
        primes().map(p -> TWO.pow(p.intValueExact()).subtract(ONE))
                .filter(mersenne -> mersenne.isProbablePrime(50))
                .limit(20)
                .forEach(System.out::println);
    }
}

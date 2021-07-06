import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;

public class Euler3 {


        public static void main(String[] args) {

        ArrayList<BigInteger> primes = new ArrayList<BigInteger>();
        BigInteger n = new BigInteger("645597847");

        for (BigInteger i = new BigInteger("2"); i.compareTo(bigIntSqRootCeil(n)) < 0; i = i.add(BigInteger.valueOf(1))) {

            boolean czyLiczbaJestPierwsza = true;

            for (BigInteger prime : primes) {
                if (i.mod(prime) == BigInteger.ZERO) {
                    czyLiczbaJestPierwsza = false;
                    break;
                }

            }
            if (czyLiczbaJestPierwsza) {
                primes.add(i);
//System.out.println(i);
            }

        }
        Collections.reverse(primes);

        for (BigInteger prime : primes) {
            if (n.mod(prime) == BigInteger.ZERO) {
                System.out.println(prime);
                break;
            }
        }
    }

    public static BigInteger bigIntSqRootCeil(BigInteger x)
            throws IllegalArgumentException {
        if (x.compareTo(BigInteger.ZERO) < 0) {
            throw new IllegalArgumentException("Negative argument.");
        }
        // square roots of 0 and 1 are trivial and
        // y == 0 will cause a divide-by-zero exception
        if (x == BigInteger.ZERO || x == BigInteger.ONE) {
            return x;
        } // end if
        BigInteger two = BigInteger.valueOf(2L);
        BigInteger y;
        // starting with y = x / 2 avoids magnitude issues with x squared
        for (y = x.divide(two);
             y.compareTo(x.divide(y)) > 0;
             y = ((x.divide(y)).add(y)).divide(two))
            ;
        if (x.compareTo(y.multiply(y)) == 0) {
            return y;
        } else {
            return y.add(BigInteger.ONE);
        }
    }
}
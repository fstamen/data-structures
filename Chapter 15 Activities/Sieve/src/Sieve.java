import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;


/**
 * A program that implements the sieve of Eratosthenes.
*/
public class Sieve
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Compute primes up to which integer?");
        int n = in.nextInt();
        Set<Integer> numbers = new HashSet<>();
        for(int i=2; i<=n; i++)
        {
            numbers.add(i);
        }

        
        for (int i = 2; i * i <= n; i++) {
            if (numbers.contains(i)) {
                Iterator<Integer> iterator = numbers.iterator();
                while (iterator.hasNext()) {
                    int num = iterator.next();
                    if (num != i && num % i == 0) {
                        iterator.remove();
                    }
                }
            }
        }
        
        
        System.out.println("Prime numbers up to " + n + ": " + numbers);
        
    }
}

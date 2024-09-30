import java.util.*;
import java.io.*;
/**
 * Read all words from a file and add them to a
 * map whose keys are word lengths and whose values
 * are comma-separated strings of words of the same length.
 * Then print out those strings, in increasing order by
 * the length of their entries.
 * Use the Java 8 merge() method from Java 8 Note 15.1.
 */
public class StringLengthMap2
{
    public static void main(String[] args)
    {
        String filename = "src/test1.txt";

        try (Scanner in = new Scanner(new File(filename)))
        {
       
            Map<Integer, String> words = new HashMap<>();

           
            while (in.hasNext())
            {
                String word = clean(in.next());
                Integer len = word.length();

                if (len > 0) 
                {
                
                    words.merge(len, word, (existingValue, newValue) -> existingValue + ", " + newValue);
                }
            }

           
            words.keySet().stream().sorted().forEach(length -> {
                System.out.println(length + ": " + words.get(length));
            });
        }
        catch (FileNotFoundException e)
        {
            System.out.println("Cannot open: " + filename);
        }
    }

    public static String clean(String s)
    {
        StringBuilder r = new StringBuilder();
        for (int i = 0; i < s.length(); i++)
        {
            char c = s.charAt(i);
            if (Character.isLetter(c))
            {
                r.append(c);
            }
        }
        return r.toString().toLowerCase();
    }
}

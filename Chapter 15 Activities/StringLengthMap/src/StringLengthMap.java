import java.io.*;
import java.util.*;
/**
 * Read all words from a file and add them to a
 * map whose keys are word lengths and whose values
 * are comma-separated strings of words of the same length.
 * Then print out those strings, in increasing order by
 * the length of their entries.
 * Modify Worked Example 15.1.
 */
public class StringLengthMap
{
    public static void main(String[] args) throws FileNotFoundException
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
                    words.put(len, words.getOrDefault(len, "") + (words.containsKey(len) ? ", " : "") + word);
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

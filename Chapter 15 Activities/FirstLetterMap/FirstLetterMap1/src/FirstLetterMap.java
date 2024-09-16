import java.util.*;
import java.io.*;
/**
 * Read all words from a file and add them to a map
 * whose keys are the first letters of the words and
 * whose values are sets of words that start with
 * that same letter.
 * Then print out the word sets in alphabetical order.
 * Use the Java 8 merge() feature.
*/
public class FirstLetterMap
{
    public static void main(String[] args)
    {
        String filename = "src/test1.txt";

        try (Scanner in = new Scanner(new File(filename)))
        {
    
            Map<Character, Set<String>> wordMap = new HashMap<>();

            while (in.hasNext())
            {
                String word = clean(in.next());
                
                if (word.length() > 0) { 
                    Character firstLetter = word.charAt(0);

 
                    wordMap.merge(firstLetter, new HashSet<>(Arrays.asList(word)),
                        (existingSet, newSet) -> { 
                            existingSet.addAll(newSet); 
                            return existingSet; 
                        });
                }
            }

            wordMap.keySet().stream().sorted().forEach(key -> {
                System.out.println(key + ": " + wordMap.get(key));
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

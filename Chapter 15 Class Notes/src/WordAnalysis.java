import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Set;
import java.util.Scanner;


/**
 * This program checks which words in a file are not present in a dictionary.
*/
public class WordAnalysis
{
    public static void main(String[] args)
        throws FileNotFoundException
    {
        // Read the dictionary file and the novel file
        Set<String> dictionaryWords = readWords("Chapter 15 Notes/src/words");
        Set<String> novelWords = readWords("Chapter 15 Notes/src/War-and-peace.txt");

        for (String word: novelWords)
        {
            if(!dictionaryWords.contains(word)){
                System.out.println(word);
            }
        }
        System.out.println(novelWords.size());

        // Print the number of unqie word with more than 3 letters 
        Iterator<String> iterator = novelWords.iterator();
        while (iterator.hasNext())
        {
            if (iterator.next().length()<=3){
                iterator.remove();
            }
        }

    }

    /**
     * Reads all words from a file.
     *
     * @param filename the name of the file
     * @return a set with all lowercased words in the file. Here, a
     * word is a sequence of upper- and lowercase letters.
    */
    public static Set<String> readWords(String filename)
        throws FileNotFoundException
    {
        // We use a HashSet instead of a TreeSet because order doesn't matter
        Set<String> words = new HashSet<>();
        
        // Determine current working directory
        // System.out.println(System.getProperty("user.dir"));

        Scanner in = new Scanner (new File(filename),"UTF-8");

        in.useDelimeter("[a-zA-Z]+");

        while(in.hasNext())
        {
            // Add words to the set (duplicate are already ignored)
            words.add(in.next().toLowerCase());
        }

        return null;
    }
}

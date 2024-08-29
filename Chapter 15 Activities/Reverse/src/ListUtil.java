import java.util.LinkedList;
import java.util.ListIterator;

/**
 * This class supplies a utility method to reverse the entries in a linked list.
*/
public class ListUtil
{
    /**
     * Reverses the elements in a linked list
     *
     * @param strings the linked list to reverse
    */
    public static void reverse(LinkedList<String> strings)
    {
        LinkedList<String> newList = new LinkedList<>();
        ListIterator<String> iterator = strings.listIterator();
        int count = 0;
        while(iterator.hasNext())
        {
            if(iterator.hasNext())
            {
                count++;
            }
            else
            {
                String n = iterator.previous();
                System.out.println(n);
                
            }
        }
        
    }
}
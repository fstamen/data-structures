import java.util.LinkedList;
import java.util.ListIterator;
/**
 * This program demonstrates the LinkedList class
 * and ListIterator class.
*/
public class ListDemo
{
    public static void main(String[] args)
    {
        /* The addLast method can be used to populate a list */
        LinkedList<String> staff = new LinkedList<>();
        staff.addLast("Tony");
        staff.addLast("Natasha");
        staff.addLast("Peter");
        staff.addLast("Gamora");
        
        System.out.println(staff);

        /*
         * the listIterator method creates new list iterator posisioned at the top of the list
         * the | is used to show the iterator position
         */

         ListIterator<String> iterator = staff.listIterator(); // |TNPG

         
        /* The next method advances the iterator over the next element in the list */
          

        iterator.next(); // T|NPG

        /* The next method also returns the element passed over */
        String avenger = iterator.next(); // TN|PG
        System.out.println(avenger);

        /* The add method inserts an element at the iterator position.
         * The iterator is then positioned AFTER the element was added.
         */

        iterator.add("Steve"); // TNS|PG
        iterator.add("Clint"); // TNSC|PG

        System.out.println(staff);

        /* The remove method removes the element returned by the last call to the next or previous
         * The remove method can only be called after calling next or previous
         */
        iterator.next(); // TNSCP|G
        iterator.remove();
        System.out.println(staff);

        /* The set method updats the element returned by the last call to next or previous */

        iterator.previous(); // TNS|CG
        iterator.set("T'Challa"); // TNS|TG
        System.out.println(staff);

        /* The hasNext method is used to determine if there is a next node
         * after the iterator.
         */

         iterator = staff.listIterator();
         while(iterator.hasNext()){
            String n = iterator.next();
            if (n.equals("Natasha")){
                iterator.remove(); // T|STG
            }
         } // TSTG|

         System.out.println(staff);

         /* Enhanced for loops work with linked lists */

         for (String n : staff){
            System.out.println(n+ " ");
         }
         System.out.println();

         /* ConcurrentModificationException
          * 
            cannot modify list while using an iterator

          */

        iterator = staff.listIterator();
        while(iterator.hasNext()){
            String n = iterator.next();
            if(n.equals("Tony")){
                // staff.remove("Tony"); ConcurrentModificationException
            }
        }

        /* the enhanced for loop will automatically create an iterator
         * CANNOT ADD OR REMOVE
         */

        for (String n : staff){
            if(n.equals("Tony")){
                staff.add("Bruce");
            }
        }
        System.out.println(staff);

    }
}

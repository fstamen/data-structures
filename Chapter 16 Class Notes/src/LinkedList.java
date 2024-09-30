import java.net.NetworkInterface;
import java.nio.channels.IllegalSelectorException;
import java.util.NoSuchElementException;

/**
 * A linked list is a sequence of nodes with efficient
 * element insertion and removal. This class
 * contains a subset of the methods of the standard
 * java.util.LinkedList class.
*/
public class LinkedList
{

    private Node first;

    /**
        Constructs an empty linked list.
    */


        public LinkedList(){
            this.first = null;

        }

    /**
        Returns the first element in the linked list.
        @return the first element in the linked list
    */

        public Object getFirst(){
            if(this.first == null){
                throw new NoSuchElementException();
            }
            return this.first.data;
        }


    /**
        Removes the first element in the linked list.
        @return the removed element
    */


        public Object removeFirst(){
            if(this.first == null){
                throw new NoSuchElementException();
            }
            Object element = this.first.data;
            this.first = this.first.next;
        }


    /**
        Adds an element to the front of the linked list.
        @param element the element to add
    */


        public void addFirst(Object element){
            Node newNode = new Node();
            newNode.data = element;
            newNode.next = this.first;
            this.first = newNode;
        }


    /**
        Returns an iterator for iterating through this list.
        @return an iterator for iterating through this list
    */

        public ListIterator listIterator(){
            return new LinkedListIterator();
        }

        

        @Override
        public String toString() {
            
            return super.toString();
        }





    //Class Node
    static class Node{
        public Node next;
        public Object data;


    }

    class LinkedListIterator implements ListIterator
    {
      //private data
      private Node position;
      private Node previous;

      private boolean isAfterNext;



        /**
            Constructs an iterator that points to the front
            of the linked list.
        */

        public LinkedListIterator(){
            position = null;
            previous = null;
            isAfterNext = false;
            // in our next method assuming we call next we can set is after next eequal to true then
            // and then in our add method we have to set isafternext to false

        }


        /**
            Moves the iterator past the next element.
            @return the traversed element
        */

        public Object next(){
            
            if(!hasNext()){
                throw new NoSuchElementException();
            }
            
            
            previous = position;

            if (position == null){
                position = first;
            }
            else{
                position = position.next;
            }

            return position.data;

        }





        /**
            Tests if there is an element after the iterator position.
            @return true if there is an element after the iterator position
        */

        public boolean hasNext(){

            // check if the list is empty
            if (position == null){
                return first != null;
            }
            return position.next != null;
        }

        public void add(Object element){
            // check if the iterator is at the beginning

            if(position == null){
                // what is the simplest way to add something to the list: the add first method
                addFirst(element);

                // whats one more thing we have to to put in there aka wha variable we have tro change

            }
            else{
                // thats if the iterator is at the beginning if it not theres more work we have to do
                Node newNode = new Node();
                // this code is very simpular to addfirst method
                newNode.data = element();
                newNode.next = position.next;
                // set the next element of the current position tp point to our new node
                position.next - newNode;

                // we havve the current node pointing ot tjhe position of previous and position so this GIVES us a really strong foundation for what we are planning to do
                // now things get fun now we get to remove stuff
            }

        }


        /**
            Adds an element before the iterator position
            and moves the iterator past the inserted element.
            @param element the element to add
        */






        /**
            Removes the last traversed element. This method may
            only be called after a call to the next() method.
        */

        public void remove(){
            // what is a super important thing we need to remember about the linkedlist method seen: something about not being able to calll it after next
            // so lets go back up to the top... i should say the top of the iterator
            if (!isAfterNext)
            {
                throw new IllegalStateException();
                // then agin we are goig to check if the iterator is at the begginging

            }
            if (position ==  first){
                removeFirst();
                position = null;
            }
            else{
                previous.next = position.next;
                position = previous;
            }

            isAfterNext = false;

            // so now we cant remove something unless weve called next at leat once 
            // we can just call remove first and set position equal to null

        
        }








        /**
            Sets the last traversed element to a different value.
            @param element the element to set
        */
        public void set(Object element){


            if(!isAfterNext){
                throw new IllegalSelectorException();

            }
            position.data = element;
        }



    }//LinkedListIterator
}//LinkedList

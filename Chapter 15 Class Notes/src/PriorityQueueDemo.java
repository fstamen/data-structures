import java.util.PriorityQueue;
import java.util.Queue;


/**
 * This program demonstrates a priority queue of to-do items. The
 * most important to-do items are removed first.
*/
public class PriorityQueueDemo
{
    public static void main(String[] args)
    {
        // Create todo list
        // The work order class has a priority and a description

        Queue<WorkOrder> todo = new PriorityQueue<>();

        todo.add(new WorkOrder(1, "Practice SAT"));
        todo.add(new WorkOrder(3, "Go to gym"));
        todo.add(new WorkOrder(2, "Write college essays"));
        todo.add(new WorkOrder(3, "Play videogames"));

        System.out.println(todo);

        while(todo.size() > 0){
            System.out.println(todo.remove());
        }


    }
}

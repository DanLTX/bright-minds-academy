import java.util.LinkedList;
public class Queue
{
    LinkedList list;
    
    public Queue(){list = new LinkedList();}
    public int size(){return list.size();}
    public boolean isEmpty(){return list.isEmpty();}
    public void enqueue(Object o){list.addLast(o);}
    public Object dequeue(){return list.removeFirst();}
    public Object front(){return list.getFirst();}  
}
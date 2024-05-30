public class LinkedList
{
    //List all attributes
    Node first, last, currNode;
    int size;
    //constructor
    public LinkedList()
    {
        first = null;
        last = null;
        currNode = null;
    }
    //insert at front 
    public void insertAtFront(Object o)
    {
        if(first == null){
            Node newNode = new Node(o);
            first = newNode;
            last = first;
        }   
        else{
            //first = new Node(car,first);
            //if there is no 2nd  constructor(guna bawah ni)
            Node newNode = new Node(o);
            newNode.next = first;
            first = newNode;
        }
        
        size++;
    }
    //insert at back
    public void insertAtBack(Object o)
    {
        if(last == null){
            Node newNode = new Node(o);
            first = newNode;
            last = first;
        }   
        else{
            //first = new Node(car,first);
            //if there is no 2nd  constructor(guna bawah ni)
            Node newNode = new Node(o);
            last.next = newNode;
            last  = newNode;
        }
        size++;
    }
    //removeFirst
    public Object removeFirst()
    {
        Object remove = null;
        if(first == null)
            return remove;
        else if(first == last)
        {
            remove = first.data;
            first = null;
            last = null;
            return remove;
        }
        else 
        {
            remove = first.data;
            first = first.next;
            return remove;
        }
    }
    //getFirst
    public Object getFirst()
    {
        if(first == null)
            return null;
        else
        {
            currNode = first;
            return first.data;        
        }
    }
    //getNext
    public Object getNext()
    {
        if(currNode != last)
        {
            currNode = currNode.next;
            return currNode.data;
        }
        else
            return null;
    }
    //getLast
    public Object getLast() {
        if (last == null)
        return null;
        else {
        currNode = last;
        return last.data;
        }
    }
    
    public int size(){
        return size;
    }
    //empty check
    public boolean isEmpty(){return first == null;}

    //remove anywhere
        public Object removeAnywhere(Object o) {
        Node current = first;
        Node previous = null;
        Object removedData = null;
    
        // If the list is empty
        if (first == null) {
            return removedData;
        }
    
        // If the node to remove is the first node
        if (first.data.equals(o)) {
            removedData = first.data;
            first = first.next;
            if (first == last) {
                last = null; // If there was only one node
            }
            size--;
            return removedData;
        }
    
        // Traverse the list to find the node with the data to remove
        while (current != null && !current.data.equals(o)) {
            previous = current;
            current = current.next;
        }
    
        // If the node was found
        if (current != null) {
            removedData = current.data;
            previous.next = current.next;
            if (current == last) {
                last = previous; // If the removed node was the last node
            }
            size--;
        }
    
        return removedData;
    }
}
package JSTD;

/**
 *
 * @author Philip
 */
public class Queue<E> {
    private JSTD.Nodes.Node<E> first;
    
    public Queue()
    {
        first = null;
    }
    
    public boolean isEmpty()
    {
        return first == null;
    }
    
    public E First()
    {
        if(!isEmpty())
        {
            return first.value;
        }
        return null;
    }
    
    private JSTD.Nodes.Node findLast()
    {
        JSTD.Nodes.Node<E> i = first;
        while(i != null)
        {
            if(!i.hasNext())
            {
                return i;
            }
            i = i.next;
        }
        return null;
    }
    
    public void clear()
    {
        first = null;
    }
    
    public void append(E value)
    {
        if(isEmpty())
        {
            first = new JSTD.Nodes.Node<E>(value);
        }
        else
        {
            JSTD.Nodes.Node last = findLast();
            last.next = new JSTD.Nodes.Node<E>(value);
        }
    }
    
    public E pop()
    {
        if(!isEmpty())
        {
            E r = first.value;
            first = first.next;
            return r;
        }
        return null;
    }
}

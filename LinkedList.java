package JSTD;
/**
 *
 * @author Philip
 */
public class LinkedList<E> {
    private JSTD.Nodes.BiNode<E> first;
    
    public LinkedList()
    {
        first = null;
    }
    public JSTD.Nodes.BiNode<E> First()
    {
        return first;
    }
    
    public JSTD.Nodes.BiNode<E> Last()
    {
        if(!isEmpty())
        {
            JSTD.Nodes.BiNode i = first;
            while(i.hasRight())
            {
                i = i.Right;
            }
            return i;
        }
        return null;
    }
    
    public boolean isEmpty()
    {
        return first == null;
    }
    
    public int length()
    {
        if(isEmpty())
        {
            return 0;
        }
        int i = 0;
        JSTD.Nodes.BiNode<E> n = first;
        while(n.hasRight())
        {
            ++i;
            n = n.Right;
        }
        return i + 1;
    }
    
    public void removeAll()
    {
        if(!isEmpty())
        {
            first.Right.Left = null;
            first = null;
        }
    }
    
    public void add(E value)
    {
        if(isEmpty())
        {
            first = new JSTD.Nodes.BiNode(value);
            return;
        }
        JSTD.Nodes.BiNode i = first;
        while(i.hasRight())
        {
            i = i.Right;
        }
        i.Right = new JSTD.Nodes.BiNode();
        i.Right.Value = value;
        i.Right.Left = i;
    }
    
    public void removeLast()
    {
        if(!isEmpty()&& Last().hasLeft())
        {
            Last().Left.Right = null;
            return;
        }
        first = null;
    }
    
    public void removeFirst()
    {
        if(!isEmpty() && first.hasRight())
        {
            JSTD.Nodes.BiNode<E> n = first;
            first = first.Right;
            first.Left = null;
            n.Right = null;
            n.Left = null;
            n = null;
            return;
        }
        first = null;
    }
    
    public boolean removeAt(JSTD.Nodes.BiNode node)
    {
        if(node == null)
        {
            return false;
        }
        else if(node == first)
        {
            removeFirst();
        }
        else if(node == Last())
        {
            removeLast();
        }       
        else
        {
            JSTD.Nodes.BiNode x = findNode(node);
            x.Right.Left = x.Left;
            x.Left.Right = x.Right;
            x = null;
        }
        return true;
    }
    
    public JSTD.Nodes.BiNode findNode(JSTD.Nodes.BiNode node) {
        JSTD.Nodes.BiNode ref = first;
        while (ref != null) 
        {
            if (ref == node) 
            {
                return ref;
            }
            ref = ref.Right;
        }
        return null;
    }
    
    public JSTD.Nodes.BiNode<E> findValue(E value)
    {
        JSTD.Nodes.BiNode ref = first;
        while (ref != null) 
        {
            if (ref.Value != null && ref.Value.equals(value))
            {
                return ref;
            }
            ref = ref.Right;
        }
        return null;
    }
    
    public boolean insertLeft(E value, JSTD.Nodes.BiNode node)
    {
        JSTD.Nodes.BiNode ref = findNode(node);
        if(ref == null)
        {
            return false;
        }
        else if(ref.Left == null)
        {
            ref.Left = new JSTD.Nodes.BiNode<E>(value);
            ref.Left.Right = ref;
            first = ref.Left;
        }
        else
        {
            ref = ref.Left;
            JSTD.Nodes.BiNode<E> newNode = new JSTD.Nodes.BiNode<E>(value);
            newNode.Left = ref;
            newNode.Right = ref.Right;
            ref.Right.Left = newNode;
            ref.Right = newNode;
        }
        return true; 
    }
    
    public boolean insertRight(E value, JSTD.Nodes.BiNode node)
    {
        JSTD.Nodes.BiNode ref = findNode(node);
        if(ref == null)
        {
            add(value);
            return true;
        }
        else
        {
            JSTD.Nodes.BiNode<E> newNode = new JSTD.Nodes.BiNode<E>(value);
            newNode.Left = ref;
            newNode.Right = ref.Right;
            ref.Right.Left = newNode;
            ref.Right = newNode;
        }
        return true; 
    }
    
    public String[] toStringArray()
    {
        int length = 1;
        JSTD.Nodes.BiNode x = first;
        if (x == null)
        {
            return null;
        }
        while(x.Right != null)
        {
            x = x.Right;
            length++;
        }
        x = first;
        String[] out = new String[length];
        int i = 0;
        while(x.Right != null)
        {
            out[i] = x.Value.toString();
            i++;
            x = x.Right;
        }
        out[i] = x.Value.toString();
        return out;
    }
}

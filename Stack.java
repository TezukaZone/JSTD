package JSTD;
/**
 *
 * @author Philip
 */
public class Stack<E> implements JSTD.Structure.StackI<E>{ 
    private JSTD.Nodes.Node<E> top;
    
    public Stack()
    {
        top = null;
    }
    
    public Stack(Stack<E> s)
    {
        if(s.isEmpty())
        {
            top = null;
            return;
        }
        JSTD.Nodes.Node<E> t = new JSTD.Nodes.Node<E>(s.Top());
        this.top = t;
        JSTD.Nodes.Node<E> st = s.top;
        while(st.hasNext())
        {
            
            t.next = new JSTD.Nodes.Node<E>(st.value);   
            t = t.next;
            st = st.next;
            
        }
        this.pop();
        t.next = new JSTD.Nodes.Node<E>(st.value);  
    }
    
    @Override
    public E Top(){
        return top.value;
    }
    
    @Override
    public void push(E value){
        if(value == null)
        {
            return;
        }
        if(isEmpty()){
            top = new JSTD.Nodes.Node<E>(value);
        }
        else{
            JSTD.Nodes.Node<E> newLayer = new JSTD.Nodes.Node<E>(value);
            newLayer.next = top;
            top = newLayer;
        }
    }
    
    @Override
    public E pop(){
        if(isEmpty()){
            return null;
        }
        JSTD.Nodes.Node<E> r = top;
        top = top.next;
        return r.value;
    }
    
    @Override
    public boolean isEmpty(){
        return top == null;
    }
    
    @Override
    public void clear(){
        top = null;
    }
    
    @Override
    public String toString()
    {
        return top.toString(); 
    }
    
    @Override
    public Stack<E> clone()
    {   
        return new Stack<E>(this);
    }
    
    @Override
    public java.util.List<E> toArray()
    {
        java.util.List<E> r = new java.util.ArrayList<E>();
        JSTD.Nodes.Node<E> n = this.top;
       
        if(!this.isEmpty())
            while(n != null)
            {
                r.add(n.value);
                n = n.next;
            }
        return r;
    }
}

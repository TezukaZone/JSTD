/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package JSTD.Nodes;

/**
 *
 * @author Philip
 */
public class Node<E> {
    public Node<E> next;
    public E value;
    public Node()
    {
        this.next = null;
        this.value = null;
    }
    
    public Node(E value)
    {
        this.next = null;
        this.value = value;
    }
    
    public boolean hasNext()
    {
        return this.next != null;
    }
}

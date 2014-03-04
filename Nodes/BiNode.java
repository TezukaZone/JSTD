package JSTD.Nodes;

/**
 *
 * @author Philip
 */
public class BiNode<E> {
    public BiNode Left, Right;
    public E Value;
    
    public BiNode() {
        this.Left = null;
        this.Right = null;
        this.Value = null;
    }
    
    public BiNode(E value){
        this.Left = null;
        this.Right = null;
        this.Value = value;
    }
    
    public boolean hasLeft()
    {
        return this.Left != null;
    }
    
    public boolean hasRight()
    {
        return this.Right != null;
    }
}

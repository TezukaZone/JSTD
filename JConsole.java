package JSTD;
/**
 *
 * @author Philip
 */
public class JConsole{
    private java.io.PrintStream outStream;
    private java.io.BufferedReader readStream;
    
    public JConsole(){
            outStream = System.out;
            readStream = new java.io.BufferedReader(new java.io.InputStreamReader(System.in));
            System.setErr(outStream);
    }
    
    public String readLine()
    {
        try
        {
            return readStream.readLine();
        }
        catch(java.io.IOException ex)
        {
            ex.printStackTrace();
            return null;
        }
    }
    
    public char read()
    {
        try
        {
            return (char)readStream.read();
        }
        catch(java.io.IOException ex)
        {
            ex.printStackTrace();
            return 0;
        }
    }

    public void write(Object o)
    {
        outStream.print(o);
    }
    
    public void writeLine(Object o)
    {
        outStream.println(o);
    
    }
    
    public void dispose() 
    {
        outStream.close();
        try
        {
            readStream.close();
        }
        catch(java.io.IOException ex)
        {
            ex.printStackTrace();
        }
        try 
        {
            this.finalize();
        } 
        catch (java.lang.Throwable ex) 
        {
            ex.printStackTrace();
        }
    }
}

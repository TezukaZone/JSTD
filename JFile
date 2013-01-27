package JSTD;
/**
 *
 * @author Philip
 */
public class JFile {
    public static enum FileType {txt, dat, inf, bat, xml, config, none}
    
    public boolean createFile(String name, FileType type)
    {
        JConsole c = new JConsole();
        try
        {
            if(type == FileType.none)
            {
                java.io.FileWriter fs  = new java.io.FileWriter(name);
                fs.close();
            }
            else
            {
                java.io.FileWriter fs = new java.io.FileWriter(name + "." + type);
                fs.close();
            }            
        }
        catch(java.io.IOException ex)
        {
            c.writeLine(ex);
            c.dispose();
            return false;
        }
        return true;
    }
    
    public boolean writeFile(java.io.File file, String data)
    {
        
        if(file.exists() && file.canWrite())
        {
            JConsole c = new JConsole();
            try
            {
                java.io.FileWriter fs = new java.io.FileWriter(file);
                fs.write(data);
                fs.close();
            }
            catch(java.io.IOException ex)
            {
                c.writeLine(ex);
                c.dispose();
                return false;
            }
        }
        else
        {
            return false;
        }
        return true;
    }
    
    public java.io.File getFile(String path)
    {
        return new java.io.File(path);
    }
    
    public String readFile(java.io.File file)
    {
        if(file.exists() && file.canRead())
        {
            JConsole c = new JConsole();
        String data = "";
            try
            {
                java.io.FileReader fs = new java.io.FileReader(file);
                while(fs.ready())
                {
                    data += (char)fs.read();
                }
                fs.close();
                return data;
            }
            catch(java.io.FileNotFoundException ex)
            {
                c.writeLine(ex);
                c.dispose();
                return "";
            }
            catch(java.io.IOException ex)
            {
                c.writeLine(ex);
                c.dispose();
                return data;
            }
        }
        return "";
    }
    
}

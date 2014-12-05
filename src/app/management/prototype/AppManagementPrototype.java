
package app.management.prototype;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
public class AppManagementPrototype {

   
    public static void main(String[] args) 
    throws IOException
    {
Path currentRelativePath = Paths.get("");
String s = currentRelativePath.toAbsolutePath().toString();
System.out.println("Current relative path is: " + s);

       SysFunc tSys = new SysFunc();
       tSys.mainMenu();
       }
    }


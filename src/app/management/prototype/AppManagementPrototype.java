
package app.management.prototype;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
public class AppManagementPrototype {

   
    public static void main(String[] args) 
    throws IOException
    {   SysFunc tSys = new SysFunc();
        Scanner i = new Scanner(System.in);
        Path currentRelativePath = Paths.get("");
        String s = currentRelativePath.toAbsolutePath().toString();
        System.out.println("Current relative path is: " + s);
        System.out.println("Please type 'new' to create a new account, or enter your account number to Log In.");
        String ch = i.nextLine();
        try{
        if (ch == "new"){ tSys.createAcc(); } 
        else { tSys.activeAccount = Integer.parseInt(ch);  tSys.mainMenu();} }
        catch(IOException e) { System.out.println("That Account does not exist");    }
        finally {System.out.println("That Account does not exist");}
       }
   }


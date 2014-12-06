
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
        System.out.println("Running from: " + s);
        System.out.println("Please type 'new' to create a new account, or press enter to Log In.");
        try{
        String ch = i.nextLine();
        if (ch.equalsIgnoreCase("new")){ tSys.createAcc(true); } 
        else { System.out.println("What is your account number?");
            tSys.activeAccount = i.nextInt(); Account aA = new Account(tSys.activeAccount);
            if (aA.getPerms().equalsIgnoreCase("c"))
          {tSys.custMenu();}
        else if(aA.getPerms().equalsIgnoreCase("d"))
          {tSys.devMenu();}
        else if(aA.getPerms().equalsIgnoreCase("a"))
          {tSys.adminMenu();}}
          
        }
        catch(IOException e) { System.out.println("That Account does not exist");    }
        finally {System.out.println("That Account does not exist");}
       }
   }


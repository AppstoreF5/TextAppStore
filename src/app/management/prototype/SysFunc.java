package app.management.prototype;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SysFunc {
    Path currentRelativePath = Paths.get("");
    public String accDir = currentRelativePath.toAbsolutePath().toString()+"\\Accounts\\";
    public String appDir = currentRelativePath.toAbsolutePath().toString()+"\\Apps\\";
    public int activeAccount;
    public int numOfAccounts = new File(accDir).list().length;
    public int numOfApps = new File(appDir).list().length;
    Scanner i = new Scanner(System.in);
    
// MENUS    
public void mainMenu() throws IOException
{   
    Account aA = new Account(activeAccount);
    Scanner in = new Scanner(System.in);    
    System.out.println("Logged in as "+aA.getName());
    System.out.println("-----------------------");
    System.out.println("What do you want to manage?");
        System.out.println("1.Accounts");
        System.out.println("2.Apps");
        System.out.println("Type a number to select an option");
        System.out.println("-----------------------");
        String choice = in.nextLine();
        switch (choice) {
            case "1":
                accMng();
                break;
            case "2":
                appMng();
                break;
            default:
            System.out.println("Not a valid option.");
                    System.out.println("-----------------------");
                    mainMenu();
                break;
        }
}
    
public void accMng() throws IOException
{
    Scanner in = new Scanner(System.in);  
    System.out.println("-----------------------");
    System.out.println("Account Management Menu");
           System.out.println("1.Create New Account");
           System.out.println("2.Delete account");
           System.out.println("3.Edit Account");
           System.out.println("4.Search for account");
           System.out.println("5.Display total Accounts");
           System.out.println("6.Return to Main Menu");
           System.out.println("Type a number to select an option");
           System.out.println("-----------------------");
           String choice = in.nextLine();
        switch (choice) {
            case "1":
                createAcc();
                break;
            case "2":
                deleteAcc();
                break;
            case "3":
                editAcc();
                break;
            case "4":
                searchAcc();
                break;
            case "5":
                System.out.println("-----------------------");
                System.out.println("There are currently "+numOfAccounts+" accounts.");
                System.out.println("-----------------------");
                accMng();
                break;
            case "6":
                mainMenu();
                break;
            default:
                System.out.println("-----------------------");
                System.out.println("Not a valid option.");
                System.out.println("-----------------------");
                accMng();
                break;
                
        }
           
    }
    
public void appMng() throws IOException
{
    Scanner in = new Scanner(System.in);   
    System.out.println("-----------------------");
    System.out.println("App Management Menu");
           System.out.println("1.Create New App");
           System.out.println("2.Delete App");
           System.out.println("3.Edit App");
           System.out.println("4.Search for App");
           System.out.println("5.Display total App");
           System.out.println("6.Return to Main Menu");
           System.out.println("Type a number to select an option");
           String choice = in.nextLine();
        switch (choice) {
            case "1":
                createApp();
                break;
            case "2":
                deleteApp();
                break;
            case "3":
                editApp();
                break;
            case "4":
                searchApp();
                break;
            case "5":
                System.out.println("There are currently "+numOfApps+" App(s).");
                appMng();
                break;
            case "6":
                mainMenu();
                break;
            default:
                System.out.println("Not a valid option.");
                System.out.println("-----------------------");
                appMng();
                break;
        }
   }

//Creators
public void createApp() throws IOException
{
    int cNum = numOfApps;
                    Scanner in = new Scanner(System.in);                   
                    System.out.println("What is the App's name?");
                    String n = in.nextLine();
                    System.out.println("What is the App's description?");
                    String a = in.nextLine();
                    System.out.println("What is the Developer name?");
                    String p = in.nextLine();
                    System.out.println("What is the App's cost? (GBP)");
                    String c = in.nextLine();
                    double pt = (int)(Math.random()*10000);
                    String pop = Double.toString(pt);
                    System.out.println("What is the type of the App?");
                    String t = in.nextLine();
                    System.out.println("Is the App for free or for purchasing? Type 1 for Free and 2 for Purchasing");
                    int ifp = in.nextInt();
                    String iff;
                    if(ifp==1){iff="Free";}
                    else {iff="Purchasing";}
                    
                    File f = new File(appDir+cNum);
                    do { cNum ++;} while(f.exists());
                    writeToFile(cNum, n, "app");
                    writeToFile(cNum, a, "app");
                    writeToFile(cNum, p, "app");
                    writeToFile(cNum, c, "app");
                    writeToFile(cNum, pop, "app");
                    writeToFile(cNum, t, "app");
                    writeToFile(cNum, iff, "app");
                    System.out.println("Your App has been created with the number "+cNum+".");
                    System.out.println("-----------------------");
                    numOfApps++;
                    appMng();
                    }
   
public void createAcc() throws IOException
{
     int cNum = numOfAccounts;
                    Scanner in = new Scanner(System.in);          
                    System.out.println("What is your Full Name?");
                    String n = in.nextLine();
                    System.out.println("What is your address?");
                    String a = in.nextLine();
                    System.out.println("What is your your Occupation?");
                    String p = in.nextLine();
                    
                    File f = new File(accDir+cNum);
                    do { cNum ++;} while(f.exists());
                    writeToFile(cNum, n, "acc");
                    writeToFile(cNum, a, "acc");
                    writeToFile(cNum, p, "acc");
                    writeToFile(cNum , "0", "acc");
                    writeToFile(cNum, "0", "acc");        
                    System.out.println("Your account has been created with the number "+cNum+".");
                    System.out.println("-----------------------");
                    numOfAccounts++;
                    accMng();
}
       
public void writeToFile(int file, String textLine, String t) throws IOException
{
    String path;
    if(t.equalsIgnoreCase("acc"))
    {path = accDir+file+".txt";}
    else
    { path = appDir+file+".txt";}
    
       boolean append_to_file = true;
  FileWriter write = new FileWriter(path, append_to_file);
  PrintWriter print_line = new PrintWriter(write);
  print_line.printf("%s%n", new Object[] { textLine });
  
  print_line.close();
    }

//Deleters
public void deleteAcc() throws IOException
{
Scanner in = new Scanner(System.in);
    System.out.println("Which Account do you want to delete");
int ch = in.nextInt();
File x = new File(accDir+ch+".txt");
boolean delete = x.delete();
if(delete)
System.out.println("Deleted!");
else 
System.out.println("Cannot Delete");
accMng();
}

public void deleteApp() throws IOException
{
    Scanner in = new Scanner(System.in);
System.out.println("Which App do you want to delete? (App Number)");
int ch = in.nextInt();
File x = new File(appDir+ch+".txt");
boolean delete = x.delete();
if(delete)
System.out.println("Deleted!");
else 
System.out.println("Cannot Delete");
appMng();  
}

//Editors
public void editAcc() throws FileNotFoundException, IOException
{
    System.out.println("Which Account do you want to edit? (Account Number)");
    Scanner impor = new Scanner(System.in);
    String editLine = "hi";
    int ach = impor.nextInt();
    String path = accDir+ach+".txt";
    String newline = System.getProperty("line.separator");
    
            
            FileReader fr1 = new FileReader(path);
            BufferedReader br1 = new BufferedReader(fr1);
            

            int numberOfLines = 3;
            String[] textData = new String[numberOfLines];
            for (int b = 0; b < numberOfLines; b++) {        
            textData[b] = br1.readLine(); }
            Scanner in = new Scanner(System.in);
            System.out.println("-----------------------");
            System.out.println(textData[0]);
            System.out.println(textData[1]);
            System.out.println(textData[2]);
            System.out.println("-----------------------");
            br1.close();
            FileWriter fw = new FileWriter(path);
            BufferedWriter bw = new BufferedWriter(fw);
            System.out.println("What do you want to edit?");
            System.out.println("type 1 for name");
            System.out.println("type 2 for Address");
            System.out.println("type 3 for Occupation");
            String inc = in.nextLine();
            System.out.println("What would you like to change it to?");
            String editMade = in.nextLine();
            switch (inc) {
            case "1":
                editLine = editMade + newline + textData[1] + newline + textData[2];
                break;
            case "2":
                editLine = textData[0] + newline + editMade + newline + textData[2];
                break;
            case "3":
                editLine = textData[0] + newline + textData[1] + newline + editMade;
                break;
        }
                  
           

            
            br1.close();
            
            bw.write(editLine);
            bw.flush();
            bw.close();
            FileReader fr = new FileReader(path);
            BufferedReader br = new BufferedReader(fr);
            for (int b = 0; b < numberOfLines; b++) {
            textData[b] = br.readLine(); }
            System.out.println("-----------------------");
            System.out.println(textData[0]);
            System.out.println(textData[1]);
            System.out.println(textData[2]);
            System.out.println("-----------------------");
   accMng();
}

public void editApp()
{
    // TBC
}

//Searchers
public void searchAcc() throws IOException
{
    try
    {
    Scanner in = new Scanner(System.in);
    System.out.println("What account are you looking for?(Account Number)");
   
    int an = in.nextInt();
    String path = accDir+an+".txt";
    
    Account aA = new Account(an);
    System.out.println("-----------------------");
    System.out.println(path);
    
    System.out.println("Name = "+aA.getName()+", Address = "+aA.getAddress()+", Occupation = "+aA.getProfession());  
   } 
    catch (IOException e)
   {
       System.out.println("-----------------------");
       System.out.println("Doesn't exist");
       System.out.println("-----------------------");
   }
   finally
    {
        System.out.println("-----------------------");
        System.out.println("Doesn't exist");
        System.out.println("-----------------------");
    accMng();}
    }



public void searchApp() throws IOException
{
    try {
    Scanner in = new Scanner(System.in);
    System.out.println("What App are you looking for?");
    int an = in.nextInt();
    String path = appDir+an+".txt";
    
    File ff = new File(path);
    App aA = new App(an);
    System.out.println(path);
   
    System.out.println("name = "+aA.getAppName()+", Description = "+aA.getDesc()+", Developer = "+aA.getDev()+", Cost = "+aA.getCost()); 
    }
    catch(IOException e)
            {
      System.out.println("-----------------------");
      System.out.println("Doesn't exist");
      System.out.println("-----------------------"); 
            }
     finally
    {
      System.out.println("-----------------------");
      System.out.println("Doesn't exist");
      System.out.println("-----------------------");
    accMng();}
    }
   
}




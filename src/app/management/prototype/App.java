

package app.management.prototype;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;


public final class App
{
    private  String appName;
    private  String appDesc;
    private  String dev;
    private  int pop;
    private  boolean type = false; //Does the app cost money
    private  double cost;
    Path currentRelativePath = Paths.get("");
    public String appDir = currentRelativePath.toAbsolutePath().toString()+"\\Apps\\";;
    
    public App(int ap) throws IOException
    {
        buildApp(ap);
    }
    public void buildApp(int fn)
    throws IOException
  {
    FileReader fr = new FileReader(appDir+fn+".txt");
    BufferedReader textReader = new BufferedReader(fr);
    
    int numberOfTextLines = 3;
    int numberOfNumberLines = 2;
    String[] textData = new String[numberOfTextLines];
    int[] numberData = new int[numberOfNumberLines];
    for (int i = 0; i < numberOfTextLines + numberOfNumberLines; i++) {
        
      textData[i] = textReader.readLine();
            
    }
    this.appName = textData[0];
    this.dev = textData[1];
    this.cost = numberData[2];
    this.appDesc = textData[3];
    this.pop = numberData[4];
    
    textReader.close();
      
  }
    // Everything past here is getters and setters
    // Setters

    public  void setAppName(String appN)
    {this.appName = appN;}
    public  void setDesc(String appD)
    {this.appDesc = appD + " , " + appName;}
    public  void setDev(String appDv)
    {this.dev = appDv;}
    public  void setPop(int appP)
    {this.pop = appP;}
    public  void setType()
    {if (this.cost <= 0)
    {this.type = true;}
    else
    {this.type = false;}}
    public void setCost(double appC)
    {if (appC > 0)
    {this.cost = appC;}
    else
    {this.cost = 0;}}
    //Getters
    public  String getAppName()
    { return this.appName; }
    public  String getDesc()
    { return this.appDesc; }
    public  String getDev()
    { return this.dev; }
    public  int getPop()
    { return this.pop; }
    public  boolean getType()
    { return this.type; }
    public  double getCost()
    { return this.cost; }
}


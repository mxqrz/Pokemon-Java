import java.util.*;
import java.lang.*;


public class Move 
{
    //VARIABLES
    private String name;
    private String type;
    private String category;
    private double power;
    private double accuracy;
    private double pp;
    
    //CONSTRUCTOR
    public Move(String name, String type, String category, double power, double accuracy, double pp) 
    {
        this.name = name;
        this.type = type;
        this.category = category;
        this.power = power;
        this.accuracy = accuracy;
        this.pp = pp;
    }
    
    //SETTERS

    public void setName(String name)
    {
        this.name = name;
    }
    
    public void setType(String type)
    {
        this.type = type;
    }
    
    public void setCat(String category)
    {
        this.category = category;
    }
    
    public void setPower(double power)
    {
        this.power = power;
    }
        
    public void setAcc(double accuracy)
    {
        this.accuracy = accuracy;
    }
        
    public void setPP(double pp)
    {
        this.pp = pp;
    }
        
    //GETTERS
    public String getName()
    {
        return name;
    }
        
    public String getType()
    {
        return type;
    }
        
    public String getCat()
    {
        return category;
    }
        
    public double getPower()
    {
        return power;
    }
        
    public double getAcc()
    {
        return accuracy;
    }
        
    public double getPP()
    {
        return pp;
    }
    
}

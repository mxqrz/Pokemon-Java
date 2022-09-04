import java.util.*;
import java.lang.*;

public class Pokemon
{
    //Base stats of the Pokemon
    private String name;
    private String nickname;
    private String primaryType;
    private String secondaryType;
    private HashMap<String, Move> learnedMoves = new HashMap<String, Move>();
    private double level = 1;  
    private double HP;
    private double maxHP;
    private double attack;
    private double defense;
    private double specialAttack;
    private double specialDefense;
    private double special = specialAttack + specialDefense;
    private double speed;
    private double xp;
    
    //constructor goes here
    public Pokemon (String name, String nickname, String primaryType, String secondaryType, double maxHP, double attack, double defense, double specialAttack, double specialDefense, double speed)
    {
        this.name = name;
        this.nickname = nickname;
        this.primaryType = primaryType;
        this.secondaryType = secondaryType;
        this.maxHP = Math.floor(0.01 * (2 * HP * level)) + level + 10;;
        this.HP = maxHP;
        this.attack = attack;
        this.defense = defense;
        this.special = special;
        this.speed = speed;
        updateStats();
    }
    
    //setters go here
    public void setNickname(String nickname)
    {
        this.nickname = nickname;
    }
    
    public void setPrimaryType(String primaryType)
    {
        this.primaryType = primaryType;
    }
    
    public void setSecondaryType(String secondaryType)
    {
        this.secondaryType = secondaryType;
    }
    
    public void setLevel(double level)
    {
        this.level = level;
    }
    
    public void setHP(double HP)
    {
        this.HP = HP;
    }
    
    public void setAttack(double attack)
    {
        this.attack = attack;
    }
    
    public void setDefense(double defense)
    {
        this.defense = defense;
    }
    
    public void setSpecial(double special)
    {
        this.special = special;
    }
    
    public void setSpeed(double speed)
    {
        this.speed = speed;
    }     

    
    //getters go here
    public double getLevel()
    {
        return level;
    }
    
    public String getName()
    {
        return name;
    }
    
    public String getNickname()
    {
        return nickname;
    }
    
    public String getPrimaryType()
    {
        return primaryType;
    }
    
    public String getSecondaryType()
    {
        return secondaryType;
    }
    
    public double getAttack()
    {
        return attack;
    }
    
    public double getDefense()
    {
        return defense;
    }
    
    public double getSpecial()
    {
        return special;
    }
    
    public double getSpeed()
    {
        return speed;
    }
    
    public double getHP()
    {
        return HP;
    }
    
    public double getMaxHP()
    {
        return maxHP;
    }
    
    public double getXP()
    {
        return xp;
    }
    
    public double getRequiredXP()
    {
        return Math.pow(getLevel(), 3) - getXP();
    }
      
    public Move getMove(String name)
    {
        try 
        {
            int x = Integer.parseInt(name);
            int i = 1;
            for (String s : learnedMoves.keySet())
            {
                if (x == i)
                {
                    return learnedMoves.get(s);
                }
                i++;
            }
        } 
        catch (NumberFormatException nfe) {
            for (String s : learnedMoves.keySet())
            {
                if (s.equals(name))
                {
                    return learnedMoves.get(s);
                }
            }
        }
        return getFirstMove();
    }
     
    //printers go here (things that print)
    public void printAllMoves()
    {
        System.out.println(nickname + " has learned the following moves:");
        int counter = 1;
        for (String s : learnedMoves.keySet())
        {
            
            System.out.println(counter + ". " + s);
            counter++;
            
        }
    }
    public void printAllStats()
    {
        System.out.println(nickname + " has the following stats:");
        System.out.println("Pokemon Species: " + name);
        System.out.println("Nickname: " + nickname);
        System.out.println("Primary Type: " + primaryType);
        System.out.println("Secondary Type: " + secondaryType);
        System.out.println("Level: " + level);
        System.out.println("HP: " + HP);
        System.out.println("Attack: " + attack);
        System.out.println("Defense: " + defense);
        System.out.println("Special: " + special);
        System.out.println("Speed: " + speed);
    }
    
    
    
    //make a method that allows the pokemon to learn a new move given the name of the move and the move itself as parameters
    public void learnMove(Move move)
    {
        this.learnedMoves.put(move.getName(), move);
    }
    
    public Move getFirstMove()
    {
        Move poop = (Move)learnedMoves.values().toArray()[0];
        return poop;
    }
    //make a method that allows you to update a pokemon’s stats when they level up once
    public void addXp(int up)
    {
        xp = xp + up;
    }
    
    //make a method that allows you to update a pokemon’s stats when they level up more than once at once
    public void levelUp()
    {
        double test = Math.pow(level, 3);
        if(xp == test){
            level++;
        }
    }
    
    public void updateStats()
    {
        HP = Math.floor(0.01 * (2 * HP * level)) + level + 10;
        attack = Math.floor(0.01 * (2 * attack * level) + 5);
        defense = Math.floor(0.01 * (2 * defense * level) + 5);
        specialAttack  =  Math.floor(0.01 * (2 * specialAttack * level) + 5);
        specialDefense = Math.floor(0.01 * (2 * specialDefense * level) + 5);
        speed = Math.floor(0.01 * (2 * speed * level) + 5);
    }

}

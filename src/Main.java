import java.io.*;
import java.util.*;
import java.lang.*;
import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.Graphics2D;

public class Main
{
    static Console console = System.console();
    static Reader reader = console.reader();
    static int start = 0;
    static String page = "";
    static int textSpeed = 0;

    // 0 = fast
    // 1 = slow

    static boolean showCursor = false;
    static String[] cmd1 = {"/bin/sh", "-c", "stty raw -echo </dev/tty"};
    static String[] cmd2 = {"/bin/sh", "-c", "stty sane -echo </dev/tty"};
    
	  //"\033[F" – move cursor to the beginning of the previous line
    //"\033[<N>A" – move cursor up N lines
    //"\033[<N>B" - move cursor down N lines
    
    //object declarations
    static Trainer player = new Trainer("YOUR");
    static Trainer opp = new Trainer("RIVAL'S");
    
    static int playerx = 16;
    static int playery = 16;
    static File playerSprite = new File("smallred/0.png");
    static int playerDirection = 0;
    
    static int starter = 0;
    static String[] choices = {"BULBASAUR", "CHARMANDER", "SQUIRTLE"};
	
    public static void main(String[] args) throws IOException, InterruptedException
    {
        System.out.print("\u001B[?25l");
        notice();
        drawSprite("cool/", 70, 135, 0);
        mainMenu();
        intro();
        redsRoom("redsroom/0.png");
        redsRoom("redsroom/1.png");
    }
    
    public static void notice() throws IOException, InterruptedException
    {
        textEngine("Please zoom out to 50-75% in your browser for the best gameplay experience.", 1);
    }
    
    public static void walk() throws IOException, InterruptedException
    {
        Runtime.getRuntime().exec(cmd1).waitFor();
        int r = reader.read();
        Runtime.getRuntime().exec(cmd2).waitFor();
        
        switch (r)
        {
            case (int)'w':
                if (playery - 16 < 16)
                {
                    break;
                }
                playery -= 16;
                playerSprite = new File("smallred/1.png");
                playerDirection = 1;
                break;
            case (int)'a':
                if (playerx - 16 < 0)
                {
                    break;
                }
                playerx -= 16;
                playerSprite = new File("smallred/2.png");
                playerDirection = 2;
                break;
            case (int)'s':
                if (playery + 16 > 16 * 7)
                {
                    break;
                }
                playery += 16;
                playerSprite = new File("smallred/0.png");
                playerDirection = 0;
                break;
            case (int)'d':
                if (playerx + 16 > 16 * 7)
                {
                    break;
                }
                playerx += 16;
                playerSprite = new File("smallred/3.png");
                playerDirection = 3;
                break;
        }
    }
    
    public static File returnIdleSprite() throws IOException, InterruptedException
    {
        switch (playerDirection)
        {
            case 0:
                playerSprite = new File("smallred/4.png");
                break;
            case 1:
                playerSprite = new File("smallred/5.png");
                break;
            case 2:
                playerSprite = new File("smallred/6.png");
                break;
            case 3:
                playerSprite = new File("smallred/7.png");
                break;
        }
        return playerSprite;
    }
    
    public static boolean checkEventRadius(int x, int y) throws IOException, InterruptedException
    {
        return (playerx == x - 16 && playery == y) || (playerx == x && playery == y - 16) || (playerx == x + 16 && playery == y) || (playerx == x && playery == y + 16) || (playerx == x - 16 && playery == y - 16) || (playerx == x + 16 && playery == y - 16) || (playerx == x - 16 && playery == y + 16) || (playerx == x + 16 && playery == y + 16); 
    }
    
    public static void redsRoom(String roomSprite) throws IOException, InterruptedException
    {
        playerx = 16*3;
        playery = 16*3;
        for (int i = 0; i < 100000; i++)
        {
            if (playerx == 16 * 7 && playery == 16) break;;
            if (checkEventRadius(48, 64))
            {
                Thread newThread = new Thread(() ->
                {
                    int r = 0;
                    try
                    {
                        Runtime.getRuntime().exec(cmd1).waitFor();
                        r = reader.read();
                    }
                    catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                    
                });         
            }
            Runtime.getRuntime().exec(cmd2).waitFor();

            System.out.print("\033[2J\033[1;1H");
            System.out.print(String.format("%c[%d;%df",0x1B,0,0));
            
            BufferedImage bg = ImageIO.read(new File(roomSprite));
            BufferedImage sprite = ImageIO.read(playerSprite);
        
            Graphics g = bg.getGraphics();
            g.drawImage(sprite, playerx, playery, null);
            BufferedImage output = new BufferedImage(16 * 5, 16 * 5, BufferedImage.TYPE_INT_ARGB);
            output.getGraphics().drawImage(bg, (playerx * -1) + (16 * 2), (playery * -1) + (16 * 2), null);
            
            File dir = new File("fullsprite/");
            dir.mkdir();
            File fullSprite = new File("fullsprite/0.png");
            ImageIO.write(output, "png", fullSprite);
            
            drawSprite("fullsprite/", 1, 0, 0, false);  
            playerSprite = returnIdleSprite();

            Thread newThread = new Thread(() -> {
                try
                {
                    walk();
                    try
                    {
                        Thread.sleep(1000);
                    }
                    catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            });
            newThread.start();
            System.out.println(playerx + ", " + playery);
            clearPage(200);
        }
    }
    
    public static void intro() throws IOException, InterruptedException
    {
        drawSprite("professoroak/0.png", true);
        
        try
        {
            Thread.sleep(2000);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        textEngine("Hello there! Welcome to the world of Pokémon!", 1);
        textEngine("My name is Mr. Vazquez! People call me the Pokémon Prof!", 1);
        System.out.print(String.format("%c[%d;%df",0x1B,0,0));
        drawSprite("professoroak/0.png", false);
        
        System.out.print("\033[2J\033[1;1H");
        try
        {
            Thread.sleep(1000);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        drawSprite("pokemon/25.png", true);
        try
        {
            Thread.sleep(1500);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        
        textEngine("This world is inhabited by creatures that we call Pokémon.", 1);
        textEngine("For some people, Pokémon are pets. Others use them for fights.", 1);
        textEngine("Myself...", 1);
        textEngine("I study Physics (and Pokémon) as a profession.", 1);
        
        System.out.print(String.format("%c[%d;%df",0x1B,0,0));
        drawSprite("pokemon/25.png", false);
        System.out.print(String.format("%c[%d;%df",0x1B,0,0));
        
        try
        {
            Thread.sleep(1000);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        drawSprite("red/0.png", true);
        try
        {
            Thread.sleep(1000);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        textEngine("First, what is your name?", 1);
        System.out.println();
        chooseName(7, "RED", "ASH", "GOKU", player);
        
        textEngine("Right! So your name is " + player.getName() + "!", 1);
        
        System.out.print(String.format("%c[%d;%df",0x1B,0,0));
        drawSprite("red/0.png", false);
        try
        {
            Thread.sleep(1000);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        drawSprite("blue/0.png", true);
        
        try
        {
            Thread.sleep(1000);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        textEngine("This is my cousin. He's been your rival since you were a baby.", 1);
        textEngine("...Erm, what is his name again?", 1);
        System.out.println();
        chooseName(7, "BLUE", "GARY", "VEGETA", opp);
        textEngine("That's right! I remember now! His name is " + opp.getName() + "!", 1);
        System.out.print(String.format("%c[%d;%df",0x1B,0,0));

        drawSprite("blue/0.png", false);
        System.out.print("\033[2J\033[1;1H");
        
        /*drawSprite("professoroak/0.png", true);
        try
        {
            Thread.sleep(2000);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        textEngine("Before you go on your journey...", 1);
        textEngine("I have 3 Pokémon left from my old days. I used to be a serious Pokémon trainer,", 1);
        textEngine("but you and " + opp.getName() + " can get one each.", 1);
        textEngine("Choose wisely!", 1);
        System.out.print(String.format("%c[%d;%df",0x1B,0,0));
        drawSprite("professoroak/0.png", false);*/
            
        //choosePokemon();
        
        try
        {
            Thread.sleep(1000);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        System.out.print(String.format("%c[%d;%df",0x1B,0,0));
        
        drawSprite("red/0.png", true);
        
        textEngine(player.getName() + "!", 1);
        textEngine("Your very own Pokémon legend is about to unfold!", 1);
        textEngine("A world of dreams and adventures with Pokémon awaits! Let's go!", 1);
        
        System.out.print("\033[2J\033[1;1H");
        System.out.print(String.format("%c[%d;%df",0x1B,0,0));
        drawSprite("transition1/", 1, 1000, 0);
        try
        {
            Thread.sleep(1000);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        
        System.out.print("\033[2J\033[1;1H");
        System.out.print(String.format("%c[%d;%df",0x1B,0,0));
        drawSprite("transition2/", 1, 1000, 0);
        try
        {
            Thread.sleep(1000);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        
        System.out.print("\033[2J\033[1;1H");
        System.out.print(String.format("%c[%d;%df",0x1B,0,0));
        drawSprite("smallred/", 1, 1000, 0);
        try
        {
            Thread.sleep(1000);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    
    public static void choosePokemon() throws IOException, InterruptedException
    {
        String[] starters = choices;
        starters[starter] = "> " + choices[starter];
        int margin = 5;
        
        for (int i = 0; i < margin; i++)
        {
            System.out.print(" ");
        }
        
        System.out.print("\033[s");
        System.out.print("◓-------------◓");
        System.out.println();
        
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < margin; j++)
            {
                System.out.print(" ");
            }
            System.out.print("| " + choices[i]);
            spaceOption(choices[i], 12);
            System.out.println();
        }
        
        for (int i = 0; i < margin; i++)
        {
            System.out.print(" ");
        }
        
        System.out.println("◓-------------◓");
        System.out.println();
        System.out.print("  USE W & D AND E TO SELECT");
        
        System.out.print(String.format("%c[%d;%df",0x1B,35,0));
        Runtime.getRuntime().exec(cmd1).waitFor();
        
        int choice = 0;
        int[] starterNumbers = {1, 4, 7};
        while (true)
        {
            int r = reader.read();
            
            if (r == (int)'w' && starter != 0)
            {
                starter--;
                drawSprite("pokemon/" + starterNumbers[starter] + ".png", true);
            }
            else
            if (r == (int)'s' && starter != 2)
            {
                starter++;
                drawSprite("pokemon/" + starterNumbers[starter] + ".png", true);
                System.out.print("\033]8");
                System.out.print("\033[" + starter + "B");
                System.out.print("\033[2K");
                
                for (int j = 0; j < margin; j++)
                {
                    System.out.print(" ");
                }
                System.out.print("| > " + starters[starter]);
                spaceOption(starters[starter], 12);
                System.out.println();
            }
            
            
        }
        
        /*switch (choice)
        {
            case 0:
                System.out.print("\033[2J\033[1;1H");
                drawSprite("pokemon/1.png", true);
                break;
            case 1:
                System.out.print("\033[2J\033[1;1H");
                drawSprite("pokemon/4.png", true);
                break;
            case 2:
                System.out.print("\033[2J\033[1;1H");
                drawSprite("pokemon/7.png", true);
                break;
        }*/
    }
    
    public static void chooseName(int y, String option1, String option2, String option3, Trainer trainer) throws IOException, InterruptedException
    {
        int choice = 0;
        
        for (int i = 0; i < y; i++)
        {
            System.out.print(" ");
        }
        System.out.print("◓------------◓");
        System.out.println();
        
        for (int i = 0; i < y; i++)
        {
            System.out.print(" ");
        }
        System.out.println("| > NEW NAME |");
        
        for (int i = 0; i < y; i++)
        {
            System.out.print(" ");
        }
        System.out.print("|   " + option1);
        spaceOption(option1, 9);
        System.out.println();

        for (int i = 0; i < y; i++)
        {
            System.out.print(" ");
        }
        System.out.print("|   " + option2);
        spaceOption(option2, 9);
        System.out.println();

        for (int i = 0; i < y; i++)
        {
            System.out.print(" ");
        }
        System.out.print("|   " + option3);
        spaceOption(option3, 9);
        System.out.println();
        
        for (int i = 0; i < y; i++)
        {
            System.out.print(" ");
        }
        System.out.println("◓------------◓");
        
        System.out.println();
        
        for (int i = 0; i < y - 6; i++)
        {
            System.out.print(" ");
        }
        System.out.print("  USE W & D AND E TO SELECT");
        
        System.out.print(String.format("%c[%d;%df",0x1B,35,0));
        Runtime.getRuntime().exec(cmd1).waitFor();
        
        while (true)
        {
            if (choice == 0)
            {
                int r = reader.read();
                if (r == (int)'s')
                {
                    Runtime.getRuntime().exec(cmd2).waitFor();
                    System.out.print(String.format("%c[%d;%df",0x1B,35,0));
                    
                    for (int i = 0; i < y; i++)
                    {
                        System.out.print(" ");
                    }
                    System.out.print("|   NEW NAME |");
                    
                    System.out.print(String.format("%c[%d;%df",0x1B,36,0));
                    for (int i = 0; i < y; i++)
                    {
                        System.out.print(" ");
                    }
                    System.out.print("| > " + option1);
                    spaceOption(option1, 9);
                    choice = 1;
                    Runtime.getRuntime().exec(cmd1).waitFor();
                }
                else
                if (r == (int)'e')
                {
                    Runtime.getRuntime().exec(cmd2).waitFor();
                    break;
                }
            }
            else
            if (choice == 1)
            {
                int r = reader.read();
                if (r == (int)'s')
                {
                    Runtime.getRuntime().exec(cmd2).waitFor();
                    System.out.print(String.format("%c[%d;%df",0x1B,36,0));
                    
                    for (int i = 0; i < y; i++)
                    {
                        System.out.print(" ");
                    }
                    System.out.print("|   " + option1);
                    spaceOption(option1, 9);
                    
                    System.out.print(String.format("%c[%d;%df",0x1B,37,0));
                    for (int i = 0; i < y; i++)
                    {
                        System.out.print(" ");
                    }
                    System.out.print("| > " + option2);
                    spaceOption(option2, 9);
                    
                    choice = 2;
                    Runtime.getRuntime().exec(cmd1).waitFor();
                }
                else
                if (r == (int)'w')
                {
                    Runtime.getRuntime().exec(cmd2).waitFor();
                    System.out.print(String.format("%c[%d;%df",0x1B,36,0));
                    
                    for (int i = 0; i < y; i++)
                    {
                        System.out.print(" ");
                    }
                    System.out.print("|   " + option1);
                    spaceOption(option1, 9);
                    
                    System.out.print(String.format("%c[%d;%df",0x1B,35,0));
                    for (int i = 0; i < y; i++)
                    {
                        System.out.print(" ");
                    }
                    System.out.print("| > NEW NAME |");
                    choice = 0;
                    Runtime.getRuntime().exec(cmd1).waitFor();
                }
                else
                if (r == (int)'e')
                {
                    Runtime.getRuntime().exec(cmd2).waitFor();
                    break;
                }
            }
            else
            if (choice == 2)
            {
                int r = reader.read();
                if (r == (int)'s')
                {
                    Runtime.getRuntime().exec(cmd2).waitFor();
                    System.out.print(String.format("%c[%d;%df",0x1B,37,0));
                    
                    for (int i = 0; i < y; i++)
                    {
                        System.out.print(" ");
                    }
                    System.out.print("|   " + option2);
                    spaceOption(option2, 9);
                    
                    System.out.print(String.format("%c[%d;%df",0x1B,38,0));
                    for (int i = 0; i < y; i++)
                    {
                        System.out.print(" ");
                    }
                    System.out.print("| > " + option3);
                    spaceOption(option3, 9);
                    choice = 3;
                    Runtime.getRuntime().exec(cmd1).waitFor();
                }
                else
                if (r == (int)'w')
                {
                    Runtime.getRuntime().exec(cmd2).waitFor();
                    System.out.print(String.format("%c[%d;%df",0x1B,37,0));
                    
                    for (int i = 0; i < y; i++)
                    {
                        System.out.print(" ");
                    }
                    System.out.print("|   " + option2);
                    spaceOption(option2, 9);
                    
                    System.out.print(String.format("%c[%d;%df",0x1B,36,0));
                    for (int i = 0; i < y; i++)
                    {
                        System.out.print(" ");
                    }
                    System.out.print("| > " + option1);
                    spaceOption(option1, 9);
                    
                    choice = 1;
                    Runtime.getRuntime().exec(cmd1).waitFor();
                }
                else
                if (r == (int)'e')
                {
                    Runtime.getRuntime().exec(cmd2).waitFor();
                    break;
                }
            }
            else
            if (choice == 3)
            {
                int r = reader.read();
                if (r == (int)'w')
                {
                    Runtime.getRuntime().exec(cmd2).waitFor();
                    System.out.print(String.format("%c[%d;%df",0x1B,38,0));
                    
                    for (int i = 0; i < y; i++)
                    {
                        System.out.print(" ");
                    }
                    System.out.print("|   " + option3);
                    spaceOption(option3, 9);
                    
                    System.out.print(String.format("%c[%d;%df",0x1B,37,0));
                    for (int i = 0; i < y; i++)
                    {
                        System.out.print(" ");
                    }
                    System.out.print("| > " + option2);
                    spaceOption(option2, 9);
                    choice = 2;
                    Runtime.getRuntime().exec(cmd1).waitFor();
                }
                else
                if (r == (int)'e')
                {
                    Runtime.getRuntime().exec(cmd2).waitFor();
                    break;
                }
            }
        }
        
        System.out.print(String.format("%c[%d;%df",0x1B,41,0));
        
        for (int i = 0; i < 9; i++)
        {
            System.out.print("\033[2K");
            System.out.print(String.format("\033[1A"));
        }
            
        System.out.print("\033[1B");
        
        if (choice == 0)
        {
            System.out.println();
            for (int i = 0; i < y; i++)
            {
                System.out.print(" ");
            }
            System.out.print(trainer.getName() + " NAME?");
            System.out.println();
            System.out.println();
            for (int i = 0; i < y; i++)
            {
                System.out.print(" ");
            }
            
            System.out.println("◓----------◓");
            
            for (int i = 0; i < y; i++)
            {
                System.out.print(" ");
            }
            System.out.println("| ________ |");
            
            for (int i = 0; i < y; i++)
            {
                System.out.print(" ");
            }
            
            System.out.println("◓----------◓");
            
            System.out.println();
            System.out.print(" PRESS ' TO ENTER AND = TO DELETE");
            
            int i = 0;
            char[] name = new char[8];
            
            while (true)
            {
            
                if (i <= 8)
                {
                    Runtime.getRuntime().exec(cmd1).waitFor();
                    int r = reader.read();
                    if (r == (int)'=' && i != 0)
                    {
                        Runtime.getRuntime().exec(cmd2).waitFor();
                        System.out.print(String.format("%c[%d;%df",0x1B,37,8));
                        name[i - 1] = '\0';
                        i--;
                        System.out.print("| ");
                        for (int k = 0; k < i; k++)
                        {
                            if (name[k] == ' ')
                            {
                                System.out.print('_');
                            }
                            else
                            {
                                System.out.print(name[k]);
                            }
                        }
                        for (int j = 0; j < 8 - i; j++)
                        {
                            System.out.print("_");
                        }
                        
                        System.out.print(" |");
                    }
                    else
                    if (r == (int)'\'')
                    {
                        break;
                    }
                    else
                    {
                        Runtime.getRuntime().exec(cmd2).waitFor();
                        System.out.print(String.format("%c[%d;%df",0x1B,37,8));
                        if (r != (int)'=' && i < 8) 
                        {
                            name[i] = Character.toUpperCase((char)r);
                            i++;
                            System.out.print("| ");
                            for (int k = 0; k < i; k++)
                            {
                                if (name[k] == ' ')
                                {
                                    System.out.print('_');
                                }
                                else
                                {
                                    System.out.print(name[k]);
                                }
                            }
                            for (int j = 0; j < 8 - i; j++)
                            {
                                System.out.print("_");
                            }
                            
                            System.out.print(" |");
                        }
                    }
                    
                }

            }
            
            String completeName = "";
            for (int b = 0; b < name.length; b++)
            {
                if (name[b] == '\0') break;
                completeName += name[b];
            }
            trainer.changeName(completeName);
            
            System.out.print(String.format("%c[%d;%df",0x1B,41,0));
        
            for (int b = 0; b < 8; b++)
            {
                System.out.print("\033[2K");
                System.out.print(String.format("\033[1A"));
            }
            
        }
        else
        if (choice == 1)
        {
            trainer.changeName(option1);
        }
        else
        if (choice == 2)
        {
            trainer.changeName(option2);
        }
        else
        if (choice == 3)
        {
            trainer.changeName(option3);
        }
    }
    
    public static void spaceOption(String option, int length)
    {
        for (int i = 0; i < length - option.length(); i++)
        {
            System.out.print(" ");
        }
        System.out.print("|");
    }
    
    public static void textEngine(String message, int y) throws IOException, InterruptedException
    {
        String[] words = message.split(" ");
        Runtime.getRuntime().exec(cmd2).waitFor();
        
        int speedMS = 100;
        
        if (textSpeed == 0)
        {
            speedMS = 50;
        }
        else
        {
            speedMS = 125;
        }
        
        //recommended margin is 16
        for (int i = 0; i < y; i++)
        {
            System.out.println();
        }
        
        System.out.print("◓");
        
        for (int i = 0; i < 30; i++)
        {
            System.out.print("-");
        }
        
        System.out.println("◓");
    
        for (int i = 0; i < 3; i++)
        {
            int counter = 0;
            System.out.print("| ");
            for (int j = 0; j < 29; j++)
            {
                System.out.print(" ");
            }
            System.out.print("|");
            
            if (i < 2)
            {
                System.out.println();
            }
        }
        
        for (int i = 0; i < y; i++)
        {
            System.out.println();
        }
        
        System.out.print("◓");
        
        for (int i = 0; i < 30; i++)
        {
            System.out.print("-");
        }
        
        System.out.print("◓");
        int index = 0;
        int counter = 0;
        
        while (index != words.length)
        {
            for (int i = 0; i < 3; i++)
            {
                String[] line = new String[words.length];
                ArrayList<Character> charHistory = new ArrayList<Character>();
                counter = 0;
                if (index == words.length) break;
                System.out.print(String.format("\033[%dA", 3 - i));
                
                System.out.print("\033[2K");
                System.out.print("\033[100D");
    
                System.out.print("| ");
    
                for (int j = index; j < words.length; j++)
                {
                    if (counter > 26 || (words[j].length() + counter) > 26)
                    {
                        break;
                    }
    
                    for (int k = 0; k < words[j].length(); k++)
                    {
                        for (int m = 0; m < charHistory.size(); m++) 
                        {
                            System.out.print(charHistory.get(m));
                        }
                        
                        System.out.print(words[j].charAt(k));
                        charHistory.add(words[j].charAt(k));
    
                        if (k == words[j].length() - 1)
                        {
                            charHistory.add(' ');
                            counter++;
                            for (int f = 0; f < 29 - counter; f++)
                            {
                                System.out.print(" ");
                            }
                            System.out.print("|");
                        }
                        else
                        {
                            for (int f = 0; f < 28 - counter; f++)
                            {
                                System.out.print(" ");
                            }
                            System.out.print("|");
                        }
                        counter++;
                    
                        try
                        {
                            Thread.sleep(speedMS);
                        }
                        catch (Exception e)
                        {
                            e.printStackTrace();
                        }
                        
                        System.out.print("\033[100D");
    
                        System.out.print("| ");
                    }
                    
                    index = j + 1;
                }
                
                System.out.print(String.format("\033[%dB", 3 - i));
            }
            
            System.out.print("\033[2B");
            System.out.print("\033[100D");
            System.out.println("      PRESS E TO CONTINUE");
            
            
            
    		Runtime.getRuntime().exec(cmd1).waitFor();
            int r = reader.read();
            while (r != (int)'e')
            {
                r = reader.read();
            }
            if (r == (int)'e')
            {
                speedMS = 0;
                Runtime.getRuntime().exec(cmd2).waitFor();
                System.out.print("\033[3A");
                for (int i = 0; i < 3; i++)
                {
                    System.out.print(String.format("\033[%dA", 3 - i));
                
                    System.out.print("\033[2K");
                    System.out.print("\033[100D");
        
                    System.out.print("| ");
                    for (int j = 0; j < 29; j++)
                    {
                        System.out.print(" ");
                    }
                    System.out.print("|");
                    System.out.print(String.format("\033[%dB", 3 - i));
                }
                
                System.out.print("\033[2B");
                System.out.print("\033[2K");
                
                System.out.print("\033[100D");
                System.out.print("\033[2A");
                System.out.print("\033[2C");
            }
        }
        
        System.out.print(String.format("\033[%dA", 4));
        System.out.print("hi");

        for (int i = 0; i < 6; i++)
        {
            System.out.print("\033[2K");
            System.out.print(String.format("\033[1B"));
        }
        
        System.out.print("\033[7A");
        System.out.print("\033[100D");
    }
    
    public static void mainMenu() throws IOException, InterruptedException
    {
        System.out.print("\033[2J\033[1;1H");
        
        printLogo();
        
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("              > START                   OPTIONS");
        System.out.println();
        System.out.println();
        System.out.print("                   USE A & D AND E TO SELECT    ");
        
        System.out.print(String.format("\033[%dA", 3));
    
		Runtime.getRuntime().exec(cmd1).waitFor();
        
        int option = 0;
        while (true)
        {
            if (option == 0)
            {
                int r = reader.read();
                if (r == (int)'d')
                {
                    Runtime.getRuntime().exec(cmd2).waitFor();
                    System.out.print("\033[2K");
                    System.out.print("\r                START                 > OPTIONS");
                    option = 1;
            		Runtime.getRuntime().exec(cmd1).waitFor();
    
                }
                else
                if (r == (int)'e')
                {
                    System.out.print("\033[H\033[2J");
                    Runtime.getRuntime().exec(cmd2).waitFor();
                    
                    start = 1;
                    break;
                }
            }
            else
            {
                int r = reader.read();
                if (r == (int)'a')
                {
                    Runtime.getRuntime().exec(cmd2).waitFor();
                    System.out.print("\033[2K");
                    System.out.print("\r              > START                   OPTIONS");
                    option = 0;
            		Runtime.getRuntime().exec(cmd1).waitFor();
                }
                else
                if (r == (int)'e')
                {
                    System.out.print("\033[H\033[2J");
                    Runtime.getRuntime().exec(cmd2).waitFor();
                    optionsPage();
                    break; 

                }
            }
        }
        
        
    }
    
    public static void clearPage(int ms) throws IOException, InterruptedException
    {
        try
        {
            Thread.sleep(ms);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        System.out.print("\033[2J\033[1;1H");
        System.out.flush();
    }
    
    
    
    public static void drawSprite(String directory, int frames, int speed, int margin)
    {
        try
        {
            for (int i = 0; i < frames; i++)
            {
                File file = new File(directory + i + ".png");
                BufferedImage image = ImageIO.read(file);

                for (int y = 0; y < image.getHeight(); y++)
                {
                    for (int j = 0; j < margin; j++)
                    {
                        System.out.print(" ");
                    }
                    for (int x = 0; x < image.getWidth(); x++)
                    {
                        int pixel = image.getRGB(x,y);
                        Color color = new Color(pixel, true);
                        int red = color.getRed();
                        int green = color.getGreen();
                        int blue = color.getBlue();
                        
                        
                       
                        
                            if (red <= 255 && red >= 235 && green <= 255 && green >= 235 && blue <= 255 && blue >= 235)
                            {
                                System.out.print(" ");
                            }
                            else
                            if (red > 80 && red < 235 && green > 80 && green < 235 && blue > 80 && blue < 235)
                            {
                                System.out.print("▒");
                            }
                            else
                            if (red > 35 && red <= 80 && green > 35 && green <= 80 && blue > 35 && blue <= 80)
                            {
                                System.out.print("▓");
                            }
                            else
                            if (red <= 35 && green <= 35 && blue <= 35)
                            {
                                System.out.print("█");
                            }
                        
                            if (x == image.getWidth() - 1) System.out.print("\n");
                    }
                }
    
                if (i != frames - 1)
                {
                    image.flush();
                    clearPage(135);
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    
    public static void drawSprite(String directory, int frames, int speed, int margin, boolean stretch)
    {
        try
        {
            for (int i = 0; i < frames; i++)
            {
                File file = new File(directory + i + ".png");
                if (stretch)
                {
                    BufferedImage img = ImageIO.read(file);
                    Image imgModified = img.getScaledInstance(img.getWidth() * 2, img.getHeight(), Image.SCALE_DEFAULT);
                    BufferedImage image = new BufferedImage(img.getWidth() * 2, img.getHeight(), BufferedImage.TYPE_INT_RGB);
                    image.getGraphics().drawImage(imgModified, 0, 0 , null);
                    
                    for (int y = 0; y < image.getHeight(); y++)
                    {
                        for (int j = 0; j < margin; j++)
                        {
                            System.out.print(" ");
                        }
                        for (int x = 0; x < image.getWidth(); x++)
                        {
                            int pixel = image.getRGB(x,y);
                            Color color = new Color(pixel, true);
                            int red = color.getRed();
                            int green = color.getGreen();
                            int blue = color.getBlue();
                            
                            if (red <= 255 && red >= 235 && green <= 255 && green >= 235 && blue <= 255 && blue >= 235)
                            {
                                System.out.print(" ");
                            }
                            else
                            if (red > 80 && red < 235 && green > 80 && green < 235 && blue > 80 && blue < 235)
                            {
                                System.out.print("▒");
                            }
                            else
                            if (red > 35 && red <= 80 && green > 35 && green <= 80 && blue > 35 && blue <= 80)
                            {
                                System.out.print("▓");
                            }
                            else
                            if (red <= 35 && green <= 35 && blue <= 35)
                            {
                                System.out.print("█");
                            }
                        
                            if (x == image.getWidth() - 1) System.out.print("\n");
                        }
                    }
    
                    if (i != frames - 1)
                    {
                        image.flush();
                        clearPage(135);
                    }
                }
                else
                {
                    BufferedImage image = ImageIO.read(file);
                    for (int y = 0; y < image.getHeight(); y++)
                    {
                        for (int j = 0; j < margin; j++)
                        {
                            System.out.print(" ");
                        }
                        for (int x = 0; x < image.getWidth(); x++)
                        {
                            int pixel = image.getRGB(x,y);
                            Color color = new Color(pixel, true);
                            int red = color.getRed();
                            int green = color.getGreen();
                            int blue = color.getBlue();
                            
                            if (red <= 255 && red >= 235 && green <= 255 && green >= 235 && blue <= 255 && blue >= 235)
                            {
                                System.out.print(" ");
                            }
                            else
                            if (red > 80 && red < 235 && green > 80 && green < 235 && blue > 80 && blue < 235)
                            {
                                System.out.print("▒");
                            }
                            else
                            if (red > 35 && red <= 80 && green > 35 && green <= 80 && blue > 35 && blue <= 80)
                            {
                                System.out.print("▓");
                            }
                            else
                            if (red <= 35 && green <= 35 && blue <= 35)
                            {
                                System.out.print("█");
                            }
                        
                            if (x == image.getWidth() - 1) System.out.print("\n");
                        }
                    }
    
                    if (i != frames - 1)
                    {
                        image.flush();
                        clearPage(135);
                    }
                }

                
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    
    public static void drawSprite(String directory, boolean fadeIn)
    {
        try
        {
            File file = new File(directory);
            BufferedImage image = ImageIO.read(file);
            
            if (fadeIn)
            {
                for (int i = 0; i < 3; i++)
                {
                    for (int y = 0; y < image.getHeight(); y++)
                    {
                        
                        for (int x = 0; x < image.getWidth(); x++)
                        {
                            int pixel = image.getRGB(x,y);
                            Color color = new Color(pixel, true);
                            int red = color.getRed() + (50 * (3 - i));
                            int green = color.getGreen()  + (50 * (3 - i));
                            int blue = color.getBlue() + (50 * (3 - i));

                            if (red >= 235 && green >= 235 && blue >= 235)
                            {
                                System.out.print(" ");
                            }
                            else
                            if (red > 80 && red < 235 && green > 80 && green < 235 && blue > 80 && blue < 235)
                            {
                                System.out.print("▒");
                            }
                            else
                            if (red > 35 && red <= 80 && green > 35 && green <= 80 && blue > 35 && blue <= 80)
                            {
                                System.out.print("▓");
                            }
                            else
                            if (red <= 35 && green <= 35 && blue <= 35)
                            {
                                System.out.print("█");
                            }
                        
                            if (x == image.getWidth() - 1) System.out.print("\n");
                        }
                    }
    
                    if (i != 3)
                    {
                        image.flush();
                        clearPage(135);
                    }
                }
                

                    
                for (int y = 0; y < image.getHeight(); y++)
                {
                    
                    for (int x = 0; x < image.getWidth(); x++)
                    {
                        int pixel = image.getRGB(x,y);
                        Color color = new Color(pixel, true);
                        int red = color.getRed();
                        int green = color.getGreen();
                        int blue = color.getBlue();

                        if (red >= 235 && green >= 235 && blue >= 235)
                        {
                            System.out.print(" ");
                        }
                        else
                        if (red > 80 && red < 235 && green > 80 && green < 235 && blue > 80 && blue < 235)
                        {
                            System.out.print("▒");
                        }
                        else
                        if (red > 35 && red <= 80 && green > 35 && green <= 80 && blue > 35 && blue <= 80)
                        {
                            System.out.print("▓");
                        }
                        else
                        if (red <= 35 && green <= 35 && blue <= 35)
                        {
                            System.out.print("█");
                        }
                    
                        if (x == image.getWidth() - 1) System.out.print("\n");
                    }
                }
            }
            else
            {
                for (int i = 0; i < 3; i++)
                {
                    for (int y = 0; y < image.getHeight(); y++)
                    {
                        for (int x = 0; x < image.getWidth(); x++)
                        {
                            int pixel = image.getRGB(x,y);
                            Color color = new Color(pixel, true);
                            int red = color.getRed() + (50 * i);
                            int green = color.getGreen() + (50 * i);
                            int blue = color.getBlue() + (50 * i);
                            
                            if (red >= 235 && green >= 235 && blue >= 235)
                            {
                                System.out.print(" ");
                            }
                            else
                            if (red > 80 && red < 235 && green > 80 && green < 235 && blue > 80 && blue < 235)
                            {
                                System.out.print("▒");
                            }
                            else
                            if (red > 35 && red <= 80 && green > 35 && green <= 80 && blue > 35 && blue <= 80)
                            {
                                System.out.print("▓");
                            }
                            else
                            if (red <= 35 && green <= 35 && blue <= 35)
                            {
                                System.out.print("█");
                            }
                        
                            if (x == image.getWidth() - 1) System.out.print("\n");
                        }
                    }
    
                    if (i != 3)
                    {
                        image.flush();
                        clearPage(135);
                    }
                }
                //opacity = (byte)0;
                for (int y = 0; y < image.getHeight(); y++)
                {
                    for (int x = 0; x < image.getWidth(); x++)
                    {
                        int pixel = image.getRGB(x,y);
                        Color color = new Color(pixel, true);
                        int red = color.getRed() + 235;
                        int green = color.getGreen() + 235;
                        int blue = color.getBlue() + 235;
                        
                        if (red >= 235 && green >= 235 && blue >= 235)
                        {
                            System.out.print(" ");
                        }
                        else
                        if (red > 80 && red < 235 && green > 80 && green < 235 && blue > 80 && blue < 235)
                        {
                            System.out.print("▒");
                        }
                        else
                        if (red > 35 && red <= 80 && green > 35 && green <= 80 && blue > 35 && blue <= 80)
                        {
                            System.out.print("▓");
                        }
                        else
                        if (red <= 35 && green <= 35 && blue <= 35)
                        {
                            System.out.print("█");
                        }
                    
                        if (x == image.getWidth() - 1) System.out.print("\n");
                    }
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    
    public static void drawSprite(String directory, int frames, int speed, int margin, boolean stretch, int xPos, int yPos)
    {
        try
        {
            for (int i = 0; i < frames; i++)
            {
                File file = new File(directory + i + ".png");
                if (stretch)
                {
                    BufferedImage img = ImageIO.read(file);
                    Image imgModified = img.getScaledInstance(img.getWidth() * 2, img.getHeight(), Image.SCALE_DEFAULT);
                    BufferedImage image = new BufferedImage(img.getWidth() * 2, img.getHeight(), BufferedImage.TYPE_INT_RGB);
                    image.getGraphics().drawImage(imgModified, 0, 0 , null);
                
                    System.out.print(String.format("%c[%d;%df",0x1B,xPos,yPos));
                
                    for (int y = 0; y < image.getHeight(); y++)
                    {
                        for (int j = 0; j < margin; j++)
                        {
                            System.out.print(" ");
                        }
                        for (int x = 0; x < image.getWidth(); x++)
                        {
                            int pixel = image.getRGB(x,y);
                            Color color = new Color(pixel, true);
                            int red = color.getRed();
                            int green = color.getGreen();
                            int blue = color.getBlue();
                            
                            if (red <= 255 && red >= 235 && green <= 255 && green >= 235 && blue <= 255 && blue >= 235)
                            {
                                System.out.print(" ");
                            }
                            else
                            if (red > 80 && red < 235 && green > 80 && green < 235 && blue > 80 && blue < 235)
                            {
                                System.out.print("▒");
                            }
                            else
                            if (red > 35 && red <= 80 && green > 35 && green <= 80 && blue > 35 && blue <= 80)
                            {
                                System.out.print("▓");
                            }
                            else
                            if (red <= 35 && green <= 35 && blue <= 35)
                            {
                                System.out.print("█");
                            }
                        
                            if (x == image.getWidth() - 1) System.out.print("\n");
                        }
                    }
    
                    if (i != frames - 1)
                    {
                        image.flush();
                        clearPage(135);
                    }
                }
                else
                {
                    BufferedImage image = ImageIO.read(file);
                    for (int y = 0; y < image.getHeight(); y++)
                    {
                        for (int j = 0; j < margin; j++)
                        {
                            System.out.print(" ");
                        }
                        for (int x = 0; x < image.getWidth(); x++)
                        {
                            int pixel = image.getRGB(x,y);
                            Color color = new Color(pixel, true);
                            int red = color.getRed();
                            int green = color.getGreen();
                            int blue = color.getBlue();
                            
                            if (red <= 255 && red >= 235 && green <= 255 && green >= 235 && blue <= 255 && blue >= 235)
                            {
                                System.out.print(" ");
                            }
                            else
                            if (red > 80 && red < 235 && green > 80 && green < 235 && blue > 80 && blue < 235)
                            {
                                System.out.print("▒");
                            }
                            else
                            if (red > 35 && red <= 80 && green > 35 && green <= 80 && blue > 35 && blue <= 80)
                            {
                                System.out.print("▓");
                            }
                            else
                            if (red <= 35 && green <= 35 && blue <= 35)
                            {
                                System.out.print("█");
                            }
                        
                            if (x == image.getWidth() - 1) System.out.print("\n");
                        }
                    }
    
                    if (i != frames - 1)
                    {
                        image.flush();
                        clearPage(135);
                    }
                }

                
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    
    public static void optionsPage() throws IOException, InterruptedException
    {
        boolean tsHover = true;
        int ts = 1;
        int tsChoice = textSpeed;
        boolean tcHover = false;
        int tc = 0;
        int tcChoice = 1;
        if (showCursor) tcChoice = 0;
        int choice = 0;
        boolean backHover = false;
        

        printLogo();
        
        System.out.println();
        System.out.println();
        System.out.println("                  TEXT SPEED");
        
        if (textSpeed == 0)
        {
            System.out.println("                > FAST                  SLOW");
        }
        else
        {
            System.out.println("                > FAST                • SLOW");
            tsChoice = 1;
        }
        
        System.out.println();
        System.out.println("                  SHOW TEXT CURSOR");
        
        if (showCursor)
        {
            System.out.println("                • YES                  NO");
        }
        else
        {
            System.out.println("                  YES                • NO");
            tcChoice = 1;
        }
        
        System.out.println();
        System.out.println("                  BACK");
        
        System.out.println();
        System.out.println();
        System.out.print("                   USE WASD AND E TO SELECT    ");
        
        System.out.print(String.format("%c[%d;%df",0x1B,22,0));

	    Runtime.getRuntime().exec(cmd1).waitFor();
        
        while (true)
        {
            if (choice == 0 && tsHover)
            {
                int r = reader.read();
                if (r == (int)'s')
                {
                    //System.out.print(String.format("\033[%dB", 3)); going down 3 lines %d is the parameter in format (3)
                    Runtime.getRuntime().exec(cmd2).waitFor();
                    System.out.print(String.format("%c[%d;%df",0x1B,25,0));
                    System.out.print("\033[2K");
                    System.out.print("\r                > YES                ");
                    if (tcChoice == 1)
                    {
                        System.out.print("• NO");
                    }
                    else
                    {
                        System.out.print("  NO");
                    }
                    
                    System.out.print(String.format("%c[%d;%df",0x1B,22,0));
                    System.out.print("\033[2K");
                    
                    System.out.print("\r                ");
                    if (tsChoice == 0)
                    {
                        System.out.print("• FAST                  SLOW");
                    }
                    else
                    {
                        System.out.print("  FAST                • SLOW");
                    }
                
                    tsHover = false;
                    tcHover = true;
                    
            		Runtime.getRuntime().exec(cmd1).waitFor();
                }
                else
                if (r == (int)'d')
                {
                    Runtime.getRuntime().exec(cmd2).waitFor();
                    System.out.print(String.format("%c[%d;%df",0x1B,22,0));
                    System.out.print("\033[2K");
                    System.out.print("\r                ");
                    if (tsChoice == 0)
                    {
                        System.out.print("• FAST");
                    }
                    else
                    {
                        System.out.print("  FAST");
                    }
                    
                    choice = 1;
                    System.out.print("                > SLOW");
                    Runtime.getRuntime().exec(cmd1).waitFor();
                }
                else
                if (r == (int)'e')
                {
                    Runtime.getRuntime().exec(cmd2).waitFor();
                    System.out.print(String.format("%c[%d;%df",0x1B,22,0));
                    System.out.print("\033[2K");
                    System.out.print("\r                > FAST                  SLOW");
                    
                    Runtime.getRuntime().exec(cmd1).waitFor();
                    tsChoice = 0;
                }
            }
            else
            if (choice == 1 && tsHover)
            {
                int r = reader.read();
                if (r == (int)'a')
                {
                    Runtime.getRuntime().exec(cmd2).waitFor();
                    System.out.print(String.format("%c[%d;%df",0x1B,22,0));
                    System.out.print("\033[2K");
                    System.out.print("\r                > FAST                ");
                    
                    if (tsChoice == 1)
                    {
                        System.out.print("• SLOW");
                    }
                    else
                    {
                        System.out.print("  SLOW");
                    }
                    
                    choice = 0;
            		Runtime.getRuntime().exec(cmd1).waitFor();
                }
                else
                if (r == (int)'s')
                {
                    Runtime.getRuntime().exec(cmd2).waitFor();
                    System.out.print(String.format("%c[%d;%df",0x1B,25,0));
                    System.out.print("\033[2K");
                    System.out.print("\r                ");
                    if (tcChoice == 0)
                    {
                        System.out.print("• YES");
                    }
                    else
                    {
                        System.out.print("  YES");
                    }
                    
                    System.out.print("                > NO");
                    
                    System.out.print(String.format("%c[%d;%df",0x1B,22,0));
                    System.out.print("\033[2K");
                    
                    System.out.print("\r                ");
                    if (tsChoice == 0)
                    {
                        System.out.print("• FAST                  SLOW");
                    }
                    else
                    {
                        System.out.print("  FAST                • SLOW");
                    }
                
                    tsHover = false;
                    tcHover = true;
                    
            		Runtime.getRuntime().exec(cmd1).waitFor();
                }
                else 
                if (r == (int)'e')
                {
                    Runtime.getRuntime().exec(cmd2).waitFor();
                    System.out.print(String.format("%c[%d;%df",0x1B,22,0));
                    System.out.print("\033[2K");
                    System.out.print("\r                  FAST                > SLOW");
                    
                    Runtime.getRuntime().exec(cmd1).waitFor();
                    tsChoice = 1;
                }
            }
            else
            if (choice == 0 && tcHover)
            {
                int r = reader.read();
                if (r == (int)'w')
                {
                    //System.out.print(String.format("\033[%dB", 3)); going down 3 lines %d is the parameter in format (3)
                    Runtime.getRuntime().exec(cmd2).waitFor();
                    System.out.print(String.format("%c[%d;%df",0x1B,22,0));
                    System.out.print("\033[2K");
                    System.out.print("\r                > FAST                ");
                    if (tsChoice == 1)
                    {
                        System.out.print("• SLOW");
                    }
                    else
                    {
                        System.out.print("  SLOW");
                    }
                    
                    System.out.print(String.format("%c[%d;%df",0x1B,25,0));
                    System.out.print("\033[2K");
                    
                    System.out.print("\r                ");
                    if (tcChoice == 0)
                    {
                        System.out.print("• YES                  NO");
                    }
                    else
                    {
                        System.out.print("  YES                • NO");
                    }
                
                    tsHover = true;
                    tcHover = false;
                    
            		Runtime.getRuntime().exec(cmd1).waitFor();
                }
                else
                if (r == (int)'d')
                {
                    Runtime.getRuntime().exec(cmd2).waitFor();
                    System.out.print(String.format("%c[%d;%df",0x1B,25,0));
                    System.out.print("\033[2K");
                    System.out.print("\r                ");
                    if (tcChoice == 0)
                    {
                        System.out.print("• YES");
                    }
                    else
                    {
                        System.out.print("  YES");
                    }
                    
                    choice = 1;
                    System.out.print("                > NO");
                    Runtime.getRuntime().exec(cmd1).waitFor();
                }
                else
                if (r == (int)'e')
                {
                    Runtime.getRuntime().exec(cmd2).waitFor();
                    System.out.print(String.format("%c[%d;%df",0x1B,25,0));
                    System.out.print("\033[2K");
                    System.out.print("\r                > YES                  NO");
                    System.out.print("\u001B[?25h");
                    
                    Runtime.getRuntime().exec(cmd1).waitFor();
                    tcChoice = 0;
                }
                else
                if (r == (int)'s')
                {
                    Runtime.getRuntime().exec(cmd2).waitFor();
                    System.out.print(String.format("%c[%d;%df",0x1B,27,0));
                    System.out.print("\033[2K");
                    System.out.print("\r                > BACK");
                    
                    System.out.print(String.format("%c[%d;%df",0x1B,25,0));
                    System.out.print("\033[2K");
                    
                    System.out.print("\r                ");
                    if (tcChoice == 0)
                    {
                        System.out.print("• YES                  NO");
                    }
                    else
                    {
                        System.out.print("  YES                • NO");
                    }
                
                    tsHover = false;
                    tcHover = false;
                    backHover = true;
                    
            		Runtime.getRuntime().exec(cmd1).waitFor();
                }
            }
            else
            if (choice == 1 && tcHover)
            {
                int r = reader.read();
                if (r == (int)'a')
                {
                    Runtime.getRuntime().exec(cmd2).waitFor();
                    System.out.print(String.format("%c[%d;%df",0x1B,25,0));
                    System.out.print("\033[2K");
                    System.out.print("\r                > YES                ");
                    
                    if (tcChoice == 1)
                    {
                        System.out.print("• NO");
                    }
                    else
                    {
                        System.out.print("  NO");
                    }
                    
                    choice = 0;
            		Runtime.getRuntime().exec(cmd1).waitFor();
                }
                else 
                if (r == (int)'e')
                {
                    Runtime.getRuntime().exec(cmd2).waitFor();
                    System.out.print(String.format("%c[%d;%df",0x1B,25,0));
                    System.out.print("\033[2K");
                    System.out.print("\r                  YES                > NO");
                    System.out.print("\u001B[?25l");
                    
                    Runtime.getRuntime().exec(cmd1).waitFor();
                    tcChoice = 1;
                }
                else
                if (r == (int)'w')
                {
                    //System.out.print(String.format("\033[%dB", 3)); going down 3 lines %d is the parameter in format (3)
                    Runtime.getRuntime().exec(cmd2).waitFor();
                    System.out.print(String.format("%c[%d;%df",0x1B,22,0));
                    System.out.print("\033[2K");
                    
                    System.out.print("\r                ");
                    if (tsChoice == 0)
                    {
                        System.out.print("• FAST");
                    }
                    else
                    {
                        System.out.print("  FAST");
                    }
                    
                    System.out.print("                > SLOW");
                    
                    System.out.print(String.format("%c[%d;%df",0x1B,25,0));
                    System.out.print("\033[2K");
                    
                    System.out.print("\r                ");
                    if (tcChoice == 0)
                    {
                        System.out.print("• YES                  NO");
                    }
                    else
                    {
                        System.out.print("  YES                • NO");
                    }
                
                    tsHover = true;
                    tcHover = false;
                    
            		Runtime.getRuntime().exec(cmd1).waitFor();
                }
            }
            else
            if (choice == 0 && backHover)
            {
                int r = reader.read();
                if (r == (int)'w')
                {
                    Runtime.getRuntime().exec(cmd2).waitFor();
                    System.out.print(String.format("%c[%d;%df",0x1B,25,0));
                    System.out.print("\033[2K");
                    
                    System.out.print("\r                > YES                ");
                    if (tcChoice == 1)
                    {
                        System.out.print("• NO");
                    }
                    else
                    {
                        System.out.print("  NO");
                    }
                    
                    System.out.print(String.format("%c[%d;%df",0x1B,27,0));
                    System.out.print("\033[2K");
                    
                    System.out.print("\r                  BACK");
                
                    tcHover = true;
                    backHover = false;
                    
            		Runtime.getRuntime().exec(cmd1).waitFor();
                }
                else
                if (r == (int)'e')
                {
                    Runtime.getRuntime().exec(cmd2).waitFor();
                    textSpeed = tsChoice;
                    if (tcChoice == 0) showCursor = true;
                    if (tcChoice == 1) showCursor = false;
                    break;
                }
            }
        }
        
        mainMenu();
    }
    
    public static void printLogo()
    {
        System.out.println("                                  ,'\\");
        System.out.println("    _.----.        ____         ,'  _\\   ___    ___     ____");
        System.out.println("_,-'       `.     |    |  /`.   \\,-'    |   \\  /   |   |    \\  |`.");
        System.out.println("\\      __    \\    '-.  | /   `.  ___    |    \\/    |   '-.   \\ |  |");
        System.out.println(" \\.    \\ \\   |  __  |  |/    ,','_  `.  |          | __  |    \\|  |");
        System.out.println("   \\    \\/   /,' _`.|      ,' / / / /   |          ,' _`.|     |  |");
        System.out.println("    \\     ,-'/  /   \\    ,'   | \\/ / ,`.|         /  /   \\  |     |");
        System.out.println("     \\    \\ |   \\_/  |   `-.  \\    `'  /|  |    ||   \\_/  | |\\    |");
        System.out.println("      \\    \\ \\      /       `-.`.___,-' |  |\\  /| \\      /  | |   |");
        System.out.println("       \\    \\ `.__,'|  |`-._    `|      |__| \\/ |  `.__,'|  | |   |");
        System.out.println("        \\_.-'       |__|    `-._ |              '-.|     '-.| |   |");
        System.out.println("                                `'                            '-._|");
        
        System.out.println("                       _____  _____         ");
        System.out.println("                      / ____|/ ____|  /\\    ");
        System.out.println("                     | |    | (___   /  \\ ");
        System.out.println("                     | |     \\___ \\ / /\\ \\  ");
        System.out.println("                     | |____ ____) / ____ \\ ");
        System.out.println("                      \\_____|_____/_/    \\_\\");
    }
}

import java.util.*;
import java.lang.*;

public class MoveList
{
    private HashMap<String, Move> Movedex = new HashMap<String, Move>();
    
    public MoveList()
    {
        // this is an empty constructor (it only creates an empty hashmap, line: 6)
        // You must use the method "fillGen1" to fill up the hashmap called 
        // Movedex
    }
    
    
    //create a method that lets you add a move to MoveList if the parameters are all the parameters needed to make a move
    public void fillGen1()
    {
        //NORMAL 
        Move Barrage = new Move("Barrage", "Normal", "Physical", 15.0, 85.0, 20.0);
        Move Bide =  new Move("Bide", "Normal", "Physical", 1, 0, 10);
        Move Bind = new Move("Bind", "Normal", "Physical", 20, 15, 85);
        Move BodySlam = new Move("Body Slam", "Normal", "Physical", 15, 85, 100);
        Move CometPunch = new Move("Comet Punch", "Normal", "Physical", 15, 18, 85);
        Move Constrict =  new Move("Constrict", "Normal", "Physical", 35, 10, 100);
        Move Conversion = new Move("Conversion", "Normal", "Status", 30, 0, 0);
        Move DefenseCurl = new Move("Defense Curl", "Normal", "Status", 40, 0, 0);
        Move Disable = new Move("Disable", "Normal", "Status", 20, 0, 100);
        Move DizzyPunch =  new Move("Dizzy Punch", "Normal", "Physical", 10, 70, 100);
        Move DoubleSlap = new Move("Double Slap", "Normal", "Physical", 10, 15, 85);
        Move DoubleTeam = new Move("Double Team", "Normal", "Status", 15, 0, 0);
        Move DoubleEdge = new Move("Double Edge", "Normal", "Physical", 15, 120, 100);
        Move EggBomb =  new Move("Egg Bomb", "Normal", "Physical", 10, 100, 75);
        Move Explosion = new Move("Explosion", "Normal", "Physical", 5, 250, 100);
        Move Flash = new Move("Flash", "Normal", "Status", 20, 0, 100);
        Move FocusEnergy = new Move("Focus Energy", "Normal", "Status", 30, 0, 0);
        Move FuryAttack =  new Move("Fury Attack", "Normal", "Physical", 20, 15, 85);
        Move FurySwipes = new Move("Fury Swipes", "Normal", "Physical", 15, 18, 80);
        Move Glare = new Move("Glare", "Normal", "Status", 30, 0, 100);
        Move Growl =  new Move("Growl", "Normal", "Status", 40, 0, 100);
        Move Growth = new Move("Growth", "Normal", "Status", 20, 0, 0);
        Move Guillotine = new Move("Guillotine", "Normal", "Physical", 5, 1, 30);
        Move Harden = new Move("Harden", "Normal", "Status", 30, 0, 0);
        Move Headbutt =  new Move("Headbutt", "Normal", "Physical", 20, 15, 85);
        Move HornAttack = new Move("Horn Attack", "Normal", "Physical", 25, 65, 100);
        Move HornDrill = new Move("Horn Drill", "Normal", "Physical", 5, 1, 30);
        Move HyperBeam = new Move("Hyper Beam", "Normal", "Status", 5, 150, 90);
        Move HyperFang =  new Move("HyperFang", "Normal", "Status", 15, 80, 90);
        Move Leer = new Move("Leer", "Normal", "Status", 30, 0, 100);
        Move LovelyKiss = new Move("Lovely Kiss", "Normal", "Physical", 10, 0, 75);
        Move MegaKick = new Move("Mega Kick", "Normal", "Physical", 5, 120, 75);
        Move MegaPunch =  new Move("Mega Punch", "Normal", "Physical", 20, 80, 85);
        Move Metronome = new Move("Metronome", "Normal", "Status", 10, 0, 0);
        Move Mimic = new Move("Mimic", "Normal", "Status", 10, 0, 0);
        Move Minimize = new Move("Minimize", "Normal", "Status", 10, 0, 0);
        Move PayDay =  new Move("Pay Day", "Normal", "Physical", 20, 40, 100);
        Move Pound = new Move("Pound", "Normal", "Physical", 35, 40, 100);
        Move QuickAttack = new Move("Quick Attack", "Normal", "Physical", 30, 40, 100);
        Move Rage = new Move("Rage", "Normal", "Physical", 20, 20, 100);
        Move RazorWind =  new Move("Razor Wind", "Normal", "Special", 10, 80, 100);
        Move Recover = new Move("Recover", "Normal", "Status", 10, 0, 0);
        Move Roar =  new Move("Roar", "Normal", "Status", 20, 0, 0);
        Move Scratch = new Move("Scratch", "Normal", "Physical", 35, 40, 100);
        Move Screech = new Move("Screech", "Normal", "Status", 40, 0, 0);
        Move SelfDestruct = new Move("Self-Destruct", "Normal", "Physical", 5, 200, 100);
        Move Sharpen =  new Move("Sharpen", "Normal", "Status", 30, 0, 0);
        Move Sing = new Move("Sing", "Normal", "Status", 15, 0, 55);
        Move SkullBash =  new Move("SkullBash", "Normal", "Physical", 10, 130, 100);
        Move Slam = new Move("Slam", "Normal", "Physical", 20, 80, 75);
        Move Smokescreen = new Move("Smokescreen", "Normal", "Status", 20, 0, 0);
        Move SoftBoiled = new Move("Soft-Boiled", "Normal", "Status", 10, 0, 0);
        Move SpikeCannon =  new Move("Spike Cannon", "Normal", "Physical", 15, 20, 100);
        Move Splash = new Move("Splash", "Normal", "Status", 40, 0, 0);
        Move Strength =  new Move("Strength", "Normal", "Physical", 15, 80, 100);
        Move Struggle = new Move("Struggle", "Normal", "Physical", 0, 50, 0);
        Move Substitute = new Move("Substitute", "Normal", "Status", 10, 0, 0);
        Move SuperFang = new Move("Super Fang", "Normal", "Physical", 10, 1, 90);
        Move Supersonic=  new Move("Supersonic", "Normal", "Status", 20, 0, 55);
        Move Swift = new Move("Swift", "Normal", "Special", 20, 60, 0);
        Move SwordsDance =  new Move("Swords Dance", "Normal", "Status", 20, 0, 0);
        Move Tackle = new Move("Tackle", "Normal", "Physical", 35, 50, 100);
        Move TailWhip = new Move("Tail Whip", "Normal", "Status", 30, 0, 100);
        Move TakeDown = new Move("Take Down", "Normal", "Physical", 20, 90, 85);
        Move Thrash =  new Move("Thrash", "Normal", "Physical", 10, 120, 100);
        Move Transform = new Move("Transform", "Normal", "Status", 10, 0, 0);
        Move TriAttack =  new Move("Tri Attack", "Normal", "Special", 10, 80, 100);
        Move ViceGrip = new Move("Vice Grip", "Normal", "Physical", 30, 55, 100);
        Move Whirlwind = new Move("Whrilwind", "Normal", "Status", 20, 0, 0);
        Move Wrap = new Move("Wrap", "Normal", "Physical", 20, 15, 90);

        //FLYING
        Move DrillPeck = new Move("Drill Peck", "Flying", "Physical", 20, 80, 100);
        Move Fly = new Move("Fly", "Flying", "Physical", 15, 90, 95);
        Move Gust = new Move("Gust", "Flying", "Special", 35, 40, 100);
        Move MirrorMove = new Move("Mirror Move", "Flying", "Status", 20, 0, 0);
        Move Peck = new Move("Gust", "Flying", "Physical", 35, 35, 100);
        Move SkyAttack = new Move("Sky Attack", "Flying", "Physical", 5, 140, 90);
        Move WingAttack = new Move("Wing Attack", "Flying", "Physical", 35, 60, 100);
        
        
        //GROUND
        Move BoneClub = new Move("Bone Club", "Ground", "Physical", 20, 65, 85);
        Move Bonemerang = new Move ("Bonemerang", "Ground", "Physical", 10, 50, 90);
        Move Dig = new Move ("Dig", "Ground", "Physical", 10, 80, 100);
        Move Earthquake = new Move ("Earthquake", "Ground", "Physical", 10, 100, 100);
        Move Fissure = new Move ("Fissure", "Ground", "Physical", 5, 1, 30);
        Move SandAttack = new Move ("Sand Attack", "Ground", "Status", 15, 0, 100);
        
        //FIGHTING
        Move Counter = new Move("Counter", "Fighting", "Physical", 20, 1, 100);
        Move DoubleKick = new Move("Double Kick", "Fighting", "Physical", 30, 30, 100);
        Move HighJumpKick = new Move("High Jump Kick", "Fighting", "Physical", 10, 130, 90);
        Move JumpKick = new Move("Jump Kick", "Fighting", "Physical", 10, 100, 95);
        Move KarateChop = new Move("Karate Chop", "Fighting", "Physical", 25, 50, 100);
        Move LowKick = new Move("Low Kick", "Fighting", "Physical", 20, 1, 100);
        Move RollingKick = new Move("Rolling Kick", "Fighting", "Physical", 15, 60, 85);
        Move SeismicToss = new Move("Seismic Toss", "Fighting", "Physical", 20, 1, 100);
        Move Submission = new Move("Submission", "Fighting", "Physical", 25, 80, 80);
        
        //POISON
        Move Acid = new Move("Acid", "Poison", "Special", 30, 40, 100);
        Move AcidArmor = new Move("Acid Armor", "Poison", "Status", 20, 0, 0);
        Move PoisonGas = new Move("Poison Gas", "Poison", "Status", 40, 0, 90);
        Move PoisonPowder = new Move("Poison Powder", "Poison", "Status", 35, 0, 75);
        Move PoisonSting = new Move("Poison Sting", "Poison", "Physical", 35, 15, 100);
        Move Sludge = new Move("Sludge", "Poison", "Special", 20, 65, 100);
        Move Smog = new Move("Acid", "Poison", "Special", 20, 30, 70);
        Move Toxic = new Move("Acid", "Poison", "Status", 10.0, 0.0, 90.0);
        
        //ROCK
        Move RockSlide = new Move("Rock Slide", "Rock", "Physical", 10, 75, 90);
        Move RockThrow = new Move("Rock Throw", "Rock", "Physical", 15, 50, 90);
        
        
        //BUG
        Move LeechLife = new Move("Leech Life", "Bug", "Physical", 15, 20, 100);
        Move PinMissle = new Move("Pin Missle", "Bug", "Physical", 20, 25, 90);
        Move StringShot = new Move("String Shot", "Bug", "Status", 40, 0, 95);
        Move Twineedle = new Move("Twineedle", "Bug", "Physical", 20, 25, 100);
        
        //GHOST
        Move ConfuseRay = new Move("Confuse Ray", "Ghost", "Status", 10, 0, 100);
        Move Lick = new Move("Lick", "Ghost", "Physical", 30, 30, 100);
        Move NightShade = new Move("Night Shade", "Ghost", "Special", 15, 1, 100);
        
        //FIRE
        Move Ember = new Move("Ember", "Fire", "Special", 25, 40, 100);
        Move FireBlast = new Move("Fire Blast", "Fire", "Special", 5, 110, 85);
        Move FirePunch = new Move("Fire Punch", "Fire", "Physical", 15, 75, 100);
        Move FireSpin = new Move("Fire Spin", "Fire", "Special", 15, 35, 85);
        Move Flamethrower = new Move("Firethrower", "Fire", "Special", 15, 90, 100);
        
        //WATER
        Move Bubble = new Move("Bubble", "Water", "Special", 30, 40, 100);
        Move BubbleBeam = new Move("Bubble Beam", "Water", "Special", 20, 65, 100);
        Move Clamp = new Move("Clamp", "Water", "Physical", 15, 35, 85);
        Move Crabhammer = new Move("Crabhammer", "Water", "Physical", 10, 100, 90);
        Move HydroPump = new Move("Hydro Pump", "Water", "Special", 5, 110, 80);
        Move Surf = new Move("Surf", "Water", "Special", 15, 90, 100);
        Move WaterGun = new Move("Water Gun", "Water", "Special", 25, 40, 100);
        Move Waterfall = new Move("Waterfall", "Water", "Physical", 15, 80, 100);
        Move Withdraw = new Move("Withdraw", "Water", "Status", 40, 0, 0);
        
        //GRASS
        Move Absorb = new Move("Absorb", "Grass", "Special", 25, 20, 100);
        Move LeechSeed = new Move("Leech Seed", "Grass", "Status", 10, 0, 90);
        Move MegaDrain = new Move("Mega Drain", "Grass", "Special", 15, 40, 100);
        Move PetalDance = new Move("Petal Dance", "Grass", "Special", 10, 120, 100);
        Move RazorLeaf = new Move("Razor Leaf", "Grass", "Physical", 25, 55, 95);
        Move SleepPowder = new Move("Sleep Powder", "Grass", "Status", 15, 0, 75);
        Move SolarBeam = new Move("Solar Beam", "Grass", "Special", 10, 120, 100);
        Move Spore = new Move("Spore", "Grass", "Status", 15, 0, 100);
        Move StunSpore = new Move("Stun Spore", "Grass", "Status", 30, 0, 75);
        Move VineWhip = new Move("Vine Whip", "Grass", "Physical", 25, 45, 100);
        
        //ELECTRIC
        Move Thunder = new Move("Thunder", "Electric", "Special", 10, 110, 70);
        Move ThunderPunch = new Move("Thunder Punch", "Electric", "Physical", 15, 75, 100);
        Move ThunderShock = new Move("Thunder Shock", "Electric", "Special", 30, 40, 100);
        Move ThunderWave = new Move("Thunder Wave", "Electric", "Status", 20, 0, 100);
        Move Thunderbolt = new Move("Thunderbolt", "Electric", "Special", 15, 90, 100);
        
        //PSYCHIC
        Move Agility = new Move("Agility", "Psychic", "Status", 30, 0, 0);
        Move Amnesia = new Move("Amnesia", "Psychic", "Status", 20, 0, 0);
        Move Barrier = new Move("Barrier", "Psychic", "Status", 20, 0, 0);
        Move Confusion = new Move("Confusion", "Psychic", "Special", 25, 50, 100);
        Move DreamEater = new Move("Dream Eater", "Psychic", "Special", 15, 100, 100);
        Move Hypnosis = new Move("Hypnosis", "Psychic", "Status", 20, 0, 60);
        Move Kinesis = new Move("Kinesis", "Psychic", "Status", 15, 0, 80);
        Move LightScreen = new Move("Light Screen", "Psychic", "Status", 30, 0, 0);
        Move Meditate = new Move("Meditate", "Psychic", "Status", 40, 0, 0);
        Move Psybeam = new Move("Psybeam", "Psychic", "Special", 20, 65, 100);
        Move Psychic = new Move("Psychic", "Psychic", "Special", 10, 90, 100);
        Move Psywave = new Move("Psywave", "Psychic", "Special", 15, 1, 100);
        Move Reflect = new Move("Reflect", "Psychic", "Status", 20, 0, 0);
        Move Rest = new Move("Rest", "Psychic", "Status", 10, 0, 0);
        Move Teleport = new Move("Teleport", "Psychic", "Status", 20, 0, 0);
        
        //ICE
        Move AuroraBeam = new Move("Aurora Beam", "Ice", "Special", 20, 65, 100);
        Move Blizzard = new Move("Blizzard", "Ice", "Special", 5, 110, 70);
        Move Haze = new Move("Haze", "Ice", "Status", 30, 0, 0);
        Move IceBeam = new Move("Ice Beam", "Ice", "Special", 10, 90, 100);
        Move IcePunch = new Move("Ice Punch", "Ice", "Physical", 15, 75, 100);
        Move Mist = new Move("Mist", "Ice", "Status", 30, 0 ,0);
        
        //DRAGON
        Move DragonRage = new Move("Dragon Rage", "Dragon", "Special", 10, 1, 100);
        
        //DARK
        Move Bite = new Move("Bite", "Dark", "Physical", 25, 60, 100);
        
        
        
        //ALL MOVES ARE NOW BEING ADDED TO THE HASHMAP
        
        //NORMAL .put
        Movedex.put("Barrage", Barrage);
        Movedex.put("Bide", Bide);
        Movedex.put("Bind", Bind);
        Movedex.put("Bode Slam", BodySlam);
        Movedex.put("Comet Punch", CometPunch);
        Movedex.put("Constrict", Constrict);
        Movedex.put("Conversion", Conversion);
        Movedex.put("Defense Curl", DefenseCurl);
        Movedex.put("Disable", Disable);
        Movedex.put("Dizzy Punch", DizzyPunch);
        Movedex.put("Double Slap", DoubleSlap);
        Movedex.put("Double Team", DoubleTeam);
        Movedex.put("Double Edge", DoubleEdge);
        Movedex.put("Egg Bomb", EggBomb);
        Movedex.put("Explosion", Explosion);
        Movedex.put("Flash", Flash);
        Movedex.put("Focus Energy", FocusEnergy);
        Movedex.put("Fury Attack", FuryAttack);
        Movedex.put("Fury Swipes", FurySwipes);
        Movedex.put("Glare", Glare);
        Movedex.put("Growl", Growl);
        Movedex.put("Guillotine", Guillotine);
        Movedex.put("Harden", Harden);
        Movedex.put("Headbutt", Headbutt);
        Movedex.put("Horn Attack", HornAttack);
        Movedex.put("Horn Drill", HornDrill);
        Movedex.put("Hyper Beam", HyperBeam);
        Movedex.put("Hyper Fang", HyperFang);
        Movedex.put("Leer", Leer);
        Movedex.put("Lovely Kiss", LovelyKiss);
        Movedex.put("Mega Kick", MegaKick);
        Movedex.put("Mega Punch", MegaPunch);
        Movedex.put("Metronome", Metronome);
        Movedex.put("Mimic", Mimic);
        Movedex.put("Minimize", Minimize);
        Movedex.put("Pay Day", PayDay);
        Movedex.put("Pound", Pound);
        Movedex.put("Quick Attack", QuickAttack);
        Movedex.put("Rage", Rage);
        Movedex.put("Razor Wind", RazorWind);
        Movedex.put("Recover", Recover);
        Movedex.put("Roar", Roar);
        Movedex.put("Scratch", Scratch);
        Movedex.put("Screech", Screech);
        Movedex.put("Self-Destruct", SelfDestruct);
        Movedex.put("Sharpen", Sharpen);
        Movedex.put("Sing", Sing);
        Movedex.put("Skull Bash", SkullBash);
        Movedex.put("Slam", Slam);
        Movedex.put("Smokescreen", Smokescreen);
        Movedex.put("Soft-Boiled", SoftBoiled);
        Movedex.put("Spike Cannon", SpikeCannon);
        Movedex.put("Splash", Splash);
        Movedex.put("Strength", Strength);
        Movedex.put("Struggle", Struggle);
        Movedex.put("Substitute", Substitute);
        Movedex.put("Super Fang", SuperFang);
        Movedex.put("Supersonic", Supersonic);
        Movedex.put("Swift", Swift);
        Movedex.put("Swords Dance", SwordsDance);
        Movedex.put("Tackle", Tackle);
        Movedex.put("Tail Whip", TailWhip);
        Movedex.put("Take Down", TakeDown);
        Movedex.put("Thrash", Thrash);
        Movedex.put("Transform", Transform);
        Movedex.put("Tri Attack", TriAttack);
        Movedex.put("Vice Grip", ViceGrip);
        Movedex.put("Whirlwind", Whirlwind);
        Movedex.put("Wrap", Wrap);
        
        //FLYING .put
        Movedex.put("Drill Peck", DrillPeck);
        Movedex.put("Fly", Fly);
        Movedex.put("Gust", Gust);
        Movedex.put("Mirror Move", MirrorMove);
        Movedex.put("Peck", Peck);
        Movedex.put("Sky Attack", SkyAttack);
        Movedex.put("Wing Attack", WingAttack);
       
        //GROUND .put
        Movedex.put("Bone Club", BoneClub);
        Movedex.put("Bonemerang", Bonemerang);
        Movedex.put("Dig", Dig);
        Movedex.put("Earthquake", Earthquake);
        Movedex.put("Fissure", Fissure);
        Movedex.put("Sand Attack", SandAttack);
        
        //FIGHTING .put
        Movedex.put("Counter", Counter);
        Movedex.put("Double Kick", DoubleKick);
        Movedex.put("High Jump Kick", HighJumpKick);
        Movedex.put("Jump Kick", JumpKick);
        Movedex.put("Karate Chop", KarateChop);
        Movedex.put("Low Kick", LowKick);
        Movedex.put("Rolling Kick", RollingKick);
        Movedex.put("Tail Whip", TailWhip);
        Movedex.put("Take Down", TakeDown);
        
        
        //POSION .put
        Movedex.put("Acid", Acid);
        Movedex.put("Poison Gas", PoisonGas);
        Movedex.put("Poison Powder", PoisonPowder);
        Movedex.put("Poison Sting", PoisonSting);
        Movedex.put("Sludge", Sludge);
        Movedex.put("Smog", Smog);
        Movedex.put("Toxic", Toxic);
        
        //ROCK .put
        Movedex.put("Rock Slide", RockSlide);
        Movedex.put("Rock Throw", RockThrow);
        
        //BUG PT.2
        Movedex.put("Leech Life", LeechLife);
        Movedex.put("Pin Missle", PinMissle);
        Movedex.put("String Shot", StringShot);
        Movedex.put("Twineedle", Twineedle);
        
        //GHOST PT.2
        Movedex.put("Confuse Ray", ConfuseRay);
        Movedex.put("Lick", Lick);
        Movedex.put("Night Shade", NightShade);
        
        //FIRE .put
        Movedex.put("Ember", Ember);
        Movedex.put("Fire Blast", FireBlast);
        Movedex.put("Fire Punch", FirePunch);
        Movedex.put("Fire Spin", FireSpin);
        Movedex.put("Flamethrower", Flamethrower);
        
        //WATER PT.2
        Movedex.put("Bubble", Bubble);
        Movedex.put("Bubble Beam", BubbleBeam);
        Movedex.put("Clamp", Clamp);
        Movedex.put("Crabhammer", Crabhammer);
        Movedex.put("Hydro Pump", HydroPump);
        Movedex.put("Surf", Surf);
        Movedex.put("Water Gun", WaterGun);
        Movedex.put("Waterfall", Waterfall);
        Movedex.put("Withdraw", Withdraw);
        
        //GRASS .put
        Movedex.put("Absorb", Absorb);
        Movedex.put("Leech Seed", LeechSeed);
        Movedex.put("Mega Drain", MegaDrain);
        Movedex.put("Petal Dance", PetalDance);
        Movedex.put("Razor Leaf", RazorLeaf);
        Movedex.put("Sleep Powder", SleepPowder);
        Movedex.put("Solar Beam", SolarBeam);
        Movedex.put("Spore", Spore);
        Movedex.put("Stun Spore", StunSpore);
        Movedex.put("VineWhip", VineWhip);
   
        //ELECTRIC PT.2
        Movedex.put("Thunder", Thunder);
        Movedex.put("Thunder Punch", ThunderPunch);
        Movedex.put("Thunder Shock", ThunderShock);
        Movedex.put("Thunder Wave", ThunderWave);
        Movedex.put("Thunderbolt", Thunderbolt);
        
        //PSYCHIC PT.2
        Movedex.put("Agility", Agility);
        Movedex.put("Amnesia", Amnesia);
        Movedex.put("Barrier", Barrier);
        Movedex.put("Confusion", Confusion);
        Movedex.put("Dream Eater", DreamEater);
        Movedex.put("Hypnosis", Hypnosis);
        Movedex.put("Kinesis", Kinesis);
        Movedex.put("Light Screen", LightScreen);
        Movedex.put("Meditate", Meditate);
        Movedex.put("Psybeam", Psybeam);
        Movedex.put("Psychic", Psychic);
        Movedex.put("Psywave", Psywave);
        Movedex.put("Reflect", Reflect);
        Movedex.put("Rest", Rest);
        Movedex.put("Teleport", Teleport);
   
        //ICE .put
        Movedex.put("Aurora Beam", AuroraBeam);
        Movedex.put("Blizzard", Blizzard);
        Movedex.put("Haze", Haze);
        Movedex.put("Ice Beam", IceBeam);
        Movedex.put("Ice Punch", IcePunch);
        Movedex.put("Mist", Mist);
        
        //DRAGON .put
        Movedex.put("Dragon Rage", DragonRage);
        
        //DARK .put
        Movedex.put("Bite", Bite);
    }
    
    
    
    public void addMove(String name, String type, String category, double pp, double power, double accuracy)
    {
        Move newMove = new Move(name, type, category, pp, power, accuracy);
        Movedex.put(name, newMove);
    }
    
    //create a method that lets you add a move to Movedex if the parameter is of type move
   public void addMove(Move blah)
    {
        Movedex.put(blah.getName(), blah);
    }


   public Move getMove(String move)
   {
       return Movedex.get(move);
   }
  
  
  //create one getter method that returns a move from Movedex

}

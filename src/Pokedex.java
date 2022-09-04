import java.util.*;
import java.lang.*;

public class Pokedex
{
    
    private HashMap<String, Pokemon> Pokedex = new HashMap<String, Pokemon>();

    public Pokedex()
    {
        // this is an empty constructor (it only creates an empty hashmap, line: 7)
        // You must use the method "fillGen1" to fill up the hashmap called 
        // pokedex
    }
    
//order is name,nickname,type,type2(incase of only having one type repeat the first type),hp,atk,def,spatk,spdef,spd
    public void createPokedex()
    {   
        Pokemon Bulbasaur = new Pokemon("Bulbasaur", "Bulbasaur", "Poison", "Grass", 45, 49, 49, 65, 65, 45);
        Pokedex.put("Bulbasaur", Bulbasaur);

        Pokemon Ivysaur = new Pokemon("Ivysaur", "Ivysaur", "Poison", "Grass", 60, 62, 63, 80, 80, 60);
        Pokedex.put("Ivysaur", Ivysaur);

        Pokemon Venasaur = new Pokemon("Venasaur", "Venasaur", "Poison", "Grass", 80, 82, 83, 100, 100, 80);
        Pokedex.put("Venasaur", Venasaur );
        
        Pokemon Charmander = new Pokemon("Charmander", "Charmander", "Fire", "Fire",  39, 52, 43, 60, 50, 65);
        Pokedex.put("Charmander", Charmander);
        
        Pokemon Charmeleon = new Pokemon("Charmeleon", "Charmeleon", "Fire", "Fire", 58, 64, 58, 80, 65, 80);
        Pokedex.put("Charmeleon", Charmeleon );
        
        Pokemon Charizard = new Pokemon("Charizard", "Charizard", "Fire", "Flying", 78, 130, 111, 130, 85, 100);
        Pokedex.put("Charizard", Charizard );
        
        Pokemon Squirtle = new Pokemon("Squirtle", "Squirtle", "Water", "Water", 44, 48, 65, 50, 64, 43);
        Pokedex.put("Squirtle", Squirtle );
        
        Pokemon Wartortle = new Pokemon("Wartortle", "Wartortle", "Water", "Water", 59, 63, 80, 65, 80, 58);
        Pokedex.put("Wartortle", Wartortle);
        
        Pokemon Blastoise = new Pokemon("Blastoise", "Blastoise", "Water", "Water", 79, 83, 100, 85, 105,78);
        Pokedex.put("Blastoise", Blastoise);
        
        Pokemon Caterpie = new Pokemon("Caterpie", "Caterpie", "Bug", "Bug", 45, 35, 35, 20, 20, 45);
        Pokedex.put("Caterpie", Caterpie);
        
        Pokemon Metapod = new Pokemon("Metapod", "Metapod", "Bug", "Bug", 50, 20, 55, 25, 25, 30);
        Pokedex.put("Metapod", Metapod);
        
        Pokemon Butterfree = new Pokemon("Butterfree", "Butterfree", "Bug", "Flying", 60, 45, 50, 90, 80, 70);
        Pokedex.put("Butterfree", Butterfree);
        
        Pokemon Weedle = new Pokemon("Weedle", "Weedle", "Bug","Poison", 45, 35, 30, 20, 10, 50);
        Pokedex.put("Weedle", Weedle);
        
        Pokemon Kakuna = new Pokemon("Kakuna", "Kakuna", "Bug", "Poison", 45, 25, 50, 25, 25, 35);
        Pokedex.put("Weedle", Weedle);
        
        Pokemon Beedrill = new Pokemon("Beedrill", "Beedrill", "Bug", "Poison", 65, 90, 40, 45, 80, 75);
        Pokedex.put("Beedrill", Beedrill);
        
        Pokemon Pidey = new Pokemon("Pidgey", "Pidgey", "Normal", "Flying", 40, 45, 40, 35, 35, 56);
        Pokedex.put("Pidey", Pidey);
        
        Pokemon Pidgeotto = new Pokemon("Pidgeotto", "Pidgeotto", "Normal", "Flying", 63, 60, 55, 50, 50, 71);
        Pokedex.put("Pidgeotto", Pidgeotto);
        
        Pokemon Pidgeot = new Pokemon("Pidgeot", "Pidgeot", "Normal", "Flying", 83, 80, 75, 70, 70, 101);
        Pokedex.put("Pidgeot", Pidgeot);
        
        Pokemon Rattata = new Pokemon("Rattata", "Rattata", "Normal", "Normal", 30, 56, 35, 25, 35, 72);
        Pokedex.put("Rattata", Rattata);
        
        Pokemon Raticate = new Pokemon("Raticate","Raticate", "Normal", "Normal", 55, 81, 60, 50, 70, 97);
        Pokedex.put("Raticate", Raticate);
        
        Pokemon Spearow = new Pokemon("Spearow", "Spearow", "Normal", "Flying", 40, 60, 30, 31, 31, 70);
        Pokedex.put("Spearow", Spearow);
        
        Pokemon Fearow = new Pokemon("Fearow", "Spearow", "Normal", "Normal" , 65, 90, 65, 61, 61, 100);
        Pokedex.put("Fearow", Fearow);
        
        Pokemon Ekans = new Pokemon("Ekans", "Ekans", "Poison", "Poison", 35, 60, 44, 40, 54, 55);
        Pokedex.put("Ekans", Ekans);
        
        Pokemon Arbok = new Pokemon("Arbok", "Arbok", "Poison", "Poison", 60, 95, 69, 65, 79, 80);
        Pokedex.put("Arbok", Arbok);
        
        Pokemon Pikachu = new Pokemon("Pikachu", "Pikachu", "Electric", "Electric", 35, 55, 40, 50, 50, 90);
        Pokedex.put("Pikachu", Pikachu);
        
        Pokemon Raichu = new Pokemon("Raichu", "Raichu", "Electric", "Electric", 60, 90, 55, 90, 80, 110);
        Pokedex.put("Raichu", Raichu);
        
        Pokemon Sandshrew= new Pokemon("Sandshrew", "Sandshrew", "Ground", "Ground", 50, 75, 85, 20, 30, 40);
        Pokedex.put("Sandshrew", Sandshrew);
        
        Pokemon Sandslash = new Pokemon("Sandslash", "Sandslash", "Ground", "Ground", 75, 100, 110, 45, 55, 65);
        Pokedex.put("Sandslash", Sandslash);
        
        Pokemon NidoranF = new Pokemon("NidoranF", "NidoranF", "Poison", "Poison", 55, 47, 52, 40, 40, 41 );
        Pokedex.put("NidoranF", NidoranF);
        
        Pokemon Nidorina = new Pokemon("Nidorina", "Nidorina", "Poison", "Poison", 70, 62, 67, 55, 55, 56);
        Pokedex.put("Nidorina", Nidorina);
        
        Pokemon Nidoqueen = new Pokemon("Nidoqueen", "Nidoqueen", "Poison", "Ground", 90, 92, 87, 75, 85, 76);
        Pokedex.put("Nidoqueen", Nidoqueen);
        
        Pokemon NidoranM = new Pokemon("NidoranM", "NidoranM", "Poison", "Poison", 46, 57, 40, 40, 40, 50);
        Pokedex.put("NidoranM", NidoranM);
        
        Pokemon Nidorino = new Pokemon("Nidorino", "Nidorino", "Poison", "Poison", 61, 72, 57, 55, 55, 65);
         Pokedex.put("Nidorino", Nidorino);
         
        Pokemon Nidoking = new Pokemon("Nidoking", "Nidoking", "Poison", "Ground", 81, 102, 77, 85, 75, 85);
         Pokedex.put("Nidoking", Nidoking);
        
        Pokemon Clefairy = new Pokemon("Clefairy", "Clefairy", "Normal", "Normal", 70, 45, 48, 60, 65, 35);
         Pokedex.put("Clefairy", Clefairy);
        
        Pokemon Clefable = new Pokemon("Clefable", "Clefable", "Normal", "Normal", 95, 70, 73, 95, 90, 60);
         Pokedex.put("Clefable", Clefable);
        
        Pokemon Vulpix = new Pokemon("Vulpix", "Vulpix", "Fire", "Fire", 38, 41, 40, 50, 65, 65);
         Pokedex.put("Vulpix", Vulpix);
        
        Pokemon Ninetales = new Pokemon("Nintales", "Nintales", "Fire", "Fire", 73, 76, 75, 81, 100, 100);
         Pokedex.put("Ninetales", Ninetales);
        
        Pokemon Jigglypuff = new Pokemon("Jigglypuff", "Jigglypuff", "Normal", "Normal", 115, 45, 20, 45, 25, 20);
         Pokedex.put("Jigglypuff", Jigglypuff);
        
        Pokemon Wigglytuff = new Pokemon("Wigglytuff", "Wigglytuff", "Normal", "Normal", 140, 70, 45, 85, 50, 45);
         Pokedex.put("Wigglytuff", Wigglytuff);
         
        Pokemon Zubat = new Pokemon("Zubat", "Zubat", "Poison", "Flying", 40, 45, 35, 30, 40, 55);
         Pokedex.put("Zubat", Zubat);
         
        Pokemon Golbat = new Pokemon("Golbat", "Golbat", "Poison", "Flying", 75, 80, 70, 65, 75, 90);
         Pokedex.put("Golbat", Golbat);
         
        Pokemon Oddish = new Pokemon("Oddish", "Oddish", "Grass", "Posion", 45, 50, 55, 75, 65, 30);
         Pokedex.put("Oddish", Oddish);
         
        Pokemon Gloom = new Pokemon("Gloom", "Gloom", "Grass", "Poison", 60, 65, 70, 85, 75, 40);
        Pokedex.put("Gloom", Gloom);
        
        Pokemon Vileplume = new Pokemon("Vilplume", "Vilplume", "Grass", "Poison",75, 80, 85, 110, 90, 50);
        Pokedex.put("Vileplume", Vileplume);
        
        Pokemon Paras = new Pokemon("Paras", "Paras", "Bug", "Grass", 35, 70, 55, 45, 55, 25);
        Pokedex.put("Paras", Paras);
        
        Pokemon Parasect = new Pokemon("Parasect", "Parasect", "Bug", "Grass", 60, 95, 80, 60, 80, 30);
        Pokedex.put("Parasect", Parasect);
        
        Pokemon Venonat = new Pokemon("Venonat", "Venonat", "Bug", "Poison", 60, 55, 50, 40, 55, 45);
        Pokedex.put("Venonat", Venonat);
        
        Pokemon Venomoth = new Pokemon("Venomoth", "Venomoth", "Bug", "Poison", 70, 65, 60, 90, 75, 90);
        Pokedex.put("Venomoth", Venomoth);
        
        Pokemon Diglett = new Pokemon("Diglett", "Dilett", "Ground", "Ground", 10, 55, 25, 35, 45, 95);
        Pokedex.put("Diglett", Diglett);
        
        Pokemon Dugtrio = new Pokemon("Dugtrio", "Dugtrio", "Ground", "Ground", 35, 80, 50, 50, 70, 120);
        Pokedex.put("Dugtrio", Dugtrio);
        
        Pokemon Meowth = new Pokemon("Meowth", "Meowth", "Normal", "Normal", 40, 45, 35, 40, 40, 90);
        Pokedex.put("Meowth", Meowth);
        
        Pokemon Persian = new Pokemon("Persian", "Persian", "Normal", "Normal", 65, 70, 60, 65, 65, 115);
        Pokedex.put("Persian", Persian);
        
        Pokemon Psyduck = new Pokemon("Psyduck", "Psyduck", "Water", "Water", 50, 52, 48, 65, 50, 55);
        Pokedex.put("Psyduck", Psyduck);
        
        Pokemon Golduck = new Pokemon("Golduck", "Golduck", "Water", "Water", 80, 82, 78, 95, 80, 85);
        Pokedex.put("Golduck", Golduck);
        
        Pokemon Mankey = new Pokemon("Mankey","Mankey", "Fighting", "Fighting", 40, 80, 35, 35, 45, 70);
        Pokedex.put("Mankey", Mankey);
        
        Pokemon Primeape = new Pokemon("Primeape", "Primeape", "Fighting", "Fighting", 65, 105, 60, 60, 70, 95);
        Pokedex.put("Primeape", Primeape);
        
        Pokemon Growlithe = new Pokemon("Growlithe", "Growlithe", "Fire", "Fire", 55, 70, 45, 70, 50, 60);
        Pokedex.put("Growlithe", Growlithe);
        
        Pokemon Arcanine = new Pokemon("Arcanine", "Arcanine", "Fire", "Fire", 90, 110, 80, 100, 80, 95);
        Pokedex.put("Arcanine", Arcanine);
        
        Pokemon Poliwag = new Pokemon("Poliwag", "Poliwag", "Water", "Water", 40, 50, 40, 40, 40, 90);
        Pokedex.put("Poliwag", Poliwag);
        
        Pokemon Poliwhirl  = new Pokemon("Poliwhirl", "Poliwhirl", "Water", "Water", 65, 65, 65, 50, 50, 90);
        Pokedex.put("Poliwhirl", Poliwhirl);
        
        Pokemon Poliwrath = new Pokemon("Poliwrath", "Poliwrath", "Water", "Fighting", 90, 95, 95, 70, 90, 70);
        Pokedex.put("Poliwrath", Poliwrath);
        
        Pokemon Abra = new Pokemon("Abra", "Abra", "Psychic", "Psychic", 25, 20, 15, 105, 55, 90);
        Pokedex.put("Abra", Abra);
        
        Pokemon Kadabra = new Pokemon("Kadabra", "Kadabra", "Psychic", "Psychic", 40, 35, 30, 120, 70, 105);
        Pokedex.put("Kadabra", Kadabra);
        
        Pokemon Alakazam  = new Pokemon("Alakazam", "Alakazam", "Psychic", "Psychic", 55, 50, 45, 135, 95, 120);
        Pokedex.put("Alakazam", Alakazam);
        
        Pokemon Machop = new Pokemon("Machop", "Machop", "Fighting", "Fighting", 70, 80, 50, 35, 35, 35);
        Pokedex.put("Machop", Machop);
        
        Pokemon Machoke = new Pokemon("Machoke","Machoke", "Fighting", "Fighting", 80, 100, 70, 50, 60, 45);
        Pokedex.put("Machoke", Machoke);
        
        Pokemon Machamp = new Pokemon("Machamp", "Machoke","Fighting","Fighting", 90, 130, 80, 65, 85, 55);
        Pokedex.put("Machamp", Machamp);
        
        Pokemon Bellsprout = new Pokemon("Bellsprout", "Bellsprout", "Grass", "Poison", 50, 75, 35, 70, 30, 40);
        Pokedex.put("Bellsprout", Bellsprout);
        
        Pokemon Weepinbell = new Pokemon("Weepinbell", "Weepinbell", "Grass", "Poison", 65, 90, 50, 85, 45, 55);
        Pokedex.put("Weepinbell", Weepinbell);
        
        Pokemon Victreebell = new Pokemon("Victrebell", "Victreebell", "Poison", "Grass", 80, 105, 65, 100, 70, 70);
        Pokedex.put("Victreebell", Victreebell);
        
        Pokemon Tentacool = new Pokemon("Tentacool", "Tentacool", "Poison", "Water", 40, 40, 35, 50, 100, 70);
        Pokedex.put("Tentacool", Tentacool);
        
        Pokemon Tentacruel = new Pokemon("Tentacruel", "Tentacruel", "Poison", "Water", 80, 70, 65, 80, 120, 100);
        Pokedex.put("Tentacruel", Tentacruel);
        
        Pokemon Geodude = new Pokemon("Geodude", "Geodude", "Rock", "Ground", 40, 80, 100, 30, 30, 20);
        Pokedex.put("Geodude", Geodude);
        
        Pokemon Graveler = new Pokemon("Graveler", "Graveler", "Rock", "Ground", 55, 95, 115, 45, 45, 35);
        Pokedex.put("Graveler", Graveler);
        
        Pokemon Golem = new Pokemon("Golem", "Golem", "Rock", "Ground", 80, 120, 130, 55, 65, 45);
        Pokedex.put("Golem", Golem);
        
        Pokemon Ponyta = new Pokemon("Ponyta", "Ponyta", "Fire", "Fire", 50, 85, 55, 65, 65, 90);
        Pokedex.put("Ponyta", Ponyta);
        
        Pokemon Rapidash = new Pokemon("Rapidash", "Rapidash", "Fire", "Fire", 65, 100, 70, 80, 80, 105);
        Pokedex.put("Rapidash", Rapidash);
        
        Pokemon Slowpoke = new Pokemon("Slowpoke", "Slowpoke", "Water", "Psychic", 90, 65, 65, 40, 40, 15);
        Pokedex.put("Slowpoke", Slowpoke);
        
        Pokemon Slowbro = new Pokemon("Slowbro", "Slowbro", "Water", "Psychic", 95, 75, 110, 100, 80, 30);
        Pokedex.put("Slowbro", Slowbro);
        
        Pokemon Magnemite = new Pokemon("Magnemite", "Magnemite", "Electric", "Electric", 25, 35, 70, 95, 55, 45);
        Pokedex.put("Magnemite", Magnemite);
        
        Pokemon Magneton = new Pokemon("Magneton", "Magneton", "ELectric", "Electric", 50, 60, 95, 120, 70,70);
        Pokedex.put("Magneton", Magneton);
        
        Pokemon Farfetchd = new Pokemon("Farfetch\'d", "Farfetch\'d", "Normal", "Flying", 52, 90, 55, 58, 62, 60);
        Pokedex.put("Farfetch\'d", Farfetchd);
        
        Pokemon Doduo = new Pokemon("Doduo", "Doduo", "Normal", "Flying", 35, 85, 45 , 35, 35, 75);
        Pokedex.put("Doduo", Doduo);
        
        Pokemon Dodrio = new Pokemon("Dodrio", "Dodrio", "Normal", "Flying", 60, 110, 70, 60, 60, 110);
        Pokedex.put("Dodrio", Dodrio);
        
        Pokemon Seel = new Pokemon("Seel", "Seel", "Water", "Water", 65, 45, 55, 45, 70, 45);
        Pokedex.put("Seel", Seel);
        
        Pokemon Dewgong = new Pokemon("Dewgong", "Dewgong", "Water", "Ice", 90, 70, 80, 70, 95, 70);
        Pokedex.put("Dewgong", Dewgong);
        
        Pokemon Grimer = new Pokemon("Grimer", "Grimer", "Poison", "Poison", 80, 80, 50, 40, 50, 25);
        Pokedex.put("Grimer", Grimer);
        
        Pokemon Muk = new Pokemon("Muk", "Muk", "Poison", "Poison", 105, 105, 75, 65, 100, 50);
        Pokedex.put("Muk", Muk);
        
        Pokemon Shellder = new Pokemon("Shellder", "Shellder", "Water", "Water", 30, 65, 100, 45, 25, 40);
        Pokedex.put("Shellder", Shellder);
        
        //daniel
        Pokemon Cloyster = new Pokemon("Cloyster", "Cloyster", "Water", "Ice", 50, 95, 180, 85, 45, 70);
        Pokedex.put("Cloyster", Cloyster);
        
        Pokemon Gastly = new Pokemon("Gastly", "Gastly", "Ghost", "Poison", 30, 35, 30, 100, 35, 80);
        Pokedex.put("Gastly", Gastly);
        
        Pokemon Haunter = new Pokemon("Haunter", "Haunter", "Ghost", "Poison", 45, 50, 45, 115, 55, 95);
        Pokedex.put("Haunter", Haunter);
        
        Pokemon Gengar = new Pokemon("Gengar", "Gengar", "Ghost", "Poison", 60, 65, 60, 130, 75, 110);
        Pokedex.put("Gengar", Gengar);
        
        Pokemon Onix = new Pokemon("Onix", "Onix", "Rock", "Ground", 35, 45, 160, 30, 465, 70);
        Pokedex.put("Onix", Onix);
        
        Pokemon Drowzee = new Pokemon("Drowzee", "Drowzee", "Psychic", "Psychic", 60, 48, 45, 43, 90, 42);
        Pokedex.put("Drowzee", Drowzee);
        
        Pokemon Hypno = new Pokemon("Hypno", "Hypno", "Psychic", "Psychic", 85, 73, 70, 73, 115, 67);
        Pokedex.put("Hypno", Hypno);
        
        Pokemon Krabby = new Pokemon("Krabby", "Krabby", "Water", "Water", 30, 105, 90, 25, 25, 50);
        Pokedex.put("Krabby", Krabby);
        
        Pokemon Kingler = new Pokemon("Kingler", "Kingler", "Water", "Water", 55, 130, 115, 50, 50, 75);
        Pokedex.put("Kingler", Kingler);
        
        Pokemon Voltorb = new Pokemon("Voltorb", "Voltorb", "Electric", "Electric", 60, 50, 70, 80, 80, 150);
        Pokedex.put("Voltorb", Voltorb);

        Pokemon Electrode = new Pokemon("Electrode", "Electrode", "Electric", "Electric", 60, 50, 70, 80, 80, 140);
        Pokedex.put("Electrode", Electrode);
        
        Pokemon Exeggcute = new Pokemon("Exeggcute", "Exeggcute", "Psychic", "Grass", 60, 40, 80, 60, 45, 40);
        Pokedex.put("Exeggcute", Exeggcute);
        
        Pokemon Exeggutor = new Pokemon("Exeggutor", "Exxegutor", "Psychic", "Grass", 95, 95, 85, 125, 65, 55);
        Pokedex.put("Exeggutor", Exeggutor);
        
        Pokemon Cubone = new Pokemon("Cubone", "Cubone", "Ground", "Ground", 50, 50, 95, 40, 50, 35);
        Pokedex.put("Cubone", Cubone);
        
        Pokemon Marowak = new Pokemon("Marowak", "Marowak", "Ground", "Ground" ,60, 80, 110, 50, 80, 45);
        Pokedex.put("Marowak", Marowak);
        
        Pokemon Hitmonlee = new Pokemon("Hitmonlee", "Hitmonlee", "Fighting", "Fighting", 50, 120, 53, 35, 110, 87);
        Pokedex.put("Hitmonlee", Hitmonlee);
        
        Pokemon Hitmonchan = new Pokemon("Hitmonchan", "Hitmonchan", "Fighting", "Fighting", 50, 105, 79, 35, 110, 76);
        Pokedex.put("Hitmonchan", Hitmonchan);
        
        Pokemon Lickitung = new Pokemon("Lickitung", "Lickitung", "Normal", "Normal", 90, 55, 75, 60, 75, 30);
        Pokedex.put("Lickitung", Lickitung);
        
        Pokemon Koffing = new Pokemon("Koffing", "Koffing", "Poison", "Posion", 40, 65, 95, 60, 45, 35);
        Pokedex.put("Koffing", Koffing);
        
        Pokemon Weezing = new Pokemon("Weezing", "Weezing", "Poison", "Poison", 65, 90, 120, 85, 70, 60);
        Pokedex.put("Weezing", Weezing);
        
        Pokemon Rhyhorn = new Pokemon("Rhyhorn", "Rhyhorn", "Ground", "Rock", 80, 85, 95, 30, 30, 25);
        Pokedex.put("Rhyhorn", Rhyhorn);
        
        Pokemon Rhydon = new Pokemon("Rhydon", "Rhydon", "Ground", "Rock", 105, 130, 120, 45, 45, 40);
        Pokedex.put("Rhydon", Rhydon);
        
        Pokemon Chansey = new Pokemon("Chansey", "Chansey", "Normal", "Normal", 250, 5, 5, 35, 105, 50);
        Pokedex.put("Chansey", Chansey);
        
        Pokemon Tangela = new Pokemon("Tangela", "Tangela", "Grass", "Grass", 65, 55, 115, 100, 40, 60);
        Pokedex.put("Tangela", Tangela);
        
        Pokemon Kangaskhan = new Pokemon("Kangaskan", "Kangaskhan", "Normal", "Normal", 105, 95, 80, 40, 80, 90);
        Pokedex.put("Kangaskhan", Kangaskhan);
        
        Pokemon Horsea = new Pokemon("Horsea", "Horsea", "Water", "Water", 30, 40, 70, 70, 25, 60);
        Pokedex.put("Horsea", Horsea);
        
        Pokemon Seadra = new Pokemon("Seadra", "Seadra", "Water", "Water", 60, 50, 70, 80, 80, 140);
        Pokedex.put("Seadra", Seadra);
        
        Pokemon Goldeen = new Pokemon("Goldeen", "Goldeen", "Water", "Water", 60, 50, 70, 80, 80, 140);
        Pokedex.put("Goldeen", Goldeen);
        
        Pokemon Seaking = new Pokemon("Seaking", "Seaking", "Water", "Water", 60, 50, 70, 80, 80, 140);
        Pokedex.put("Seaking", Seaking);
        
        Pokemon Staryu = new Pokemon("Staryu", "Staryu", "Water", "Water", 60, 50, 70, 80, 80, 140);
        Pokedex.put("Staryu", Staryu);
        //daniel
        
        Pokemon Starmie = new Pokemon("Starmie", "Starmie", "Water", "Psychic", 60, 75, 85, 100, 85, 115);
        Pokedex.put("Starmie", Starmie);
        
        Pokemon Mr_Mime = new Pokemon("Mr. Mime", "Mr. Mime", "Psychic", "Psychic", 40, 45, 65, 100, 120, 90);
        Pokedex.put("Mr Mime", Mr_Mime);
        
        Pokemon Scyther = new Pokemon("Scyther", "Scyther", "Bug", "Flying", 70, 110, 80, 55, 80, 105);
        Pokedex.put("Scyther", Scyther);
        
        Pokemon Jinx = new Pokemon("Jinx", "Jinx", "Ice", "Psychic", 65, 50, 35, 115, 95, 95);
        Pokedex.put("Jinx", Jinx);
        
        Pokemon Electabuzz = new Pokemon("Electabuzz", "Electabuzz", "Electric","Electric", 65, 83, 57, 95, 85, 105);
        Pokedex.put("Electabuzz", Electabuzz);
        
        Pokemon Magmar = new Pokemon("Magmar", "Magmar", "Fire", "Fire", 65, 95, 57, 100, 85, 93);
        Pokedex.put("Magmar", Magmar);
        
        Pokemon Pinsir = new Pokemon("Pinsir", "Pinsir", "Bug", "Bug", 65, 125, 100, 55, 70, 85);
        Pokedex.put("Pinsir", Pinsir);
        
        Pokemon Tauros = new Pokemon("Tauros", "Tauros", "Normal", "Normal", 75, 100, 95, 40, 70, 110);
        Pokedex.put("Tauros", Tauros);
        
        Pokemon Magikarp = new Pokemon("Magikarp", "Magikarp", "Water", "Water", 20, 10, 55, 15, 20, 80);
        Pokedex.put("Magikarp", Magikarp);
        
        Pokemon Gyarados = new Pokemon("Gyarados", "Gyarados", "Water", "Flying", 95, 125, 79, 60, 100, 81);
        Pokedex.put("Gyarados", Gyarados);
        
        Pokemon Lapras = new Pokemon("Lapras", "Lapras", "Water", "Ice", 130, 85, 80, 85, 95, 60);
        Pokedex.put("Lapras", Lapras);
        
        Pokemon Ditto = new Pokemon("Ditto", "Ditto", "Normal", "Normal", 48, 48, 48, 48, 48, 48);
        Pokedex.put("Ditto", Ditto);
        
        Pokemon Eevee = new Pokemon("Eevee", "Eevee", "Normal", "Normal", 55, 55, 50, 45, 65, 55);
        Pokedex.put("Eevee", Eevee);
        
        Pokemon Vaporeon = new Pokemon("Vaporeon", "Vaporeon", "Water", "Water", 130, 65, 60, 110, 95, 65);
        Pokedex.put("Vaporeon", Vaporeon);
        
        Pokemon Jolteon = new Pokemon("Jolteon", "Jolteon", "Electric", "Electric", 65, 65, 60, 110, 95, 130);
        Pokedex.put("Jolteon", Jolteon);
        
        Pokemon Flareon = new Pokemon("Flareon", "Flareon", "Fire", "Fire", 65, 130, 60, 95, 110, 65);
        Pokedex.put("Flareon", Flareon);
        
        Pokemon Porygon = new Pokemon("Porygon", "Porygon", "Normal", "Normal", 65, 60, 70, 85, 75, 40);
        Pokedex.put("Porygon", Porygon);
        
        Pokemon Omanyte = new Pokemon("Omanyte", "Omanyte", "Rock", "Water", 35, 40, 100, 90, 55, 35);
        Pokedex.put("Omanyte", Omanyte);
        
        Pokemon Omastar = new Pokemon("Omastar", "Omastar", "Rock", "Water", 70, 60, 125, 115, 70, 55);
        Pokedex.put("Omastar", Omastar);
        
        Pokemon Kabuto = new Pokemon("Kabuto", "Kabuto", "Rock", "Water", 30, 80, 90, 55, 45, 55);
        Pokedex.put("Kabuto", Kabuto);
        
        Pokemon Kabutops = new Pokemon("Kabutops","Kabutops", "Rock", "Water", 60, 115, 105, 65, 70, 80);
        Pokedex.put("Kabutops", Kabutops);
        
        Pokemon Aerodactyl = new Pokemon("Aerodactyl", "Aerodactyl", "Rock", "Flying", 80, 105, 65, 60, 75, 130);
        Pokedex.put("Aerodactyl", Aerodactyl);
        
        Pokemon Snorlax = new Pokemon("Snorlax", "Snorlax", "Normal", "Normal", 160, 110, 65, 65, 110, 30);
        Pokedex.put("Snorlax", Snorlax);
        
        Pokemon Zapdos = new Pokemon("Zapdos", "Zapdos", "Electric", "Flying", 90, 90, 85, 125, 90, 100);
        Pokedex.put("Zapdos", Zapdos);
        
        Pokemon Moltres = new Pokemon("Moltres", "Moltres", "Fire", "Flying", 90, 100, 90, 125, 85, 90);
        Pokedex.put("Moltres", Moltres);
        
        Pokemon Dratini = new Pokemon("Dratini", "Dratini", "Dragon", "Dragon", 41, 64, 45, 50, 50, 50);
        Pokedex.put("Dratini", Dratini);
        
        Pokemon Dragonair = new Pokemon("Dragonair", "Dragonair", "Dragon", "Dragon", 61, 84, 65, 70, 70, 70);
        Pokedex.put("Dragonair", Dragonair);
        
        Pokemon Dragonite = new Pokemon("Dragonite", "Dragonite", "Dragon", "Flying", 91, 134, 95, 100, 100, 85);
        Pokedex.put("Dragonite", Dragonite);
        
        Pokemon Mewtwo = new Pokemon("Mewtwo", "Mewtwo", "Psychic", "Psychic", 106, 110, 90, 154, 90, 130);
        Pokedex.put("Mewtwo", Mewtwo);
        
        Pokemon Mew = new Pokemon("Mew", "Mew", "Psychic", "Psychic", 100, 100, 100, 100, 100, 100);
        Pokedex.put("Mew", Mew);
    }
    

    //make a getter method that returns a Pokemon from the pokedex
    public Pokemon getPokemon(String name)
    {
        return Pokedex.get(name);
    }
    
    
    //make a method that adds a Pokemon to the pokedex
    public void addPokemon(Pokemon pokemon)
    {
        Pokedex.put(pokemon.getName(), pokemon);
    }
    
}

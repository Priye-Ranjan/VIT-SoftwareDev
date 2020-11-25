import java.io.*;
import java.util.*;
class HitWicket{

    static HashMap<Integer,String> bowler=new HashMap<>();
    static HashMap<Integer,String> batsman=new HashMap<>();
    
    public static String PvE()
    {
        int x=getRandomInteger(1,6);
        System.out.print("You have selected a :");
        String p=bowler.get(x);
        System.out.println(p+" bowler");
        
        return p;
    }
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        bowler.put(1,"Aggressive");
        bowler.put(2,"Aggressive");
        bowler.put(3,"Passive");
        bowler.put(4,"Passive");
        bowler.put(5,"Aggressive");
        bowler.put(6,"Passive");

        batsman.put(1,"Aggressive");
        batsman.put(2,"Aggressive");
        batsman.put(3,"Passive");
        batsman.put(4,"Passive");
        batsman.put(5,"Aggressive");
        batsman.put(6,"Passive");

        int gameMode;
        System.out.println("Select GameMode\n Press 1 for PvE \n Press 2 for PvP");
        gameMode=sc.nextInt();

        if(gameMode==1)
        {
           String bow=PvE();
           System.out.println("Now select a batsman");
           System.out.println(batsman);
           int choiceBatsman=sc.nextInt();
        }
    }

    public static int getRandomInteger(int maximum, int minimum)
    { 
        return ((int) (Math.random()*(maximum - minimum))) + minimum;
    }

}
import java.io.*;
import java.util.*;
class HitWicket{

    static HashMap<Integer,String> bowler=new HashMap<>();
    static HashMap<Integer,String> batsman=new HashMap<>();
    static HashMap<String,Integer> typeOfBall=new HashMap<>();
    static HashMap<String,ArrayList<String>> shotsPossible=new HashMap<>();
    static HashMap<String,ArrayList<Integer>> runOnShots=new HashMap<>();

    int Run=0;

    public static void addDummyData()
    {
        //Dummy Data for Types of Balls

        typeOfBall.put("Full Toss",4);
        typeOfBall.put("Yorker",3);
        typeOfBall.put("Out-swinger",3);
        typeOfBall.put("In-swinger",2);
        typeOfBall.put("Bouncer",4);
        typeOfBall.put("Slower-ball",2);        //Dummy Data for Types of Balls

        
        //Dummy Data for Run on Shots

        ArrayList<Integer> run=new ArrayList<>();
        run.add(5);run.add(0);
        runOnShots.put("Defend",run);

        ArrayList<Integer> run2=new ArrayList<>();
        run2.add(7);run2.add(1);
        runOnShots.put("Run",run2);

        ArrayList<Integer> run3=new ArrayList<>();
        run3.add(6);run3.add(2);
        runOnShots.put("Run Fast",run3);

        ArrayList<Integer> run4=new ArrayList<>();
        run4.add(7);run4.add(2);
        runOnShots.put("Cover Drive",run4);

        ArrayList<Integer> run5=new ArrayList<>();
        run5.add(5);run5.add(2);
        runOnShots.put("On Drive",run5);

        ArrayList<Integer> run6=new ArrayList<>();
        run6.add(6);run6.add(2);
        runOnShots.put("Straight Drive",run6);

        ArrayList<Integer> run7=new ArrayList<>();
        run7.add(7);run7.add(4);
        runOnShots.put("Square Cut",run7);

        ArrayList<Integer> run8=new ArrayList<>();
        run8.add(8);run8.add(4);
        runOnShots.put("Pull",run8);

        ArrayList<Integer> run9=new ArrayList<>();
        run9.add(7);run9.add(6);
        runOnShots.put("Hook",run9);

        ArrayList<Integer> run10=new ArrayList<>();
        run10.add(8);run10.add(6);
        runOnShots.put("Helicopter",run10);         //Dummy Data for Run on Shots



        //Dummy Data for Shots Possible  Start    

        ArrayList<String> l=new ArrayList<>();
        l.add("Defend");l.add("Run");l.add("Run Fast");l.add("Square Cut");l.add("Helicopter");
        shotsPossible.put("Full Toss",l);

        ArrayList<String> l2=new ArrayList<>();
        l2.add("Defend");l2.add("Run");l2.add("Straight Drive");l2.add("Square Cut");l2.add("Hook");
        shotsPossible.put("Yorker",l2);

        ArrayList<String> l3=new ArrayList<>();
        l3.add("Defend");l3.add("Run");l3.add("Cover Drive");l3.add("Pull");l3.add("Helicopter");
        shotsPossible.put("Out-Swinger",l3);

        ArrayList<String> l4=new ArrayList<>();
        l4.add("Defend");l4.add("Run");l4.add("On Drive");l4.add("Pull");l4.add("Hook");
        shotsPossible.put("In-Swinger",l4);

        ArrayList<String> l5=new ArrayList<>();
        l5.add("Defend");l5.add("Run");l5.add("Cover Drive");l5.add("Pull");l5.add("Hook");
        shotsPossible.put("Bouncer",l5);

        ArrayList<String> l6=new ArrayList<>();
        l6.add("Defend");l6.add("Run");l6.add("On Drive");l6.add("Pull");l6.add("Helicopter");
        shotsPossible.put("Slower Ball",l6);

        //Dummy Data for Shots Possible  End      


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
    }

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
        addDummyData();
        int gameMode;
        System.out.println("Select GameMode\n Press 1 for PvE \n Press 2 for PvP");
        gameMode=sc.nextInt();

        if(gameMode==1)
        {
           String bow=PvE();
           System.out.println("Now select a batsman");
           System.out.println(batsman);
           int choiceBatsman;
           do
           {
            choiceBatsman=sc.nextInt();
            if(choiceBatsman<1 || choiceBatsman>6)
                System.out.println("Invalid Selection");
           }
            while(choiceBatsman<1 || choiceBatsman >6);

            int curRun=0;
           for(int i=0;i<6;i++)
           {
             ArrayList randomBall=getRandomMapValue(typeOfBall);
             String ballType=(String)randomBall.get(0);
             int ballTypeVal=(int)randomBall.get(1);
             int runScored=0;
             System.out.println("Current Runs: "+curRun);
             System.out.println("Runs on last ball: "+runScored);

             System.out.println("Current Ball: "+ballType);
             System.out.println("Possible Shots: ");
             ArrayList shottype=shotsPossible.get(ballType);
             for(int j=0;j<shottype.size();j++)
             {
                 String shot=(String)shottype.get(j);
                 int shotVal=runOnShots.get(shot).get(0);
                 runScored=runOnShots.get(shot).get(1);
                 curRun+=runScored;
                 
                double shotProb=getProb(shotVal,ballTypeVal);
                
                System.out.println(shot+" - "+shotVal+" - "+shotProb);
                //System.out.println();
             }
             System.out.println();
           }
        }
    }

    //Probability Calculation
    public static double getProb(int shotm,int ballm) {
		double d = 0;
		d = (((shotm-ballm)*100)/shotm);
		return d;
    }
    

	public static boolean possible(double p) {
		Random rand = new Random();
		int num = (int)rand.nextInt(100)+1;
		if(num>p) {
			return false;
		}
		return true;
	}
    public static ArrayList getRandomMapValue(HashMap hmap)
    {
        Iterator<Map.Entry<String, Integer>> it = hmap.entrySet().iterator();
        ArrayList l=new ArrayList<>();
         int k = getRandomInteger(1,hmap.size());
         int p = 0;
         
         String key="";
         int val=0;
         while (it.hasNext()) {
            Map.Entry<String, Integer> pair = it.next();
            p++;

            val = pair.getValue();
            key=pair.getKey();
            if(p==k)
            {
                break;
            }
        }
        l.add(key);
        l.add(val);
        return l;
    }
    
    public static int getRandomInteger(int maximum, int minimum)
    { 
        return ((int) (Math.random()*(maximum - minimum))) + minimum;
    }

}
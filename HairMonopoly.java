public class HairMonopoly {
  public static boolean keepGoing = true;
  public static void main(String[] args){
    //**hairmonoply.intro();
    int[] stats = {70,0,60};
    int start=0;
    int end=0;
    loop(stats,start =1, end = 4);
    Day5(stats,start,end);
    //**hairmonopoly.finalday(stats);
  }

/*****************/
  public static void loop(int[] stats,int start,int end){
    for(int i=start;i<=end;i++){
      int day = i;
      System.out.printf("****************************%n Day %d%n",day);
      System.out.println("Good morning. There is a bunch of hairs on your pillow (-5%).");
      stats[0] = stats[0]-5;
      System.out.println("Hair: "+stats[0]+"%  Money: $"+stats[1]+"  Knowledge: "+stats[2]+"%");
      activity(stats);
      day++;
    }
    System.out.println("Hair: "+stats[0]+"%  Money: $"+stats[1]+"  Knowledge: "+stats[2]+"%");
  }

/******************/
  public static int[] activity(int[] stats){
    System.out.println("What would you like to do today? Choose 'study', 'work', or 'haircare'");
    stats = calculate(stats);
    System.out.println("What would you like to do next? Choose 'study', 'work', or 'haircare'.");
      stats = calculate(stats);
    return stats;
  }

/***********/
  public static int[] calculate(int[] stats){
    while(HairMonopoly.keepGoing){
      String activity = TextIO.getln();
      if(activity.equals("study")||activity.equals("work")||activity.equals("haircare")){
        switch(activity){
          case "study": stats = study(stats);break;
          case "work": stats = work(stats);break;
          case "haircare": stats = haircare(stats);break;
        }
        break;
      }else{
        System.out.println("Error! Please re-enter:");
      }
    }
    return stats;
  }

  /**************/
  public static void Day5(int[] stats,int start,int end){
    System.out.println("Surprise! Do you want to open it? yes/no");
    while (HairMonopoly.keepGoing){
      String choice = TextIO.getlnWord();
      if(choice.equals("yes")){
        //**hairmonopoly.Surprise(stats);
        break;
      } else if (choice.equals("no")){
        int[] statss = stats;
        int startt = start;
        int endd = end;
        loop(stats,start=6,end=7);
        break;
      } else{
        System.out.println("Error! Please re-enter:");
      }
    }
  }


/********/
  public static int[] haircare(int[] stats){
    stats[0]=stats[0]+10;
    stats[1]=stats[1]-10;
    System.out.println("You've bought a magic hair potion, increase 10% hair, lose 10 dollars");
    return stats;
  }

  public static int[] work(int stats[]){
    stats[0] = stats[0]- 5;
    stats[1] = stats[1] + 10;
    System.out.println("You lose 5% hair and obtain 10 dollors.");
    return stats;
  }

  public static int[] study(int stats[]){
    stats[0] = stats[0]- 15;
    stats[2] = stats[2] + 10;
    System.out.println("You lose 15% hair and obtain %10 knowledge.");
    return stats;
  }
}

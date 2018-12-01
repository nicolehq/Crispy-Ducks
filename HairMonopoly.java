public class HairMonopoly {
  public static boolean keepGoing = true;
  public static void main(String[] args){
    intro();
    int[] stats = {70,0,60};
    int start=0;
    int end=0;
    loop(stats,start =1, end = 4);
    Day5(stats,start,end);
    //**finalday(stats);
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
        //**Surprise();
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
  public static void intro(){
    System.out.println("Welcome to the game of Hair Monopoly!");
    System.out.println();
    System.out.println("Here is the instruction of the game: ");
    System.out.println("You are a super busy senior student, and your midterm is one week from now.");
    System.out.println("You will also take your senior portrait on that day.");
    System.out.println("In case to pass this game, you will need to look dashing on the picture as well as pass your exam.");
    System.out.println("There are three activities available for you everyday: Study, work and haircare.");
    System.out.println("You can choose two of them each day.");
    System.out.println("Study will increase your study ability but make you tired.");
    System.out.println("Work will increase your money and make you tired.");
    System.out.println("Haircare will cost you money but make you less tired.");
    System.out.println("If you are too tired, you will lose hair.");
    System.out.println("****************************");
    System.out.println("");
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
    System.out.println("You lose %5 hair and obtain 10 dollors.");
    return stats;
  }

  public static int[] study(int stats[]){
    stats[0] = stats[0]- 15;
    stats[2] = stats[2] + 10;
    System.out.println("You lose %15 hair and obtain %10 knowledge.");
    return stats;
  }
}

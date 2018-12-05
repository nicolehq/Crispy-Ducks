
public class HairMonopoly {
  public static boolean keepGoing = true;
  public static void main(String[] args){
    intro();
    int[] stats = {65,10,65};
    promptEnterKey.promptenterkey();
    loop(stats,1,5);
    promptEnterKey.promptenterkey();
    Day6(stats,6,7);
    FinalDay.finalday(stats);
  }

/*****************/
  public static void loop(int[] stats,int start,int end){
    for(int i=start;i<=end;i++){
      int day = i;
      System.out.printf("****************************%n Day %d%n",day);
      System.out.println("Good morning. There is a bunch of hairs on your pillow (-5%). You forgot what you have learnt. (-5%)");
      Sound.playSound("morning");
      stats[0] = stats[0]-5;
      stats[2] = stats[2]-5;
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
  public static void Day6(int[] stats,int start,int end){
    System.out.printf("**************************** %nWeekend is coming%n");
    promptEnterKey.promptenterkey();
    System.out.println("Surprise! Do you want to open it? yes/no");
    boolean open = TextIO.getlnBoolean();
    if(open){
      System.out.printf("Now you have the opportunity to participate in an event during the weekend. %nIf you don't want to use this opportunity, you would return to your normal schedule. Do you want to open the surprise?(yes/no)");
      while (HairMonopoly.keepGoing){
        String choice = TextIO.getlnWord();
        if(choice.equals("yes")){
          Surprise.surprise(stats);
          break;
        } else if (choice.equals("no")){
          loop(stats,start,end);
          break;
        } else{
          System.out.println("Error! Please re-enter:");
        }
      }
    }else{
      loop(stats,start,end);
    }
  }

  public static void intro(){
    System.out.println("Welcome to the game of Hair Monopoly!");
    System.out.println();
    promptEnterKey.promptenterkey();
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
   if(stats[1]==0){
     System.out.println("You don't have any money left. Please choose another activity.");
     stats = calculate(stats);
   }else if(stats[1]>0){
     stats[1]=stats[1]-10;
     if(stats[0]<0){
       stats[0]=0;
     }else if(stats[0]>100){
       stats[0]=100;
     }else{
       stats[0]=stats[0]+10;
     }
     System.out.println("You've bought a magic hair potion, increase 10% hair, lose 10 dollars.");
   }
   return stats;
 }

 public static int[] work(int stats[]){
   //stats[0] = stats[0]- 5;
   stats[1] = stats[1] + 10;
   if(stats[0]<0){
     stats[0]=0;
   }else if(stats[0]>100){
     stats[0]=100;
   }
   if(stats[1]<0){
     stats[1]=0;
   }
   System.out.println("You obtained 10 dollors.");
   return stats;
 }

 public static int[] study(int stats[]){
   stats[0] = stats[0] - 10;
   stats[2] = stats[2] + 15;
   if(stats[0]<0){
     stats[0]=0;
   }else if(stats[0]>100){
     stats[0]=100;
   }
   if(stats[2]>100){
     stats[2]=100;
   }
   if(stats[2]<0){
     stats[2]=0;
   }
   System.out.println("You lost 10% hair but obtained 15% knowledge.");
   return stats;
 }
}

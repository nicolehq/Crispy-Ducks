package project;
public class FinalDay{
  public static void finalday(int[] stats){
    System.out.println();
    System.out.println();
    System.out.println("**************************");
    System.out.println("Good morning! Today is your big day! You will take the senior portrait and the midterm.");
    System.out.println("Hair: "+stats[0]+"%  Money: $"+stats[1]+"  Knowledge: "+stats[2]+"%");
    System.out.println("On your way to photoshoot, you pass by an mysterious street vendor with only one mechardise:...A PERFECT-LOOKING WIG!");
    System.out.println("The price of wig is $100.");
    if (stats[0]>=60) {
      System.out.println("But you have enough hair to look awesome so you don't need this crap.");
    }else if (stats[1]>=100){
      makeDecision(stats);
    } else {
      System.out.println("You don't have enough money for this wig. You have to show up to the photoshoot with a pathetic amount of hair.");
    }

    if (stats[0]>=60 && stats[2]>=60){
      System.out.println("Congratulations! You passed your midterm and you look amazing in your senior portrait.");
    } else if(stats[0]<60 && stats[2]>=60) {
      System.out.println("You passed your midterm but you showed up to your senior portrait looking like this...");
    } else if (stats[0]>=60 && stats[2]<60){
      System.out.println("You look hot in your senior portrait but you failed the exam...");
    } else{
      System.out.println("You didn't pass your exam and your senior portrait looked pathetic...");
    }
  }

  public static void makeDecision(int[] stats){
    System.out.print("Your have less than 60% of hair left but you have enough money to buy this wig. Enter \"Y\" if you want to purchase, \"N\" if otherwise:");
    String choice=TextIO.getln();
    while (!choice.equals("Y") && !choice.equals("N")){
      System.out.print("Error! Please enter \"Y\" if you want to purchase, \"N\" if otherwise:");
      choice=TextIO.getln();
    }
    if (choice.equals("Y")){
      stats[0] = 60;
      stats[1] = stats[1] - 100;
      System.out.println("You purchased the wig. You can now wear it to your senior portrait.");
    } else {
      System.out.println("You didn't purchase the wig. You will show up to the photoshoot with a pathetic amount of hair.");
    }
  }
}

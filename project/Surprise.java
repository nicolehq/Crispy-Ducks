package project;
public class Surprise{
  public static int[] surprise(int[] stats){
    System.out.println("What a wonderful weekend! Your friend Tim invites you to do 3 activities with him.");
    System.out.println("Do you want to go to the casino-you can invest money and probably win more");
    System.out.println("Or enjoy a scalp massage-Tim treats you and you may gain some hair");
    System.out.println("Or hang up all night to study in the library-you may lose hair but may boost your study ability");
    System.out.println("Please enter C for casino, M for massage, and L for study in the library.");

    String choice =TextIO.getlnWord();

    while (!choice.equals("C")&&!choice.equals("M")&&!choice.equals("L")){
      System.out.println("Error! Please enter capitalized C, M or L here");
      choice =TextIO.getlnWord();
    }

    if (choice.equals("C")){
      casino(stats);
    }

    if(choice.equals("M")){
      massage(stats);
    }
    if(choice.equals("L")){
      library(stats);
    }
    return stats;
  }


  public static void casino(int[] stats){
    int invest;
    System.out.println("You decide to try the slot machine. Please enter the amount of money(integer) you want to put in.");
    invest=TextIO.getlnInt();
    if (invest>stats[1]){
      System.out.println("Please enter an amount that you can afford. The current money you have is "+stats[1]);
      invest=TextIO.getlnInt();
    }
    int random = (int)(Math.random() * 50 + 1);
    if(random<11){
    System.out.println("Yay! You win 10 times your bet!");
    stats[1]=stats[1]+9*invest;
    } else{
    System.out.println("Uh-oh,you lose.");
    stats[1]=stats[1]-invest;
    }
    System.out.println("The money you have now is "+stats[1]);
  }


  public static void massage(int[] stats){
    int growth = (int)(Math.random() * 30 + 1);
    stats[0]=stats[0]+growth;
    System.out.printf("Congratulations! You gain %3d percent of hair back!%n",growth);
    System.out.printf("The hair amount you have is %3d percent%n",stats[0] );
  }


  public static void library(int[] stats){
    stats[2]=stats[2]+50;
    stats[0]=1;
    if (stats[2]>100){
      stats[2]=100;
    }
    System.out.println("You have mastered great knowledge but after two whole days of study, there is only 1% hair on your head.");
    System.out.println("The knowledge now is "+stats[2]);
  }
}

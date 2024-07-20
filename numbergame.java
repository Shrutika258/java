
import java.util.Scanner;

public class numbergame  
 {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int chances=8;
        int finals=0;
        boolean playAgain=true;
        System.out.println("Welcome buddy!");
        System.out.println("Hello buddy you Have about"+chances +"to win the game");
        while(playAgain){
            int rand=getrandN(1,100);
            boolean guess=false;
            for(int i=0;i<chances;i++){
                System.out.println("chance"+(i+1)+"Enter your guess:");
                int user=sc.nextInt();
                if(user==rand){
                    guess=true;
                    finals+=1;
                    System.out.println("YOU WON IT...");
                    break;
                 }
                 else if(user>rand){
                    System.out.println("Too high");
                 }
                else{
                    System.out.println("Too low");
                }
            }
            if(guess==false){
            System.out.println("SORRY BUDDY.YOU LOST THE CHANCE.THE NUMBER IS "+rand);
        }
        System.out.println("DO U WANT TO PLAY AGAIN(y/n)");
        String pA=sc.next();
        playAgain=pA.equalsIgnoreCase("y");
   }
   System.out.println("THAT'S IT BUDDY,HOPE U ENJOYED IT");
   System.out.println("HERE IS UR SCORE"+finals);
    }
   public static int getrandN(int min,int max){
    return (int)(Math.random()*(max-min+1)+min);
   }
}

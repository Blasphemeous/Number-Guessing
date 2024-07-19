
/**
 *
 * @author blasphemeous
 */
import java.util.Scanner; 
import java.io.IOException; 
import java.util.InputMismatchException; 
import java.util.ArrayList; 
public class Main {
    public static void main(String[] args){
        ArrayList<Integer> scores = new ArrayList<>();
        Scanner scan = new Scanner(System.in); 
        System.out.println("GUESS THE NUMBER GAME");
        System.out.println("[1] PLAY");
        System.out.println("[2] EXIT");
        System.out.print("CHOICE: ");
        int choice = scan.nextInt();
        
        switch(choice){
            case 1: 
                Play(scores); 
                break;
            case 2: 
               break; 
            default:
                System.out.println("INVALID CHOICE");
                try{
                  System.in.read(); 
                  main(new String[] {}); 
                    
                }catch(IOException e){
                 System.out.println(); 
                }
                break;  
             
        }
    }
    
    public static void Play(ArrayList<Integer> scores){
        Scanner scan = new Scanner(System.in); 
        while(true){
            Game(scores, scan); 
            Score(scores);
        }
    }
    
    public static void Game(ArrayList<Integer> scores, Scanner scan){
       System.out.println("GUESS THE NUMBER BETWEEN 1-20");
       System.out.println("THREE ATTEMPTS");
       int random = (int) (Math.random() *20)+1;
       String convert = Integer.toString(random); 
       if(convert.length() > 1){
           System.out.printf("HINT: %s DIGITS\n", convert.length());
       }else{
           System.out.printf("HINT: %s DIGIT\n", convert.length()); 
       }
     
       if(random % 2 == 0){
           System.out.println("HINT: EVEN NUMBER"); 
       }else{
           System.out.println("HINT: ODD NUMBER"); 
       }
         int attempts = 3; 
         
         int score = 0; 
         

       while(attempts > 0){
           try{
        System.out.print("ENTER THE NUMBER: "); 
           int answer = scan.nextInt();
           if(answer == random){
               score++; 
               scores.add(score); 
               System.out.println("YOU GOT THE CORRECT ANSWER: " + random);
               break; 
           }else{
               attempts--; 
               if(attempts > 0){
                   System.out.printf("YOU ONLY HAVE %d ATTEMPTS\n", attempts);
               }else{
                   System.out.println("YOU FAILED ALL ATTEMPTS");
                   System.out.println("SCORE: " + score);
                   main(new String[] {}); 
                   break;
              
               }
           }
           }catch(InputMismatchException e){
            System.out.println("INVALID INPUT");
            scan.next(); 
          }
       }
    }
    
     public static void Score(ArrayList<Integer> scores) {
        System.out.print("TOTAL SCORE: ");
        int sum = 0; 
        for (int score : scores) {
            sum += score; 
        }
        System.out.println(sum);  
    }
}

import java.util.Scanner; import java.util.Random;
public class Main {
  public static void main(String[] args) { 
     
       final int NUM_COLORS = 4; 
    final int CODE_LENGTH = 4; 
    Generate the random code int[] secretCode = generateCode(CODE_LENGTH, NUM_COLORS); 
    System.out.println("Welcome to Mastermind!"); 
    System.out.println("Try to guess the code consisting of " + CODE_LENGTH + " colors (from 1 to " + NUM_COLORS + ").");
    Scanner scanner = new Scanner(System.in); 
    boolean hasWon = false; 
    for (int attempts = 1; attempts <= 10; attempts++) 
    { System.out.println("\nAttempt #" + attempts + ": Enter your guess (numbers separated by spaces):");
     int[] guess = new int[CODE_LENGTH];
     for (int i = 0; i < CODE_LENGTH; i++) 
     { 
       guess[i] = scanner.nextInt(); }
     int[] feedback = checkGuess(secretCode, guess); 
     System.out.println("Number of correct colors in the correct positions: " + feedback[0]);
     System.out.println("Number of correct colors in the wrong positions: " + feedback[1]); 
     if (feedback[0] == CODE_LENGTH) { hasWon = true; break; } } 
    if (hasWon) { 
      System.out.println("Congratulations! You've won."); }
    else {
      System.out.println("Unfortunately, you've run out of attempts. The secret code was:"); 
      for (int num : secretCode) { System.out.print(num + " "); } } } 
 private static int[] generateCode(int length, int numColors) 
  { Random random = new Random(); 
   int[] code = new int[length];
   for (int i = 0; i < length; i++) 
   { code[i] = random.nextInt(numColors) + 1;  } 
   return code; }
  private static int[] checkGuess(int[] secretCode, int[] guess) 
  { int correctPosition = 0; int correctColor = 0;
   boolean[] secretUsed = new boolean[secretCode.length]; 
   boolean[] guessUsed = new boolean[guess.length];  
     for (int i = 0; i < secretCode.length; i++)
       { 
         if (secretCode[i] == guess[i]) { correctPosition++; secretUsed[i] = true; guessUsed[i] = true; } } 
   for (int i = 0; i < secretCode.length; i++)
     { for (int j = 0; j < guess.length; j++) 
     { if (!secretUsed[i] && !guessUsed[j] && secretCode[i] == guess[j]) 
     { correctColor++; secretUsed[i] = true; guessUsed[j] = true; break; } } 
     } return new int[]{correctPosition, correctColor}; }

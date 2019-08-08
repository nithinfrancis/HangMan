
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Hangman {

    Set<Character> guessedCharacter;
    private int limit;
    private final int maxTrails = 3;
    private StringBuilder filledword;
    private String word;
    private int wordLength;
    private int flag;
    private int wrongEntry;

    private enum hangmanState {
        win, running, failed;};
    hangmanState h;

    public Hangman(String w) {

        word = w;
        wordLength = word.length();
    }

    private void guess(char p) {

        if (h != hangmanState.running) {
            throw new IllegalStateException("is not running");
        }
        char c = Character.toUpperCase(p);
        if (c < 'A' || c > 'Z') {
            throw new IllegalStateException("incorrect input");
        } 

        if (guessedCharacter.contains(c)) {
               throw new IllegalStateException("character is allreday entered");
            } 
                flag = 0;
                guessedCharacter.add(c);
                for (int i = 0; i < wordLength; i++) {
                    if (word.charAt(i) == c) {
                        flag++;
                        filledword.setCharAt(i, c);

                    }

                }
                System.out.println(filledword);
                if (flag == 0) {
                    wrongEntry++;

                }
            

        
        if (filledword.toString().equals(word)) {
            h = hangmanState.win;

        }
        if (wrongEntry == 4) {
            h = hangmanState.failed;
            System.out.println("You have entered '"+wrongEntry+" 'worng options" );
        }

    }

    public static void main(String arg[]) {
        String word = "WELCOME";
        //System.out.println("enter the word");
        Scanner s = new Scanner(System.in);
        //String word = s.nextLine().toUpperCase();

        Hangman hangman = new Hangman(word);
        hangman.h = hangmanState.running;
        hangman.guessedCharacter = new HashSet<>();
        hangman.filledword = new StringBuilder();
        hangman.wordLength = word.length();
        hangman.filledword.setLength(hangman.wordLength);
        for (int i = 0; i < word.length(); i++) {
            hangman.filledword.setCharAt(i, '#');
        }
        System.out.println(hangman.filledword);
        hangman.limit = hangman.maxTrails + hangman.wordLength;

        for (int i = 0; i < hangman.limit; i++) {
            if (hangman.h == hangmanState.failed || hangman.h == hangmanState.win) {
                if (hangman.h == hangmanState.win) {
                    System.out.println("win");
                } else {
                    System.out.println("you have exceed maximum limit");
                }
                break;
            }
            System.out.println("enter character:");
            char p = s.next().charAt(0);
            try {
                hangman.guess(p);
            } catch (IllegalStateException e) {
                System.out.println(e);
            }
        }
    }

}

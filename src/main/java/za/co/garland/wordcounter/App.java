package za.co.garland.wordcounter;

import java.util.Scanner;

public class App
{
    public static void main( String[] args ) {
        WordCounter wordCounter = new WordCounter();
        Scanner systemIn = new Scanner(System.in);

        System.out.println( "Welcome to the word counter");
        System.out.println( "To show current words press s");
        System.out.println( "To exit type x");
        System.out.println( "Enter a word");
        while (true) {
            String line = systemIn.nextLine();
            if (line.equals("x")) {
                System.out.println( "Exit");
                return;
            } else if (line.equals("s")) {
                System.out.println( "Current list");
                System.out.println(wordCounter);
            } else {
                try {
                    wordCounter.addWord(line);
                } catch (WordException e){
                    System.err.println( e.getMessage());
                }
            }
        }
    }
}

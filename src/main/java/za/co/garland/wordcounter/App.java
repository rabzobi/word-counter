package za.co.garland.wordcounter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class App
{
    public static void main( String[] args ) throws IOException {
        WordCounter wordCounter = new WordCounter();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println( "Welcome to the word counter");
        System.out.println( "To show current words press s");
        System.out.println( "To exit type x");
        System.out.println( "Enter a word");
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            if (line.equals("x")) {
                System.out.println( "Exit");
                return;
            } else if (line.equals("s")) {
                System.out.println( "Current list");
                System.out.println(wordCounter);
            } else {
                try {
                    wordCounter.addWord(line);
                } catch (Exception e){
                    System.err.println( "Invalid word");
                }
            }
        }
    }
}

package za.co.garland.wordcounter;

import java.util.HashMap;
import java.util.Map;

public class WordCounter {

    private Map<String,Integer> wordCount;
    Translator translator;

    public WordCounter(){
        wordCount = new HashMap();
        translator = new Translator();
    }

    public synchronized void addWord(String word) throws WordException {
        if (!isValidWord(word)) {
            throw new WordException("Invalid word");
        }
        String translatedWord = translator.translate(word);

        wordCount.put(word, wordCount.getOrDefault(translatedWord, 0) + 1);
    }

    private boolean isValidWord(String word) {
        if (word == null || word.trim().isEmpty()) {
            return false;
        }
        return word.matches("[a-zA-Z]+");
    }

    public Integer countWord(String word){
        String translatedWord = translator.translate(word);
        return wordCount.getOrDefault(translatedWord,0);
    }

    @Override
    public String toString() {
        String words = new String();
        for (String word: wordCount.keySet()){
            words += word+":"+ wordCount.get(word)+"\n";
        }
        return words;
    }
}

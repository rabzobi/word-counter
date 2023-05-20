package za.co.garland.wordcounter;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordCounter {

    private Map<String,Integer> map = new HashMap();
    Translator translator = new Translator();

    public synchronized void addWord(String word) throws Exception {
        word = translator.translate(word);

        if (word == null || word.trim().isEmpty()) {
            throw new Exception("null or empty string");
        }
        Pattern pattern = Pattern.compile("[^A-Za-z]");
        Matcher matcher = pattern.matcher(word);
        boolean found = matcher.find();
        if (found) {
            throw new Exception("There is a special character in the word");
        }
        Integer count = map.get(word);
        if (count == null){
            map.put(word,1);
        } else {
            map.put(word,count+1);
        }
    }

    public Integer countOccurrenceOfWord(String word){
        word = translator.translate(word);
        return map.get(word);
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        for (String word: map.keySet()){
            stringBuffer.append(word+":"+map.get(word)+"\n");
        }
        return stringBuffer.toString();
    }
}

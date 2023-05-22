package za.co.garland.wordcounter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class WordCounterTest {
    private WordCounter wordCounter;

    @BeforeEach
    void setUp() {
        wordCounter = new WordCounter();
    }

    @Test
    void testAddValidWords() throws WordException {
        wordCounter.addWord("flower");
        wordCounter.addWord("flower");
        wordCounter.addWord("flower");
        wordCounter.addWord("flor");

        assertEquals(3, wordCounter.countWord("flower"));
        assertEquals(1, wordCounter.countWord("flor"));
        assertEquals(0, wordCounter.countWord("rose"));
    }

    @Test
    void testAddImvalidWord() throws WordException {
        WordCounter wordCounter = new WordCounter();

        assertThrows(WordException.class, () -> {
            wordCounter.addWord("apple1");
        });
    }

    @Test
    void testAddInvalidWordToCounter() throws WordException {
        wordCounter.addWord("flower");
        assertThrows(WordException.class, () -> {
            wordCounter.addWord("rose1");
        });
        wordCounter.addWord("rose");

        assertEquals(1, wordCounter.countWord("flower"));
        assertEquals(1, wordCounter.countWord("rose"));
        assertEquals(0, wordCounter.countWord("rose1"));
    }

}
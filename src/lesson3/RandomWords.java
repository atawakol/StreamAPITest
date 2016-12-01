/**
 * Copyright © 2014, Oracle and/or its affiliates. All rights reserved.
 * 
 * JDK 8 MOOC Lesson 3 homework
 */
package lesson3;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
/**
 * Class to generate a list of random words
 *
 * @author Simon Ritter (@speakjava)
 */
public class RandomWords {
  private final List<String> sourceWords;

  /**
   * Constructor
   * 
   * @throws IOException If the source words file cannot be read
   */
  public RandomWords() throws IOException {   
    try (BufferedReader reader = Files.newBufferedReader(Paths.get("words"))) {
      //sourceWords = reader.lines().collect(Collectors.toList());    // YOUR CODE HERE
      
      sourceWords = reader.lines().collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
        
      System.out.println("Loaded " + sourceWords.size() + " words");
    }
  }

  /**
   * Create a list of a given size containing random words
   *
   * @param listSize The size of the list to create
   * @return The created list
   */
  public List<String> createList(int listSize) {
    Random rand = new Random();
    List<String> wordList = null; // YOUR CODE HERE
    
/*    wordList = rand.ints(0, sourceWords.size()).limit(listSize)
            .collect(ArrayList::new, (list, index) -> list.add(sourceWords.get(index)), ArrayList::addAll);
  */
    
      wordList = rand.ints(listSize, 0, sourceWords.size())
            .collect(ArrayList::new, (list, index) -> list.add(sourceWords.get(index)), ArrayList::addAll);
    
    
    return wordList;
  }

  /**
   * Return the list of all source words, which cannot be modified
   *
   * @return The unmodifiable list of all source words
   */
  public List<String> allWords() {
    return Collections.unmodifiableList(sourceWords);
  }
}
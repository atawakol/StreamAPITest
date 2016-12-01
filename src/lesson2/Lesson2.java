/**
 * Copyright © 2014, Oracle and/or its affiliates. All rights reserved.
 *
 * JDK 8 MOOC Lesson 2 homework
 */
package lesson2;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Speakjava (simon.ritter@oracle.com)
 */
public class Lesson2 {
  private static final String WORD_REGEXP = "[- .:,]+";

  /**
   * Run the exercises to ensure we got the right answers
   *
   * @throws java.io.IOException
   */
  public void runExercises() throws IOException {

    System.out.println("JDK 8 Lambdas and Streams MOOC Lesson 2");
    System.out.println("Running exercise 1 solution...");
    exercise1();
    System.out.println("Running exercise 2 solution...");
    exercise2();
    System.out.println("Running exercise 3 solution...");
    exercise3();
    System.out.println("Running exercise 4 solution...");
    exercise4();
    System.out.println("Running exercise 5 solution...");
    exercise5();
    System.out.println("Running exercise 6 solution...");
    exercise6();
    System.out.println("Running exercise 7 solution...");
    exercise7();
    System.out.println("Running exercise 8 solution...");
    exercise8();
    System.out.println("Running exercise9 solution...");
    exercise9();
 
  }

  /**
   * Exercise 1
   *
   * Create a new list with all the strings from original list converted to 
   * lower case and print them out.
   */
  private void exercise1() {
    List<String> list = Arrays.asList(
        "The", "Quick", "BROWN", "Fox", "Jumped", "Over", "The", "LAZY", "DOG");

    //list.stream().map(String::toLowerCase).forEach(System.out::println);
    
    List<String> newList = list.stream()
            .map(String::toLowerCase)
            .collect(Collectors.toList());
    
    newList.forEach(System.out::println);
    
    /* YOUR CODE HERE */
  }

  /**
   * Exercise 2
   *
   * Modify exercise 1 so that the new list only contains strings that have an
   * odd length
   */
  private void exercise2() {
    List<String> list = Arrays.asList(
        "The", "Quick", "BROWN", "Fox", "Jumped", "Over", "The", "LAZY", "DOG");

        List<String> newList = list.stream()
            .filter(e -> (e.length() & 1) == 1)
            .map(String::toLowerCase)
            .collect(Collectors.toList());
    
        
        newList.forEach(System.out::println);
    /* YOUR CODE HERE */
  }

  /**
   * Exercise 3
   *
   * Join the second, third and forth strings of the list into a single string,
   * where each word is separated by a hyphen (-). Print the resulting string.
   */
  private void exercise3() {
    List<String> list = Arrays.asList(
        "The", "quick", "brown", "fox", "jumped", "over", "the", "lazy", "dog");

    String res = list.stream()
            .skip(1)
            .limit(3)
            .collect(Collectors.joining("-"));
    
      System.out.println("res : " + res);
    
    /* YOUR CODE HERE */
  }

  /**
   * Count the number of lines in the file using the BufferedReader provided
   */
  private void exercise4() throws IOException {
    try (BufferedReader reader = Files.newBufferedReader(
        Paths.get("SonnetI.txt"), StandardCharsets.UTF_8)) {
      
        long len = reader.lines().count();
         System.out.println("length :- " + len);        
    }
  }
  
  /**
   * Using the BufferedReader to access the file, create a list of words with
   * no duplicates contained in the file.  Print the words.
   * 
   * HINT: A regular expression, WORD_REGEXP, is already defined for your use.
   */
  private void exercise5() throws IOException {
    try (BufferedReader reader = Files.newBufferedReader(
        Paths.get("SonnetI.txt"), StandardCharsets.UTF_8)) {
      /* YOUR CODE HERE */
        
/*        Object[] res = (Object[]) reader.lines()
                .flatMap(l -> Stream.of(l.split(WORD_REGEXP)))
                .distinct().toArray();
        
        Arrays.stream(res).forEach(System.out::println);
        
        */
        
        reader.lines()
                .flatMap(l -> Stream.of(l.split(WORD_REGEXP)))
                .distinct()
                .forEach(System.out::println);
        
    }
  }
  
  /**
   * Using the BufferedReader to access the file create a list of words from 
   * the file, converted to lower-case and with duplicates removed, which is
   * sorted by natural order.  Print the contents of the list.
   */
  private void exercise6() throws IOException {
    try (BufferedReader reader = Files.newBufferedReader(
        Paths.get("SonnetI.txt"), StandardCharsets.UTF_8)) {
      /* YOUR CODE HERE */
        
        reader.lines()
                .flatMap(l -> Stream.of(l.split(WORD_REGEXP)))
                .map(String::toLowerCase)
                .distinct()
                .sorted()
                .forEach(System.out::println);        
    }
  }
  
  /**
   * Modify exercise6 so that the words are sorted by length
   */
  private void exercise7() throws IOException {
    try (BufferedReader reader = Files.newBufferedReader(
        Paths.get("SonnetI.txt"), StandardCharsets.UTF_8)) {
      /* YOUR CODE HERE */
        
        reader.lines()
                .flatMap(l -> Stream.of(l.split(WORD_REGEXP)))
                .map(String::toLowerCase)
                .distinct()
                .sorted((w1, w2) -> w1.length() - w2.length())
                .forEach(System.out::println);          
    }
  }
  
  
    /**
   * Find the length of longest line in the file
   */
  private void exercise8() throws IOException {
    
      Path path = Paths.get("SonnetI.txt");
      
      int longest = Files.lines(path)
              .mapToInt(String::length)
              .peek(System.out::println)
              .max()
              .getAsInt();
      
      System.out.println("Length : " + longest);
      
  }

  
    /**
   * Find the longest line in the file
   */
  private void exercise9() throws IOException {
    
      Path path = Paths.get("SonnetI.txt");
      
      /*String longest = Files.lines(path)
              .sorted((x,y) -> y.length() - x.length())
              .findFirst()
              .get();
      */
      
/*      String longest = Files.lines(path)
              .reduce( (elm1, elm2) -> {
                if (elm1.length() > elm2.length()) 
                    return elm1;    
                return elm2;
              })
              .get();
*/
      
      
      String longest = Files.lines(path)
              .max(Comparator.comparingInt(String::length))
              .get();
              
      System.out.println("longest : " + longest);
      
  }
  
  
  /**
   * Main entry point for application
   *
   * @param args the command line arguments
   * @throws IOException If file access does not work
   */
  public static void main(String[] args) throws IOException {
    Lesson2 lesson = new Lesson2();
    lesson.runExercises();
  }
}


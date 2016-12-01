/**
 * Copyright © 2014, Oracle and/or its affiliates. All rights reserved.
 *
 * JDK 8 MOOC Lesson 1 homework
 */
package lesson1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Predicate;

/**
 * @author Speakjava (simon.ritter@oracle.com)
 */
public class Lesson1 {
  /**
   * Run the exercises to ensure we got the right answers
   */
  public void runExercises() {
    System.out.println("JDK 8 Lambdas and Streams MOOC Lesson 1");
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
  }

  /**
   * All exercises should be completed using Lambda expressions and the new
   * methods added to JDK 8 where appropriate. There is no need to use an
   * explicit loop in any of the code. Use method references rather than full
   * lambda expressions wherever possible.
   */
  /**
   * Exercise 1
   *
   * Create a string that consists of the first letter of each word in the list
   * of Strings provided.
   */
  private void exercise1() {
    List<String> list = Arrays.asList(
        "alpha", "bravo", "charlie", "delta", "echo", "foxtrot");
    
    StringBuilder build = new StringBuilder();
    //list.forEach((String s) -> build.append(s.charAt(0)));
    //list.forEach(s -> build.append(s.charAt(0)));
    //list.forEach((String s) -> {build.append(s.charAt(0));});
    
    list.forEach((String s) -> build.append(s.charAt(0)));

    System.out.println(build.toString());
    System.out.println("-----------------------------------------------------------");
    /* YOUR CODE HERE */
  }

  /**
   * Exercise 2
   *
   * Remove the words that have odd lengths from the list.
   */
  private void exercise2() {
    List<String> list = new ArrayList<>(Arrays.asList(
        "alpha", "bravo", "charlie", "delta", "echo", "foxtrot"));

    //list.removeIf(s -> s.length()%2 !=0 );
    //list.removeIf((String s) -> {return s.length()%2 !=0;} );
    
    //  Predicate<String> perd = s -> s.length()%2 !=0 ;
    //  list.removeIf(perd);
    
      Predicate<String> perd = (String s) -> (s.length() & 1) ==1 ;
      list.removeIf(perd);
    
    //list.forEach( s-> System.out.println(s));
    list.forEach(System.out::println);
    System.out.println("-----------------------------------------------------------");

    
    /* YOUR CODE HERE */
  }

  /**
   * Exercise 3
   *
   * Replace every word in the list with its upper case equivalent.
   */
  private void exercise3() {
    List<String> list = new ArrayList<>(Arrays.asList(
        "alpha", "bravo", "charlie", "delta", "echo", "foxtrot"));

    
    //list.replaceAll(s -> s.toUpperCase());
    list.replaceAll(String::toUpperCase);
    
    list.forEach(System.out::println);
    /* YOUR CODE HERE */
  }

  /**
   * Exercise 4
   *
   * Convert every key-value pair of the map into a string and append them all
   * into a single string, in iteration order.
   */
  private void exercise4() {
    Map<String, Integer> map = new TreeMap<>();
    map.put("c", 3);
    map.put("b", 2);
    map.put("a", 1);
    
    StringBuffer buffer = new StringBuffer();
    
    //map.forEach((k,v)-> buffer.append(k).append(":").append(v).append(","));
    map.forEach((k,v)-> buffer.append(String.format("%s:%s, ", k, v)));
    
    System.out.println(buffer.toString());

    /* YOUR CODE HERE */
  }

  /**
   * Exercise 5
   *
   * Create a new thread that prints the numbers from the list.
   */
  private void exercise5() {
    List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

    new Thread(() -> list.forEach(System.out::println)).start();
    
    /* YOUR CODE HERE */
  }

  /**
   * Main entry point for application
   *
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    Lesson1 lesson = new Lesson1();
    lesson.runExercises();
  }
}

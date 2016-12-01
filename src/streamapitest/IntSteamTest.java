/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streamapitest;

import java.util.stream.IntStream;

/**
 *
 * @author atawakol
 */
public class IntSteamTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
       // test1();
       // test2();
         test3();
        
    }
    

    private static void test1() {
        IntStream stream = IntStream.range(10, 1000).parallel();
        
        System.out.println(stream.isParallel());
        
        stream.forEach(System.out::println);
    }

    private static void test2() {
       int sum  = IntStream.of(1, 2, 3, 4).parallel()
         .filter( e -> e > 2  )
         .peek(e -> System.out.println("Filtered value: " + e))
         .map(e -> e * e)
         .peek(e -> System.out.println("Mapped value: " + e))
         .sum();
       
       System.out.println(sum);
    }
    
    private static void test3() {
       long start = System.currentTimeMillis(); 
       int sum  = IntStream.range(10, 10000)
         .filter(e -> e > 2)
         .peek(e -> System.out.println("Filtered value: " + e))
         .map(e -> e * e)
         .peek(System.out::println)
         .sum();
       
       System.out.println(sum);
       System.out.print(System.currentTimeMillis() - start);
    }
    
}

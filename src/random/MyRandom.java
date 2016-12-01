/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package random;

import java.util.Random;
import java.util.stream.IntStream;

/**
 *
 * @author atawakol
 */
public class MyRandom {
    
     public static void main(String[] args) {
        new MyRandom().test();
        System.out.println("Seperatorr---------------------------->");
       new MyRandom().test2();
        System.out.println("Seperatorr---------------------------->");
        new MyRandom().test3();
    }

    private void test() {
       int rand = new Random().ints()
               .peek(r-> System.out.println("Filter --> " + r))
               .filter(r -> r > 255)
               .peek(r-> System.out.println("finmd --> " + r))
               .findFirst().getAsInt();
    }
    
    private void test2() {
        
        IntStream stream = IntStream.range(0, 10);
        
       int rand = stream
               .peek(r-> System.out.println("Filter --> " + r))
               .filter(r -> r > 5)
               .peek(r-> System.out.println("map --> " + r))
               .map(r -> {
                   for (int i = 0 ; i < 1000; i++)
                       System.out.println("i " + i);
                   return r;
                   })
               .peek(r-> System.out.println("find --> " + r))
               .findFirst().getAsInt();
    }

    private void test3() {
        new Random().ints(10, 10, 20).forEach(System.out::println);
    }
    
}

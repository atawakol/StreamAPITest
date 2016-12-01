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
public class EmptySteam {
    public static void main(String[] args) {
        
        //test1();
        test2();
        
    }

    private static void test1() {
        IntStream.Builder builder = IntStream.builder();
        double avg = builder.add(10).add(20).add(30).build().average().getAsDouble();
        System.out.println("" + avg);
    }
    
    private static void test2() {
        IntStream.Builder builder = IntStream.builder();
        builder.add(10).add(20).add(10).add(30).build().distinct().forEach(System.out::println);
        
    }
}

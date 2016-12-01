/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arrays;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 *
 * @author atawakol
 */
public class TestArrays {
    public static void main(String[] args) {
        
        int[] array = new int[10];
        
        Arrays.setAll(array, i ->i );
        
        for (int i = 0 ; i < array.length; i++) {
            System.out.println(array[i]);
        }
        
        Arrays.asList(array).stream().forEach(System.out::println);
        System.out.println(Arrays.asList(array).stream().count());
        Stream.of(array).forEach(System.out::println);
        
        Arrays.stream(array).forEach(System.out::println);
        
    }
}

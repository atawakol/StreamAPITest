/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streamapitest;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author atawakol
 */
public class NewSortComprator {
    
    public static void main(String[] args) {
        new NewSortComprator().test();
        System.out.println("Seperatorr---------------------------->");
       //new NewSortComprator().test2();
        System.out.println("Seperatorr---------------------------->");
       // new MyRandom().test3();
    }

    private void test() {
        
        List<Integer> list = Arrays.asList(10, 20, 15, 17, 12, 11, 13);
        
        list.sort(Comparator.naturalOrder());
        list.forEach(System.out::println);
        
    }
    
}

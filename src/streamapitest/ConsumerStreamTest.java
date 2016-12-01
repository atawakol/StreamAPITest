/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streamapitest;

import java.util.Locale;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntConsumer;
import java.util.stream.IntStream;

/**
 *
 * @author atawakol
 */
public class ConsumerStreamTest {
    
    public static void main(String[] args) {
        test1();
    }

    private static void test1() {
        
        IntConsumer cons1 = (s) -> System.out.println("1:" + s);
        IntConsumer cons2 = (s) -> System.out.println("2:" + s);
        
         IntConsumer cons3 = cons1.andThen(cons2);
        
        IntStream stream = IntStream.range(0, 10);
        stream = stream.peek(cons3);
        stream.sum();
    }
    
    private static void process(Function f){
      
        
    
    }
    
}

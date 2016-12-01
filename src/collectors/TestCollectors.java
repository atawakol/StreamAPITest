/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collectors;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author atawakol
 */
public class TestCollectors {
    
    private static final String WORD_REGEXP = "[- .:,]+";
    
    public static void main(String[] args) throws Exception {
        //new TestCollectors().test1();
        System.out.println("sepeator --------------------------------");
        new TestCollectors().test2();
    }

    private void test1() throws IOException {
        
        List<String> words = readFile();
         
         
         Map<Integer, List<String>> res =  words.stream().collect(Collectors.groupingBy(String::length));
         
         res.forEach((k,v) -> {
            System.out.println("---> Key " + k);
            v.forEach(System.out::println);
    });
    }

    private List<String> readFile() throws IOException {
        Path path = Paths.get("SonnetI.txt");
        List<String> words = Files.lines(path)
                .flatMap(l -> Stream.of(l.split(WORD_REGEXP))).collect(Collectors.toList());
        return words;
    }

    private void test2() throws IOException {
          List<String> words = readFile();
          
          Map<Integer, Long> res =  words.stream().collect(Collectors.groupingBy(String::length, Collectors.counting()));
          
          res.forEach( (k,v) -> {
          System.out.println("---> Key " + k + " : value : " + v );
          
          });
    }
}

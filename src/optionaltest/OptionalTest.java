/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package optionaltest;

import java.util.Optional;

/**
 *
 * @author atawakol
 */
public class OptionalTest {

    public static void main(String[] args) {
        new OptionalTest().test();
        System.out.println("Seperatorr---------------------------->");
        new OptionalTest().test2();
        System.out.println("Seperatorr---------------------------->");
        new OptionalTest().test3();
    }
    
    private void test (){
        
          //GPSData gbs = null;
        GPSData gbs = new GPSData();
        
        
        String direction = Optional.ofNullable(gbs)
                .flatMap(GPSData::getPosition)
                .flatMap(Position::getLatitude)
                .map(Latitude::getString)
                .orElse("Unknown");
        
        System.out.println("direction is --> " + direction);
    
    }

    private void test2() {
        
        //GPSData gbs = null;
        GPSData gbs = new GPSData();
        
        
        String direction = gbs
                .getPosition()
                .flatMap(Position::getLatitude)
                .map(Latitude::getString)
                .orElse("Unknown");
        
        System.out.println("direction is --> " + direction);
        
    }
    
    
    private void test3() {
        
        //GPSData gbs = null;
        GPSData gbs = new GPSData();
        
        
                gbs
                .getPosition()
                .flatMap(Position::getLatitude)
                .ifPresent(l -> System.err.println("direction is -->" + l.getString()));

        
    }
    
    
}







class GPSData {

    public Optional<Position> getPosition() {
        System.out.println("Position");
        
        return Optional.of(new Position());
        //return Optional.empty();
    }
}

class Position {

    public Optional<Latitude> getLatitude() {
        System.out.println("tLatitude");
       
        
        return Optional.of(new Latitude());
        //return Optional.empty();
    }
}

class Latitude {

    public String getString() {
         System.out.println("final drect");
        
         return "Right";
         //return null;
    }
}

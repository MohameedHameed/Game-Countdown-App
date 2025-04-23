/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author admin
 */
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 */
public  class GameListing {
    public static List<Game> Games=new ArrayList<Game>();
    
    
    public static List<Game> getAll(){
        return GameListing.Games;
    }
    
}

package eg.edu.alexu.csd.oop.circus;

import java.awt.Color;

import eg.edu.alexu.csd.oop.circus.model.GameWorld;
import eg.edu.alexu.csd.oop.game.GameEngine;

public class Main {
    public static void main(String[] args){
        GameWorld world = new GameWorld(800, 600);

        GameEngine.start("Circus of Plates", world, Color.BLACK);
    }
}

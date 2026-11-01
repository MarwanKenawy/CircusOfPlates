package eg.edu.alexu.csd.oop.circus.factory;

import java.awt.Color;

import eg.edu.alexu.csd.oop.circus.model.objects.Plate;
import eg.edu.alexu.csd.oop.circus.model.objects.Ring;
import eg.edu.alexu.csd.oop.circus.model.objects.Shape;

public class ShapeFactory {

    public Shape createPlate(int x, int y, Color color, int fallSpeed){
        return new Plate(x, y, color, fallSpeed);
    }

    public Shape createRing(int x, int y, Color color, int fallSpeed){
        return new Ring(x, y, color, fallSpeed);
    }

    public Shape createRandomShape(int x, int y, Color color, int fallSpeed){
        if(Math.random() < 0.5){
            return createPlate(x, y, color, fallSpeed);
        }
        return createRing(x, y, color, fallSpeed);
    }
    
}

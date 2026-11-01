package eg.edu.alexu.csd.oop.circus.factory;

import java.awt.Color;

import eg.edu.alexu.csd.oop.circus.model.objects.Plate;
import eg.edu.alexu.csd.oop.circus.model.objects.Shape;

public class ShapeFactory {

    public Shape createPlate(int x, int y, Color color, int fallSpeed){
        return new Plate(x, y, color, fallSpeed);
    }
    
}

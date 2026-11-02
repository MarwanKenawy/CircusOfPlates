package eg.edu.alexu.csd.oop.circus.factory;

import java.awt.Color;

import eg.edu.alexu.csd.oop.circus.model.objects.Bomb;
import eg.edu.alexu.csd.oop.circus.model.objects.FallingObject;

public class FallingObjectFactory {
    private final ShapeFactory shapeFactory;

    public FallingObjectFactory(){
        shapeFactory = new ShapeFactory();
    }

    public FallingObject createRandomObject(int x, int y, int fallSpeed){
        if(Math.random() < 0.8){
            Color[] colors = {Color.RED, Color.BLUE, Color.GREEN, Color.YELLOW};
            Color color = colors[(int)(Math.random() * colors.length)];
            return shapeFactory.createRandomShape(x, y, color, fallSpeed);
        }

        return new Bomb(x, y, fallSpeed);
    }
}

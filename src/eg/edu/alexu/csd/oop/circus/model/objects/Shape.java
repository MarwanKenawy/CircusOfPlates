package eg.edu.alexu.csd.oop.circus.model.objects;

import java.awt.Color;
import java.awt.image.BufferedImage;

public abstract class Shape extends FallingObject {
    protected Color color;

    public Shape(int x, int y, int width, int height, BufferedImage[] spriteImages, int fallSpeed, Color color){
        super(x, y, width, height, spriteImages, fallSpeed);
        this.color = color;
    }

    public Color getColor(){
        return color;
    }
}

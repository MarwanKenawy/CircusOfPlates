package eg.edu.alexu.csd.oop.circus.model.objects;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class Clown extends AbstractGameObject {
    private static final int CLOWN_WIDTH = 80;
    private static final int CLOWN_HEIGHT = 100;

    private final ShapeStack leftStack;
    private final ShapeStack rightStack;

    public Clown(int x, int y){
        super(x, y, CLOWN_WIDTH, CLOWN_HEIGHT, createSprite());
        leftStack = new ShapeStack();
        rightStack = new ShapeStack();
    }

    @Override 
    public void setY(int y){

    }

    private static BufferedImage[] createSprite(){
        BufferedImage image = new BufferedImage(CLOWN_WIDTH, CLOWN_HEIGHT, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = image.createGraphics();

        g.setColor(Color.PINK);
        g.fillOval(20, 5, 40, 40);

        g.setColor(Color.RED);
        g.fillRect(20, 0, 40, 10);

        g.setColor(Color.BLUE);
        g.fillRect(20, 45, 40, 45);

        g.setColor(Color.BLACK);
        g.fillRect(25, 90, 10, 10);
        g.fillRect(45, 90, 10, 10);

        g.dispose();

        return new BufferedImage[] {image};
    }

    public ShapeStack getLeftStack(){
        return leftStack;
    }

    public ShapeStack getRightStack(){
        return rightStack;
    }
}

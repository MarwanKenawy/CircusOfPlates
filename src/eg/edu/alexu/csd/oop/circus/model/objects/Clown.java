package eg.edu.alexu.csd.oop.circus.model.objects;

// import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Clown extends AbstractGameObject {
    private static final int CLOWN_WIDTH = 150;
    private static final int CLOWN_HEIGHT = 176;

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
        try{
            BufferedImage original = ImageIO.read(new File("resources/images/game/clown_with_sticks.png"));
            BufferedImage image = new BufferedImage(CLOWN_WIDTH, CLOWN_HEIGHT, BufferedImage.TYPE_INT_ARGB);

            Graphics2D g = image.createGraphics();
            g.drawImage(original, 0, 0, CLOWN_WIDTH, CLOWN_HEIGHT, null);
            g.dispose();
            return new BufferedImage[] {image};
        }catch(IOException e){
            throw new RuntimeException("Could not load clown image!", e);
        }
    }

    public ShapeStack getLeftStack(){
        return leftStack;
    }

    public ShapeStack getRightStack(){
        return rightStack;
    }
}

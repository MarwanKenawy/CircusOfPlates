package eg.edu.alexu.csd.oop.circus.model.objects;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class TestObject extends AbstractGameObject {
    public TestObject(int x, int y){
        super(x, y, 100, 100, createSprite());
    }

    private static BufferedImage[] createSprite(){
        BufferedImage image = new BufferedImage(100, 100, BufferedImage.TYPE_INT_ARGB);

        Graphics2D g = image.createGraphics();

        g.setColor(Color.RED);
        g.fillRect(0, 0, 100, 100);

        g.dispose();
        return new BufferedImage[] {image};
    }
}

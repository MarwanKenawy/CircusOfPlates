package eg.edu.alexu.csd.oop.circus.model.objects;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

public class Bomb extends FallingObject {
    private static final int BOMB_SIZE = 35;

    public Bomb(int x, int y, int fallSpeed){
        super(x, y, BOMB_SIZE, BOMB_SIZE, createSprite(), fallSpeed);
    }

    private static BufferedImage[] createSprite(){
        BufferedImage image = new BufferedImage(BOMB_SIZE, BOMB_SIZE, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = image.createGraphics();

        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g.setColor(Color.ORANGE);
        g.fillOval(5, 8, 25, 25);
        
        g.setColor(Color.YELLOW);
        g.drawLine(22, 8, 28, 2);

        g.setColor(Color.RED);
        g.fillOval(26, 0, 6, 6);

        g.dispose();
        return new BufferedImage[] {image};
    }
}

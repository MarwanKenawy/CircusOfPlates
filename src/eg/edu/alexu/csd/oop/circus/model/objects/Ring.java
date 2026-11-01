package eg.edu.alexu.csd.oop.circus.model.objects;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

public class Ring extends Shape {
    private static final int RING_WIDTH = 50;
    private static final int RING_HEIGHT = 50;

    public Ring(int x, int y, Color color, int fallSpeed){
        super(x, y, RING_WIDTH, RING_WIDTH, createSprite(color), fallSpeed, color);
    }

    private static BufferedImage[] createSprite(Color color){
        BufferedImage image = new BufferedImage(RING_WIDTH, RING_HEIGHT, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = image.createGraphics();

        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g.setColor(color);
        g.setStroke(new BasicStroke(8));
        g.drawOval(6, 6, RING_WIDTH - 12, RING_HEIGHT - 12);
        g.dispose();

        return new BufferedImage[] {image};
    }
}

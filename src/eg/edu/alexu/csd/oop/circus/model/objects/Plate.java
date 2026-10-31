package eg.edu.alexu.csd.oop.circus.model.objects;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

public class Plate extends Shape {
    private static final int PLATE_WIDTH = 60;
    private static final int PLATE_HEIGHT = 20;

    public Plate(int x, int y, Color color, int fallSpeed){
        super(x, y, PLATE_WIDTH, PLATE_HEIGHT, createSprite(color), fallSpeed, color);
    }

    private static BufferedImage[] createSprite(Color color){
        BufferedImage image = new BufferedImage(PLATE_WIDTH, PLATE_HEIGHT, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = image.createGraphics();

        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g.setColor(color);
        g.fillOval(2, 2, PLATE_WIDTH - 4, PLATE_HEIGHT - 4);

        g.setColor(Color.WHITE);
        g.setStroke(new BasicStroke(2));
        g.drawOval(2, 2, PLATE_WIDTH - 4, PLATE_HEIGHT - 4);

        g.dispose();
        return new BufferedImage[] {image};
    }
}

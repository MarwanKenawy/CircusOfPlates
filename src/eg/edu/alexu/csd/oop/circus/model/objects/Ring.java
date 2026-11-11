package eg.edu.alexu.csd.oop.circus.model.objects;

// import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
// import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Ring extends Shape {
    private static final int RING_WIDTH = 50;
    private static final int RING_HEIGHT = 50;

    public Ring(int x, int y, Color color, int fallSpeed){
        super(x, y, RING_WIDTH, RING_WIDTH, createSprite(color), fallSpeed, color);
    }

    private static BufferedImage[] createSprite(Color color){
        String imagePath = "";

        if(color.equals(Color.RED)){
            imagePath = "resources/images/game/ring_red2.png";
        }else if(color.equals(Color.BLUE)){
            imagePath = "resources/images/game/ring_blue2.png";
        }else if(color.equals(Color.GREEN)){
            imagePath = "resources/images/game/ring_green2.png";
        }else if(color.equals(Color.YELLOW)){
            imagePath = "resources/images/game/ring_yellow2.png";
        }

        try {
            BufferedImage original = ImageIO.read(new File(imagePath));
            BufferedImage image = new BufferedImage(RING_WIDTH, RING_HEIGHT, BufferedImage.TYPE_INT_ARGB);

            Graphics2D g = image.createGraphics();

            g.drawImage(original, 0, 0, RING_WIDTH, RING_HEIGHT, null);

            g.dispose();
            return new BufferedImage[] {image};
        } catch (IOException e) {
            throw new RuntimeException("Could not load ring image: " + imagePath, e);
        }
        // BufferedImage image = new BufferedImage(RING_WIDTH, RING_HEIGHT, BufferedImage.TYPE_INT_ARGB);
        // Graphics2D g = image.createGraphics();

        // g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // g.setColor(color);
        // g.setStroke(new BasicStroke(8));
        // g.drawOval(6, 6, RING_WIDTH - 12, RING_HEIGHT - 12);
        // g.dispose();

        // return new BufferedImage[] {image};
    }
}

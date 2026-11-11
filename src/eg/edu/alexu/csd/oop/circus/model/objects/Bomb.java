package eg.edu.alexu.csd.oop.circus.model.objects;

// import java.awt.Color;
import java.awt.Graphics2D;
// import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Bomb extends FallingObject {
    private static final int BOMB_SIZE = 35;

    public Bomb(int x, int y, int fallSpeed){
        super(x, y, BOMB_SIZE, BOMB_SIZE, createSprite(), fallSpeed);
    }

    private static BufferedImage[] createSprite(){
        int bombNumber = (int)(Math.random() * 4) + 1;
        String imagePath = "resources/images/game/bomb_" + bombNumber + ".png";
        try {
            BufferedImage original = ImageIO.read(new File(imagePath));
            BufferedImage image = new BufferedImage(BOMB_SIZE, BOMB_SIZE, BufferedImage.TYPE_INT_ARGB);

            Graphics2D g = image.createGraphics();

            g.drawImage(original, 0, 0, BOMB_SIZE, BOMB_SIZE, null);

            g.dispose();
            return new BufferedImage[] {image};
        } catch (IOException e) {
            throw new RuntimeException("Could not load bomb image: " + imagePath, e);
        }
        // BufferedImage image = new BufferedImage(BOMB_SIZE, BOMB_SIZE, BufferedImage.TYPE_INT_ARGB);
        // Graphics2D g = image.createGraphics();

        // g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // g.setColor(Color.ORANGE);
        // g.fillOval(5, 8, 25, 25);
        
        // g.setColor(Color.YELLOW);
        // g.drawLine(22, 8, 28, 2);

        // g.setColor(Color.RED);
        // g.fillOval(26, 0, 6, 6);

        // g.dispose();
        // return new BufferedImage[] {image};
    }
}

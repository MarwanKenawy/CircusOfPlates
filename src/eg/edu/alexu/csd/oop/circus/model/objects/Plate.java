package eg.edu.alexu.csd.oop.circus.model.objects;

// import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
// import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Plate extends Shape {
    private static final int PLATE_WIDTH = 60;
    private static final int PLATE_HEIGHT = 20;

    public Plate(int x, int y, Color color, int fallSpeed){
        super(x, y, PLATE_WIDTH, PLATE_HEIGHT, createSprite(color), fallSpeed, color);
    }

    private static BufferedImage[] createSprite(Color color){
        try{
            BufferedImage original = ImageIO.read(new File("resources/images/game/plate_blue_front.png"));
            BufferedImage image = new BufferedImage(PLATE_WIDTH, PLATE_HEIGHT, BufferedImage.TYPE_INT_ARGB);
            Graphics2D g = image.createGraphics();

            g.drawImage(original, 0, 0, PLATE_WIDTH, PLATE_HEIGHT, null);

            g.dispose();

            for(int x = 0; x < image.getWidth(); x++){
                for(int y = 0; y < image.getHeight(); y++){
                    Color pixel = new Color(image.getRGB(x, y), true);
                    if(pixel.getAlpha() == 0){
                        continue;
                    }

                    float brightness = Math.max(pixel.getRed(), Math.max(pixel.getGreen(), pixel.getBlue())) / 255.0f;
                    int red = Math.min(255, Math.round(color.getRed() * brightness));
                    int green = Math.min(255, Math.round(color.getGreen() * brightness));
                    int blue = Math.min(255, Math.round(color.getBlue() * brightness));

                    Color newPixel = new Color(
                        red,
                        green,
                        blue,
                        pixel.getAlpha()
                    );

                    image.setRGB(x, y, newPixel.getRGB());
                }
            }
            return new BufferedImage[] {image};
        }catch(IOException e){
            throw new RuntimeException("Could not load plate image!", e);
        }
        // BufferedImage image = new BufferedImage(PLATE_WIDTH, PLATE_HEIGHT, BufferedImage.TYPE_INT_ARGB);
        // Graphics2D g = image.createGraphics();

        // g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // g.setColor(color);
        // g.fillOval(2, 2, PLATE_WIDTH - 4, PLATE_HEIGHT - 4);

        // g.setColor(Color.WHITE);
        // g.setStroke(new BasicStroke(2));
        // g.drawOval(2, 2, PLATE_WIDTH - 4, PLATE_HEIGHT - 4);

        // g.dispose();
        // return new BufferedImage[] {image};
    }
}

package eg.edu.alexu.csd.oop.circus.model.objects;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import eg.edu.alexu.csd.oop.game.GameObject;

public class Background implements GameObject {
    private final int x;
    private final int y;
    private final int width;
    private final int height;
    private final BufferedImage image;

    public Background(int width, int height){
        this.x = 0;
        this.y = 0;
        this.width = width;
        this.height = height;
        try{
            BufferedImage original = ImageIO.read(new File("resources/images/game/circus_game_background.png"));

            image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

            java.awt.Graphics2D g2 = image.createGraphics();
            g2.drawImage(original, 0, 0, width, height, null);
            g2.dispose();
        }catch(IOException e){
            throw new RuntimeException("Could not load circus background!", e);
        }
    }

    @Override 
    public int getX(){
        return x;
    }

    @Override 
    public void setX(int x){
    }

    @Override 
    public int getY(){
        return y;
    }

    @Override 
    public void setY(int y){
    }

    @Override 
    public int getWidth(){
        return width;
    }

    @Override 
    public int getHeight(){
        return height;
    }

    @Override 
    public boolean isVisible(){
        return true;
    }

    @Override 
    public BufferedImage[] getSpriteImages(){
        return new BufferedImage[] {image};
    }
}

package eg.edu.alexu.csd.oop.circus.model.objects;

import java.awt.image.BufferedImage;

public abstract class FallingObject extends AbstractGameObject {
    protected int fallSpeed;
    
    public FallingObject(int x, int y, int width, int height, BufferedImage[] spriteImages, int fallSpeed){
        super(x, y, width, height, spriteImages);
        this.fallSpeed = fallSpeed;
    }

    public int getFallSpeed(){
        return fallSpeed;
    }

    public void setFallSpeed(int fallSpeed){
        this.fallSpeed = fallSpeed;
    }

    public void fall(){
        setY(getY() + fallSpeed);
    }
}

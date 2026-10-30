package eg.edu.alexu.csd.oop.circus.model.objects;

import java.awt.image.BufferedImage;

import eg.edu.alexu.csd.oop.game.GameObject;

public abstract class AbstractGameObject implements GameObject {
    protected int x;
    protected int y;
    protected int width;
    protected int height;
    protected boolean visible;
    protected BufferedImage[] spriteImages;

    public AbstractGameObject(int x, int y, int width, int height, BufferedImage[] spriteImages){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.spriteImages = spriteImages;
    }

    @Override 
    public int getX(){
        return x;
    }

    @Override 
    public void setX(int x){
        this.x = x;
    }

    @Override 
    public int getY(){
        return y;
    }

    @Override 
    public void setY(int y){
        this.y = y;
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
        return visible;
    }

    @Override 
    public java.awt.image.BufferedImage[] getSpriteImages(){
        return spriteImages;
    }
}

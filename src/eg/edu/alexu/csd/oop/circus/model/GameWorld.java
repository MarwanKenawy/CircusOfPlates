package eg.edu.alexu.csd.oop.circus.model;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import eg.edu.alexu.csd.oop.game.GameObject;
import eg.edu.alexu.csd.oop.game.World;
// import eg.edu.alexu.csd.oop.circus.model.objects.TestObject;
import eg.edu.alexu.csd.oop.circus.model.objects.Clown;
import eg.edu.alexu.csd.oop.circus.model.objects.FallingObject;
import eg.edu.alexu.csd.oop.circus.model.objects.Plate;
import eg.edu.alexu.csd.oop.circus.model.objects.Shape;

public class GameWorld implements World{
    private final int width; 
    private final int height;
    
    private final List<GameObject> constantObjects;
    private final List<GameObject> movableObjects;
    private final List<GameObject> controllableObjects;

    private final Clown clown;

    public GameWorld(int width, int height){
        this.width = width;
        this.height = height;

        constantObjects = new ArrayList<>();
        movableObjects = new ArrayList<>();
        controllableObjects = new ArrayList<>();

        // constantObjects.add(new TestObject(350, 250));
        clown = new Clown(width / 2 - 40, height - 120);
        controllableObjects.add(clown);
        movableObjects.add(new Plate(width / 2 - 30, 0, Color.RED, 2));
    }

    @Override 
    public List<GameObject> getConstantObjects(){
        return constantObjects;
    }

    @Override 
    public List<GameObject> getMovableObjects(){
        return movableObjects;
    }

    @Override 
    public List<GameObject> getControlableObjects(){
        return controllableObjects;
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
    public boolean refresh(){
        for(int i = movableObjects.size() - 1; i >= 0; i--){
            GameObject object = movableObjects.get(i);
            if(object instanceof FallingObject){
                FallingObject fallingObject = (FallingObject)object;
                fallingObject.fall();
                if(fallingObject instanceof Shape && intersects(fallingObject, clown)){
                    Shape shape = (Shape)fallingObject;
                    catchShape(shape);
                    movableObjects.remove(i);
                    continue;
                }
                if(fallingObject.getY() > height){
                    movableObjects.remove(i);
                }
            }
        }
        return true;
    }

    @Override 
    public String getStatus(){
        return "Circus of Plates | Score : 0";
    }
    
    @Override 
    public int getSpeed(){
        return 10;
    }

    @Override 
    public int getControlSpeed(){
        return 10;
    }

    private boolean intersects(GameObject first, GameObject second){
        return first.getX() < second.getX() + second.getWidth() && first.getX() + first.getWidth() > second.getX() && first.getY() < second.getY() + second.getHeight() && first.getY() + first.getHeight() > second.getY();
    }

    private void catchShape(Shape shape){
        int clownCenter = clown.getX() + clown.getWidth() / 2;
        int shapeCenter = shape.getX() + shape.getWidth() / 2;

        if(shapeCenter < clownCenter){
            clown.getLeftStack().push(shape);
        }else{
            clown.getRightStack().push(shape);
        }
    }
}
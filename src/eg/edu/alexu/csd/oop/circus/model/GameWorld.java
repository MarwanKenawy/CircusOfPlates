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
import eg.edu.alexu.csd.oop.circus.model.objects.ShapeStack;

public class GameWorld implements World{
    private static final int STACK_OFFSET = 10;
    private static final int SPAWN_INTERVAL = 100;

    private final int width; 
    private final int height;
    private int refreshCount = 0;
    private int score = 0;

    
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
        // movableObjects.add(new Plate(width / 2 - 30, 0, Color.RED, 2));
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
        updateStackPositions();
        refreshCount++;
        if(refreshCount % SPAWN_INTERVAL == 0){
            spawnPlate();
        }
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
        return "Score: " + score;
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

        boolean isLeftStack = shapeCenter < clownCenter;

        if(isLeftStack){
            clown.getLeftStack().push(shape);
        }else{
            clown.getRightStack().push(shape);
        }

        positionShapeOnStack(shape, isLeftStack);
        controllableObjects.add(shape);
        checkForMatch(isLeftStack);
    }

    private void positionShapeOnStack(Shape shape, boolean leftStack){
        int stackSize;
        if(leftStack){
            stackSize = clown.getLeftStack().size();
            shape.setX(clown.getX() - shape.getWidth() + STACK_OFFSET);
        }else{
            stackSize = clown.getRightStack().size();
            shape.setX(clown.getX() + shape.getWidth() - STACK_OFFSET);
        }
        shape.setY(clown.getY() - (stackSize * shape.getHeight()));
    }

    private void updateStackPositions(){
        for(int i = 0; i < clown.getLeftStack().size(); i++){
            Shape shape = clown.getLeftStack().get(i);
            shape.setX(clown.getX() - shape.getWidth() + STACK_OFFSET);
            shape.setY(clown.getY() - ((i + 1) * shape.getHeight()));
        }
        for(int i = 0; i < clown.getRightStack().size(); i++){
            Shape shape = clown.getRightStack().get(i);
            shape.setX(clown.getX() + shape.getWidth() - STACK_OFFSET);
            shape.setY(clown.getY() - ((i + 1) * shape.getHeight()));
        }
    }

    private void spawnPlate(){
        Color[] colors = {Color.RED, Color.BLUE, Color.GREEN, Color.YELLOW};
        Color color = colors[(int)(Math.random() * colors.length)];
        int x = (int)(Math.random() * (width - 60));
        movableObjects.add(new Plate(x, 0, color, 2));
    }

    private void checkForMatch(boolean leftStack){
        ShapeStack stack;

        if(leftStack){
            stack = clown.getLeftStack();
        }else{
            stack = clown.getRightStack();
        }

        if(stack.hasThreeMatchingColors()){
            List<Shape> removedShapes = stack.removeTopThree();
            controllableObjects.removeAll(removedShapes);
            score++;
        }
    }
}
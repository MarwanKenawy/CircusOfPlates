package eg.edu.alexu.csd.oop.circus.model;

import java.util.ArrayList;
import java.util.List;

import eg.edu.alexu.csd.oop.game.GameObject;
import eg.edu.alexu.csd.oop.game.World;

public class GameWorld implements World{
    private final int width; 
    private final int height;
    
    private final List<GameObject> constantObjects;
    private final List<GameObject> movableObjects;
    private final List<GameObject> controllableObjects;

    public GameWorld(int width, int height){
        this.width = width;
        this.height = height;

        constantObjects = new ArrayList<>();
        movableObjects = new ArrayList<>();
        controllableObjects = new ArrayList<>();
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
}
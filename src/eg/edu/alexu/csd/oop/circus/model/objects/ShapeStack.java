package eg.edu.alexu.csd.oop.circus.model.objects;

import java.util.ArrayList;
import java.util.List;

public class ShapeStack {
    private final List<Shape> shapes;

    public ShapeStack(){
        shapes = new ArrayList<>();
    }

    public void push(Shape shape){
        shapes.add(shape);
    }

    public Shape pop(){
        if(shapes.isEmpty()){
            return null;
        }
        return shapes.remove(shapes.size() - 1);
    }

    public Shape peek(){
        if(shapes.isEmpty()){
            return null;
        }
        return shapes.get(shapes.size() - 1);
    }

    public int size(){
        return shapes.size();
    }

    public boolean isEmpty(){
        return shapes.isEmpty();
    }
}

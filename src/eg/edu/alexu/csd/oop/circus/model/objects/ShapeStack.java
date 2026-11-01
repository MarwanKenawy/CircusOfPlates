package eg.edu.alexu.csd.oop.circus.model.objects;

import java.util.ArrayList;
import java.util.List;

public class ShapeStack {
    private final List<Shape> shapes;

    public ShapeStack(){
        shapes = new ArrayList<>();
    }

    public Shape get(int index){
        return shapes.get(index);
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

    public boolean hasThreeMatchingColors(){
        if(shapes.size() < 3){
            return false;
        }

        int size = shapes.size();

        Shape first = shapes.get(size - 1);
        Shape second = shapes.get(size - 2);
        Shape third = shapes.get(size - 3);

        return first.getColor().equals(second.getColor()) && second.getColor().equals(third.getColor());
    }

    public List<Shape> removeTopThree(){
        List<Shape> removed = new ArrayList<>();

        if(!hasThreeMatchingColors()){
            return removed;
        }

        removed.add(pop());
        removed.add(pop());
        removed.add(pop());

        return removed;
    }
}

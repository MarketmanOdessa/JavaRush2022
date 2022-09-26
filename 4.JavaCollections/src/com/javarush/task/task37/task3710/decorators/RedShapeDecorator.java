package com.javarush.task.task37.task3710.decorators;

import com.javarush.task.task37.task3710.shapes.Shape;

public class RedShapeDecorator extends ShapeDecorator {
  //  protected Shape sh;
    private void setBorderColor(Shape s) {
        System.out.println("Setting the border color for " + s.getClass().getSimpleName() + " to red.");
    }

    public RedShapeDecorator(Shape decoratedShape) {
        super(decoratedShape);
    }

    @Override
    public void draw() {
        setBorderColor(decoratedShape);
        super.draw();
    }
}

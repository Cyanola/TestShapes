package com.example.testshapes.Models;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;

import java.awt.Point;
import java.util.Random;

public class Triangle extends Shape {
    @Override
    public void setXY(double x, double y) {
        this.x=x;
        this.y=y;
    }
    @Override
    public void setLineBorder(int lineBorder) {
        this.lineBorder = lineBorder;
    }
    @Override
    public void setColorBorder(Color colorBorder) {
        this.colorBorder = colorBorder;
    }
    @Override
    public void setColorFill(Color colorFill) {
        this.colorFill = colorFill;
    }
    public Triangle(int lineBorder, Color colorBorder, Color colorFill, double x, double y) {
        super(lineBorder, colorBorder, colorFill, x, y);
    }

    @Override
    public void draw(Canvas canvas,GraphicsContext gc,double x, double y, int Borderline, Color Border, Color Fill ) {
        //Start the Path

        gc.beginPath();

// Make different Paths
        setColorBorder(Border);
        setColorFill(Fill);
        setLineBorder(Borderline);
        setXY(x,y);
        gc.setStroke(colorBorder);
        gc.setLineWidth(lineBorder);

        gc.setFill(colorFill);
        gc.moveTo(x, y);

        gc.lineTo(x-25 , y+50);

        gc.lineTo(x+25 , y+50);


        gc.lineTo(x,y);

        gc.fill();
        gc.stroke();


//// End the Path

        gc.closePath();

   triangle=new Polygon();
        triangle.getPoints().addAll(x,y, x-25 , y+50, x+25 , y+50);

    }
    Polygon triangle;
    @Override
    public String toString()
    {
        return "Треугольник";
    }

    @Override
    public boolean contains(double x, double y) {
        return triangle.contains(x,y);
    }

    @Override
    void setWidth(double value) {
        width = value;
    }

    @Override
    double getWidth() {
        return width;
    }
    @Override
    void setHeight(double value) {
        height = value;
    }

    @Override
    double getHeight() {
        return height;
    }
    public Triangle(){
        super();
        type = "Треугольник";
    }
    @Override
    public String descriptor() {
        return "Треугольник" + " "+super.getX()+" "+super.getY()+" "+super.getLineBorder()+" "+super.getColorBorder().toString()+" "+super.getColorFill().toString();
    }

}
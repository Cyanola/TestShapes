package com.example.testshapes.Models;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Circle extends Shape {
    @Override
    public void setXY(double x, double y) {
        this.x=x;
        this.y=y;
    }

    public Circle(int lineBorder, Color colorBorder, Color colorFill, double x, double y) {
        super(lineBorder, colorBorder, colorFill, x, y);
        this.width=35;
        this.height=35;
    }

    @Override
    void setHeight(double value) {
        super.height = value;
    }

    @Override
    double getHeight() {
        return super.height;
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
    public void draw(Canvas canvas,GraphicsContext gr,double x, double y, int Borderline, Color Border, Color Fill) {

        setColorBorder(Border);
        setColorFill(Fill);
        setLineBorder(Borderline);
        setXY(x,y);
        gr.setStroke(colorBorder);
        gr.setLineWidth(lineBorder);
        gr.setFill(colorFill);
        gr.strokeOval(this.x - (height/2), this.y - (width/2), width, height);
        gr.setFill(colorFill);
        gr.fillOval(this.x - (height/2), this.y - (width/2), width, height);
    }
    public Circle(){
        super();
        type = "Круг";
        this.width=35;
        this.height=35;
    }

    @Override
    public  String descriptor() {
        return "Круг"+" " + super.getX()+" "+super.getY()+" "+super.getLineBorder()+" "+super.getColorBorder().toString()+" "+super.getColorFill().toString();
    }
    @Override
    public String toString()
    {
        return "Круг";
    }

    @Override
   public boolean contains(double x, double y) {
    return    Math.pow(x - this.x, 2) + Math.pow(y - this.y, 2) <= Math.pow(width/2.0, 2);
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
}
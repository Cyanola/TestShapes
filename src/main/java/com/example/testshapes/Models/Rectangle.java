package com.example.testshapes.Models;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Rectangle extends Shape {
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
    public Rectangle(int lineBorder, Color colorBorder, Color colorFill, double x, double y) {
        super(lineBorder, colorBorder, colorFill, x, y);
        this.width = 35;
        this.height=35;
    }

    @Override
    public void draw(Canvas canvas, GraphicsContext gr,double x, double y, int Borderline, Color Border, Color Fill) {
        setColorBorder(Border);
        setColorFill(Fill);
        setLineBorder(Borderline);
        setXY(x,y);
        gr.setStroke(colorBorder);
        gr.setLineWidth(lineBorder);
        gr.setFill(colorFill);

        gr.strokeRect(this.x - (width/2), this.y - (height/2), width, height);
        gr.setFill(colorFill);
        gr.fillRect(this.x - (width/2), this.y - (height/2), width, height);
    }
    //
    @Override
    public String toString()
    {
        return "Квадрат";
    }

    @Override
  public   boolean contains(double x, double y) {
        return (x >= this.x && x <= (this.x + width) &&
                y >= this.y && y <= (this.y + height));
    }


    @Override
    void setHeight(double value) {
        height = value;
    }

    @Override
    double getHeight() {
        return height;
    }

    @Override
    void setWidth(double value) {
        width = value;
    }
    public Rectangle(){
        super();
        type = "Квадрат";
        this.width = 35;
        this.height=35;
    }
    @Override
    double getWidth() {
        return width;
    }
    @Override
    public String descriptor() {
        return "Квадрат" +" " + super.getX()+" "+super.getY()+" "+super.getLineBorder()+" "+super.getColorBorder().toString()+" "+super.getColorFill().toString();
    }
}
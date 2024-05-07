package com.example.testshapes.Models;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;



public abstract class Shape implements Cloneable {

    protected int lineBorder;
    protected Color colorBorder;
    protected Color colorFill;
    protected double x, y;

    public double getX() {
        return x;
    }
    public abstract void setXY(double x, double y);

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public Shape(int lineBorder, Color colorBorder, Color colorFill, double x, double y) {
        this.lineBorder = lineBorder;
        this.colorBorder = colorBorder;
        this.colorFill = colorFill;
        this.x = x;
        this.y = y;
    }


    public double height;
    public double width;
    abstract void setHeight(double value);
    abstract double getHeight();
    abstract void setWidth(double value);
    abstract double getWidth();

    public abstract void draw(Canvas canvas,  GraphicsContext gr,double x, double y, int lineBorder, Color Border, Color Fill);
    public abstract String descriptor();
    protected String type;
    public Shape(){

    }
    public double getLineBorder() {
        return lineBorder;
    }
    public abstract void setLineBorder(int LineBorder);
    public abstract void setColorBorder(Color colorBorder);
    public abstract void setColorFill(Color colorFill);



    public Color getColorBorder() {
        return colorBorder;
    }



    public Color getColorFill() {
        return colorFill;
    }


    public abstract String toString();


    @Override
    public Object clone() {
        Object clone = null;

        try {

            clone = super.clone();

        } catch (CloneNotSupportedException e) {

            e.printStackTrace();   }

        return clone; }


    public abstract boolean contains(double x, double y) ;


}
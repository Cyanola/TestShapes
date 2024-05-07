package com.example.testshapes.Test;
import com.example.testshapes.Models.Circle;
import com.example.testshapes.Models.Shape;
import javafx.scene.paint.Color;
import java.util.ArrayList;

import java.util.List;
import java.util.Random;

public class TestHighlightCircle {
//    private Shape figure;
//    private Color originalFill;
//    private Color highlightedFill;
//    private Color originalBorderFill;
//    private Color highlightedBorderFill;
//
//    public TestHighlightCircle(Shape figure) {
//
////        this.figure = figure;
////        this.originalFill = figure.getColorFill();
////        this.highlightedFill = Color.YELLOW;
////        this.originalBorderFill = figure.getColorBorder();
////        this.highlightedBorderFill = Color.YELLOW;
//
////        canvas.setOnMouseEntered(enteredHandler);
////        canvas.setOnMouseExited(exitedHandler);
//    }
//
//    private void enteredHandler() {
//        figure.setColorFill(highlightedFill);
//        figure.setColorBorder(highlightedBorderFill);
//    }
//
//    ;
//
//    // Метод для установки цвета выделения
//    public void setHighlightedFill(Color color1, Color color2) {
//        this.highlightedFill = color1;
//        this.highlightedBorderFill = color2;
//    }
Random rnd =new Random();
    public static void main(String[] args) {
        double x=200, y=200;
        List<List<Shape>>shapes=generate(x,y);
        List<Shape> tests = shapes.get(0);
     //   solve(tests);,
        check(shapes,solve(tests,x,y));
    }

    public static List<List<Shape>> generate(double x, double y) {
        List<List<Shape>> lists = new ArrayList<>();

        List<Shape> testCases = new ArrayList<>();

        List<Shape> testSelecteds = new ArrayList<>();

        // Тесты для закрашивания объекта
        testCases.add(new Circle(9, Color.CORAL, Color.BLACK, 50, 90));
        testSelecteds.add(new Circle(9, Color.YELLOW, Color.YELLOW, x, y));

        testCases.add(new Circle(9, Color.CORAL, Color.BLACK, 98, 90));
//        testSelecteds.add(new Circle(9, Color.YELLOW, Color.YELLOW, x, y));

        testCases.add(new Circle(9, Color.MISTYROSE, Color.BLACK, 59, 91));
//        testSelecteds.add(new Circle(9, Color.YELLOW, Color.YELLOW, x, y));

        testCases.add(new Circle(9, Color.SIENNA, Color.BISQUE, 99, 81));
//        testSelecteds.add(new Circle(9, Color.YELLOW, Color.YELLOW, x, y));

        testCases.add(new Circle(9, Color.BLUE, Color.SILVER, 350, 390));



        testCases.add(new Circle(9, Color.BLUE, Color.SILVER, 99, 390));
        testCases.add(new Circle(9, Color.BLUE, Color.SILVER, 250, 99));
        testCases.add(new Circle(9, Color.BLUE, Color.SILVER, 100, 150));
        testCases.add(new Circle(9, Color.BLUE, Color.SILVER, 90, 103));
        testCases.add(new Circle(9, Color.BLUE, Color.SILVER, 87, 12));
        testCases.add(new Circle(9, Color.BLUE, Color.SILVER, 369, 12));
        testCases.add(new Circle(9, Color.BLUE, Color.SILVER, 23, 51));
        testCases.add(new Circle(9, Color.BLUE, Color.SILVER, 246, 410));
        testCases.add(new Circle(9, Color.BLUE, Color.SILVER, 91, 3));
        testCases.add(new Circle(9, Color.BLUE, Color.SILVER, 152, 39));
        testCases.add(new Circle(9, Color.BLUE, Color.SILVER, 35, 69));

        testCases.add(new Circle(9, Color.BLUE, Color.SILVER, 12, 12));
        testCases.add(new Circle(9, Color.BLUE, Color.SILVER, 23, 123));
        testCases.add(new Circle(9, Color.BLUE, Color.SILVER, 405, 410));
        testCases.add(new Circle(9, Color.BLUE, Color.SILVER, 455, 601));
        testCases.add(new Circle(9, Color.BLUE, Color.SILVER, 125, 89));
        testCases.add(new Circle(9, Color.BLUE, Color.SILVER, 123, 501));

        testCases.add(new Circle(9, Color.BLUE, Color.SILVER, 350, 390));
        testSelecteds.add(new Circle(9, Color.YELLOW, Color.YELLOW, x, y));

        testCases.add(new Circle(9, Color.BLUE, Color.SILVER, 350, 390));
        testSelecteds.add(new Circle(9, Color.YELLOW, Color.YELLOW, x, y));

        testCases.add(new Circle(9, Color.BLUE, Color.SILVER, 350, 390));
        testSelecteds.add(new Circle(9, Color.YELLOW, Color.YELLOW, x, y));

        testCases.add(new Circle(9, Color.BLUE, Color.SILVER, 350, 390));
        testSelecteds.add(new Circle(9, Color.YELLOW, Color.YELLOW, x, y));

        testCases.add(new Circle(9, Color.BLUE, Color.SILVER, 350, 390));
        testSelecteds.add(new Circle(9, Color.YELLOW, Color.YELLOW, x, y));

        testCases.add(new Circle(9, Color.BLUE, Color.SILVER, 350, 390));
        testSelecteds.add(new Circle(9, Color.YELLOW, Color.YELLOW, x, y));

        testCases.add(new Circle(9, Color.BLUE, Color.SILVER, 350, 390));
        testSelecteds.add(new Circle(9, Color.YELLOW, Color.YELLOW, x, y));

        testCases.add(new Circle(9, Color.BLUE, Color.SILVER, 350, 390));
        testSelecteds.add(new Circle(9, Color.YELLOW, Color.YELLOW, x, y));


        // return new ObservableList<Shape>((Shape[]) testCases.toArray(), (Shape[]) testSelecteds.toArray());

        lists.add(testCases);
        lists.add(testSelecteds);
        return lists;
        }
      //  return (ObservableList<Shape>) new ListPair<>(testCases, testSelecteds);

    public static List <Shape> solve(List<Shape> tests,double x, double y) {
        // Реализация эталонного решения
        ArrayList<Shape> s=new ArrayList<>();
        for (Shape test : tests) {
            if(test.contains(x, y)) {
              //  Shape point = new Circle((int) test.getLineBorder(), test.getColorBorder(), test.getColorFill(), test.getX(), test.getY());

                int index = tests.indexOf(test);
                Shape sh = (Shape) tests.get(index).clone();
                System.out.println(sh.descriptor());
                sh.setColorBorder(Color.YELLOW);
                sh.setColorFill(Color.YELLOW);
                if(!s.contains(sh)) {
                    s.add(sh);
                }
                System.out.println("Фигура окрасилась");
                System.out.println(sh.descriptor());
                System.out.println("\n\n\n");
            }
        }
        return s;
    }
static boolean check=false;
    public static void check(List<List<Shape>> tests, List<Shape> s) {
        // Проверка результатов

        if(!s.isEmpty()) {
            System.out.println("Дескриптор решения: " + "\t\t\t\t\t\t\t" + "Выбранная фигура");
            for (Shape test : s) {
                Shape point = new Circle((int) test.getLineBorder(), test.getColorBorder(), test.getColorFill(), test.getX(), test.getY());
                for (Shape testSelected : tests.get(1)) {
                    // Сравнение результатов с ожидаемыми значениями
                    if (point.getColorBorder().equals(testSelected.getColorBorder()) && point.getColorFill().equals(testSelected.getColorFill())
                            && point.contains(testSelected.getX(), testSelected.getY())) {
//                   if(!list.containsKey(test)&& !list.containsValue(point)&&!list.containsKey(point)&& !list.containsValue(test)) {
//                       list.put(test,point);

                        System.out.println("Test PASSED: " + point.descriptor() + "\t" + testSelected.descriptor());
                        break;


                    } else {
                        System.out.println("Test FAILED: " + point.descriptor() + "\t" + testSelected.descriptor());
                    }
                }
            }
        }else
        {
            System.out.println("Test FAILED");
        }
    }

}
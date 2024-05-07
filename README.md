# Задача 5
## Условие задачи
> [!NOTE]
> При наведении курсора на фигуру закрашивать ее желтым цветом:

![Задача](src/main/resources/com/example/testshapes/Images/task.png)

> [!IMPORTANT]
> Реализация класса-теста `TestHighlightCircle`:

```java
package com.example.testshapes.Test;
import com.example.testshapes.Models.Circle;
import com.example.testshapes.Models.Shape;
import javafx.scene.paint.Color;
import java.util.ArrayList;

import java.util.List;
import java.util.Random;

public class TestHighlightCircle {

Random rnd =new Random();
    public static void main(String[] args) {
        double x=200, y=200;
        List<List<Shape>>shapes=generate(x,y);
        List<Shape> tests = shapes.get(0);
  
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
        testCases.add(new Circle(9, Color.MISTYROSE, Color.BLACK, 59, 91));
        testCases.add(new Circle(9, Color.SIENNA, Color.BISQUE, 99, 81));
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

        lists.add(testCases);
        lists.add(testSelecteds);
        return lists;
        }

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
```
> [__Содержимое класса контроллера__](src/main/java/com/example/testshapes/HelloController.java) `HelloController`

> [__Содержимое класса приложения__](src/main/java/com/example/testshapes/HelloApplication.java) `HelloApplication`

- [__Реализация клаcса__](src/main/java/Models/Shape.java) `Shape`
- [__Реализация класcа__](src/main/java/Models/Circle.java) `Circle`
- [__Реализация клаcса__](src/main/java/Models/Rectangle.java) `Rectangle`
- - [__Реализация клаcса__](src/main/java/Models/Triangle.java) `Triangle`

> [!NOTE]
> Проверка теста:
Зададим координаты курсора:
```java
double x=200, y=200;
```
Создадим списки фигур - один список содержит все фигуры, другой список содержит 1 фигуру - ту, которая "закрасится" при наведении на нее курсора мыши(то есть она содержит заданные "координаты курсора" x и y
```java
        List<List<Shape>>shapes=generate(x,y);
```
Получим список всех фигур и используя метод contains() пройдем по списку, в случае успеха что какая-либо фигура содержит "координаты курсора" выведется сообщение, что "фигура окрасилась" и вернется список фигур, которые мог "задеть" курсор
```java
        List<Shape> tests = shapes.get(0);

      solve(tests);,
```
Если ни одна из фигур не содержит координат курсора, то solve() вернет пустой список, соотвественно, тест будет FAILED
В ином случае, если "задетая курсором" фигура совпадает с фигурой, которую нашли в решении, то тест будет PASSED.
```java
        check(shapes,solve(tests,x,y));
```
В текущем примере, объект Circle имеет заданную по умолчанию ширину=высоту=35, а координаты центра круга x=200 и y=200;
что не попадает ни в один заданный testCase, соотвественно тест будет провален.
![Выполнение теста](src/main/resources/com/example/testshapes/Images/img.png)
![Выполнение задачи](src/main/resources/com/example/testshapes/Images/ezgif-2-925520e0cb.gif)


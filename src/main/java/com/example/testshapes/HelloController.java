package com.example.testshapes;
import com.example.testshapes.Models.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

import javax.swing.event.ChangeEvent;

import java.net.URL;
import java.util.*;

public class HelloController implements Initializable {
    @FXML
    RadioButton toChoice;
    @FXML
    RadioButton toDraw;
    @FXML
    private Label label;
    @FXML
    Button effects;
    @FXML
    Button clear;
    @FXML
    ColorPicker colorpickerFill;
    @FXML
    ColorPicker colorpickerBorder;
    @FXML
    Canvas canvas;
    @FXML
    ListView listView;
    @FXML
    ListView view;
    @FXML
    TextField lineWidth;
    private ObservableList<Shape> content;
    private List<Shape> shapes;
    private List<Shape> selectedShapes;

    @FXML
    public void onClear2()
    {
for(Object shape :view.getItems().stream().toList()) {
    for (Shape s : shapes) {
if(shape==s.descriptor() ){
           s.draw(canvas, gc, s.getX(), s.getY(), (int)s.getLineBorder(),
                s.getColorBorder(), s.getColorFill());
}
}
    }
        selectedShapes.clear();
        view.getItems().clear();
    }
    HashMap<String,String> descriptors;
    @FXML
    public void onDelete()
    {
        for (Map.Entry<String, String> entry : descriptors.entrySet()) {
            if(Objects.equals(view.getItems().get
                    (view.getSelectionModel().getSelectedIndex()).toString(),entry.getKey()))
            {

                for (Shape hp :shapes) {
                    if(Objects.equals(hp.descriptor(), entry.getKey())) {
                        hp.draw(canvas, gc, hp.getX(), hp.getY(), (int) hp.getLineBorder(),
                                hp.getColorBorder(), hp.getColorFill());
                    }
                }
                selectedShapes.removeIf(hp -> Objects.equals(hp.descriptor(), entry.getValue()));

            }
        }
        view.getItems().remove(view.getSelectionModel().getSelectedIndex());


    }
    @FXML
    public void onClear()
    {
shapes.clear();
selectedShapes.clear();
view.getItems().clear();
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        descriptors.clear();
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        shapes = new ArrayList<>();
        descriptors=new HashMap<>();
        selectedShapes = new ArrayList<>();
        Rectangle square =new Rectangle();
        ToggleGroup group = new ToggleGroup();
        // установка группы
        toDraw.setToggleGroup(group);
        toChoice.setToggleGroup(group);


        Circle circle=new Circle();


        Triangle triangle=new Triangle();

        content = FXCollections.observableArrayList (circle,square,triangle);

        listView.setItems(content);

        listView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
       view.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        gc = canvas.getGraphicsContext2D();
        canvas.setOnMouseMoved(event -> highlightShapes(event));
        view.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {

            }
        });

    }
    private void highlightShapes(MouseEvent event) {
        if(toChoice.isSelected()) {
            selectedShapes.clear();
            for (Shape shape : shapes) {
                if (shape.contains(event.getX(), event.getY())) {
                    int index = shapes.indexOf(shape);
                    Shape sh = (Shape) shapes.get(index).clone();
descriptors.put(shape.descriptor(),sh.descriptor());
                    sh.setColorFill(Color.YELLOW);
                    sh.setColorBorder(Color.YELLOW);
                    if(!selectedShapes.contains(sh)) {
                        selectedShapes.add(sh);
                    }
                    sh.draw(canvas, gc, sh.getX(), sh.getY(), (int)sh.getLineBorder(),
                    sh.getColorBorder(),sh.getColorFill());
                    if(!view.getItems().contains(sh.descriptor())) {
                       view.getItems().add(sh.descriptor());
                   }
                }
            }
        }
    }
    GraphicsContext gc;
    @FXML
    public void drawShape(MouseEvent mouseEvent) {
     if(toDraw.isSelected()) {
         int index = listView.getSelectionModel().getSelectedIndex();

         Shape shape = (Shape) content.get(index).clone();

         shape.setColorFill(colorpickerFill.getValue());

         shape.draw(canvas, gc, mouseEvent.getX(), mouseEvent.getY(), Integer.parseInt(lineWidth.getText()),
                 colorpickerBorder.getValue(), colorpickerFill.getValue());
         shapes.add(shape);
         label.setText(shape.descriptor());

     }
    }
}
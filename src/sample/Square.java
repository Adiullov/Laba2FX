package sample;

import javafx.scene.Node;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Translate;

import java.util.ArrayList;

public class Square {
    private Color color;
    //private int idCount;

    public Square() { }
    public Color getColor(){ return color; }
    public Square(Color color) {
        this.color = color;
        //this.idCount = idCount;
    }

//    public Node createSquare(){
//        Rectangle square = new Rectangle(100, 100, 100, 100);
//        square.setFill(color);
//
//        square.setId("square" + idCount);
//
//        Controller id = new Controller(square.getId());
//
//        id.addNewItem(idCount - 1);
//
//        System.out.println("Create " + color + " square: " + square.getId());
//        System.out.println("Arr--> " + id.data);
//        return square;
//    }
    public void createSquare(int idCount, VBox boxing, Color colorPicker){
        Rectangle square = new Rectangle(100, 100, 100, 100);
        square.setFill(colorPicker);
        square.setId("square" + idCount);
        Controller id = new Controller(square.getId());
        id.addNewItem(idCount - 1);

        boxing.getChildren().add(square);

        System.out.println("Create " + color + " square: " + square.getId());
        System.out.println("Arr--> " + id.data);
    }

    public void removeSquare(VBox boxing, String choiceBox_id, ArrayList data){
        Rectangle rectangle = (Rectangle)boxing.lookup("#"+choiceBox_id);
        data.remove(choiceBox_id);
        boxing.getChildren().remove(rectangle);
    }

    public void moveSquare(VBox boxing, String choiceBox_id){
        Rectangle rectangle = (Rectangle)boxing.lookup("#"+choiceBox_id);

        // Creating the translation transformation
        Translate translate = new Translate();

        // Set arguments for translation
        translate.setX(20);

        // Adding transformation to rectangle
        rectangle.getTransforms().addAll(translate);

    }

    public void resizeSquare(VBox boxing, String choiceBox_id, Color colorPicker, double setX, double setY){
        Rectangle rectangle = (Rectangle)boxing.lookup("#"+choiceBox_id);

        rectangle.setHeight(setY);
        rectangle.setWidth(setX);
        rectangle.setFill(colorPicker);
    }

//    public Node createSquare(){
//        Rectangle square = new Rectangle(100, 100, 100, 100);
//        square.setFill(color);
//
//        square.setId("square" + idCount);
//
//        Controller id = new Controller(square.getId());
//
//        id.addNewItem(idCount - 1);
//
//        System.out.println("Create " + color + " square: " + square.getId());
//        System.out.println("Arr--> " + id.data);
//        return square;
//    }

}

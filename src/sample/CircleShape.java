package sample;

import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.transform.Translate;

import java.util.ArrayList;

public class CircleShape {
    private Color color;
    //private int idCount;

    public CircleShape() { }
    public Color getColor(){ return color; }
    public CircleShape(Color color) {
        this.color = color;
        //this.idCount = idCount;
    }


    public void createCircle(int idCount, VBox boxing, Color colorPicker){
        Circle circle = new Circle(100, 100, 50);
        circle.setFill(colorPicker);
        circle.setId("circle" + idCount);
        Controller id = new Controller(circle.getId());
        id.addNewItem(idCount - 1);

        boxing.getChildren().add(circle);

        System.out.println("Create " + color + " circle: " + circle.getId());
        System.out.println("Arr--> " + id.data);
    }

    public void removeCircle(VBox boxing, String choiceBox_id, ArrayList data){
        Circle circle = (Circle)boxing.lookup("#"+choiceBox_id);
        data.remove(choiceBox_id);
        boxing.getChildren().remove(circle);
    }

    public void moveCircle(VBox boxing, String choiceBox_id){
        Circle circle = (Circle)boxing.lookup("#"+choiceBox_id);

        Translate translate = new Translate();

        translate.setX(20);

        circle.getTransforms().addAll(translate);

    }

    public void resizeCircle(VBox boxing, String choiceBox_id, Color colorPicker, double setX){
        Circle circle = (Circle)boxing.lookup("#"+choiceBox_id);

        circle.setRadius(setX);
        circle.setFill(colorPicker);
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

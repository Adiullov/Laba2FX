package sample;

import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.transform.Translate;

import java.util.ArrayList;

public class LineShape {
    private Color color;
    //private int idCount;

    public LineShape() { }
    public Color getColor(){ return color; }
    public LineShape(Color color) {
        this.color = color;
        //this.idCount = idCount;
    }


    public void createLine(int idCount, VBox boxing, Color colorPicker){
        Line line = new Line(100, 100, 200, 200);
        line.setStroke(colorPicker);
        line.setStrokeWidth(5);
        line.setId("line" + idCount);
        Controller id = new Controller(line.getId());
        id.addNewItem(idCount - 1);

        boxing.getChildren().add(line);

        System.out.println("Create " + color + " line: " + line.getId());
        System.out.println("Arr--> " + id.data);
    }

    public void removeLine(VBox boxing, String choiceBox_id, ArrayList data){
        Line line = (Line)boxing.lookup("#"+choiceBox_id);
        data.remove(choiceBox_id);
        boxing.getChildren().remove(line);
    }

    public void moveLine(VBox boxing, String choiceBox_id){
        Line line = (Line)boxing.lookup("#"+choiceBox_id);

        Translate translate = new Translate();

        translate.setX(20);

        line.getTransforms().addAll(translate);

    }

    public void resizeLine(VBox boxing, String choiceBox_id, Color colorPicker, double setX, double setY,double setR){
        Line line = (Line)boxing.lookup("#"+choiceBox_id);

        line.setStartX(setX);
        line.setStartY(setX);
        line.setEndX(setY);
        line.setEndY(setY);
        line.setStrokeWidth(setR);
        line.setStroke(colorPicker);
    }


}

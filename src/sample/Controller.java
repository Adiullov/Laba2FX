package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Slider;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    private int idCount;

    public static List<String> data = new ArrayList<String>();

    private String newItem;

    public Controller(){}
    public Controller(String newItem){
        this.newItem = newItem;
    }
    public void addNewItem(int i){
        data.add(newItem);
    }

    @FXML
    public AnchorPane board;
    @FXML
    public VBox boxing;
    @FXML
    private Button move_button;

    @FXML
    private Button remove_button;

    @FXML
    private Button resize_button;

    @FXML
    private Button clear_button;

    @FXML
    private Button create_button;

    @FXML
    void initialize(){
        // True
        create_button.setOnAction(event -> {
            System.out.println("Create Window");

            VBox secondaryLayout = new VBox();

            secondaryLayout.setSpacing(50);
            secondaryLayout.setPadding(new Insets(15,50, 10,75));
            Scene secondScene = new Scene(secondaryLayout, 250, 200);

            ColorPicker colorPicker = new ColorPicker();
            colorPicker.setValue(Color.RED);

            ObservableList<String> shapes
                    = FXCollections.observableArrayList("Квадрат", "Круг", "Линия");

            ChoiceBox<String> choiceBox = new ChoiceBox<String>(shapes);
            choiceBox.setValue("Квадрат");

            Button create_shape = new Button("Создать фигуру");

            secondaryLayout.getChildren().addAll(choiceBox,colorPicker, create_shape);

            //Создание фигуры

            Stage newWindow = new Stage();
            newWindow.setTitle("Создать фигуру");
            newWindow.setScene(secondScene);

            newWindow.show();

            create_shape.setOnAction(event1 -> {
                if(choiceBox.getValue().equals("Квадрат")){
                    idCount++;
                    Square square = new Square();
                    square.createSquare(idCount, boxing, colorPicker.getValue());
                } else if (choiceBox.getValue().equals("Круг")){
                    idCount++;
                    CircleShape circle = new CircleShape();
                    circle.createCircle(idCount, boxing, colorPicker.getValue());
                }
                else if (choiceBox.getValue().equals("Линия")){
                    LineShape lineShape = new LineShape();
                    lineShape.createLine(idCount, boxing, colorPicker.getValue());
                }
                newWindow.close();
            });

        });
        // True
        remove_button.setOnAction(event -> {
            System.out.println("Create Window");

            VBox secondaryLayout = new VBox();

            secondaryLayout.setSpacing(100);
            secondaryLayout.setPadding(new Insets(15,0, 10,75));
            Scene secondScene = new Scene(secondaryLayout, 300, 200);

            ChoiceBox<String> choiceBox_id = new ChoiceBox<String>();
            choiceBox_id.getItems().addAll(data);
            choiceBox_id.getSelectionModel().selectFirst();

            Button remove_shape = new Button("Удалить фигуру");

            secondaryLayout.getChildren().addAll(choiceBox_id, remove_shape);

            Stage newWindow = new Stage();
            newWindow.setTitle("Удалить фигуру");
            newWindow.setScene(secondScene);

            newWindow.show();

            //Создани фигуры
            remove_shape.setOnAction(event1 -> {
                if(choiceBox_id.getValue().charAt(0) == 's') {
                    Square square = new Square();
                    square.removeSquare(boxing, choiceBox_id.getValue(), (ArrayList) data);
                } else if(choiceBox_id.getValue().charAt(0) == 'c') {
                    CircleShape circle = new CircleShape();
                    circle.removeCircle(boxing, choiceBox_id.getValue(), (ArrayList) data);
                } else if(choiceBox_id.getValue().charAt(0) == 'l') {
                    LineShape lineShape = new LineShape();
                    lineShape.removeLine(boxing, choiceBox_id.getValue(), (ArrayList) data);
                }
                newWindow.close();

            });


        });
        // True
        move_button.setOnAction(event -> {
            System.out.println("Create Window");

            VBox secondaryLayout = new VBox();

            secondaryLayout.setSpacing(100);
            secondaryLayout.setPadding(new Insets(15,0, 10,75));
            Scene secondScene = new Scene(secondaryLayout, 300, 200);

            ChoiceBox<String> choiceBox_id = new ChoiceBox<String>();
            choiceBox_id.getItems().addAll(data);
            choiceBox_id.getSelectionModel().selectFirst();

            Button move_shape = new Button("Переместить фигуру");

            secondaryLayout.getChildren().addAll(choiceBox_id, move_shape);

            Stage newWindow = new Stage();
            newWindow.setTitle("Переместить фигуру");
            newWindow.setScene(secondScene);

            newWindow.show();
            //Создание фигуры
            move_shape.setOnAction(event1 -> {
                if(choiceBox_id.getValue().charAt(0) == 's') {
                    Square square = new Square();
                    square.moveSquare(boxing, choiceBox_id.getValue());
                } else if(choiceBox_id.getValue().charAt(0) == 'c') {
                    CircleShape circle = new CircleShape();
                    circle.moveCircle(boxing, choiceBox_id.getValue());
                } else if(choiceBox_id.getValue().charAt(0) == 'l') {
                    LineShape lineShape = new LineShape();
                    lineShape.moveLine(boxing, choiceBox_id.getValue());
                }

            });


        });
        // True
        clear_button.setOnAction(event -> {
            System.out.println("ClearAll");
            boxing.getChildren().clear();
            data.clear();
        });
        // True
        resize_button.setOnAction(event -> {
            System.out.println("Create Window");

            VBox secondaryLayout = new VBox();

            secondaryLayout.setSpacing(25);
            secondaryLayout.setPadding(new Insets(15,15, 10,15));
            Scene secondScene = new Scene(secondaryLayout, 400, 350);

            ChoiceBox<String> choiceBox_id = new ChoiceBox<String>();
            choiceBox_id.getItems().addAll(data);
            choiceBox_id.getSelectionModel().selectFirst();

            ColorPicker colorPicker = new ColorPicker();
            colorPicker.setValue(Color.GREENYELLOW);

            Slider sliderX = new Slider();
            sliderX.setMin(20);
            sliderX.setMax(200);
            sliderX.setValue(100);
            sliderX.setShowTickLabels(true);
            sliderX.setShowTickMarks(true);
            sliderX.setBlockIncrement(20);

            Slider sliderY = new Slider();
            sliderY.setMin(20);
            sliderY.setMax(200);
            sliderY.setValue(100);
            sliderY.setShowTickLabels(true);
            sliderY.setShowTickMarks(true);
            sliderY.setBlockIncrement(20);

            Slider sliderR = new Slider();
            sliderR.setMin(2);
            sliderR.setMax(100);
            sliderR.setValue(50);
            sliderR.setShowTickLabels(true);
            sliderR.setShowTickMarks(true);
            sliderR.setBlockIncrement(10);

            Button resize_shape = new Button("Изменить фигуру");

            secondaryLayout.getChildren().addAll(choiceBox_id,sliderX,sliderY,sliderR,colorPicker, resize_shape);

            Stage newWindow = new Stage();
            newWindow.setTitle("Изменить фигуру");
            newWindow.setScene(secondScene);

            newWindow.show();

            //Создание фигуры
            resize_shape.setOnAction(event1 -> {
                if(choiceBox_id.getValue().charAt(0) == 's') {
                    Square square = new Square();
                    square.resizeSquare(boxing, choiceBox_id.getValue(), colorPicker.getValue(), sliderX.getValue(), sliderY.getValue());
                } else if(choiceBox_id.getValue().charAt(0) == 'c') {
                    CircleShape circle = new CircleShape();
                    circle.resizeCircle(boxing, choiceBox_id.getValue(), colorPicker.getValue(), sliderR.getValue());
                }
                else if(choiceBox_id.getValue().charAt(0) == 'l') {
                    LineShape lineShape = new LineShape();
                    lineShape.resizeLine(boxing, choiceBox_id.getValue(), colorPicker.getValue(), sliderX.getValue(), sliderY.getValue(), sliderR.getValue());
                }
            });


        });

    }

}


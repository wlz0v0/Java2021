package edu.buptsse.project3;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

public class HelloApplication extends Application {
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) {
        var car1 = new Car();
        var car2 = new Car();
        var car3 = new Car();
        var car4 = new Car();

        var speed1 = new TextField();
        speed1.setMaxWidth(40);
        speed1.setText("1");

        var speed2 = new TextField();
        speed2.setMaxWidth(40);
        speed2.setText("1");

        var speed3 = new TextField();
        speed3.setMaxWidth(40);
        speed3.setText("1");

        var speed4 = new TextField();
        speed4.setMaxWidth(40);
        speed4.setText("1");

        var hBox = new HBox();
        hBox.getChildren().add(speed1);
        hBox.getChildren().add(speed2);
        hBox.getChildren().add(speed3);
        hBox.getChildren().add(speed4);
        hBox.setSpacing(50);

        var pane = new Pane();
        pane.getChildren().add(hBox);
        pane.getChildren().add(car1);
        pane.getChildren().add(car2);
        pane.getChildren().add(car3);
        pane.getChildren().add(car4);

        var scene = new Scene(pane, 600, 300);
        car1.setLayoutX(scene.getWidth());
        car2.setLayoutX(scene.getWidth());
        car3.setLayoutX(scene.getWidth());
        car4.setLayoutX(scene.getWidth());
        car1.setLayoutY(50);
        car2.setLayoutY(100);
        car3.setLayoutY(150);
        car4.setLayoutY(200);
        var timeLine = new Timeline();
        timeLine.setCycleCount(Timeline.INDEFINITE);
        var keyFrame = new KeyFrame(Duration.seconds(0.01), actionEvent -> {
            moveCar(car1, speed1, scene);
            moveCar(car2, speed2, scene);
            moveCar(car3, speed3, scene);
            moveCar(car4, speed4, scene);
        });
        timeLine.getKeyFrames().add(keyFrame);
        timeLine.play();
        stage.setScene(scene);
        stage.show();
    }

    private void moveCar(Car car, TextField speed, Scene scene) {
        String speedStr = speed.getText();
        if (speedStr.equals("")) {
            speedStr += '1';
        }
        car.setSpeed(Math.log(Double.parseDouble(speedStr)) + 1);
        car.setLayoutX(car.getLayoutX() - 0.04 * 100 / car.getSpeed());
        if (car.getLayoutX() < -70) {
            car.setLayoutX(scene.getWidth());
        }
    }
}
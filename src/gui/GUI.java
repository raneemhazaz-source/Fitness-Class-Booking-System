/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package gui;


import javafx.application.Application;

import javafx.geometry.Insets;

import javafx.geometry.Pos;

import javafx.scene.Scene;

import javafx.scene.control.*;

import javafx.scene.layout.GridPane;

import javafx.scene.text.Font;

import javafx.stage.Stage;

import javafx.scene.layout.Background;

import javafx.scene.layout.BackgroundFill;

import javafx.scene.paint.Color;

import java.util.ArrayList;

public class GUI extends Application {

    ArrayList<Sessions> sessionsList = new ArrayList<>();

    @Override

    public void start(Stage primaryStage) {

        GridPane grid = new GridPane();

        grid.setAlignment(Pos.CENTER);

        grid.setPadding(new Insets(20));

        grid.setVgap(10);

        grid.setHgap(10);

        grid.setBackground(new Background(new BackgroundFill(Color.LAVENDERBLUSH, null, null)));

        Label title = new Label("--- Fitness Class Booking System ---");

        title.setFont(Font.font(20));

        title.setTextFill(Color.PURPLE);

        grid.add(title, 0, 0, 2, 1);

        Label nameLabel = new Label("Session Name:");

        TextField nameField = new TextField();

        nameLabel.setTextFill(Color.PURPLE);

        grid.add(nameLabel, 0, 1);

        grid.add(nameField, 1, 1);

        Label TraineeIdLabel = new Label("TraineeID:");

        TextField TraineeIdField = new TextField();

        TraineeIdLabel.setTextFill(Color.PURPLE);

        grid.add(TraineeIdLabel, 0, 2);

        grid.add(TraineeIdField, 1, 2);

        Label TraineeNameLabel = new Label("Trainee Name:");

        TextField TraineeNameField = new TextField();

        TraineeNameLabel.setTextFill(Color.PURPLE);

        grid.add(TraineeNameLabel, 0, 3);

        grid.add(TraineeNameField, 1, 3);
         Label TraineePhoneLabel = new Label("Trainee Phone:");
         TextField TraineePhoneField = new TextField();
         TraineePhoneLabel.setTextFill(Color.PURPLE);
         grid.add(TraineePhoneLabel, 0, 4);
         grid.add(TraineePhoneField, 1, 4);
         Label TraineeAgeLabel = new Label("Trainee Age:");
         TextField TraineeAgeField = new TextField();
         TraineeAgeLabel.setTextFill(Color.PURPLE);
          grid.add(TraineeAgeLabel, 0, 5);
           grid.add(TraineeAgeField, 1, 5);

        Button addButton = new Button("Add Session");

        Button showButton = new Button("Show All Sessions");

        addButton.setStyle("-fx-background-color: #E6E6FA; -fx-padding: 8px;");

        showButton.setStyle("-fx-background-color: #E6E6FA; -fx-padding: 8px;");

        grid.add(addButton, 0, 6);

        grid.add(showButton, 1, 6);

        TextArea outputArea = new TextArea();

        outputArea.setEditable(false);

        outputArea.setPrefHeight(200);

        grid.add(outputArea, 0, 7, 2, 1);

        addButton.setOnAction(e -> {

            try {

               String sessionName = nameField.getText();
                String id =TraineeIdField.getText(); 
                String name=TraineeNameField.getText();
                 String Phone=TraineePhoneField.getText();
                 int age =Integer.parseInt(TraineeAgeField.getText().trim());
                         


                Sessions session = null;
                String searhName=sessionName.toLowerCase();
                String spec = "yoga";
                if ( searhName.contains("yoga")) {
                    spec = "yoga";
                  session = new Yoga("Vinyasa", "S001", sessionName, 5,  new Date(2026, 5, 10, 9, 0),new Trainer("T001", "Sara Ali", "0501234567", 30, "Yoga")) ;  
                }else if ( searhName.contains("cardio")){
                    spec = "cardio";
                  session = new Cardio("High", "S002",sessionName,  6,new Date(2026, 5, 11, 11, 30),new Trainer("T002", "Khalid Omar", "0559876543", 28, "Cardio") );  
                }else{
                    spec = "strength";
                   session = new Strength("Dumbbells", "S003",sessionName, 9, new Date(2026, 5, 12, 15, 0), new Trainer("T003", "Noor Saleh", "0531112233", 35, "Strength"));  
                }if (session != null) {
                      sessionsList.add(session);

                outputArea.setText("Session added successfully");
                }

                

                nameField.clear();
                TraineeIdField.clear();
                TraineeNameField.clear();
                TraineePhoneField.clear();
                TraineeAgeField.clear();

                

            } catch (Exception ex) {

                outputArea.setText("Error: "+ex.getMessage());

            }

        });

        showButton.setOnAction(e -> {

            String s = "";

            for (Sessions session : sessionsList) {

                s += session + "\n------------------\n";

            }

            outputArea.setText(s);

        });

        Scene scene = new Scene(grid, 400, 550);

        primaryStage.setScene(scene);

        primaryStage.setTitle("Fitness System");

        primaryStage.show();

    }

    public static void main(String[] args) {

        launch(args);

    }

}
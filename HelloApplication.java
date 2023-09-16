package com.example.vendingfx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        AnchorPane root = new AnchorPane();
        AnchorPane root2 = new AnchorPane();
        AnchorPane rootC = new AnchorPane();

        Scene vendS = new Scene(root, 800, 600);
        Scene addS = new Scene(root2, 800, 600);
        Scene makeCustomer = new Scene(rootC, 800, 600);


        Customer c = new Customer("", 0);

        /////////////////////////Make the Customer Scene/////////////////
        Label cNameLbl = new Label("Customer Name: ");
        Label cMoneyLbl = new Label("Customer Cash: ");

        TextField cNameTF = new TextField();
        TextField cCashTF = new TextField();

        Button cBtn = new Button("Create the Customer");
        cBtn.setOnAction(actionEvent -> {
            try{
                String cName = cNameTF.getText();
                double cCash = Double.parseDouble(cCashTF.getText());
                c.setName(cName);
                c.setCash(cCash);

                stage.setScene(vendS);
            }
            catch(Exception e)
            {
                cBtn.setText("You type bad!");
            }
        });
        AnchorPane.setLeftAnchor(cNameLbl, 120.0);
        AnchorPane.setTopAnchor(cNameLbl, 80.0);

        AnchorPane.setLeftAnchor(cMoneyLbl, 120.0);
        AnchorPane.setTopAnchor(cMoneyLbl, 200.0);

        AnchorPane.setLeftAnchor(cNameTF, 250.0);
        AnchorPane.setTopAnchor(cNameTF, 80.0);

        AnchorPane.setLeftAnchor(cCashTF, 250.0);
        AnchorPane.setTopAnchor(cCashTF, 200.0);

        AnchorPane.setLeftAnchor(cBtn, 120.0);
        AnchorPane.setTopAnchor(cBtn, 330.0);

        rootC.getChildren().addAll(cNameLbl, cNameTF, cMoneyLbl, cCashTF, cBtn);

        /////////////////////////END CUSTOMER SCENE////////////////////////

        /////////////////////////START SCENE 1///////////////////////////

        ListView<Drink> drinks = new ListView<>();
        drinks.getItems().add(new Drink("Coke", "20oz", 1.50));
        drinks.getItems().add(new Drink("Coke", "24oz", 1.75));
        drinks.getItems().add(new Drink("Sprite", "20oz", 1.50));
        drinks.getItems().add(new Drink("Sprite", "24oz", 1.75));
        drinks.getItems().add(new Drink("Fanta", "20oz", 1.50));
        drinks.getItems().add(new Drink("Fanta", "24oz", 1.75));

        AnchorPane.setRightAnchor(drinks, 10.0);
        AnchorPane.setTopAnchor(drinks, 10.0);

        Label infoLbl = new Label("Buy a Drink!");

        Button buyBtn = new Button("Buy Drink");
        buyBtn.setOnAction(actionEvent -> {
            infoLbl.setText(c.buyDrink(drinks.getSelectionModel().getSelectedItem()));
        });

        AnchorPane.setRightAnchor(buyBtn, 10.0);
        AnchorPane.setBottomAnchor(buyBtn, 140.0);

        Button addDrink = new Button("Add Drink");
        addDrink.setOnAction(actionEvent -> {
            stage.setScene(addS);
        });

        Button remDrink = new Button("Remove Drink");
        remDrink.setOnAction(actionEvent -> {
            drinks.getItems().remove(drinks.getSelectionModel().getSelectedIndex());
        });

        AnchorPane.setRightAnchor(addDrink, 10.0);
        AnchorPane.setBottomAnchor(addDrink, 10.0);

        AnchorPane.setRightAnchor(remDrink, 140.0);
        AnchorPane.setBottomAnchor(remDrink, 10.0);

        AnchorPane.setLeftAnchor(infoLbl, 10.0);
        AnchorPane.setTopAnchor(infoLbl, 10.0);

        root.getChildren().addAll(drinks, buyBtn, infoLbl, addDrink, remDrink);

        ///////////////////////////END SCENE 1///////////////////////////////

        ///////////////////////////START SCENE 2/////////////////////////////
        Label nameLbl = new Label("Drink name: ");
        Label sizeLbl = new Label("Drink size: ");
        Label priceLbl = new Label("Drink cost: ");

        Label statusLbl = new Label();

        TextField nameTF = new TextField();
        TextField sizeTF = new TextField();
        TextField priceTF = new TextField();

        Button makeDrinkBtn = new Button("Create!");
        makeDrinkBtn.setOnAction(actionEvent -> {
            String name;
            String size;
            double price;

            try{
                name = nameTF.getText();
                size = sizeTF.getText();
                price = Double.parseDouble(priceTF.getText());
                drinks.getItems().add(new Drink(name, size, price));

                stage.setScene(vendS);
            }
            catch (Exception e)
            {
                statusLbl.setText("Check your input");
            }
        });

        AnchorPane.setTopAnchor(nameLbl, 10.0);
        AnchorPane.setLeftAnchor(nameLbl, 10.0);
        AnchorPane.setTopAnchor(sizeLbl, 80.0);
        AnchorPane.setLeftAnchor(sizeLbl, 10.0);
        AnchorPane.setTopAnchor(priceLbl, 150.0);
        AnchorPane.setLeftAnchor(priceLbl, 10.0);

        AnchorPane.setTopAnchor(nameTF, 10.0);
        AnchorPane.setLeftAnchor(nameTF, 130.0);
        AnchorPane.setTopAnchor(sizeTF, 80.0);
        AnchorPane.setLeftAnchor(sizeTF, 130.0);
        AnchorPane.setTopAnchor(priceTF, 150.0);
        AnchorPane.setLeftAnchor(priceTF, 130.0);

        AnchorPane.setBottomAnchor(statusLbl, 10.0);
        AnchorPane.setLeftAnchor(statusLbl, 10.0);

        AnchorPane.setBottomAnchor(makeDrinkBtn, 10.0);
        AnchorPane.setRightAnchor(makeDrinkBtn, 10.0);

        root2.getChildren().addAll(nameLbl, nameTF, sizeLbl, sizeTF, priceLbl, priceTF, statusLbl, makeDrinkBtn);


        ///////////////////////////////////END SECOND SCENE///////////////////

        stage.setTitle("Vending Machine");
        stage.setScene(makeCustomer);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
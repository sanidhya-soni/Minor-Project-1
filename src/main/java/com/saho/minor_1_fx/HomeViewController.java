package com.saho.minor_1_fx;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.util.Objects;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class HomeViewController {

    static String[] arguments = new String[8];
    public DatePicker startDate;
    public DatePicker endDate;
    public TextField days;
    @FXML
    private TextField binHeight;
    @FXML
    private TextField rackCapacity;
    @FXML
    public TextField warehouseRow;
    @FXML
    public TextField warehouseCol;
    @FXML
    public TextField total_stock;

    int warehouse_row;
    int warehouse_col;
    int rack_capacity;
    int bin_height;
    String start_date;
    String end_date;
    int fruit_stock;
    int days_old;
    @FXML
    void OpenInventory(ActionEvent event) throws IOException {
        Parent root;
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Inventory.fxml")));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void OpenStock(ActionEvent event) throws IOException {
        Parent root;
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Stock.fxml")));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void OpenDispatch(ActionEvent event) throws IOException {
        Parent root;
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Dispatch.fxml")));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void OpenHome(ActionEvent event) throws IOException {
        Parent root;
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("HomeView.fxml")));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void inventory_setup(ActionEvent event) throws IOException {
        this.warehouse_row = Integer.parseInt(warehouseRow.getText());
        this.warehouse_col = Integer.parseInt(warehouseCol.getText());
        this.rack_capacity = Integer.parseInt(rackCapacity.getText());
        this.bin_height = Integer.parseInt(binHeight.getText());
        System.out.println(warehouse_row);
        System.out.println(warehouse_col);
        System.out.println(rack_capacity);
        System.out.println(bin_height);

        arguments[0] = Integer.toString(warehouse_row);
        arguments[1] = Integer.toString(warehouse_col);
        arguments[2] = Integer.toString(rack_capacity);
        arguments[3] = Integer.toString(bin_height);
    }

    @FXML
    void FindPath(ActionEvent event) throws Exception {
        this.days_old = Integer.parseInt(this.days.getText());
        arguments[7] = Integer.toString(days_old);
        MasterLink ml = new MasterLink();
        ml.arguments = arguments;
        ml.start();
    }
    @FXML
    void fetch_stock(ActionEvent event) throws IOException {
        fruit_stock = Integer.parseInt(this.total_stock.getText());
        start_date = startDate.getValue().toString();
        end_date = endDate.getValue().toString();
        start_date = start_date.substring(8) + "/" + start_date.substring(5, 7) + "/" + start_date.substring(0, 4);
        end_date = end_date.substring(8) + "/" + end_date.substring(5, 7) + "/" + end_date.substring(0, 4);
        System.out.println(fruit_stock);
        System.out.println(start_date);
        System.out.println(end_date);

        arguments[4] = start_date;
        arguments[5] = end_date;
        arguments[6] = Integer.toString(fruit_stock);
    }

    @FXML
    void initialize() {

    }

}

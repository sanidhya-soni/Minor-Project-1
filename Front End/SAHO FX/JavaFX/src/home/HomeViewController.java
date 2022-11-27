package home;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class HomeViewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    void OpenInventory(ActionEvent event) {
Parent root;
try {
	root = FXMLLoader.load(getClass().getResource("/home/Inventory.fxml"));
	Scene scene =new Scene(root);
	Stage stage = new Stage();
	stage.setScene(scene);
	stage.show();
}
catch(Exception e)
{
	e.printStackTrace();
}
    }
    
    @FXML
    void OpenStock(ActionEvent event) {
    	Parent root;
    	try {
    		root = FXMLLoader.load(getClass().getResource("/home/Stock.fxml"));
    		Scene scene =new Scene(root);
    		Stage stage = new Stage();
    		stage.setScene(scene);
    		stage.show();
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    }
    
    @FXML
    void OpenDispatch(ActionEvent event) {
    	Parent root;
    	try {
    		root = FXMLLoader.load(getClass().getResource("/home/Dispatch.fxml"));
    		Scene scene =new Scene(root);
    		Stage stage = new Stage();
    		stage.setScene(scene);
    		stage.show();
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    }
    
    @FXML
    void OpenHome(ActionEvent event) {
    	Parent root;
    	try {
    		root = FXMLLoader.load(getClass().getResource("/home/HomeView.fxml"));
    		Scene scene =new Scene(root);
    		Stage stage = new Stage();
    		stage.setScene(scene);
    		stage.show();
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    }




    @FXML
    void initialize() {

    }

}

package application;
	
import java.util.ArrayList;
import java.util.HashMap;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
//import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
//import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;


public class Main extends Application {
	public static ArrayList<Category> categories = new ArrayList<Category>();
	public static HashMap<String,ArrayList<Category>> cOptions = new HashMap<String,ArrayList<Category>>();
	
	@Override
	public void start(Stage stage) {
		try {

			Parent root = FXMLLoader.load(getClass().getResource("/Main.fxml"));

			Scene scene = new Scene(root,800,600,Color.web("EAE9F0"));
			scene.getStylesheets().add("/application.css");

			//making an icon and setting it
			Image icon = new Image("TB.png");
			stage.getIcons().add(icon);
			
			//setting App Title
			stage.setTitle("Budget Tracker");

			//setting scene to the created scene
			stage.setScene(scene);
			stage.show();	//Displaying the scene
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
}

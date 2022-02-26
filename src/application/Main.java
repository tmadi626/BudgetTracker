package application;
	
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
	@Override
	public void start(Stage stage) {
		try {
//			Parent hP = FXMLLoader.load(getClass().getResource("/homePage.fxml"));
//			Parent eP = FXMLLoader.load(getClass().getResource("/expensePage.fxml"));
//			Parent iP = FXMLLoader.load(getClass().getResource("/incomePage.fxml"));
			Parent root = FXMLLoader.load(getClass().getResource("/Main.fxml"));
//			Group root = new Group();//Creating Root Node
			//Creating a scene
//		    FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("/Main.fxml"));
//		    Parent root = loader.load();
		    
			Scene scene = new Scene(root,700,600,Color.web("EAE9F0"));
//			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());	
			scene.getStylesheets().add("/application.css");

			//making an icon and setting it
			Image icon = new Image("TB.png");
			stage.getIcons().add(icon);
			
			//setting App Title
			stage.setTitle("Budget Tracker");
//			stage.setWidth(420);
//			stage.setHeight(420);
//			stage.setResizable(false);
			
			//setting scene to the created scene
			stage.setScene(scene);
			stage.show();	//Displaying the scene
			Controller control = new Controller();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}

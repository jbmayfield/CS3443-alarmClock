 /* Main is a Java class containing a main method to run your program when completed.
 * This class creates the first scene by calling Main.fxml
 * 
 * @author Ryan Harrison (uva238)
 * UTSA CS 3443 - Lab 5
 * Spring 2022
 */

package application;

import java.io.*;
import java.net.*;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.*;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {

			// Loads Main.fxml to start the application
			URL url = new File("Alarm.fxml").toURI().toURL();
			AnchorPane root = FXMLLoader.load(url);
			Scene scene = new Scene(root, 800, 800);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}

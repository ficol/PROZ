package calculator.application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

/**
 * Class App starts calculator using JavaFX.
 * 
 * @author Jakub Ficek
 * @version 1.0
 */
public class App extends Application {
	public static void main(String[] args) {
		launch(args);
	}

	/**
	 * <p>
	 * Method loads interface from View.fxml.
	 * </p>
	 * <p>
	 * Method sets application parameters.
	 * </p>
	 */
	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("View.fxml"));
		primaryStage.setScene(new Scene(root));
		primaryStage.setTitle("Calculator");
		primaryStage.centerOnScreen();
		primaryStage.show();
	}
}
